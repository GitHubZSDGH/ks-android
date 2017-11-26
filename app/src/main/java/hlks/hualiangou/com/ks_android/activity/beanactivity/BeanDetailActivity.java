package hlks.hualiangou.com.ks_android.activity.beanactivity;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import hlks.hualiangou.com.ks_android.R;
import hlks.hualiangou.com.ks_android.activity.MainActivity;
import hlks.hualiangou.com.ks_android.base.BaseActivity;
import hlks.hualiangou.com.ks_android.modle.adapter.BeanDetailAdapter;

/**
 * 项目名称:
 * 类描述:银行卡列表
 * 创建人:lenovo
 * 创建时间:2017/11/14
 * 修改人:
 * 修改内容:
 */
public class BeanDetailActivity extends BaseActivity implements View.OnClickListener {
    private ListView bean_listview;
    private BeanDetailAdapter beanDetailAdapter;
    private List<String> detailList = new ArrayList<>();
    private TextView mbean_title;
    private LinearLayout mgetMessage;//联系客服按钮
    private ImageView mHandBack;


    @Override
    public int getLayoutId() {
        return R.layout.bean_detail_activity;
    }

    @Override
    public void initView() {
        bean_listview = (ListView) findViewById(R.id.bean_listview);
        mbean_title = (TextView) findViewById(R.id.bean_title);
        mgetMessage = (LinearLayout) findViewById(R.id.getMessage);
        mbean_title.setText("联豆明细");
        mHandBack = (ImageView) findViewById(R.id.hand_back);
    }

    @Override
    public void loadData() {
        //===================死值==========
        for (int i = 0; i<60;i++){
            detailList.add("银行卡"+i);
        }
        beanDetailAdapter = new BeanDetailAdapter(this,detailList);
        bean_listview.setAdapter(beanDetailAdapter);
        beanDetailAdapter.notifyDataSetChanged();
    }

    @Override
    public void setListener() {
        mgetMessage.setOnClickListener(this);
        mHandBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.getMessage:
                Intent intent = new Intent(BeanDetailActivity.this,MainActivity.class);
                intent.putExtra("getMessage","1");
                startActivityForResult(intent,1);
                finish();
                break;
            case R.id.hand_back:
                finish();
                break;
        }
    }
}
