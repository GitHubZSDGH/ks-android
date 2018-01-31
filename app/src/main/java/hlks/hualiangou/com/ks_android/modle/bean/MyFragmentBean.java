package hlks.hualiangou.com.ks_android.modle.bean;

/**
 * Created by lenovo on 2018/2/1.
 */

public class MyFragmentBean {

    /**
     * ret : 0
     * msg : {"wait_pay":9,"wait_ship":1,"wait_rece":1,"no_common":0,"refund":1,"integral":"10000"}
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
        /**
         * wait_pay : 9
         * wait_ship : 1
         * wait_rece : 1
         * no_common : 0
         * refund : 1
         * integral : 10000
         */

        private int wait_pay;
        private int wait_ship;
        private int wait_rece;
        private int no_common;
        private int refund;
        private String integral;

        public int getWait_pay() {
            return wait_pay;
        }

        public void setWait_pay(int wait_pay) {
            this.wait_pay = wait_pay;
        }

        public int getWait_ship() {
            return wait_ship;
        }

        public void setWait_ship(int wait_ship) {
            this.wait_ship = wait_ship;
        }

        public int getWait_rece() {
            return wait_rece;
        }

        public void setWait_rece(int wait_rece) {
            this.wait_rece = wait_rece;
        }

        public int getNo_common() {
            return no_common;
        }

        public void setNo_common(int no_common) {
            this.no_common = no_common;
        }

        public int getRefund() {
            return refund;
        }

        public void setRefund(int refund) {
            this.refund = refund;
        }

        public String getIntegral() {
            return integral;
        }

        public void setIntegral(String integral) {
            this.integral = integral;
        }
    }
}
