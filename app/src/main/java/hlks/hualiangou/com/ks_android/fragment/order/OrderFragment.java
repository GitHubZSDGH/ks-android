package hlks.hualiangou.com.ks_android.fragment.order;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.tsy.sdk.myokhttp.response.GsonResponseHandler;

import java.util.ArrayList;
import java.util.List;

import hlks.hualiangou.com.ks_android.App;
import hlks.hualiangou.com.ks_android.R;
import hlks.hualiangou.com.ks_android.adapter.OrderAdapter;
import hlks.hualiangou.com.ks_android.base.BaseFragment;
import hlks.hualiangou.com.ks_android.bean.OrderDataBean;
import hlks.hualiangou.com.ks_android.modle.url.UrlUtilds;
import hlks.hualiangou.com.ks_android.utils.UserUtils;

/**
 * /**
 * 项目名称: 华联可溯
 * 类描述:
 * 创建人: XI
 * 创建时间: 2018/1/27 0027 1:11
 * 修改人:
 * 修改内容:
 * 修改时间:
 */


public class OrderFragment extends BaseFragment implements OrderAdapter.OrderClickListener {
    private ListView mListView;
    private final String TAG = getClass().getSimpleName();

    private List<OrderDataBean.MsgBean.OrderListBean.ShopBean> mList;
    private OrderAdapter myAdapter;
    private String orderType;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_order_list;
    }

    @Override
    public void initView(View view) {
        mListView = view.findViewById(R.id.order_list);
        mList = new ArrayList<>();
        myAdapter = new OrderAdapter(baseActivity, mList, R.layout.item_order);
        myAdapter.setOrderClickListener(this);
        mListView.setAdapter(myAdapter);


    }

    @Override
    public void getBundle(Bundle bundle) {
        super.getBundle(bundle);
        orderType = bundle.getString("orderType", "-1");
        Log.e(TAG, "orderType===>" + orderType);
        loadOrderList(orderType);
    }

    @Override
    public void loadData() {

    }

    @Override
    public void setListener() {

    }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
    }

    private void loadOrderList(String type) {
        App.myOkHttp
                .postParams()
                .url(UrlUtilds.GET_ORDER_LIST)
                .addParam("user_id", UserUtils.getUserId())
                .addParam("type", type)
                .addParam("api", "myself/order")
                .addParam("appid", UrlUtilds.APPID)
                .addParam("t", String.valueOf(System.currentTimeMillis()))
                .addParam("token", UserUtils.getToken())
                .enqueue(new GsonResponseHandler<OrderDataBean>() {
                    @Override
                    public void onSuccess(int statusCode, OrderDataBean response) {
                        Log.e(TAG, "onsuccful==>" + statusCode);
                        List<OrderDataBean.MsgBean.OrderListBean> order_list = response.getMsg().getOrder_list();
                        mList.clear();
                        for (int i = 0; i < order_list.size(); i++) {
                            OrderDataBean.MsgBean.OrderListBean orderListBean = order_list.get(i);
                            List<OrderDataBean.MsgBean.OrderListBean.ShopBean> shop = orderListBean.getShop();
                            for (OrderDataBean.MsgBean.OrderListBean.ShopBean shopBean : shop) {
                                shopBean.setOrderState(orderListBean.getOrder_staff());
                                shopBean.setStoreHead(orderListBean.getMember_image());
                                shopBean.setOrder_pay(orderListBean.getOrder_pay());
                                shopBean.setOrder_type(orderListBean.getOrder_type());
                                shopBean.setOrder_number(orderListBean.getOrder_number());
                                if (!TextUtils.isEmpty(orderListBean.getMember_name())) {
                                    shopBean.setStoreName(orderListBean.getMember_name());
                                } else {
                                    shopBean.setStoreName("未知商家");
                                }
                                Log.e(TAG, "orderState===>" + orderListBean.getOrder_staff());
                                shopBean.setStoreId(i + 1);
                                mList.add(shopBean);
                                Log.e(TAG, "name===>" + orderListBean.getMember_name());
                            }
                        }
                        myAdapter.notifyDataSetChanged();

                    }

                    @Override
                    public void onFailure(int statusCode, String error_msg) {
                        Log.e(TAG, "onerror==>" + error_msg);
                    }
                });
    }


    @Override
    public void leftButtonCLick(String type, String order) {
        Log.e(TAG, "type===>" + type);
    }

    @Override
    public void rightButtonClick(String type, String order) {
        Log.e(TAG, "playTYpe===>" + type);
    }
}
