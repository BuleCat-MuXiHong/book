package com.server.util;

import com.server.entity.BookNet;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;
import sun.java2d.pipe.AAShapePipe;

import java.awt.print.Book;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class HtmlParse extends BaseHtmlParse{

    /**
     * 获取共有多少页
     * @param url
     * @return
     */
    public Integer getBookNetPageNumber(String url){
        Element last = getElement(url, "last", 0);
        String pages = getStringByText(last);
        return Integer.parseInt(pages);
    }

    /**
     * 获取图书名和网址
     * @param url
     * @return
     */
    public List<BookNet> getBookNet(String url){
        ArrayList<BookNet> bookNets = new ArrayList<>();
        Element element = getElement(url, "l", 0);
        String h2 = getStringByText(element.getElementsByTag("h2").get(0));
        String bookType = h2.replace("好看的", "").replace("小说最近更新列表", "");

        Elements bookInfo = element.getElementsByClass("s2");
        for (Element  elementBookInfo : bookInfo) {
            String href = elementBookInfo.getElementsByTag("a").eq(0).attr("href");
            String bookName = elementBookInfo.getElementsByTag("a").eq(0).text();
            bookNets.add(new BookNet(null,bookName,href,LocalDate.now(),LocalDate.now(),bookType));
        }
        return bookNets;

    }

    public static void main(String[] args) {
        HtmlParse htmlParse = new HtmlParse();
        String DefaultUrl = "https://www.xbiquge.la/fenlei/4_1.html";
        System.out.println(DefaultUrl.split("_")[0]+"_"+123+".html");
//        Integer bookNetPageNumber = htmlParse.getBookNetPageNumber(DefaultUrl);
//        System.out.println(bookNetPageNumber);
//        List<BookNet> bookNet = htmlParse.getBookNet(DefaultUrl);
//        for (BookNet net : bookNet) {
//            System.out.println(net);
//        }
    }

}
