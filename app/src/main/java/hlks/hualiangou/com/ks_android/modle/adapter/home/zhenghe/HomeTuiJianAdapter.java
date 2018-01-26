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
public class HomeTuiJianAdapter extends BaseRecyclerAdapter<HomefragmentBean.MsgBean.RecommendBean> {


    public HomeTuiJianAdapter(Collection<HomefragmentBean.MsgBean.RecommendBean> collection, @LayoutRes int layoutId, AdapterView.OnItemClickListener listener) {
        super(collection, layoutId, listener);
    }

    @Override
    protected void conver(ViewHolder holder, HomefragmentBean.MsgBean.RecommendBean modle, int position) {
        holder.setText(R.id.tv_money, "¥"+modle.getShop_end_money());
        holder.setText(R.id.old_money, "¥"+modle.getShop_start_money());
        TextView textView = (TextView) holder.findViewById(R.id.old_money);
        textView.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG);
        holder.setText(R.id.tv_title, modle.getShop_name());
        holder.setRoundImages(R.id.iv_img, UrlUtilds.IMG_URL + modle.getImage_path());
        if(modle.getIs_integral()!=0){
            TextView jifen = (TextView) holder.findViewById(R.id.jifen_back);
            jifen.setVisibility(View.VISIBLE);
            jifen.setText("可用 "+ modle.getIntegral() + " 积分兑换");
        }
    }
}
