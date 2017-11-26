package hlks.hualiangou.com.ks_android.modle.bean;

import com.google.gson.annotations.SerializedName;

/**
 * 项目名称:
 * 类描述:
 * 创建人:lenovo
 * 创建时间:2017/11/14
 * 修改人:
 * 修改内容:
 */
public class LoginBean extends NoRegisterRespon {


    @Override
    public String toString() {
        return "LoginBean{" +
                "msgX=" + msgX +
                '}';
    }

    /**
     * msg : {"username":"15933269431","staffNum":"135","headIcon":"http://shop.elliotngok.xin","webUrl":"http://shop.elliotngok.xin","token":"c44bb538fb4a4c205605b2efe82aa2a6"}
     */

    @SerializedName("msg")
    private MsgBean msgX;

    public MsgBean getMsgX() {
        return msgX;
    }

    public void setMsgX(MsgBean msgX) {
        this.msgX = msgX;
    }

    public static class MsgBean {
        /**
         * username : 15933269431
         * staffNum : 135
         * headIcon : http://shop.elliotngok.xin
         * webUrl : http://shop.elliotngok.xin
         * token : c44bb538fb4a4c205605b2efe82aa2a6
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
