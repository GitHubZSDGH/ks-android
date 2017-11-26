package hlks.hualiangou.com.ks_android.view.home;

import android.content.Context;
import android.graphics.Paint;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

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

public class HomeJingXuanView extends BaseDevrisLayoutView {

    LinearLayout ll_all;
    RecyclerView rListview1, rListview2, rListview3;
    ImageView ivHandImg;
    MyAdpater adapter1;
    MyAdpater adapter2;
    MyAdpater adapter3;
    private ImageView im2,im3;
    AdapterView.OnItemClickListener listener;

    public void setListener(AdapterView.OnItemClickListener listener) {
        this.listener = listener;
        if (this.listener != null) {
            adapter1.setOnItemClickListener(this.listener);
        }
    }

    public HomeJingXuanView(Context context) {
        super(context);
    }



    @Override
    public View initView() {
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_home_jingxuan, null);
        int screenWidth = DensityUtil.getDisplayWidth(mContext);
        ll_all = $(view, R.id.ll_all);
        ivHandImg = $(view, R.id.hand_tuijian_img);
        im2 = $(view, R.id.id_image2);
        im3 = $(view, R.id.id_image3);
        rListview1 = $(view, R.id.rListview1);
        rListview2 = $(view, R.id.rListview2);
        rListview3 = $(view, R.id.rListview3);
        ll_all.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false);
        rListview1.setLayoutManager(linearLayoutManager);
        rListview2.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
        rListview3.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
        adapter1 = new MyAdpater(R.layout.item_new_buy);
        adapter2 = new MyAdpater(R.layout.item_new_buy);
        adapter3 = new MyAdpater(R.layout.item_new_buy);
        rListview1.setAdapter(adapter1);
        rListview2.setAdapter(adapter2);
        rListview3.setAdapter(adapter3);
        return view;
    }


    public void setdata(List<HomefragmentBean.MsgBean.FeaturedBean> list) {
        if (list.size() >= 3) {
            adapter1.refresh(list.get(0).getShop());
            adapter2.refresh(list.get(1).getShop());
            adapter3.refresh(list.get(2).getShop());
            Glide.with(mContext).load("http://shop.elliotngok.xin" + list.get(0).getBanner()).placeholder(R.drawable.search3).error(R.drawable.search3).into(ivHandImg);
            Glide.with(mContext).load("http://shop.elliotngok.xin" + list.get(1).getBanner()).placeholder(R.drawable.search3).error(R.drawable.search3).into(im2);
            Glide.with(mContext).load("http://shop.elliotngok.xin" + list.get(2).getBanner()).placeholder(R.drawable.search3).error(R.drawable.search3).into(im3);
        }
    }

    class MyAdpater extends BaseRecyclerAdapter<HomefragmentBean.MsgBean.FeaturedBean.ShopBean> {

        public MyAdpater(@LayoutRes int layoutId) {
            super(layoutId);
        }

        @Override
        protected void conver(ViewHolder holder, HomefragmentBean.MsgBean.FeaturedBean.ShopBean modle, int position) {
            holder.setText(R.id.tv_money, "¥"+modle.getShop_start_money());
            holder.setText(R.id.old_money, "¥"+modle.getShop_end_money());
            TextView textView = (TextView) holder.findViewById(R.id.old_money);
            textView.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG);
            holder.setText(R.id.tv_title, modle.getShop_name());
            holder.setRoundImages(R.id.iv_img, UrlUtilds.IMG_URL + modle.getImage_path());
        }
    }

}
