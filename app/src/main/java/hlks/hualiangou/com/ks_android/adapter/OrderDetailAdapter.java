package hlks.hualiangou.com.ks_android.adapter;

import android.content.Context;

import java.util.List;

import hlks.hualiangou.com.ks_android.R;
import hlks.hualiangou.com.ks_android.base.BaseAdapterb.ListAdapter;
import hlks.hualiangou.com.ks_android.bean.OrderDataBean;
import hlks.hualiangou.com.ks_android.modle.url.UrlUtilds;

/**
 * /**
 * 项目名称: 药到家
 * 类描述:
 * 创建人: XI
 * 创建时间: 2018/1/29 0029 2:16
 * 修改人:
 * 修改内容:
 * 修改时间:
 */


public class OrderDetailAdapter extends ListAdapter<OrderDataBean.MsgBean.OrderListBean.ShopBean> {

    public OrderDetailAdapter(Context mContext, List<OrderDataBean.MsgBean.OrderListBean.ShopBean> list, int resId) {
        super(mContext, list, resId);
    }

    @Override
    public void conver(ViewHolder viewHolder, OrderDataBean.MsgBean.OrderListBean.ShopBean shopBean, int position) {

        viewHolder.setText(R.id.item_order_shop_name, shopBean.getShop_name());
        viewHolder.setText(R.id.item_order_shop_lab, shopBean.getSpec_one_name() + shopBean.getSpec_two_name());
        viewHolder.setText(R.id.item_order_shop_money, "￥" + shopBean.getShop_price());
        viewHolder.setText(R.id.item_order_shop_num, "x" + String.valueOf(shopBean.getShop_num()));
        viewHolder.setImage(R.id.item_order_shop_head, UrlUtilds.IMG_URL + shopBean.getImage_path());
    }
}
