package hlks.hualiangou.com.ks_android.activity.main.order;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import hlks.hualiangou.com.ks_android.R;
import hlks.hualiangou.com.ks_android.adapter.OrderDetailAdapter;
import hlks.hualiangou.com.ks_android.bean.OrderDataBean;
import hlks.hualiangou.com.ks_android.view.MyListView;

public class OrderDetailsActivity extends AppCompatActivity {
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //TODO  完成时间
        setContentView(R.layout.activity_order_details);
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
        money.setText("￥"+orderListBean.getOrder_money());
        freight.setText("￥" + orderListBean.getFreight());
        orderNumber.setText(orderListBean.getOrder_number());
        creatTime.setText(orderListBean.getCreate_time());
        playTime.setText(orderListBean.getPay_time());
        myAdapter = new OrderDetailAdapter(this, orderListBean.getShop(), R.layout.item_order_details);
        mListView.setAdapter(myAdapter);



    }
}
