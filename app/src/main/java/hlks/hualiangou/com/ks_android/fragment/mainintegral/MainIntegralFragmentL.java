package hlks.hualiangou.com.ks_android.fragment.mainintegral;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import hlks.hualiangou.com.ks_android.R;
import hlks.hualiangou.com.ks_android.activity.main.adapter.JifenAdapter;
import hlks.hualiangou.com.ks_android.base.BaseFragment;
import hlks.hualiangou.com.ks_android.modle.bean.MainIntegralBean;

/**
 * Created by lenovo on 2018/1/29.
 */

public class MainIntegralFragmentL extends BaseFragment {
    private View view;
    private ListView mMainIntegralLv;
    private ArrayList<MainIntegralBean.MsgBean.IntegralListBean> list;
    private JifenAdapter myAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_mainintegrall;
    }

    @Override
    public void initView(View view) {
        mMainIntegralLv = (ListView) view.findViewById(R.id.main_integral_lv);

    }

    @Override
    public void loadData() {

    }

    @Override
    public void setListener() {

    }

    @Override
    public void getBundle(Bundle bundle) {
        super.getBundle(bundle);
        list = bundle.getParcelableArrayList("shopImage");
        myAdapter = new JifenAdapter(baseActivity, list, R.layout.item_mainintegral_ll);
        mMainIntegralLv.setAdapter(myAdapter);
    }
}
