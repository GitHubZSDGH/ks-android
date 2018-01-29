package hlks.hualiangou.com.ks_android.activity.main;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import hlks.hualiangou.com.ks_android.R;
import hlks.hualiangou.com.ks_android.activity.main.adapter.SimpleFragmentPagerAdapter;
import hlks.hualiangou.com.ks_android.base.BaseActivity;
import hlks.hualiangou.com.ks_android.fragment.order.OrderFragment;
import hlks.hualiangou.com.ks_android.utils.UI.BadgeView;

public class MainOrderActivity extends BaseActivity implements View.OnClickListener {

    private ImageView mGoBackImg;
    private RelativeLayout mGoBack;
    /**
     * 编辑
     */
    private TextView mMainFootEdit;
    private TabLayout mMainOrderTab;
    private ViewPager mMainOrderVp;
    private SimpleFragmentPagerAdapter mPagerAdapter;
    private List<String> mPageTitleList = new ArrayList<String>();
    private List<Fragment> mFragmentList = new ArrayList<Fragment>();
    private List<Integer> mBadgeCountList = new ArrayList<Integer>();
    private List<BadgeView> mBadgeViews;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main_order;
    }

    @Override
    public void initView() {
        mGoBackImg = (ImageView) findViewById(R.id.go_back_img);
        mGoBackImg.setOnClickListener(this);
        mGoBack = (RelativeLayout) findViewById(R.id.go_back);
        mMainFootEdit = (TextView) findViewById(R.id.main_foot_edit);
        mMainOrderTab = (TabLayout) findViewById(R.id.main_order_tab);
        mMainOrderVp = (ViewPager) findViewById(R.id.main_order_vp);
    }


    @Override
    public void loadData() {
        /**
         * 全部订单、待付款、待发货、待收货、待评价
         */

        for (int i = 0; i < 5; i++) {
            Bundle bundle = new Bundle();
            bundle.putString("orderType", String.valueOf((i + 1)));
            OrderFragment orderFragment = new OrderFragment();
            orderFragment.setArguments(bundle);
            mFragmentList.add(orderFragment);
        }

        mPageTitleList.add("全部");
        mPageTitleList.add("待付款");
        mPageTitleList.add("待发货");
        mPageTitleList.add("待收货");
        mPageTitleList.add("待评价");
        mBadgeCountList.add(0);
        mBadgeCountList.add(0);
        mBadgeCountList.add(6);
        mBadgeCountList.add(6);
        mBadgeCountList.add(6);
        mPagerAdapter = new SimpleFragmentPagerAdapter(this, getSupportFragmentManager(),
                mFragmentList, mPageTitleList, mBadgeCountList);
        mMainOrderVp.setAdapter(mPagerAdapter);
        mMainOrderTab.setupWithViewPager(mMainOrderVp);
        initBadgeViews();
        setUpTabBadge();
    }

    @Override
    public void setListener() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.go_back_img:
                finish();
                break;
        }
    }

    private void initBadgeViews() {
        if (mBadgeViews == null) {
            mBadgeViews = new ArrayList<BadgeView>();
            for (int i = 0; i < mFragmentList.size(); i++) {
                BadgeView tmp = new BadgeView(this);
                tmp.setBadgeMargin(0, 4, 8, 0);
                tmp.setTextSize(8);
                mBadgeViews.add(tmp);
            }
        }
    }

    /**
     * 设置Tablayout上的标题的角标
     */
    private void setUpTabBadge() {
        // 1. 最简单
//        for (int i = 0; i < mFragmentList.size(); i++) {
//            mBadgeViews.get(i).setTargetView(((ViewGroup) mTabLayout.getChildAt(0)).getChildAt(i));
//            mBadgeViews.get(i).setText(formatBadgeNumber(mBadgeCountList.get(i)));
//        }

        // 2. 最实用
        for (int i = 0; i < mFragmentList.size(); i++) {
            TabLayout.Tab tab = mMainOrderTab.getTabAt(i);

            // 更新Badge前,先remove原来的customView,否则Badge无法更新
            View customView = tab.getCustomView();
            if (customView != null) {
                ViewParent parent = customView.getParent();
                if (parent != null) {
                    ((ViewGroup) parent).removeView(customView);
                }
            }

            // 更新CustomView
            tab.setCustomView(mPagerAdapter.getTabItemView(i));
        }

        // 需加上以下代码,不然会出现更新Tab角标后,选中的Tab字体颜色不是选中状态的颜色
        mMainOrderTab.getTabAt(mMainOrderTab.getSelectedTabPosition()).getCustomView().setSelected(true);
    }
}
