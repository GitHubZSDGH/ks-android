package hlks.hualiangou.com.ks_android.modle.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/10/13.
 */

public class LoginRespon implements Serializable {

    /**
     * ret : 0
     * msg : {"username":"13717608740","staffNum":"76","headIcon":"http://shop.elliotngok.xin","webUrl":"http://shop.elliotngok.xin","token":"736f5a35871d344aa7490e92c09af808"}
     */

    private int ret;
    private MsgBean msg;

    public int getRet() {
        return ret;
    }

    public void setRet(int ret) {
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
         * username : 13717608740
         * staffNum : 76
         * headIcon : http://shop.elliotngok.xin
         * webUrl : http://shop.elliotngok.xin
         * token : 736f5a35871d344aa7490e92c09af808
         */

        private String username;
        private String staffNum;
        private String headIcon;
        private String webUrl;
        private String token;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getStaffNum() {
            return staffNum;
        }

        public void setStaffNum(String staffNum) {
            this.staffNum = staffNum;
        }

        public String getHeadIcon() {
            return headIcon;
        }

        public void setHeadIcon(String headIcon) {
            this.headIcon = headIcon;
        }

        public String getWebUrl() {
            return webUrl;
        }

        public void setWebUrl(String webUrl) {
            this.webUrl = webUrl;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }
}
