package com.kbop.controller;

import com.kbop.bean.JsonMsg;
import com.kbop.bean.po.Book;
import com.kbop.common.KBOPConsts;
import com.kbop.mapper.BookMapper;
import com.kbop.util.JsonMsgFactory;
import com.kbop.util.UUIDUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * Created by WallaceTang on 2017/5/19.
 */
@Controller
public class UpDownloadController {
    private static final Logger logger = LogManager.getLogger(UpDownloadController.class);
    @Autowired
    BookMapper bookMapper;


    @RequestMapping("/download")
    public void downloadBook(@RequestParam(value = "bookId") int bookId, HttpServletResponse response, HttpServletRequest request) {
        //TODO-WallaceTang 5-19-2017 spring 下载文件
        //服务器流量统计

        int id = Integer.valueOf(bookId);
        Book book = bookMapper.selectByPrimaryKey(id);

        if (book != null) {
            logger.info("download book id: " + id);

            String fileName = book.getUrl();
            String filePathName = KBOPConsts.BOOK_DIR_PATH + fileName;
            File file = new File(filePathName);

            if (file.exists()) {
                //历史统计
                //统计每本书下载量

                // 下载书籍
                // twr
                try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
                     ServletOutputStream sos = response.getOutputStream()
                ) {

                    response.setHeader(HttpHeaders.CONTENT_DISPOSITION,
                            "attachment;filename=\"" + URLEncoder.encode(book.getBookName(), StandardCharsets.UTF_8.name()) + "." + book.getExt() + "\"");

                    int len = 0;
                    //每次读取2KB数据
                    byte[] buf = new byte[2048];

                    while ((len = bis.read(buf)) != -1) {
                        sos.write(buf, 0, len);
                    }
                    sos.flush();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public @ResponseBody
    JsonMsg upload(@RequestParam("name") String name,
                   @RequestParam("file") MultipartFile upfile) throws IOException {

        logger.info("upload file name: " + name);
        if (!upfile.isEmpty()) {
            logger.info("upload file size: " + upfile.getSize());
            //保存文件名
            String filePathName = KBOPConsts.BOOK_DIR_PATH + UUIDUtil.randomUUID();
            File savefile = new File(filePathName);

            // 保存书籍
            // twr
            try (BufferedInputStream bis = new BufferedInputStream(upfile.getInputStream());
                 BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(savefile))
            ) {
                int len = 0;
                //每次读取2KB数据
                byte[] buf = new byte[2048];

                while ((len = bis.read(buf)) != -1) {
                    bos.write(buf, 0, len);
                }
                bos.flush();
                return JsonMsgFactory.OK_MSG();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        logger.error("upload file save failed");

        return JsonMsgFactory.FAIL_MSG();
    }
}
