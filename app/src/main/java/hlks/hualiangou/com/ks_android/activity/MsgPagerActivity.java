package hlks.hualiangou.com.ks_android.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import hlks.hualiangou.com.ks_android.R;
import hlks.hualiangou.com.ks_android.base.BaseActivity;

public class MsgPagerActivity extends BaseActivity implements View.OnClickListener {

    private ImageView mSearchActivityImg;
    /**
     * 客服热线
     */
    private TextView mMsgTitle;
    private ImageView mImageView2;

    @Override
    public int getLayoutId() {
        return R.layout.activity_msg_pager;
    }

    @Override
    public void initView() {

        mSearchActivityImg = (ImageView) findViewById(R.id.search_activity_img);
        mSearchActivityImg.setOnClickListener(this);
        mMsgTitle = (TextView) findViewById(R.id.msg_title);
        mImageView2 = (ImageView) findViewById(R.id.imageView2);
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
            case R.id.search_activity_img:
                finish();
                break;
        }
    }
}
