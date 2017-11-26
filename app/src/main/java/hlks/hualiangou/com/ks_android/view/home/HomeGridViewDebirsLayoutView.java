package hlks.hualiangou.com.ks_android.view.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import hlks.hualiangou.com.ks_android.R;
import hlks.hualiangou.com.ks_android.utils.encryption.DensityUtil;
import hlks.hualiangou.com.ks_android.view.BaseDevrisLayoutView;


/**
 * Created by cuijl on 2017/2/11.
 */

public class HomeGridViewDebirsLayoutView extends BaseDevrisLayoutView {

    LinearLayout ll_all;
    @BindView(R.id.tv_qudaojianshe)
    ImageView tvQudaojianshe;
    @BindView(R.id.tv_jiesuanzhifu)
    ImageView tvJiesuanzhifu;
    @BindView(R.id.tv_gongxiangzhoubian)
    ImageView tvGongxiangzhoubian;
    @BindView(R.id.tv_xinpinshangshi)
    ImageView tvXinpinshangshi;
    @BindView(R.id.tv_lijuanzhongxin)
    ImageView tvLijuanzhongxin;
    @BindView(R.id.tv_woyaotuijian)
    ImageView tvWoyaotuijian;
    @BindView(R.id.tv_qiyexuanchuan)
    ImageView tvQiyexuanchuan;
    @BindView(R.id.tv_fenleisahngpin)
    ImageView tvFenleisahngpin;
    @BindView(R.id.ll_all)
    LinearLayout llAll;


    private HomeGridViewResponseListener homeGridViewResponseListener;

    public void setHomeGridViewResponseListener(HomeGridViewResponseListener homeGridViewResponseListener) {
        this.homeGridViewResponseListener = homeGridViewResponseListener;
    }

    public HomeGridViewDebirsLayoutView(Context context) {
        super(context);
    }

    @Override
    public View initView() {
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_home_gridview_debris, null);
        ButterKnife.bind(this, view);
        initViewListener();
        int screenWidth = DensityUtil.getDisplayWidth(mContext);
        ll_all = $(view, R.id.ll_all);
        ll_all.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        return view;

    }

    private void initViewListener() {
        tvQudaojianshe.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (homeGridViewResponseListener != null) {
                    homeGridViewResponseListener.qudaojianshe();
                }
            }
        });
        tvJiesuanzhifu.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (homeGridViewResponseListener != null) {
                    homeGridViewResponseListener.jiesuanzhifu();
                }
            }
        });
        tvGongxiangzhoubian.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (homeGridViewResponseListener != null) {
                    homeGridViewResponseListener.gongxiangzhoubian();
                }
            }
        });
        tvXinpinshangshi.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (homeGridViewResponseListener != null) {
                    homeGridViewResponseListener.xinpinshangshi();
                }
            }
        });
        tvLijuanzhongxin.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (homeGridViewResponseListener != null) {
                    homeGridViewResponseListener.lijuanzhongxin();
                }
            }
        });
        tvWoyaotuijian.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (homeGridViewResponseListener != null) {
                    homeGridViewResponseListener.woyaotuijian();
                }
            }
        });
        tvQiyexuanchuan.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (homeGridViewResponseListener != null) {
                    homeGridViewResponseListener.qiyexuanchuan();
                }
            }
        });
        tvFenleisahngpin.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (homeGridViewResponseListener != null) {
                    homeGridViewResponseListener.fenleisahngpin();
                }
            }
        });

    }

    public interface HomeGridViewResponseListener {
        void qudaojianshe();
        void jiesuanzhifu();
        void gongxiangzhoubian();
        void xinpinshangshi();
        void lijuanzhongxin();
        void woyaotuijian();
        void qiyexuanchuan();
        void fenleisahngpin();

    }


}
