package org.tuyinti.app;

import android.app.Application;
import android.content.Context;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import org.tuyinti.bean.User;

/**
 * Created by Administrator on 2017/4/7.
 */

public class ApplicationContext extends Application {

    public static Context mContext =null;

    private static ApplicationContext instance;
    private static User user;
    public static final String videoPath = "file:///android_asset/test.mp4";

    public static ApplicationContext getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        // TODO Auto-generated method stub
        super.onCreate();
        mContext = ApplicationContext.this;
        instance = this;
        //创建默认的ImageLoader配置参数
        ImageLoaderConfiguration configuration = ImageLoaderConfiguration.createDefault(this);
        //Initialize ImageLoader with configuration.
        ImageLoader.getInstance().init(configuration);

    }


}
