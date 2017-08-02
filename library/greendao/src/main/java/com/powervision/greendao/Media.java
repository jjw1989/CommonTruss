package com.powervision.greendao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by David on 2017/8/2.
 */
@Entity
public class Media {
    @Id
    private Long id;
    private String fileName;
    @Generated(hash = 1115525062)
    public Media(Long id, String fileName) {
        this.id = id;
        this.fileName = fileName;
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
}
