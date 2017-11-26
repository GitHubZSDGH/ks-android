package hlks.hualiangou.com.ks_android.utils.encryption;




import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

/**
 * 字符串操作工具包
 * Created by lzq on 2016/3/21.
 */
public class StringUtil {

    private final static Pattern emailer = Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");
    private static final String TAG = StringUtil.class.getSimpleName();

    /**
     * 判断给定字符串是否空白串。
     * 空白串是指由空格、制表符、回车符、换行符组成的字符串
     * 若输入字符串为null或空字符串，返回true
     *
     * @param input
     * @return boolean
     */
    public static boolean isEmpty(String input) {
        if (input == null || "".equals(input) || input.trim().length() == 0)
            return true;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c != ' ' && c != '\t' && c != '\r' && c != '\n') {
                return false;
            }
        }
        return true;
    }

    /**
     * 字符串只包含数字或字母
     */
    public static boolean isOnlyHasDigitOrLetter(String str) {
        for (int i = 0; i < str.length(); i++) { //循环遍历字符串
            char c = str.charAt(i);
            if (c < '0' || c > '9') {
                if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 遍历List集合以标点符号隔开
     */

    public static String listToString(List list, String symbol) {
        StringBuilder sb = new StringBuilder();
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                if (i < list.size() - 1) {
                    sb.append(list.get(i) + symbol);
                } else {
                    sb.append(list.get(i));
                }
            }
        }
        return sb.toString();
    }

    /**
     * 判断是不是一个合法的电子邮件地址
     *
     * @param email
     * @return
     */
    public static boolean isEmail(String email) {
        if (isEmpty(email))
            return false;
        return emailer.matcher(email).matches();
    }

    /**
     * 是否是指定字符
     *
     * @param text
     * @return
     */
    public static boolean isMyRegex(String text) {
        //账号只能输入特定的字符
        String regEx = "[^-._@0123456789abcdefghigklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ]";
        Pattern p = Pattern.compile(regEx);
        if (isEmpty(text))
            return false;
        else
            return p.matcher(text).matches();
    }

    /**
     * 验证手机格式
     */
    public static boolean isMobile(String mobiles) {
        /*
         * 移动：134、135、136、137、138、139、150、151、157(TD)、158、159、187、188
		 * 联通：130、131、132、152、155、156、185、186
		 * 电信：133、153、180、189、（1349卫通）
		 * 新增的4G手机号段：
         * 中国电信分到新号段170,177,联通分到了176,移动分到了178号段.
		 * 总结起来就是第一位必定为1，第二位必定为3或5或8，其他位置的可以为0-9
		 */
        // "[1]"代表第1位为数字1，"[3578]"代表第二位可以为3、5、7、8中的一个，"\\d{9}"代表后面是可以是0～9的数字，有9位。
        String telRegex = "[1][3578]\\d{9}";
        if (isEmpty(mobiles))
            return false;
        else
            return mobiles.matches(telRegex);
    }

    /**
     * 将时间戳转为字符串 ，格式：yyyy.MM.dd  星期几
     */
    public static String getSection(long cc_time) {
        String re_StrTime = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd  EEEE", Locale.CHINA);
//		对于创建SimpleDateFormat传入的参数：EEEE代表星期，如“星期四”；MMMM代表中文月份，如“十一月”；MM代表月份，如“11”；
//		yyyy代表年份，如“2010”；dd代表天，如“25”
        // 例如：cc_time=1291778220
        long lcc_time = 0;
        try {
            lcc_time = Long.valueOf(cc_time);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        re_StrTime = sdf.format(new Date(lcc_time));
        return re_StrTime;
    }

    private final static ThreadLocal<SimpleDateFormat> dateFormater = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault());
        }
    };
    private final static ThreadLocal<SimpleDateFormat> dateFormater2 = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        }
    };
    private final static ThreadLocal<SimpleDateFormat> dateFormater3 = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy", Locale.getDefault());
        }
    };

    /**
     * 将字符串转位日期类型
     *
     * @param sdate
     * @return
     */
    public static Date toDate(String sdate) {
        try {
            return dateFormater.get().parse(sdate);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * @param lo 毫秒数
     * @return String yyyy-MM-dd HH:mm:ss
     * @Description: long类型转换成日期
     */
    public static String longToDate(long lo) {
        Date date = new Date(lo);
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sd.format(date);
    }

    /**
     * 以友好的方式显示时间
     *
     * @param sdate
     * @return
     */
    public static String friendly_time(String sdate) {

//        Date time = toDate(sdate);

        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date time = null;
        try {
            time = sf.parse(sdate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (time == null) {
            return "Unknown";
        }
        String ftime = "";

        Calendar cal = Calendar.getInstance();

        // 判断是否是同一天
        String curDate = dateFormater2.get().format(cal.getTime());
        String paramDate = dateFormater2.get().format(time);
        if (curDate.equals(paramDate)) {
            int hour = (int) ((cal.getTimeInMillis() - time.getTime()) / 3600000);
            if (hour == 0)
                ftime = Math.max(
                        (cal.getTimeInMillis() - time.getTime()) / 60000, 1)
                        + "分钟前";
            else
                ftime = hour + "小时前";
            return ftime;
        }

        double lt = (double) time.getTime() / 86400000;
        //long ct = cal.getTimeInMillis() / 86400000;
        double ct = (double) cal.getTime().getTime() / 86400000;
        //int days = (int) (ct - lt);
        double days = ct - lt;
        if (/*days == 0*/days >= 0 && days < 1) {
            int hour = (int) ((cal.getTimeInMillis() - time.getTime()) / 3600000);
            if (hour == 0)
                ftime = Math.max(
                        (cal.getTimeInMillis() - time.getTime()) / 60000, 1)
                        + "分钟前";
            else
                ftime = hour + "小时前";
        } else if (/*days == 1*/days >= 1 && days < 2) {
            ftime = "昨天";
        } else if (/*days == 2*/days >= 2 && days < 3) {
            ftime = "前天";
        } else if (/*days > 2 && days < 31*/days >= 3 && days < 31) {
            ftime = ((int) days) + "天前";
        } else if (/*days >= 31 && days <= 2 * 31*/days >= 31 && days < 2 * 31) {
            ftime = "一个月前";
        } else if (/*days > 2 * 31 && days <= 3 * 31*/days >= 2 * 31 && days < 3 * 31) {
            ftime = "2个月前";
        } else if (/*days > 3 * 31 && days <= 4 * 31*/days >= 3 * 31 && days < 4 * 31) {
            ftime = "3个月前";
        } else {
            ftime = dateFormater2.get().format(time);
        }
        //LogUtil.w("时间","lt="+lt+"; ct="+ct+"; days="+days);
        return ftime;
    }

    /**
     * 将时间戳转为代表"距现在多久之前"的字符串
     *
     * @param timeStr 时间戳
     * @return
     */
    public static String getStandardDate(String timeStr) throws ParseException {

        StringBuffer sb = new StringBuffer();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d1 = sf.parse(timeStr);
        long t = d1.getTime();

//        long t = Long.parseLong(timeStr);
        long time = System.currentTimeMillis() - (t * 1000);
        long mill = (long) Math.ceil(time / 1000);//秒前

        long minute = (long) Math.ceil(time / 60 / 1000.0f);// 分钟前

        long hour = (long) Math.ceil(time / 60 / 60 / 1000.0f);// 小时

        long day = (long) Math.ceil(time / 24 / 60 / 60 / 1000.0f);// 天前

        if (day - 1 > 0) {
            sb.append(day + "天");
        } else if (hour - 1 > 0) {
            if (hour >= 24) {
                sb.append("1天");
            } else {
                sb.append(hour + "小时");
            }
        } else if (minute - 1 > 0) {
            if (minute == 60) {
                sb.append("1小时");
            } else {
                sb.append(minute + "分钟");
            }
        } else if (mill - 1 > 0) {
            if (mill == 60) {
                sb.append("1分钟");
            } else {
                sb.append(mill + "秒");
            }
        } else {
            sb.append("刚刚");
        }
        if (!sb.toString().equals("刚刚")) {
            sb.append("前");
        }
        return sb.toString();
    }

    /* 替换掉指定的字符 */
    public static String replaceChar(String sdate) {
        String tempStr = sdate.replace('T', ' ').replace('Z', '\u0000').trim();
        return tempStr;
    }


    /**
     * 我的足迹显示时间
     *
     * @param sdate
     * @return
     */
    public static String friendly_time2(String sdate) {


//        Date time = toDate(sdate);
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date time = null;
        try {
            time = sf.parse(sdate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (time == null) {
            return "Unknown";
        }
        String ftime = "";

        Calendar cal = Calendar.getInstance();


        double lt = (double) time.getTime() / 86400000;
        //long ct = cal.getTimeInMillis() / 86400000;
        double ct = (double) cal.getTime().getTime() / 86400000;

        //int days = (int) (ct - lt);
        double days = ct - lt;
        if (days < 1) {
            ftime = "今天";
        } else if (/*days == 1*/days >= 1 && days < 2) {
            ftime = "昨天";
        } else if (/*days == 2*/days >= 2 && days < 3) {
            ftime = "前天";
        } else if (/*days > 2 && days < 31*/days >= 3 && days < 31) {
            ftime = ((int) days) + "天前";
        } else if (/*days >= 31 && days <= 2 * 31*/days >= 31 && days < 2 * 31) {
            ftime = "一个月前";
        } else if (/*days > 2 * 31 && days <= 3 * 31*/days >= 2 * 31 && days < 3 * 31) {
            ftime = "2个月前";
        } else if (/*days > 3 * 31 && days <= 4 * 31*/days >= 3 * 31 && days < 4 * 31) {
            ftime = "3个月前";
        } else {
            ftime = dateFormater2.get().format(time);
        }

        return ftime;
    }
    //系统拽出的判断时间方法，正确
    public static String friendlyTime(String sdate) {

//        Date time = toDate(sdate);
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date time = null;
        try {
            time = sf.parse(sdate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //获取time距离当前的秒数
        int ct = (int)((System.currentTimeMillis() - time.getTime())/1000);

        if(ct == 0) {
            return "刚刚";
        }

        if(ct > 0 && ct < 60) {
            return ct + "秒前";
        }

        if(ct >= 60 && ct < 3600) {
            return Math.max(ct / 60,1) + "分钟前";
        }
        if(ct >= 3600 && ct < 86400)
            return ct / 3600 + "小时前";
        if(ct >= 86400 && ct < 2592000){ //86400 * 30
            int day = ct / 86400 ;
            return day + "天前";
        }
        if(ct >= 2592000 && ct < 31104000) { //86400 * 30
            return ct / 2592000 + "月前";
        }
        return ct / 31104000 + "年前";
    }


    //极光推送时间判断
    public static Boolean JpushTime(String sdate) {

//        Date time = toDate(sdate);
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date time = null;
        try {
            time = sf.parse(sdate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //获取time距离当前的秒数
        int ct = (int)((System.currentTimeMillis() - time.getTime())/1000);

        if(ct >=2* 86400 ){
            return  true;
        }
        return false;
    }


    public static String friendly_timesss(String sdate) {

        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date time = null;
        try {
            time = sf.parse(sdate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (time == null) {
            return "Unknown";
        }
        String ftime = "";

        Calendar cal = Calendar.getInstance();

        // 判断是否是同一天
        String curDate = dateFormater2.get().format(cal.getTime());
        String paramDate = dateFormater2.get().format(time);
        if (curDate.equals(paramDate)) {
//            int hour = (int) ((cal.getTimeInMillis() - time.getTime()) / 3600000);
//            if (hour == 0)
//                ftime = Math.max(
//                        (cal.getTimeInMillis() - time.getTime()) / 60000, 1)
//                        + "分钟前";
//            else
//                ftime = hour + "小时前";
            ftime = "今天";
            return ftime;
        }

        double lt = (double) time.getTime() / 86400000;
        //long ct = cal.getTimeInMillis() / 86400000;
        double ct = (double) cal.getTime().getTime() / 86400000;
        //int days = (int) (ct - lt);
        double days = ct - lt;
        if (/*days == 0*/days < 1) {
//            int hour = (int) ((cal.getTimeInMillis() - time.getTime()) / 3600000);
//            if (hour == 0)
//                ftime = Math.max(
//                        (cal.getTimeInMillis() - time.getTime()) / 60000, 1)
//                        + "分钟前";
//            else
//                ftime = hour + "小时前";
            ftime = "今天";
        } else if (/*days == 1*/days >= 1 && days < 2) {
            ftime = "昨天";
        } else if (/*days == 2*/days >= 2 && days < 3) {
            ftime = "前天";
        } else if (/*days > 2 && days < 31*/days >= 3 && days < 31) {
            ftime = ((int) days) + "天前";
        } else if (/*days >= 31 && days <= 2 * 31*/days >= 31 && days < 2 * 31) {
            ftime = "一个月前";
        } else if (/*days > 2 * 31 && days <= 3 * 31*/days >= 2 * 31 && days < 3 * 31) {
            ftime = "2个月前";
        } else if (/*days > 3 * 31 && days <= 4 * 31*/days >= 3 * 31 && days < 4 * 31) {
            ftime = "3个月前";
        } else {
            ftime = "今天";
//            ftime = dateFormater2.get().format(time);
        }
        //LogUtil.w("时间","lt="+lt+"; ct="+ct+"; days="+days);
        return ftime;
    }


    public static String friendly_timess(String sdate) {

        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date time = null;
        try {
            time = sf.parse(sdate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (time == null) {
            return "Unknown";
        }

        String ftime = "";

        Calendar cal = Calendar.getInstance();
        double lt = (double) time.getTime() / 43200000;
        double ct = (double) cal.getTime().getTime() / 43200000;
        double days = ct - lt;
        if (days >= 0 && days < 1) {
            ftime = "今天";
        } else if (days > 1 && days < 2) {
            ftime = "昨天";
        }else {
            ftime = dateFormater2.get().format(time);
        }
        return ftime;
    }


    public static String rmdtabfragment(String sdate) {

        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date time = null;
        try {
            time = sf.parse(sdate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (time == null) {
            return "Unknown";
        }
        String ftime = "";

        Calendar cal = Calendar.getInstance();

        // 判断是否是同一天
        String curDate = dateFormater2.get().format(cal.getTime());
        String paramDate = dateFormater2.get().format(time);
        if (curDate.equals(paramDate)) {
            int hour = (int) ((cal.getTimeInMillis() - time.getTime()) / 3600000);
            if (hour == 0)
                ftime = Math.max(
                        (cal.getTimeInMillis() - time.getTime()) / 60000, 1)
                        + "分钟前";
            else
                ftime = hour + "小时前";
            return ftime;
        }

        double lt = (double) time.getTime() / 43200000;
        //long ct = cal.getTimeInMillis() / 86400000;
        double ct = (double) cal.getTime().getTime() / 43200000;
        //int days = (int) (ct - lt);
        double days = ct - lt;
        if (/*days == 0*/days >= 0 && days < 1) {
            int hour = (int) ((cal.getTimeInMillis() - time.getTime()) / 3600000);
            if (hour == 0){
                ftime = Math.max((cal.getTimeInMillis() - time.getTime()) / 60000, 1)
                        + "分钟前";
            }else{
                ftime = hour + "小时前";
            }
        } else {
            ftime = sdate.substring(5, 16);
        }
        return ftime;
    }

    public static String rmdtabfragment2(String sdate) {

        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date time = null;
        try {
            time = sf.parse(sdate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (time == null) {
            return "Unknown";
        }
        String ftime = "";

        Calendar cal = Calendar.getInstance();

        // 判断是否是同一天
        String curDate = dateFormater2.get().format(cal.getTime());
        String paramDate = dateFormater2.get().format(time);
        if (curDate.equals(paramDate)) {
//            int hour = (int) ((cal.getTimeInMillis() - time.getTime()) / 3600000);
//            if (hour == 0)
//                ftime = Math.max(
//                        (cal.getTimeInMillis() - time.getTime()) / 60000, 1)
//                        + "分钟前";
//            else
//                ftime = hour + "小时前";
            ftime = "今天";
            return ftime;
        }

        double lt = (double) time.getTime() / 43200000;
        //long ct = cal.getTimeInMillis() / 86400000;
        double ct = (double) cal.getTime().getTime() / 43200000;
        //int days = (int) (ct - lt);
        double days = ct - lt;
        if (/*days == 0*/days >= 0 && days < 1) {
//            int hour = (int) ((cal.getTimeInMillis() - time.getTime()) / 3600000);
//            if (hour == 0){
//                ftime = Math.max((cal.getTimeInMillis() - time.getTime()) / 60000, 1)
//                        + "分钟前";
//            }else{
//                ftime = hour + "小时前";
//            }
            ftime = "今天";
        } else {
            ftime = sdate.substring(5, 16);
        }
        return ftime;
    }

    /* 以友好的方式显示年龄 */
    public static String friend_age(String age) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //得到当前的年份
        String cYear = sdf.format(new Date()).substring(0, 4);
        //得到出生的年份
        int birthYear = Integer.parseInt(cYear) - Integer.parseInt(age);
        if (birthYear < 1970) {
            return "70前";
        } else if (birthYear >= 1970 && birthYear < 1975) {
            return "70后";
        } else if (birthYear >= 1975 && birthYear < 1980) {
            return "75后";
        } else if (birthYear >= 1980 && birthYear < 1985) {
            return "80后";
        } else if (birthYear >= 1985 && birthYear < 1990) {
            return "85后";
        } else if (birthYear >= 1990) {
            return "90后";
        } else {
            return null;
        }
    }

    /**
     * 以友好的方式显示时间
     *
     * @param date
     * @return
     */
    public static String friendly_time(Date date) {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        return friendly_time(f.format(date));
    }

    /**
     * 判断给定字符串时间是否为今日
     *
     * @param sdate
     * @return boolean
     */
    public static boolean isToday(String sdate) {
        boolean b = false;
        Date time = toDate(sdate);
        Date today = new Date();
        if (time != null) {
            String nowDate = dateFormater2.get().format(today);
            String timeDate = dateFormater2.get().format(time);
            if (nowDate.equals(timeDate)) {
                b = true;
            }
        }
        return b;
    }

    /**
     * 返回long类型的今天的日期
     *
     * @return
     */
    public static long getToday() {
        Calendar cal = Calendar.getInstance();
        String curDate = dateFormater2.get().format(cal.getTime());
        curDate = curDate.replace("-", "");
        return Long.parseLong(curDate);
    }

    public static String stringForTime(int timeMs) {
        if (timeMs <= 0 || timeMs >= 24 * 60 * 60 * 1000) {
            return "00:00";
        }
        int totalSeconds = timeMs / 1000;
        int seconds = totalSeconds % 60;
        int minutes = (totalSeconds / 60) % 60;
        int hours = totalSeconds / 3600;
        StringBuilder mFormatBuilder = new StringBuilder();
        Formatter mFormatter = new Formatter(mFormatBuilder, Locale.getDefault());
        if (hours > 0) {
            return mFormatter.format("%d:%02d:%02d", hours, minutes, seconds).toString();
        } else {
            return mFormatter.format("%02d:%02d", minutes, seconds).toString();
        }
    }

    /*
     * 将时间戳转为字符串 ，格式：MM-dd HH:mm:ss
	 */
    public static String getNewsDetailsDate(String cc_time) {
        String re_StrTime = null;
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd HH:mm:ss");
        // 例如：cc_time=1291778220
        long lcc_time = Long.valueOf(cc_time);
        re_StrTime = sdf.format(new Date(lcc_time * 1000L));
        return re_StrTime;
    }

    /**
     * 将字符串转为时间戳
     */
    public static String getTime() {
        String re_time = null;
        long currentTime = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
        Date d;
        d = new Date(currentTime);
        long l = d.getTime();
        String str = String.valueOf(l);
        re_time = str.substring(0, 10);
        return re_time;
    }

    /**
     * 字符串转整数
     *
     * @param str
     * @param defValue
     * @return
     */
    public static int toInt(String str, int defValue) {
        try {
            return Integer.parseInt(str);
        } catch (Exception e) {
        }
        return defValue;
    }

    /**
     * 对象转整数
     *
     * @param obj
     * @return 转换异常返回 0
     */
    public static int toInt(Object obj) {
        if (obj == null) return 0;
        return toInt(obj.toString(), 0);
    }

    /**
     * 对象转整数
     *
     * @param obj
     * @return 转换异常返回 0
     */
    public static long toLong(String obj) {
        try {
            return Long.parseLong(obj);
        } catch (Exception e) {
        }
        return 0;
    }

    /**
     * 字符串转布尔值
     *
     * @param b
     * @return 转换异常返回 false
     */
    public static boolean toBool(String b) {
        try {
            return Boolean.parseBoolean(b);
        } catch (Exception e) {
        }
        return false;
    }

    /**
     * 将一个InputStream流转换成字符串
     *
     * @param is
     * @return
     */
    public static String toConvertString(InputStream is) {
        StringBuffer res = new StringBuffer();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader read = new BufferedReader(isr);
        try {
            String line;
            line = read.readLine();
            while (line != null) {
                res.append(line);
                line = read.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != read) {
                    read.close();
                    read = null;
                }
                if (null != isr) {
                    isr.close();
                    isr = null;
                }
                if (null != is) {
                    is.close();
                    is = null;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return res.toString();
    }

    /**
     * 格式化 电子化移交完成率 保留一位
     */

    public static String formateRate(String rateStr) {
        if (rateStr.indexOf(".") != -1) {
            //获取小数点的位置
            int num = 0;
            num = rateStr.indexOf(".");

            //获取小数点后面的数字 是否有两位 不足两位补足一位
            String dianAfter = rateStr.substring(0, num + 1);
            String afterData = rateStr.replace(dianAfter, "");
            if (afterData.length() < 2) {
                afterData = afterData + "0";
            } else {
                afterData = afterData;
            }
            return rateStr.substring(0, num) + "." + afterData.substring(0, 1);
        } else {
            if (rateStr == "1") {
                return "100";
            } else {
                return rateStr;
            }
        }
    }
    /**
     * MD5加码。32位
     *
     * @param inStr
     * @return
     */
    public static String MD5(String inStr) {
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
            char[] charArray = inStr.toCharArray();
            byte[] byteArray = new byte[charArray.length];

            for (int i = 0; i < charArray.length; i++)
                byteArray[i] = (byte) charArray[i];

            byte[] md5Bytes = md5.digest(byteArray);

            StringBuffer hexValue = new StringBuffer();

            for (int i = 0; i < md5Bytes.length; i++) {
                int val = ((int) md5Bytes[i]) & 0xff;
                if (val < 16)
                    hexValue.append("0");
                hexValue.append(Integer.toHexString(val));
            }

            return hexValue.toString();
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
            return "";
        }
    }

    public static String Html2Text(String inputString) {
        String htmlStr = inputString; // 含html标签的字符串
        String textStr = "";
        Pattern p_script;
        java.util.regex.Matcher m_script;
        Pattern p_style;
        java.util.regex.Matcher m_style;
        Pattern p_html;
        java.util.regex.Matcher m_html;

        try {
            String regEx_script = "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>"; // 定义script的正则表达式{或<script[^>]*?>[\\s\\S]*?<\\/script>
            // }
            String regEx_style = "<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>"; // 定义style的正则表达式{或<style[^>]*?>[\\s\\S]*?<\\/style>
            // }
            String regEx_html = "<[^>]+>"; // 定义HTML标签的正则表达式

            p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
            m_script = p_script.matcher(htmlStr);
            htmlStr = m_script.replaceAll(""); // 过滤script标签

            p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
            m_style = p_style.matcher(htmlStr);
            htmlStr = m_style.replaceAll(""); // 过滤style标签

            p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
            m_html = p_html.matcher(htmlStr);
            htmlStr = m_html.replaceAll(""); // 过滤html标签

            textStr = htmlStr;

        } catch (Exception e) {
            System.err.println("Html2Text: " + e.getMessage());
        }

        return textStr;// 返回文本字符串
    }
}
