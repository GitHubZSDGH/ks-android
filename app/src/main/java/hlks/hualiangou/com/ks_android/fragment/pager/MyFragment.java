package hlks.hualiangou.com.ks_android.fragment.pager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.tsy.sdk.myokhttp.response.GsonResponseHandler;
import com.tsy.sdk.myokhttp.response.RawResponseHandler;

import java.util.ArrayList;

import hlks.hualiangou.com.ks_android.App;
import hlks.hualiangou.com.ks_android.R;
import hlks.hualiangou.com.ks_android.activity.LoginActivity;
import hlks.hualiangou.com.ks_android.activity.main.AccountSettingActivity;
import hlks.hualiangou.com.ks_android.activity.main.MainIntegralActivity;
import hlks.hualiangou.com.ks_android.activity.main.MainOrderActivity;
import hlks.hualiangou.com.ks_android.base.BaseFragment;
import hlks.hualiangou.com.ks_android.config.FragmentBuilder;
import hlks.hualiangou.com.ks_android.fragment.mainintegral.MainIntegralFragmentL;
import hlks.hualiangou.com.ks_android.modle.bean.MainIntegralBean;
import hlks.hualiangou.com.ks_android.modle.bean.MyFragmentBean;
import hlks.hualiangou.com.ks_android.modle.url.UrlUtilds;
import hlks.hualiangou.com.ks_android.utils.KeyUtils;
import hlks.hualiangou.com.ks_android.utils.SharedPreferencesUtils;
import hlks.hualiangou.com.ks_android.utils.UserUtils;
import hlks.hualiangou.com.ks_android.view.img.RoundedImageView;

import static hlks.hualiangou.com.ks_android.App.baseActivity;

/**
 * 项目名称:
 * 类描述:
 * 创建人:lenovo
 * 创建时间:2017/11/10
 * 修改人:
 * 修改内容:
 */
public class MyFragment extends BaseFragment implements View.OnClickListener {
    //布局id；
//    private LinearLayout mMy_bean;//我的联豆
    private LinearLayout siginLogin;
    private LinearLayout homeSiginAddress;
    private View view;
    private TextView mUserId;
    private RoundedImageView mRoundedImageView;
    /**
     * 请登录
     */
    private TextView mUserid;
    private LinearLayout mGuanzhu;
    private LinearLayout mShoucang;
    private LinearLayout mPingjia;
    private LinearLayout mZuji;
    private RelativeLayout mDaifukuan;
    private RelativeLayout mDaifahuo;
    private RelativeLayout mDashouhuo;
    private RelativeLayout mTuihuotuikuan;
    private LinearLayout mPingtaitongzhi;
    private LinearLayout mFuwufankui;
    private LinearLayout mShezhizhongxin;
    private LinearLayout mHomeSiginLogin;
    private LinearLayout mWodejifen;
    private RelativeLayout mMyRv;
    /**
     * 全部订单
     */
    private TextView mQuanbuOrder;
    private ImageView mImageView6;
    /**
     * 56
     */
    private TextView mDaifukuanNum;
    /**
     * 56
     */
    private TextView mDaifahuoNum;
    /**
     * 56
     */
    private TextView mDashouhuoNum;
    /**
     * 56
     */
    private TextView mTuihuotuikuanNum;

    //获取布局
    @Override
    public int getLayoutId() {
        return R.layout.my_fragment;
    }

    @Override
    public void initView(View view) {

        siginLogin = view.findViewById(R.id.home_sigin_login);
        siginLogin.setOnClickListener(this);
        mUserId = view.findViewById(R.id.userid);
        mRoundedImageView = (RoundedImageView) view.findViewById(R.id.roundedImageView);
        mRoundedImageView.setOnClickListener(this);
        mUserid = (TextView) view.findViewById(R.id.userid);
        mGuanzhu = (LinearLayout) view.findViewById(R.id.guanzhu);
        mGuanzhu.setOnClickListener(this);
        mShoucang = (LinearLayout) view.findViewById(R.id.shoucang);
        mShoucang.setOnClickListener(this);
        mPingjia = (LinearLayout) view.findViewById(R.id.pingjia);
        mPingjia.setOnClickListener(this);
        mZuji = (LinearLayout) view.findViewById(R.id.zuji);
        mZuji.setOnClickListener(this);
        mDaifukuan = (RelativeLayout) view.findViewById(R.id.daifukuan);
        mDaifukuan.setOnClickListener(this);
        mDashouhuo = (RelativeLayout) view.findViewById(R.id.dashouhuo);
        mDashouhuo.setOnClickListener(this);
        mDaifahuo = (RelativeLayout) view.findViewById(R.id.daifahuo);
        mDaifahuo.setOnClickListener(this);
        mTuihuotuikuan = (RelativeLayout) view.findViewById(R.id.tuihuotuikuan);
        mTuihuotuikuan.setOnClickListener(this);
        mPingtaitongzhi = (LinearLayout) view.findViewById(R.id.pingtaitongzhi);
        mPingtaitongzhi.setOnClickListener(this);
        mFuwufankui = (LinearLayout) view.findViewById(R.id.fuwufankui);
        mFuwufankui.setOnClickListener(this);
        mShezhizhongxin = (LinearLayout) view.findViewById(R.id.shezhizhongxin);
        mShezhizhongxin.setOnClickListener(this);
        mHomeSiginLogin = (LinearLayout) view.findViewById(R.id.home_sigin_login);
        mHomeSiginLogin.setOnClickListener(this);
        mWodejifen = (LinearLayout) view.findViewById(R.id.wodejifen);
        mWodejifen.setOnClickListener(this);
        mUserid.setOnClickListener(this);
        mMyRv = (RelativeLayout) view.findViewById(R.id.my_rv);
        mQuanbuOrder = (TextView) view.findViewById(R.id.quanbu_order);
        mQuanbuOrder.setOnClickListener(this);
        mImageView6 = (ImageView) view.findViewById(R.id.imageView6);
        mImageView6.setOnClickListener(this);
        mDaifukuanNum = (TextView) view.findViewById(R.id.daifukuan_num);
        mDaifahuoNum = (TextView) view.findViewById(R.id.daifahuo_num);
        mDashouhuoNum = (TextView) view.findViewById(R.id.dashouhuo_num);
        mTuihuotuikuanNum = (TextView) view.findViewById(R.id.tuihuotuikuan_num);
    }

    @Override
    public void loadData() {
        if (!UserUtils.getToken().isEmpty()) {
//            startActivity(new Intent(baseActivity, LoginActivity.class));
            mUserId.setText(UserUtils.getUserPhone().toString());
            initOkhttp();
            return;
        } else {
            myDialogText();
            return;
        }
    }

    @Override
    public void setListener() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.home_sigin_login:
                SharedPreferencesUtils.remove(KeyUtils.USER_TOKEN);
                startActivity(new Intent(baseActivity, LoginActivity.class));
//                baseActivity.finish();
                break;
            case R.id.guanzhu:
                myDialogJieSuan();
                break;
            case R.id.shoucang:
                myDialogJieSuan();
                break;
            case R.id.pingjia:
                myDialogJieSuan();
                break;
            case R.id.zuji:
                break;
            case R.id.daifukuan:
                startActivity(new Intent(baseActivity, MainOrderActivity.class).putExtra("index", 1));
                break;
            case R.id.daifahuo:
                startActivity(new Intent(baseActivity, MainOrderActivity.class).putExtra("index", 2));
                break;
            case R.id.dashouhuo:
                startActivity(new Intent(baseActivity, MainOrderActivity.class).putExtra("index", 3));
                break;
            case R.id.tuihuotuikuan:
//                startActivity(new Intent(baseActivity, MainOrderActivity.class).putExtra("index", 4));
                myDialogJieSuan();
                break;
            case R.id.pingtaitongzhi:
                myDialogJieSuan();
                break;
            case R.id.fuwufankui:
                myDialogJieSuan();
                break;
            case R.id.shezhizhongxin:
                startActivity(new Intent(baseActivity, AccountSettingActivity.class));
                break;
            case R.id.roundedImageView:

                break;
            case R.id.wodejifen:
                startActivity(new Intent(baseActivity, MainIntegralActivity.class));
                break;

            case R.id.userid:
                break;
            case R.id.quanbu_order:
                startActivity(new Intent(baseActivity, MainOrderActivity.class).putExtra("index", 0));
                break;
            case R.id.imageView6:
                break;
        }
    }

    private void myDialogText() {
        AlertDialog.Builder builder = new AlertDialog.Builder(baseActivity, R.style.MyCommonDialog);
        builder.setView(R.layout.shop_dialog_custom);
        final AlertDialog dialog = builder.create();
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
        TextView textView = (TextView) dialog.findViewById(R.id.home_dialog_determine);
        TextView textView1 = (TextView) dialog.findViewById(R.id.home_dialog);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(baseActivity, LoginActivity.class));
                dialog.dismiss();
            }
        });
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentBuilder.getInstance(baseActivity)
                        .start(ClassIfyFragment.class)
                        .add(R.id.main_home)
                        .commit();
                dialog.dismiss();
            }
        });
    }

    private void myDialogJieSuan() {
        AlertDialog.Builder builder = new AlertDialog.Builder(baseActivity, R.style.MyCommonDialog);
        builder.setView(R.layout.shop_dialog_custom);
        final AlertDialog dialog = builder.create();
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
        TextView textView = (TextView) dialog.findViewById(R.id.home_dialog_determine);
        TextView textView1 = (TextView) dialog.findViewById(R.id.dialog_text);
        TextView textView2 = (TextView) dialog.findViewById(R.id.home_dialog);
        textView2.setVisibility(View.GONE);
        textView1.setText("敬请期待");
        textView.setText("好的");
        textView.setTextColor(getResources().getColor(R.color.color_bea571));
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
    }

    private void initOkhttp() {
        App.myOkHttp
                .postParams()
                .url(UrlUtilds.GET_MYSELF)
                .addParam("api", "myself/myself")
                .addParam("appid", UrlUtilds.APPID)
                .addParam("t", String.valueOf(System.currentTimeMillis()))
                .addParam("token", UserUtils.getToken())
                .addParam("user_id", UserUtils.getUserId())
                .enqueue(new GsonResponseHandler<MyFragmentBean>() {
                    @Override
                    public void onSuccess(int statusCode, MyFragmentBean response) {
                        int waitpay = response.getMsg().getWait_pay();
                        int waitship = response.getMsg().getWait_ship();
                        int waitrece = response.getMsg().getWait_rece();
                        int nocommon = response.getMsg().getNo_common();
                        int refund = response.getMsg().getRefund();

                        if (waitpay == 0) {
                            mDaifukuanNum.setVisibility(View.GONE);
                        } else if (waitpay > 0 || waitpay < 100) {
                            mDaifukuanNum.setVisibility(View.VISIBLE);
                            mDaifukuanNum.setText(waitpay + "");
                        } else if (waitpay >= 100) {
                            mDaifukuanNum.setVisibility(View.VISIBLE);
                            mDaifukuanNum.setText("...");
                        }
                        if (waitship == 0) {
                            mDaifahuoNum.setVisibility(View.GONE);
                        } else if (waitship > 0 || waitship < 100) {
                            mDaifahuoNum.setVisibility(View.VISIBLE);
                            mDaifahuoNum.setText(waitship + "");
                        } else if (waitship >= 100) {
                            mDaifahuoNum.setVisibility(View.VISIBLE);
                            mDaifahuoNum.setText("...");
                        }
                        if (waitrece == 0) {
                            mDashouhuoNum.setVisibility(View.GONE);
                        } else if (waitrece > 0 || waitrece < 100) {
                            mDashouhuoNum.setVisibility(View.VISIBLE);
                            mDashouhuoNum.setText(waitrece + "");
                        } else if (waitrece >= 100) {
                            mDashouhuoNum.setVisibility(View.VISIBLE);
                            mDashouhuoNum.setText("...");
                        }
//                        if (nocommon == 0) {
//                            mDaifukuanNum.setVisibility(View.GONE);
//                        } else if (nocommon > 0 || nocommon < 100) {
//                            mDaifukuanNum.setText(nocommon + "");
//                        } else if (nocommon >= 100) {
//                            mDaifukuanNum.setText("...");
//                        }
                        if (refund == 0) {
                            mTuihuotuikuanNum.setVisibility(View.GONE);
                        } else if (refund > 0 || refund < 100) {
                            mTuihuotuikuanNum.setVisibility(View.VISIBLE);
                            mTuihuotuikuanNum.setText(waitpay + "");
                        } else if (refund >= 100) {
                            mTuihuotuikuanNum.setVisibility(View.VISIBLE);
                            mTuihuotuikuanNum.setText("...");
                        }


                    }

                    @Override
                    public void onFailure(int statusCode, String error_msg) {

                    }
                });
    }


}
