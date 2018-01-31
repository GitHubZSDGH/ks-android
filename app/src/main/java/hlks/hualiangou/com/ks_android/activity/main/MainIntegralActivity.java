package hlks.hualiangou.com.ks_android.activity.main;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.tsy.sdk.myokhttp.response.GsonResponseHandler;
import com.tsy.sdk.myokhttp.response.RawResponseHandler;

import java.util.ArrayList;
import java.util.List;

import hlks.hualiangou.com.ks_android.App;
import hlks.hualiangou.com.ks_android.R;
import hlks.hualiangou.com.ks_android.base.BaseActivity;
import hlks.hualiangou.com.ks_android.config.FragmentBuilder;
import hlks.hualiangou.com.ks_android.fragment.detailPages.PingLunFragment;
import hlks.hualiangou.com.ks_android.fragment.detailPages.XiangQingFragment;
import hlks.hualiangou.com.ks_android.fragment.mainintegral.MainIntegralFragmentL;
import hlks.hualiangou.com.ks_android.fragment.mainintegral.MainIntegralFragmentR;
import hlks.hualiangou.com.ks_android.modle.bean.MainIntegralBean;
import hlks.hualiangou.com.ks_android.modle.url.UrlUtilds;
import hlks.hualiangou.com.ks_android.utils.UserUtils;

import static hlks.hualiangou.com.ks_android.App.baseActivity;

public class MainIntegralActivity extends BaseActivity implements View.OnClickListener {

    private ImageView mGoBackImg;
    /**
     * 返回
     */
    private TextView mGetBackTv;
    private RelativeLayout mGoBack;
    /**
     * 我的积分
     */
    private TextView mTitleTv;
    /**
     * 编辑
     */
    private TextView mMainFootEdit;
    private TextView mMainIntegralTv;
    /**
     * 当前积分
     */
    private TextView mDangqianjifen;


    private RelativeLayout shopXiangQing;
    private RelativeLayout shopPingJian;
    private FrameLayout shopFragment;
    List<MainIntegralBean.MsgBean.IntegralListBean> shopBean;
    @Override
    public int getLayoutId() {
        return R.layout.activity_main_integral;
    }

    @Override
    public void initView() {

        mGoBackImg = (ImageView) findViewById(R.id.go_back_img);
        mGoBackImg.setOnClickListener(this);
        mGetBackTv = (TextView) findViewById(R.id.get_back_tv);
        mGoBack = (RelativeLayout) findViewById(R.id.go_back);
        mGoBack.setOnClickListener(this);
        mTitleTv = (TextView) findViewById(R.id.title_tv);
        mMainFootEdit = (TextView) findViewById(R.id.main_foot_edit);
        mMainIntegralTv = (TextView) findViewById(R.id.main_integral_tv);
        mDangqianjifen = (TextView) findViewById(R.id.dangqianjifen);
        shopXiangQing = (RelativeLayout) findViewById(R.id.shop_details);
        shopPingJian = (RelativeLayout) findViewById(R.id.shop_evaluate);
        shopFragment = (FrameLayout) findViewById(R.id.shop_details_fragment);
        shopXiangQing.setOnClickListener(this);
        shopPingJian.setOnClickListener(this);
    }

    @Override
    public void loadData() {

        initOkhttp();
    }

    private void initOkhttp() {
        App.myOkHttp
                .postParams()
                .url(UrlUtilds.GET_USER_INTEGRAL)
                .addParam("api", "myself/userIntegral")
                .addParam("appid", UrlUtilds.APPID)
                .addParam("t", String.valueOf(System.currentTimeMillis()))
                .addParam("token", UserUtils.getToken())
                .addParam("user_id", UserUtils.getUserId())
                .enqueue(new GsonResponseHandler<MainIntegralBean>() {
                    @Override
                    public void onSuccess(int statusCode, MainIntegralBean response) {
                     mMainIntegralTv.setText(response.getMsg().getIntegral());
                     shopBean = response.getMsg().getIntegral_list();
                        Bundle bundle = new Bundle();
                        bundle.putParcelableArrayList("shopImage", (ArrayList<? extends Parcelable>) shopBean);
                        FragmentBuilder.getInstance(baseActivity)
                                .start(MainIntegralFragmentL.class)
                                .setBundle(bundle)
                                .add(R.id.shop_details_fragment)
                                .commit();
                    }

                    @Override
                    public void onFailure(int statusCode, String error_msg) {

                    }
                });
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
            case R.id.go_back:
                finish();
                break;
            case R.id.shop_details:
                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList("shopImage", (ArrayList<? extends Parcelable>) shopBean);
                FragmentBuilder.getInstance(baseActivity)
                        .start(MainIntegralFragmentL.class)
                        .setBundle(bundle)
                        .add(R.id.shop_details_fragment)
                        .commit();

                break;
            case R.id.shop_evaluate:
                FragmentBuilder.getInstance(baseActivity)
                        .start(MainIntegralFragmentR.class)
                        .add(R.id.shop_details_fragment)
                        .commit();
                break;
        }
    }
}
