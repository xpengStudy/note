package com.xp.note.entity;

import com.baomidou.mybatisplus.annotation.TableField;

import java.util.Date;
//import com.baomidou.mybatisplus.annotations.TableField;
//import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author xp123
 * @since 2021-02-08
 */
public class TNote implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    /*****
     *  父节点id
     */
    private String pId;

    /**
     * 对应日记文件id
     */
    private String fileId;
    /**
     * 日记标题
     */
    private String noteTitle;
    /**
     * 日记标签
     */
    private String noteFlag;
    /**
     * 日记内容
     */
    private String noteContent;
    /**
     * 图片地址
     */
    private String imgPath;
    /**
     * 操作人员id
     */
    private String uid;
    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    @TableField(exist = false)
    private String startTime;

    @TableField(exist = false)
    private String endTime;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getNoteTitle() {
        return noteTitle;
    }

    public void setNoteTitle(String noteTitle) {
        this.noteTitle = noteTitle;
    }

    public String getNoteFlag() {
        return noteFlag;
    }

    public void setNoteFlag(String noteFlag) {
        this.noteFlag = noteFlag;
    }

    public String getNoteContent() {
        return noteContent;
    }

    public void setNoteContent(String noteContent) {
        this.noteContent = noteContent;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "TNote{" +
                "id='" + id + '\'' +
                ", pId='" + pId + '\'' +
                ", fileId='" + fileId + '\'' +
                ", noteTitle='" + noteTitle + '\'' +
                ", noteFlag='" + noteFlag + '\'' +
                ", noteContent='" + noteContent + '\'' +
                ", imgPath='" + imgPath + '\'' +
                ", uid='" + uid + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
