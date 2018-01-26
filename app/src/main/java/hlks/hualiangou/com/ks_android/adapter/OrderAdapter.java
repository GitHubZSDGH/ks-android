package hlks.hualiangou.com.ks_android.adapter;

import android.content.Context;
import android.view.View;
import android.widget.SectionIndexer;
import android.widget.TextView;

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
 * 创建时间: 2018/1/27 0027 3:25
 * 修改人:
 * 修改内容:
 * 修改时间:
 */


public class OrderAdapter extends ListAdapter<OrderDataBean.MsgBean.OrderListBean.ShopBean> implements SectionIndexer {
    private OrderClickListener orderClickListener;

    public void setOrderClickListener(OrderClickListener orderClickListener) {
        this.orderClickListener = orderClickListener;
    }

    public OrderAdapter(Context mContext, List<OrderDataBean.MsgBean.OrderListBean.ShopBean> list, int resId) {
        super(mContext, list, resId);
    }

    @Override
    public void conver(ViewHolder viewHolder, OrderDataBean.MsgBean.OrderListBean.ShopBean shopBean, int position) {
        View storeRel = viewHolder.findView(R.id.item_order_storeRel);
        int sectionForPosition = getSectionForPosition(position);
        if (position == getPositionForSection(sectionForPosition)) {
            //商家显示的时候
            storeRel.setVisibility(View.VISIBLE);
            viewHolder.setImage(R.id.item_order_store_img, UrlUtilds.IMG_URL+shopBean.getStoreHead());
            viewHolder.setText(R.id.item_order_store_name, shopBean.getStoreName());
            TextView orderState = (TextView) viewHolder.findView(R.id.item_order_state);
            //1待付款 2已付款 3交易成功 4交易关闭 5申请退款 6退款完成
            switch (shopBean.getOrderState()) {
                case "1":
                    orderState.setText("待付款");
                    break;
                case "2":
                    orderState.setText("已付款");
                    break;
                case "3":
                    orderState.setText("交易成功");
                    break;
                case "4":
                    orderState.setText("交易关闭");
                    break;
                case "5":
                    orderState.setText("申请退款");
                    break;
                case "6":
                    orderState.setText("退款完成");
                    break;
                default:
                    orderState.setText("未知参数");
                    break;
            }
        } else {
            //商家影藏的
            storeRel.setVisibility(View.GONE);
        }

        viewHolder.setImage(R.id.item_order_shop_head,UrlUtilds.IMG_URL+shopBean.getImage_path());
        viewHolder.setText(R.id.item_order_shop_name, shopBean.getShop_name());
        viewHolder.setText(R.id.item_order_shop_lab, shopBean.getSpec_one_name() + shopBean.getSpec_two_name());
        viewHolder.setText(R.id.item_order_shop_money, "￥"+shopBean.getShop_price());
        viewHolder.setText(R.id.item_order_shop_num, "x"+String.valueOf(shopBean.getShop_num()));

    }


    @Override
    public Object[] getSections() {
        return new Object[0];
    }

    @Override
    public int getPositionForSection(int storeId) {
        for (int i1 = 0; i1 < list.size(); i1++) {
            OrderDataBean.MsgBean.OrderListBean.ShopBean shopBean = list.get(i1);
            if (storeId == shopBean.getStoreId()) {
                return i1;
            }
        }
        return -1;
    }

    @Override
    public int getSectionForPosition(int i) {
        return list.get(i).getStoreId();
    }

    public interface OrderClickListener {
        void deleteOrderClick(int position);

        void alreadrOrderClick(int position);
    }
}
