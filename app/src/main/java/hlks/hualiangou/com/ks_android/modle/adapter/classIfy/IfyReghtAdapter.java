package hlks.hualiangou.com.ks_android.modle.adapter.classIfy;

import android.support.annotation.LayoutRes;

import hlks.hualiangou.com.ks_android.R;
import hlks.hualiangou.com.ks_android.base.BaseAdapterb.BaseRecyclerAdapter;
import hlks.hualiangou.com.ks_android.base.BaseAdapterb.ViewHolder;
import hlks.hualiangou.com.ks_android.modle.bean.ClassIfygragmentBean;

/**
 * 项目名称:
 * 类描述:
 * 创建人:lenovo
 * 创建时间:2017/11/17
 * 修改人:
 * 修改内容:
 */
public class IfyReghtAdapter extends BaseRecyclerAdapter<ClassIfygragmentBean.MsgBean.TwoBean> {

    public IfyReghtAdapter(@LayoutRes int layoutId) {
        super(R.layout.item_right_type);
    }

    @Override
    protected void conver(ViewHolder holder, ClassIfygragmentBean.MsgBean.TwoBean modle, int position) {
        holder.setText(R.id.tv_ify_title,modle.getCategroy_name());

    }
}
