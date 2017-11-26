package hlks.hualiangou.com.ks_android.view.home;

import android.content.Context;
import android.graphics.Paint;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Collection;

import hlks.hualiangou.com.ks_android.R;
import hlks.hualiangou.com.ks_android.base.BaseAdapterb.BaseRecyclerAdapter;
import hlks.hualiangou.com.ks_android.base.BaseAdapterb.ViewHolder;
import hlks.hualiangou.com.ks_android.modle.bean.HomefragmentBean;
import hlks.hualiangou.com.ks_android.modle.url.UrlUtilds;
import hlks.hualiangou.com.ks_android.utils.encryption.DensityUtil;
import hlks.hualiangou.com.ks_android.view.BaseDevrisLayoutView;


/**
 * Created by cuijl on 2017/2/11.
 */

public class HomeTuiJianView extends BaseDevrisLayoutView {

    LinearLayout ll_all;
    RecyclerView rListview;
    MaAdapter adapter;
    AdapterView.OnItemClickListener listener;

    public HomeTuiJianView(Context context, AdapterView.OnItemClickListener listener) {
        super(context);
        this.listener = listener;
        if (this.listener != null) {
            adapter.setOnItemClickListener(this.listener);
        }
    }

    public HomeTuiJianView(Context context) {
        super(context);
    }



    @Override
    public View initView() {
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_home_tuijian, null);
        int screenWidth = DensityUtil.getDisplayWidth(mContext);
        ll_all = $(view, R.id.ll_all);
        rListview = $(view, R.id.rListview);
        ll_all.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        rListview.setLayoutManager(new GridLayoutManager(mContext,3));
        adapter = new MaAdapter(R.layout.item_adapter_tuijian);
        rListview.setAdapter(adapter);
        return view;
    }
    public void setData(Collection<HomefragmentBean.MsgBean.RecommendBean> collection) {
        adapter.refresh(collection);
    }
class MaAdapter extends BaseRecyclerAdapter<HomefragmentBean.MsgBean.RecommendBean> {
    public MaAdapter(@LayoutRes int layoutId) {
        super(layoutId);
    }

    @Override
    protected void conver(ViewHolder holder, HomefragmentBean.MsgBean.RecommendBean modle, int position) {
        holder.setText(R.id.tv_money, "¥"+modle.getShop_start_money());
        holder.setText(R.id.old_money, "¥"+modle.getShop_end_money());
        TextView textView = (TextView) holder.findViewById(R.id.old_money);
        textView.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG);
        holder.setText(R.id.tv_title, modle.getShop_name());
        holder.setRoundImages(R.id.iv_img, UrlUtilds.IMG_URL + modle.getImage_path());
    }
}
}
