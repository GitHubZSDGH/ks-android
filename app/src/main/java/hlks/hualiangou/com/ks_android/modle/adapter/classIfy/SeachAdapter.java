package hlks.hualiangou.com.ks_android.modle.adapter.classIfy;

import android.support.annotation.LayoutRes;
import android.widget.AdapterView;

import java.util.Collection;

import hlks.hualiangou.com.ks_android.base.BaseAdapterb.BaseRecyclerAdapter;
import hlks.hualiangou.com.ks_android.base.BaseAdapterb.ViewHolder;
import hlks.hualiangou.com.ks_android.modle.bean.Seachbean;

/**
 * 项目名称:
 * 类描述:
 * 创建人:lenovo
 * 创建时间:2017/11/18
 * 修改人:
 * 修改内容:
 */
public class SeachAdapter extends BaseRecyclerAdapter<Seachbean.MsgBean.ShopBean> {
    public SeachAdapter(Collection<Seachbean.MsgBean.ShopBean> collection, @LayoutRes int layoutId, AdapterView.OnItemClickListener listener) {
        super(collection, layoutId, listener);
    }

    @Override
    protected void conver(ViewHolder holder, Seachbean.MsgBean.ShopBean modle, int position) {

    }
}
