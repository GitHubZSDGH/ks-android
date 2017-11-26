package hlks.hualiangou.com.ks_android.modle.bean;

import java.util.List;

/**
 * 项目名称:
 * 类描述:
 * 创建人:lenovo
 * 创建时间:2017/11/17
 * 修改人:
 * 修改内容:
 */
public class ClassIfygragmentBean extends NoRegisterRespon{


    private List<MsgBean> msg;

    public List<MsgBean> getMsg() {
        return msg;
    }

    public void setMsg(List<MsgBean> msg) {
        this.msg = msg;
    }

    public static class MsgBean {
        /**
         * id : 29
         * categroy_name : 牛广华
         * two : [{"id":"31","categroy_name":"牛广","three":[{"id":"35","image":"/upload/20171122/ad67885424a417d9861d5826d89973b4.jpg","categroy_name":"华"}]}]
         */

        private String id;
        private String categroy_name;
        private List<TwoBean> two;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getCategroy_name() {
            return categroy_name;
        }

        public void setCategroy_name(String categroy_name) {
            this.categroy_name = categroy_name;
        }

        public List<TwoBean> getTwo() {
            return two;
        }

        public void setTwo(List<TwoBean> two) {
            this.two = two;
        }

        public static class TwoBean {
            /**
             * id : 31
             * categroy_name : 牛广
             * three : [{"id":"35","image":"/upload/20171122/ad67885424a417d9861d5826d89973b4.jpg","categroy_name":"华"}]
             */

            private String id;
            private String categroy_name;
            private List<ThreeBean> three;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getCategroy_name() {
                return categroy_name;
            }

            public void setCategroy_name(String categroy_name) {
                this.categroy_name = categroy_name;
            }

            public List<ThreeBean> getThree() {
                return three;
            }

            public void setThree(List<ThreeBean> three) {
                this.three = three;
            }

            public static class ThreeBean {
                /**
                 * id : 35
                 * image : /upload/20171122/ad67885424a417d9861d5826d89973b4.jpg
                 * categroy_name : 华
                 */

                private String id;
                private String image;
                private String categroy_name;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getImage() {
                    return image;
                }

                public void setImage(String image) {
                    this.image = image;
                }

                public String getCategroy_name() {
                    return categroy_name;
                }

                public void setCategroy_name(String categroy_name) {
                    this.categroy_name = categroy_name;
                }
            }
        }
    }
}
