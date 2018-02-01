package hlks.hualiangou.com.ks_android.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ListView;

import com.tsy.sdk.myokhttp.response.GsonResponseHandler;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import hlks.hualiangou.com.ks_android.App;
import hlks.hualiangou.com.ks_android.R;
import hlks.hualiangou.com.ks_android.base.BaseAdapterb.ListAdapter;
import hlks.hualiangou.com.ks_android.base.BaseFragment;
import hlks.hualiangou.com.ks_android.bean.MyFootBean;
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
    }

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
                        myAdapter = new MyAdapter(baseActivity,result, R.layout.item_foot);
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
            CheckBox checkBox = (CheckBox) viewHolder.findView(R.id.foot_checkBox);
            if (resultBean.isSelect()) {
                checkBox.setVisibility(View.VISIBLE);
            } else {
                checkBox.setVisibility(View.GONE);
            }
            viewHolder.setText(R.id.foot_title, resultBean.getShop_name());
            viewHolder.setText(R.id.foot_money, resultBean.getShop_end_money());
            viewHolder.setImage(R.id.foot_img, UrlUtilds.IMG_URL + resultBean.getImage_path());
        }
    }


}
