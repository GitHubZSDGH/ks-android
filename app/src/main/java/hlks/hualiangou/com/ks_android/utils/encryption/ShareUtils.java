package hlks.hualiangou.com.ks_android.utils.encryption;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by FY on 2016/12/1.
 * 本地保存工具类
 */

public class ShareUtils {
    private final static int mode = Context.MODE_PRIVATE;
    //保存数据
    public static  void saveXML(String key,String Value,Context ctx){
        SharedPreferences share = ctx.getSharedPreferences("animal", 0);
        SharedPreferences.Editor edt = share.edit();
        edt.putString(key, Value);
        edt.commit();
    }
    //读取数据
    public static String readXML(String key,Context ctx){
        String result = null;
        SharedPreferences share = ctx.getSharedPreferences("animal", 0);
        result = share.getString(key, "");
        return result;
    }
    //删除数据key
    public static void ClearXML(String key, Context ctx){
        SharedPreferences shareClear = ctx.getSharedPreferences("animal",0);
        SharedPreferences.Editor editor = shareClear.edit();
        editor.remove(key);
        editor.commit();

    }
    //删除所有数据
    public static void Clear(Context ctx){
        SharedPreferences shareClear = ctx.getSharedPreferences("animal",0);
        SharedPreferences.Editor editor = shareClear.edit();
       editor.clear();
        editor.commit();

    }
    public static void saveBoolean(Context context,String key,boolean value){
        SharedPreferences sp = context.getSharedPreferences("animal", mode);
        SharedPreferences.Editor edit = sp.edit();
        edit.putBoolean(key, value);
        edit.commit();
    }
    public static boolean getBoolean(Context context,String key,boolean defValue){
        SharedPreferences sp = context.getSharedPreferences("animal", mode);
        return sp.getBoolean(key, defValue);
    }
}
