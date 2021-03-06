package com.powervision.greendao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "MEDIA".
*/
public class MediaDao extends AbstractDao<Media, Long> {

    public static final String TABLENAME = "MEDIA";

    /**
     * Properties of entity Media.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property FileName = new Property(1, String.class, "fileName", false, "FILE_NAME");
        public final static Property ImgPath = new Property(2, String.class, "imgPath", false, "IMG_PATH");
        public final static Property VideoPath = new Property(3, String.class, "videoPath", false, "VIDEO_PATH");
        public final static Property VideoThumbail = new Property(4, String.class, "videoThumbail", false, "VIDEO_THUMBAIL");
        public final static Property CreateTime = new Property(5, String.class, "createTime", false, "CREATE_TIME");
        public final static Property ModifyTime = new Property(6, String.class, "modifyTime", false, "MODIFY_TIME");
        public final static Property Type = new Property(7, int.class, "type", false, "TYPE");
    }


    public MediaDao(DaoConfig config) {
        super(config);
    }
    
    public MediaDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"MEDIA\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"FILE_NAME\" TEXT," + // 1: fileName
                "\"IMG_PATH\" TEXT UNIQUE ," + // 2: imgPath
                "\"VIDEO_PATH\" TEXT UNIQUE ," + // 3: videoPath
                "\"VIDEO_THUMBAIL\" TEXT," + // 4: videoThumbail
                "\"CREATE_TIME\" TEXT," + // 5: createTime
                "\"MODIFY_TIME\" TEXT," + // 6: modifyTime
                "\"TYPE\" INTEGER NOT NULL );"); // 7: type
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"MEDIA\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Media entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String fileName = entity.getFileName();
        if (fileName != null) {
            stmt.bindString(2, fileName);
        }
 
        String imgPath = entity.getImgPath();
        if (imgPath != null) {
            stmt.bindString(3, imgPath);
        }
 
        String videoPath = entity.getVideoPath();
        if (videoPath != null) {
            stmt.bindString(4, videoPath);
        }
 
        String videoThumbail = entity.getVideoThumbail();
        if (videoThumbail != null) {
            stmt.bindString(5, videoThumbail);
        }
 
        String createTime = entity.getCreateTime();
        if (createTime != null) {
            stmt.bindString(6, createTime);
        }
 
        String modifyTime = entity.getModifyTime();
        if (modifyTime != null) {
            stmt.bindString(7, modifyTime);
        }
        stmt.bindLong(8, entity.getType());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Media entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String fileName = entity.getFileName();
        if (fileName != null) {
            stmt.bindString(2, fileName);
        }
 
        String imgPath = entity.getImgPath();
        if (imgPath != null) {
            stmt.bindString(3, imgPath);
        }
 
        String videoPath = entity.getVideoPath();
        if (videoPath != null) {
            stmt.bindString(4, videoPath);
        }
 
        String videoThumbail = entity.getVideoThumbail();
        if (videoThumbail != null) {
            stmt.bindString(5, videoThumbail);
        }
 
        String createTime = entity.getCreateTime();
        if (createTime != null) {
            stmt.bindString(6, createTime);
        }
 
        String modifyTime = entity.getModifyTime();
        if (modifyTime != null) {
            stmt.bindString(7, modifyTime);
        }
        stmt.bindLong(8, entity.getType());
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public Media readEntity(Cursor cursor, int offset) {
        Media entity = new Media( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // fileName
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // imgPath
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // videoPath
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // videoThumbail
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // createTime
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // modifyTime
            cursor.getInt(offset + 7) // type
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Media entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setFileName(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setImgPath(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setVideoPath(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setVideoThumbail(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setCreateTime(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setModifyTime(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setType(cursor.getInt(offset + 7));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(Media entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(Media entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(Media entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
