package hlks.hualiangou.com.ks_android.activity.main.order;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import hlks.hualiangou.com.ks_android.R;
import hlks.hualiangou.com.ks_android.adapter.OrderDetailAdapter;
import hlks.hualiangou.com.ks_android.bean.OrderDataBean;
import hlks.hualiangou.com.ks_android.view.MyListView;

public class OrderDetailsActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView storeNmae;

    private TextView receiptName;
    private TextView receiptPhone;
    private TextView receiptAdress;

    private TextView freight;

    private TextView money;
    private OrderDetailAdapter myAdapter;
    private MyListView mListView;

    private TextView orderNumber;
    private TextView creatTime;
    private TextView playTime;
    private ImageView mGoBackImg;
    /**
     * 返回
     */
    private TextView mGetBackTv;
    private RelativeLayout mGoBack;
    private ImageView mOrderTime;
    private TextView mOrderZhuangtai;
    private TextView mErjizhuangtai;
    private LinearLayout mErjizhuangtaiLl;
    private ImageView mOrderAddressImg;
    /**
     * 收货人：
     */
    private TextView mOrderPoper;
    /**
     * 收货地址：
     */
    private TextView mReceivingAddress;
    /**
     * 华联可溯商城
     */
    private TextView mOrderStoreLogo;
    private MyListView mOrderStoreList;
    /**
     * 拨打电话
     */
    private TextView mBodadianhua;
    /**
     * 取消选择
     */
    private TextView mQuxiaoxuanze;
    /**
     * 选择确定
     */
    private TextView mXuanzequeding;
    /**
     * 联系卖家
     */
    private TextView mLianximaijia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //TODO  完成时间
        setContentView(R.layout.activity_order_details);
        initView();
        Intent intent = getIntent();
        if (intent == null) {
            return;
        }
        OrderDataBean.MsgBean.OrderListBean orderListBean = intent.getParcelableExtra("orderBean");
        storeNmae = findViewById(R.id.order_store_logo);
        receiptName = findViewById(R.id.tv_poper_order);
        receiptPhone = findViewById(R.id.tv_poper_phone);
        receiptAdress = findViewById(R.id.tv_receiving_address);
        money = findViewById(R.id.money_tv);
        freight = findViewById(R.id.yunfei_tv);
        orderNumber = findViewById(R.id.order_number_tv);
        playTime = findViewById(R.id.paymoney_time_tv);
        mListView = findViewById(R.id.order_store_list);
        creatTime = findViewById(R.id.establish_time_tv);
        storeNmae.setText(orderListBean.getMember_name());
        receiptName.setText(orderListBean.getBuyer_name());
        receiptPhone.setText(orderListBean.getBuyer_phone());
        receiptAdress.setText(orderListBean.getOrder_addr());
        money.setText("￥" + orderListBean.getOrder_money());
        freight.setText("￥" + orderListBean.getFreight());
        orderNumber.setText(orderListBean.getOrder_number());
        creatTime.setText(orderListBean.getCreate_time());
        playTime.setText(orderListBean.getPay_time());
        myAdapter = new OrderDetailAdapter(this, orderListBean.getShop(), R.layout.item_order_details);
        mListView.setAdapter(myAdapter);


    }

    private void initView() {
        mGoBackImg = (ImageView) findViewById(R.id.go_back_img);
        mGetBackTv = (TextView) findViewById(R.id.get_back_tv);
        mGoBack = (RelativeLayout) findViewById(R.id.go_back);
        mGoBack.setOnClickListener(this);
        mOrderTime = (ImageView) findViewById(R.id.order_time);
        mOrderZhuangtai = (TextView) findViewById(R.id.order_zhuangtai);
        mErjizhuangtai = (TextView) findViewById(R.id.erjizhuangtai);
        mErjizhuangtaiLl = (LinearLayout) findViewById(R.id.erjizhuangtai_ll);
        mOrderAddressImg = (ImageView) findViewById(R.id.order_address_img);
        mOrderPoper = (TextView) findViewById(R.id.order_poper);
        mReceivingAddress = (TextView) findViewById(R.id.receiving_address);
        mOrderStoreLogo = (TextView) findViewById(R.id.order_store_logo);
        mOrderStoreList = (MyListView) findViewById(R.id.order_store_list);
        mBodadianhua = (TextView) findViewById(R.id.bodadianhua);
        mBodadianhua.setOnClickListener(this);
        mQuxiaoxuanze = (TextView) findViewById(R.id.quxiaoxuanze);
        mQuxiaoxuanze.setOnClickListener(this);
        mXuanzequeding = (TextView) findViewById(R.id.xuanzequeding);
        mXuanzequeding.setOnClickListener(this);
        mLianximaijia = (TextView) findViewById(R.id.lianximaijia);
        mLianximaijia.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.go_back:
                finish();
                break;
            case R.id.bodadianhua:
                break;
            case R.id.quxiaoxuanze:
                break;
            case R.id.xuanzequeding:
                break;
            case R.id.lianximaijia:
                break;
        }
    }
}
