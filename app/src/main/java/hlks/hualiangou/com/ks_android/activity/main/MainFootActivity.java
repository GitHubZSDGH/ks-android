package hlks.hualiangou.com.ks_android.activity.main;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.tsy.sdk.myokhttp.response.GsonResponseHandler;
import com.tsy.sdk.myokhttp.response.RawResponseHandler;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import hlks.hualiangou.com.ks_android.App;
import hlks.hualiangou.com.ks_android.R;
import hlks.hualiangou.com.ks_android.base.BaseActivity;
import hlks.hualiangou.com.ks_android.base.BaseFragment;
import hlks.hualiangou.com.ks_android.bean.MyFootBean;
import hlks.hualiangou.com.ks_android.event.FootpFragment;
import hlks.hualiangou.com.ks_android.event.MainFootBean;
import hlks.hualiangou.com.ks_android.fragment.FootFragment;
import hlks.hualiangou.com.ks_android.modle.url.UrlUtilds;
import hlks.hualiangou.com.ks_android.utils.UserUtils;

public class MainFootActivity extends BaseActivity implements View.OnClickListener {
    private RelativeLayout mGoBack;
    /**
     * 编辑
     */
    private TextView mMainFootEdit;
    private TabLayout mMainFootTab;
    private ViewPager mMainFootPager;
    private List<String> listTitle;
    private List<BaseFragment> listFragment;
    /**
     * 我的足迹的实体类
     */
    private MyFootBean myFootBean;
    private CheckBox mAllSelect;
    /**
     * 删除
     */
    private TextView mDeleteBtn;
    private RelativeLayout mDeletePop;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main_foot;
    }

    @Override
    public void initView() {
        listTitle = new ArrayList<>();
        listFragment = new ArrayList<>();
        mGoBack = (RelativeLayout) findViewById(R.id.go_back);
        mGoBack.setOnClickListener(this);
        mMainFootEdit = (TextView) findViewById(R.id.main_foot_edit);
        mMainFootEdit.setOnClickListener(this);
        mMainFootTab = (TabLayout) findViewById(R.id.main_foot_tab);
        mMainFootPager = (ViewPager) findViewById(R.id.main_foot_pager);
        mAllSelect = (CheckBox) findViewById(R.id.all_select);
        mDeleteBtn = (TextView) findViewById(R.id.delete_btn);
        mDeleteBtn.setOnClickListener(this);
        mDeletePop = (RelativeLayout) findViewById(R.id.delete_pop);
    }

    @Override
    public void loadData() {
        mMainFootTab.setTabMode(TabLayout.MODE_SCROLLABLE);

        initOkhttp();
    }

    @Override
    public void setListener() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.go_back:
                finish();
                break;
            //编辑
            case R.id.main_foot_edit:
                if ("编辑".equals(mMainFootEdit.getText().toString().trim())) {
                    EventBus.getDefault().post(new MainFootBean(true));
                    mMainFootEdit.setText("完成");
                    mDeletePop.setVisibility(View.VISIBLE);
                } else {
                    EventBus.getDefault().post(new MainFootBean(false));
                    mMainFootEdit.setText("编辑");
                    mDeletePop.setVisibility(View.GONE);
                }

                break;
            case R.id.delete_btn:
                EventBus.getDefault().post(new FootpFragment());
                break;
        }
    }






    private void initOkhttp() {
        App.myOkHttp
                .postParams()
                .url(UrlUtilds.GET_USER_HISTORY)
                .addParam("api", "shop/getUserHistory")
                .addParam("appid", UrlUtilds.APPID)
                .addParam("t", String.valueOf(System.currentTimeMillis()))
                .addParam("token", UserUtils.getToken())
                .addParam("user_id", UserUtils.getUserId())
                .enqueue(new GsonResponseHandler<MyFootBean>() {
                    @Override
                    public void onSuccess(int statusCode, MyFootBean response) {
                        List<MyFootBean.MsgBean.TimeBean> timeList = response.getMsg().getTime();
                        for (MyFootBean.MsgBean.TimeBean timeBean : timeList) {
                            listTitle.add(timeBean.getKey());
                            Log.e("TAG", "title==》" + timeBean.getKey());
                        }
                        for (int i = 0; i < listTitle.size(); i++) {
                            FootFragment footFragment = new FootFragment();

                            Bundle bundle = new Bundle();
                            bundle.putString("foot", response.getMsg().getTime().get(i).getValue());
                            footFragment.setArguments(bundle);
                            listFragment.add(footFragment);
                        }
                        MyAdapter myAdapter = new MyAdapter(getSupportFragmentManager(), listTitle, listFragment);
                        mMainFootPager.setAdapter(myAdapter);
                        mMainFootTab.setupWithViewPager(mMainFootPager);
                    }

                    @Override
                    public void onFailure(int statusCode, String error_msg) {

                    }
                });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO:OnCreate Method has been created, run FindViewById again to generate code
        setContentView(R.layout.activity_main_foot);
        initView();
    }

    class MyAdapter extends FragmentPagerAdapter {

        private List<String> listTitle;

        private List<BaseFragment> listFragment;

        public MyAdapter(FragmentManager fm, List<String> listTitle, List<BaseFragment> listFragment) {
            super(fm);
            this.listTitle = listTitle;
            this.listFragment = listFragment;
        }


        @Override
        public Fragment getItem(int i) {
            return listFragment.get(i);
        }

        @Override
        public int getCount() {
            return listFragment.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return listTitle.get(position);
        }
    }

}
