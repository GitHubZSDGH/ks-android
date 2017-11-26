package hlks.hualiangou.com.ks_android.activity.beanactivity;

import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import hlks.hualiangou.com.ks_android.R;
import hlks.hualiangou.com.ks_android.base.BaseActivity;
import hlks.hualiangou.com.ks_android.modle.adapter.BackListAdapter;

/**
 * 项目名称:
 * 类描述:
 * 创建人:lenovo
 * 创建时间:2017/11/14
 * 修改人:
 * 修改内容:
 */
public class BackListActivity extends BaseActivity implements View.OnClickListener{
    private ListView listView;
    private List<String> backList = new ArrayList<>();
    private BackListAdapter backListAdapter;
    private TextView mbean_title;
    @Override
    public int getLayoutId() {
        return R.layout.back_list_activity;
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
    public void onClick(View view) {

    }
}
