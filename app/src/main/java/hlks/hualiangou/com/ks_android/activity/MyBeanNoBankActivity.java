package hlks.hualiangou.com.ks_android.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import hlks.hualiangou.com.ks_android.R;
import hlks.hualiangou.com.ks_android.activity.beanactivity.BindBankCardActivity;
import hlks.hualiangou.com.ks_android.base.BaseActivity;

/**
 * 项目名称:
 * 类描述:联豆
 * 创建人:lenovo
 * 创建时间:2017/11/14
 * 修改人:
 * 修改内容:
 */
public class MyBeanNoBankActivity extends BaseActivity implements View.OnClickListener {
    private Button mAdd_Back;
    private ImageView mHandBack;

    @Override
    public int getLayoutId() {
        return R.layout.my_bean_no_backactivity;
    }

    @Override
    public void initView() {
mAdd_Back = (Button) findViewById(R.id.add_back);
        mHandBack = (ImageView) findViewById(R.id.hand_back);
    }

    @Override
    public void loadData() {

    }

    @Override
    public void setListener() {
        mAdd_Back.setOnClickListener(this);
        mHandBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.add_back:
                Intent intent = new Intent(this,BindBankCardActivity.class);
                startActivity(intent);
                break;
            case R.id.hand_back:
               finish();
                break;
        }
    }
}
