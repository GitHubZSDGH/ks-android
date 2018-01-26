package hlks.hualiangou.com.ks_android.activity.orderdetails;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.alipay.sdk.app.PayTask;
import com.tsy.sdk.myokhttp.response.GsonResponseHandler;
import com.tsy.sdk.myokhttp.response.RawResponseHandler;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import hlks.hualiangou.com.ks_android.App;
import hlks.hualiangou.com.ks_android.R;
import hlks.hualiangou.com.ks_android.base.BaseActivity;
import hlks.hualiangou.com.ks_android.bean.UserAdressBean;
import hlks.hualiangou.com.ks_android.modle.adapter.Shopping.ConFimAdapter;
import hlks.hualiangou.com.ks_android.modle.bean.DetailPagesBean;
import hlks.hualiangou.com.ks_android.modle.bean.PayBean;
import hlks.hualiangou.com.ks_android.modle.bean.ShoppingCartBean;
import hlks.hualiangou.com.ks_android.modle.bean.StoreBean;
import hlks.hualiangou.com.ks_android.modle.url.UrlUtilds;
import hlks.hualiangou.com.ks_android.utils.UserUtils;
import hlks.hualiangou.com.ks_android.view.NestedExpandaleListView;
import hlks.hualiangou.com.ks_android.zhifubao.AuthResult;
import hlks.hualiangou.com.ks_android.zhifubao.PayResult;

import static hlks.hualiangou.com.ks_android.App.baseActivity;
import static hlks.hualiangou.com.ks_android.zhifubao.PayDemoActivity.RSA2_PRIVATE;

/**
 * 确认订单
 */

public class ConfimOrderActivity extends BaseActivity implements View.OnClickListener {
    private RelativeLayout mHaveAdress;
    private LinearLayout mAddAdress;
    private ImageView mConfirmReturn;
    /**
     * 确定订单
     */
    private TextView mShoppingCartTitle;
    private RelativeLayout mTitlebarRel;
    private ImageView mOrderAddressImg;


    /**
     * 收货人：
     */
    private TextView mOrderPoper;
    /**
     * 牛宝宝
     */
    private TextView mTvPoperOrder;
    /**
     * 15933269431
     */
    private TextView mTvPoperPhone;
    /**
     * 收货地址：
     */
    private TextView mReceivingAddress;
    /**
     * 北京市昌平区五合公寓
     */
    private TextView mTvReceivingAddress;
    private RelativeLayout mConfimHaveAdress;
    private NestedExpandaleListView mLvShopGuige;
    /**
     * 配送方式mLvShopGuige
     */
    private TextView mTvOrderDistribution;
    /**
     * 选填，可以告诉卖家您对商品的特殊需求,如颜色、尺寸。
     */
    private EditText mEditText;
    private ScrollView mScrollviewId;
    /**
     * 总金额
     */
    private TextView mTextView2;
    /**
     * asdasdasd
     */
    private TextView mTvOrderMoney;
    /**
     * 提交订单
     */
    private TextView mTvPlaceOrder;
    private RelativeLayout mOrderRelative;

    private String time;
    private boolean isbuy;
    private String allMoney;
    private PopupWindow mPopupWindow;
    private String msg1;
    private TextView yunFeiId;
    private int PAY_FLAG = 0;

    public static final String RSA_PRIVATE = "";

    private static final int SDK_PAY_FLAG = 1;
    private static final int SDK_AUTH_FLAG = 2;
    private List<UserAdressBean.MsgBean.UserAddrBean> user_addr;
    private LinearLayout mAddOrderAddress;


    private ConFimAdapter<ShoppingCartBean.MsgBean> shopAdapter;

    private ConFimAdapter<DetailPagesBean.MsgBean> detailAdapter;

    private List<StoreBean> storeBeanList;
    private Map<StoreBean, List<ShoppingCartBean.MsgBean>> shopBeanList;
    private Map<StoreBean, List<DetailPagesBean.MsgBean>> pageList;
    private ArrayList<DetailPagesBean.MsgBean> msg;
    private ArrayList<ShoppingCartBean.MsgBean> shopMsg;

    @Override
    public int getLayoutId() {
        return R.layout.activity_confirm_order;
    }

    @Override
    public void initView() {
        time = String.valueOf(System.currentTimeMillis());
        storeBeanList = new ArrayList<>();
        shopBeanList = new HashMap<>();
        pageList = new HashMap<>();
        mHaveAdress = (RelativeLayout) findViewById(R.id.confim_have_adress);
        mAddAdress = (LinearLayout) findViewById(R.id.add_order_address);
        yunFeiId = (TextView) findViewById(R.id.yunfei_id);

        mConfirmReturn = (ImageView) findViewById(R.id.confirm_return);
        mShoppingCartTitle = (TextView) findViewById(R.id.shoppingCart_title);
        mTitlebarRel = (RelativeLayout) findViewById(R.id.titlebar_rel);
        mAddOrderAddress = (LinearLayout) findViewById(R.id.add_order_address);
        mOrderAddressImg = (ImageView) findViewById(R.id.order_address_img);
        mOrderPoper = (TextView) findViewById(R.id.order_poper);
        mTvPoperOrder = (TextView) findViewById(R.id.tv_poper_order);
        mTvPoperPhone = (TextView) findViewById(R.id.tv_poper_phone);
        mReceivingAddress = (TextView) findViewById(R.id.receiving_address);
        mTvReceivingAddress = (TextView) findViewById(R.id.tv_receiving_address);
        mConfimHaveAdress = (RelativeLayout) findViewById(R.id.confim_have_adress);
        mLvShopGuige = (NestedExpandaleListView) findViewById(R.id.lv_shop_guige);
        mTvOrderDistribution = (TextView) findViewById(R.id.tv_order_distribution);
        mEditText = (EditText) findViewById(R.id.editText);
        mScrollviewId = (ScrollView) findViewById(R.id.scrollview_id);
        mTextView2 = (TextView) findViewById(R.id.textView2);
        mTvOrderMoney = (TextView) findViewById(R.id.tv_order_money);

        mTvPlaceOrder = (TextView) findViewById(R.id.tv_place_order);
        mOrderRelative = (RelativeLayout) findViewById(R.id.order_relative);
        mConfirmReturn.setOnClickListener(this);
        mShoppingCartTitle.setOnClickListener(this);
        mTitlebarRel.setOnClickListener(this);
        mAddOrderAddress.setOnClickListener(this);
        mOrderAddressImg.setOnClickListener(this);
        mOrderPoper.setOnClickListener(this);
        mTvPoperOrder.setOnClickListener(this);
        mTvPoperPhone.setOnClickListener(this);
        mReceivingAddress.setOnClickListener(this);
        mTvReceivingAddress.setOnClickListener(this);
        mConfimHaveAdress.setOnClickListener(this);
//        mLvShopGuige.setOnClickListener(this);
        mTvOrderDistribution.setOnClickListener(this);
        mEditText.setOnClickListener(this);
        mScrollviewId.setOnClickListener(this);
        mTextView2.setOnClickListener(this);
        mTvOrderMoney.setOnClickListener(this);
        mTvPlaceOrder.setOnClickListener(this);
        mOrderRelative.setOnClickListener(this);

        Intent intent = getIntent();
        if (intent == null) return;
        if (intent.getBundleExtra("bundle") == null) return;
        Bundle bundle = intent.getBundleExtra("bundle");
        isbuy = intent.getBooleanExtra("isbuy", false);

        allMoney = intent.getStringExtra("allMoney");


        if (isbuy) {

            msg = bundle.getParcelableArrayList("details");
            yunFeiId.setText("¥" + msg.get(0).getFreight().toString());
        } else {

            shopMsg = bundle.getParcelableArrayList("det");
            yunFeiId.setText("¥" + shopMsg.get(0).getFreight().toString());
        }


        loadAdress();

        if (isbuy) {
            for (int i = 0; i < 1; i++) {
                StoreBean storeBean = new StoreBean();
                storeBean.setSelect(false);
                storeBean.setStoreName("华联可溯");
                storeBeanList.add(storeBean);
//                            mExpandableListView.expandGroup(i);
                pageList.put(storeBean, msg);
            }
            detailAdapter = new ConFimAdapter<>(storeBeanList, pageList, this);
            mLvShopGuige.setAdapter(detailAdapter);
            for (int i = 0; i < detailAdapter.getGroupCount(); i++) {
                mLvShopGuige.expandGroup(i); //关键步骤4:初始化，将ExpandableListView以展开的方式显示
            }


        } else {
            for (int i = 0; i < 1; i++) {
                StoreBean storeBean = new StoreBean();
                storeBean.setSelect(false);
                storeBean.setStoreName("华联可溯");
                storeBeanList.add(storeBean);
//                            mExpandableListView.expandGroup(i);
                shopBeanList.put(storeBean, shopMsg);
            }
            shopAdapter = new ConFimAdapter<>(storeBeanList, shopBeanList, this);
            mLvShopGuige.setAdapter(shopAdapter);
            for (int i = 0; i < shopAdapter.getGroupCount(); i++) {
                mLvShopGuige.expandGroup(i); //关键步骤4:初始化，将ExpandableListView以展开的方式显示
            }
        }


        mTvOrderMoney.setText("¥" + allMoney);
//        mTvOrderMoney.setText("dsadddddddddddddddddddddddddd");


    }

    @Override
    public void loadData() {
//        initOkHttp();

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        user_addr.clear();
        loadAdress();
    }

    private void loadAdress() {
        App.myOkHttp
                .postParams()
                .url(UrlUtilds.GET_USERADDR)
                .addParam("api", "addr/getUserAddr")
                .addParam("appid", UrlUtilds.APPID)
                .addParam("t", time)
                .addParam("token", UserUtils.getToken())
                .addParam("user_id", UserUtils.getUserId())
                .enqueue(new GsonResponseHandler<UserAdressBean>() {
                    @Override
                    public void onSuccess(int statusCode, UserAdressBean response) {
                        user_addr = response.getMsg().getUser_addr();
                        int length = user_addr.size();
                        for (int i = 0; i < length; i++) {
                            UserAdressBean.MsgBean.UserAddrBean userAddrBean = user_addr.get(i);
                            if ("1".equals(userAddrBean.getIs_default())) {
                                mAddAdress.setVisibility(View.GONE);
                                mHaveAdress.setVisibility(View.VISIBLE);
                                mTvPoperOrder.setText(userAddrBean.getReceiver());
                                mTvPoperPhone.setText(userAddrBean.getReceiver_phone());
                                mTvReceivingAddress.setText(userAddrBean.getArea() + "\t"
                                        + userAddrBean.getCity() + "\t"
                                        + userAddrBean.getDomain());

                                break;
                            } else {
                                mAddAdress.setVisibility(View.VISIBLE);
                                mHaveAdress.setVisibility(View.GONE);
                            }


                        }
                    }

                    @Override
                    public void onFailure(int statusCode, String error_msg) {

                    }

                    @Override
                    public void onSuccfulString(int code, String message) {
                        mAddAdress.setVisibility(View.VISIBLE);
                        mHaveAdress.setVisibility(View.GONE);
                    }
                });

    }

    @Override
    public void setListener() {

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            /**
             * 返回
             */
            case R.id.confirm_return:
                finish();
                break;
            /**
             * 添加默认地址
             */
            case R.id.add_order_address:
                Intent intent = new Intent(ConfimOrderActivity.this, ReceivingAddressActivity.class);
                startActivity(intent);
                break;
            /**
             * 收货人
             */
            case R.id.tv_poper_order:
                break;
            /**
             * 收货人手机号
             */
            case R.id.tv_poper_phone:
                break;
            /**
             * 收货人地址
             */
            case R.id.tv_receiving_address:

                break;
            case R.id.confim_have_adress:
                Intent intentone = new Intent(ConfimOrderActivity.this, ReceivingAddressActivity.class);
                startActivity(intentone);
                break;
            /**
             * 商品列表
             */
            case R.id.lv_shop_guige:
                break;
            /**
             * 配送方式
             */
            case R.id.tv_order_distribution:
                break;
            case R.id.editText:
                break;
            case R.id.scrollview_id:
                break;
            case R.id.textView2:
                break;
            /**
             * 订单价格
             */
            case R.id.tv_order_money:
                break;


            /**
             * 提交订单
             */
            case R.id.tv_place_order:
                StringBuffer sb = new StringBuffer();
                if (isbuy) {
                    for (DetailPagesBean.MsgBean msgBean : msg) {
                        sb.append(msgBean.getId() + ",");
                    }
                    showPopupWindow();

                } else {
                    for (ShoppingCartBean.MsgBean msgBean : shopMsg) {
                        sb.append(msgBean.getCart_id() + ",");
                    }
                    showPopupWindow();
                }
                if (!sb.toString().isEmpty()) {

                    sb.deleteCharAt(sb.length() - 1);
                }
                //order/order
                App.myOkHttp
                        .postParams()
                        .url(UrlUtilds.ORDER)
                        .addParam("api", "order/order")
                        .addParam("appid", UrlUtilds.APPID)
                        .addParam("t", time)
                        .addParam("token", UserUtils.getToken())
                        .addParam("user_id", UserUtils.getUserId())
                        .addParam("cart_id", sb.toString())
                        .addParam("order_addr", mTvReceivingAddress.getText().toString().trim())
                        .addParam("buyer_name", mTvPoperOrder.getText().toString().trim())
                        .addParam("user_iphone", mTvPoperPhone.getText().toString().trim())
                        .addParam("order_money", allMoney)
                        .addParam("buyer_message", mEditText.getText().toString().trim())
                        .enqueue(new RawResponseHandler() {
                            @Override
                            public void onSuccess(int statusCode, String response) {
                                Log.e("TAG", "onsuccful==\n" + response);
                                try {
                                    JSONObject result = new JSONObject(response);
                                    //获取到订单号
                                    msg1 = result.optString("msg");
                                    Log.e("sssss",msg1);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }

                            @Override
                            public void onFailure(int statusCode, String error_msg) {

                            }

                        });

                break;
            case R.id.pay_popup_delete:
                mPopupWindow.dismiss();
                break;
//            微信支付
            case R.id.weixin_pay:
                myDialogJieSuan();
                mPopupWindow.dismiss();
                break;
            case R.id.alipay_pay:
                //这段代码不能动，会有全局bug 稍后修改
                initPayOkHttp();
//                myDialogJieSuan();
                mPopupWindow.dismiss();
                break;
//            银联支付
            case R.id.yinlian_pay:
                myDialogJieSuan();
                mPopupWindow.dismiss();
                break;
            case R.id.shoppingCart_title:
                break;
            case R.id.titlebar_rel:
                break;
            case R.id.order_address_img:
                break;
            case R.id.order_poper:
                break;
            case R.id.receiving_address:
                break;
            case R.id.order_relative:
                break;
        }
    }

    private void initPayOkHttp() {


        App.myOkHttp
                .postParams()
                .url(UrlUtilds.PAY_ORDER)
                .addParam("api", "pay/payOrder")
                .addParam("appid", UrlUtilds.APPID)
                .addParam("t", String.valueOf(System.currentTimeMillis()))
                .addParam("token", UserUtils.getToken())
                .addParam("order_number", msg1)
                .addParam("pay_type", "1")
                .enqueue(new GsonResponseHandler<PayBean>() {
                    @Override
                    public void onSuccess(int statusCode, PayBean response) {
                        Log.d("ConfimOrderActivity", "成功了");
                        if (response.getRet().equals("0")) {

                            String Alipaymsg = response.getMsg();

                            aliPay(Alipaymsg);

                        }

                    }

                    @Override
                    public void onFailure(int statusCode, String error_msg) {
                        Log.d("ConfimOrderActivity", "失败==" + error_msg + "\n" + statusCode);
                    }
                });
    }

    private void showPopupWindow() {
        backgroundAlpha(0.4f);

        View contentView = LayoutInflater.from(this).inflate(R.layout.popup_payment, null);
        mPopupWindow = new PopupWindow(contentView,
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, true);
        TextView paymentMoney = contentView.findViewById(R.id.payment_money);
        ImageView payDelete = contentView.findViewById(R.id.pay_popup_delete);
        RelativeLayout weiXinPay = contentView.findViewById(R.id.weixin_pay);
        RelativeLayout zhiFuBaoPay = contentView.findViewById(R.id.alipay_pay);
        RelativeLayout yinLianPay = contentView.findViewById(R.id.yinlian_pay);
        paymentMoney.setText(mTvOrderMoney.getText());
        payDelete.setOnClickListener(this);
        weiXinPay.setOnClickListener(this);
        zhiFuBaoPay.setOnClickListener(this);
        yinLianPay.setOnClickListener(this);
        mPopupWindow.setOutsideTouchable(true);
        mPopupWindow.setFocusable(true);
        mPopupWindow.setAnimationStyle(R.style.anim_menu_bottombar);
        View rootView = LayoutInflater.from(baseActivity).inflate(R.layout.activity_confirm_order, null);
        mPopupWindow.showAtLocation(rootView, Gravity.BOTTOM, 0, 0);
        mPopupWindow.setOnDismissListener(new PoponDismissListener());
    }


    // TODO: 2017/9/15 这是设置 背景为半透明
    public void backgroundAlpha(float bgAlpha) {
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.alpha = bgAlpha; //0.0-1.0
        getWindow().setAttributes(lp);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO:OnCreate Method has been created, run FindViewById again to generate code
        setContentView(R.layout.activity_confirm_order);
        initView();
    }

    class PoponDismissListener implements PopupWindow.OnDismissListener {

        @Override
        public void onDismiss() {
            // TODO Auto-generated method stub
            //Log.v("List_noteTypeActivity:", "我是关闭事件");
            backgroundAlpha(1.0f);
        }
    }

    /**
     * 支付宝业务
     */
    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {
        @SuppressWarnings("unused")
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case SDK_PAY_FLAG: {
                    @SuppressWarnings("unchecked")
                    PayResult payResult = new PayResult((Map<String, String>) msg.obj);
                    /**
                     对于支付结果，请商户依赖服务端的异步通知结果。同步通知结果，仅作为支付结束的通知。
                     */
                    String resultInfo = payResult.getResult();// 同步返回需要验证的信息
                    String resultStatus = payResult.getResultStatus();

                    Log.d("WebViewActivity", "支付的回调" + resultStatus);
                    // 判断resultStatus 为9000则代表支付成功
                    if (TextUtils.equals(resultStatus, "9000")) {
                        // 该笔订单是否真实支付成功，需要依赖服务端的异步通知。
                        Toast.makeText(ConfimOrderActivity.this, "支付成功", Toast.LENGTH_SHORT).show();


                    } else {
                        // 该笔订单真实的支付结果，需要依赖服务端的异步通知。
                        Toast.makeText(ConfimOrderActivity.this, "支付失败", Toast.LENGTH_SHORT).show();
                    }
                    break;
                }
                case SDK_AUTH_FLAG: {
                    @SuppressWarnings("unchecked")
                    AuthResult authResult = new AuthResult((Map<String, String>) msg.obj, true);
                    String resultStatus = authResult.getResultStatus();
                    Log.d("PayDemoActivity", resultStatus);
                    // 判断resultStatus 为“9000”且result_code
                    // 为“200”则代表授权成功，具体状态码代表含义可参考授权接口文档
                    if (TextUtils.equals(resultStatus, "9000") && TextUtils.equals(authResult.getResultCode(), "200")) {
                        // 获取alipay_open_id，调支付时作为参数extern_token 的value
                        // 传入，则支付账户为该授权账户
                        Toast.makeText(ConfimOrderActivity.this,
                                "授权成功\n" + String.format("authCode:%s", authResult.getAuthCode()), Toast.LENGTH_SHORT)
                                .show();
                    } else {
                        // 其他状态值则为授权失败
                        Toast.makeText(ConfimOrderActivity.this,
                                "授权失败" + String.format("authCode:%s", authResult.getAuthCode()), Toast.LENGTH_SHORT).show();

                    }
                    break;
                }
                default:
                    break;
            }
        }


    };

    /**
     * 进行支付
     */

    private void aliPay(final String ordString) {
        if (TextUtils.isEmpty(UrlUtilds.APPID) || (TextUtils.isEmpty(RSA2_PRIVATE) && TextUtils.isEmpty(RSA_PRIVATE))) {
            new AlertDialog.Builder(this).setTitle("警告").setMessage("需要配置APPID | RSA_PRIVATE")
                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialoginterface, int i) {
                            //
                            finish();
                        }
                    }).show();
            return;
        }
        Runnable payRunnable = new Runnable() {

            @Override
            public void run() {
                PayTask alipay = new PayTask(ConfimOrderActivity.this);
                Map<String, String> result = alipay.payV2(ordString, true);
                Log.i("msp", result.toString());

                Message msg = new Message();
                msg.what = SDK_PAY_FLAG;
                msg.obj = result;
                mHandler.sendMessage(msg);
            }
        };

        Thread payThread = new Thread(payRunnable);
        payThread.start();

    }

    private void myDialogJieSuan() {
        AlertDialog.Builder builder = new AlertDialog.Builder(baseActivity, R.style.MyCommonDialog);
        builder.setView(R.layout.login_dialog_custom1);
        final AlertDialog dialoga = builder.create();
        dialoga.setCanceledOnTouchOutside(false);
        dialoga.show();
        TextView textView1 = (TextView) dialoga.findViewById(R.id.home_dialog);
        TextView textView = (TextView) dialoga.findViewById(R.id.dialog_text);
        textView.setText("此功能暂未开放");
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialoga.dismiss();
            }
        });
    }
}