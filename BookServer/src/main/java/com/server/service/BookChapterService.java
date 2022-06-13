package com.server.service;

import com.server.entity.BookChapter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (BookChapter)表服务接口
 *
 * @author makejava
 * @since 2022-06-05 00:15:38
 */
public interface BookChapterService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    BookChapter queryById(Integer id);

    /**
     * 分页查询
     *
     * @param bookChapter 筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<BookChapter> queryByPage(BookChapter bookChapter, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param bookChapter 实例对象
     * @return 实例对象
     */
    BookChapter insert(BookChapter bookChapter);

    /**
     * 修改数据
     *
     * @param bookChapter 实例对象
     * @return 实例对象
     */
    BookChapter update(BookChapter bookChapter);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    /**
     * 根据书的id获取所有的章节列表
     * @param bookId
     * @return
     */
    List<BookChapter> queryAllById(Integer bookId);

}
