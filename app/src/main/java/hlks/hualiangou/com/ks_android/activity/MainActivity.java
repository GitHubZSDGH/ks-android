package hlks.hualiangou.com.ks_android.activity;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.githang.statusbar.StatusBarCompat;

import butterknife.BindView;
import hlks.hualiangou.com.ks_android.App;
import hlks.hualiangou.com.ks_android.R;
import hlks.hualiangou.com.ks_android.base.BaseActivity;
import hlks.hualiangou.com.ks_android.config.FragmentBuilder;
import hlks.hualiangou.com.ks_android.fragment.pager.ClassIfyFragment;
import hlks.hualiangou.com.ks_android.fragment.pager.HomePagerFragment;
import hlks.hualiangou.com.ks_android.fragment.pager.MessageFragment;
import hlks.hualiangou.com.ks_android.fragment.pager.MyFragment;
import hlks.hualiangou.com.ks_android.fragment.pager.ShoppingCartFragment;
import hlks.hualiangou.com.ks_android.listener.MainListener;

/**
 * 首页
 */
public class MainActivity extends BaseActivity implements MainListener {



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
//首页模块Fragment
     HomePagerFragment homePagerFragment;//首页
     ClassIfyFragment classIfyFragment;//分类'
     MessageFragment messageFragment;//消息
     ShoppingCartFragment shoppingCartFragment;//购物车
     MyFragment myFragment;//我的
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
                .start(HomePagerFragment.class)
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
    public void setListener() {
    homePage.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
            switch (i){
                case R.id.home_button1:
                    homePagerFragment = new HomePagerFragment();
                    getSupportFragmentManager().beginTransaction().
                            replace(R.id.main_home,homePagerFragment).commitAllowingStateLoss();
                    StatusBarCompat.setStatusBarColor(MainActivity.this, getResources()
                            .getColor(R.color.corlorsearch), true);
                    break;
                case R.id.home_button2:
                    classIfyFragment = new ClassIfyFragment();
                    getSupportFragmentManager().
                            beginTransaction().
                            replace(R.id.main_home,classIfyFragment).
                            commitAllowingStateLoss();
                    StatusBarCompat.setStatusBarColor(MainActivity.this, getResources()
                            .getColor(R.color.white), true);
                    break;
                case R.id.home_button3:
                    messageFragment = new MessageFragment();
                    getSupportFragmentManager().beginTransaction().
                            replace(R.id.main_home,messageFragment).commitAllowingStateLoss();
                    break;
                case R.id.home_button4:
                    ShoppingCartFragment commit = (ShoppingCartFragment) FragmentBuilder.getInstance(App.baseActivity)
                            .start(ShoppingCartFragment.class)
                            .add(R.id.main_home)
                            .commit();
                    commit.setMainCLicter(mainActivity);
                    break;
                case R.id.home_button5:
                    myFragment = new MyFragment();
                    getSupportFragmentManager().beginTransaction().
                            replace(R.id.main_home,myFragment).commitAllowingStateLoss();
                    //  initState();
                    break;
            }
        }
    });
    }

    @Override
    public void onCheckdListener() {
        homeButton2.setChecked(true);
    }



}
