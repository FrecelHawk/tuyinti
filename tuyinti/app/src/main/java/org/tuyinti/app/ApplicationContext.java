package org.tuyinti.app;

import android.app.Application;
import android.content.Context;

/**
 * Created by Administrator on 2017/4/7.
 */

public class ApplicationContext extends Application {

    public static Context mContext =null;


    @Override
    public void onCreate() {
        // TODO Auto-generated method stub
        super.onCreate();
        mContext = ApplicationContext.this;

    }


}
