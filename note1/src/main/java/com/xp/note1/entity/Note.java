package com.xp.note1.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/********
 *  日记对象
 *
 */
public class Note extends BaseEntity {

    // 对应文件夹的id
    private String fileId;

    // 日记标题
    private String noteTitle;

    //日记标签
    private String noteFlag;

    // 日记内容（可能需要大字段）
    private String noteContent;

    // 图片地址
    private String imgPath;

    // 记录人
    private String uid;

    //记录生成时间
    private LocalDateTime createTime;

    // 记录更新时间
    private LocalDateTime updateTime;


}
