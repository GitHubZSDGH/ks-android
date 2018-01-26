package hlks.hualiangou.com.ks_android.modle.bean;

/**
 * 项目名称:
 * 类描述:
 * 创建时间:2017/12/2
 * 支付宝实体类
 */
public class PayBean {

    /**
     * ret : 0
     * msg : alipay_sdk=alipay-sdk-php-20161101&app_id=2017110109659139&biz_content=%7B%22body%22%3A%22%5Cu8054%5Cu60f3%28Lenovo%29%5Cu62ef%5Cu6551%5Cu8005R7+2015.6%5Cu82f1%5Cu5bf8%5Cu6e38%5Cu620f%5Cu7b14%5Cu8bb0%5Cu672c%5Cu7535%5Cu8111%22%2C%22subject%22%3A%22%5Cu8054%5Cu60f3%28Lenovo%29%5Cu62ef%5Cu6551%5Cu8005R7+2015.6%5Cu82f1%5Cu5bf8%5Cu6e38%5Cu620f%5Cu7b14%5Cu8bb0%5Cu672c%5Cu7535%5Cu8111%22%2C%22out_trade_no%22%3A%222017120287215638%22%2C%22timeout_express%22%3A%2230m%22%2C%22total_amount%22%3A%220.01%22%2C%22product_code%22%3A%22QUICK_MSECURITY_PAY%22%7D&charset=UTF-8&format=json&method=alipay.trade.app.pay&notify_url=shop.elliotngok.xin%2Fapi%2FCallback%2FaliPayBack&sign_type=RSA2&timestamp=2017-12-02+21%3A56%3A45&version=1.0&sign=oq4XavCL%2B19RaSeluTk2zB4JOsyrtIGamMFFaR27wZWryu0l8vnzMINPNGj3LwjyeDcsS9CeYDd52TPpbiKOVJZlRaPTJ6oZd%2FtKrlFRfMkVvVrxVipKxe5qqoKYyc9qBbpAZsXEvbVuPecfwpgyuk31G%2BfZcNmMiEGGAMQoG14POYZSNUrEicRiD6sIR%2BS1gLihtMqkUxbuliZiaMD1zok%2Bmh4euTHRJIekJgtGfziDGgxoCf3L3UWfms8pUHJopvzVv%2BwX2EifKB6rLle6QRVeuftLaPTY6I1B5pvK58unmnI5ryVYwuNUljvm2q2X7bK04yKr4QNtHtK8CAC%2FSQ%3D%3D
     */

    private String ret;
    private String msg;

    public String getRet() {
        return ret;
    }

    public void setRet(String ret) {
        this.ret = ret;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
