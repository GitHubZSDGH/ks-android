package hlks.hualiangou.com.ks_android.modle.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目名称:
 * 类描述:
 * 创建时间:2017/11/28
 */
public class PopupAddressSelectorBean extends NoRegisterRespon {



    private MsgBean msg;

    public MsgBean getMsg() {
        return msg;
    }

    public void setMsg(MsgBean msg) {
        this.msg = msg;
    }

    public static class MsgBean implements Parcelable {
        private List<RegionBean> region;

        public List<RegionBean> getRegion() {
            return region;
        }

        public void setRegion(List<RegionBean> region) {
            this.region = region;
        }

        public static class RegionBean implements Parcelable {


            private String region_id;
            private String local_name;
            private List<CRegionBean> c_region;

            public String getRegion_id() {
                return region_id;
            }

            public void setRegion_id(String region_id) {
                this.region_id = region_id;
            }

            public String getLocal_name() {
                return local_name;
            }

            public void setLocal_name(String local_name) {
                this.local_name = local_name;
            }

            public List<CRegionBean> getC_region() {
                return c_region;
            }

            public void setC_region(List<CRegionBean> c_region) {
                this.c_region = c_region;
            }

            public static class CRegionBean implements Parcelable {


                private String region_id;
                private String local_name;
                private List<ZRegionBean> z_region;

                public String getRegion_id() {
                    return region_id;
                }

                public void setRegion_id(String region_id) {
                    this.region_id = region_id;
                }

                public String getLocal_name() {
                    return local_name;
                }

                public void setLocal_name(String local_name) {
                    this.local_name = local_name;
                }

                public List<ZRegionBean> getZ_region() {
                    return z_region;
                }

                public void setZ_region(List<ZRegionBean> z_region) {
                    this.z_region = z_region;
                }

                public static class ZRegionBean implements Parcelable {
                    public ZRegionBean(String region_id, String local_name) {
                        this.region_id = region_id;
                        this.local_name = local_name;
                    }




                    private String region_id;
                    private String local_name;

                    public String getRegion_id() {
                        return region_id;
                    }

                    public void setRegion_id(String region_id) {
                        this.region_id = region_id;
                    }

                    public String getLocal_name() {
                        return local_name;
                    }

                    public void setLocal_name(String local_name) {
                        this.local_name = local_name;
                    }

                    @Override
                    public int describeContents() {
                        return 0;
                    }

                    @Override
                    public void writeToParcel(Parcel dest, int flags) {
                        dest.writeString(this.region_id);
                        dest.writeString(this.local_name);
                    }

                    protected ZRegionBean(Parcel in) {
                        this.region_id = in.readString();
                        this.local_name = in.readString();
                    }

                    public static final Creator<ZRegionBean> CREATOR = new Creator<ZRegionBean>() {
                        @Override
                        public ZRegionBean createFromParcel(Parcel source) {
                            return new ZRegionBean(source);
                        }

                        @Override
                        public ZRegionBean[] newArray(int size) {
                            return new ZRegionBean[size];
                        }
                    };
                }

                @Override
                public int describeContents() {
                    return 0;
                }

                @Override
                public void writeToParcel(Parcel dest, int flags) {
                    dest.writeString(this.region_id);
                    dest.writeString(this.local_name);
                    dest.writeList(this.z_region);
                }

                public CRegionBean() {
                }

                protected CRegionBean(Parcel in) {
                    this.region_id = in.readString();
                    this.local_name = in.readString();
                    this.z_region = new ArrayList<ZRegionBean>();
                    in.readList(this.z_region, ZRegionBean.class.getClassLoader());
                }

                public static final Creator<CRegionBean> CREATOR = new Creator<CRegionBean>() {
                    @Override
                    public CRegionBean createFromParcel(Parcel source) {
                        return new CRegionBean(source);
                    }

                    @Override
                    public CRegionBean[] newArray(int size) {
                        return new CRegionBean[size];
                    }
                };
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.region_id);
                dest.writeString(this.local_name);
                dest.writeList(this.c_region);
            }

            public RegionBean() {
            }

            protected RegionBean(Parcel in) {
                this.region_id = in.readString();
                this.local_name = in.readString();
                this.c_region = new ArrayList<CRegionBean>();
                in.readList(this.c_region, CRegionBean.class.getClassLoader());
            }

            public static final Creator<RegionBean> CREATOR = new Creator<RegionBean>() {
                @Override
                public RegionBean createFromParcel(Parcel source) {
                    return new RegionBean(source);
                }

                @Override
                public RegionBean[] newArray(int size) {
                    return new RegionBean[size];
                }
            };
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeList(this.region);
        }

        public MsgBean() {
        }

        protected MsgBean(Parcel in) {
            this.region = new ArrayList<RegionBean>();
            in.readList(this.region, RegionBean.class.getClassLoader());
        }

        public static final Parcelable.Creator<MsgBean> CREATOR = new Parcelable.Creator<MsgBean>() {
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
