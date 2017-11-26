package hlks.hualiangou.com.ks_android.utils.encryption;

import android.util.Base64;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created by Administrator on 2017/10/13.
 * sha1加密工具类
 *
 */

public class HMACSHA1 {

    private static final String MAC_NAME = "HmacSHA1";
    private static final String ENCODING = "UTF-8";

    public static String hmac_sha1(String key, String datas) {
        String reString = "";
        try {
            byte[] data = key.getBytes("UTF-8");
            //根据给定的字节数组构造一个密钥,第二参数指定一个密钥算法的名称
            SecretKey secretKey = new SecretKeySpec(data, "HmacSHA1");
            //生成一个指定 Mac 算法 的 Mac 对象
            Mac mac = Mac.getInstance(MAC_NAME);
            //用给定密钥初始化 Mac 对象
            mac.init(secretKey);

            byte[] text = datas.getBytes(ENCODING);
            //完成 Mac 操作
            byte[] text1 = mac.doFinal(text);

            reString = Base64.encodeToString(text1, Base64.DEFAULT);

        } catch (Exception e) {
            // TODO: handle exception
        }

        return reString.trim();
    }

}
