package hlks.hualiangou.com.ks_android.activity.main;


import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import hlks.hualiangou.com.ks_android.R;
import hlks.hualiangou.com.ks_android.base.BaseActivity;

/**
 * 账户安全
 */
public class AccountSecurityActivity extends BaseActivity implements View.OnClickListener {


    private ImageView mGoBackImg;
    /**
     * name
     */
    private TextView mNickName;
    private LinearLayout mHeadPortrait;
    private TextView mPersonalPhone;
    private LinearLayout mUpdatePhone;
    private TextView mPersonalSexTv;
    private LinearLayout mUpdateLoginPsd;

    @Override
    public int getLayoutId() {
        return R.layout.activity_account_security;
    }

    @Override
    public void initView() {

        mGoBackImg = (ImageView) findViewById(R.id.go_back_img);
        mGoBackImg.setOnClickListener(this);
        mNickName = (TextView) findViewById(R.id.nick_name);
        mHeadPortrait = (LinearLayout) findViewById(R.id.head_portrait);
        mHeadPortrait.setOnClickListener(this);
        mPersonalPhone = (TextView) findViewById(R.id.personal_phone);
        mUpdatePhone = (LinearLayout) findViewById(R.id.update_phone);
        mUpdatePhone.setOnClickListener(this);
        mUpdateLoginPsd = (LinearLayout) findViewById(R.id.update_login_psd);
        mUpdateLoginPsd.setOnClickListener(this);
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
            case R.id.go_back_img:
                finish();
                break;
            /**
             * 修改手机号
             */
            case R.id.update_phone:
                break;
            /**
             * 修改密码
             */
            case R.id.update_login_psd:
                break;
        }
    }
}
