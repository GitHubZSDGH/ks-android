package hlks.hualiangou.com.ks_android.fragment.pager;

import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import hlks.hualiangou.com.ks_android.R;
import hlks.hualiangou.com.ks_android.activity.MsgPagerActivity;
import hlks.hualiangou.com.ks_android.base.BaseFragment;


/**
 * 项目名称:
 * 类描述:
 * 创建人:lenovo
 * 创建时间:2017/11/10
 * 修改人:
 * 修改内容:
 */
public class MessageFragment extends BaseFragment implements View.OnClickListener {
    private View view;
    /**
     * 华联可溯
     */
    private TextView mTextView5;
    /**
     * 昨天
     */
    private TextView mTextView4;
    private LinearLayout mDuokefu;

    @Override
    public int getLayoutId() {
        return R.layout.message_fragment;
    }

    @Override
    public void initView(View view) {

        mTextView5 = (TextView) view.findViewById(R.id.textView5);
        mTextView4 = (TextView) view.findViewById(R.id.textView4);
        mDuokefu = (LinearLayout) view.findViewById(R.id.duokefu);
        mDuokefu.setOnClickListener(this);
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
            case R.id.duokefu:
                Intent intent = new Intent(baseActivity, MsgPagerActivity.class);
                startActivity(intent);
                break;
        }
    }
}
