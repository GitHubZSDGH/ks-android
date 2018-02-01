package hlks.hualiangou.com.ks_android.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.tsy.sdk.myokhttp.response.GsonResponseHandler;

import java.util.List;

import hlks.hualiangou.com.ks_android.App;
import hlks.hualiangou.com.ks_android.R;
import hlks.hualiangou.com.ks_android.base.BaseAdapterb.ListAdapter;
import hlks.hualiangou.com.ks_android.base.BaseFragment;
import hlks.hualiangou.com.ks_android.bean.MyFootBean;
import hlks.hualiangou.com.ks_android.modle.url.UrlUtilds;
import hlks.hualiangou.com.ks_android.utils.UserUtils;

/**
 * /**
 * 项目名称: 药到家
 * 类描述:
 * 创建人: XI
 * 创建时间: 2018/2/1 0001 13:22
 * 修改人:
 * 修改内容:
 * 修改时间:
 */


public class FootFragment extends BaseFragment {
    private ListView listView;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_foot;
    }

    @Override
    public void initView(View view) {
        listView = view.findViewById(R.id.id_listView);
    }

    @Override
    public void loadData() {
    }

    @Override
    public void setListener() {

    }

    @Override
    public void getBundle(Bundle bundle) {
        super.getBundle(bundle);
        String value = bundle.getString("foot");
        initOkhttp(value);


    }

    private void initOkhttp(String value) {
        App.myOkHttp
                .postParams()
                .url(UrlUtilds.GET_USER_HISTORY)
                .addParam("api", "shop/getUserHistory")
                .addParam("appid", UrlUtilds.APPID)
                .addParam("t", String.valueOf(System.currentTimeMillis()))
                .addParam("time",value)
                .addParam("token", UserUtils.getToken())
                .addParam("user_id", UserUtils.getUserId())
                .enqueue(new GsonResponseHandler<MyFootBean>() {
                    @Override
                    public void onSuccess(int statusCode, MyFootBean response) {
                        MyAdapter myAdapter = new MyAdapter(baseActivity, response.getMsg().getResult(), R.layout.item_foot);
                        listView.setAdapter(myAdapter);
                    }

                    @Override
                    public void onFailure(int statusCode, String error_msg) {

                    }
                });
    }

    private class MyAdapter extends ListAdapter<MyFootBean.MsgBean.ResultBean> {

        public MyAdapter(Context mContext, List<MyFootBean.MsgBean.ResultBean> list, int resId) {
            super(mContext, list, resId);
        }

        @Override
        public void conver(ViewHolder viewHolder, MyFootBean.MsgBean.ResultBean resultBean, int position) {
            viewHolder.setText(R.id.foot_title, resultBean.getShop_name());
            viewHolder.setText(R.id.foot_money, resultBean.getShop_end_money());
            viewHolder.setImage(R.id.foot_img, UrlUtilds.IMG_URL + resultBean.getImage_path());
        }
    }


}
