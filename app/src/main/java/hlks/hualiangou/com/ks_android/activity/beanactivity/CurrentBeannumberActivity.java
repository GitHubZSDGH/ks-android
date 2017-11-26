package hlks.hualiangou.com.ks_android.activity.beanactivity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import hlks.hualiangou.com.ks_android.R;
import hlks.hualiangou.com.ks_android.base.BaseActivity;

/**
 * 项目名称:
 * 类描述:
 * 创建人:lenovo
 * 创建时间:2017/11/14
 * 修改人:
 * 修改内容:
 */
public class CurrentBeannumberActivity extends BaseActivity implements View.OnClickListener {
    private Button mRecharge;//充值
    private Button mWithdraw;//提现
    private RelativeLayout mBack_item;
    private RelativeLayout mbean_detail_Relative;
    private ImageView mexplain_img;//跳转联豆界面
    private ImageView mHandBack;
    @Override
    public int getLayoutId() {
        return R.layout.currentbean_number_activity;
    }

    @Override
    public void initView() {
        mRecharge = (Button) findViewById(R.id.Recharge);
        mWithdraw = (Button) findViewById(R.id.Withdraw);
        mBack_item = (RelativeLayout) findViewById(R.id.back_item);
        mbean_detail_Relative = (RelativeLayout) findViewById(R.id.bean_detail_Relative);
        mexplain_img = (ImageView) findViewById(R.id.explain_img);
        mHandBack = (ImageView) findViewById(R.id.hand_back);
    }

    @Override
    public void loadData() {

    }

    @Override
    public void setListener() {
        mRecharge.setOnClickListener(this);
        mWithdraw.setOnClickListener(this);
        mBack_item.setOnClickListener(this);
        mbean_detail_Relative.setOnClickListener(this);
        mexplain_img.setOnClickListener(this);
        mHandBack.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.Recharge:
                Intent intent = new Intent(this,RechargeActivity.class);
                startActivity(intent);
                break;
            case R.id.Withdraw:
                Intent intent1 = new Intent(this,WithdrawActivity.class);
                startActivity(intent1);
                break;
            case R.id.back_item:
                Intent intent2 = new Intent(this,BackListActivity.class);
                startActivity(intent2);
                break;
            case R.id.bean_detail_Relative:
                Intent intent3 = new Intent(this,BeanDetailActivity.class);
                startActivity(intent3);
                break;
            case R.id.explain_img:
                Intent intent4 = new Intent(this,ExplainActivity.class);
                startActivity(intent4);
                break;
            case R.id.hand_back:
                finish();
                break;
        }
    }
}
