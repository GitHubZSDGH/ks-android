package hlks.hualiangou.com.ks_android.activity.orderdetails;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hlks.hualiangou.com.ks_android.R;
import hlks.hualiangou.com.ks_android.base.BaseActivity;

/**
 * 接收地址
 */
public class ReceivingAddressActivity extends BaseActivity {

    @BindView(R.id.receiving_address_return)
    ImageView receivingAddressReturn;
    @BindView(R.id.ll_receiving_address)
    ListView llReceivingAddress;
    @BindView(R.id.new_add_address)
    TextView newAddAddress;

    @Override
    public int getLayoutId() {
        return R.layout.activity_receiving_address;
    }

    @Override
    public void initView() {

    }

    @Override
    public void loadData() {

    }

    @Override
    public void setListener() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.receiving_address_return, R.id.new_add_address})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.receiving_address_return:
                finish();
                break;
            case R.id.new_add_address:
                initOkHttp();
                break;
        }
    }

    private void initOkHttp() {

    }
}
