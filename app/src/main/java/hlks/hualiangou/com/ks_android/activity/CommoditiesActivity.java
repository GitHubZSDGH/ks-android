package hlks.hualiangou.com.ks_android.activity;

import android.content.Intent;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tsy.sdk.myokhttp.response.GsonResponseHandler;
import com.tsy.sdk.myokhttp.util.ParamsUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import hlks.hualiangou.com.ks_android.App;
import hlks.hualiangou.com.ks_android.R;
import hlks.hualiangou.com.ks_android.base.BaseActivity;
import hlks.hualiangou.com.ks_android.base.BaseAdapterb.BaseRecyclerAdapter;
import hlks.hualiangou.com.ks_android.base.BaseAdapterb.ViewHolder;
import hlks.hualiangou.com.ks_android.modle.bean.Seachbean;
import hlks.hualiangou.com.ks_android.modle.url.UrlUtilds;
import hlks.hualiangou.com.ks_android.utils.UI.DividerItemDecoration;
import hlks.hualiangou.com.ks_android.utils.UserUtils;

/**
 * 项目名称:
 * 类描述:商品列表
 */
public class CommoditiesActivity extends BaseActivity implements View.OnClickListener {
    private ImageView imCommoditiesBack;//返回
    private EditText etCommoditiesSeach;//填写商品
    private TextView tvCommoditiesWhole;//商品全部
    private TextView tvCommoditiesSale;//商品销量
    private TextView tvCommoditiesPrice;//商品价格
    private TextView tvCommoditiesComment;//商品评论
    private TextView tvCommoditiesScreen;//商品筛选
    private TextView tvCommoditiesSeach;//搜索按键
    private RecyclerView mRecycle;
    private LinearLayout mLlYes,mLlNo;
    private String time;
    private List<Seachbean.MsgBean.ShopBean> mShopList = new ArrayList<>();
    private MyAdapter adapter;
    @Override
    public int getLayoutId() {
        return R.layout.commodities_list;
    }

    @Override
    public void initView() {

        //获取id
        mRecycle = (RecyclerView) findViewById(R.id.commodities_recycle);
        mRecycle.setLayoutManager(new GridLayoutManager(this,2));

        tvCommoditiesWhole = (TextView) findViewById(R.id.commodities_whole);
        tvCommoditiesSale = (TextView) findViewById(R.id.commodities_sale);
        tvCommoditiesPrice = (TextView) findViewById(R.id.commodities_price);
        tvCommoditiesComment = (TextView) findViewById(R.id.commodities_comment);
        tvCommoditiesScreen = (TextView) findViewById(R.id.commodities_screen);
        imCommoditiesBack = (ImageView) findViewById(R.id.search_activity_img);
        etCommoditiesSeach = (EditText) findViewById(R.id.search_activity_et);
        tvCommoditiesSeach = (TextView) findViewById(R.id.commodities_seach);
        mLlYes = (LinearLayout) findViewById(R.id.ll_yes);
        mLlNo = (LinearLayout) findViewById(R.id.ll_no);
        //获取时间
        Date dt = new Date();
        time = String.valueOf(dt.getTime());
        //id监听事件
        tvCommoditiesWhole.setOnClickListener(this);
        tvCommoditiesSale.setOnClickListener(this);
        tvCommoditiesPrice.setOnClickListener(this);
        tvCommoditiesComment.setOnClickListener(this);
        tvCommoditiesScreen.setOnClickListener(this);
        imCommoditiesBack.setOnClickListener(this);
        tvCommoditiesSeach.setOnClickListener(this);
        Intent intent = getIntent();
        if (intent != null) {
            etCommoditiesSeach.setText(intent.getStringExtra("commodities"));
        }

    }

    @Override
    public void loadData() {
//        mRecycle.setPullRefreshEnabled(true);
//        mRecycle.setLoadingMoreEnabled(true);
        initOkHttp();
        //布局适配
        adapter = new MyAdapter(R.layout.item_seach_category);
        mRecycle.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        //垂直+水平分割线
        mRecycle.addItemDecoration(new DividerItemDecoration(
                CommoditiesActivity.this, DividerItemDecoration.BOTH_SET));
    }

    @Override
    public void setListener() {
    adapter.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Log.d("CommoditiesActivity", "mShopList.size():" + mShopList.size());
        Intent intent = new Intent(CommoditiesActivity.this,DetailPagesActivity.class);
        intent.putExtra("shop_id",mShopList.get(i).getId());
        startActivity(intent);
    }
     });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.commodities_whole://全部
                 initOkHttp();
                break;
            case R.id.commodities_sale://销量
                 initOkHttpSale();
                break;
            case R.id.commodities_price://价格
                 initOkHttpPrice();
                break;
            case R.id.commodities_comment://评论
                 initOkHttpComment();
                break;
            case R.id.commodities_screen://筛选
                 initOkHttpScreen();
                break;
            case R.id.search_activity_img://返回
                finish();
                break;

            case R.id.commodities_seach://搜索内容
                initOkHttp();
                break;

        }
    }
    //默认或全部请求
    private void initOkHttp() {
        String build = ParamsUtils.getInstance()
                .params("api", "shop/getShop")
                .params("appid", UrlUtilds.APPID)
                .params("t", time)
                .params("token", UserUtils.getToken())
                .params("shop_name",etCommoditiesSeach.getText().toString())
                .params("shop_end_money","asc")
                .params("page","1")
                .params("page_count","5")
                .build();
        App.myOkHttp.post().tag(this)
                .url(UrlUtilds.GET_SHOP)
                .addParam("api", "shop/getShop")
                .addParam("appid", UrlUtilds.APPID)
                .addParam("t", time)
                .addParam("token", UserUtils.getToken())
                .addParam("s",build)
                .addParam("shop_name",etCommoditiesSeach.getText().toString())
                .addParam("shop_end_money","asc")
                .addParam("page", String.valueOf(1))
                .addParam("page_count", String.valueOf(5))
                .enqueue(new GsonResponseHandler<Seachbean>() {
                    @Override
                    public void onSuccess(int statusCode, Seachbean response) {
                       mShopList.addAll(response.getMsg().getShop());
                        adapter.refresh(response.getMsg().getShop());
                        Log.d("CommoditiesActivity", "response.getMsg().getShop():" + mShopList.size());
                    }

                    @Override
                    public void onFailure(int statusCode, String error_msg) {

                    }
                });
    }
     //销量请求
    private void initOkHttpSale() {
        String build = ParamsUtils.getInstance()
                .params("api", "shop/getShop")
                .params("appid", UrlUtilds.APPID)
                .params("t", time)
                .params("token", "")
                .params("shop_name",etCommoditiesSeach.getText().toString())
                .params("sale_num","asc")
                .params("page","1")
                .params("page_count","5")
                .build();
        App.myOkHttp.post().tag(this)
                .url(UrlUtilds.GET_SHOP)
                .addParam("api", "shop/getShop")
                .addParam("appid", UrlUtilds.APPID)
                .addParam("t", time)
                .addParam("token", "")
                .addParam("s",build)
                .addParam("shop_name",etCommoditiesSeach.getText().toString())
                .addParam("sale_num","asc")

                .addParam("page", String.valueOf(1))
                .addParam("page_count", String.valueOf(5))
                .enqueue(new GsonResponseHandler<Seachbean>() {
                    @Override
                    public void onSuccess(int statusCode, Seachbean response) {

                    }

                    @Override
                    public void onFailure(int statusCode, String error_msg) {

                    }
                });
    }
     //价格请求
    private void initOkHttpPrice() {
        String build = ParamsUtils.getInstance()
                .params("api", "shop/getShop")
                .params("appid", UrlUtilds.APPID)
                .params("t", time)
                .params("token", "")
                .params("shop_name",etCommoditiesSeach.getText().toString())
                .params("shop_end_money","asc")
                .params("page","1")
                .params("page_count","5")
                .build();
        App.myOkHttp.post().tag(this)
                .url(UrlUtilds.GET_SHOP)
                .addParam("api", "shop/getShop")
                .addParam("appid", UrlUtilds.APPID)
                .addParam("t", time)
                .addParam("token", "")
                .addParam("s",build)
                .addParam("shop_name",etCommoditiesSeach.getText().toString())
                .addParam("shop_end_money","asc")
                .addParam("page", String.valueOf(1))
                .addParam("page_count", String.valueOf(5))
                .enqueue(new GsonResponseHandler<Seachbean>() {
                    @Override
                    public void onSuccess(int statusCode, Seachbean response) {

                    }

                    @Override
                    public void onFailure(int statusCode, String error_msg) {

                    }
                });
    }
     //评论请求
    private void initOkHttpComment() {
        String build = ParamsUtils.getInstance()
                .params("api", "shop/getShop")
                .params("appid", UrlUtilds.APPID)
                .params("t", time)
                .params("token", "")
                .params("shop_name",etCommoditiesSeach.getText().toString())
                .params("comment_num","asc")
                .params("page","1")
                .params("page_count","5")
                .build();
        App.myOkHttp.post().tag(this)
                .url(UrlUtilds.GET_SHOP)
                .addParam("api", "shop/getShop")
                .addParam("appid", UrlUtilds.APPID)
                .addParam("t", time)
                .addParam("token", "")
                .addParam("s",build)
                .addParam("shop_name",etCommoditiesSeach.getText().toString())
                .addParam("shop_end_money","asc")
                .addParam("page", String.valueOf(1))
                .addParam("page_count", String.valueOf(5))
                .enqueue(new GsonResponseHandler<Seachbean>() {
                    @Override
                    public void onSuccess(int statusCode, Seachbean response) {

                    }

                    @Override
                    public void onFailure(int statusCode, String error_msg) {

                    }
                });
    }
     //筛选请求
    private void initOkHttpScreen() {
        String build = ParamsUtils.getInstance()
                .params("api", "shop/getShop")
                .params("appid", UrlUtilds.APPID)
                .params("t", time)
                .params("token", "")
                .params("shop_name",etCommoditiesSeach.getText().toString())
                .params("shop_end_money","asc")
                .params("page","1")
                .params("page_count","5")
                .build();
        App.myOkHttp.post().tag(this)
                .url(UrlUtilds.GET_SHOP)
                .addParam("api", "shop/getShop")
                .addParam("appid", UrlUtilds.APPID)
                .addParam("t", time)
                .addParam("token", "")
                .addParam("s",build)
                .addParam("shop_name",etCommoditiesSeach.getText().toString())
                .addParam("shop_end_money","asc")
                .addParam("page", String.valueOf(1))
                .addParam("page_count", String.valueOf(5))
                .enqueue(new GsonResponseHandler<Seachbean>() {
                    @Override
                    public void onSuccess(int statusCode, Seachbean response) {
                      response.getMsg().getShop();
                    }

                    @Override
                    public void onFailure(int statusCode, String error_msg) {

                    }
                });

    }

class MyAdapter extends BaseRecyclerAdapter<Seachbean.MsgBean.ShopBean> {
    public MyAdapter(@LayoutRes int layoutId) {
        super(layoutId);
    }

    @Override
    protected void conver(ViewHolder holder, Seachbean.MsgBean.ShopBean modle, int position) {
        holder.setRoundImages(R.id.item_category_seachimg, UrlUtilds.IMG_URL+modle.getImage_path());
        holder.setText(R.id.shop_name,modle.getShop_name());
        holder.setText(R.id.item_money_integer,"¥"+modle.getShop_end_money());
        holder.setText(R.id.item_comment_number,modle.getComment_num()+"条评论");
        holder.setText(R.id.item_craise_rate,"好评率"+modle.getGood_commont()+"%");
    }

}

}
