package hlks.hualiangou.com.ks_android.bean;

import com.google.gson.annotations.Expose;

import java.util.List;

/**
 * 项目名称:
 * 类描述:
 * 创建时间:2017/11/26
 */
public class UserAdressBean {

    /**
     * ret : 0
     * msg : {"user_addr":[{"id":"1","addr":"慈云寺","receiver":"牛广华","receiver_phone":"13065003966","area":"北京","city":"北京市","domain":"朝阳区","is_default":"0"},{"id":"2","addr":"慈云寺住邦","receiver":"牛广华","receiver_phone":"13065003966","area":"北京","city":"北京市","domain":"朝阳区","is_default":"0"}]}
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
        private List<UserAddrBean> user_addr;

        public List<UserAddrBean> getUser_addr() {
            return user_addr;
        }

        public void setUser_addr(List<UserAddrBean> user_addr) {
            this.user_addr = user_addr;
        }

        public static class UserAddrBean {
            /**
             * id : 1
             * addr : 慈云寺
             * receiver : 牛广华
             * receiver_phone : 13065003966
             * area : 北京
             * city : 北京市
             * domain : 朝阳区
             * is_default : 0
             */
            @Expose
            private boolean isChecked;

            public boolean isChecked() {
                return isChecked;
            }

            public void setChecked(boolean checked) {
                isChecked = checked;
            }

            private String id;
            private String addr;
            private String receiver;
            private String receiver_phone;
            private String area;
            private String city;
            private String domain;
            private String is_default;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getAddr() {
                return addr;
            }

            public void setAddr(String addr) {
                this.addr = addr;
            }

            public String getReceiver() {
                return receiver;
            }

            public void setReceiver(String receiver) {
                this.receiver = receiver;
            }

            public String getReceiver_phone() {
                return receiver_phone;
            }

            public void setReceiver_phone(String receiver_phone) {
                this.receiver_phone = receiver_phone;
            }

            public String getArea() {
                return area;
            }

            public void setArea(String area) {
                this.area = area;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getDomain() {
                return domain;
            }

            public void setDomain(String domain) {
                this.domain = domain;
            }

            public String getIs_default() {
                return is_default;
            }

            public void setIs_default(String is_default) {
                this.is_default = is_default;
            }
        }
    }
}
