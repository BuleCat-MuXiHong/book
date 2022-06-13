package com.server.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.io.Serializable;

/**
 * (BookChapter)实体类
 *
 * @author makejava
 * @since 2022-06-05 00:15:38
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookChapter implements Serializable {
    private static final long serialVersionUID = 342921397968848016L;

    private Integer id;
    /**
     * 图书id
     */
    private Integer bookId;
    /**
     * 章节id
     */
    private Integer chapterId;
    /**
     * 章节名称
     */
    private String chapterName;

    private LocalDate createDate;
    /**
     * 章节地址
     */
    private String chapterIp;
}

