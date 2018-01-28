package hlks.hualiangou.com.ks_android.bean;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

/**
 * /**
 * 项目名称: 药到家
 * 类描述:
 * 创建人: XI
 * 创建时间: 2018/1/27 0027 3:00
 * 修改人:
 * 修改内容:
 * 修改时间:
 */


public class OrderDataBean {

    /**
     * ret : 0
     * msg : {"wait_pay":3,"wait_ship":0,"wait_rece":0,"no_common":0,"integral":"0","order_list":[{"order_number":"2018011930114529","order_money":"4.00","order_staff":"1","freight":"0.00","user_remind":0,"create_time":"2018-01-19 11:45:29","order_addr":"广西\t百色市\t德保县","buyer_name":"张硕","buyer_phone":"15011447712","pay_time":"","shop_send_time":"","finish_time":"","is_integral":0,"integral_num":"0","order_type":"1","order_pay":"1","member_id":1,"member_name":"华联可溯","member_image":"/image/logo.png","shop":[{"shop_id":64,"shop_name":"1","shop_num":4,"shop_total":"4.00","shop_price":"1.00","image_path":"/upload/20171205/e3e63e296918f7cd6ec5ef440ba5fd60.jpg","spec_one_name":"2","spec_two_name":"3"}]}]}
     */

    private String ret;
    private MsgBean msg;

    public String getRet() {
        return ret;
    }

    public void setRet(String ret) {
        this.ret = ret;
    }

    public MsgBean getMsg() {
        return msg;
    }

    public void setMsg(MsgBean msg) {
        this.msg = msg;
    }

    public static class MsgBean {
        /**
         * wait_pay : 3
         * wait_ship : 0
         * wait_rece : 0
         * no_common : 0
         * integral : 0
         * order_list : [{"order_number":"2018011930114529","order_money":"4.00","order_staff":"1","freight":"0.00","user_remind":0,"create_time":"2018-01-19 11:45:29","order_addr":"广西\t百色市\t德保县","buyer_name":"张硕","buyer_phone":"15011447712","pay_time":"","shop_send_time":"","finish_time":"","is_integral":0,"integral_num":"0","order_type":"1","order_pay":"1","member_id":1,"member_name":"华联可溯","member_image":"/image/logo.png","shop":[{"shop_id":64,"shop_name":"1","shop_num":4,"shop_total":"4.00","shop_price":"1.00","image_path":"/upload/20171205/e3e63e296918f7cd6ec5ef440ba5fd60.jpg","spec_one_name":"2","spec_two_name":"3"}]}]
         */

        private int wait_pay;
        private int wait_ship;
        private int wait_rece;
        private int no_common;
        private String integral;
        private List<OrderListBean> order_list;

        public int getWait_pay() {
            return wait_pay;
        }

        public void setWait_pay(int wait_pay) {
            this.wait_pay = wait_pay;
        }

        public int getWait_ship() {
            return wait_ship;
        }

        public void setWait_ship(int wait_ship) {
            this.wait_ship = wait_ship;
        }

        public int getWait_rece() {
            return wait_rece;
        }

        public void setWait_rece(int wait_rece) {
            this.wait_rece = wait_rece;
        }

        public int getNo_common() {
            return no_common;
        }

        public void setNo_common(int no_common) {
            this.no_common = no_common;
        }

        public String getIntegral() {
            return integral;
        }

        public void setIntegral(String integral) {
            this.integral = integral;
        }

        public List<OrderListBean> getOrder_list() {
            return order_list;
        }

        public void setOrder_list(List<OrderListBean> order_list) {
            this.order_list = order_list;
        }

        public static class OrderListBean implements Parcelable {

            @Override
            public String toString() {
                return "OrderListBean{" +
                        "order_number='" + order_number + '\'' +
                        ", order_money='" + order_money + '\'' +
                        ", order_staff='" + order_staff + '\'' +
                        ", freight='" + freight + '\'' +
                        ", user_remind=" + user_remind +
                        ", create_time='" + create_time + '\'' +
                        ", order_addr='" + order_addr + '\'' +
                        ", buyer_name='" + buyer_name + '\'' +
                        ", buyer_phone='" + buyer_phone + '\'' +
                        ", pay_time='" + pay_time + '\'' +
                        ", shop_send_time='" + shop_send_time + '\'' +
                        ", finish_time='" + finish_time + '\'' +
                        ", is_integral=" + is_integral +
                        ", integral_num='" + integral_num + '\'' +
                        ", order_type='" + order_type + '\'' +
                        ", order_pay='" + order_pay + '\'' +
                        ", member_id=" + member_id +
                        ", member_name='" + member_name + '\'' +
                        ", member_image='" + member_image + '\'' +
                        ", shop=" + shop +
                        '}';
            }


            /**
             * order_number : 2018011930114529
             * order_money : 4.00
             * order_staff : 1
             * freight : 0.00
             * user_remind : 0
             * create_time : 2018-01-19 11:45:29
             * order_addr : 广西	百色市	德保县
             * buyer_name : 张硕
             * buyer_phone : 15011447712
             * pay_time :
             * shop_send_time :
             * finish_time :
             * is_integral : 0
             * integral_num : 0
             * order_type : 1
             * order_pay : 1
             * member_id : 1
             * member_name : 华联可溯
             * member_image : /image/logo.png
             * shop : [{"shop_id":64,"shop_name":"1","shop_num":4,"shop_total":"4.00","shop_price":"1.00","image_path":"/upload/20171205/e3e63e296918f7cd6ec5ef440ba5fd60.jpg","spec_one_name":"2","spec_two_name":"3"}]
             */

            /**
             * 订单号
             */
            private String order_number;
            /**
             * 订单金额
             */
            private String order_money;
            /**
             * 订单状态
             * 1待付款 2已付款 3交易成功 4交易关闭 5申请退款 6退款完成
             */
            private String order_staff;
            /**
             * 运费
             */
            private String freight;
            /**
             *
             */
            private int user_remind;
            private String create_time;
            /**
             * 收货地址
             */
            private String order_addr;
            /**
             * 收货人
             */
            private String buyer_name;
            /**
             * 收货人手机号
             */
            private String buyer_phone;
            /**
             * 购买时间
             */
            private String pay_time;
            /**
             * 商品发货时间
             */
            private String shop_send_time;
            private String finish_time;
            /**
             * 是否可以积分兑换
             * 1 可以
             * 0 不可以
             */
            private int is_integral;
            /**
             * 积分数量
             */
            private String integral_num;
            /**
             * 订单类型
             */
            private String order_type;
            /**
             * 1.支付宝
             * 2.微信
             * 3.积分
             */
            private String order_pay;
            private int member_id;
            private String member_name;
            /**
             * 商家头像
             */
            public String member_image;
            private List<ShopBean> shop;

            public String getOrder_number() {
                return order_number;
            }

            public void setOrder_number(String order_number) {
                this.order_number = order_number;
            }

            public String getOrder_money() {
                return order_money;
            }

            public void setOrder_money(String order_money) {
                this.order_money = order_money;
            }

            public String getOrder_staff() {
                return order_staff;
            }

            public void setOrder_staff(String order_staff) {
                this.order_staff = order_staff;
            }

            public String getFreight() {
                return freight;
            }

            public void setFreight(String freight) {
                this.freight = freight;
            }

            public int getUser_remind() {
                return user_remind;
            }

            public void setUser_remind(int user_remind) {
                this.user_remind = user_remind;
            }

            public String getCreate_time() {
                return create_time;
            }

            public void setCreate_time(String create_time) {
                this.create_time = create_time;
            }

            public String getOrder_addr() {
                return order_addr;
            }

            public void setOrder_addr(String order_addr) {
                this.order_addr = order_addr;
            }

            public String getBuyer_name() {
                return buyer_name;
            }

            public void setBuyer_name(String buyer_name) {
                this.buyer_name = buyer_name;
            }

            public String getBuyer_phone() {
                return buyer_phone;
            }

            public void setBuyer_phone(String buyer_phone) {
                this.buyer_phone = buyer_phone;
            }

            public String getPay_time() {
                return pay_time;
            }

            public void setPay_time(String pay_time) {
                this.pay_time = pay_time;
            }

            public String getShop_send_time() {
                return shop_send_time;
            }

            public void setShop_send_time(String shop_send_time) {
                this.shop_send_time = shop_send_time;
            }

            public String getFinish_time() {
                return finish_time;
            }

            public void setFinish_time(String finish_time) {
                this.finish_time = finish_time;
            }

            public int getIs_integral() {
                return is_integral;
            }

            public void setIs_integral(int is_integral) {
                this.is_integral = is_integral;
            }

            public String getIntegral_num() {
                return integral_num;
            }

            public void setIntegral_num(String integral_num) {
                this.integral_num = integral_num;
            }

            public String getOrder_type() {
                return order_type;
            }

            public void setOrder_type(String order_type) {
                this.order_type = order_type;
            }

            public String getOrder_pay() {
                return order_pay;
            }

            public void setOrder_pay(String order_pay) {
                this.order_pay = order_pay;
            }

            public int getMember_id() {
                return member_id;
            }

            public void setMember_id(int member_id) {
                this.member_id = member_id;
            }

            public String getMember_name() {
                return member_name;
            }

            public void setMember_name(String member_name) {
                this.member_name = member_name;
            }

            public String getMember_image() {
                return member_image;
            }

            public void setMember_image(String member_image) {
                this.member_image = member_image;
            }

            public List<ShopBean> getShop() {
                return shop;
            }

            public void setShop(List<ShopBean> shop) {
                this.shop = shop;
            }

            public static class ShopBean implements Parcelable {


                /**
                 * shop_id : 64
                 * shop_name : 1
                 * shop_num : 4
                 * shop_total : 4.00
                 * shop_price : 1.00
                 * image_path : /upload/20171205/e3e63e296918f7cd6ec5ef440ba5fd60.jpg
                 * spec_one_name : 2
                 * spec_two_name : 3
                 */
                /**
                 * 商品id
                 */
                private int shop_id;
                /**
                 * 商品名字
                 */
                private String shop_name;
                /**
                 * 商品总数
                 */
                private int shop_num;
                /**
                 * 商品总价
                 */
                private String shop_total;
                /**
                 * 商品价格
                 */
                private String shop_price;
                /**
                 * 商品头像
                 */
                private String image_path;
                /**
                 * {@link #spec_two_name} 和这个合起来
                 */
                private String spec_one_name;
                private String spec_two_name;

                /**
                 * 自定义的商家id
                 */
                @Expose
                private int storeId;


                /**
                 * 订单类型 第一个button
                 * 1:取消订单
                 * 2:再次购买
                 * 3：查看物流。
                 * 4:提醒发货
                 * 5:已提醒发货
                 * 6评论
                 * 7:撤销申请
                 */
                @Expose
                private String order_type;

                /**
                 * 第二个button
                 * 1: 付款
                 * 2: 确认收货
                 * 3：删除订单
                 * 4: 联系客服
                 */
                @Expose
                private String order_pay;





                /**
                 * 商家名字
                 */
                @Expose
                private String storeName;

                /**
                 * 商家的一个logo
                 */
                @Expose
                private String storeHead;

                /**
                 * 订单状态
                 * 1待付款 2已付款 3交易成功 4交易关闭 5申请退款 6退款完成
                 */
                @Expose
                private String orderState;
                /**
                 * 运费
                 */
                @Expose
                private String freight;




                /**
                 * 是否使用积分
                 * 1 可以
                 * 0 不可以
                 */
                @Expose
                private int is_integral;

                /**
                 * 积分数量
                 */
                @Expose
                private String integral_num;


                /**
                 * 商家的index
                 * {@link OrderDataBean.MsgBean.OrderListBean {@link #getOrder_list()}}
                 */
                @Expose
                private int storeIndex;


                /**
                 * 商品数量
                 *
                 */
                @Expose
                private int shopNum;

                @Expose
                private String shopMoney;

                public String getShopMoney() {
                    return shopMoney;
                }

                public void setShopMoney(String shopMoney) {
                    this.shopMoney = shopMoney;
                }

                public int getShopNum() {
                    return shopNum;
                }

                public void setShopNum(int shopNum) {
                    this.shopNum = shopNum;
                }

                public String getFreight() {
                    return freight;
                }

                public void setFreight(String freight) {
                    this.freight = freight;
                }

                public int getIs_integral() {
                    return is_integral;
                }

                public void setIs_integral(int is_integral) {
                    this.is_integral = is_integral;
                }

                public String getIntegral_num() {
                    return integral_num;
                }

                public void setIntegral_num(String integral_num) {
                    this.integral_num = integral_num;
                }

                public int getStoreIndex() {
                    return storeIndex;
                }

                public void setStoreIndex(int storeIndex) {
                    this.storeIndex = storeIndex;
                }

                public String getOrder_type() {
                    return order_type;
                }

                public void setOrder_type(String order_type) {
                    this.order_type = order_type;
                }

                public String getOrder_pay() {
                    return order_pay;
                }

                public void setOrder_pay(String order_pay) {
                    this.order_pay = order_pay;
                }

                public int getStoreId() {
                    return storeId;
                }

                public void setStoreId(int storeId) {
                    this.storeId = storeId;
                }

                public String getStoreName() {
                    return storeName;
                }

                public void setStoreName(String storeName) {
                    this.storeName = storeName;
                }

                public String getStoreHead() {
                    return storeHead;
                }

                public void setStoreHead(String storeHead) {
                    this.storeHead = storeHead;
                }

                public String getOrderState() {
                    return orderState;
                }

                public void setOrderState(String orderState) {
                    this.orderState = orderState;
                }


                public int getShop_id() {
                    return shop_id;
                }

                public void setShop_id(int shop_id) {
                    this.shop_id = shop_id;
                }

                public String getShop_name() {
                    return shop_name;
                }

                public void setShop_name(String shop_name) {
                    this.shop_name = shop_name;
                }

                public int getShop_num() {
                    return shop_num;
                }

                public void setShop_num(int shop_num) {
                    this.shop_num = shop_num;
                }

                public String getShop_total() {
                    return shop_total;
                }

                public void setShop_total(String shop_total) {
                    this.shop_total = shop_total;
                }

                public String getShop_price() {
                    return shop_price;
                }

                public void setShop_price(String shop_price) {
                    this.shop_price = shop_price;
                }

                public String getImage_path() {
                    return image_path;
                }

                public void setImage_path(String image_path) {
                    this.image_path = image_path;
                }

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

                @Override
                public int describeContents() {
                    return 0;
                }

                @Override
                public void writeToParcel(Parcel dest, int flags) {
                    dest.writeInt(this.shop_id);
                    dest.writeString(this.shop_name);
                    dest.writeInt(this.shop_num);
                    dest.writeString(this.shop_total);
                    dest.writeString(this.shop_price);
                    dest.writeString(this.image_path);
                    dest.writeString(this.spec_one_name);
                    dest.writeString(this.spec_two_name);
                    dest.writeInt(this.storeId);
                    dest.writeString(this.order_type);
                    dest.writeString(this.order_pay);
                    dest.writeString(this.storeName);
                    dest.writeString(this.storeHead);
                    dest.writeString(this.orderState);
                    dest.writeString(this.freight);
                    dest.writeInt(this.is_integral);
                    dest.writeString(this.integral_num);
                    dest.writeInt(this.storeIndex);
                    dest.writeInt(this.shopNum);
                    dest.writeString(this.shopMoney);
                }

                public ShopBean() {
                }

                protected ShopBean(Parcel in) {
                    this.shop_id = in.readInt();
                    this.shop_name = in.readString();
                    this.shop_num = in.readInt();
                    this.shop_total = in.readString();
                    this.shop_price = in.readString();
                    this.image_path = in.readString();
                    this.spec_one_name = in.readString();
                    this.spec_two_name = in.readString();
                    this.storeId = in.readInt();
                    this.order_type = in.readString();
                    this.order_pay = in.readString();
                    this.storeName = in.readString();
                    this.storeHead = in.readString();
                    this.orderState = in.readString();
                    this.freight = in.readString();
                    this.is_integral = in.readInt();
                    this.integral_num = in.readString();
                    this.storeIndex = in.readInt();
                    this.shopNum = in.readInt();
                    this.shopMoney = in.readString();
                }

                public static final Creator<ShopBean> CREATOR = new Creator<ShopBean>() {
                    @Override
                    public ShopBean createFromParcel(Parcel source) {
                        return new ShopBean(source);
                    }

                    @Override
                    public ShopBean[] newArray(int size) {
                        return new ShopBean[size];
                    }
                };
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.order_number);
                dest.writeString(this.order_money);
                dest.writeString(this.order_staff);
                dest.writeString(this.freight);
                dest.writeInt(this.user_remind);
                dest.writeString(this.create_time);
                dest.writeString(this.order_addr);
                dest.writeString(this.buyer_name);
                dest.writeString(this.buyer_phone);
                dest.writeString(this.pay_time);
                dest.writeString(this.shop_send_time);
                dest.writeString(this.finish_time);
                dest.writeInt(this.is_integral);
                dest.writeString(this.integral_num);
                dest.writeString(this.order_type);
                dest.writeString(this.order_pay);
                dest.writeInt(this.member_id);
                dest.writeString(this.member_name);
                dest.writeString(this.member_image);
                dest.writeList(this.shop);
            }

            public OrderListBean() {
            }

            protected OrderListBean(Parcel in) {
                this.order_number = in.readString();
                this.order_money = in.readString();
                this.order_staff = in.readString();
                this.freight = in.readString();
                this.user_remind = in.readInt();
                this.create_time = in.readString();
                this.order_addr = in.readString();
                this.buyer_name = in.readString();
                this.buyer_phone = in.readString();
                this.pay_time = in.readString();
                this.shop_send_time = in.readString();
                this.finish_time = in.readString();
                this.is_integral = in.readInt();
                this.integral_num = in.readString();
                this.order_type = in.readString();
                this.order_pay = in.readString();
                this.member_id = in.readInt();
                this.member_name = in.readString();
                this.member_image = in.readString();
                this.shop = new ArrayList<ShopBean>();
                in.readList(this.shop, ShopBean.class.getClassLoader());
            }

            public static final Parcelable.Creator<OrderListBean> CREATOR = new Parcelable.Creator<OrderListBean>() {
                @Override
                public OrderListBean createFromParcel(Parcel source) {
                    return new OrderListBean(source);
                }

                @Override
                public OrderListBean[] newArray(int size) {
                    return new OrderListBean[size];
                }
            };
        }
    }
}
