package hlks.hualiangou.com.ks_android.activity;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tsy.sdk.myokhttp.response.GsonResponseHandler;
import com.tsy.sdk.myokhttp.util.ParamsUtils;

import java.util.Date;
import java.util.List;

import hlks.hualiangou.com.ks_android.App;
import hlks.hualiangou.com.ks_android.R;
import hlks.hualiangou.com.ks_android.base.BaseActivity;
import hlks.hualiangou.com.ks_android.modle.bean.Seachbean;
import hlks.hualiangou.com.ks_android.modle.url.UrlUtilds;
import hlks.hualiangou.com.ks_android.utils.DimenUtils;
import hlks.hualiangou.com.ks_android.utils.UserUtils;
import hlks.hualiangou.com.ks_android.view.FlowLayout;

/**
 * 项目名称:
 * 类描述:首页搜索跳转页面
 */
public class HomeSeachActivity extends BaseActivity {
    private LinearLayout backLin;
    private FlowLayout flowLayout;
    private String[] list;
    private List<String> mHotList;
    private String time;
    private EditText mSeach_et;
    private ImageView pagerBack;

    @Override
    public int getLayoutId() {
        return R.layout.activity_home_seach;
    }

    @Override
    public void initView() {
        backLin = (LinearLayout) findViewById(R.id.seach_back);
        pagerBack = (ImageView) findViewById(R.id.search_activity_img);
//        backLin.setBackgroundResource(R.color.white);
        flowLayout = (FlowLayout) findViewById(R.id.seach_flowLayout);
        mSeach_et = (EditText) findViewById(R.id.search_activity_et);
        mSeach_et.clearFocus();
        list = getResources().getStringArray(R.array.home_seach_history_list);
        Date dt = new Date();
        time = String.valueOf(dt.getTime());
    }

    @Override
    public void loadData() {
        for (String child : list) {
            final TextView textview = new TextView(this);
            textview.setText(child);
            textview.setBackgroundResource(R.drawable.seach_shape_option);
            textview.setTextSize((int) DimenUtils.pxToSp(48));
            textview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mSeach_et.setText(textview.getText());
                    Intent intent = new Intent(HomeSeachActivity.this, CommoditiesActivity.class);
                    intent.putExtra("commodities", textview.getText());
                    startActivity(intent);
//                    initOkHttp();
                }
            });

            flowLayout.addView(textview);
        }
    }

    @Override
    public void setListener() {
        pagerBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    private void initOkHttp() {
        String build = ParamsUtils.getInstance()
                .params("api", "shop/getShop")
                .params("appid", UrlUtilds.APPID)
                .params("t", time)
                .params("token", UserUtils.getToken())
                .params("shop_name", mSeach_et.getText().toString())
//                .params("shop_name","商品")
                .params("shop_end_money", "asc")

                .params("page", "1")
                .params("page_count", "5")
                .build();
        App.myOkHttp.post().tag(this)
                .url(UrlUtilds.GET_SHOP)
                .addParam("api", "shop/getShop")
                .addParam("appid", UrlUtilds.APPID)
                .addParam("t", time)
                .addParam("token", UserUtils.getToken())
                .addParam("s", build)
                .addParam("shop_name", mSeach_et.getText().toString())
                .addParam("shop_end_money", "asc")
                .addParam("page", String.valueOf(1))
                .addParam("page_count", String.valueOf(5))
                .enqueue(new GsonResponseHandler<Seachbean>() {
                    @Override
                    public void onSuccess(int statusCode, Seachbean response) {

                    }

                    @Override
                    public void onFailure(int statusCode, String error_msg) {

                    }

                    @Override
                    public void onSuccfulString(int code, String message) {


                    }
                });

    }


}
