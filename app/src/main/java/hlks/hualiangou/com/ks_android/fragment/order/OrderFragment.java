package hlks.hualiangou.com.ks_android.fragment.order;

import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.tsy.sdk.myokhttp.response.RawResponseHandler;

import java.util.ArrayList;

import hlks.hualiangou.com.ks_android.App;
import hlks.hualiangou.com.ks_android.R;
import hlks.hualiangou.com.ks_android.base.BaseAdapterb.ListAdapter;
import hlks.hualiangou.com.ks_android.base.BaseFragment;
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


public class OrderFragment extends BaseFragment {
    private ListView mListView;
    private final String TAG = getClass().getSimpleName();
    @Override
    public int getLayoutId() {
        return R.layout.fragment_order_list;
    }

    @Override
    public void initView(View view) {
        mListView = view.findViewById(R.id.order_list);

        ListAdapter<String> listAdapter = new ListAdapter<String>(baseActivity, new ArrayList<String>(), R.layout.item_order) {
            @Override
            public int getCount() {
                return 20;
            }

            @Override
            public void conver(ViewHolder viewHolder, String s, int position) {

            }
        };
        mListView.setAdapter(listAdapter);
    }

    @Override
    public void loadData() {
        loadOrderList("1");
    }

    @Override
    public void setListener() {

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
                .enqueue(new RawResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, String response) {
                        Log.e(TAG, "onresponse===>" + response);
                    }

                    @Override
                    public void onFailure(int statusCode, String error_msg) {
                        Log.e(TAG, "onError===>" + error_msg);
                    }
                });
    }
}
