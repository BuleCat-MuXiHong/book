package com.server.util;


import com.server.entity.BookChapter;
import com.server.entity.BookNet;
import com.server.service.BookChapterService;
import com.server.service.BookNetService;
import com.server.task.BookNetTask;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class ChapterParse extends BaseHtmlParse{
    public static final Logger logger = LoggerFactory.getLogger(ChapterParse.class);
    private static final String HTML_URL = "https://www.xbiquge.la";

    @Autowired
    private BookChapterService bookChapterService;

    @Autowired
    private BookNetService bookNetService;

    /**
     * 分页查询出单个bookNet
     * @param page
     * @return
     */
    public List<BookNet> getBookListPage(int page){
        PageRequest of = PageRequest.of(page, 1);
        Page<BookNet> bookNets = bookNetService.queryByPage(null,of);
        return bookNets.toList();
    }

    /**
     * 添加数据库
     * @param bookChapters
     */
    public void insertChapter(List<BookChapter> bookChapters){
        for (BookChapter bookChapter : bookChapters) {
            //这里进行添加
            BookChapter insert = bookChapterService.insert(bookChapter);
        }
        String bookName = bookNetService.queryById(bookChapters.get(0).getBookId()).getBookName();
        logger.info(bookName+"---章节加载成功----共"+bookChapters.size()+"章");
    }

    /**
     * 根据书对象获取章节list
     * @param bookNet
     * @return
     */
    public List<BookChapter> getBookChapterList(BookNet bookNet){
        ArrayList<BookChapter> bookChapters= new ArrayList<>();
        Document document = getDocument(bookNet.getBookIp());
        Elements dds = document.getElementsByTag("dd");
        int size = dds.size();//多少章

        for (int i = 0; i < size; i++) {
            Element dd = dds.get(i);
            Element element = dd.getElementsByTag("a").get(0);
            String chapterIp = element.attr("href");
            String chapterName = element.text();
            BookChapter bookChapter = new BookChapter(null, bookNet.getBookId(), i + 1, chapterName, LocalDate.now(),HTML_URL+chapterIp);
            bookChapters.add(bookChapter);
        }
        return bookChapters;
    }

    public List<BookChapter> checkChapter(Integer bookNetId){
        //根据id去Chapter表中查询是否有数据
        return bookChapterService.queryAllById(bookNetId);
    }


}
