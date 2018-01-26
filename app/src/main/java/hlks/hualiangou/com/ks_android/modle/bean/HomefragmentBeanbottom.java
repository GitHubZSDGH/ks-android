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
     * msg : {"shop_host":{"shop":[{"id":10,"shop_name":"雅诗兰黛（Estee Lauder）肌初赋活原生液150ml","shop_end_money":"639.00","shop_start_money":"799.99","image_path":"/upload/20171201/d5a8d1baae7bc6eb1f4bc54256a30c36.jpg","sale_num":0,"is_integral":0,"integral":"0","shop_staff":0,"comment":0},{"id":11,"shop_name":"资生堂（Shiseido） Fino浸透美容液发膜 深层修护 持续滋养 230g/瓶","shop_end_money":"48.00","shop_start_money":"89.90","image_path":"/upload/20171201/9fab0ac6f8976b63c08ff9f87d939444.jpg","sale_num":0,"is_integral":0,"integral":"0","shop_staff":0,"comment":0},{"id":36,"shop_name":"一叶子补水保湿面膜清爽控油收缩毛孔深层锁水细肤面膜贴专柜正品","shop_end_money":"149.00","shop_start_money":"265.00","image_path":"/upload/20171204/64a8b4b9c65bc329d2e24eb6dd392e47.jpg","sale_num":0,"is_integral":0,"integral":"0","shop_staff":0,"comment":0},{"id":38,"shop_name":"资生堂水之密语海盐弹润 紧致沐浴乳沐浴露","shop_end_money":"59.00","shop_start_money":"68.00","image_path":"/upload/20171204//c06e5fdf10589a14623472c6fb22a073.jpg","sale_num":0,"is_integral":0,"integral":"0","shop_staff":0,"comment":0},{"id":45,"shop_name":"雪地靴女短筒韩版面包鞋女冬百搭短靴防滑保暖学生真皮加厚靴子棉","shop_end_money":"148.00","shop_start_money":"538.00","image_path":"/upload/20171204/4cd8c44e4eaf1d554abe48f5c42f13ff.jpg","sale_num":0,"is_integral":0,"integral":"0","shop_staff":0,"comment":0},{"id":47,"shop_name":"杰克丹尼（Jack Daniel`s）洋酒 美国田纳西州","shop_end_money":"152.00","shop_start_money":"168.00","image_path":"/upload/20171204/71553d7737b5577be49e9ff97b0887e8.jpg","sale_num":0,"is_integral":0,"integral":"0","shop_staff":0,"comment":0},{"id":48,"shop_name":"伊利 金典 有机纯牛奶 250ml*12 天赐有机 WWF","shop_end_money":"64.60","shop_start_money":"78.00","image_path":"/upload/20171204/28cb5ef6f92026078bf351f41e476c2f.jpg","sale_num":0,"is_integral":0,"integral":"0","shop_staff":0,"comment":0},{"id":49,"shop_name":"红功夫 熟冻麻辣小龙虾 25-32只 4-6钱/只 1.5kg（净虾重750g）盒装 海鲜水产","shop_end_money":"67.10","shop_start_money":"1.00","image_path":"/upload/20171204/ec8eaa660e0acad6cc95fed1fb73d8ca.jpg","sale_num":0,"is_integral":0,"integral":"0","shop_staff":0,"comment":0},{"id":52,"shop_name":"九华粮品 土鸡蛋 40枚 山林散养 柴鸡蛋 笨鸡蛋 月子蛋 破损包赔","shop_end_money":"69.80","shop_start_money":"1.00","image_path":"/upload/20171204/94600d2e669b5afc710e114b022dfa7e.jpg","sale_num":0,"is_integral":0,"integral":"0","shop_staff":0,"comment":0}],"page_num":1}}
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
         * shop_host : {"shop":[{"id":10,"shop_name":"雅诗兰黛（Estee Lauder）肌初赋活原生液150ml","shop_end_money":"639.00","shop_start_money":"799.99","image_path":"/upload/20171201/d5a8d1baae7bc6eb1f4bc54256a30c36.jpg","sale_num":0,"is_integral":0,"integral":"0","shop_staff":0,"comment":0},{"id":11,"shop_name":"资生堂（Shiseido） Fino浸透美容液发膜 深层修护 持续滋养 230g/瓶","shop_end_money":"48.00","shop_start_money":"89.90","image_path":"/upload/20171201/9fab0ac6f8976b63c08ff9f87d939444.jpg","sale_num":0,"is_integral":0,"integral":"0","shop_staff":0,"comment":0},{"id":36,"shop_name":"一叶子补水保湿面膜清爽控油收缩毛孔深层锁水细肤面膜贴专柜正品","shop_end_money":"149.00","shop_start_money":"265.00","image_path":"/upload/20171204/64a8b4b9c65bc329d2e24eb6dd392e47.jpg","sale_num":0,"is_integral":0,"integral":"0","shop_staff":0,"comment":0},{"id":38,"shop_name":"资生堂水之密语海盐弹润 紧致沐浴乳沐浴露","shop_end_money":"59.00","shop_start_money":"68.00","image_path":"/upload/20171204//c06e5fdf10589a14623472c6fb22a073.jpg","sale_num":0,"is_integral":0,"integral":"0","shop_staff":0,"comment":0},{"id":45,"shop_name":"雪地靴女短筒韩版面包鞋女冬百搭短靴防滑保暖学生真皮加厚靴子棉","shop_end_money":"148.00","shop_start_money":"538.00","image_path":"/upload/20171204/4cd8c44e4eaf1d554abe48f5c42f13ff.jpg","sale_num":0,"is_integral":0,"integral":"0","shop_staff":0,"comment":0},{"id":47,"shop_name":"杰克丹尼（Jack Daniel`s）洋酒 美国田纳西州","shop_end_money":"152.00","shop_start_money":"168.00","image_path":"/upload/20171204/71553d7737b5577be49e9ff97b0887e8.jpg","sale_num":0,"is_integral":0,"integral":"0","shop_staff":0,"comment":0},{"id":48,"shop_name":"伊利 金典 有机纯牛奶 250ml*12 天赐有机 WWF","shop_end_money":"64.60","shop_start_money":"78.00","image_path":"/upload/20171204/28cb5ef6f92026078bf351f41e476c2f.jpg","sale_num":0,"is_integral":0,"integral":"0","shop_staff":0,"comment":0},{"id":49,"shop_name":"红功夫 熟冻麻辣小龙虾 25-32只 4-6钱/只 1.5kg（净虾重750g）盒装 海鲜水产","shop_end_money":"67.10","shop_start_money":"1.00","image_path":"/upload/20171204/ec8eaa660e0acad6cc95fed1fb73d8ca.jpg","sale_num":0,"is_integral":0,"integral":"0","shop_staff":0,"comment":0},{"id":52,"shop_name":"九华粮品 土鸡蛋 40枚 山林散养 柴鸡蛋 笨鸡蛋 月子蛋 破损包赔","shop_end_money":"69.80","shop_start_money":"1.00","image_path":"/upload/20171204/94600d2e669b5afc710e114b022dfa7e.jpg","sale_num":0,"is_integral":0,"integral":"0","shop_staff":0,"comment":0}],"page_num":1}
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
             * shop : [{"id":10,"shop_name":"雅诗兰黛（Estee Lauder）肌初赋活原生液150ml","shop_end_money":"639.00","shop_start_money":"799.99","image_path":"/upload/20171201/d5a8d1baae7bc6eb1f4bc54256a30c36.jpg","sale_num":0,"is_integral":0,"integral":"0","shop_staff":0,"comment":0},{"id":11,"shop_name":"资生堂（Shiseido） Fino浸透美容液发膜 深层修护 持续滋养 230g/瓶","shop_end_money":"48.00","shop_start_money":"89.90","image_path":"/upload/20171201/9fab0ac6f8976b63c08ff9f87d939444.jpg","sale_num":0,"is_integral":0,"integral":"0","shop_staff":0,"comment":0},{"id":36,"shop_name":"一叶子补水保湿面膜清爽控油收缩毛孔深层锁水细肤面膜贴专柜正品","shop_end_money":"149.00","shop_start_money":"265.00","image_path":"/upload/20171204/64a8b4b9c65bc329d2e24eb6dd392e47.jpg","sale_num":0,"is_integral":0,"integral":"0","shop_staff":0,"comment":0},{"id":38,"shop_name":"资生堂水之密语海盐弹润 紧致沐浴乳沐浴露","shop_end_money":"59.00","shop_start_money":"68.00","image_path":"/upload/20171204//c06e5fdf10589a14623472c6fb22a073.jpg","sale_num":0,"is_integral":0,"integral":"0","shop_staff":0,"comment":0},{"id":45,"shop_name":"雪地靴女短筒韩版面包鞋女冬百搭短靴防滑保暖学生真皮加厚靴子棉","shop_end_money":"148.00","shop_start_money":"538.00","image_path":"/upload/20171204/4cd8c44e4eaf1d554abe48f5c42f13ff.jpg","sale_num":0,"is_integral":0,"integral":"0","shop_staff":0,"comment":0},{"id":47,"shop_name":"杰克丹尼（Jack Daniel`s）洋酒 美国田纳西州","shop_end_money":"152.00","shop_start_money":"168.00","image_path":"/upload/20171204/71553d7737b5577be49e9ff97b0887e8.jpg","sale_num":0,"is_integral":0,"integral":"0","shop_staff":0,"comment":0},{"id":48,"shop_name":"伊利 金典 有机纯牛奶 250ml*12 天赐有机 WWF","shop_end_money":"64.60","shop_start_money":"78.00","image_path":"/upload/20171204/28cb5ef6f92026078bf351f41e476c2f.jpg","sale_num":0,"is_integral":0,"integral":"0","shop_staff":0,"comment":0},{"id":49,"shop_name":"红功夫 熟冻麻辣小龙虾 25-32只 4-6钱/只 1.5kg（净虾重750g）盒装 海鲜水产","shop_end_money":"67.10","shop_start_money":"1.00","image_path":"/upload/20171204/ec8eaa660e0acad6cc95fed1fb73d8ca.jpg","sale_num":0,"is_integral":0,"integral":"0","shop_staff":0,"comment":0},{"id":52,"shop_name":"九华粮品 土鸡蛋 40枚 山林散养 柴鸡蛋 笨鸡蛋 月子蛋 破损包赔","shop_end_money":"69.80","shop_start_money":"1.00","image_path":"/upload/20171204/94600d2e669b5afc710e114b022dfa7e.jpg","sale_num":0,"is_integral":0,"integral":"0","shop_staff":0,"comment":0}]
             * page_num : 1
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
                 * id : 10
                 * shop_name : 雅诗兰黛（Estee Lauder）肌初赋活原生液150ml
                 * shop_end_money : 639.00
                 * shop_start_money : 799.99
                 * image_path : /upload/20171201/d5a8d1baae7bc6eb1f4bc54256a30c36.jpg
                 * sale_num : 0
                 * is_integral : 0
                 * integral : 0
                 * shop_staff : 0
                 * comment : 0
                 */

                private int id;
                private String shop_name;
                private String shop_end_money;
                private String shop_start_money;
                private String image_path;
                private int sale_num;
                private int is_integral;
                private String integral;
                private int shop_staff;
                private int comment;

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

                public int getSale_num() {
                    return sale_num;
                }

                public void setSale_num(int sale_num) {
                    this.sale_num = sale_num;
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

                public int getShop_staff() {
                    return shop_staff;
                }

                public void setShop_staff(int shop_staff) {
                    this.shop_staff = shop_staff;
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
