package hlks.hualiangou.com.ks_android.modle.adapter.home;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.List;

import hlks.hualiangou.com.ks_android.R;


/**
 * 创建时间：2017/10/20 10:54
 * 邮箱：liukai3099@163.com
 */
public class SpecialInsuranceAdapter extends RecyclerView.Adapter<SpecialInsuranceAdapter.ViewHolder>{
    private Context mContext;
    private List<TeSeXianZhongResult.ProductFeatureCategoryModelListBean> list;
    private OnItemClickLitener onItemClickLitener;
    public SpecialInsuranceAdapter(Context mContext, List<TeSeXianZhongResult.ProductFeatureCategoryModelListBean> recentPurchaseList, OnItemClickLitener onItemClickLitener) {
        this.mContext = mContext;
        this.list = recentPurchaseList;
        this.onItemClickLitener = onItemClickLitener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_special_insurance, parent, false);
        ViewHolder  holder = new ViewHolder (view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {






    }

    @Override
    public int getItemCount() {
        if (list == null) {
            return 6;
        }
        if (list.size() > 6) {
            return 6;
        }
        return 6;
//        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder  {//我们需要inflate的item布局需要传入
        ImageView iv_img;
        LinearLayout ll_all;
        public ViewHolder(View itemView) {
            super(itemView);
            iv_img = (ImageView) itemView.findViewById(R.id.iv_img);
            ll_all = (LinearLayout) itemView.findViewById(R.id.ll_all);

        }


    }

    public void setData(List<TeSeXianZhongResult.ProductFeatureCategoryModelListBean> recentPurchaseList){
        list = recentPurchaseList;
        notifyDataSetChanged();
    }

    //定义点击事件的接口
    public interface OnItemClickLitener {
        void onItemClick(int position);
    }

}
