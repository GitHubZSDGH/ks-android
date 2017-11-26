package hlks.hualiangou.com.ks_android.utils;

import android.app.Activity;

import hlks.hualiangou.com.ks_android.App;

/**
 * description:上下文工具类
 * author:wangjie
 * date:17/6/26
 * update:
 * version: 1.0.0
 */
public class ContextUtil {

    private static ContextUtil instance = new ContextUtil();

    private Activity currentActivity;

    private App app;
    private ContextUtil() {
    }
    public static ContextUtil getInstance() {
        return instance;
    }
    public Activity getCurrentActivity() {
        return currentActivity;
    }
    public void setCurrentActivity(Activity currentActivity) {
        this.currentActivity = currentActivity;
    }
    public App getApp() {
        return app;
    }

    public void setApp(App app) {
        this.app = app;
    }

}
