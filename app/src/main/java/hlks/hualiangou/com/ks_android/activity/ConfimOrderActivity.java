package hlks.hualiangou.com.ks_android.activity;

import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import hlks.hualiangou.com.ks_android.R;
import hlks.hualiangou.com.ks_android.base.BaseActivity;

/**
 * 确认订单
 */

public class ConfimOrderActivity extends BaseActivity {
private RelativeLayout mHaveAdress;
private LinearLayout mAddAdress;

    @Override
    public int getLayoutId() {
        return R.layout.activity_confirm_order;
    }

    @Override
    public void initView() {
      mHaveAdress = (RelativeLayout) findViewById(R.id.confim_have_adress);
      mAddAdress = (LinearLayout) findViewById(R.id.add_order_address);


    }

    @Override
    public void loadData() {

    }

    @Override
    public void setListener() {

    }
}
