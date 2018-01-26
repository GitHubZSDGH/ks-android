package hlks.hualiangou.com.ks_android.base;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Stack;

import butterknife.ButterKnife;
import hlks.hualiangou.com.ks_android.App;
import hlks.hualiangou.com.ks_android.utils.KeyBoardUtils;


/**
 * 编写人：老田
 * Created by localadmin on 2017/7/28.
 */
   //所有的activity继承AutoLayoutActivity
public abstract class BaseActivity extends AppCompatActivity {
    //判断是否从后台切换到前台
    private int count;
    private static boolean isActive;
    private boolean isSearchEditTextCeanter = false;
    private KeyBordListener keyBordListener;
private int[] ids;
    /**
     * 用来保存所有已打开的Activity这有坑
     */
    private static Stack<Activity> listActivity = new Stack<Activity>();



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listActivity.push(this);

        if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
        setContentView(getLayoutId());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                //        这段代码不能动，会有全局bug 稍后修改
                if (!isEMUI3_1()) {
                    window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                }
                window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.setStatusBarColor(Color.TRANSPARENT);
                getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            }
        }



        App.baseActivity = this;
        //这段代码不能动，会有全局bug 稍后修改
//        getSupportActionBar().hide();
        ButterKnife.bind(this);
        initView();
        loadData();
        setListener();
    }
    public static boolean isEMUI3_1() {
        if ("EmotionUI_3.1".equals(getEmuiVersion())) {
            return true;
        }
        return false;
    }

    private static String getEmuiVersion(){
        Class<?> classType = null;
        try {
            classType = Class.forName("android.os.SystemProperties");
            Method getMethod = classType.getDeclaredMethod("get", String.class);
            return (String)getMethod.invoke(classType, "ro.build.version.emui");
        } catch (Exception e){
        }
        return "";
    }


    public void setKeyBordListener(KeyBordListener keyBordListener) {
        this.keyBordListener = keyBordListener;
    }
    //这段代码不能动，稍后会用到 如果我走了，但愿后来的哥们千万记住了
    public void setKeyBordListenerNull() {
        keyBordListener = null;
    }

    public abstract int getLayoutId();

    public abstract void initView();

    public abstract void loadData();

    public abstract void setListener();

    @Override
    protected void onResume() {
        super.onResume();
        App.baseActivity = this;


    }

    /**
     * APP是否处于前台唤醒状态
     *
     * @return
     */
    public boolean isAppOnForeground() {
        ActivityManager activityManager = (ActivityManager) getApplicationContext().getSystemService(Context.ACTIVITY_SERVICE);
        String packageName = getApplicationContext().getPackageName();
        List<ActivityManager.RunningAppProcessInfo> appProcesses = activityManager
                .getRunningAppProcesses();
        if (appProcesses == null)
            return false;

        for (ActivityManager.RunningAppProcessInfo appProcess : appProcesses) {
            // The name of the process that this object is associated with.
            if (appProcess.processName.equals(packageName)
                    && appProcess.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
//        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
//            if (isSearchEditTextCeanter) {
//                View v = getCurrentFocus();
//                if (isShouldHideKeyboard(v, ev)) {
//                    hideKeyboard(v.getWindowToken());
//                }
//            }
//        }
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            if (isTouchView(filterViewByIds(), ev)) return super.dispatchTouchEvent(ev);
            if (hideSoftByEditViewIds() == null || hideSoftByEditViewIds().length == 0)
                return super.dispatchTouchEvent(ev);
            View v = getCurrentFocus();
            if (isFocusEditText(v, hideSoftByEditViewIds())) {
                if (isTouchView(hideSoftByEditViewIds(), ev))
                    return super.dispatchTouchEvent(ev);
                //隐藏键盘
                KeyBoardUtils.hideInputForce(this);
                if (keyBordListener != null) {
                    keyBordListener.onHideKeyBord();
                }
//                clearViewFocus(v, hideSoftByEditViewIds());//解决焦点问题

            }
        }


        return super.dispatchTouchEvent(ev);
    }

    /**
     * 清除editText的焦点
     *
     * @param v   焦点所在View
     * @param ids 输入框
     */
    public void clearViewFocus(View v, int... ids) {
        if (null != v && null != ids && ids.length > 0) {
            for (int id : ids) {
                if (v.getId() == id) {
                    v.clearFocus();
                    break;
                }
            }
        }


    }

    /**
     * 隐藏键盘
     *
     * @param v   焦点所在View
     * @param ids 输入框
     * @return true代表焦点在edit上
     */
    public boolean isFocusEditText(View v, int... ids) {
        if (v instanceof EditText) {
            EditText tmp_et = (EditText) v;
            for (int id : ids) {
                if (tmp_et.getId() == id) {
                    return true;
                }
            }
        }
        return false;
    }




    /**
     * 传入EditText的Id
     * 没有传入的EditText不做处理
     *
     * @return id 数组
     */
    public int[] hideSoftByEditViewIds() {
        return ids;
    }
    public void hideEditext(int[] ids){
        this.ids = ids;
    }

    /**
     * 传入要过滤的View
     * 过滤之后点击将不会有隐藏软键盘的操作
     *
     * @return id 数组
     */
    public View[] filterViewByIds() {
        return null;
    }

    //是否触摸在指定view上面,对某个控件过滤
    public boolean isTouchView(View[] views, MotionEvent ev) {
        if (views == null || views.length == 0) return false;
        int[] location = new int[2];
        for (View view : views) {
            view.getLocationOnScreen(location);
            int x = location[0];
            int y = location[1];
            if (ev.getX() > x && ev.getX() < (x + view.getWidth())
                    && ev.getY() > y && ev.getY() < (y + view.getHeight())) {
                return true;
            }
        }
        return false;
    }

    //是否触摸在指定view上面,对某个控件过滤
    public boolean isTouchView(int[] ids, MotionEvent ev) {
        int[] location = new int[2];
        for (int id : ids) {
            View view = findViewById(id);
            if (view == null) continue;
            view.getLocationOnScreen(location);
            int x = location[0];
            int y = location[1];
            if (ev.getX() > x && ev.getX() < (x + view.getWidth())
                    && ev.getY() > y && ev.getY() < (y + view.getHeight())) {
                return true;
            }
        }
        return false;
    }

    /**
     * 根据EditText所在坐标和用户点击的坐标相对比，来判断是否隐藏键盘，因为当用户点击EditText时则不能隐藏
     *
     * @param v
     * @param event
     * @return
     */
    private boolean isShouldHideKeyboard(View v, MotionEvent event) {
        if (v != null && (v instanceof EditText)) {
            int[] l = {0, 0};
            v.getLocationInWindow(l);
            int left = l[0],
                    top = l[1],
                    bottom = top + v.getHeight(),
                    right = left + v.getWidth();
            if (event.getX() > left && event.getX() < right
                    && event.getY() > top && event.getY() < bottom) {
                // 点击EditText的事件，忽略它。
                return false;
            } else {
                v.clearFocus();
                return true;
            }
        }
        // 如果焦点不是EditText则忽略，这个发生在视图刚绘制完，第一个焦点不在EditText上，和用户用轨迹球选择其他的焦点
        return false;
    }

    /**
     * 获取InputMethodManager，隐藏软键盘
     *
     * @param token
     */
    public void hideKeyboard(IBinder token) {
        if (token != null) {
            InputMethodManager im = (InputMethodManager) this.getSystemService(Context.INPUT_METHOD_SERVICE);
            im.hideSoftInputFromWindow(token, InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    public void setIsSearchEditTextCeanter(boolean isSearchEditTextCeanter) {

        this.isSearchEditTextCeanter = isSearchEditTextCeanter;
    }

    public interface KeyBordListener {


        void onHideKeyBord();
    }

//    @Override
//    protected void onStart() {
//        super.onStart();
//        if (mLoginReceiver == null) {
//            mLoginReceiver = new SingleLoginReceiver();
//        }
//        if (loginBroadcastReceiver == null) {
//            loginBroadcastReceiver = new CoreService.LoginBroadcastReceiver();
//        }
//        IntentFilter loginFilter = new IntentFilter();
//        loginFilter.addAction(AppBroadcastAction.XMPP_LOGIN_ACTION);
//        registerReceiver(loginBroadcastReceiver, loginFilter);
//        mLoginReceiver.setSingleLoginListener(mSingleLoginListener);
//        IntentFilter intentFilter = new IntentFilter();
//        intentFilter.addAction(AppBroadcastAction.SINGLE_LOGIN_ACTION);
//        registerReceiver(mLoginReceiver, intentFilter);
//    }
//
//    @Override
//    protected void onDestroy() {
//        try {
//            unregisterReceiver(mLoginReceiver);
//            unregisterReceiver(loginBroadcastReceiver);
//        } catch (IllegalArgumentException e) {
//        }
//        super.onDestroy();
//        // 从栈中移除当前activity
//        if (listActivity.contains(this)) {
//            listActivity.remove(this);
//        }
//    }
//
//    /**
//     * 关闭所有(前台、后台)Activity,注意：请以BaseActivity为父类
//     */
//    protected static void finishAll() {
//        int len = listActivity.size();
//        for (int i = 0; i < len; i++) {
//            Activity activity = listActivity.pop();
//            activity.finish();
//        }
//    }


//    private SingleLoginReceiver mLoginReceiver;
//    private CoreService.LoginBroadcastReceiver loginBroadcastReceiver;

//    /**
//     * 单点登录接收广播
//     */
//    private SingleLoginReceiver.SingleLoginListener mSingleLoginListener = new SingleLoginReceiver.SingleLoginListener() {
//
//        String token = SharedPreferencesUtils.getString(KeyUtils.TOKEN_KEY);
//
////        @Override
////        public void onReceive(final Context context, Intent intent) {
////            if (intent != null) {
////                Log.e("KKKK", "服务器==" + intent.getStringExtra("token"));
////                Log.e("KKKK", "本地==" + UserUtils.getToken());
////
////                boolean isLoginOut = intent.getBooleanExtra("isLoginOut", false);
////                if (isLoginOut && UserUtils.getToken().equals(intent.getStringExtra("token"))) {
////                    AppAlertDialog dialog = new AppAlertDialog(context, true, true, true);
////                    dialog.setCanceledOnTouchOutside(false);
////                    dialog.setTitle("下线通知");
////                    dialog.setMessage("您的账号于" + TimeUtils.getNowString(new SimpleDateFormat("yyyy年MM月dd日HH时mm分", Locale.getDefault()))
////                            + "在另一台设备上登录,如非本人操作建议登录后修改密码或联系客服95132修改");
////                    dialog.setLeftButton("退出", new View.OnClickListener() {
////                        @Override
////                        public void onClick(View v) {
////                            SharedPreferencesUtils.remove(KeyUtils.TOKEN_KEY);
////                            finishAll();
////                        }
////                    });
////                    dialog.setRightButton("重新登录", new View.OnClickListener() {
////                        @Override
////                        public void onClick(View v) {
////                            finishAll();
////                            startActivity(new Intent(context, LoginActivity.class));
////                        }
////                    });
////                }
//        @Override
//        public void singleLoginListener(boolean isLoginOut, String imToken) {
//            LogUtils.e("-----------Token = " + token);
//            LogUtils.e("-----------imToken = " + imToken);
//            if("myokhttp".equals(imToken)){
//                imToken = UserUtils.getToken();
//            }
//            if (isLoginOut && token.equals(imToken)) {
//                AppAlertDialog dialog = new AppAlertDialog(BaseActivity.this, true, true, true);
//                dialog.setCanceledOnTouchOutside(false);
//                dialog.setTitle("下线通知");
//                dialog.setMessage("您的账号于" + TimeUtils.getNowString(new SimpleDateFormat("yyyy年MM月dd日HH时mm分", Locale.getDefault()))
//                        + "在另一台设备上登录,如非本人操作建议登录后修改密码或联系客服95132修改");
//                dialog.setLeftButton("退出", new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        SharedPreferencesUtils.remove(KeyUtils.TOKEN_KEY);
//                        finishAll();
//                    }
//                });
//                dialog.setRightButton("重新登录", new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        finishAll();
//                        startActivity(new Intent(BaseActivity.this, LoginActivity.class));
//                    }
//                });
//            }
//        }
//    };
}
