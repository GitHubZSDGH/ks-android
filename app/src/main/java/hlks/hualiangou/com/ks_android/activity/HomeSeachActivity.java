package hlks.hualiangou.com.ks_android.activity;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tsy.sdk.myokhttp.response.GsonResponseHandler;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import hlks.hualiangou.com.ks_android.App;
import hlks.hualiangou.com.ks_android.R;
import hlks.hualiangou.com.ks_android.base.BaseActivity;
import hlks.hualiangou.com.ks_android.modle.bean.HomeSeachBean;
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
    private TextView mTitleSeach;

    @Override
    public int getLayoutId() {
        return R.layout.activity_home_seach;
    }

    @Override
    public void initView() {
        mHotList = new ArrayList<>();
        backLin = (LinearLayout) findViewById(R.id.seach_back);
        pagerBack = (ImageView) findViewById(R.id.search_activity_img);
//        backLin.setBackgroundResource(R.color.white);
        flowLayout = (FlowLayout) findViewById(R.id.seach_flowLayout);
        mSeach_et = (EditText) findViewById(R.id.search_activity_et);
        mSeach_et.clearFocus();
        mTitleSeach = (TextView) findViewById(R.id.title_seach);
        mTitleSeach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeSeachActivity.this, CommoditiesActivity.class);
                intent.putExtra("isnet", false);
                intent.putExtra("categroyid", mSeach_et.getText().toString().trim());
                startActivity(intent);
            }
        });
        list = getResources().getStringArray(R.array.home_seach_history_list);
        Date dt = new Date();
        time = String.valueOf(dt.getTime());
    }

    @Override
    public void loadData() {
        initOkHttp();
        for (String child : list) {
            final TextView textview = new TextView(this);
            textview.setText(child);
            textview.setBackgroundResource(R.drawable.seach_shape_option);
            textview.setTextSize((int) DimenUtils.pxToSp(50));
            textview.setPadding((int) DimenUtils.pxToSp(40),(int) DimenUtils.pxToSp(22),(int) DimenUtils.pxToSp(54),(int) DimenUtils.pxToSp(22));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            layoutParams.setMargins(0,20,0,20);

            textview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mSeach_et.setText(textview.getText());
                    Intent intent = new Intent(HomeSeachActivity.this, CommoditiesActivity.class);
                    intent.putExtra("isnet", false);
                    intent.putExtra("categroyid", textview.getText());
                    startActivity(intent);
//                    initOkHttp();
                }
            });

            flowLayout.addView(textview,layoutParams);
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
        App.myOkHttp.postParams()
                .url(UrlUtilds.GET_KEY)
                .addParam("api", "keyword/getKey")
                .addParam("appid",UrlUtilds.APPID)
                .addParam("t",time)
                .addParam("token",UserUtils.getToken())
                .enqueue(new GsonResponseHandler<HomeSeachBean>() {
                    @Override
                    public void onSuccess(int statusCode, HomeSeachBean response) {

                    }

                    @Override
                    public void onFailure(int statusCode, String error_msg) {

                    }
                });

    }


}
