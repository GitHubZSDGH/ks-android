package hlks.hualiangou.com.ks_android.utils.encryption;

/**
 * Created by Administrator on 2017/10/13.
 * 测试接口请求实体类
 */

public class ModelUtilds {
    //签名密钥
    public  final static String construct_key="hh8bf094169a40a3bd188ba37ebe872v&";
   public final static String APPID = "1610001";
    //接口域名地址
    public final static String URL = "http://shop.elliotngok.xin/api/";
    //短信验证地址
    public final static String NotURL = "http://m.5c.com.cn/api/send/index.php";
//图片域名地址
public final static String IMG_URL = "http://shop.elliotngok.xin/";
    //登录请求
    public final static String LoginUrl= URL+"user/login";
    //手机号码检测
    public  final static String PhoneText = URL+"user/userValid";
   // public final static String aa = "http://elliotngok.xin/admin/index/hello";
    //注册
    public final static String RegisterPhone = URL+"user/registerUser";
    //密码找回
    public final static String getPassWord = URL+"user/getBack";
    //轮播图图片名称
    public final static String carousel = URL+"carousel/getCarousel";
  //首页下部分
    public  final static String recommend = URL+"recommend/getRecommend";
    //分类界面
    public final static String categroy = URL +"categroy/getCategroy";
//http://shop.elliotngok.xin/uploads/shop/2.jpg
}

