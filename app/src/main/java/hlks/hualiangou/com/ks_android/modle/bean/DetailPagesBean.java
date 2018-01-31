package hlks.hualiangou.com.ks_android.modle.bean;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目名称:
 * 类描述:
 * 创建时间:2017/11/25
 */
public class DetailPagesBean extends NoRegisterRespon {


    /**
     * msg : {"id":"6","shop_name":"微软（Microsoft）","shop_sketch":"","categroy_id":"5","shop_banner":"/upload/20171201/eca87d64f20a5557bcc44055c3a0c89c.jpg","shop_start_money":"6200.00","shop_end_money":"7288.00","sale_num":"0","freight":"5","member_id":1,"member_name":"华联可溯","member_image":"","spec_one":"尺寸","spec_two":"系统","shop_image":[{"path":"/upload/20171201/a75fa0724cadf34554001a63ca735409.jpg"},{"path":"/upload/20171201/6770c01605755ce4b246d612aed5606e.jpg"},{"path":"/upload/20171201/6770c01605755ce4b246d612aed5606e.jpg"}],"shop_features":[{"path":"/upload/20171201/e96cc655722fa7a539814f7dc716b18f.jpg"},{"path":"/upload/20171201/b5ba33e99f80f21c2fc3f109bfd05913.jpg"}],"shop_spec":[{"spec_one_name":"12.3","spec_two":[{"id":"8","spec_two_name":"4G+128G","stock_num":"80"},{"id":"9","spec_two_name":"8G+128G","stock_num":"60"}]}]}
     */

    private MsgBean msg;

    public MsgBean getMsg() {
        return msg;
    }

    public void setMsg(MsgBean msg) {
        this.msg = msg;
    }

    public static class MsgBean implements Parcelable {
        /**
         * id : 6
         * shop_name : 微软（Microsoft）
         * shop_sketch :
         * categroy_id : 5
         * shop_banner : /upload/20171201/eca87d64f20a5557bcc44055c3a0c89c.jpg
         * shop_start_money : 6200.00
         * shop_end_money : 7288.00
         * sale_num : 0
         * freight : 5
         * member_id : 1
         * member_name : 华联可溯
         * member_image :
         * spec_one : 尺寸
         * spec_two : 系统
         * shop_image : [{"path":"/upload/20171201/a75fa0724cadf34554001a63ca735409.jpg"},{"path":"/upload/20171201/6770c01605755ce4b246d612aed5606e.jpg"},{"path":"/upload/20171201/6770c01605755ce4b246d612aed5606e.jpg"}]
         * shop_features : [{"path":"/upload/20171201/e96cc655722fa7a539814f7dc716b18f.jpg"},{"path":"/upload/20171201/b5ba33e99f80f21c2fc3f109bfd05913.jpg"}]
         * shop_spec : [{"spec_one_name":"12.3","spec_two":[{"id":"8","spec_two_name":"4G+128G","stock_num":"80"},{"id":"9","spec_two_name":"8G+128G","stock_num":"60"}]}]
         */

        private String id;
        private String shop_name;
        private String shop_sketch;
        private String categroy_id;
        private String shop_banner;
        private String shop_start_money;
        private String shop_end_money;
        private String sale_num;
        private String freight;
        private int member_id;
        private String member_name;
        private String member_image;
        private String spec_one;
        private String spec_two;
        private String is_integral;
        private String integral;

        public String getIs_integral() {
            return is_integral;
        }

        public void setIs_integral(String is_integral) {
            this.is_integral = is_integral;
        }

        public String getIntegral() {
            return integral;
        }

        public void setIntegral(String integral) {
            this.integral = integral;
        }

        private List<ShopImageBean> shop_image;
        private List<ShopFeaturesBean> shop_features;
        private List<ShopSpecBean> shop_spec;

        public String getShop_num() {
            return shop_num;
        }

        public void setShop_num(String shop_num) {
            this.shop_num = shop_num;
        }

        @Expose
        private String shop_num;

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

        public String getShop_banner() {
            return shop_banner;
        }

        public void setShop_banner(String shop_banner) {
            this.shop_banner = shop_banner;
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

        public List<ShopFeaturesBean> getShop_features() {
            return shop_features;
        }

        public void setShop_features(List<ShopFeaturesBean> shop_features) {
            this.shop_features = shop_features;
        }

        public List<ShopSpecBean> getShop_spec() {
            return shop_spec;
        }

        public void setShop_spec(List<ShopSpecBean> shop_spec) {
            this.shop_spec = shop_spec;
        }

        public static class ShopImageBean implements Parcelable {
            /**
             * path : /upload/20171201/a75fa0724cadf34554001a63ca735409.jpg
             */

            private String path;

            public String getPath() {
                return path;
            }

            public void setPath(String path) {
                this.path = path;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.path);
            }

            public ShopImageBean() {
            }

            protected ShopImageBean(Parcel in) {
                this.path = in.readString();
            }

            public static final Creator<ShopImageBean> CREATOR = new Creator<ShopImageBean>() {
                @Override
                public ShopImageBean createFromParcel(Parcel source) {
                    return new ShopImageBean(source);
                }

                @Override
                public ShopImageBean[] newArray(int size) {
                    return new ShopImageBean[size];
                }
            };
        }

        public static class ShopFeaturesBean implements Parcelable {
            /**
             * path : /upload/20171201/e96cc655722fa7a539814f7dc716b18f.jpg
             */

            private String path;

            public String getPath() {
                return path;
            }

            public void setPath(String path) {
                this.path = path;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.path);
            }

            public ShopFeaturesBean() {
            }

            protected ShopFeaturesBean(Parcel in) {
                this.path = in.readString();
            }

            public static final Creator<ShopFeaturesBean> CREATOR = new Creator<ShopFeaturesBean>() {
                @Override
                public ShopFeaturesBean createFromParcel(Parcel source) {
                    return new ShopFeaturesBean(source);
                }

                @Override
                public ShopFeaturesBean[] newArray(int size) {
                    return new ShopFeaturesBean[size];
                }
            };
        }

        public static class ShopSpecBean implements Parcelable {
            /**
             * spec_one_name : 12.3
             * spec_two : [{"id":"8","spec_two_name":"4G+128G","stock_num":"80"},{"id":"9","spec_two_name":"8G+128G","stock_num":"60"}]
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

            public static class SpecTwoBean implements Parcelable {
                /**
                 * id : 8
                 * spec_two_name : 4G+128G
                 * stock_num : 80
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

                @Override
                public int describeContents() {
                    return 0;
                }

                @Override
                public void writeToParcel(Parcel dest, int flags) {
                    dest.writeString(this.id);
                    dest.writeString(this.spec_two_name);
                    dest.writeString(this.stock_num);
                }

                public SpecTwoBean() {
                }

                protected SpecTwoBean(Parcel in) {
                    this.id = in.readString();
                    this.spec_two_name = in.readString();
                    this.stock_num = in.readString();
                }

                public static final Creator<SpecTwoBean> CREATOR = new Creator<SpecTwoBean>() {
                    @Override
                    public SpecTwoBean createFromParcel(Parcel source) {
                        return new SpecTwoBean(source);
                    }

                    @Override
                    public SpecTwoBean[] newArray(int size) {
                        return new SpecTwoBean[size];
                    }
                };
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.spec_one_name);
                dest.writeList(this.spec_two);
            }

            public ShopSpecBean() {
            }

            protected ShopSpecBean(Parcel in) {
                this.spec_one_name = in.readString();
                this.spec_two = new ArrayList<SpecTwoBean>();
                in.readList(this.spec_two, SpecTwoBean.class.getClassLoader());
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
            dest.writeString(this.id);
            dest.writeString(this.shop_name);
            dest.writeString(this.shop_sketch);
            dest.writeString(this.categroy_id);
            dest.writeString(this.shop_banner);
            dest.writeString(this.shop_start_money);
            dest.writeString(this.shop_end_money);
            dest.writeString(this.sale_num);
            dest.writeString(this.freight);
            dest.writeInt(this.member_id);
            dest.writeString(this.member_name);
            dest.writeString(this.member_image);
            dest.writeString(this.spec_one);
            dest.writeString(this.spec_two);
            dest.writeString(this.is_integral);
            dest.writeString(this.integral);
            dest.writeTypedList(this.shop_image);
            dest.writeTypedList(this.shop_features);
            dest.writeTypedList(this.shop_spec);
            dest.writeString(this.shop_num);
        }

        protected MsgBean(Parcel in) {
            this.id = in.readString();
            this.shop_name = in.readString();
            this.shop_sketch = in.readString();
            this.categroy_id = in.readString();
            this.shop_banner = in.readString();
            this.shop_start_money = in.readString();
            this.shop_end_money = in.readString();
            this.sale_num = in.readString();
            this.freight = in.readString();
            this.member_id = in.readInt();
            this.member_name = in.readString();
            this.member_image = in.readString();
            this.spec_one = in.readString();
            this.spec_two = in.readString();
            this.is_integral = in.readString();
            this.integral = in.readString();
            this.shop_image = in.createTypedArrayList(ShopImageBean.CREATOR);
            this.shop_features = in.createTypedArrayList(ShopFeaturesBean.CREATOR);
            this.shop_spec = in.createTypedArrayList(ShopSpecBean.CREATOR);
            this.shop_num = in.readString();
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
