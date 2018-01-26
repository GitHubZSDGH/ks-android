package hlks.hualiangou.com.ks_android.activity.main;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import hlks.hualiangou.com.ks_android.R;
import hlks.hualiangou.com.ks_android.base.BaseActivity;
import hlks.hualiangou.com.ks_android.view.img.RoundedImageView;

/**
 * 个人信息
 */
public class PersonalInformationActivity extends BaseActivity implements View.OnClickListener {

    private ImageView mGoBackImg;
    private RoundedImageView mRoundedImageView;
    private LinearLayout mHeadPortrait;
    private TextView mPersonalName;
    private LinearLayout mNickName;
    private TextView mPersonalSexTv;
    private LinearLayout mPersonalSex;

    @Override
    public int getLayoutId() {
        return R.layout.activity_personal_information;
    }

    @Override
    public void initView() {

        mGoBackImg = (ImageView) findViewById(R.id.go_back_img);
        mGoBackImg.setOnClickListener(this);
        mRoundedImageView = (RoundedImageView) findViewById(R.id.roundedImageView);
        mHeadPortrait = (LinearLayout) findViewById(R.id.head_portrait);
        mHeadPortrait.setOnClickListener(this);
        mPersonalName = (TextView) findViewById(R.id.personal_name);
        mNickName = (LinearLayout) findViewById(R.id.nick_name);
        mNickName.setOnClickListener(this);
        mPersonalSexTv = (TextView) findViewById(R.id.personal_sex_tv);
        mPersonalSex = (LinearLayout) findViewById(R.id.personal_sex);
        mPersonalSex.setOnClickListener(this);
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
             * 头像
             */
            case R.id.head_portrait:
                break;
            /**
             * 昵称
             */
            case R.id.nick_name:
                break;
            /**
             * 性别
             */
            case R.id.personal_sex:
                break;
        }
    }
}
