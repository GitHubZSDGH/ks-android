package hlks.hualiangou.com.ks_android.utils.encryption;

import android.content.Context;

/**
 * Created by lzq on 2016/5/10.
 */
public class HwAppCache {

    // context
    private static Context context;
    // 用户帐号
    private static String account;

    /**
     * TODO 清空本地的用户账号
     */
    public static void clear() {
        account = null;
    }

    /**
     * TODO 获取本地的用户账号
     */
    public static String getAccount() {
        return account;
    }

    /**
     * TODO 设置本地的用户账号
     */
    public static void setAccount(String account) {
        HwAppCache.account = account;
    }

    /**
     * TODO 获取ApplicationContext
     */
    public static Context getContext() {
        return context;
    }

    /**
     * TODO 由Context得到ApplicationContext并存储在DemoCache
     */
    public static void setContext(Context context) {
        HwAppCache.context = context.getApplicationContext();
    }

}
