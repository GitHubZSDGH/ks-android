package hlks.hualiangou.com.ks_android.fragment;

import android.os.Bundle;
import android.view.View;

import com.tsy.sdk.myokhttp.response.GsonResponseHandler;

import java.util.List;

import hlks.hualiangou.com.ks_android.App;
import hlks.hualiangou.com.ks_android.R;
import hlks.hualiangou.com.ks_android.activity.main.MainFootActivity;
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
    @Override
    public int getLayoutId() {
        return R.layout.fragment_foot;
    }

    @Override
    public void initView(View view) {

    }

    @Override
    public void loadData() {
        initOkhttp();
    }

    @Override
    public void setListener() {

    }
    @Override
    public void getBundle(Bundle bundle) {
        super.getBundle(bundle);

    }
    private void initOkhttp() {
        App.myOkHttp
                .postParams()
                .url(UrlUtilds.GET_USER_HISTORY)
                .addParam("api", "shop/getUserHistory")
                .addParam("appid", UrlUtilds.APPID)
                .addParam("t", String.valueOf(System.currentTimeMillis()))
                .addParam("time","2018-01-31")
                .addParam("token", UserUtils.getToken())
                .addParam("user_id", UserUtils.getUserId())
                .enqueue(new GsonResponseHandler<MyFootBean>() {
                    @Override
                    public void onSuccess(int statusCode, MyFootBean response) {

                    }

                    @Override
                    public void onFailure(int statusCode, String error_msg) {

                    }
                });
    }


}
