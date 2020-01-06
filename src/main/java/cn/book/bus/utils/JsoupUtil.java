package cn.book.bus.utils;

import cn.book.bus.aop.HttpAspect;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Jsoup 工具类
 */
public class JsoupUtil {

    private static final Logger log = LoggerFactory.getLogger(HttpAspect.class);
    /**
     * @param content
     * @return 删除Html标签
     */
    public static String delHTMLTag(String content) {
        content = content.replaceAll("\\&[a-zA-Z]{1,10};", "").replaceAll("<[^>]*>", "").replaceAll("[(/>)<]", "");

        // 去除字符串中的空格 回车 换行符 制表符 等

        content = content.replaceAll("\\s*|\t|\r|\n", "");

        // 去除空格
        content = content.replaceAll("&nbsp;", "");

        return content;
    }

    /**
     * 字符串转化为UTF-8
     *
     * @param str
     * @return
     */
    public static String toUTF8(String str) {
        String result = str;
        try {
            result = changeCharSet(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;

    }

    /**
     * @param str
     * @param newCharset
     * @return
     * @throws UnsupportedEncodingException
     */
    private static String changeCharSet(String str, String newCharset) throws UnsupportedEncodingException {
        if (str != null) {
            // 用默认字符编码解码字符串。
            byte[] bs = str.getBytes();
            // 用新的字符编码生成字符串
            return new String(bs, newCharset);
        }
        return str;
    }

    /**
     * @param str
     * @return
     */
    public static String sub(String str) {

        if (!str.isEmpty()) {
            return str.substring(str.indexOf("：") + 1);
        }
        return null;
    }

    public static String subContent(String str) {

        if (!str.isEmpty()) {
           // return str.substring(0, str.indexOf("http"));
            return str.substring(0);
        }
        return null;
    }

    /**
     * 获取链接的document对象
     *
     * @param url
     * @return document
     */
    public static Document getDoc(String url) {
        boolean flag = false;
        Document document = null;
        do {
            try {
				/*
				 * document = Jsoup .connect(url) .timeout(5000) .userAgent("Mozilla")//模拟浏览器
				 * .get();
				 */
            	document =Jsoup.connect(url)
                .header("Accept-Encoding", "gzip, deflate")
                .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64; rv:23.0) Gecko/20100101 Firefox/23.0")
                .maxBodySize(0)
                .timeout(600000).get();   
                flag = false;
            } catch (IOException e) {
                // TODO 自动生成的 catch 块
//                e.printStackTrace();
                log.info("链接超时并开始重新连接");
                flag = true;
            }
        } while (flag);
        return document;
    }
    public static boolean isConnection(String url) {
        boolean flag = false;
        int counts = 0;
        if (null == url || url.length() <= 0) {
            return flag;
        }
        while (counts < 10) {
            try {
                HttpURLConnection connection = (HttpURLConnection) new URL(url)
                        .openConnection();
				/*
				 * //设置请求方式 connection.setRequestMethod("POST"); //连接 connection.connect();
				 */
                //connection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
                //connection.setRequestProperty("User-Agent", "Mozilla/31.0 (compatible; MSIE 10.0; Windows NT; DigExt)"); //防止报403错误。
                connection.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:221.0) Gecko/20100101 Firefox/31.0");
                //connection.setRequestProperty("Referer", "http://,,,");
                int state = connection.getResponseCode();
                if (state == 200) {
                    flag = true;
                }
                break;
            } catch (Exception e) {
                counts++;
                continue;
            }
        }
        return flag;
    }
}
