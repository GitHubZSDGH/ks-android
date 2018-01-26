package hlks.hualiangou.com.ks_android.modle.bean;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;

import java.util.List;

/**
 * Created by localadmin on 2017/11/19.
 */

public class ShoppingCartBean  {


    /**
     * ret : 0
     * msg : [{"cart_id":"40","shop_id":"36","shop_num":"1","shop_price":"100","shop_money":"111","shop_name":"华","shop_spec_id":"189","member_id":"1","member_name":"华联可溯","shop_sketch":"华","shop_link":"http://www.kesu-shop.com/admin/index/index.html","shop_start_money":"22","shop_end_money":"234","shop_mark":"华联自营,商家认证,正品保证","is_use":"0","is_new":"0","comment_num":"0","look_num":"0","stock_num":"0","sale_num":"0","is_heat":"0","serial_number":"","freight":"5","money_diff":"212","spike":"0","image_path":"/upload//20171122\\2188b07175dd6b4ef03a5727e9b7c24e.jpg","shop_spec":{"spec_one_name":"八年","spec_two_name":"500ml"}},{"cart_id":"41","shop_id":"24","shop_num":"2","shop_price":"100","shop_money":"554","shop_name":"二维","shop_spec_id":"189","member_id":"1","member_name":"华联可溯","shop_sketch":"无二次","shop_link":"http://www.kesu-shop.com/admin/index/index.html","shop_start_money":"211","shop_end_money":"234","shop_mark":"华联自营,7天无理由","is_use":"0","is_new":"0","comment_num":"0","look_num":"0","stock_num":"0","sale_num":"0","is_heat":"0","serial_number":"","freight":"5","money_diff":"23","spike":"0","image_path":"/upload//20171121\\101f081cf1f87f766625dbc596d1dc2b.jpg","shop_spec":{"spec_one_name":"八年","spec_two_name":"500ml"}},{"cart_id":"49","shop_id":"4","shop_num":"6","shop_price":"103","shop_money":"","shop_name":"商品测试3","shop_spec_id":"175","member_id":"1","member_name":"华联可溯","shop_sketch":"","shop_link":null,"shop_start_money":"403","shop_end_money":"103","shop_mark":"华联自营,商家认证,7天无理由","is_use":"0","is_new":"0","comment_num":"3","look_num":"3","stock_num":"0","sale_num":"3","is_heat":"1","serial_number":"123","freight":"10","money_diff":"","spike":"1","image_path":"/upload/20171027/7ba6150d3271554021432643b30917d7.jpg","shop_spec":{"spec_one_name":"绿色","spec_two_name":"XL"}},{"cart_id":"50","shop_id":"4","shop_num":"11","shop_price":"103","shop_money":"","shop_name":"商品测试3","shop_spec_id":"171","member_id":"1","member_name":"华联可溯","shop_sketch":"","shop_link":null,"shop_start_money":"403","shop_end_money":"103","shop_mark":"华联自营,商家认证,7天无理由","is_use":"0","is_new":"0","comment_num":"3","look_num":"3","stock_num":"0","sale_num":"3","is_heat":"1","serial_number":"123","freight":"10","money_diff":"","spike":"1","image_path":"/upload/20171027/7ba6150d3271554021432643b30917d7.jpg","shop_spec":{"spec_one_name":"红色","spec_two_name":"XXL"}}]
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

    public static class MsgBean implements Parcelable {

        /**
         * cart_id : 40
         * shop_id : 36
         * shop_num : 1
         * shop_price : 100
         * shop_money : 111
         * shop_name : 华
         * shop_spec_id : 189
         * member_id : 1
         * member_name : 华联可溯
         * shop_sketch : 华
         * shop_link : http://www.kesu-shop.com/admin/index/index.html
         * shop_start_money : 22
         * shop_end_money : 234
         * shop_mark : 华联自营,商家认证,正品保证
         * is_use : 0
         * is_new : 0
         * comment_num : 0
         * look_num : 0
         * stock_num : 0
         * sale_num : 0
         * is_heat : 0
         * serial_number :
         * freight : 5
         * money_diff : 212
         * spike : 0
         * image_path : /upload//20171122\2188b07175dd6b4ef03a5727e9b7c24e.jpg
         * shop_spec : {"spec_one_name":"八年","spec_two_name":"500ml"}
         */
        @Expose
        private boolean ischeck;
        @Expose
        private boolean isBianji;

        public boolean isBianji() {
            return isBianji;
        }

        public void setBianji(boolean bianji) {
            isBianji = bianji;
        }

        public boolean ischeck() {
            return ischeck;
        }

        public void setIscheck(boolean ischeck) {
            this.ischeck = ischeck;
        }

        private String cart_id;
        private String shop_id;
        private String shop_num;
        private String shop_price;
        private String shop_money;
        private String shop_name;
        private String shop_spec_id;
        private String member_id;
        private String member_name;
        private String shop_sketch;
        private String shop_link;
        private String shop_start_money;
        private String shop_end_money;
        private String shop_mark;
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
        private ShopSpecBean shop_spec;
        private int is_integral;
        private String integral;

        public int getIs_integral() {
            return is_integral;
        }

        public void setIs_integral(int is_integral) {
            this.is_integral = is_integral;
        }

        public String getIntegral() {
            return integral;
        }

        public void setIntegral(String integral) {
            this.integral = integral;
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

        public String getShop_spec_id() {
            return shop_spec_id;
        }

        public void setShop_spec_id(String shop_spec_id) {
            this.shop_spec_id = shop_spec_id;
        }

        public String getMember_id() {
            return member_id;
        }

        public void setMember_id(String member_id) {
            this.member_id = member_id;
        }

        public String getMember_name() {
            return member_name;
        }

        public void setMember_name(String member_name) {
            this.member_name = member_name;
        }

        public String getShop_sketch() {
            return shop_sketch;
        }

        public void setShop_sketch(String shop_sketch) {
            this.shop_sketch = shop_sketch;
        }

        public String getShop_link() {
            return shop_link;
        }

        public void setShop_link(String shop_link) {
            this.shop_link = shop_link;
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

        public String getShop_mark() {
            return shop_mark;
        }

        public void setShop_mark(String shop_mark) {
            this.shop_mark = shop_mark;
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

        public ShopSpecBean getShop_spec() {
            return shop_spec;
        }

        public void setShop_spec(ShopSpecBean shop_spec) {
            this.shop_spec = shop_spec;
        }

        public static class ShopSpecBean implements Parcelable {
            /**
             * spec_one_name : 八年
             * spec_two_name : 500ml
             */

            private String spec_one_name;
            private String spec_two_name;

            public String getSpec_one_name() {
                return spec_one_name;
            }

            public void setSpec_one_name(String spec_one_name) {
                this.spec_one_name = spec_one_name;
            }

            public String getSpec_two_name() {
                return spec_two_name;
            }

            public void setSpec_two_name(String spec_two_name) {
                this.spec_two_name = spec_two_name;
            }

            public ShopSpecBean() {
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.spec_one_name);
                dest.writeString(this.spec_two_name);
            }

            protected ShopSpecBean(Parcel in) {
                this.spec_one_name = in.readString();
                this.spec_two_name = in.readString();
            }

            public static final Creator<ShopSpecBean> CREATOR = new Creator<ShopSpecBean>() {
                @Override
                public ShopSpecBean createFromParcel(Parcel source) {
                    return new ShopSpecBean(source);
                }

                @Override
                public ShopSpecBean[] newArray(int size) {
                    return new ShopSpecBean[size];
                }
            };
        }

        public MsgBean() {
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeByte(this.ischeck ? (byte) 1 : (byte) 0);
            dest.writeByte(this.isBianji ? (byte) 1 : (byte) 0);
            dest.writeString(this.cart_id);
            dest.writeString(this.shop_id);
            dest.writeString(this.shop_num);
            dest.writeString(this.shop_price);
            dest.writeString(this.shop_money);
            dest.writeString(this.shop_name);
            dest.writeString(this.shop_spec_id);
            dest.writeString(this.member_id);
            dest.writeString(this.member_name);
            dest.writeString(this.shop_sketch);
            dest.writeString(this.shop_link);
            dest.writeString(this.shop_start_money);
            dest.writeString(this.shop_end_money);
            dest.writeString(this.shop_mark);
            dest.writeString(this.is_use);
            dest.writeString(this.is_new);
            dest.writeString(this.comment_num);
            dest.writeString(this.look_num);
            dest.writeString(this.stock_num);
            dest.writeString(this.sale_num);
            dest.writeString(this.is_heat);
            dest.writeString(this.serial_number);
            dest.writeString(this.freight);
            dest.writeString(this.money_diff);
            dest.writeString(this.spike);
            dest.writeString(this.image_path);
            dest.writeParcelable(this.shop_spec, flags);
            dest.writeInt(this.is_integral);
            dest.writeString(this.integral);
        }

        protected MsgBean(Parcel in) {
            this.ischeck = in.readByte() != 0;
            this.isBianji = in.readByte() != 0;
            this.cart_id = in.readString();
            this.shop_id = in.readString();
            this.shop_num = in.readString();
            this.shop_price = in.readString();
            this.shop_money = in.readString();
            this.shop_name = in.readString();
            this.shop_spec_id = in.readString();
            this.member_id = in.readString();
            this.member_name = in.readString();
            this.shop_sketch = in.readString();
            this.shop_link = in.readString();
            this.shop_start_money = in.readString();
            this.shop_end_money = in.readString();
            this.shop_mark = in.readString();
            this.is_use = in.readString();
            this.is_new = in.readString();
            this.comment_num = in.readString();
            this.look_num = in.readString();
            this.stock_num = in.readString();
            this.sale_num = in.readString();
            this.is_heat = in.readString();
            this.serial_number = in.readString();
            this.freight = in.readString();
            this.money_diff = in.readString();
            this.spike = in.readString();
            this.image_path = in.readString();
            this.shop_spec = in.readParcelable(ShopSpecBean.class.getClassLoader());
            this.is_integral = in.readInt();
            this.integral = in.readString();
        }

        public static final Creator<MsgBean> CREATOR = new Creator<MsgBean>() {
            @Override
            public MsgBean createFromParcel(Parcel source) {
                return new MsgBean(source);
            }

            @Override
            public MsgBean[] newArray(int size) {
                return new MsgBean[size];
            }
        };
    }
}
