package hlks.hualiangou.com.ks_android.activity.main;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import hlks.hualiangou.com.ks_android.R;
import hlks.hualiangou.com.ks_android.base.BaseActivity;

public class UpdatePsdActivity extends BaseActivity implements View.OnClickListener {

    private ImageView mGoBackImg;
    /**
     * 返回
     */
    private TextView mGetBackTv;
    private RelativeLayout mGoBack;
    /**
     * 修改密码
     */
    private TextView mTitleTv;
    /**
     * 请输入原密码
     */
    private EditText mOriginalCipher;
    /**
     * 请输入8-16字符
     */
    private EditText mNewCipher;
    /**
     * 请确认密码
     */
    private EditText mConfirmNewCipher;
    /**
     * 确认修改
     */
    private Button mConfirmUpdateBtn;

    @Override
    public int getLayoutId() {
        return R.layout.activity_update_psd;
    }

    @Override
    public void initView() {

        mGoBackImg = (ImageView) findViewById(R.id.go_back_img);
        mGetBackTv = (TextView) findViewById(R.id.get_back_tv);
        mGoBack = (RelativeLayout) findViewById(R.id.go_back);
        mTitleTv = (TextView) findViewById(R.id.title_tv);
        mOriginalCipher = (EditText) findViewById(R.id.original_cipher);
        mNewCipher = (EditText) findViewById(R.id.new_cipher);
        mConfirmNewCipher = (EditText) findViewById(R.id.confirm_new_cipher);
        mConfirmUpdateBtn = (Button) findViewById(R.id.confirm_update_btn);
        mConfirmUpdateBtn.setOnClickListener(this);
        mGoBackImg.setOnClickListener(this);
        mGetBackTv.setOnClickListener(this);
        mGoBack.setOnClickListener(this);
        mTitleTv.setOnClickListener(this);
        mOriginalCipher.setOnClickListener(this);
        mNewCipher.setOnClickListener(this);
        mConfirmNewCipher.setOnClickListener(this);
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
            case R.id.confirm_update_btn:
                break;
            case R.id.go_back_img:
                finish();
                break;
            case R.id.original_cipher:
                break;
            case R.id.new_cipher:
                break;
            case R.id.confirm_new_cipher:
                break;
        }
    }


}
