package hlks.hualiangou.com.ks_android.modle.url;

/**
 * Created by Administrator on 2017/10/13.
 * 测试接口请求实体类
 */

public class UrlUtilds {
    //正式签名密钥
//    public final static String construct_key = "b38fc4a7153bee3047259b2cc7cbc231";
//    public final static String APPID = "16551120";
    //签名密钥
    public final static String construct_key = "hh8bf094169a40a3bd188ba37ebe872v&";
    public final static String APPID = "1610001";
    //接口域名地址
//    public final static String URL = "http://shop.elliotngok.xin/api/";
    public final static String URL = "http://dev.api.chinatonect.com/api/";
    //短信验证地址
    public final static String NotURL = "http://m.5c.com.cn/api/send/index.php";
    //图片域名地址
    public final static String IMG_URL = "http://shop.elliotngok.xin";
    //登录请求
    public final static String LoginUrl = URL + "user/login";
    //手机号码检测
    public final static String PhoneText = URL + "user/userValid";
    // public final static String aa = "http://elliotngok.xin/admin/index/hello";
    //注册
    public final static String RegisterPhone = URL + "user/registerUser";
    //密码找回
    public final static String getPassWord = URL + "user/getBack";
    //轮播图图片名称
    public final static String getCarousel = URL + "carousel/getCarousel";
    //首页下部分
    public final static String recommend = URL + "recommend/getRecommend";
    //分类界面
    public final static String categroy = URL + "categroy/getCategroy";
    /**
     * 获取购物车列表
     */
    public final static String GET_SHOPPING_CART = URL + "Cart/getCartList";

    //商品搜索/商品列表
    public final static String GET_SHOP = URL + "shop/getShop";


    //用户查看商品的次数
    public final static String USER_LOOK_NUM = URL + "user/userLookNum";
    //商品详情
    public final static String GET_SHOPINFO = URL + "shop/getShopInfo";
    //修改购物车
    public final static String UPDATE_SHOPING = URL + "shop/updateShoping";
    //添加商品到购物车
    public final static String CREATE = URL + "Cart/create";
    //订单
    public final static String ORDER = URL + "order/order";
    //订单支付
    public final static String ORDER_SETTLEMENT = URL + "order/orderSettlement";
    //获取分类
    public final static String GET_CATEGROY = URL + "categroy/getCategroy";
    //获取省市区
    public final static String GET_REGION = URL + "region/getRegion";
    //获取用户收货地址列表
    public final static String GET_USERADDR = URL + "addr/getUserAddr";
    //用户添加收货地址
    public final static String ADD_USERADDR = URL + "addr/AddUserAddr";
    //修改用户默认收货地址
    public final static String UPDATE_USER_ADDRDEFAULT = URL + "addr/updateUserAddrDefault";
    //修改用户收货地址
    public final static String UPDATE_USER_ADDR = URL + "addr/updateUserAddr";
    //用户删除收货地址
    public final static String DELEDT_USERADDR = URL + "addr/deledtUserAddr";
    //修改用户头像
    public final static String UPDATE_HEADER = URL + "users/updateHeader";
    //支付宝支付接口
    public final static String PAY_ORDER = URL + "pay/payOrder";
    //搜索页面
    public final static String GET_KEY = URL + "keyword/getKey";

    /**
     * 获取订单列表
     */
    public final static String GET_ORDER_LIST = URL + "myself/order";
    /**
     * 提醒发货
     */
    public final static String GET_REMIND = URL + "myself/remind";
    /**
     * 取消订单
     */
    public final static String GET_CANCEL_ORDER = URL + "myself/cancelOrder";
    /**
     *确认收货
     */
    public final static String GET_QUERY_RECE = URL + "myself/queryRece";
    /**
     *申请退款
     */
    public final static String GET_QUEST_REFUND = URL + "myself/questRefund";
    /**
     * 删除订单
     */
    public final static String GET_DELORDER = URL + "myself/delOrder";

    /**
     * 撤销申请退款
     */
    public final static String GET_CANCEL_REFUND = URL + "myself/cancelRefund";
    /**
     * 获取用户积分值
     */
    public final static String GET_USER_INTEGRAL = URL + "myself/userIntegral";
    /**
     * 我的界面
     */
    public final static String GET_MYSELF = URL + "myself/myself";
    /**
     *用户查看商品记录
     */
    public final static String GET_USER_SHOPHISTORY = URL + "shop/userShopHistory";
    /**
     * 查询用户足迹
     */
    public final static String GET_USER_HISTORY = URL + "shop/getUserHistory";
    /**
     * 删除足迹
     */
    public final static String GET_CHCK_HISTORY = URL + "shop/chckHistory";

}

