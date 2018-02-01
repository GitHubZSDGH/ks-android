package hlks.hualiangou.com.ks_android.fragment.pager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.bumptech.glide.Glide;
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
import hlks.hualiangou.com.ks_android.activity.DetailPagesActivity;
import hlks.hualiangou.com.ks_android.activity.HomeSeachActivity;
import hlks.hualiangou.com.ks_android.base.BaseFragment;
import hlks.hualiangou.com.ks_android.modle.adapter.home.zhenghe.HomeJingXuanAdapter;
import hlks.hualiangou.com.ks_android.modle.adapter.home.zhenghe.HomeMiaoShaAdapter;
import hlks.hualiangou.com.ks_android.modle.adapter.home.zhenghe.HomeReXiaoAdapter;
import hlks.hualiangou.com.ks_android.modle.adapter.home.zhenghe.HomeTuiJianAdapter;
import hlks.hualiangou.com.ks_android.modle.bean.HomefragmentBean;
import hlks.hualiangou.com.ks_android.modle.bean.HomefragmentBeanbottom;
import hlks.hualiangou.com.ks_android.modle.url.UrlUtilds;
import hlks.hualiangou.com.ks_android.utils.UI.ObservableScrollView;
import hlks.hualiangou.com.ks_android.utils.encryption.NetUtils;
import hlks.hualiangou.com.ks_android.view.SnapUpCountDownTimerView;
import hlks.hualiangou.com.ks_android.view.home.FullyGridLayoutManager;
import hlks.hualiangou.com.ks_android.view.home.FullyLinearLayoutManager;

import static com.youth.banner.Banner.CIRCLE_INDICATOR_TITLE;
import static hlks.hualiangou.com.ks_android.App.mContext;

/**
 * 项目名称:
 * 类描述:
 * 创建时间:2017/12/10
 */
public class HomeFragmentPaer extends BaseFragment implements View.OnClickListener {
    private View view;
    private Banner mHomeFragmentBanner;
    private ImageView mTvQudaojianshe;
    private ImageView mTvJiesuanzhifu;
    private ImageView mTvGongxiangzhoubian;
    private ImageView mTvXinpinshangshi;
    private LinearLayout mHomeLl1;
    private ImageView mTvLijuanzhongxin;
    private ImageView mTvWoyaotuijian;
    private ImageView mTvQiyexuanchuan;
    private ImageView mTvFenleisahngpin;
    private LinearLayout mHomeLl2;
    private SnapUpCountDownTimerView mHomeMiaoshaTime;
    private RecyclerView mHomeMiaoshaRv;
    private RecyclerView mHomeTuijianRv;
    private ImageView mHandTuijianImg;
    private RecyclerView mRListview1;
    private ImageView mIdImage2;
    private RecyclerView mRListview2;
    private ImageView mIdImage3;
    private RecyclerView mRListview3;
    private RecyclerView mCxRecyclerView;
    private LinearLayout mHomeFragment;
    private ScrollView mHomeSv;
    private ImageView seachRelat;
    private SmartRefreshLayout smartRefreshLayout;
    private String time;
    private int mNumber = 1;
    private int pageCount = 10;
    private String TOken ="";
    //***数据适配器***
    private HomeMiaoShaAdapter homeMiaoShaAdapter;
    private HomeJingXuanAdapter homeJingXuanAdapter;
    private HomeJingXuanAdapter homeJingXuanAdapter1;
    private HomeJingXuanAdapter homeJingXuanAdapter2;
    private HomeTuiJianAdapter homeTuiJianAdapter;
    private HomeReXiaoAdapter homeReXiaoAdapter;
     //***数据集合***
    private List<HomefragmentBean.MsgBean.SpikeBean.SpikeShopBean> miaoshaList;
    private List<HomefragmentBean.MsgBean.RecommendBean> tuijianList;
    private List<HomefragmentBean.MsgBean.FeaturedBean.ShopBean> jingxuanList;
    private List<HomefragmentBean.MsgBean.FeaturedBean.ShopBean> jingxuanList1;
    private List<HomefragmentBean.MsgBean.FeaturedBean.ShopBean> jingxuanList2;
    private List<HomefragmentBeanbottom.MsgBean.ShopHostBean.ShopBean> rexiaoList;
//*********Top*****
private ObservableScrollView scrollView;
    private ImageView btn_top;
    int timetm;
    int hh;
    int mm;
    int ss;

    @Override
    public int getLayoutId() {
        return R.layout.home_fragment_zhenghe;
    }

    @Override
    public void initView(View view) {
        scrollView = (ObservableScrollView) view.findViewById(R.id.home_sv);
        btn_top = (ImageView) view.findViewById(R.id.btn_top);
        scrollView.setOnScollChangedListener(new ObservableScrollView.OnScollChangedListener() {
            @Override
            public void onScrollChanged(ObservableScrollView scrollView, int x, int y, int oldx, int oldy) {
                if(y>600){
                    btn_top.setVisibility(View.VISIBLE);
                }else {
                    btn_top.setVisibility(View.INVISIBLE);
                }
            }
        });
        btn_top.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollView.scrollTo(0,0);
            }
        });
        //****banner******
        mHomeFragmentBanner = (Banner) view.findViewById(R.id.home_fragment_banner);
        mHomeFragmentBanner.setBannerStyle(CIRCLE_INDICATOR_TITLE);
        mHomeFragmentBanner.isAutoPlay(true);
        mHomeFragmentBanner.setDelayTime(3000);
        mHomeFragmentBanner.setIndicatorGravity(Banner.CENTER);
        mHomeFragmentBanner.setOnBannerClickListener(new Banner.OnBannerClickListener() {
            @Override
            public void OnBannerClick(View view, int position) {

            }
        });
        //****八小板块******
        mTvQudaojianshe = (ImageView) view.findViewById(R.id.tv_qudaojianshe);
        mTvJiesuanzhifu = (ImageView) view.findViewById(R.id.tv_jiesuanzhifu);
        mTvGongxiangzhoubian = (ImageView) view.findViewById(R.id.tv_gongxiangzhoubian);
        mTvXinpinshangshi = (ImageView) view.findViewById(R.id.tv_xinpinshangshi);
        mHomeLl1 = (LinearLayout) view.findViewById(R.id.home_ll1);
        mTvLijuanzhongxin = (ImageView) view.findViewById(R.id.tv_lijuanzhongxin);
        mTvWoyaotuijian = (ImageView) view.findViewById(R.id.tv_woyaotuijian);
        mTvQiyexuanchuan = (ImageView) view.findViewById(R.id.tv_qiyexuanchuan);
        mTvFenleisahngpin = (ImageView) view.findViewById(R.id.tv_fenleisahngpin);
        mHomeLl2 = (LinearLayout) view.findViewById(R.id.home_ll2);

        //****秒杀时间******
        mHomeMiaoshaTime = (SnapUpCountDownTimerView) view.findViewById(R.id.home_miaosha_time);
        //****秒杀、推荐、精选rv******
        mHomeMiaoshaRv = (RecyclerView) view.findViewById(R.id.home_miaosha_rv);
        mHomeTuijianRv = (RecyclerView) view.findViewById(R.id.home_tuijian_rv);
        mHandTuijianImg = (ImageView) view.findViewById(R.id.hand_tuijian_img);
        mRListview1 = (RecyclerView) view.findViewById(R.id.rListview1);
        mIdImage2 = (ImageView) view.findViewById(R.id.id_image2);
        mRListview2 = (RecyclerView) view.findViewById(R.id.rListview2);
        mIdImage3 = (ImageView) view.findViewById(R.id.id_image3);
        mRListview3 = (RecyclerView) view.findViewById(R.id.rListview3);
        //****bottom rv******
        mCxRecyclerView = (RecyclerView) view.findViewById(R.id.cxRecyclerView);
        mHomeFragment = (LinearLayout) view.findViewById(R.id.home_fragment);
//        mHomeSv = (ObservableScrollView) view.findViewById(R.id.home_sv);
        smartRefreshLayout = view.findViewById(R.id.home_paget_refresh);

        seachRelat = view.findViewById(R.id.seach_relat);
        seachRelat.setOnClickListener(this);
        mHomeLl1.setVisibility(View.GONE);
        mHomeLl2.setVisibility(View.GONE);

        Date dt = new Date();
        time = String.valueOf(dt.getTime());
        //****数据集合初始化******
        miaoshaList = new ArrayList<>();
        tuijianList = new ArrayList<>();
        jingxuanList = new ArrayList<>();
        jingxuanList1 = new ArrayList<>();
        jingxuanList2 = new ArrayList<>();
        rexiaoList = new ArrayList<>();

        mHomeMiaoshaRv.setLayoutManager(new FullyLinearLayoutManager(baseActivity, LinearLayoutManager.HORIZONTAL, false){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        mHomeTuijianRv.setLayoutManager(new FullyGridLayoutManager(baseActivity, 3){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        mCxRecyclerView.setLayoutManager(new FullyGridLayoutManager(baseActivity,2){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        mRListview1.setLayoutManager(new FullyLinearLayoutManager(baseActivity, LinearLayoutManager.HORIZONTAL, false){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        mRListview2.setLayoutManager(new FullyLinearLayoutManager(baseActivity, LinearLayoutManager.HORIZONTAL, false){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        mRListview3.setLayoutManager(new FullyLinearLayoutManager(baseActivity, LinearLayoutManager.HORIZONTAL, false){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });

    }

    @Override
    public void onResume() {
        super.onResume();
        initOkHttp(null);
        initOkHttpbottom(null);
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

        //****适配器初始化*******
        homeMiaoShaAdapter =new HomeMiaoShaAdapter(miaoshaList, R.layout.item_new_buy_miaosha, new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                HomefragmentBean.MsgBean.SpikeBean.SpikeShopBean spikeShopBean = miaoshaList.get(i);
                Intent intent = new Intent(baseActivity, DetailPagesActivity.class);
                intent.putExtra("shop_id", String.valueOf(spikeShopBean.getId()));

                startActivity(intent);
            }
        });
        homeTuiJianAdapter = new HomeTuiJianAdapter(tuijianList, R.layout.item_adapter_tuijian, new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                HomefragmentBean.MsgBean.RecommendBean tuijianShopBean = tuijianList.get(i);
                Intent intent = new Intent(baseActivity, DetailPagesActivity.class);
                intent.putExtra("shop_id", String.valueOf(tuijianShopBean.getId()));
                startActivity(intent);
            }
        });
        homeReXiaoAdapter = new HomeReXiaoAdapter(rexiaoList, R.layout.item_adapter_bottom, new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                HomefragmentBeanbottom.MsgBean.ShopHostBean.ShopBean rexiaoBean = rexiaoList.get(i);
                Intent intent = new Intent(baseActivity, DetailPagesActivity.class);
                intent.putExtra("shop_id", String.valueOf(rexiaoBean.getId()));
                startActivity(intent);
            }
        });
        homeJingXuanAdapter = new HomeJingXuanAdapter(jingxuanList, R.layout.item_new_buy, new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                HomefragmentBean.MsgBean.FeaturedBean.ShopBean jingxuanBean = jingxuanList.get(i);
                Intent intent = new Intent(baseActivity, DetailPagesActivity.class);
                intent.putExtra("shop_id", String.valueOf(jingxuanBean.getId()));
                Log.e("onItemClick: ", String.valueOf(jingxuanBean.getId()));
                startActivity(intent);

            }
        });
        homeJingXuanAdapter1 = new HomeJingXuanAdapter(jingxuanList1, R.layout.item_new_buy, new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                HomefragmentBean.MsgBean.FeaturedBean.ShopBean jingxuanBean1 = jingxuanList1.get(i);
                Intent intent = new Intent(baseActivity, DetailPagesActivity.class);
                intent.putExtra("shop_id", String.valueOf(jingxuanBean1.getId()));
                startActivity(intent);
            }
        });
        homeJingXuanAdapter2 = new HomeJingXuanAdapter(jingxuanList2, R.layout.item_new_buy, new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                HomefragmentBean.MsgBean.FeaturedBean.ShopBean jingxuanBean2 = jingxuanList2.get(i);
                Intent intent = new Intent(baseActivity, DetailPagesActivity.class);
                intent.putExtra("shop_id", String.valueOf(jingxuanBean2.getId()));
                startActivity(intent);
            }
        });
        mHomeMiaoshaRv.setAdapter(homeMiaoShaAdapter);
        mHomeTuijianRv.setAdapter(homeTuiJianAdapter);
        mCxRecyclerView.setAdapter(homeReXiaoAdapter);
        mRListview1.setAdapter(homeJingXuanAdapter);
        mRListview2.setAdapter(homeJingXuanAdapter1);
        mRListview3.setAdapter(homeJingXuanAdapter2);
        homeMiaoShaAdapter.refresh(miaoshaList);
        homeTuiJianAdapter.refresh(tuijianList);
        homeReXiaoAdapter.refresh(rexiaoList);
        homeJingXuanAdapter.refresh(jingxuanList);
        homeJingXuanAdapter1.refresh(jingxuanList1);
        homeJingXuanAdapter2.refresh(jingxuanList2);

    }

    public void setTime() {
        hh = timetm / 60 / 60;
        mm = (timetm - hh * 60 * 60) / 60;
        ss = timetm - hh * 60 * 60 - mm  * 60;
        mHomeMiaoshaTime.setTime(hh,mm,ss);
        mHomeMiaoshaTime.start();
    }



    @Override
    public void setListener() {

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
//                            HomeReXiaoAdapter.refresh(response.getMsg().getShop_host().getShop());
                            rexiaoList = response.getMsg().getShop_host().getShop();
                            homeReXiaoAdapter.refresh(rexiaoList);
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



    private void initOkHttp(final RefreshLayout refreshlayout) {
        if (refreshlayout == null) ;

        String build = ParamsUtils.getInstance()
                .params("api", "carousel/getCarousel")
                .params("appid", UrlUtilds.APPID)
                .params("t", time)
                .params("token", TOken)
                .build();
        Log.e("TAG", "lunbo==" + build + time);
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
//                            Log.e( "onSuccess: ",response.getMsg().getRecommend().get(0).getId()+"");
                            List<HomefragmentBean.MsgBean.CarouselBean> carousel = response.getMsg().getCarousel();
                            List<String> list = new ArrayList<String>();
                            for (HomefragmentBean.MsgBean.CarouselBean carouselBean : carousel) {
                                list.add("http://shop.elliotngok.xin" + carouselBean.getPath());
                            }
                            mHomeFragmentBanner.setImages(list);
                            timetm = response.getMsg().getSpike().getSpike_time();
                            setTime();
                            List<HomefragmentBean.MsgBean.FeaturedBean> featured = response.getMsg().getFeatured();

                             if (featured.size() >= 3){
                                 homeJingXuanAdapter.refresh(featured.get(0).getShop());
                                 homeJingXuanAdapter1.refresh(featured.get(1).getShop());
                                 homeJingXuanAdapter2.refresh(featured.get(2).getShop());
                                 Glide.with(mContext).load("http://shop.elliotngok.xin" + featured.get(0).getBanner()).placeholder(R.drawable.search3).error(R.drawable.search3).into(mHandTuijianImg);
                                 Glide.with(mContext).load("http://shop.elliotngok.xin" + featured.get(1).getBanner()).placeholder(R.drawable.search3).error(R.drawable.search3).into(mIdImage2);
                                 Glide.with(mContext).load("http://shop.elliotngok.xin" + featured.get(2).getBanner()).placeholder(R.drawable.search3).error(R.drawable.search3).into(mIdImage3);
                             }



                            miaoshaList = response.getMsg().getSpike().getSpike_shop();
                            tuijianList = response.getMsg().getRecommend();
                            jingxuanList = response.getMsg().getFeatured().get(0).getShop();
                            jingxuanList1 = response.getMsg().getFeatured().get(1).getShop();
                            jingxuanList2 = response.getMsg().getFeatured().get(2).getShop();
                            homeMiaoShaAdapter.refresh(miaoshaList);
                            homeTuiJianAdapter.refresh(tuijianList);

                            homeJingXuanAdapter.refresh(jingxuanList);
                            homeJingXuanAdapter1.refresh(jingxuanList1);
                            homeJingXuanAdapter2.refresh(jingxuanList2);
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
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.seach_relat:
                startActivity(new Intent(baseActivity, HomeSeachActivity.class));
                break;
        }
    }

}
