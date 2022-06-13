package com.server.dao;

import com.server.entity.BookNet;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (BookNet)表数据库访问层
 *
 * @author makejava
 * @since 2022-06-03 03:28:09
 */
public interface BookNetDao {

    /**
     * 通过ID查询单条数据
     *
     * @param bookId 主键
     * @return 实例对象
     */
    BookNet queryById(Integer bookId);

    /**
     * 查询指定行数据
     *
     * @param bookNet  查询条件
     * @param pageable 分页对象
     * @return 对象列表
     */
    List<BookNet> queryAllByLimit(@Param("bookNet") BookNet bookNet, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param bookNet 查询条件
     * @return 总行数
     */
    long count(BookNet bookNet);

    /**
     * 新增数据
     *
     * @param bookNet 实例对象
     * @return 影响行数
     */
    int insert(BookNet bookNet);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<BookNet> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<BookNet> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<BookNet> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<BookNet> entities);

    /**
     * 修改数据
     *
     * @param bookNet 实例对象
     * @return 影响行数
     */
    int update(BookNet bookNet);

    /**
     * 通过主键删除数据
     *
     * @param bookId 主键
     * @return 影响行数
     */
    int deleteById(Integer bookId);

    /**
     * 通过name查询单条数据
     * @return
     */
    BookNet queryByName(@Param("name") String name);

    /**
     * 文章网址查询
     * @param ip
     * @return
     */
    BookNet queryByIp(@Param("ip") String ip);
}

