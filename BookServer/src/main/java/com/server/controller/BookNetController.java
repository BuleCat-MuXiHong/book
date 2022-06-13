package com.server.controller;

import com.server.entity.BookNet;
import com.server.service.BookNetService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (BookNet)表控制层
 *
 * @author makejava
 * @since 2022-06-03 03:28:05
 */
@RestController
@RequestMapping("/booknet")
public class BookNetController {
    /**
     * 服务对象
     */
    @Resource
    private BookNetService bookNetService;

    /**
     * 分页查询
     *
     * @param bookNet     筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<BookNet>> queryByPage(BookNet bookNet, PageRequest pageRequest) {
        return ResponseEntity.ok(this.bookNetService.queryByPage(bookNet, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/{id}")
    public ResponseEntity<BookNet> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.bookNetService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param bookNet 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<BookNet> add(BookNet bookNet) {
        return ResponseEntity.ok(this.bookNetService.insert(bookNet));
    }

    /**
     * 编辑数据
     *
     * @param bookNet 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<BookNet> edit(BookNet bookNet) {
        return ResponseEntity.ok(this.bookNetService.update(bookNet));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.bookNetService.deleteById(id));
    }

    /**
     * 通过name查询单条数据
     *
     * @param name 主键
     * @return 单条数据
     */
    @GetMapping("/name/{name}")
    public ResponseEntity<BookNet> queryByName(@PathVariable("name") String name) {
        return ResponseEntity.ok(this.bookNetService.queryByName(name));
    }
}

