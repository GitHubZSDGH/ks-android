package hlks.hualiangou.com.ks_android.fragment.pager;

import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;

import hlks.hualiangou.com.ks_android.R;
import hlks.hualiangou.com.ks_android.activity.MyBeanNoBankActivity;
import hlks.hualiangou.com.ks_android.base.BaseFragment;

/**
 * 项目名称:
 * 类描述:
 * 创建人:lenovo
 * 创建时间:2017/11/10
 * 修改人:
 * 修改内容:
 */
public class MyFragment extends BaseFragment implements View.OnClickListener {
    //布局id；
    private LinearLayout mMy_bean;//我的联豆

    //获取布局
    @Override
    public int getLayoutId() {
        return R.layout.my_fragment;
    }

    @Override
    public void initView(View view) {
        mMy_bean = (LinearLayout) view.findViewById(R.id.My_bean);
    }

    @Override
    public void loadData() {

    }

    @Override
    public void setListener() {
        mMy_bean.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.My_bean:
                Intent intent = new Intent(getActivity(), MyBeanNoBankActivity.class);
                startActivity(intent);
                break;
        }
    }
}
