package hlks.hualiangou.com.ks_android.bean;

import java.util.List;

/**
 * 项目名称:
 * 类描述:
 * 创建时间:2017/11/27
 */
public class UploadShopping {

    private List<ShopingBean> shoping;

    public List<ShopingBean> getShoping() {
        return shoping;
    }

    public void setShoping(List<ShopingBean> shoping) {
        this.shoping = shoping;
    }

    public static class ShopingBean {
        /**
         * cart_id : 购物车列表返回的cart_id
         * staff : 1:删除。0:修改
         * shop_num : 商品数量
         * shop_money : 商品总额
         */

        private String cart_id;
        private String staff;
        private String shop_num;
        private String shop_money;

        public String getCart_id() {
            return cart_id;
        }

        public void setCart_id(String cart_id) {
            this.cart_id = cart_id;
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
    }
}
