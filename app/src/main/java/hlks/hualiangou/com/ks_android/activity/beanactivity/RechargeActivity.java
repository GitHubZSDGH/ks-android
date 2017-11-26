package hlks.hualiangou.com.ks_android.activity.beanactivity;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import hlks.hualiangou.com.ks_android.R;
import hlks.hualiangou.com.ks_android.base.BaseActivity;
import hlks.hualiangou.com.ks_android.view.OKRechargePopuwindow;

/**
 * 项目名称:
 * 类描述:
 * 创建人:lenovo
 * 创建时间:2017/11/14
 * 修改人:
 * 修改内容:
 */
public class RechargeActivity extends BaseActivity implements CompoundButton.OnCheckedChangeListener,View.OnClickListener{

    private TextView mbean_title;//标题
    private Button mok_recharge_btn;//确认充值
    private EditText mRecharge_bean_number_et;//充值联豆数量
    private CheckBox mpay_back_ck;
    private CheckBox mpay_Wechat_ck;
    private CheckBox mpay_Alipay_ck;
    private LinearLayout mOk_Bean_Number;
    private TextView mbean_number_tv;
    private OKRechargePopuwindow okRechargePopuwindow;
    private String BeanNumber;//获取充值联豆数量
    private String Pay_stye = "Unionpay";//默认是银联支付
    private ImageView mHandBack;
    @Override
    public int getLayoutId() {
        return R.layout.recharge_activity;
    }

    @Override
    public void initView() {
        mbean_title = (TextView) findViewById(R.id.bean_title);
        mpay_back_ck = (CheckBox) findViewById(R.id.pay_back_ck);
        mpay_Wechat_ck = (CheckBox) findViewById(R.id.pay_Wechat_ck);
        mpay_Alipay_ck = (CheckBox) findViewById(R.id.pay_Alipay_ck);
        mok_recharge_btn = (Button) findViewById(R.id.ok_recharge_btn);
        mOk_Bean_Number = (LinearLayout) findViewById(R.id.Ok_Bean_Number);
        mbean_number_tv = (TextView) findViewById(R.id.bean_number_tv);
        mRecharge_bean_number_et = (EditText) findViewById(R.id.Recharge_bean_number_et);
        mbean_title.setText("联豆充值");
        mHandBack = (ImageView) findViewById(R.id.hand_back);
    }

    @Override
    public void loadData() {

    }

    @Override
    public void setListener() {
        mpay_back_ck.setOnCheckedChangeListener(this);
        mpay_Wechat_ck.setOnCheckedChangeListener(this);
        mpay_Alipay_ck.setOnCheckedChangeListener(this);
        mok_recharge_btn.setOnClickListener(this);
        mHandBack.setOnClickListener(this);
        mRecharge_bean_number_et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                mOk_Bean_Number.setVisibility(View.VISIBLE);
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }
            @Override
            public void afterTextChanged(Editable editable) {
                mbean_number_tv.setText(editable.toString());
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ok_recharge_btn:
              /*  okRechargePopuwindow = new OKRechargePopuwindow(this,itemsOnClick);
                okRechargePopuwindow.showAtLocation(mok_recharge_btn, Gravity.CENTER
                        , 0, 0);*/
                BeanNumber = mRecharge_bean_number_et.getText().toString();
                if(!BeanNumber.equals("")&&BeanNumber != null){
                    if (Pay_stye .equals("PayAlipay")){
                        Toast.makeText(RechargeActivity.this,"您选择了支付宝支付",Toast.LENGTH_SHORT).show();
                    }
                    if(Pay_stye .equals("PayWetchat")){
                        Toast.makeText(RechargeActivity.this,"您选择了微信支付",Toast.LENGTH_SHORT).show();
                    }
                    if(Pay_stye .equals("Unionpay")){
                        Toast.makeText(RechargeActivity.this,"您选择了银联支付",Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(this,"请填写您想要充值的联豆数量",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.hand_back:
                finish();
                break;
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
        if(isChecked){
            switch (compoundButton.getId()){
                case R.id.pay_back_ck:
                    mpay_Wechat_ck.setChecked(false);
                    mpay_Alipay_ck.setChecked(false);
                    Pay_stye = "Unionpay";
                    break;
                case R.id.pay_Wechat_ck:
                    mpay_back_ck.setChecked(false);
                    mpay_Alipay_ck.setChecked(false);
                    Pay_stye = "PayWetchat";
                    break;
                case R.id.pay_Alipay_ck:
                    mpay_Wechat_ck.setChecked(false);
                    mpay_back_ck.setChecked(false);
                    Pay_stye = "PayAlipay";
                    break;
            }
        }
    }
    private  View.OnClickListener itemsOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            okRechargePopuwindow.dismiss();
            switch (v.getId()) {
                case R.id.I_know:
                    okRechargePopuwindow.dismiss();
                    break;

            }

        }
    };
}
