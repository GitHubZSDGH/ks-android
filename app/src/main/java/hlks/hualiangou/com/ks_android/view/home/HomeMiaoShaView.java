package hlks.hualiangou.com.ks_android.view.home;

import android.content.Context;
import android.graphics.Paint;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
import hlks.hualiangou.com.ks_android.view.SnapUpCountDownTimerView;


/**
 * Created by cuijl on 2017/2/11.
 */

public class HomeMiaoShaView extends BaseDevrisLayoutView {
    SnapUpCountDownTimerView miaoshaTime;
    LinearLayout ll_all;
    RecyclerView rListview;
    MyAdpater adapter;
    int hh;
    int mm;
    int ss;
    AdapterView.OnItemClickListener listener;
//    HomefragmentBean.MsgBean.SpikeBean mSpikeTime;

    public void setListener(AdapterView.OnItemClickListener listener) {
        this.listener = listener;
        if (this.listener != null) {
            adapter.setOnItemClickListener(this.listener);
        }
    }

    public HomeMiaoShaView(Context context) {
        super(context);
    }

    @Override
    public View initView() {
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_home_miaosha, null);
        int screenWidth = DensityUtil.getDisplayWidth(mContext);
        ll_all = $(view, R.id.ll_all);
        rListview = $(view, R.id.rListview);
        miaoshaTime = $(view, R.id.home_miaosha_time);
//        initSpiketime();


        ll_all.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false);
        rListview.setLayoutManager(linearLayoutManager);
        adapter = new MyAdpater(R.layout.item_new_buy);

        rListview.setAdapter(adapter);
        return view;
    }

    private void initSpiketime() {
        hh = 90000 / 1000 / 60 / 60;
        mm = (90000 - hh * 1000 * 60 * 60) / 1000 / 60;
        ss = (90000 - hh * 1000 * 60 * 60 - mm * 1000 * 60) / 1000;
    }
//时间转换
    public void setTime(int time) {
        hh = time / 60 / 60;
        mm = (time - hh * 60 * 60) / 60;
        ss = time - hh * 60 * 60 - mm  * 60;
        Log.d("HomeMiaoShaView", "time:" + time);
//        miaoshaTime.setTime(Integer.parseInt(split[0]),
//                Integer.parseInt(split[1]), Integer.parseInt(split[2]));
        miaoshaTime.setTime(hh,mm,ss);
        miaoshaTime.start();
    }

    public void setData(Collection<HomefragmentBean.MsgBean.SpikeBean.SpikeShopBean> collection) {
        adapter.refresh(collection);
    }


    class MyAdpater extends BaseRecyclerAdapter<HomefragmentBean.MsgBean.SpikeBean.SpikeShopBean> {

        public MyAdpater(@LayoutRes int layoutId) {
            super(layoutId);
        }

        @Override
        protected void conver(ViewHolder holder, HomefragmentBean.MsgBean.SpikeBean.SpikeShopBean modle, int position) {
            holder.setText(R.id.tv_money, "¥" + modle.getShop_end_money());
            holder.setText(R.id.old_money, "¥" + modle.getShop_start_money());
            holder.setRoundImages(R.id.iv_img, UrlUtilds.IMG_URL + modle.getImage_path());
            TextView textView = (TextView) holder.findViewById(R.id.old_money);
            textView.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
            holder.setText(R.id.tv_title, modle.getShop_name());

        }


    }


}
