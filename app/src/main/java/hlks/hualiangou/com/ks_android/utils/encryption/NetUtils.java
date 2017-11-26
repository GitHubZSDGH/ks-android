package hlks.hualiangou.com.ks_android.utils.encryption;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.widget.Toast;

/*
 * 网络判断工具类
 */
public class NetUtils {
    private Context ctx;

    public NetUtils(Context ctx) {
        this.ctx = ctx;
    }

    public boolean isNet() {
        ConnectivityManager manager = (ConnectivityManager) ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
        //ConnectivityManager 网络管理器
        //getSystemService 获取服务
        //name 你要获取系统的什么服务
        NetworkInfo info;//网络实体类
        State state;//网络状态
        info = manager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        if (info != null) {
            state = info.getState();
            if (state == State.CONNECTED) {
                //	Toast.makeText(ctx, "现在是WiFi", Toast.LENGTH_LONG).show();
                return true;
            }
        }

        info = manager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        if (info != null) {
            state = info.getState();
            if (state == State.CONNECTED) {
                //Toast.makeText(ctx, "现在是移送网络", Toast.LENGTH_LONG).show();
                return true;
            }
        }
        Toast.makeText(ctx, "无网络连接，请检查网络连接状态", Toast.LENGTH_LONG).show();
        return false;
    }
    /*public void connect(){

		OkHttpClient client = new OkHttpClient.Builder()
					.connectTimeout(10, TimeUnit.SECONDS)
					.readTimeout(20, TimeUnit.SECONDS)
					.build();

	}*/
}
