package hlks.hualiangou.com.ks_android.utils;

/**
 * Created by localadmin on 2017/11/19.
 */

public class UserUtils {
    public static String getToken() {
        return SharedPreferencesUtils.getString(KeyUtils.USER_TOKEN);
    }
    public static String getUserId() {
        return SharedPreferencesUtils.getString(KeyUtils.USER_ID);
    }
}
