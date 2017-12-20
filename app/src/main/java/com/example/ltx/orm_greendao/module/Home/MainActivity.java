package com.example.ltx.orm_greendao.module.Home;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.ltx.orm_greendao.R;
import com.example.ltx.orm_greendao.db.DBHelper;
import com.example.ltx.orm_greendao.db.entity.DaoSession;
import com.example.ltx.orm_greendao.db.entity.User;
import com.example.ltx.orm_greendao.db.entity.UserDao;

import de.greenrobot.dao.async.AsyncOperation;
import de.greenrobot.dao.async.AsyncOperationListener;
import de.greenrobot.dao.async.AsyncSession;

public class MainActivity extends Activity implements View.OnClickListener {
    private TextView mTvShow;
    private Button mBtnAdd,mBtnDel,mBtnUpdate,mBtnSelect;
    private AsyncSession mAsyncSession;
    private DaoSession mDaoSession;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTvShow = findViewById(R.id.db_show);
        mBtnAdd = findViewById(R.id.db_add);
        mBtnDel = findViewById(R.id.db_delete);
        mBtnUpdate = findViewById(R.id.db_update);
        mBtnSelect = findViewById(R.id.db_select);


        mBtnAdd.setOnClickListener(this);
        mBtnDel.setOnClickListener(this);
        mBtnUpdate.setOnClickListener(this);
        mBtnSelect.setOnClickListener(this);

        mAsyncSession = DBHelper.getAsyncSessionInstance();
        mDaoSession = DBHelper.getSessionInstance();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.db_add:
                User u = new User();
                u.setUserName("ltx");
                u.setAge(4);


                //异步操作
                mAsyncSession.insert(u);
                mAsyncSession.setListenerMainThread(new AsyncOperationListener() {
                    @Override
                    public void onAsyncOperationCompleted(AsyncOperation operation) {
                        operation.getResult();
                    }
                });



                mAsyncSession.runInTx(new Runnable() {
                    @Override
                    public void run() {
                        //不关心结果，且有多个顺序执行的操作
                    }
                });


                UserDao userDao = mDaoSession.getUserDao();
                //同步操作
                userDao.insert(u);


                break;

            case R.id.db_delete:


                break;

            case R.id.db_update:
                break;

            case R.id.db_select:
                break;
        }
    }
}
