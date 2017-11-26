package hlks.hualiangou.com.ks_android.utils.encryption;

import android.content.Context;
import android.content.SharedPreferences;


/**
 * 用户信息存储类
 * Created by lzq on 2016/5/10.
 */
public class Preferences {

    private static final String KEY_USER_IS_ANONY = "isanony";//是否为匿名状态，因为匿名的话无法评论
    private static final String KEY_USER_ACCOUNT = "account";
    private static final String KEY_USER_PASSWORD = "password";
    private static final String KEY_USER_TOKEN = "token";
    private static final String KEY_USER_TOKEN2 = "token2";//同步设备的时候token单独存储,就是为了退出的时候更换
    private static final String KEY_USER_HEAD_IMAGE_PATH = "headimage";
    private static final String KEY_USER_HEAD_IMAGE = "headimage01"; // 认证头像
    private static final String KEY_USER_IMAGE_ICON = "headimageicon02"; // 认证上传照片
    private static final String KEY_USER_HEAD_IMAGE_ICON = "headimageicon01"; // 认证照片
    private static final String KEY_USER_NICKNAME = "nickname";
    private static final String KEY_USER_SIGN = "sign";
    private static final String KEY_USER_PHONE = "phone";
    private static final String KEY_USER_LOCATION = "location";
    private static final String KEY_USER_LOCATIONS = "locations";
    private static final String KEY_USER_AGE = "age";
    private static final String KEY_USER_SEX = "sex";
    private static final String KEY_USER_MARRIAGE = "marriage";
    private static final String KEY_USER_INTEREST = "interest";
    private static final String KEY_USER_COMPANY = "company";
    private static final String KEY_USER_SCHOOL = "school";
    private static final String KEY_USER_JOB = "job";
    private static final String KEY_USER_ID = "id";
    private static final String KEY_USER_ID2 = "id2";//设备同步的UserID,就是为了退出的时候更换
    private static final String KEY_ACCOUNT_ID = "account_id";//显示的ID

    private static final String KEY_LIKE_COUNT = "like";//点赞数量
    private static final String KEY_FAVORITE_COUNT = "favorite_count";//收藏数量
    private static final String KEY_SUBSRCIBE_COUNT = "subscribe_count";//订阅数量
    private static final String KEY_FANS_COUNT = "fans_count";//读者数量
    private static final String KEY_USER_LEVEL = "user_level";//用户等级
    private static final String KEY_USER_TIME = "user_time";//用户等级
    private static final String KEY_FLAG_VALID = "flag_valid";//是否是号外号用户
    private static final String KEY_USER_IDENTITY = "identity";//用户类型
    private static final String KEY_TEXT_SIZE = "text_size";//字体大小
    private static final String KEY_BACK = "backgound";//详情页背景
    private static final String KEY_BACK_COLORS = "backgoundcolors";//标签背景
    private static final String KEY_NIGHT = "is_night";//夜间模式
    private static final String KEY_BACKGROUND_NIGHT = "is_Background_night";//夜间模式与背景切换冲突
    private static final String KEY_IS_INPUT = "is_input";
    private static final String KEY_YUSU = "yusu";//语速存储
    private static final String KEY_YINLIANG = "yinliang";//音量存储
    private static final String KEY_IDENTITY_NUMBER = "identity_number";//身份证号码
    private static final String KEY_EMAIL = "email";//邮箱
    private static final String KEY_TEXT = "text";
    private static final String KEY_JSON_CACHE = "json";//首页缓存的json
    private static final String KEY_JPUSH_TIME = "jpush_time";//极光推送提示关闭的当前时间
    private static final String KEY_HELP_ONE = "help_one";//判断首页是否弹出演示界面
    private static final String KEY_HELP_TWO = "help_two";//判断详情页是否弹出演示界面
    private static final String KEY_HELP_THREE = "help_three";//判断我的页是否弹出演示界面
    private static final String KEY_HELP_FOUR = "help_four";//判断频道是否弹出演示界面
    private static final String KEY_POSITION_SCROLL = "position";//记录浏览位置ID
    private static final String KEY_THUMB = "thumb";//详情页显示图片

    private static final String IS_CHU_SHENG = "ischusheng";//是否为匿名状态时候走出生
    private static final String IS_CHU_SHENG2 = "ischusheng2";//判断三方状态是否走过出生

    private static final String IS_YAOYIYAO = "is_yaoyiyao";//判断摇一摇功能是否开启，“1”和“null”为开启，“0”为未开启
    private static final String IS_YAOYIYAO_READ = "is_yaoyiyao_read";//判断摇一摇的时候是否自动读文章，“1”为开启，“0”和“null”为未开启
    public static void saveIsYaoYiYao(String text_size) {
        saveString(IS_YAOYIYAO, text_size);
    }

    public static String getIsYaoYiYao() {
        return getString(IS_YAOYIYAO);
    }
    public static void saveIsYaoYiYaoRead(String text_size) {
        saveString(IS_YAOYIYAO_READ, text_size);
    }

    public static String getIsYaoYiYaoRead() {
        return getString(IS_YAOYIYAO_READ);
    }

    public static void saveIsChuSheng(String text_size) {
        saveString(IS_CHU_SHENG, text_size);
    }

    public static String getIsChuSheng() {
        return getString(IS_CHU_SHENG);
    }
    public static void saveIsChuSheng2(String text_size) {
        saveString(IS_CHU_SHENG2, text_size);
    }

    public static String getIsChuSheng2() {
        return getString(IS_CHU_SHENG2);
    }
    public static void savePositionScroll(String text_size) {
        saveString(KEY_POSITION_SCROLL, text_size);
    }

    public static String getPositionScroll() {
        return getString(KEY_POSITION_SCROLL);
    }

    public static void saveHelpOne(String text_size) {
        saveString(KEY_HELP_ONE, text_size);
    }

    public static String getHelpOne() {
        return getString(KEY_HELP_ONE);
    }

    public static void saveHelpTwo(String text_size) {
        saveString(KEY_HELP_TWO, text_size);
    }

    public static String getHelpTwo() {
        return getString(KEY_HELP_TWO);
    }

    public static void saveHelpThree(String text_size) {
        saveString(KEY_HELP_THREE, text_size);
    }

    public static String getHelpThree() {
        return getString(KEY_HELP_THREE);
    }

    public static void saveHelpFour(String text_size) {
        saveString(KEY_HELP_FOUR, text_size);
    }

    public static String getHelpFour() {
        return getString(KEY_HELP_FOUR);
    }


    public static void saveJpushTime(String text_size) {
        saveString(KEY_JPUSH_TIME, text_size);
    }

    public static String getJpushTime() {
        return getString(KEY_JPUSH_TIME);
    }

    public static void saveJson(String text_size) {
        saveString(KEY_JSON_CACHE, text_size);
    }

    public static String getJson() {
        return getString(KEY_JSON_CACHE);
    }

    public static void saveIdentityNumber(String text_size) {
        saveString(KEY_IDENTITY_NUMBER, text_size);
    }

    public static String getIdentityNumber() {
        return getString(KEY_IDENTITY_NUMBER);
    }

    public static void saveEmail(String text_size) {
        saveString(KEY_EMAIL, text_size);
    }

    public static String getEmail() {
        return getString(KEY_EMAIL);
    }

    public static void saveYuSu(String text_size) {
        saveString(KEY_YUSU, text_size);
    }

    public static String getYuSu() {
        return getString(KEY_YUSU);
    }
    public static void saveYinLiang(String text_size) {
        saveString(KEY_YINLIANG, text_size);
    }

    public static String getYinLiang() {
        return getString(KEY_YINLIANG);
    }

    public static void saveTextSize(String text_size) {
        saveString(KEY_TEXT_SIZE, text_size);
    }

    public static String getTextSize() {
        return getString(KEY_TEXT_SIZE);
    }
    public static void saveBack(String back) {
        saveString(KEY_BACK, back);
    }

    public static String getBack() {
        return getString(KEY_BACK);
    }

    public static void saveBackColors(String backColors) {
        saveString(KEY_BACK_COLORS, backColors);
    }

    public static String getBackColors() {
        return getString(KEY_BACK_COLORS);
    }

    public static void saveThumb(String thumb) {
        saveString(KEY_THUMB, thumb);
    }

    public static String getThumb() {
        return getString(KEY_THUMB);
    }

    public static void saveUserLevel(String user_level) {
        saveString(KEY_USER_LEVEL, user_level);
    }

    public static String getUserLevel() {
        return getString(KEY_USER_LEVEL);
    }

    public static void saveUserTime(String user_time) {
        saveString(KEY_USER_TIME, user_time);
    }

    public static String getUserTime() {
        return getString(KEY_USER_TIME);
    }


    public static void saveFlagValid(String flag_valid) {
        saveString(KEY_FLAG_VALID, flag_valid);
    }

    public static String getFlagValid() {
        return getString(KEY_FLAG_VALID);
    }



    public static void saveIdentity(String identity) {
        saveString(KEY_USER_IDENTITY, identity);
    }

    public static String getIdentity() {
        return getString(KEY_USER_IDENTITY);
    }
    public static void saveLikeCount(String like) {
        saveString(KEY_LIKE_COUNT, like);
    }

    public static String getLikeCount() {
        return getString(KEY_LIKE_COUNT);
    }

    public static void saveTexts(String text) {
        saveString(KEY_TEXT, text);
    }

    public static String getTexts() {
        return getString(KEY_TEXT);
    }

    public static void saveFavotiteCount(String favorite_count) {
        saveString(KEY_FAVORITE_COUNT, favorite_count);
    }

    public static String getFavotiteCount() {
        return getString(KEY_FAVORITE_COUNT);
    }



    public static void saveSubscribeCount(String subscribe_count) {
        saveString(KEY_SUBSRCIBE_COUNT, subscribe_count);
    }

    public static String getSubscribeCount() {
        return getString(KEY_SUBSRCIBE_COUNT);
    }



    public static void saveFansCount(String fans_count) {
        saveString(KEY_FANS_COUNT, fans_count);
    }

    public static String getFansCount() {
        return getString(KEY_FANS_COUNT);
    }


    public static void setNight(boolean isNight){
        if (isNight){
            saveString(KEY_NIGHT, 1+"");
        } else {
            saveString(KEY_NIGHT, 0+"");
        }
    }

    public static boolean isNight(){
        return !(getString(KEY_NIGHT)==null || "0".equals(getString(KEY_NIGHT)))&& "1".equals(getString(KEY_NIGHT));
    }

    public static void setBackgroundNight(boolean isNight){
        if (isNight){
            saveString(KEY_BACKGROUND_NIGHT, 1+"");
        } else {
            saveString(KEY_BACKGROUND_NIGHT, 0+"");
        }
    }

    public static boolean isBackgroundNight(){
        return !(getString(KEY_BACKGROUND_NIGHT)==null || "0".equals(getString(KEY_BACKGROUND_NIGHT)))&& "1".equals(getString(KEY_BACKGROUND_NIGHT));
    }

    public static void setInput(boolean isNight){
        if (isNight){
            saveString(KEY_IS_INPUT, 1+"");
        } else {
            saveString(KEY_IS_INPUT, 0+"");
        }
    }

    public static boolean isInput(){
        return !(getString(KEY_IS_INPUT)==null || "0".equals(getString(KEY_IS_INPUT)))&& "1".equals(getString(KEY_IS_INPUT));
    }


    public static void setAnony(boolean isAnony){
        if (isAnony){
            saveString(KEY_USER_IS_ANONY, 1+"");
        } else {
            saveString(KEY_USER_IS_ANONY, 0+"");
        }
    }

    public static boolean isAnony(){
        return !(getString(KEY_USER_IS_ANONY)==null || "0".equals(getString(KEY_USER_IS_ANONY)))&& "1".equals(getString(KEY_USER_IS_ANONY));
    }

    public static void saveAccountId(String id) {
        saveString(KEY_ACCOUNT_ID, id);
    }

    public static String getAccountId() {
        return getString(KEY_ACCOUNT_ID);
    }
    public static void saveUserId(String id) {
        saveString(KEY_USER_ID, id);
    }

    public static String getKeyUserId() {
        return getString(KEY_USER_ID);
    }

    public static void saveUserId2(String id) {
        saveString(KEY_USER_ID2, id);
    }

    public static String getKeyUserId2() {
        return getString(KEY_USER_ID2);
    }
    public static void saveUserAccount(String account) {
        saveString(KEY_USER_ACCOUNT, account);
    }


    public static String getUserAccount() {
        return getString(KEY_USER_ACCOUNT);
    }

    public static void saveUserPassword(String password){
        saveString(KEY_USER_PASSWORD, password);
    }

    public static String getUserPassword(){
        return getString(KEY_USER_PASSWORD);
    }

    public static void saveUserToken(String token) {
        saveString(KEY_USER_TOKEN, token);
    }

    public static String getUserToken() {
        return getString(KEY_USER_TOKEN);
    }

    public static void saveUserToken2(String token) {
        saveString(KEY_USER_TOKEN2, token);
    }

    public static String getUserToken2() {
        return getString(KEY_USER_TOKEN2);
    }
    public static void saveUserHeadImagePath(String path){
        saveString(KEY_USER_HEAD_IMAGE_PATH, path);
    }

    public static String getUserHeadImagePath(){
        return getString(KEY_USER_HEAD_IMAGE_PATH);
    }

    public static void saveUserHeadImage(String path){
        saveString(KEY_USER_HEAD_IMAGE, path);
    }

    public static String getUserHeadImage(){
        return getString(KEY_USER_HEAD_IMAGE);
    }

    public static void saveUserHeadImageicon(String path){
        saveString(KEY_USER_HEAD_IMAGE_ICON, path);
    }

    public static String getUserHeadImageicon(){
        return getString(KEY_USER_HEAD_IMAGE_ICON);
    }

    public static void saveUserImageicon(String path){
        saveString(KEY_USER_IMAGE_ICON, path);
    }

    public static String getUserImageicon(){
        return getString(KEY_USER_IMAGE_ICON);
    }


    public static void saveUserNickname(String nickname){
        saveString(KEY_USER_NICKNAME, nickname);
    }

    public static String getUserNickname(){
        return getString(KEY_USER_NICKNAME);
    }

    public static void saveUserSign(String sign){
        saveString(KEY_USER_SIGN, sign);
    }

    public static String getUserSign(){
        return getString(KEY_USER_SIGN);
    }

    public static void saveUserPhone(String phone){
        saveString(KEY_USER_PHONE, phone);
    }

    public static String getUserPhone(){
        return getString(KEY_USER_PHONE);
    }

    public static void saveUserLocation(String location){
        saveString(KEY_USER_LOCATION, location);
    }

    public static String getUserLocation(){
        return getString(KEY_USER_LOCATION);
    }
    public static void saveUserLocation2(String location){
        saveString(KEY_USER_LOCATIONS, location);
    }

    public static String getUserLocation2(){
        return getString(KEY_USER_LOCATIONS);
    }
    public static void saveUserAge(String age){
        saveString(KEY_USER_AGE, age);
    }

    public static String getUserAge(){
        return getString(KEY_USER_AGE);
    }

    public static void saveUserSex(String sex){
        saveString(KEY_USER_SEX, sex);
    }

    public static String getUserSex(){
        return getString(KEY_USER_SEX);
    }

    public static void saveUserMarriage(String marriage){
        saveString(KEY_USER_MARRIAGE, marriage);
    }

    public static String getUserMarriage(){
        return getString(KEY_USER_MARRIAGE);
    }

    public static void saveUserInterest(String[] interests){
        StringBuffer sb = new StringBuffer();
        if (interests!=null && interests.length!=0) {
            for (int i = 0; i < interests.length; i++) {
                if (i != interests.length - 1) {
                    sb.append(interests[i] + ",");
                } else {
                    sb.append(interests[i]);
                }
            }
        } else {
            sb.append("");
        }
        saveString(KEY_USER_INTEREST, sb.toString());
    }

    public static String[] getUserInterest(){
        String[] interests;
        String interestString = getString(KEY_USER_INTEREST);
        if (interestString!=null && !interestString.equals("")&&interestString.length()!=0){
            interests = interestString.split(",");
        } else {
            interests = new String[]{};
        }
        return interests;
    }

    public static void saveUserCompany(String company){
        saveString(KEY_USER_COMPANY, company);
    }

    public static String getUserCompany(){
        return getString(KEY_USER_COMPANY);
    }

    public static void saveUserSchool(String school){
        saveString(KEY_USER_SCHOOL, school);
    }

    public static String getUserSchool(){
        return getString(KEY_USER_SCHOOL);
    }

    public static void saveUserJob(String job){
        saveString(KEY_USER_JOB, job);
    }

    public static String getUserJob(){
        return getString(KEY_USER_JOB);
    }

    private static void saveString(String key, String value) {
        SharedPreferences.Editor editor = getSharedPreferences().edit();
        editor.putString(key, value);
        editor.commit();
    }

    private static String getString(String key) {
        return getSharedPreferences().getString(key, null);
    }

    static SharedPreferences getSharedPreferences() {
        return HwAppCache.getContext().getSharedPreferences("user_prefs", Context.MODE_PRIVATE);
    }

}
