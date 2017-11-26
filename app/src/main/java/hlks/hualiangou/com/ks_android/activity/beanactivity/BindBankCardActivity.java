package hlks.hualiangou.com.ks_android.activity.beanactivity;

import android.content.Intent;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import hlks.hualiangou.com.ks_android.R;
import hlks.hualiangou.com.ks_android.base.BaseActivity;
import hlks.hualiangou.com.ks_android.view.CertificationDialog;

/**
 * 项目名称:
 * 类描述:
 * 创建人:lenovo
 * 创建时间:2017/11/14
 * 修改人:
 * 修改内容:
 */
public class BindBankCardActivity extends BaseActivity implements View.OnClickListener {
    private Button mBack_type;
    private CertificationDialog cfd;
    private TextView mbean_title;
    private ImageView mHandBack;
    @Override
    public int getLayoutId() {
        return R.layout.bind_bank_cardactivity;
    }

    @Override
    public void initView() {
        mBack_type = (Button) findViewById(R.id.next_go);
        mbean_title = (TextView) findViewById(R.id.bean_title);
        mbean_title.setText("绑定银行卡");
        mHandBack = (ImageView) findViewById(R.id.hand_back);
    }

    @Override
    public void loadData() {

    }

    @Override
    public void setListener() {
        mBack_type.setOnClickListener(this);
        mHandBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.next_go:
                cfd = new CertificationDialog(this,itemsOnClick);
                cfd.showAtLocation(mBack_type, Gravity.CENTER
                        , 0, 0);
                break;
            case R.id.hand_back:
                finish();
                break;

        }
    }
    private View.OnClickListener itemsOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            cfd.dismiss();
            switch (v.getId()) {
                case R.id.Verify_Now_tv:
                    Intent intent = new Intent(BindBankCardActivity.this,CurrentBeannumberActivity.class);
                    startActivity(intent);
                    break;
                case R.id.close_real_name:
                    cfd.dismiss();
                    break;

            }

        }
    };
}
