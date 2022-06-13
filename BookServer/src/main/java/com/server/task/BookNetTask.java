package com.server.task;


import com.server.entity.BookNet;
import com.server.service.BookNetService;
import com.server.util.HtmlParse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookNetTask {
    public static  String URL_PATH_number1 = "https://www.xbiquge.la/fenlei/1_1.html";
    public static  String URL_PATH_number2 = "https://www.xbiquge.la/fenlei/2_1.html";
    public static  String URL_PATH_number3 = "https://www.xbiquge.la/fenlei/3_1.html";
    public static  String URL_PATH_number4 = "https://www.xbiquge.la/fenlei/4_1.html";
    public static  String URL_PATH_number5 = "https://www.xbiquge.la/fenlei/5_1.html";
    public static  String URL_PATH_number6 = "https://www.xbiquge.la/fenlei/6_1.html";
    public static  String URL_PATH_number7 = "https://www.xbiquge.la/fenlei/7_1.html";

    @Autowired
    private BookNetService bookNetService;

    @Autowired
    private HtmlParse htmlParse;

    int page = 1;
    public void addBookNet(int page){
        Logger logger = LoggerFactory.getLogger(BookNetTask.class);
        ArrayList<String> urls = new ArrayList();
//        urls.add(URL_PATH_number1);
//        urls.add(URL_PATH_number2);
//        urls.add(URL_PATH_number3);
//        urls.add(URL_PATH_number4);
//        urls.add(URL_PATH_number5);
//        urls.add(URL_PATH_number6);
        urls.add(URL_PATH_number7);
        for (String url : urls) {
            try {
                Integer bookNetPageNumber = htmlParse.getBookNetPageNumber(url);
                logger.info("共有"+bookNetPageNumber+"页");

                for (Integer i = page; i < bookNetPageNumber; i++) {
                    String urlTemp =  url.split("_")[0]+"_"+i+".html";
                    List<BookNet> bookNet = htmlParse.getBookNet(urlTemp);
                    for (BookNet net : bookNet) {
                        if (bookNetService.queryByIp(net.getBookIp())==null){
                            BookNet insert = bookNetService.insert(net);
                            logger.info(insert+"------添加成功");
                        }else {
                            if (bookNetService.queryByIp(net.getBookIp()).getBookName().equals(net.getBookName())){
                                logger.info("数据库中存在-----"+net.getBookName()+"------"+net.getBookType()+"-----不添加");
                            }else {
                                BookNet insert = bookNetService.insert(net);
                                logger.info(insert+"------添加成功------二次比较");
                            }

                        }
                    }
                    logger.info("第"+i+"页添加完成");
                    page+=1;
                }
            }catch (Exception e){
                e.printStackTrace();
                addBookNet(page);
                logger.info("从第"+page+"页开始------------------------------------");
            }
//            urls.remove(0);
            page=0;
        }

    }

}
