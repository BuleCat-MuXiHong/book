package com.server.task;

import com.server.entity.BookChapter;
import com.server.entity.BookNet;
import com.server.service.BookChapterService;
import com.server.service.BookNetService;
import com.server.util.ChapterParse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookChapterTask {
    public static final Logger logger = LoggerFactory.getLogger(ChapterParse.class);

    @Autowired
    private BookNetTask bookNetTask;

    @Autowired
    private BookNetService bookNetService;

    @Autowired
    private ChapterParse chapterParse;


    int page = 0;
    public void insertChapter(){
        Long aLong = bookNetService.bookCount(null);
        int bookCount = Integer.parseInt(String.valueOf(aLong));
        for (int i = page; i < bookCount; i++) {
            List<BookNet> bookListPage = chapterParse.getBookListPage(i);
            for (BookNet bookNet : bookListPage) {
                try {
                    //判断数据库中是否有数据
                    if (chapterParse.checkChapter(bookNet.getBookId()).size()==0){
                        List<BookChapter> bookChapterList = chapterParse.getBookChapterList(bookNet);
                        chapterParse.insertChapter(bookChapterList);
                    }else {
                        logger.info(bookNet.getBookName()+"章节已存在-------不添加");
                    }
                }catch (Exception e){
                    e.printStackTrace();
                    insertChapter();
                }

            }
            logger.info("第---"+page+"---本");
            page+=1;
        }
        page = 0;

    }
}
