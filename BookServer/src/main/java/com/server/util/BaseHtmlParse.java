package com.server.util;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;

public class BaseHtmlParse {

    private static final String HTML_URL = "https://www.xbiquge.la/";
    /**
     *  根据网址解析网页
     * @return
     */
    public Document getDocument(String url){
        try {
            return  Jsoup.parse(new URL(url), 5000);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Element getElementById(String url,String id){
        Document document = getDocument(url);
        Element elementById = document.getElementById(id);
        return elementById;
    }

    /**
     * 根据classname获取标签
     * @param url
     * @param className
     * @param tagIndex
     * @return
     */
    public Element getElement(String url, String className, int tagIndex){
        Document document = getDocument(url);
        Elements elementsByClass = document.getElementsByClass(className);
        return elementsByClass.get(tagIndex);
    }

    /**
     * 获取
     * @param url
     * @param className
     * @return
     */
    public Elements getElements(String url, String className){
        Document document = getDocument(url);
        return document.getElementsByClass(className);

    }
    /**
     * 获取属性值
     * @param element
     * @param attrKey
     * @return
     */
    public String getStringByAttr(Element element,String attrKey){
        return element.attr(attrKey);
    }

    /**
     * 获取标签值
     * @param element
     * @return
     */
    public String getStringByText(Element element){
        return element.text();
    }
}
