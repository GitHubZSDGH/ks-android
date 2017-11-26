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
     * msg : {"shop":[{"id":"2","shop_name":"测试商品","shop_end_money":"102","image_path":"/upload/20171027/7ba6150d3271554021432643b30917d7.jpg","comment_num":"9","shop_staff":"0","good_commont":0},{"id":"4","shop_name":"商品测试3","shop_end_money":"103","image_path":"/upload/20171027/7ba6150d3271554021432643b30917d7.jpg","comment_num":"3","shop_staff":"0","good_commont":0},{"id":"5","shop_name":"商品测试4","shop_end_money":"104","image_path":"/upload/20171027/7ba6150d3271554021432643b30917d7.jpg","comment_num":"4","shop_staff":"0","good_commont":0}],"page":"1","page_num":6}
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
         * shop : [{"id":"2","shop_name":"测试商品","shop_end_money":"102","image_path":"/upload/20171027/7ba6150d3271554021432643b30917d7.jpg","comment_num":"9","shop_staff":"0","good_commont":0},{"id":"4","shop_name":"商品测试3","shop_end_money":"103","image_path":"/upload/20171027/7ba6150d3271554021432643b30917d7.jpg","comment_num":"3","shop_staff":"0","good_commont":0},{"id":"5","shop_name":"商品测试4","shop_end_money":"104","image_path":"/upload/20171027/7ba6150d3271554021432643b30917d7.jpg","comment_num":"4","shop_staff":"0","good_commont":0}]
         * page : 1
         * page_num : 6
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
             * id : 2
             * shop_name : 测试商品
             * shop_end_money : 102
             * image_path : /upload/20171027/7ba6150d3271554021432643b30917d7.jpg
             * comment_num : 9
             * shop_staff : 0
             * good_commont : 0
             */

            private String id;
            private String shop_name;
            private String shop_end_money;
            private String image_path;
            private String comment_num;
            private String shop_staff;
            private int good_commont;

            public String getId() {
                return id;
            }

            public void setId(String id) {
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

            public String getComment_num() {
                return comment_num;
            }

            public void setComment_num(String comment_num) {
                this.comment_num = comment_num;
            }

            public String getShop_staff() {
                return shop_staff;
            }

            public void setShop_staff(String shop_staff) {
                this.shop_staff = shop_staff;
            }

            public int getGood_commont() {
                return good_commont;
            }

            public void setGood_commont(int good_commont) {
                this.good_commont = good_commont;
            }
        }
    }
}
