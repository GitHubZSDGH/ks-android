package hlks.hualiangou.com.ks_android.activity.main;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TextView;

import com.tsy.sdk.myokhttp.response.RawResponseHandler;

import hlks.hualiangou.com.ks_android.App;
import hlks.hualiangou.com.ks_android.R;
import hlks.hualiangou.com.ks_android.base.BaseActivity;
import hlks.hualiangou.com.ks_android.modle.url.UrlUtilds;
import hlks.hualiangou.com.ks_android.utils.UserUtils;

public class MainFootActivity extends BaseActivity implements View.OnClickListener {

    private RelativeLayout mGoBack;
    /**
     * 编辑
     */
    private TextView mMainFootEdit;
    private TableLayout mMainFootTab;
    private ViewPager mMainFootPager;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main_foot;
    }
    @Override
    public void initView() {
        mGoBack = (RelativeLayout) findViewById(R.id.go_back);
        mGoBack.setOnClickListener(this);
        mMainFootEdit = (TextView) findViewById(R.id.main_foot_edit);
        mMainFootEdit.setOnClickListener(this);
        mMainFootTab = (TableLayout) findViewById(R.id.main_foot_tab);
        mMainFootPager = (ViewPager) findViewById(R.id.main_foot_pager);
    }

    @Override
    public void loadData() {

    }

    @Override
    public void setListener() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.go_back:
                finish();
                break;
            case R.id.main_foot_edit:
                break;
        }
    }
    private void initOkhttp() {
        App.myOkHttp
                .postParams()
                .url(UrlUtilds.GET_USER_HISTORY)
                .addParam("api", "shop/getUserHistory")
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
}
