package hlks.hualiangou.com.ks_android.modle.adapter.home;

import android.content.Context;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import hlks.hualiangou.com.ks_android.R;
import hlks.hualiangou.com.ks_android.modle.bean.HomefragmentBean;

/**
 * 作者：liukai
 * 创建时间：2017/10/9 14:31
 * 邮箱：liukai3099@163.com
 * 最近购买
 */
public class NewBuyAdapter extends RecyclerView.Adapter<NewBuyAdapter.ViewHolder>{
    private Context mContext;
    private List<HomefragmentBean.MsgBean.SpikeBean.SpikeShopBean> list;
    private OnItemClickLitener onItemClickLitener;
    public NewBuyAdapter(Context mContext, List<HomefragmentBean.MsgBean.SpikeBean.SpikeShopBean> recentPurchaseList, OnItemClickLitener onItemClickLitener) {
        this.mContext = mContext;
        this.list = recentPurchaseList;
        this.onItemClickLitener = onItemClickLitener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_new_buy, parent, false);
        ViewHolder  holder = new ViewHolder (view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        holder.old_money.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG);


    }

    @Override
    public int getItemCount() {
        if (list == null) {
            return 6;
        }
        if (list.size() > 6) {
            return 6;
        }
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder  {//我们需要inflate的item布局需要传入
        ImageView iv_img;
        TextView tv_title;
        TextView tv_money;
        TextView old_money;
        LinearLayout ll_all;
        public ViewHolder(View itemView) {
            super(itemView);
            iv_img = (ImageView) itemView.findViewById(R.id.iv_img);
            tv_title = (TextView) itemView.findViewById(R.id.tv_title);
            tv_money = (TextView) itemView.findViewById(R.id.tv_money);
            old_money = (TextView) itemView.findViewById(R.id.old_money);
            ll_all = (LinearLayout) itemView.findViewById(R.id.ll_all);

        }


    }

    public void setData(List<HomefragmentBean.MsgBean.SpikeBean.SpikeShopBean> recentPurchaseList){
        list = recentPurchaseList;
        notifyDataSetChanged();
    }

    //定义点击事件的接口
    public interface OnItemClickLitener {
        void onItemClick(int position);
    }

}
