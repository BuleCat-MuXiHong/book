package com.server.controller;

import com.server.entity.BookChapter;
import com.server.service.BookChapterService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (BookChapter)表控制层
 *
 * @author makejava
 * @since 2022-06-05 00:15:36
 */
@RestController
@RequestMapping("bookChapter")
public class BookChapterController {
    /**
     * 服务对象
     */
    @Resource
    private BookChapterService bookChapterService;

    /**
     * 分页查询
     *
     * @param bookChapter 筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<BookChapter>> queryByPage(BookChapter bookChapter, PageRequest pageRequest) {
        return ResponseEntity.ok(this.bookChapterService.queryByPage(bookChapter, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<BookChapter> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.bookChapterService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param bookChapter 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<BookChapter> add(BookChapter bookChapter) {
        return ResponseEntity.ok(this.bookChapterService.insert(bookChapter));
    }

    /**
     * 编辑数据
     *
     * @param bookChapter 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<BookChapter> edit(BookChapter bookChapter) {
        return ResponseEntity.ok(this.bookChapterService.update(bookChapter));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.bookChapterService.deleteById(id));
    }

}

