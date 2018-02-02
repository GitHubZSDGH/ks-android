package hlks.hualiangou.com.ks_android.modle.adapter.home.zhenghe;

import android.support.annotation.LayoutRes;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import java.util.Collection;

import hlks.hualiangou.com.ks_android.R;
import hlks.hualiangou.com.ks_android.base.BaseAdapterb.BaseRecyclerAdapter;
import hlks.hualiangou.com.ks_android.base.BaseAdapterb.ViewHolder;
import hlks.hualiangou.com.ks_android.modle.bean.HomefragmentBeanbottom;
import hlks.hualiangou.com.ks_android.modle.url.UrlUtilds;

/**
 * 项目名称:
 * 类描述:
 * 创建时间:2017/12/11
 */
public class HomeReXiaoAdapter extends BaseRecyclerAdapter<HomefragmentBeanbottom.MsgBean.ShopHostBean.ShopBean> {

    public HomeReXiaoAdapter(Collection<HomefragmentBeanbottom.MsgBean.ShopHostBean.ShopBean> collection, @LayoutRes int layoutId, AdapterView.OnItemClickListener listener) {
        super(collection, layoutId, listener);
    }

    @Override
    protected void conver(ViewHolder holder, HomefragmentBeanbottom.MsgBean.ShopHostBean.ShopBean modle, int position) {
        holder.setText(R.id.tv_money, "¥"+modle.getShop_start_money());
        holder.setText(R.id.old_money, "¥"+modle.getShop_end_money());
        holder.setText(R.id.tv_title, modle.getShop_name());
        holder.setRoundImages(R.id.iv_img, UrlUtilds.IMG_URL + modle.getImage_path());
        if(modle.getIs_integral()!=0){
            TextView jifen = (TextView) holder.findViewById(R.id.jifen_back);
            jifen.setVisibility(View.VISIBLE);
            jifen.setText("可用 "+ modle.getIntegral() + " 积分兑换");
        }else {
            TextView jifen = (TextView) holder.findViewById(R.id.jifen_back);
            jifen.setVisibility(View.GONE);
        }
    }


}
