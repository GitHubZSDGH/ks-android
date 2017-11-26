package hlks.hualiangou.com.ks_android.fragment.pager;

import android.content.Intent;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.GridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.tsy.sdk.myokhttp.MyOkHttp;
import com.tsy.sdk.myokhttp.response.GsonResponseHandler;
import com.tsy.sdk.myokhttp.util.ParamsUtils;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import hlks.hualiangou.com.ks_android.R;
import hlks.hualiangou.com.ks_android.activity.HomeSeachActivity;
import hlks.hualiangou.com.ks_android.base.BaseAdapterb.BaseRecyclerAdapter;
import hlks.hualiangou.com.ks_android.base.BaseAdapterb.ViewHolder;
import hlks.hualiangou.com.ks_android.base.BaseFragment;
import hlks.hualiangou.com.ks_android.modle.bean.HomefragmentBean;
import hlks.hualiangou.com.ks_android.modle.bean.HomefragmentBeanbottom;
import hlks.hualiangou.com.ks_android.modle.url.UrlUtilds;
import hlks.hualiangou.com.ks_android.utils.encryption.NetUtils;
import hlks.hualiangou.com.ks_android.view.CXRecycleView.CXRecyclerView;
import hlks.hualiangou.com.ks_android.view.bannerpager.BannerViewData;
import hlks.hualiangou.com.ks_android.view.home.HomeDebrisTypeBannerView;
import hlks.hualiangou.com.ks_android.view.home.HomeGridViewDebirsLayoutView;
import hlks.hualiangou.com.ks_android.view.home.HomeJingXuanView;
import hlks.hualiangou.com.ks_android.view.home.HomeMiaoShaView;
import hlks.hualiangou.com.ks_android.view.home.HomeTuiJianView;

import static com.youth.banner.Banner.CIRCLE_INDICATOR_TITLE;

/**
 * 项目名称:
 * 类描述:
 * 创建人:lenovo
 * 创建时间:2017/11/10
 * 修改人:
 * 修改内容:
 */
public class HomePagerFragment extends BaseFragment implements AdapterView.OnItemClickListener, View.OnClickListener, HomeGridViewDebirsLayoutView.HomeGridViewResponseListener {
    CXRecyclerView mRecyclerView;
    MyAdapter adapter;
    private RelativeLayout seachRelat;
    private HomeDebrisTypeBannerView bannerview;
    private List<BannerViewData> bannerData;
    private HomeGridViewDebirsLayoutView homegridview;
    private HomeMiaoShaView homeMiaoShaView;
    private HomeTuiJianView homeTuiJianView;
    private SmartRefreshLayout smartRefreshLayout;
    private String TOken ="";
    private String UID ="";
    private String time;//当前时间戳
    private Banner banner;
    private HomeJingXuanView homeJingXuanView;
    private int mNumber = 1;
    private int pageCount = 10;
    private List<HomefragmentBean.MsgBean.SpikeBean.SpikeShopBean> miaoshaList;

    @Override
    public int getLayoutId() {
        return R.layout.home_pager_fragment;
    }

    @Override
    public void initView(View view) {
        smartRefreshLayout = view.findViewById(R.id.home_paget_refresh);
        mRecyclerView = (CXRecyclerView) view.findViewById(R.id.cxRecyclerView);
        seachRelat = view.findViewById(R.id.seach_relat);
        seachRelat.setOnClickListener(this);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        Date dt = new Date();
        time = String.valueOf(dt.getTime());



    }

    @Override
    public void loadData() {

        initOkHttp(null);
        initOkHttpbottom(null);

        smartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                initOkHttpbottom(refreshlayout);
                initOkHttp(refreshlayout);
                refreshlayout.finishLoadmore();
            }
        });
        smartRefreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                pageCount += 10;
                initOkHttpbottom(refreshlayout);

            }
        });
//        mRecyclerView.setPullRefreshEnabled(true);
//        mRecyclerView.setLoadingMoreEnabled(true);
        //布局适配
        banner();
//        purpose();
        seckill();
        recommend();
        optimization();
        adapter = new MyAdapter(R.layout.item_adapter_tuijian);
        mRecyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }
    @Override
    public void onResume() {
        super.onResume();


    }

    private void initOkHttpbottom(final RefreshLayout refreshlayout) {

        String build = ParamsUtils.getInstance()
                .params("api", "recommend/getRecommend")
                .params("appid", UrlUtilds.APPID)
                .params("t", time)
                .params("token", "")
                .params("page", String.valueOf(mNumber))
                .params("page_count", String.valueOf(pageCount))
                .build();
        NetUtils netUtils = new NetUtils(getActivity());
        if (netUtils.isNet()) {
            MyOkHttp myOkHttp = new MyOkHttp();
            myOkHttp.post().tag(this)
                    .url(UrlUtilds.recommend)
                    .addParam("s", build)
                    .addParam("api", "recommend/getRecommend")
                    .addParam("appid", UrlUtilds.APPID)
                    .addParam("t", time)
                    .addParam("token", "")
                    .addParam("page", String.valueOf(mNumber))
                    .addParam("page_count", String.valueOf(pageCount))
                    .enqueue(new GsonResponseHandler<HomefragmentBeanbottom>() {
                        @Override
                        public void onSuccess(int statusCode, HomefragmentBeanbottom response) {
                            response.getMsg().getShop_host().getShop().size();
                            adapter.refresh(response.getMsg().getShop_host().getShop());
                            Log.e("HAHHAHA", response.getMsg().getShop_host().getShop().size() + "个");
                            if (refreshlayout != null) {

                                refreshlayout.finishLoadmore(500, true);
                                refreshlayout.finishRefresh(500, true);
                            }

                        }

                        @Override
                        public void onFailure(int statusCode, String error_msg) {
                            if (refreshlayout != null) {
                                refreshlayout.finishRefresh(500, true);
                                refreshlayout.finishLoadmore(500, true);
                            }
                        }
                    });
        }

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.e("TAG", "home_dis");
    }

    private void initOkHttp(final RefreshLayout refreshlayout) {
        if (refreshlayout == null) ;

        String build = ParamsUtils.getInstance()
                .params("api", "carousel/getCarousel")
                .params("appid", UrlUtilds.APPID)
                .params("t", time)
                .params("token", TOken)
                .build();
        Log.e("TAG", "lunbo==" + build);
        NetUtils netUtils = new NetUtils(getActivity());
        if (netUtils.isNet()) {
            MyOkHttp myOkHttp = new MyOkHttp();
            myOkHttp.post().tag(this)
                    .url(UrlUtilds.getCarousel)
                    .addParam("s", build)
                    .addParam("api", "carousel/getCarousel")
                    .addParam("appid", UrlUtilds.APPID)
                    .addParam("t", time)
                    .addParam("token", "")
                    .enqueue(new GsonResponseHandler<HomefragmentBean>() {
                        @Override
                        public void onSuccess(int statusCode, HomefragmentBean response) {

                            List<HomefragmentBean.MsgBean.CarouselBean> carousel = response.getMsg().getCarousel();
                            List<String> list = new ArrayList<String>();
                            for (HomefragmentBean.MsgBean.CarouselBean carouselBean : carousel) {
                                list.add("http://shop.elliotngok.xin" + carouselBean.getPath());
                            }
                            banner.setImages(list);
                            miaoshaList = response.getMsg().getSpike().getSpike_shop();
                            homeMiaoShaView.setData(miaoshaList);
                            homeMiaoShaView.setTime(response.getMsg().getSpike().getSpike_time());
//                            Log.d("HomePagerFragment", "response.getMsg().getSpike().getSpike_time():" + response.getMsg().getSpike().getSpike_time());
                            homeTuiJianView.setData(response.getMsg().getRecommend());
                            homeJingXuanView.setdata(response.getMsg().getFeatured());
                            if (refreshlayout != null) {
                                refreshlayout.finishRefresh(500, true);
                                refreshlayout.finishLoadmore(500, true);
                            }
                        }

                        @Override
                        public void onFailure(int statusCode, String error_msg) {
                            if (refreshlayout != null) {
                                refreshlayout.finishRefresh(500, true);
                                refreshlayout.finishLoadmore(500, true);
                            }
                        }

                        @Override
                        public void onSuccfulString(int code, String message) {
                            super.onSuccfulString(code, message);
                        }
                    });

        }
    }

    @Override
    public void setListener() {

    }

    //轮播首页banner
    private void banner() {
        View headView = LayoutInflater.from(baseActivity).inflate(R.layout.view_head_view, null);
        banner = headView.findViewById(R.id.headView_banner);
        banner.setBannerStyle(CIRCLE_INDICATOR_TITLE);
        banner.isAutoPlay(true);
        banner.setDelayTime(3000);
        banner.setIndicatorGravity(Banner.CENTER);
        mRecyclerView.addHeaderView(headView);

    }

    //首页应用
    private void purpose() {
        homegridview = new HomeGridViewDebirsLayoutView(getActivity());
        homegridview.setHomeGridViewResponseListener(this);
//        String[] name = new String[]{"渠道建议","结算支付","共享周边","新品上市","礼券中心","我要推荐","企业宣传","分类商品"};
        mRecyclerView.addHeaderView(homegridview);
    }
    //秒杀

    private void seckill() {
        homeMiaoShaView = new HomeMiaoShaView(getActivity());
        homeMiaoShaView.setListener(new MiaoShaOnclicter());
        mRecyclerView.addHeaderView(homeMiaoShaView);
    }

    //推荐
    private void recommend() {
        homeTuiJianView = new HomeTuiJianView(getActivity());
        mRecyclerView.addHeaderView(homeTuiJianView);
    }

    //优选 精选
    private void optimization() {
        homeJingXuanView = new HomeJingXuanView(getActivity());
        mRecyclerView.addHeaderView(homeJingXuanView);
        getView().invalidate();
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int postion, long l) {

    }

    @Override
    public void onClick(View view) {
        startActivity(new Intent(baseActivity, HomeSeachActivity.class));
    }

    @Override
    public void qudaojianshe() {
        myDialogText();
    }


    @Override
    public void jiesuanzhifu() {
        myDialogText();
    }

    @Override
    public void gongxiangzhoubian() {
        myDialogText();
    }

    @Override
    public void xinpinshangshi() {
        myDialogText();
    }

    @Override
    public void lijuanzhongxin() {
        myDialogText();
    }

    @Override
    public void woyaotuijian() {
        myDialogText();
    }

    @Override
    public void qiyexuanchuan() {
        myDialogText();
    }

    @Override
    public void fenleisahngpin() {
        myDialogText();
    }

    class MyAdapter extends BaseRecyclerAdapter<HomefragmentBeanbottom.MsgBean.ShopHostBean.ShopBean> {
        public MyAdapter(@LayoutRes int layoutId) {
            super(layoutId);
        }


        @Override
        protected void conver(ViewHolder holder, HomefragmentBeanbottom.MsgBean.ShopHostBean.ShopBean modle, int position) {
            holder.setText(R.id.tv_money, "¥"+modle.getShop_start_money());
            holder.setText(R.id.old_money, "¥"+modle.getShop_end_money());
            holder.setText(R.id.tv_title, modle.getShop_name());
            holder.setRoundImages(R.id.iv_img, UrlUtilds.IMG_URL + modle.getImage_path());

        }

    }

    private void myDialogText() {
        AlertDialog.Builder builder = new AlertDialog.Builder(baseActivity, R.style.MyCommonDialog);
        builder.setView(R.layout.dialog_custom);
        final AlertDialog dialog = builder.create();
        dialog.show();
        TextView textView = (TextView) dialog.findViewById(R.id.home_dialog_determine);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.findViewById(R.id.home_dialog_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });



    }


     class MiaoShaOnclicter implements AdapterView.OnItemClickListener{

        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            HomefragmentBean.MsgBean.SpikeBean.SpikeShopBean spikeShopBean = miaoshaList.get(i);
            spikeShopBean.getId();


        }
    }

}
