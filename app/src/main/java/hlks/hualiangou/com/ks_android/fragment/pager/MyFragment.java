package hlks.hualiangou.com.ks_android.fragment.pager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import hlks.hualiangou.com.ks_android.R;
import hlks.hualiangou.com.ks_android.activity.LoginActivity;
import hlks.hualiangou.com.ks_android.activity.main.AccountSettingActivity;
import hlks.hualiangou.com.ks_android.activity.main.MainOrderActivity;
import hlks.hualiangou.com.ks_android.base.BaseFragment;
import hlks.hualiangou.com.ks_android.config.FragmentBuilder;
import hlks.hualiangou.com.ks_android.utils.KeyUtils;
import hlks.hualiangou.com.ks_android.utils.SharedPreferencesUtils;
import hlks.hualiangou.com.ks_android.utils.UserUtils;
import hlks.hualiangou.com.ks_android.view.img.RoundedImageView;

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
    }

    @Override
    public void loadData() {
        if (!UserUtils.getToken().isEmpty()) {
//            startActivity(new Intent(baseActivity, LoginActivity.class));

            mUserId.setText(UserUtils.getUserPhone().toString());
            return;
        } else {

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
                break;
            case R.id.shoucang:
                break;
            case R.id.pingjia:
                break;
            case R.id.zuji:
                break;
            case R.id.daifukuan:
                startActivity(new Intent(baseActivity, MainOrderActivity.class));
                break;
            case R.id.daifahuo:
                break;
            case R.id.dashouhuo:
                break;
            case R.id.tuihuotuikuan:
                break;
            case R.id.pingtaitongzhi:
                break;
            case R.id.fuwufankui:
                break;
            case R.id.shezhizhongxin:
                startActivity(new Intent(baseActivity, AccountSettingActivity.class));
                break;
            case R.id.roundedImageView:
                if (UserUtils.getToken().isEmpty()) {
                    myDialogText();
                    return;
                }
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
}
