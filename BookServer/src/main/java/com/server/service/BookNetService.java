package com.server.service;

import com.server.entity.BookNet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (BookNet)表服务接口
 *
 * @author makejava
 * @since 2022-06-03 03:28:12
 */
public interface BookNetService {

    /**
     * 通过ID查询单条数据
     *
     * @param bookId 主键
     * @return 实例对象
     */
    BookNet queryById(Integer bookId);

    /**
     * 分页查询
     *
     * @param bookNet     筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<BookNet> queryByPage(BookNet bookNet, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param bookNet 实例对象
     * @return 实例对象
     */
    BookNet insert(BookNet bookNet);

    /**
     * 修改数据
     *
     * @param bookNet 实例对象
     * @return 实例对象
     */
    BookNet update(BookNet bookNet);

    /**
     * 通过主键删除数据
     *
     * @param bookId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer bookId);

    /**
     * 通过name查询单条数据
     * @param name
     * @return
     */
    BookNet queryByName(String name);

    /**
     * 文章网址查询
     * @param ip
     * @return
     */
    BookNet queryByIp(String ip);

    /**
     * 共有多少条记录
     * @return
     */
    Long bookCount(BookNet bookNet);
}
