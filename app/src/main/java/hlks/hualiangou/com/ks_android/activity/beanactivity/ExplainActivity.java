package hlks.hualiangou.com.ks_android.activity.beanactivity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import hlks.hualiangou.com.ks_android.R;
import hlks.hualiangou.com.ks_android.base.BaseActivity;

/**
 * 项目名称:
 * 类描述:联豆说明界面
 * 创建人:lenovo
 * 创建时间:2017/11/14
 * 修改人:
 * 修改内容:
 */
public class ExplainActivity extends BaseActivity implements View.OnClickListener {
    private TextView mbean_title;//标题
    private ImageView mHandBack;
    @Override
    public int getLayoutId() {
        return R.layout.explain_activity;
    }

    @Override
    public void initView() {
        mbean_title = (TextView) findViewById(R.id.bean_title);
        mbean_title.setText("联豆说明");
        mHandBack = (ImageView) findViewById(R.id.hand_back);
    }

    @Override
    public void loadData() {

    }

    @Override
    public void setListener() {
        mHandBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.hand_back:
                finish();
                break;
        }
    }
}
