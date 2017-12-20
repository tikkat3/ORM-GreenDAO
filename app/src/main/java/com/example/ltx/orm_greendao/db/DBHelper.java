package com.example.ltx.orm_greendao.db;

import android.app.Application;
import android.content.Context;

import com.example.ltx.orm_greendao.db.entity.DaoMaster;
import com.example.ltx.orm_greendao.db.entity.DaoSession;

import de.greenrobot.dao.async.AsyncSession;

/**
 * Created by ltx on 2017/12/20.
 */

public class DBHelper {
    private static String DB_NAME = "test";

    private static DaoSession session  = null;
    private static AsyncSession asyncSession  = null;

    /**
     * DaoSession单利
     * @return
     */
    public static DaoSession getSessionInstance(){
        if(session==null)
            synchronized (DBHelper.class) {
                if(session==null){
                    Context appContext = new Application().getApplicationContext();
                    DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(appContext, DB_NAME, null);
                    DaoMaster master = new DaoMaster(helper.getWritableDatabase());
                    session = master.newSession();
                }
            }
        return session;
    }

    /**
     * AsyncSession单利
     * @return
     */
    public static AsyncSession getAsyncSessionInstance(){
        if(asyncSession==null)
            synchronized (DBHelper.class) {
                if(asyncSession==null){
                    if(session==null){
                        session = getSessionInstance();
                    }
                    asyncSession = session.startAsyncSession();

                }
            }
        return asyncSession;
    }



}
