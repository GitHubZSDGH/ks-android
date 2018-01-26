package hlks.hualiangou.com.ks_android.activity.zhengce;

import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import hlks.hualiangou.com.ks_android.R;
import hlks.hualiangou.com.ks_android.base.BaseActivity;

/**
 * 项目名称:
 * 类描述:
 * 创建时间:2017/12/13
 */
public class PrivacyPolicy extends BaseActivity {
    private WebView mWvlogin;
    private TextView mTitle;
    private ImageView mReturn;
    private WebSettings mWebSettings;
    String URL = "http://shop.elliotngok.xin/api/Privacyclause/loginClick";
//    String URL = "http://shop.elliotngok.xin/api/Privacyclause/regClick";


    @Override
    public int getLayoutId() {
        return R.layout.activity_login_reg_web;
    }

    @Override
    public void initView() {
        mWvlogin = (WebView) findViewById(R.id.login_reg_wv);
        mReturn = (ImageView) findViewById(R.id.wv_title_img);
        mTitle = (TextView) findViewById(R.id.wv_title_text);
        mWebSettings = mWvlogin.getSettings();
        mWebSettings.setSupportZoom(true);
        mWebSettings.setDefaultFontSize(55);
        mWvlogin.loadUrl(URL);

        mWvlogin.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
  mReturn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
          finish();
          mWvlogin.destroy();
      }
  });
    }

    @Override
    public void loadData() {

    }

    @Override
    public void setListener() {

    }
    @Override
    protected void onDestroy() {
        if (mWvlogin != null) {
            mWvlogin.loadDataWithBaseURL(null, "", "text/html", "utf-8", null);
            mWvlogin.clearHistory();

            ((ViewGroup) mWvlogin.getParent()).removeView(mWvlogin);
            mWvlogin.destroy();
            mWvlogin = null;
        }
        super.onDestroy();
    }


}
