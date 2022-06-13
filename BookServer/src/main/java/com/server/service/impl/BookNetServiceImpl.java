package com.server.service.impl;

import com.server.entity.BookNet;
import com.server.dao.BookNetDao;
import com.server.service.BookNetService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (BookNet)表服务实现类
 *
 * @author makejava
 * @since 2022-06-03 03:28:12
 */
@Service("bookNetService")
public class BookNetServiceImpl implements BookNetService {
    @Resource
    private BookNetDao bookNetDao;

    /**
     * 通过ID查询单条数据
     *
     * @param bookId 主键
     * @return 实例对象
     */
    @Override
    public BookNet queryById(Integer bookId) {
        return this.bookNetDao.queryById(bookId);
    }

    /**
     * 分页查询
     *
     * @param bookNet     筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<BookNet> queryByPage(BookNet bookNet, PageRequest pageRequest) {
        if (bookNet == null) {
            bookNet = new BookNet();
        }
        long total = this.bookNetDao.count(bookNet);
        return new PageImpl<>(this.bookNetDao.queryAllByLimit(bookNet, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param bookNet 实例对象
     * @return 实例对象
     */
    @Override
    public BookNet insert(BookNet bookNet) {
        this.bookNetDao.insert(bookNet);
        return bookNet;
    }

    /**
     * 修改数据
     *
     * @param bookNet 实例对象
     * @return 实例对象
     */
    @Override
    public BookNet update(BookNet bookNet) {
        this.bookNetDao.update(bookNet);
        return this.queryById(bookNet.getBookId());
    }

    /**
     * 通过主键删除数据
     *
     * @param bookId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer bookId) {
        return this.bookNetDao.deleteById(bookId) > 0;
    }

    /**
     *
     * @param name
     * @return
     */
    @Override
    public BookNet queryByName(String name) {
        return bookNetDao.queryByName(name);
    }

    /**
     * 文章网址查询
     * @param ip
     * @return
     */
    @Override
    public BookNet queryByIp(String ip) {
        return bookNetDao.queryByIp(ip);
    }

    /**
     * 共有多少条记录
     * @return
     */
    @Override
    public Long bookCount(BookNet bookNet) {
        if (bookNet ==null){
            bookNet = new BookNet();
        }
        return bookNetDao.count(bookNet);
    }
}
