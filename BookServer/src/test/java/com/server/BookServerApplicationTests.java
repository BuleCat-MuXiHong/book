package com.server;

import com.server.entity.BookChapter;
import com.server.entity.BookNet;
import com.server.service.BookChapterService;
import com.server.service.BookNetService;
import com.server.task.BookChapterTask;
import com.server.task.BookNetTask;
import com.server.util.ChapterParse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

@SpringBootTest
class BookServerApplicationTests {

    @Autowired
    private BookNetTask bookNetTask;

    @Autowired
    private BookNetService bookNetService;

    @Autowired
    private ChapterParse chapterParse;

    @Autowired
    private BookChapterTask bookChapterTask;

    @Autowired
    private BookChapterService bookChapterService;

    @Test
    void contextLoads() {

        bookNetTask.addBookNet(1);
    }


    @Test
    void contextLoads1() {
        PageRequest of = PageRequest.of(0, 100);
        Page<BookNet> bookNets = bookNetService.queryByPage(null,of);
        for (BookNet bookNet : bookNets) {
            System.out.println(bookNet);
        }

    }
    @Test
    void contextLoads2() {
        List<BookNet> bookListPage = chapterParse.getBookListPage(0);
        for (BookNet bookNet : bookListPage) {
            List<BookChapter> bookChapterList = chapterParse.getBookChapterList(bookNet);
            chapterParse.insertChapter(bookChapterList);
        }
    }
    @Test
    void contextLoads4() {
        bookChapterTask.insertChapter();
    }

    //测试打开章节
    @Test
    void contextLoads5() {
        List<BookChapter> bookChapters = bookChapterService.queryAllById(7312);
        for (BookChapter bookChapter : bookChapters) {
            System.out.println(bookChapter);
        }
    }






}
