package hlks.hualiangou.com.ks_android.modle.bean;

import java.util.List;

/**
 * 项目名称:
 * 类描述:
 * 创建时间:2017/11/25
 */
public class DetailPagesBean extends NoRegisterRespon {


    /**
     * msg : {"id":"4","shop_name":"商品测试3","shop_sketch":"","categroy_id":"35","shop_start_money":"403","shop_end_money":"103","sale_num":"3","freight":"10","member_id":1,"member_name":"华联可溯","member_image":"","spec_one":"分类规格1","spec_two":"分类规格2","shop_image":[{"path":"/upload/20171124/f0648f59353b2e4808365cef02253c2f.jpg"}],"shop_features":[],"shop_spec":[{"spec_one_name":"红色","spec_two":[{"id":"173","spec_two_name":"L","stock_num":"50"},{"id":"172","spec_two_name":"XL","stock_num":"50"},{"id":"171","spec_two_name":"XXL","stock_num":"50"}]},{"spec_one_name":"绿色","spec_two":[{"id":"176","spec_two_name":"L","stock_num":"50"},{"id":"177","spec_two_name":"M","stock_num":"50"},{"id":"175","spec_two_name":"XL","stock_num":"50"},{"id":"174","spec_two_name":"XXL","stock_num":"50"}]}]}
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
         * id : 4
         * shop_name : 商品测试3
         * shop_sketch :
         * categroy_id : 35
         * shop_start_money : 403
         * shop_end_money : 103
         * sale_num : 3
         * freight : 10
         * member_id : 1
         * member_name : 华联可溯
         * member_image :
         * spec_one : 分类规格1
         * spec_two : 分类规格2
         * shop_image : [{"path":"/upload/20171124/f0648f59353b2e4808365cef02253c2f.jpg"}]
         * shop_features : []
         * shop_spec : [{"spec_one_name":"红色","spec_two":[{"id":"173","spec_two_name":"L","stock_num":"50"},{"id":"172","spec_two_name":"XL","stock_num":"50"},{"id":"171","spec_two_name":"XXL","stock_num":"50"}]},{"spec_one_name":"绿色","spec_two":[{"id":"176","spec_two_name":"L","stock_num":"50"},{"id":"177","spec_two_name":"M","stock_num":"50"},{"id":"175","spec_two_name":"XL","stock_num":"50"},{"id":"174","spec_two_name":"XXL","stock_num":"50"}]}]
         */

        private String id;
        private String shop_name;
        private String shop_sketch;
        private String categroy_id;
        private String shop_start_money;
        private String shop_end_money;
        private String sale_num;
        private String freight;
        private int member_id;
        private String member_name;
        private String member_image;
        private String spec_one;
        private String spec_two;
        private List<ShopImageBean> shop_image;
        private List<?> shop_features;
        private List<ShopSpecBean> shop_spec;

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

        public String getShop_sketch() {
            return shop_sketch;
        }

        public void setShop_sketch(String shop_sketch) {
            this.shop_sketch = shop_sketch;
        }

        public String getCategroy_id() {
            return categroy_id;
        }

        public void setCategroy_id(String categroy_id) {
            this.categroy_id = categroy_id;
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

        public String getSale_num() {
            return sale_num;
        }

        public void setSale_num(String sale_num) {
            this.sale_num = sale_num;
        }

        public String getFreight() {
            return freight;
        }

        public void setFreight(String freight) {
            this.freight = freight;
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

        public String getSpec_one() {
            return spec_one;
        }

        public void setSpec_one(String spec_one) {
            this.spec_one = spec_one;
        }

        public String getSpec_two() {
            return spec_two;
        }

        public void setSpec_two(String spec_two) {
            this.spec_two = spec_two;
        }

        public List<ShopImageBean> getShop_image() {
            return shop_image;
        }

        public void setShop_image(List<ShopImageBean> shop_image) {
            this.shop_image = shop_image;
        }

        public List<?> getShop_features() {
            return shop_features;
        }

        public void setShop_features(List<?> shop_features) {
            this.shop_features = shop_features;
        }

        public List<ShopSpecBean> getShop_spec() {
            return shop_spec;
        }

        public void setShop_spec(List<ShopSpecBean> shop_spec) {
            this.shop_spec = shop_spec;
        }

        public static class ShopImageBean {
            /**
             * path : /upload/20171124/f0648f59353b2e4808365cef02253c2f.jpg
             */

            private String path;

            public String getPath() {
                return path;
            }

            public void setPath(String path) {
                this.path = path;
            }
        }

        public static class ShopSpecBean {
            /**
             * spec_one_name : 红色
             * spec_two : [{"id":"173","spec_two_name":"L","stock_num":"50"},{"id":"172","spec_two_name":"XL","stock_num":"50"},{"id":"171","spec_two_name":"XXL","stock_num":"50"}]
             */

            private String spec_one_name;
            private List<SpecTwoBean> spec_two;

            public String getSpec_one_name() {
                return spec_one_name;
            }

            public void setSpec_one_name(String spec_one_name) {
                this.spec_one_name = spec_one_name;
            }

            public List<SpecTwoBean> getSpec_two() {
                return spec_two;
            }

            public void setSpec_two(List<SpecTwoBean> spec_two) {
                this.spec_two = spec_two;
            }

            public static class SpecTwoBean {
                /**
                 * id : 173
                 * spec_two_name : L
                 * stock_num : 50
                 */

                private String id;
                private String spec_two_name;
                private String stock_num;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getSpec_two_name() {
                    return spec_two_name;
                }

                public void setSpec_two_name(String spec_two_name) {
                    this.spec_two_name = spec_two_name;
                }

                public String getStock_num() {
                    return stock_num;
                }

                public void setStock_num(String stock_num) {
                    this.stock_num = stock_num;
                }
            }
        }
    }
}
