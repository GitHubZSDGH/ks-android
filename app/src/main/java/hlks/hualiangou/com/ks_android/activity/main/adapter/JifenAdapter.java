package hlks.hualiangou.com.ks_android.activity.main.adapter;

import android.content.Context;

import java.util.List;

import hlks.hualiangou.com.ks_android.R;
import hlks.hualiangou.com.ks_android.base.BaseAdapterb.ListAdapter;
import hlks.hualiangou.com.ks_android.modle.bean.MainIntegralBean;

/**
 * Created by lenovo on 2018/1/29.
 */

public class JifenAdapter extends ListAdapter<MainIntegralBean.MsgBean.IntegralListBean> {
    public JifenAdapter(Context mContext, List<MainIntegralBean.MsgBean.IntegralListBean> list, int resId) {
        super(mContext, list, resId);
    }

    @Override
    public void conver(ViewHolder viewHolder, MainIntegralBean.MsgBean.IntegralListBean integralListBean, int position) {
        viewHolder.setText(R.id.shop_name_tv,integralListBean.getIntegral_use());
        viewHolder.setText(R.id.main_integral_num,integralListBean.getIntegral_num());
        viewHolder.setText(R.id.shop_time_tv,integralListBean.getCreate_time());

    }
}
