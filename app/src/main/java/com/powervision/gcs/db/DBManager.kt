package com.powervision.gcs.manage

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.powervision.greendao.DaoMaster
import com.powervision.greendao.DaoSession
import com.powervision.greendao.Media
import com.powervision.greendao.MediaDao

/**
 * 本地数据管理
 * Created by Sundy on 2017/7/17.
 */
class DBManager( context: Context) {
    private val openHelper: DaoMaster.DevOpenHelper

    init {
        openHelper = DaoMaster.DevOpenHelper(context, dbName, null)
    }

    /**
     * 获取可读数据库
     */
    fun getReadableDatabase(): SQLiteDatabase {
        return openHelper.readableDatabase
    }

    /**
     *  获取可写数据库
     */
    fun getWritableDatabase(): SQLiteDatabase {
        return openHelper.writableDatabase
    }

    fun getSession(isWrite: Boolean): DaoSession {
        var daoMaster: DaoMaster
        if (isWrite) {
            daoMaster = DaoMaster(getWritableDatabase())
        } else {
            daoMaster = DaoMaster(getReadableDatabase())
        }
        var daoSession: DaoSession = daoMaster.newSession()
        return daoSession
    }

    /**
     * 添加一个媒体(添加一条数据)
     */
    fun addMedio(media: Media) {
        val medioDao: MediaDao = getSession(true).mediaDao
        medioDao.insertOrReplace(media)//可以防止重复数据的添加
    }


    /**
     * 添加数据集合（添加多条数据）
     */
    fun addMedioList(mediaList: List<Media>) {
        val medioDao: MediaDao = getSession(true).mediaDao
        medioDao.insertInTx(mediaList)

    }

    /**
     * 获取一条数据
     */
    fun queryMedia(imgPath: String):Media {
        val medioDao: MediaDao = getSession(false).mediaDao
        val query = medioDao.queryBuilder().where(MediaDao.Properties.ImgPath.eq(imgPath)).build()
        val list = query.list()
        var item: Media? = null
        if (list != null && !list.isEmpty()) {
            item = list.get(0)
        }
        return item!!
    }

    /**
     * 插叙所有数据
     */
    fun queryAllMedia():MutableList<Media>{
        val medioDao: MediaDao = getSession(false).mediaDao
        val list=medioDao.queryBuilder().list()
        return list
    }
    /**
     * 删除一个图片或视频资源
     */
   fun deleteMedia(media: Media){
        val mediaDao: MediaDao = getSession(false).mediaDao
         mediaDao.delete(media)
    }
    /**
     * 删除所有数据
      */
    fun deleteAllMedia(){
        val mediaDao: MediaDao = getSession(false).mediaDao
        mediaDao.deleteAll()
    }
    companion object {
        private val dbName = "media_db"
        private var mInstance: DBManager? = null

        /**
         * 获取单例引用
         * @param context
         * *
         * @return
         */
        fun getInstance(context: Context): DBManager {
            if (mInstance == null) {
                synchronized(DBManager::class.java) {
                    if (mInstance == null) {
                        mInstance = DBManager(context)
                    }
                }
            }
            return mInstance!!
        }
    }


}