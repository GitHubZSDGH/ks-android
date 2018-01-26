package hlks.hualiangou.com.ks_android.activity.main;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import hlks.hualiangou.com.ks_android.R;
import hlks.hualiangou.com.ks_android.activity.LoginActivity;
import hlks.hualiangou.com.ks_android.base.BaseActivity;
import hlks.hualiangou.com.ks_android.utils.KeyUtils;
import hlks.hualiangou.com.ks_android.utils.SharedPreferencesUtils;

/**
 * 设置界面
 */
public class AccountSettingActivity extends BaseActivity implements View.OnClickListener {

    private ImageView mGoBackImg;
    /**
     * 返回
     */
    private TextView mGetBackTv;
    private RelativeLayout mGoBack;
    /**
     * 账户设置
     */
    private TextView mTitleTv;
    private LinearLayout mPersonalInformation;
    private LinearLayout mAddressManage;
    private LinearLayout mAccountSecurity;
    private LinearLayout mAssociatedAccount;
    private LinearLayout mClearCache;
    /**
     * v1.0.1
     */
    private TextView mVersionNumber;
    private LinearLayout mAboutUs;
    /**
     * 退出登录
     */
    private TextView mFinishLogin;

    @Override
    public int getLayoutId() {
        return R.layout.activity_account_setting;
    }

    @Override
    public void initView() {

        mGoBackImg = (ImageView) findViewById(R.id.go_back_img);
        mGetBackTv = (TextView) findViewById(R.id.get_back_tv);
        mGoBack = (RelativeLayout) findViewById(R.id.go_back);
        mTitleTv = (TextView) findViewById(R.id.title_tv);
        mPersonalInformation = (LinearLayout) findViewById(R.id.personal_information);
        mPersonalInformation.setOnClickListener(this);
        mAddressManage = (LinearLayout) findViewById(R.id.Address_manage);
        mAddressManage.setOnClickListener(this);
        mAccountSecurity = (LinearLayout) findViewById(R.id.account_security);
        mAccountSecurity.setOnClickListener(this);
        mAssociatedAccount = (LinearLayout) findViewById(R.id.associated_account);
        mAssociatedAccount.setOnClickListener(this);
        mClearCache = (LinearLayout) findViewById(R.id.clear_cache);
        mClearCache.setOnClickListener(this);
        mVersionNumber = (TextView) findViewById(R.id.version_number);
        mVersionNumber.setOnClickListener(this);
        mAboutUs = (LinearLayout) findViewById(R.id.about_us);
        mAboutUs.setOnClickListener(this);
        mFinishLogin = (TextView) findViewById(R.id.finish_login);
        mFinishLogin.setOnClickListener(this);
        mGoBackImg.setOnClickListener(this);
        mGetBackTv.setOnClickListener(this);
        mGoBack.setOnClickListener(this);
        mTitleTv.setOnClickListener(this);
    }

    @Override
    public void loadData() {

    }

    @Override
    public void setListener() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            /**
             * 个人信息
             */
            case R.id.personal_information:
                startActivity(new Intent(AccountSettingActivity.this, PersonalInformationActivity.class));
                break;
            /**
             * 地址管理
             */
            case R.id.Address_manage:
                break;
            /**
             * 账户安全
             */
            case R.id.account_security:
                startActivity(new Intent(AccountSettingActivity.this, AccountSecurityActivity.class));
                break;
            /**
             * 关联账号
             */
            case R.id.associated_account:
                break;
            /**
             * 清除缓存
             */
            case R.id.clear_cache:
                break;
            /**
             * 版本号
             */
            case R.id.version_number:
                break;
            /**
             * 关于我们
             */
            case R.id.about_us:
                break;
            /**
             * 退出登录
             */
            case R.id.finish_login:
                SharedPreferencesUtils.remove(KeyUtils.USER_TOKEN);
                startActivity(new Intent(AccountSettingActivity.this, LoginActivity.class));
                break;
            case R.id.go_back_img:
                finish();
                break;
            case R.id.get_back_tv:
                break;
            case R.id.go_back:
                finish();
                break;
            case R.id.title_tv:
                break;
        }
    }

}
