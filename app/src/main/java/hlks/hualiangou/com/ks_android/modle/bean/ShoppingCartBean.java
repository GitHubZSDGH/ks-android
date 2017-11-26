package hlks.hualiangou.com.ks_android.modle.bean;

import com.google.gson.annotations.Expose;

import java.util.List;

/**
 * Created by localadmin on 2017/11/19.
 */

public class ShoppingCartBean  {


    /**
     * ret : 0
     * msg : [{"shop_id":"4","shop_num":"1","shop_price":"103","shop_money":"103","shop_name":"商品测试3","shop_sketch":"","shop_link":null,"shop_mark":"","shop_start_money":"403","shop_end_money":"103","create_time":"1466561616","is_use":"0","is_new":"1","comment_num":"3","look_num":"3","stock_num":"5","sale_num":"3","is_heat":"1","serial_number":"123","freight":"10","money_diff":"","spike":"1","image_path":"\\upload\\20171027\\7ba6150d3271554021432643b30917d7.jpg"},{"shop_id":"4","shop_num":"1","shop_price":"103","shop_money":"103","shop_name":"商品测试3","shop_sketch":"","shop_link":null,"shop_mark":"","shop_start_money":"403","shop_end_money":"103","create_time":"1466561616","is_use":"0","is_new":"1","comment_num":"3","look_num":"3","stock_num":"5","sale_num":"3","is_heat":"1","serial_number":"123","freight":"10","money_diff":"","spike":"1","image_path":"\\upload\\20171027\\7ba6150d3271554021432643b30917d7.jpg"},{"shop_id":"4","shop_num":"1","shop_price":"103","shop_money":"103","shop_name":"商品测试3","shop_sketch":"","shop_link":null,"shop_mark":"","shop_start_money":"403","shop_end_money":"103","create_time":"1466561616","is_use":"0","is_new":"1","comment_num":"3","look_num":"3","stock_num":"5","sale_num":"3","is_heat":"1","serial_number":"123","freight":"10","money_diff":"","spike":"1","image_path":"\\upload\\20171027\\7ba6150d3271554021432643b30917d7.jpg"},{"shop_id":"4","shop_num":"1","shop_price":"103","shop_money":"103","shop_name":"商品测试3","shop_sketch":"","shop_link":null,"shop_mark":"","shop_start_money":"403","shop_end_money":"103","create_time":"1466561616","is_use":"0","is_new":"1","comment_num":"3","look_num":"3","stock_num":"5","sale_num":"3","is_heat":"1","serial_number":"123","freight":"10","money_diff":"","spike":"1","image_path":"\\upload\\20171027\\7ba6150d3271554021432643b30917d7.jpg"},{"shop_id":"4","shop_num":"1","shop_price":"103","shop_money":"103","shop_name":"商品测试3","shop_sketch":"","shop_link":null,"shop_mark":"","shop_start_money":"403","shop_end_money":"103","create_time":"1466561616","is_use":"0","is_new":"1","comment_num":"3","look_num":"3","stock_num":"5","sale_num":"3","is_heat":"1","serial_number":"123","freight":"10","money_diff":"","spike":"1","image_path":"\\upload\\20171027\\7ba6150d3271554021432643b30917d7.jpg"}]
     */

    private String ret;
    private List<MsgBean> msg;

    public String getRet() {
        return ret;
    }

    public void setRet(String ret) {
        this.ret = ret;
    }

    public List<MsgBean> getMsg() {
        return msg;
    }

    public void setMsg(List<MsgBean> msg) {
        this.msg = msg;
    }

    public static class MsgBean {
        /**
         * shop_id : 4
         * shop_num : 1
         * shop_price : 103
         * shop_money : 103
         * shop_name : 商品测试3
         * shop_sketch :
         * shop_link : null
         * shop_mark :
         * shop_start_money : 403
         * shop_end_money : 103
         * create_time : 1466561616
         * is_use : 0
         * is_new : 1
         * comment_num : 3
         * look_num : 3
         * stock_num : 5
         * sale_num : 3
         * is_heat : 1
         * serial_number : 123
         * freight : 10
         * money_diff :
         * spike : 1
         * image_path
         */
        /**
         * 是否选中
         */
        @Expose
        private boolean ischeck;

        public boolean isIscheck() {
            return ischeck;
        }

        public void setIscheck(boolean ischeck) {
            this.ischeck = ischeck;
        }

        private String shop_id;
        private String shop_num;
        private String shop_price;
        private String shop_money;
        private String shop_name;
        private String shop_sketch;
        private Object shop_link;
        private String shop_mark;
        private String shop_start_money;
        private String shop_end_money;
        private String create_time;
        private String is_use;
        private String is_new;
        private String comment_num;
        private String look_num;
        private String stock_num;
        private String sale_num;
        private String is_heat;
        private String serial_number;
        private String freight;
        private String money_diff;
        private String spike;
        private String image_path;

        public String getShop_id() {
            return shop_id;
        }

        public void setShop_id(String shop_id) {
            this.shop_id = shop_id;
        }

        public String getShop_num() {
            return shop_num;
        }

        public void setShop_num(String shop_num) {
            this.shop_num = shop_num;
        }

        public String getShop_price() {
            return shop_price;
        }

        public void setShop_price(String shop_price) {
            this.shop_price = shop_price;
        }

        public String getShop_money() {
            return shop_money;
        }

        public void setShop_money(String shop_money) {
            this.shop_money = shop_money;
        }

        public String getShop_name() {
            return shop_name;
        }

        public void setShop_name(String shop_name) {
            this.shop_name = shop_name;
        }

        public String getShop_sketch() {
            return shop_sketch;
        }

        public void setShop_sketch(String shop_sketch) {
            this.shop_sketch = shop_sketch;
        }

        public Object getShop_link() {
            return shop_link;
        }

        public void setShop_link(Object shop_link) {
            this.shop_link = shop_link;
        }

        public String getShop_mark() {
            return shop_mark;
        }

        public void setShop_mark(String shop_mark) {
            this.shop_mark = shop_mark;
        }

        public String getShop_start_money() {
            return shop_start_money;
        }

        public void setShop_start_money(String shop_start_money) {
            this.shop_start_money = shop_start_money;
        }

        public String getShop_end_money() {
            return shop_end_money;
        }

        public void setShop_end_money(String shop_end_money) {
            this.shop_end_money = shop_end_money;
        }

        public String getCreate_time() {
            return create_time;
        }

        public void setCreate_time(String create_time) {
            this.create_time = create_time;
        }

        public String getIs_use() {
            return is_use;
        }

        public void setIs_use(String is_use) {
            this.is_use = is_use;
        }

        public String getIs_new() {
            return is_new;
        }

        public void setIs_new(String is_new) {
            this.is_new = is_new;
        }

        public String getComment_num() {
            return comment_num;
        }

        public void setComment_num(String comment_num) {
            this.comment_num = comment_num;
        }

        public String getLook_num() {
            return look_num;
        }

        public void setLook_num(String look_num) {
            this.look_num = look_num;
        }

        public String getStock_num() {
            return stock_num;
        }

        public void setStock_num(String stock_num) {
            this.stock_num = stock_num;
        }

        public String getSale_num() {
            return sale_num;
        }

        public void setSale_num(String sale_num) {
            this.sale_num = sale_num;
        }

        public String getIs_heat() {
            return is_heat;
        }

        public void setIs_heat(String is_heat) {
            this.is_heat = is_heat;
        }

        public String getSerial_number() {
            return serial_number;
        }

        public void setSerial_number(String serial_number) {
            this.serial_number = serial_number;
        }

        public String getFreight() {
            return freight;
        }

        public void setFreight(String freight) {
            this.freight = freight;
        }

        public String getMoney_diff() {
            return money_diff;
        }

        public void setMoney_diff(String money_diff) {
            this.money_diff = money_diff;
        }

        public String getSpike() {
            return spike;
        }

        public void setSpike(String spike) {
            this.spike = spike;
        }

        public String getImage_path() {
            return image_path;
        }

        public void setImage_path(String image_path) {
            this.image_path = image_path;
        }
    }
}
