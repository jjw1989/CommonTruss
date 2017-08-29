package com.powervision.greendao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Unique;

/**
 * Created by David on 2017/8/2.
 */
@Entity
public class Media {
    @Id
    private Long id;
    private String fileName;
    @Unique
    private String imgPath;
    @Unique
    private String videoPath;
    private String videoThumbail;
    private String createTime;
    private String modifyTime;
    private int type;
    @Generated(hash = 1208319279)
    public Media(Long id, String fileName, String imgPath, String videoPath,
                 String videoThumbail, String createTime, String modifyTime, int type) {
        this.id = id;
        this.fileName = fileName;
        this.imgPath = imgPath;
        this.videoPath = videoPath;
        this.videoThumbail = videoThumbail;
        this.createTime = createTime;
        this.modifyTime = modifyTime;
        this.type = type;
    }
    @Generated(hash = 551662551)
    public Media() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getFileName() {
        return this.fileName;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    public String getImgPath() {
        return this.imgPath;
    }
    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }
    public String getVideoPath() {
        return this.videoPath;
    }
    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath;
    }
    public String getVideoThumbail() {
        return this.videoThumbail;
    }
    public void setVideoThumbail(String videoThumbail) {
        this.videoThumbail = videoThumbail;
    }
    public String getCreateTime() {
        return this.createTime;
    }
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
    public String getModifyTime() {
        return this.modifyTime;
    }
    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }
    public int getType() {
        return this.type;
    }
    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Media{" +
                "id=" + id +
                ", fileName='" + fileName + '\'' +
                ", imgPath='" + imgPath + '\'' +
                ", videoPath='" + videoPath + '\'' +
                ", videoThumbail='" + videoThumbail + '\'' +
                ", createTime='" + createTime + '\'' +
                ", modifyTime='" + modifyTime + '\'' +
                ", type=" + type +
                '}';
    }
}
