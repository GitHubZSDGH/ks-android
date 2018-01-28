package hlks.hualiangou.com.ks_android.adapter;

import android.content.Context;
import android.util.Log;
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
    public void conver(ViewHolder viewHolder, final OrderDataBean.MsgBean.OrderListBean.ShopBean shopBean, int position) {
        View storeRel = viewHolder.findView(R.id.item_order_storeRel);
        TextView storeMoney = (TextView) viewHolder.findView(R.id.item_order_shop_allMoney);
        final TextView leftButton = (TextView) viewHolder.findView(R.id.item_order_shop_already_by);
        final TextView rightButton = (TextView) viewHolder.findView(R.id.item_order_shop_delete);
        int storeId = getSectionForPosition(position);
        if (position == getPositionForSection(storeId)) {
            //商家显示的时候
            storeRel.setVisibility(View.VISIBLE);
            viewHolder.setImage(R.id.item_order_store_img, UrlUtilds.IMG_URL + shopBean.getStoreHead());
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
                case "7":
                    orderState.setText("交易成功");
                    break;
                case "8":
                    orderState.setText("订单异常");
                    break;
                default:
                    orderState.setText("未知参数");
                    break;
            }
        } else {
            //商家影藏的
            storeRel.setVisibility(View.GONE);
        }

        if (position == getPositionLastSection(storeId)) {
            storeMoney.setVisibility(View.VISIBLE);
            rightButton.setVisibility(View.VISIBLE);
            leftButton.setVisibility(View.VISIBLE);
            setLeftButton(leftButton, shopBean.getOrder_type());
            setrightButton(rightButton, shopBean.getOrder_pay());
            leftButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (orderClickListener != null) {
                        orderClickListener.leftButtonCLick(((String) leftButton.getTag()), shopBean.getOrder_number());
                    }
                }
            });
            rightButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (orderClickListener != null) {
                        orderClickListener.rightButtonClick(((String) rightButton.getTag()), shopBean.getOrder_number());
                    }
                }
            });
//            storeMoney.setText("共"+shopBean.getShop_num()+"件商品");
        } else {
            storeMoney.setVisibility(View.GONE);
            rightButton.setVisibility(View.GONE);
            leftButton.setVisibility(View.GONE);
        }

        viewHolder.setImage(R.id.item_order_shop_head, UrlUtilds.IMG_URL + shopBean.getImage_path());
        viewHolder.setText(R.id.item_order_shop_name, shopBean.getShop_name());
        viewHolder.setText(R.id.item_order_shop_lab, shopBean.getSpec_one_name() + shopBean.getSpec_two_name());
        viewHolder.setText(R.id.item_order_shop_money, "￥" + shopBean.getShop_price());
        viewHolder.setText(R.id.item_order_shop_num, "x" + String.valueOf(shopBean.getShop_num()));

    }


    /**
     * 1: 付款
     * 2: 确认收货
     * 3：删除订单
     * 4: 联系客服
     *
     * @param rightButton
     * @param type
     */
    private void setrightButton(TextView rightButton, String type) {
        switch (type) {
            case "1":
                rightButton.setText("付款");
                rightButton.setTag(type);
                break;
            case "2":
                rightButton.setText("确认收货");
                rightButton.setTag(type);
                break;
            case "3":
                rightButton.setText("删除订单");
                rightButton.setTag(type);
                break;
            case "4":
                rightButton.setText("联系客服");
                rightButton.setTag(type);
                break;
        }
    }

    /**
     * 1:取消订单
     * 2:再次购买
     * 3：查看物流。
     * 4:提醒发货
     * 5:已提醒发货
     * 6评论
     * 7:撤销申请
     *
     * @param leftButton
     * @param type
     */
    private void setLeftButton(TextView leftButton, String type) {
        switch (type) {
            case "1":
                leftButton.setText("取消订单");
                leftButton.setTag(type);
                break;
            case "2":
                leftButton.setText("再次购买");
                leftButton.setTag(type);
                break;
            case "3":
                leftButton.setText("查看物流");
                leftButton.setTag(type);
                break;
            case "4":
                leftButton.setText("提醒发货");
                leftButton.setTag(type);
                break;
            case "5":
                leftButton.setText("已提醒发货");
                leftButton.setTag(type);
                break;
            case "6":
                leftButton.setText("评论");
                leftButton.setTag(type);
                break;
            case "7":
                leftButton.setText("撤销申请");
                leftButton.setTag(type);
                break;
            default:
                Log.e("ordertype", "orderType==>" + type);
        }
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

    public int getPositionLastSection(int storeId) {
        for (int i = list.size() - 1; i >= 0; i--) {
            OrderDataBean.MsgBean.OrderListBean.ShopBean shopBean = list.get(i);
            if (storeId == shopBean.getStoreId()) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int getSectionForPosition(int i) {
        return list.get(i).getStoreId();
    }

    public interface OrderClickListener {
        void leftButtonCLick(String type, String order);

        void rightButtonClick(String type, String order);

    }
}
