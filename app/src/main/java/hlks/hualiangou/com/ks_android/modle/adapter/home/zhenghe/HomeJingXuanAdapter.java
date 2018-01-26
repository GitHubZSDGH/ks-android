package hlks.hualiangou.com.ks_android.modle.adapter.home.zhenghe;

import android.graphics.Paint;
import android.support.annotation.LayoutRes;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import java.util.Collection;

import hlks.hualiangou.com.ks_android.R;
import hlks.hualiangou.com.ks_android.base.BaseAdapterb.BaseRecyclerAdapter;
import hlks.hualiangou.com.ks_android.base.BaseAdapterb.ViewHolder;
import hlks.hualiangou.com.ks_android.modle.bean.HomefragmentBean;
import hlks.hualiangou.com.ks_android.modle.url.UrlUtilds;

/**
 * 项目名称:
 * 类描述:
 * 创建时间:2017/12/11
 */
public class HomeJingXuanAdapter extends BaseRecyclerAdapter<HomefragmentBean.MsgBean.FeaturedBean.ShopBean> {


    public HomeJingXuanAdapter(Collection<HomefragmentBean.MsgBean.FeaturedBean.ShopBean> collection, @LayoutRes int layoutId, AdapterView.OnItemClickListener listener) {
        super(collection, layoutId, listener);
    }

    @Override
    protected void conver(ViewHolder holder, HomefragmentBean.MsgBean.FeaturedBean.ShopBean modle, int position) {
        holder.setText(R.id.tv_money, "¥"+modle.getShop_start_money());
        holder.setText(R.id.old_money, "¥"+modle.getShop_end_money());
        TextView textView = (TextView) holder.findViewById(R.id.tv_money);
        textView.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG);
        textView.setVisibility(View.GONE);
        holder.setText(R.id.tv_title, modle.getShop_name());
        holder.setRoundImages(R.id.iv_img, UrlUtilds.IMG_URL + modle.getImage_path());
        if(modle.getIs_integral()!=0){
            TextView jifen = (TextView) holder.findViewById(R.id.jifen_back);
            jifen.setVisibility(View.VISIBLE);
            jifen.setText("可用 "+ modle.getIntegral() + " 积分兑换");
        }
    }
}
