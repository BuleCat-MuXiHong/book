package com.server.dao;

import com.server.entity.BookChapter;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (BookChapter)表数据库访问层
 *
 * @author makejava
 * @since 2022-06-05 00:15:37
 */
public interface BookChapterDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    BookChapter queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param bookChapter 查询条件
     * @param pageable    分页对象
     * @return 对象列表
     */
    List<BookChapter> queryAllByLimit(BookChapter bookChapter, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param bookChapter 查询条件
     * @return 总行数
     */
    long count(BookChapter bookChapter);

    /**
     * 新增数据
     *
     * @param bookChapter 实例对象
     * @return 影响行数
     */
    int insert(BookChapter bookChapter);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<BookChapter> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<BookChapter> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<BookChapter> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<BookChapter> entities);

    /**
     * 修改数据
     *
     * @param bookChapter 实例对象
     * @return 影响行数
     */
    int update(BookChapter bookChapter);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    /**
     * 根据书的id获取所有的章节列表
     * @param bookId
     * @return
     */
    List<BookChapter> queryAllById(@Param("bookId") Integer bookId);
}

