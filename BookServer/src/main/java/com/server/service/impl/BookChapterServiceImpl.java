package com.server.service.impl;

import com.server.entity.BookChapter;
import com.server.dao.BookChapterDao;
import com.server.service.BookChapterService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * (BookChapter)表服务实现类
 *
 * @author makejava
 * @since 2022-06-05 00:15:39
 */
@Service("bookChapterService")
public class BookChapterServiceImpl implements BookChapterService {
    @Resource
    private BookChapterDao bookChapterDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public BookChapter queryById(Integer id) {
        return this.bookChapterDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param bookChapter 筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<BookChapter> queryByPage(BookChapter bookChapter, PageRequest pageRequest) {
        long total = this.bookChapterDao.count(bookChapter);
        return new PageImpl<>(this.bookChapterDao.queryAllByLimit(bookChapter, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param bookChapter 实例对象
     * @return 实例对象
     */
    @Override
    public BookChapter insert(BookChapter bookChapter) {
        this.bookChapterDao.insert(bookChapter);
        return bookChapter;
    }

    /**
     * 修改数据
     *
     * @param bookChapter 实例对象
     * @return 实例对象
     */
    @Override
    public BookChapter update(BookChapter bookChapter) {
        this.bookChapterDao.update(bookChapter);
        return this.queryById(bookChapter.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.bookChapterDao.deleteById(id) > 0;
    }

    /**
     * 根据书的id获取所有的章节列表
     * @param bookId
     * @return
     */
    @Override
    public List<BookChapter> queryAllById(Integer bookId) {
        return bookChapterDao.queryAllById(bookId);
    }


}
