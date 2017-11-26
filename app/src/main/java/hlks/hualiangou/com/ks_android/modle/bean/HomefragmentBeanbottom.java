package hlks.hualiangou.com.ks_android.modle.bean;

import java.util.List;

/**
 * 项目名称:
 * 类描述:
 * 创建人:lenovo
 * 创建时间:2017/11/15
 * 修改人:
 * 修改内容:
 */
public class HomefragmentBeanbottom extends NoRegisterRespon {


    /**
     * msg : {"shop_host":{"shop":[{"id":"5","shop_name":"商品测试4","shop_end_money":"104","shop_start_money":"404","image_path":"/upload/20171027/7ba6150d3271554021432643b30917d7.jpg","comment":0},{"id":"9","shop_name":"商品测试8","shop_end_money":"104","shop_start_money":"404","image_path":"/upload/20171027/7ba6150d3271554021432643b30917d7.jpg","comment":0}],"page_num":8}}
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
         * shop_host : {"shop":[{"id":"5","shop_name":"商品测试4","shop_end_money":"104","shop_start_money":"404","image_path":"/upload/20171027/7ba6150d3271554021432643b30917d7.jpg","comment":0},{"id":"9","shop_name":"商品测试8","shop_end_money":"104","shop_start_money":"404","image_path":"/upload/20171027/7ba6150d3271554021432643b30917d7.jpg","comment":0}],"page_num":8}
         */

        private ShopHostBean shop_host;

        public ShopHostBean getShop_host() {
            return shop_host;
        }

        public void setShop_host(ShopHostBean shop_host) {
            this.shop_host = shop_host;
        }

        public static class ShopHostBean {
            /**
             * shop : [{"id":"5","shop_name":"商品测试4","shop_end_money":"104","shop_start_money":"404","image_path":"/upload/20171027/7ba6150d3271554021432643b30917d7.jpg","comment":0},{"id":"9","shop_name":"商品测试8","shop_end_money":"104","shop_start_money":"404","image_path":"/upload/20171027/7ba6150d3271554021432643b30917d7.jpg","comment":0}]
             * page_num : 8
             */

            private int page_num;
            private List<ShopBean> shop;

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
                 * id : 5
                 * shop_name : 商品测试4
                 * shop_end_money : 104
                 * shop_start_money : 404
                 * image_path : /upload/20171027/7ba6150d3271554021432643b30917d7.jpg
                 * comment : 0
                 */

                private String id;
                private String shop_name;
                private String shop_end_money;
                private String shop_start_money;
                private String image_path;
                private int comment;

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

                public String getShop_start_money() {
                    return shop_start_money;
                }

                public void setShop_start_money(String shop_start_money) {
                    this.shop_start_money = shop_start_money;
                }

                public String getImage_path() {
                    return image_path;
                }

                public void setImage_path(String image_path) {
                    this.image_path = image_path;
                }

                public int getComment() {
                    return comment;
                }

                public void setComment(int comment) {
                    this.comment = comment;
                }
            }
        }
    }
}
