package com.kbop.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

/**
 * Created by TWJ on 2016-6-19.
 */
@Component
@PropertySource("classpath:email.properties")
public class EMail {
    private static final Logger logger = LogManager.getLogger(EMail.class);
    //    @Value("${email.sender}")
//    private String SENDER;
//    @Value("${email.passowrd}")
//    private String PASSOWRD;
//    @Value("${email.emailhost}")
//    private String EMAILHOST;
    private final static String SENDER = "booknux@163.com";
    private final static String PASSOWRD = "EB9xrVYJNQR92K71";
    private final static String EMAILHOST = "smtp.163.com";

    String recver;
    Session session;
    MimeMessage message;


    public EMail() {
        // 获取系统属性
        Properties properties = new Properties();

        // 设置qq邮件服务器
        properties.setProperty("mail.smtp.host", EMAILHOST);

        //发送邮箱认证
        properties.put("mail.smtp.auth", "true");

        // 获取默认session对象
        session = Session.getDefaultInstance(properties, new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(SENDER, PASSOWRD); //发件人邮件用户名、密码
            }
        });
    }

    /**
     * 发送一封纯文本email
     *
     * @param subject 标题
     * @param text    内容
     * @return true 成功 false 失败
     */
    public boolean sendMail(String recver, String subject, String text) {
        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);


            // Set From: header field of the header.
            message.setFrom(new InternetAddress(SENDER));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(recver));

            // Set Subject: header field
            message.setSubject(subject);

            // Now set the actual message
            message.setText(text);

            // Send message
            Transport.send(message);

            logger.info("sent message successfully\n" +
                    "subject:" + subject + "\n" +
                    "text:\n" + text);

            return true;
        } catch (MessagingException mex) {
            mex.printStackTrace();
            logger.error("sent message :  " + recver + " failed");
            return false;
        }
    }

    /**
     * 发送一封纯文本email
     *
     * @param subject 标题
     * @param text    内容
     * @return true 成功 false 失败
     */
    public boolean sendMail(String subject, String text) {
        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);


            // Set From: header field of the header.
            message.setFrom(new InternetAddress(SENDER));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(recver));

            // Set Subject: header field
            message.setSubject(subject);

            // Now set the actual message
            message.setText(text);

            // Send message
            Transport.send(message);

            logger.info("sent message successfully\n" +
                    "subject:" + subject + "\n" +
                    "text:\n" + text);

            return true;
        } catch (MessagingException mex) {
            mex.printStackTrace();
            logger.error("sent message :  " + recver + " failed");
            return false;
        }
    }

    /**
     * 发送一封纯文本email 有 附件
     *
     * @param subject 标题
     * @param text    内容
     * @param uri     附件资源
     * @return true 成功 false 失败
     */
    public boolean sendMailWithFile(String recver, String subject, String text, String uri) {
        try {
            // 创建默认的 MimeMessage 对象
            message = new MimeMessage(session);

            // Set From: 头部头字段
            message.setFrom(new InternetAddress(SENDER));

            // Set To: 头部头字段
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recver));

            // Set Subject: 头部头字段
            message.setSubject(subject);

            // 设置消息体
            //message.setText(text);

            //带附件的
            // 创建消息部分
            BodyPart messageBodyPart = new MimeBodyPart();

            // 消息
            messageBodyPart.setText(text);

            // 创建多重消息
            Multipart multipart = new MimeMultipart();

            // 设置文本消息部分
            multipart.addBodyPart(messageBodyPart);

            // 附件部分
            messageBodyPart = new MimeBodyPart();
            //文件路径

            DataSource source = new FileDataSource(uri);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(text);
            multipart.addBodyPart(messageBodyPart);

            // 发送完整消息
            message.setContent(multipart);

            // 发送消息
            Transport.send(message);

            logger.info("sent message successfully\n" +
                    "subject:" + subject + "\n" +
                    "text:\n" + text + "\n" +
                    "URI:" + uri);

            return true;
        } catch (MessagingException mex) {
            mex.printStackTrace();
            logger.error("sent message uri :  " + recver + " failed");
            return false;
        }
    }

    public void setRecver(String recver) {
        this.recver = recver;
    }
}