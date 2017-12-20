package com.example.ltx.orm_greendao.db.generator;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

/**
 * Created by ltx on 2017/12/19.
 */

public class GreenDaoGenerator {

    private static void addTaskDetail(Schema schema) {
        //创建User表
        Entity entityUser = schema.addEntity("User");
        entityUser.addIdProperty().primaryKey().autoincrement();;
        entityUser.addStringProperty("userId").notNull();
        entityUser.addStringProperty("userName");
        entityUser.addIntProperty("age");
        entityUser.addStringProperty("phone");
        entityUser.addDateProperty("createTime");
        entityUser.addDateProperty("modifyTime");

        //创建NetCache表
        Entity entityNetCache = schema.addEntity("NetCache");
        entityNetCache.addIdProperty().primaryKey().autoincrement();;
        entityNetCache.addLongProperty("netId").notNull();
        entityNetCache.addStringProperty("url");
        entityNetCache.addStringProperty("json");
        entityNetCache.addDateProperty("createTime");
        entityNetCache.addDateProperty("modifyTime");
    }

    public static void main(String[] args) throws Exception {
        //定义Scheme，可以有多个，通常一个就可以了。Scheme相当于房间，表相当于书架子。
        //参数二代表包的路径，生成文件所在位置。
        //需要注意的是，Scheme版本更新，DaoSession
        Schema schema = new Schema(1, "com.example.ltx.orm_greendao.db.entity");
        addTaskDetail(schema);
        try {
            new DaoGenerator().generateAll(schema, "../ORM-GreenDao/app/src/main/java/");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
