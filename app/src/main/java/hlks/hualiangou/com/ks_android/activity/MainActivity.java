package hlks.hualiangou.com.ks_android.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.annotation.IdRes;
import android.support.v7.app.AlertDialog;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import butterknife.BindView;
import hlks.hualiangou.com.ks_android.R;
import hlks.hualiangou.com.ks_android.base.BaseActivity;
import hlks.hualiangou.com.ks_android.config.FragmentBuilder;
import hlks.hualiangou.com.ks_android.fragment.pager.ClassIfyFragment;
import hlks.hualiangou.com.ks_android.fragment.pager.HomeFragmentPaer;
import hlks.hualiangou.com.ks_android.fragment.pager.MessageFragment;
import hlks.hualiangou.com.ks_android.fragment.pager.MyFragment;
import hlks.hualiangou.com.ks_android.fragment.pager.ShoppingCartFragment;

import static hlks.hualiangou.com.ks_android.App.baseActivity;

/**
 * 首页
 */
public class MainActivity extends BaseActivity  {



    @BindView(R.id.home_button1)
    RadioButton homeButton1;
    @BindView(R.id.home_button2)
    RadioButton homeButton2;
    @BindView(R.id.home_button3)
    RadioButton homeButton3;
    @BindView(R.id.home_button4)
    RadioButton homeButton4;
    @BindView(R.id.home_button5)
    RadioButton homeButton5;
    @BindView(R.id.home_page)
    RadioGroup homePage;

    String selector_fragment;
    private MainActivity mainActivity;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
//首页默认fragment
        mainActivity = this;
        FragmentBuilder.getInstance(this)
                .start(HomeFragmentPaer.class)
                .add(R.id.main_home)
                .commit();
    }

    @Override
    public void loadData() {
        Intent intert=  this.getIntent();
        if(intert != null){
            selector_fragment = intert.getStringExtra("getMessage");
            if (selector_fragment!=null&&selector_fragment.equals("1")){
                homePage.check(R.id.home_button3);
            }else {
                homePage.check(R.id.home_button1);
            }
        }
    }
//RadioButton监听事件 更换fragment

    @Override
    protected void onResume() {
        int id = getIntent().getIntExtra("fragment",0);
        if (id==1){
            homePage.check(R.id.home_button4);
        }
        super.onResume();
    }

    @Override
    public void setListener() {
    homePage.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
            switch (i){
                case R.id.home_button1:
//                    homePagerFragment = new HomePagerFragment();
//                    getSupportFragmentManager().beginTransaction().
//                            replace(R.id.main_home,homePagerFragment).commitAllowingStateLoss();
//                    StatusBarCompat.setStatusBarColor(MainActivity.this, getResources()
//                            .getColor(R.color.corlorsearch), true);
                    FragmentBuilder.getInstance(baseActivity)
                            .start(HomeFragmentPaer.class)
                            .add(R.id.main_home)
                            .commit();
                    break;
                case R.id.home_button2:
//                    classIfyFragment = new ClassIfyFragment();
//                    getSupportFragmentManager().
//                            beginTransaction().
//                            replace(R.id.main_home,classIfyFragment).
//                            commitAllowingStateLoss();
//                    StatusBarCompat.setStatusBarColor(MainActivity.this, getResources()
//                            .getColor(R.color.white), true);

                    FragmentBuilder.getInstance(baseActivity)
                            .start(ClassIfyFragment.class)
                            .add(R.id.main_home)
                            .commit();
                    break;
                case R.id.home_button3:
//                    messageFragment = new MessageFragment();
//                    getSupportFragmentManager().beginTransaction().
//                            replace(R.id.main_home,messageFragment).commitAllowingStateLoss();
                    FragmentBuilder.getInstance(baseActivity)
                            .start(MessageFragment.class)
                            .add(R.id.main_home)
                            .commit();
                    break;
                case R.id.home_button4:
//                    ShoppingCartFragment commit = (ShoppingCartFragment) FragmentBuilder.getInstance(baseActivity)
//                            .start(ShoppingCartFragment.class)
//                            .add(R.id.main_home)
//                            .commit();
//                    commit.setMainCLicter(mainActivity);
                    FragmentBuilder.getInstance(baseActivity)
                            .start(ShoppingCartFragment.class)
                            .add(R.id.main_home)
                            .commit();
                    break;
                case R.id.home_button5:
//                    myFragment = new MyFragment();
//                    getSupportFragmentManager().beginTransaction().
//                            replace(R.id.main_home,myFragment).commitAllowingStateLoss();
//                    //  initState();
                    FragmentBuilder.getInstance(baseActivity)
                            .start(MyFragment.class)
                            .add(R.id.main_home)
                            .commit();
                    break;
            }
        }
    });
    }

//    @Override
//    public void onCheckdListener() {
//        homeButton2.setChecked(true);
//    }


    private long firstTime = 0;
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_UP) {
            long secondTime = System.currentTimeMillis();
            if (secondTime - firstTime > 2000) {
                Toast toast = new Toast(this);
                // 找到toast布局的位置
                View layout = View.inflate(this, R.layout.shop_dialog_custom2, null);
                // 设置toast文本，把设置好的布局传进来
                toast.setView(layout);
                // 设置土司显示在屏幕的位置
//                        toast.setGravity(Gravity.FILL_HORIZONTAL|Gravity.TOP,0,70);
                // 显示土司
                toast.show();

//                myDialogJieSuan();
            firstTime = secondTime;
            return true;
        } else {
            System.exit(0);
        }
    }
        return super.onKeyUp(keyCode, event);
    }


}
