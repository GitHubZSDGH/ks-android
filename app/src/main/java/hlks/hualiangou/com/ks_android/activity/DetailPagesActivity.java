package hlks.hualiangou.com.ks_android.activity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hankkin.library.GradationScrollView;
import com.hankkin.library.NoScrollListView;
import com.hankkin.library.ScrollViewContainer;
import com.tsy.sdk.myokhttp.response.GsonResponseHandler;
import com.tsy.sdk.myokhttp.response.RawResponseHandler;
import com.tsy.sdk.myokhttp.util.ParamsUtils;
import com.tsy.sdk.myokhttp.util.ToastUtils;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import hlks.hualiangou.com.ks_android.App;
import hlks.hualiangou.com.ks_android.R;
import hlks.hualiangou.com.ks_android.activity.orderdetails.ConfimOrderActivity;
import hlks.hualiangou.com.ks_android.base.BaseActivity;
import hlks.hualiangou.com.ks_android.config.FragmentBuilder;
import hlks.hualiangou.com.ks_android.fragment.detailPages.PingLunFragment;
import hlks.hualiangou.com.ks_android.fragment.detailPages.XiangQingFragment;
import hlks.hualiangou.com.ks_android.modle.bean.DetailPagesBean;
import hlks.hualiangou.com.ks_android.modle.url.UrlUtilds;
import hlks.hualiangou.com.ks_android.utils.UserUtils;
import hlks.hualiangou.com.ks_android.utils.util.PopWindowUtils;
import hlks.hualiangou.com.ks_android.view.FlowLayout;

import static com.youth.banner.Banner.CIRCLE_INDICATOR_TITLE;
import static hlks.hualiangou.com.ks_android.App.baseActivity;

/**
 * 商品详情
 */

public class DetailPagesActivity extends BaseActivity implements View.OnClickListener {
    private TextView buyTextView;
    private String time;
    String shopId;
    private Banner mIvGoodDetaiImg;
    /**
     * 25646券
     */
    private TextView mTvGoodDetailDiscount;
    private LinearLayout mLlOffset;
    private LinearLayout mLlGoodDetailService;
    /**
     * 进入商家
     */
    private TextView mTvTalentDetailOpen;
    private NoScrollListView mNlv;
    /**
     * 继续拖动,查看图文详情
     */
    private TextView mTvGoodDetailTuodong;
    private GradationScrollView mScrollview;
    private NoScrollListView mNlvGoodDetialImgs;
    /**
     * 已经最到底啦!
     */
    private TextView mTvGoodDetailDaodi;
    private ScrollViewContainer mSvContainer;
    private ImageView mIvGoodDetaiBack;
    /**
     * 商品详情
     */
    private TextView mTvGoodDetailTitleGood;
    private ImageView mIvGoodDetaiShop;
    private ImageView mIvGoodDetaiShare;
    private RelativeLayout mLlGoodDetail;
    /**
     * 店铺
     */
    private TextView mTvGoodDetailShop;
    private ImageView mIvGoodDetaiCollectUnselect;
    private ImageView mIvGoodDetaiCollectSelect;
    private LinearLayout mLlGoodDetailCollect;
    /**
     * 加入购物车
     */
    private TextView mTvGoodDetailShopCart;
    /**
     * 立即购买
     */
    private TextView mTvGoodDetailBuy;
    private LinearLayout mLlGoodDetailBottom;
    /**
     * 法国 Chanel 香奈儿 炫亮魅力丝绒唇膏
     */
    private TextView mTvShopName;
    /**
     * 25646券
     */
    private TextView mTvShopPrice;
    /**
     * 快递：￥0.00
     */
    private TextView mKuaidiJiage;
    /**
     * 销量：236件
     */
    private TextView mXiaoliangNab;
    /**
     * 北京顺义
     */
    private TextView mFahuodidian;
    private DetailPagesBean.MsgBean msg;
    private DetailPagesBean.MsgBean.ShopFeaturesBean shopFeaturesBean;
    private TextView shopNum;
    private PopWindowUtils pop;
    private TextView lastTextView;
    private TextView lastTextView1;
    private int maxNum;
    private String shopSpecId;
    //fragment
    private RelativeLayout shopXiangQing;
    private RelativeLayout shopPingJian;
    private FrameLayout shopFragment;
    private XiangQingFragment xiangQingFragment;
    private PingLunFragment pingLunFragment;

    private boolean checkedName;
    private List<DetailPagesBean.MsgBean.ShopFeaturesBean> mshopImage;
    private TextView shopTitle;
    private TextView shopTitle2;


    @Override
    public int getLayoutId() {
        return R.layout.detail_pages_activityone;
    }


    @Override
    public void initView() {
//        mshopImage = new ArrayList<>();
        buyTextView = (TextView) findViewById(R.id.tv_good_detail_buy);
        buyTextView.setOnClickListener(this);
        //获取时间
        Date dt = new Date();
        time = String.valueOf(dt.getTime());
//        banner
        mIvGoodDetaiImg = (Banner) findViewById(R.id.iv_good_detai_img);
        mIvGoodDetaiImg.setBannerStyle(CIRCLE_INDICATOR_TITLE);
        mIvGoodDetaiImg.isAutoPlay(false);
        mIvGoodDetaiImg.setDelayTime(3000);
        mIvGoodDetaiImg.setIndicatorGravity(Banner.CENTER);


        mTvGoodDetailDiscount = (TextView) findViewById(R.id.tv_good_detail_discount);
        mLlOffset = (LinearLayout) findViewById(R.id.ll_offset);
        mLlGoodDetailService = (LinearLayout) findViewById(R.id.ll_good_detail_service);
        mTvTalentDetailOpen = (TextView) findViewById(R.id.tv_talent_detail_open);
        mNlv = (NoScrollListView) findViewById(R.id.nlv_);
        mTvGoodDetailTuodong = (TextView) findViewById(R.id.tv_good_detail_tuodong);
        mScrollview = (GradationScrollView) findViewById(R.id.scrollview);
        mNlvGoodDetialImgs = (NoScrollListView) findViewById(R.id.nlv_good_detial_imgs);
        mTvGoodDetailDaodi = (TextView) findViewById(R.id.tv_good_detail_daodi);
        mSvContainer = (ScrollViewContainer) findViewById(R.id.sv_container);
        mIvGoodDetaiBack = (ImageView) findViewById(R.id.iv_good_detai_back);
        mIvGoodDetaiBack.setOnClickListener(this);
        mTvGoodDetailTitleGood = (TextView) findViewById(R.id.tv_good_detail_title_good);
       //********隐藏分享*******
        mIvGoodDetaiShop = (ImageView) findViewById(R.id.iv_good_detai_shop);
        mIvGoodDetaiShop.setVisibility(View.GONE);
        mIvGoodDetaiShare = (ImageView) findViewById(R.id.iv_good_detai_share);
        mIvGoodDetaiShare.setVisibility(View.GONE);

        mLlGoodDetail = (RelativeLayout) findViewById(R.id.ll_good_detail);
        mTvGoodDetailShop = (TextView) findViewById(R.id.tv_good_detail_shop);
        mTvGoodDetailShop.setOnClickListener(this);
        mIvGoodDetaiCollectUnselect = (ImageView) findViewById(R.id.iv_good_detai_collect_unselect);
        mIvGoodDetaiCollectSelect = (ImageView) findViewById(R.id.iv_good_detai_collect_select);
        mLlGoodDetailCollect = (LinearLayout) findViewById(R.id.ll_good_detail_collect);
        mTvGoodDetailShopCart = (TextView) findViewById(R.id.tv_good_detail_shop_cart);
        mTvGoodDetailShopCart.setOnClickListener(this);
        mTvGoodDetailBuy = (TextView) findViewById(R.id.tv_good_detail_buy);
        mLlGoodDetailBottom = (LinearLayout) findViewById(R.id.ll_good_detail_bottom);
        mTvShopName = (TextView) findViewById(R.id.tv_shop_name);
        mTvShopPrice = (TextView) findViewById(R.id.tv_shop_price);
        mKuaidiJiage = (TextView) findViewById(R.id.kuaidi_jiage);
        mXiaoliangNab = (TextView) findViewById(R.id.xiaoliang_nab);
        mFahuodidian = (TextView) findViewById(R.id.fahuodidian);
        //Fragment
        shopXiangQing = (RelativeLayout) findViewById(R.id.shop_details);
        shopPingJian = (RelativeLayout) findViewById(R.id.shop_evaluate);
        shopFragment = (FrameLayout) findViewById(R.id.shop_details_fragment);
        shopXiangQing.setOnClickListener(this);
        shopPingJian.setOnClickListener(this);

        xiangQingFragment = new XiangQingFragment();
        pingLunFragment = new PingLunFragment();


    }


    private void initShopPage() {

        List<DetailPagesBean.MsgBean.ShopSpecBean> shopSpec = msg.getShop_spec();
        View view = LayoutInflater.from(this).inflate(R.layout.shop_popup, null);
        ImageView shopImage = view.findViewById(R.id.iv_shop_img);
        TextView shopMoney = view.findViewById(R.id.iv_shop_price);
        TextView shopAdeuate = view.findViewById(R.id.tv_adequate);
        final TextView textone = view.findViewById(R.id.textone);
        final TextView shopspecifications = view.findViewById(R.id.tv_shop_specifications);
        final TextView shopSize = view.findViewById(R.id.tv_shop_size);
        TextView shopNumReduce = view.findViewById(R.id.order_numder_reduce);
        TextView shopNumadd = view.findViewById(R.id.order_numder_add);
        TextView shopSure = view.findViewById(R.id.iv_shop_sure);
        shopSure.setOnClickListener(this);
        shopNum = view.findViewById(R.id.order_numder);
        ImageView shopBack = view.findViewById(R.id.iv_delete_popup);
        LinearLayout shopAdd = view.findViewById(R.id.shop_lin_add);
        Glide.with(baseActivity).load(UrlUtilds.IMG_URL + msg.getShop_features()).into(shopImage);
        //创建title
        if(msg!=null&&!msg.getShop_name().isEmpty()&&!msg.getSpec_one().isEmpty()) {
            shopTitle = new TextView(this);

            shopTitle.setText(msg.getSpec_one());
            shopTitle2 = new TextView(this);
            shopTitle2.setText(msg.getSpec_two());
        }else {
            return;
        }
        int length = shopSpec.size();
      //这段代码不能动，会有全局bug 稍后修改
        FlowLayout flowLayout = new FlowLayout(this);
        flowLayout.setRowSpacing(20);
        final FlowLayout flowLayoutPage = new FlowLayout(this);
        flowLayout.setChildSpacing(20);
        flowLayoutPage.setChildSpacing(20);
        flowLayoutPage.setRowSpacing(20);

        shopAdd.addView(shopTitle, 0);
        shopAdd.addView(flowLayout, 1);
        shopAdd.addView(shopTitle2, 2);
        shopAdd.addView(flowLayoutPage, 3);

        for (int i = 0; i < length; i++) {
            final DetailPagesBean.MsgBean.ShopSpecBean shopSpecBean = shopSpec.get(i);
            final TextView textView = new TextView(this);
            textView.setBackgroundResource(R.drawable.shop_shop_white);
            textView.setPadding(50, 10, 50, 10);
            textView.setText(shopSpecBean.getSpec_one_name());
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (lastTextView1 != null) {
                        lastTextView1.setBackgroundResource(R.drawable.shop_shop_white);
                        lastTextView1.setTextColor(getResources().getColor(R.color.black));
                    }
                    textView.setTextColor(getResources().getColor(R.color.color_e53e42));
                    textView.setBackgroundResource(R.drawable.shop_shop_red);
                    textone.setText("");
                    shopspecifications.setText(textView.getText() + "、");
                    lastTextView1 = textView;
                    flowLayoutPage.removeAllViews();
                    addSecondView(textone, shopSize, flowLayoutPage, shopSpecBean);


                }
            });
            flowLayout.addView(textView);
//            addSecondView(textone, shopSize, flowLayoutPage, shopSpecBean);
        }

        shopBack.setOnClickListener(this);
        shopNumadd.setOnClickListener(this);
        shopNumReduce.setOnClickListener(this);
        Glide.with(this).load(UrlUtilds.IMG_URL + msg.getMember_image()).into(shopImage);
        shopMoney.setText(msg.getShop_end_money());
//        shopAdeuate.setText("");
//        shopspecifications.setText();

        pop = new PopWindowUtils(view, LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        pop.setOutsideTouchable(true);
        pop.setFocusable(true);
        pop.setBackgroundDrawable(new ColorDrawable());
        view.setFocusable(true);
        view.setFocusableInTouchMode(true);

        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.alpha = 0.3f;
        getWindow().setAttributes(lp);

        pop.showAtLocation(getWindow().getDecorView(), Gravity.BOTTOM, 0, 0,DetailPagesActivity.this);
    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();
        WindowManager.LayoutParams lp2 = getWindow().getAttributes();
        lp2.alpha = 1.0f;
        getWindow().setAttributes(lp2);
    }


    private void addSecondView(final TextView textone, final TextView shopSize, FlowLayout flowLayoutPage, DetailPagesBean.MsgBean.ShopSpecBean shopSpecBean) {
        List<DetailPagesBean.MsgBean.ShopSpecBean.SpecTwoBean> specTwo = shopSpecBean.getSpec_two();
        lastTextView = null;
        /**
         * 参数的集合
         */
        int shopPageLength = specTwo.size();
        for (int j = 0; j < shopPageLength; j++) {
            /**
             * 加的商品的参=参数信息
             */
            final TextView textView1 = new TextView(this);
            textView1.setBackgroundResource(R.drawable.shop_shop_white);
            textView1.setPadding(50, 10, 50, 10);

            final DetailPagesBean.MsgBean.ShopSpecBean.SpecTwoBean specTwoBean = specTwo.get(j);
            textView1.setText(specTwoBean.getSpec_two_name());
            textView1.setTag(specTwoBean.getStock_num());
            textView1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (lastTextView != null) {
                        lastTextView.setBackgroundResource(R.drawable.shop_shop_white);
                        lastTextView.setTextColor(getResources().getColor(R.color.black));
                    }
                    shopSpecId = specTwoBean.getId();
                    textView1.setTextColor(getResources().getColor(R.color.color_e53e42));
                    textView1.setBackgroundResource(R.drawable.shop_shop_red);
                    shopSize.setVisibility(View.VISIBLE);
                    textone.setText("");
                    shopSize.setText(textView1.getText());
                    lastTextView = textView1;
                    maxNum = Integer.parseInt(specTwoBean.getStock_num());
                }
            });
            flowLayoutPage.addView(textView1);
        }
    }

    @Override
    public void loadData() {
        Intent intent = this.getIntent();
        shopId = intent.getStringExtra("shop_id");
        Log.e("loadData: ", shopId+"");
        if (UserUtils.getToken().isEmpty()) {
//            startActivity(new Intent(baseActivity, LoginActivity.class));
            myDialogText();
            return;
        }
        initOkHttp();
    }

    private void myDialogText() {
        AlertDialog.Builder builder = new AlertDialog.Builder(baseActivity, R.style.MyCommonDialog);
        builder.setView(R.layout.shop_dialog_custom);
        final AlertDialog dialog = builder.create();
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
        TextView textView = (TextView) dialog.findViewById(R.id.home_dialog_determine);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(baseActivity, LoginActivity.class));
                dialog.dismiss();
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        initOkHttp();
    }

    private void initOkHttp() {
        String build = ParamsUtils.getInstance()
                .params("api", "shop/getShopInfo")
                .params("appid", UrlUtilds.APPID)
                .params("t", time)
                .params("token", UserUtils.getToken())
                .params("shop_id", shopId)
                .build();
        App.myOkHttp.post().tag(this)
                .url(UrlUtilds.GET_SHOPINFO)
                .addParam("api", "shop/getShopInfo")
                .addParam("appid", UrlUtilds.APPID)
                .addParam("t", time)
                .addParam("s", build)
                .addParam("token", UserUtils.getToken())
                .addParam("shop_id", shopId)
                .enqueue(new GsonResponseHandler<DetailPagesBean>() {
                    @Override
                    public void onSuccess(int statusCode, DetailPagesBean response) {
                        Log.e("DetailPagesActivity", "onSuccess");
                        List<DetailPagesBean.MsgBean.ShopImageBean> msgImage = response.getMsg().getShop_image();
                        mshopImage = response.getMsg().getShop_features();
                        msg = response.getMsg();
//                        shopFeaturesBean=response.getMsg().getShop_features();
//                        mshopImage = response.getMsg().getShop_features();


//                        for (DetailPagesBean.MsgBean.ShopFeaturesBean shopFeaturesBean:mshopImage){
//                            mshopImage.add("http://shop.elliotngok.xin" +);
//                        }
                        mTvShopName.setText(response.getMsg().getShop_name());
                        mTvShopPrice.setText("¥" + response.getMsg().getShop_end_money());
                        mTvGoodDetailDiscount.setText(response.getMsg().getShop_start_money());
                        mKuaidiJiage.setText("快递: ¥" + response.getMsg().getFreight());
                        mXiaoliangNab.setText("销售量："+response.getMsg().getSale_num() + "件");
//                        Glide.with(baseActivity).load(UrlUtilds.IMG_URL + response.getMsg().getShop_image().get(0).getPath()).into(mIvGoodDetaiImg);
                        List<String> list = new ArrayList<String>();
                        for (DetailPagesBean.MsgBean.ShopImageBean msgBean : msgImage) {
                            list.add("http://shop.elliotngok.xin" + msgBean.getPath());
                        }
                        //轮播图
                        mIvGoodDetaiImg.setImages(list);

                        msg.setShop_num("1");
                        Bundle bundle = new Bundle();
                        bundle.putParcelableArrayList("shopImage", (ArrayList<? extends Parcelable>) mshopImage);
                        FragmentBuilder.getInstance(baseActivity)
                                .start(XiangQingFragment.class)
                                .setBundle(bundle)
                                .add(R.id.shop_details_fragment)
                                .commit();
                    }

                    @Override
                    public void onFailure(int statusCode, String error_msg) {
                        Log.e("DetailPagesActivity", "onFailure");
                    }

                    @Override
                    public void onSuccfulString(int code, String message) {
                        myDialogText();
                    }
                });
    }

    @Override
    public void setListener() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.tv_good_detail_shop_cart:
                checkedName = true;
                initShopPage();

                break;
            case R.id.tv_good_detail_shop:
               Intent in = new Intent(DetailPagesActivity.this,MainActivity.class);
                in.putExtra("fragment",1);
                startActivity(in);

                break;



            //立即购买，跳转到确定订单
            case R.id.tv_good_detail_buy:
                 checkedName = false;
                initShopPage();
                break;
            case R.id.order_numder_add:
                String trim = shopNum.getText().toString().trim();
                shopNum.setText(String.valueOf(Integer.parseInt(trim) + 1));
                msg.setShop_num(shopNum.getText().toString().trim());
                break;
            case R.id.iv_delete_popup:
                pop.dismiss();
                WindowManager.LayoutParams lp = getWindow().getAttributes();
                lp.alpha = 1.0f;
                getWindow().setAttributes(lp);
                break;
            case R.id.order_numder_reduce:
                String trim1 = shopNum.getText().toString().trim();
                if (Integer.parseInt(trim1) > 0)
                    shopNum.setText(String.valueOf(Integer.parseInt(trim1) - 1));
                msg.setShop_num(shopNum.getText().toString().trim());
                break;
            //确定
            case R.id.iv_shop_sure:
                if (TextUtils.isEmpty(shopNum.getText()) || TextUtils.isEmpty(shopSpecId)) {
                    ToastUtils.showSingleLongToast("请补全商品信息");
                    return;
                }
                pop.dismiss();
                WindowManager.LayoutParams lp1 = getWindow().getAttributes();
                lp1.alpha = 1.0f;
                getWindow().setAttributes(lp1);
                if (checkedName!=false){
                initOkHttpAdd();
                }else {
                Bundle bundle = new Bundle();
                    DetailPagesBean.MsgBean bean = new DetailPagesBean.MsgBean();
                    bean.setShop_name(msg.getShop_name());
                    bean.setMember_image(msg.getMember_image());
                    bean.setCategroy_id(msg.getCategroy_id());
                    bean.setFreight(msg.getFreight());
                    bean.setId(msg.getId());
                    bean.setMember_id(msg.getMember_id());
                    bean.setSale_num(shopNum.getText().toString().trim());
                    bean.setShop_end_money(msg.getShop_end_money());

                ArrayList<DetailPagesBean.MsgBean> list = new ArrayList<>();
                list.add(msg);

                bundle.putParcelableArrayList("details", list);
                Intent intent = new Intent(DetailPagesActivity.this, ConfimOrderActivity.class);
                intent.putExtra("bundle", bundle);
                intent.putExtra("isbuy", true);
                intent.putExtra("allMoney", String.valueOf(Double.parseDouble(msg.getShop_end_money()) + Double.parseDouble(msg.getFreight())));
                startActivity(intent);
                }
                break;
            case R.id.shop_details:
                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList("shopImage", (ArrayList<? extends Parcelable>) mshopImage);
                FragmentBuilder.getInstance(baseActivity)
                        .start(XiangQingFragment.class)
                        .setBundle(bundle)
                        .add(R.id.shop_details_fragment)
                        .commit();

                break;
            case R.id.shop_evaluate:
                FragmentBuilder.getInstance(baseActivity)
                        .start(PingLunFragment.class)
                        .add(R.id.shop_details_fragment)
                        .commit();
                break;
            case R.id.iv_good_detai_back:
                finish();
                break;

            default:
        }
    }

    //添加购物车请求
    private void initOkHttpAdd() {
        App.myOkHttp
                .postParams()
                .url(UrlUtilds.CREATE)
                .addParam("api", "Cart/create")
                .addParam("appid", UrlUtilds.APPID)
                .addParam("t", time)
                .addParam("token", UserUtils.getToken())
                .addParam("shop_id", shopId)
                .addParam("user_id", UserUtils.getUserId())
                .addParam("shop_spec_id", shopSpecId)
                .addParam("shop_name", msg.getShop_name())
                .addParam("shop_num", shopNum.getText().toString().trim())
                .addParam("shop_price", msg.getShop_end_money())
                .addParam("shop_image", msg.getShop_image().get(0).getPath())
                .addParam("order_money", String.valueOf(Double.parseDouble(msg.getShop_end_money()) * Double.parseDouble(shopNum.getText().toString().trim())))
                .addParam("member_id", String.valueOf(msg.getMember_id()))
                .addParam("member_name", msg.getMember_name())
                .enqueue(new RawResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, String response) {
                        Log.d("DetailPagesActivity", response.toString().trim());
                        myDialogJieSuan();
                    }

                    @Override
                    public void onFailure(int statusCode, String error_msg) {
                        Log.d("DetailPagesActivity", error_msg.toString().trim());
                        myDialog();
                    }
                });

    }
    private void myDialogJieSuan() {
        AlertDialog.Builder builder = new AlertDialog.Builder(baseActivity, R.style.MyCommonDialog);
        builder.setView(R.layout.shop_dialog_custom);
        final AlertDialog dialog = builder.create();
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
        TextView textView = (TextView) dialog.findViewById(R.id.home_dialog_determine);
        TextView textView1 = (TextView) dialog.findViewById(R.id.dialog_text);
        TextView textView2 = (TextView) dialog.findViewById(R.id.home_dialog);
        textView2.setVisibility(View.GONE);
        textView1.setText("添加购物车成功");
        textView.setText("确定");
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
    }
    private void myDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(baseActivity, R.style.MyCommonDialog);
        builder.setView(R.layout.shop_dialog_custom);
        final AlertDialog dialog = builder.create();
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
        TextView textView = (TextView) dialog.findViewById(R.id.home_dialog_determine);
        TextView textView1 = (TextView) dialog.findViewById(R.id.dialog_text);
        textView1.setText("添加购物车失败");
        textView.setText("确定");
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
    }
}
