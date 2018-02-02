package hlks.hualiangou.com.ks_android.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ListView;

import com.tsy.sdk.myokhttp.response.GsonResponseHandler;
import com.tsy.sdk.myokhttp.response.RawResponseHandler;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import hlks.hualiangou.com.ks_android.App;
import hlks.hualiangou.com.ks_android.R;
import hlks.hualiangou.com.ks_android.activity.DetailPagesActivity;
import hlks.hualiangou.com.ks_android.base.BaseAdapterb.ListAdapter;
import hlks.hualiangou.com.ks_android.base.BaseFragment;
import hlks.hualiangou.com.ks_android.bean.MyFootBean;
import hlks.hualiangou.com.ks_android.event.FootpFragment;
import hlks.hualiangou.com.ks_android.event.MainFootBean;
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
    private MyAdapter myAdapter;
    private List<MyFootBean.MsgBean.ResultBean> result;
    private MyFootBean.MsgBean.ResultBean resultBean;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_foot;
    }

    @Override
    public void initView(View view) {
        EventBus.getDefault().register(this);
        listView = view.findViewById(R.id.id_listView);

    }

    @Override
    public void loadData() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                expressitemClick(i);
            }
        });
    }
    public void expressitemClick(int postion){
        Intent intent = new Intent(baseActivity, DetailPagesActivity.class);
        intent.putExtra("shop_id", String.valueOf(resultBean.getShop_id()));
        Log.e( "expressitemClick: ",resultBean.getShop_id()+"" );
        startActivity(intent);}
    @Override
    public void setListener() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getState(MainFootBean mainFootBean) {


        for (MyFootBean.MsgBean.ResultBean resultBean : result) {
            resultBean.setSelect(mainFootBean.isSelect);
        }
        myAdapter.notifyDataSetChanged();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    private void delete(FootpFragment footpFragment) {
        List<String> ids = new ArrayList<>();
        for (MyFootBean.MsgBean.ResultBean resultBean : result) {
            if (resultBean.isSelect()) {
                ids.add(String.valueOf(resultBean.getHistory_id()));
            }
        }
//网络请求

    }


    private void initDeleteOkhttp() {
        App.myOkHttp
                .postParams()
                .url(UrlUtilds.GET_CHCK_HISTORY)
                .addParam("api", "shop/chckHistory")
                .addParam("appid", UrlUtilds.APPID)
                .addParam("t", String.valueOf(System.currentTimeMillis()))
                .addParam("token", UserUtils.getToken())
                .addParam("user_id", UserUtils.getUserId())
                .enqueue(new RawResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, String response) {

                    }

                    @Override
                    public void onFailure(int statusCode, String error_msg) {

                    }
                });
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
                .addParam("time", value)
                .addParam("token", UserUtils.getToken())
                .addParam("user_id", UserUtils.getUserId())
                .enqueue(new GsonResponseHandler<MyFootBean>() {
                    @Override
                    public void onSuccess(int statusCode, MyFootBean response) {

                        result = response.getMsg().getResult();
                        myAdapter = new MyAdapter(baseActivity, result, R.layout.item_foot);
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
        public void conver(ViewHolder viewHolder, final MyFootBean.MsgBean.ResultBean resultBean, int position) {
            final CheckBox checkBox = (CheckBox) viewHolder.findView(R.id.foot_checkBox);
            if (resultBean.isSelect()) {
                checkBox.setVisibility(View.VISIBLE);
            } else {
                checkBox.setVisibility(View.GONE);
            }
            checkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (checkBox.isChecked()) {
                        resultBean.setSelect(true);
                    }else{
                        resultBean.setSelect(false);
                    }
                }
            });
            viewHolder.setText(R.id.foot_title, resultBean.getShop_name());
            viewHolder.setText(R.id.foot_money, "¥" + resultBean.getShop_end_money());
            viewHolder.setImage(R.id.foot_img, UrlUtilds.IMG_URL + resultBean.getImage_path());
        }
    }


}
