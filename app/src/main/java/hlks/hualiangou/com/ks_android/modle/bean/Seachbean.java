package hlks.hualiangou.com.ks_android.modle.bean;

import java.util.List;

/**
 * 项目名称:
 * 类描述:
 * 创建人:lenovo
 * 创建时间:2017/11/18
 * 修改人:
 * 修改内容:
 */
public class Seachbean extends NoRegisterRespon {


    /**
     * msg : {"shop":[{"id":36,"shop_name":"一叶子补水保湿面膜清爽控油收缩毛孔深层锁水细肤面膜贴专柜正品","shop_end_money":"149.00","image_path":"/upload/20171204/64a8b4b9c65bc329d2e24eb6dd392e47.jpg","comment_num":0,"shop_staff":0,"is_integral":0,"integral":"0","good_commont":"0"}],"page":"1","page_num":1}
     */

    private MsgBean msg;

    public MsgBean getMsg() {
        return msg;
    }

    public void setMsg(MsgBean msg) {
        this.msg = msg;
    }

    public static class MsgBean {
        /**
         * shop : [{"id":36,"shop_name":"一叶子补水保湿面膜清爽控油收缩毛孔深层锁水细肤面膜贴专柜正品","shop_end_money":"149.00","image_path":"/upload/20171204/64a8b4b9c65bc329d2e24eb6dd392e47.jpg","comment_num":0,"shop_staff":0,"is_integral":0,"integral":"0","good_commont":"0"}]
         * page : 1
         * page_num : 1
         */

        private String page;
        private int page_num;
        private List<ShopBean> shop;

        public String getPage() {
            return page;
        }

        public void setPage(String page) {
            this.page = page;
        }

        public int getPage_num() {
            return page_num;
        }

        public void setPage_num(int page_num) {
            this.page_num = page_num;
        }

        public List<ShopBean> getShop() {
            return shop;
        }

        public void setShop(List<ShopBean> shop) {
            this.shop = shop;
        }

        public static class ShopBean {
            /**
             * id : 36
             * shop_name : 一叶子补水保湿面膜清爽控油收缩毛孔深层锁水细肤面膜贴专柜正品
             * shop_end_money : 149.00
             * image_path : /upload/20171204/64a8b4b9c65bc329d2e24eb6dd392e47.jpg
             * comment_num : 0
             * shop_staff : 0
             * is_integral : 0
             * integral : 0
             * good_commont : 0
             */

            private int id;
            private String shop_name;
            private String shop_end_money;
            private String image_path;
            private int comment_num;
            private int shop_staff;
            private int is_integral;
            private String integral;
            private String good_commont;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getShop_name() {
                return shop_name;
            }

            public void setShop_name(String shop_name) {
                this.shop_name = shop_name;
            }

            public String getShop_end_money() {
                return shop_end_money;
            }

            public void setShop_end_money(String shop_end_money) {
                this.shop_end_money = shop_end_money;
            }

            public String getImage_path() {
                return image_path;
            }

            public void setImage_path(String image_path) {
                this.image_path = image_path;
            }

            public int getComment_num() {
                return comment_num;
            }

            public void setComment_num(int comment_num) {
                this.comment_num = comment_num;
            }

            public int getShop_staff() {
                return shop_staff;
            }

            public void setShop_staff(int shop_staff) {
                this.shop_staff = shop_staff;
            }

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

            public String getGood_commont() {
                return good_commont;
            }

            public void setGood_commont(String good_commont) {
                this.good_commont = good_commont;
            }
        }
    }
}
