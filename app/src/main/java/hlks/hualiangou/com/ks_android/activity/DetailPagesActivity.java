package hlks.hualiangou.com.ks_android.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hankkin.library.GradationScrollView;
import com.hankkin.library.NoScrollListView;
import com.hankkin.library.ScrollViewContainer;
import com.tsy.sdk.myokhttp.response.GsonResponseHandler;
import com.tsy.sdk.myokhttp.util.ParamsUtils;

import java.util.Date;
import java.util.List;

import hlks.hualiangou.com.ks_android.App;
import hlks.hualiangou.com.ks_android.R;
import hlks.hualiangou.com.ks_android.base.BaseActivity;
import hlks.hualiangou.com.ks_android.modle.bean.DetailPagesBean;
import hlks.hualiangou.com.ks_android.modle.url.UrlUtilds;
import hlks.hualiangou.com.ks_android.utils.UserUtils;

import static hlks.hualiangou.com.ks_android.R.id.order_numder_add;

/**
 * 商品详情
 */

public class DetailPagesActivity extends BaseActivity implements View.OnClickListener {
    private TextView buyTextView;
    private String time;
    String shopId;
    private ImageView mIvGoodDetaiImg;
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
    private TextView shopNum;
    private PopupWindow pop;

    @Override
    public int getLayoutId() {
        return R.layout.detail_pages_activityone;
    }


    @Override
    public void initView() {
        buyTextView = (TextView) findViewById(R.id.tv_good_detail_buy);
        buyTextView.setOnClickListener(this);
        //获取时间
        Date dt = new Date();
        time = String.valueOf(dt.getTime());
        mIvGoodDetaiImg = (ImageView) findViewById(R.id.iv_good_detai_img);
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
        mTvGoodDetailTitleGood = (TextView) findViewById(R.id.tv_good_detail_title_good);
        mIvGoodDetaiShop = (ImageView) findViewById(R.id.iv_good_detai_shop);
        mIvGoodDetaiShare = (ImageView) findViewById(R.id.iv_good_detai_share);
        mLlGoodDetail = (RelativeLayout) findViewById(R.id.ll_good_detail);
        mTvGoodDetailShop = (TextView) findViewById(R.id.tv_good_detail_shop);
        mIvGoodDetaiCollectUnselect = (ImageView) findViewById(R.id.iv_good_detai_collect_unselect);
        mIvGoodDetaiCollectSelect = (ImageView) findViewById(R.id.iv_good_detai_collect_select);
        mLlGoodDetailCollect = (LinearLayout) findViewById(R.id.ll_good_detail_collect);
        mTvGoodDetailShopCart = (TextView) findViewById(R.id.tv_good_detail_shop_cart);
        mTvGoodDetailBuy = (TextView) findViewById(R.id.tv_good_detail_buy);
        mLlGoodDetailBottom = (LinearLayout) findViewById(R.id.ll_good_detail_bottom);
        mTvShopName = (TextView) findViewById(R.id.tv_shop_name);
        mTvShopPrice = (TextView) findViewById(R.id.tv_shop_price);
        mKuaidiJiage = (TextView) findViewById(R.id.kuaidi_jiage);
        mXiaoliangNab = (TextView) findViewById(R.id.xiaoliang_nab);
        mFahuodidian = (TextView) findViewById(R.id.fahuodidian);
    }


    private void initShopPage() {
        List<DetailPagesBean.MsgBean.ShopSpecBean> shop_spec = msg.getShop_spec();

        View view = LayoutInflater.from(this).inflate(R.layout.shop_popup, null);
        ImageView shopImage = view.findViewById(R.id.iv_shop_img);
        TextView shopMoney = view.findViewById(R.id.iv_shop_price);
        TextView shopAdeuate = view.findViewById(R.id.tv_adequate);
        TextView shopspecifications = view.findViewById(R.id.tv_shop_specifications);
        TextView shopNumReduce = view.findViewById(R.id.order_numder_reduce);
        TextView shopNumadd = view.findViewById(order_numder_add);
        shopNum = view.findViewById(R.id.order_numder);
        ImageView shopBack = view.findViewById(R.id.iv_delete_popup);
        LinearLayout shopAdd = view.findViewById(R.id.shop_lin_add);

        TextView shopTitle = new TextView(this);

        shopBack.setOnClickListener(this);
        shopNumadd.setOnClickListener(this);
        shopNumReduce.setOnClickListener(this);
        Glide.with(this).load(msg.getMember_image()).into(shopImage);
        shopMoney.setText(msg.getShop_end_money());
//        shopAdeuate.setText("");
//        shopspecifications.setText();

        pop = new PopupWindow(view, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.alpha = 0.3f;
        getWindow().setAttributes(lp);

        pop.showAtLocation(getWindow().getDecorView(), Gravity.BOTTOM, 0, 0);
    }

    @Override
    public void loadData() {
        Intent intent = this.getIntent();
        shopId = intent.getStringExtra("shop_id");
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
                        msg = response.getMsg();
                        mTvShopName.setText(response.getMsg().getShop_name());
                        mTvShopPrice.setText(response.getMsg().getShop_end_money() + "券");
                        mTvGoodDetailDiscount.setText(response.getMsg().getShop_start_money() + "券");
                        mKuaidiJiage.setText("￥" + response.getMsg().getFreight());
                        mXiaoliangNab.setText(response.getMsg().getSale_num() + "件");

                    }

                    @Override
                    public void onFailure(int statusCode, String error_msg) {

                    }
                });
    }

    @Override
    public void setListener() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_good_detail_buy:
//                startActivity(new Intent(DetailPagesActivity.this, ConfimOrderActivity.class));
                initShopPage();

                break;
            case R.id.order_numder_add:
                String trim = shopNum.getText().toString().trim();
                shopNum.setText(String.valueOf(Integer.parseInt(trim)+1));
                break;
            case R.id.iv_delete_popup:
                pop.dismiss();
                WindowManager.LayoutParams lp = getWindow().getAttributes();
                lp.alpha = 1.0f;
                getWindow().setAttributes(lp);
                break;
            case R.id.order_numder_reduce:
                String trim1 = shopNum.getText().toString().trim();
                shopNum.setText(String.valueOf(Integer.parseInt(trim1)-1));
                break;


            default:
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO:OnCreate Method has been created, run FindViewById again to generate code
        setContentView(R.layout.detail_pages_activityone);
        initView();
    }
}
