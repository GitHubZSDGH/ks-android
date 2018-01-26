package hlks.hualiangou.com.ks_android.bean;

/**
 * 项目名称:
 * 类描述:
 * 创建人:lenovo
 * 创建时间:2017/11/22
 * 修改人:
 * 修改内容:
 */
public class UpdateShopping {

    /**
     * shop_id : 商品id
     * staff : 1:删除。0:修改
     * shop_num : 商品数量
     * shop_money : 商品总额
     */

    private String shop_spec_id;
    private String staff;
    private String shop_num;
    private String shop_money;
    private  String cart_id;
    private  String shop_id;

    public String getShop_spec_id() {
        return shop_spec_id;
    }

    public void setShop_spec_id(String shop_spec_id) {
        this.shop_spec_id = shop_spec_id;
    }

    public String getStaff() {
        return staff;
    }

    public void setStaff(String staff) {
        this.staff = staff;
    }

    public String getShop_num() {
        return shop_num;
    }

    public void setShop_num(String shop_num) {
        this.shop_num = shop_num;
    }

    public String getShop_money() {
        return shop_money;
    }

    public void setShop_money(String shop_money) {
        this.shop_money = shop_money;
    }

    public String getCart_id() {
        return cart_id;
    }

    public void setCart_id(String cart_id) {
        this.cart_id = cart_id;
    }

    public String getShop_id() {
        return shop_id;
    }

    public void setShop_id(String shop_id) {
        this.shop_id = shop_id;
    }
}
