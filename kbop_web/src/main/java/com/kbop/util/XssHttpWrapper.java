package com.kbop.util;

/**
 * Created by TWJ on 2016-10-18.
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * XSS保护
 *
 * @author storezhang
 */
public class XssHttpWrapper extends HttpServletRequestWrapper {

    private HttpServletRequest orgRequest;

    public XssHttpWrapper(HttpServletRequest request) {
        super(request);
        orgRequest = request;
    }

    /**
     * 将容易引起xss漏洞的半角字符直接替换成全角字符
     *
     * @param s
     * @return
     */
    private static String xssEncode(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }

//        StringReader reader = new StringReader(s);
//        StringWriter writer = new StringWriter();
//        try {
//            HTMLParser.process(reader, writer, new XSSFilter(), true);
//            return writer.toString();
//        } catch (NullPointerException e) {
//            return s;
//        } catch (Exception ex) {
//            ex.printStackTrace(System.out);
        //过滤 特殊字符
        s = s.replace("\u0000", "");
        s = s.replace("\u0001", "");
        s = s.replace("\u0002", "");
        s = s.replace("\u0003", "");
        s = s.replace("\u0004", "");
        s = s.replace("\u0005", "");
        s = s.replace("\u0006", "");
        s = s.replace("\u0007", "");
        s = s.replace("\b", "");
        s = s.replace("\t", "");
        s = s.replace("\n", "");
        s = s.replace("\u000b", "");
        s = s.replace("\f", "");
        s = s.replace("\r", "");
        s = s.replace("\u000e", "");
        s = s.replace("\u000f", "");
        s = s.replace("\u0010", "");
        s = s.replace("\u0011", "");
        s = s.replace("\u0012", "");
        s = s.replace("\u0013", "");
        s = s.replace("\u0014", "");
        s = s.replace("\u0015", "");
        s = s.replace("\u0016", "");
        s = s.replace("\u0017", "");
        s = s.replace("\u0018", "");
        s = s.replace("\u0019", "");
        s = s.replace("\u001a", "");
        s = s.replace("\u001b", "");
        s = s.replace("\u001c", "");
        s = s.replace("\u001d", "");
        s = s.replace("\u001e", "");
        s = s.replace("\u001f", "");

        s = s.replace("script", "");
        s = s.replace("embed", "");
        s = s.replace("object", "");
        s = s.replace("layer", "");
        s = s.replace("style", "");
        s = s.replace("meta", "");
        s = s.replace("iframe", "");
        s = s.replace("frame", "");
        s = s.replace("link", "");
        s = s.replace("import", "");
        s = s.replace("xml", "");

        s = s.replace("\"", "");
        s = s.replace("<", "");
        s = s.replace(">", "");
        s = s.replace("onload", "");

        return s;

    }

    /**
     * 获取最原始的request的静态方法
     *
     * @return
     */
    public static HttpServletRequest getOrgRequest(HttpServletRequest req) {
        if (req instanceof XssHttpWrapper) {
            return ((XssHttpWrapper) req).getOrgRequest();
        }
        return req;
    }

    /**
     * 覆盖getParameter方法，将参数名和参数值都做xss过滤。<br/>
     * 如果需要获得原始的值，则通过super.getParameterValues(name)来获取<br/>
     * getParameterNames,getParameterValues和getParameterMap也可能需要覆盖
     */
    @Override
    public String getParameter(String name) {
        String value = super.getParameter(xssEncode(name));
        if (value != null) {
            value = xssEncode(value);
        }
        return value;
    }

    /**
     * 覆盖getHeader方法，将参数名和参数值都做xss过滤。<br/>
     * 如果需要获得原始的值，则通过super.getHeaders(name)来获取<br/> getHeaderNames 也可能需要覆盖
     */
    @Override
    public String getHeader(String name) {
        String value = super.getHeader(xssEncode(name));
        if (value != null) {
            value = xssEncode(value);
        }
        return value;
    }

    /**
     * 获取最原始的request
     *
     * @return
     */
    public HttpServletRequest getOrgRequest() {
        return orgRequest;
    }

}
