package com.server.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.io.Serializable;

/**
 * (BookNet)实体类
 *
 * @author makejava
 * @since 2022-06-03 03:28:10
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookNet implements Serializable {
    private static final long serialVersionUID = -68017961608157792L;
    /**
     * bookid
     */
    private Integer bookId;
    /**
     * book_name
     */
    private String bookName;
    /**
     * book网址
     */
    private String bookIp;
    /**
     * 创建时间
     */
    private LocalDate createDate;
    /**
     * 修改时间
     */
    private LocalDate updateDate;
    /**
     * 图书类型
     */
    private String bookType;

}

