package hlks.hualiangou.com.ks_android.bean;

import java.util.List;

/**
 * Created by lenovo on 2018/2/1.
 */

public class MyFootBean {

    /**
     * ret : 0
     * msg : {"time":[{"key":"今天","value":"2018-02-01"},{"key":"昨天","value":"2018-01-31"},{"key":"01月30日","value":"2018-01-30"},{"key":"01月29日","value":"2018-01-29"},{"key":"01月28日","value":"2018-01-28"},{"key":"01月27日","value":"2018-01-27"},{"key":"01月26日","value":"2018-01-26"},{"key":"01月25日","value":"2018-01-25"},{"key":"01月24日","value":"2018-01-24"},{"key":"01月23日","value":"2018-01-23"},{"key":"01月22日","value":"2018-01-22"},{"key":"01月21日","value":"2018-01-21"},{"key":"01月20日","value":"2018-01-20"},{"key":"01月19日","value":"2018-01-19"},{"key":"01月18日","value":"2018-01-18"},{"key":"01月17日","value":"2018-01-17"},{"key":"01月16日","value":"2018-01-16"},{"key":"01月15日","value":"2018-01-15"},{"key":"01月14日","value":"2018-01-14"},{"key":"01月13日","value":"2018-01-13"},{"key":"01月12日","value":"2018-01-12"},{"key":"01月11日","value":"2018-01-11"},{"key":"01月10日","value":"2018-01-10"},{"key":"01月09日","value":"2018-01-09"},{"key":"01月08日","value":"2018-01-08"},{"key":"01月07日","value":"2018-01-07"},{"key":"01月06日","value":"2018-01-06"},{"key":"01月05日","value":"2018-01-05"},{"key":"01月04日","value":"2018-01-04"},{"key":"01月03日","value":"2018-01-03"},{"key":"01月02日","value":"2018-01-02"}],"result":[{"history_id":43,"shop_id":47,"create_time":"2018-02-01 11:15:06","shop_name":"杰克丹尼（Jack Daniel`s）洋酒 美国田纳西州","shop_end_money":"152.00","image_path":"/upload/20171204/71553d7737b5577be49e9ff97b0887e8.jpg","is_integral":0,"integral":"0"},{"history_id":44,"shop_id":54,"create_time":"2018-02-01 11:15:58","shop_name":"进口精选牛油果 4个装 单果约130-150g 新鲜水果","shop_end_money":"21.00","image_path":"/upload/20171204/bcffd0cf40834adb89407737cbf3c0a3.jpg","is_integral":0,"integral":"0"}]}
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
         * tablayout展示的时间的集合
         */
        private List<TimeBean> time;
        /**
         * 时间对应的Fragment的数据的集合
         * 根据
         * TODO 创建时间判断
         */
        private List<ResultBean> result;

        public List<TimeBean> getTime() {
            return time;
        }

        public void setTime(List<TimeBean> time) {
            this.time = time;
        }

        public List<ResultBean> getResult() {
            return result;
        }

        public void setResult(List<ResultBean> result) {
            this.result = result;
        }

        public static class TimeBean {
            /**
             * key : 今天
             * value : 2018-02-01
             */
            /**
             * key是参数 展示在tablayout上
             * valve 是是参数 表示日期
             */
            private String key;
            private String value;

            public String getKey() {
                return key;
            }

            public void setKey(String key) {
                this.key = key;
            }

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }
        }

        public static class ResultBean {
            /**
             * history_id : 43
             * shop_id : 47
             * create_time : 2018-02-01 11:15:06
             * shop_name : 杰克丹尼（Jack Daniel`s）洋酒 美国田纳西州
             * shop_end_money : 152.00
             * image_path : /upload/20171204/71553d7737b5577be49e9ff97b0887e8.jpg
             * is_integral : 0
             * integral : 0
             */
            /**
             * 删除时应用
             */
            private int history_id;
            /**
             * 商品id
             */
            private int shop_id;
            /**
             * 创建时间
             * TODO create_time
             */
            private String create_time;
            /**
             * 商品名称
             */
            private String shop_name;
            /**
             * 商品价格
             */
            private String shop_end_money;
            /**
             * 商品图标
             */
            private String image_path;
            /**
             * 是否可积分兑换
             * 0 - N
             * 1 - Y
             */
            private int is_integral;
            /**
             * 积分数量
             */
            private String integral;

            public int getHistory_id() {
                return history_id;
            }

            public void setHistory_id(int history_id) {
                this.history_id = history_id;
            }

            public int getShop_id() {
                return shop_id;
            }

            public void setShop_id(int shop_id) {
                this.shop_id = shop_id;
            }

            public String getCreate_time() {
                return create_time;
            }

            public void setCreate_time(String create_time) {
                this.create_time = create_time;
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

            public String getImage_path() {
                return image_path;
            }

            public void setImage_path(String image_path) {
                this.image_path = image_path;
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
        }
    }
}
