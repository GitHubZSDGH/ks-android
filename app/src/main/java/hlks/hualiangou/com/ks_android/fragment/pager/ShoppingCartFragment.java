package hlks.hualiangou.com.ks_android.fragment.pager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.tsy.sdk.myokhttp.response.GsonResponseHandler;
import com.tsy.sdk.myokhttp.util.ParamsUtils;
import com.tsy.sdk.myokhttp.util.ToastUtils;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import hlks.hualiangou.com.ks_android.App;
import hlks.hualiangou.com.ks_android.R;
import hlks.hualiangou.com.ks_android.activity.LoginActivity;
import hlks.hualiangou.com.ks_android.activity.orderdetails.ConfimOrderActivity;
import hlks.hualiangou.com.ks_android.base.BaseFragment;
import hlks.hualiangou.com.ks_android.bean.UpdateShopping;
import hlks.hualiangou.com.ks_android.bean.UploadShopping;
import hlks.hualiangou.com.ks_android.config.FragmentBuilder;
import hlks.hualiangou.com.ks_android.listener.MainListener;
import hlks.hualiangou.com.ks_android.modle.adapter.Shopping.ShoppingStateListener;
import hlks.hualiangou.com.ks_android.modle.adapter.Shopping.ShppingCartAdapter;
import hlks.hualiangou.com.ks_android.modle.bean.ShoppingCartBean;
import hlks.hualiangou.com.ks_android.modle.bean.StoreBean;
import hlks.hualiangou.com.ks_android.modle.url.UrlUtilds;
import hlks.hualiangou.com.ks_android.utils.ShoppingUtils;
import hlks.hualiangou.com.ks_android.utils.UserUtils;

/**
 * 项目名称:
 * 类描述:
 * 创建人:lenovo
 * 创建时间:2017/11/10
 * 修改人:
 * 修改内容:
 */
public class ShoppingCartFragment extends BaseFragment implements View.OnClickListener, ShppingCartAdapter.StateListener {
    /**
     * 标题
     */
    private TextView mTitle;
    /**
     * 编辑
     */
    private TextView mEdit;
    /**
     * 全选按钮
     */
    private CheckBox mAllSlect;

    /**
     * 结算总额
     */
    private TextView mMoney;

    /**
     * 结算按钮
     */
    private TextView mSettlement;

    /**
     * 商品列表
     */
    private ExpandableListView mExpandableListView;
    /**
     * 当前时间戳
     */
    private String time;

    /**
     * 适配器
     */
    private ShppingCartAdapter myAdapter;

    /**
     * 当前结算的总额
     */
    private double allMoney;

    /**
     * 商品的总数
     */
    private int shopCount;

    private UploadShopping uploadShopping;
    private List<UploadShopping.ShopingBean> listShop;
    private List<StoreBean> storeBeanList;
    private Map<StoreBean, List<ShoppingCartBean.MsgBean>> shopBeanList;
    private RelativeLayout empRealayout;
    private RelativeLayout mBottonRelayout;
    private TextView shopping;
    private MainListener mainCLicter;
    private ArrayList<ShoppingCartBean.MsgBean> buyShopList;
    private ShoppingStateListener shoppingStateListener;
    private LinearLayout shopingHeJi;
    private ImageView returnone;
    List<UpdateShopping> updateList;

    private boolean isRefrush;

    public void setMainCLicter(MainListener mainCLicter) {
        this.mainCLicter = mainCLicter;
    }

    @Override
    public int getLayoutId() {
        return R.layout.shoppingcart_fragment;
    }

    @Override
    public void initView(View view) {
        updateList = new ArrayList<>();
        shopingHeJi = view.findViewById(R.id.shopingcar_ll_heji);
        uploadShopping = new UploadShopping();
        listShop = new ArrayList<>();
        buyShopList = new ArrayList<>();
        mTitle = view.findViewById(R.id.shoppingCart_title);
        mAllSlect = view.findViewById(R.id.shopping_all_check);
        mMoney = view.findViewById(R.id.shopping_monery);
        mExpandableListView = view.findViewById(R.id.shopping_expandListView);
        mSettlement = view.findViewById(R.id.shopping_settlement);
        empRealayout = view.findViewById(R.id.shopping_isemp);
        mBottonRelayout = view.findViewById(R.id.shopping_bottom_rel);
        returnone = view.findViewById(R.id.return_one);
        returnone.setVisibility(View.INVISIBLE);
        mEdit = view.findViewById(R.id.shopping_edit);
        mEdit.setOnClickListener(this);
        shopping = view.findViewById(R.id.start_buy_shop);
        shopping.setOnClickListener(this);
        mSettlement.setOnClickListener(this);
        mExpandableListView.setGroupIndicator(null);
        Date dt = new Date();
        time = String.valueOf(dt.getTime());
    }

    @Override
    public void loadData() {
        loadShopping();
        Log.d("ShoppingCartFragment", "user==" + UserUtils.getToken());
    }

    private void loadShopping() {


        if (UserUtils.getToken().isEmpty()) {
//            startActivity(new Intent(baseActivity, LoginActivity.class));
            myDialogText();
            return;
        }
        loadShop();


    }

    @Override
    public void onShow() {
        super.onShow();
        loadShop();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (isRefrush) {
            isRefrush = false;
            loadShop();
        }


    }

    private void loadShop() {
        String build = ParamsUtils.getInstance()
                .params("api", "Cart/getCartList")
                .params("appid", UrlUtilds.APPID)
                .params("t", time)
                .params("user_id", UserUtils.getUserId())
                .params("token", UserUtils.getToken())
                .build();

        App.myOkHttp.post()
                .url(UrlUtilds.GET_SHOPPING_CART)
                .tag(this)
                .addParam("s", build)
                .addParam("token", UserUtils.getToken())
                .addParam("api", "Cart/getCartList")
                .addParam("appid", UrlUtilds.APPID)
                .addParam("t", time)
                .addParam("user_id", UserUtils.getUserId())
                .enqueue(new GsonResponseHandler<ShoppingCartBean>() {

                    @Override
                    public void onSuccess(int statusCode, ShoppingCartBean response) {
                        Log.e("ShoppingCartFragment", response.getMsg().toString().trim());
                        final List<ShoppingCartBean.MsgBean> msg = response.getMsg();
                        empRealayout.setVisibility(View.GONE);
                        mBottonRelayout.setVisibility(View.VISIBLE);
                        storeBeanList = new ArrayList<>();
                        shopBeanList = new HashMap<>();
                        for (int i = 0; i < 1; i++) {
                            StoreBean storeBean = new StoreBean();
                            storeBean.setSelect(false);
                            storeBean.setStoreName("华联可溯");
                            storeBeanList.add(storeBean);
//                            mExpandableListView.expandGroup(i);
                            shopBeanList.put(storeBean, msg);
                        }
                        myAdapter = new ShppingCartAdapter(storeBeanList, shopBeanList, getContext());
                        myAdapter.setStateListener(ShoppingCartFragment.this);
                        shoppingStateListener = myAdapter.getShoppingStateListener();
                        mExpandableListView.setAdapter(myAdapter);
                        for (int i = 0; i < myAdapter.getGroupCount(); i++) {
                            mExpandableListView.expandGroup(i); //关键步骤4:初始化，将ExpandableListView以展开的方式显示
                        }
//                        myAdapter.notifyDataSetChanged();


                    }

                    @Override
                    public void onFailure(int statusCode, String error_msg) {

                    }

                    @Override
                    public void onSuccfulString(int code, String message) {
                        empRealayout.setVisibility(View.VISIBLE);
                        mBottonRelayout.setVisibility(View.GONE);
                        if (message.equals("用户登录登录失败")) {
                            myDialogText();
                        }
                    }
                });
    }

    private void myDialogText() {
        AlertDialog.Builder builder = new AlertDialog.Builder(baseActivity, R.style.MyCommonDialog);
        builder.setView(R.layout.shop_dialog_custom);
        final AlertDialog dialog = builder.create();
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
        TextView textView = (TextView) dialog.findViewById(R.id.home_dialog_determine);
        TextView textView1 = (TextView) dialog.findViewById(R.id.home_dialog);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(baseActivity, LoginActivity.class));
                dialog.dismiss();
            }
        });
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentBuilder.getInstance(baseActivity)
                        .start(ClassIfyFragment.class)
                        .add(R.id.main_home)
                        .commit();
                dialog.dismiss();
            }
        });
    }

    private void myDialogDelete() {
        AlertDialog.Builder builder = new AlertDialog.Builder(baseActivity, R.style.MyCommonDialog);
        builder.setView(R.layout.shop_cart_delete);
        final AlertDialog dialog = builder.create();
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
        TextView textView = (TextView) dialog.findViewById(R.id.cart_delete_no);
        TextView textView1 = (TextView) dialog.findViewById(R.id.cart_delete_yes);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dialog.dismiss();
            }
        });
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ShoppingUtils.deleteShop(buyShopList)) {
                    loadShop();

                }
                dialog.dismiss();
            }
        });
    }

    @Override
    public void setListener() {
        mAllSlect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!mAllSlect.isChecked()) {
                    for (StoreBean storeBean : storeBeanList) {
                        storeBean.setSelect(false);
                        final List<ShoppingCartBean.MsgBean> msgBeans = shopBeanList.get(storeBean);
                        for (ShoppingCartBean.MsgBean msgBean : msgBeans) {
                            msgBean.setIscheck(false);
                            shopCount += 1;
                        }
                    }
                    shopCount = 0;
                } else {
                    /**
                     * 如果为true
                     * 证明列表包含有积分商品 不可以一键选择
                     */
                    if (myAdapter.isJifen()) {
                        ToastUtils.showSingleToast("购物车有积分商品，请单独购买");
                        mAllSlect.setChecked(false);
                        return;
                    }
                    shopCount = 0;
                    for (StoreBean storeBean : storeBeanList) {
                        storeBean.setSelect(true);
                        final List<ShoppingCartBean.MsgBean> msgBeans = shopBeanList.get(storeBean);
                        for (ShoppingCartBean.MsgBean msgBean : msgBeans) {
                            msgBean.setIscheck(true);
                            shopCount += 1;
                        }
                    }
                }
                calculationMoney();
                myAdapter.notifyDataSetChanged();
                mTitle.setText("购物车（" + shopCount + "）");
                if (!mSettlement.getText().equals("删除")) {
                    mSettlement.setText("结算（" + shopCount + "）");
                }

            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            /**
             * 编辑
             */
            case R.id.shopping_edit:
                switch (mEdit.getText().toString().trim()) {
                    case "编辑":
                        mEdit.setText("完成");
                        shopingHeJi.setVisibility(View.GONE);
                        mAllSlect.setVisibility(View.GONE);
                        mSettlement.setText("删除");
                        shoppingStateListener.bianji(true);
                        break;
                    case "完成":
                        mEdit.setText("编辑");
                        shopingHeJi.setVisibility(View.VISIBLE);
                        mAllSlect.setVisibility(View.VISIBLE);
                        mSettlement.setText("结算");
                        shoppingStateListener.bianji(false);
//                        if (ShoppingUtils.update(buyShopList)) {
//                           loadShop();
//                }
                        break;
                }

                break;
            /**
             * 结算
             */
            case R.id.shopping_settlement:

                String content = mSettlement.getText().toString();
                Set<StoreBean> storeBeen = shopBeanList.keySet();
                for (StoreBean storeBean : storeBeen) {
                    List<ShoppingCartBean.MsgBean> msgBeen = shopBeanList.get(storeBean);
                    int length = msgBeen.size();
                    for (int i = 0; i < length; i++) {
                        ShoppingCartBean.MsgBean msgBean = msgBeen.get(i);
                        if (msgBean.ischeck()) {
                            buyShopList.add(msgBean);
                            continue;
                        }

                    }
                }
                if (content.startsWith("结算")) {
                    isRefrush = true;
                    if (shopCount <= 0) {
                        myDialogJieSuan();
                        return;
                    }

                    Intent intent = new Intent(baseActivity, ConfimOrderActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putParcelableArrayList("det", buyShopList);
                    intent.putExtra("bundle", bundle);
                    intent.putExtra("isbuy", false);
                    intent.putExtra("allMoney", mMoney.getText().toString());

                    startActivity(intent);
                    buyShopList.clear();
                } else {

                    myDialogDelete();
                }

                break;

            case R.id.start_buy_shop:
                FragmentBuilder.getInstance(App.baseActivity)
                        .start(ClassIfyFragment.class)
                        .add(R.id.main_home)
                        .commit();
//                mainCLicter.onCheckdListener();
                break;
            default:


        }
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
        textView1.setText("您还没有选择商品");
        textView.setText("去选择");
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
    }

    @Override
    public void onCheckEd(int groupPosttion, int childPosition, boolean ischecked) {
        calculationMoney();
        final StoreBean storeBean = storeBeanList.get(groupPosttion);
        final List<ShoppingCartBean.MsgBean> msgBeans = shopBeanList.get(storeBean);
        ShoppingCartBean.MsgBean msgBean1 = msgBeans.get(childPosition);
        if (ischecked) {
            UploadShopping.ShopingBean bean = new UploadShopping.ShopingBean();
            bean.setCart_id(msgBean1.getCart_id());
            bean.setStaff("0");
            listShop.add(bean);
            Gson gson = new Gson();
            String s = gson.toJson(uploadShopping);
            shopCount += 1;
        } else {
            //这段代码不能动，动了会出现很多bug，不动的话只有个小bug，你自己看着办
//            listShop.remove()
            shopCount -= 1;
        }
        boolean allState = false;
        for (ShoppingCartBean.MsgBean msgBean : msgBeans) {
            if (msgBean.ischeck() != ischecked) {
                allState = true;
                break;
            }
        }

        if (!allState) {
            storeBean.setSelect(ischecked);
        } else {
            storeBean.setSelect(false);
        }
        allState();
        mTitle.setText("购物车（" + shopCount + "）");
        if (!mSettlement.getText().equals("删除")) {
            mSettlement.setText("结算（" + shopCount + "）");
        }
        myAdapter.notifyDataSetChanged();
    }


    private void allState() {
        boolean isall = true;
        for (StoreBean storeBean : storeBeanList) {
            if (!storeBean.isSelect()) {
                isall = false;
                break;
            }

        }
        mAllSlect.setChecked(isall);
    }

    @Override
    public void onCountState(String money, int count, boolean isAdd) {
        calculationMoney();
    }

    private void calculationMoney() {
        allMoney = 0;
        for (StoreBean storeBean : storeBeanList) {
            final List<ShoppingCartBean.MsgBean> msgBeans = shopBeanList.get(storeBean);
            for (ShoppingCartBean.MsgBean msgBean : msgBeans) {
                if (msgBean.ischeck()) {
//                    allMoney += Integer.parseInt(msgBean.getShop_end_money()) * Integer.parseInt(msgBean.getShop_num());
                    allMoney += Double.parseDouble(msgBean.getShop_end_money()) * Double.parseDouble(msgBean.getShop_num());
                }

            }
        }
        mMoney.setText(String.valueOf(new DecimalFormat("#0.00").format(allMoney)));
    }

    @Override
    public void storeCheckEd(int groupPosition, boolean isChecked) {
        final int size = shopBeanList.get(storeBeanList.get(groupPosition)).size();
        if (!isChecked) {
            shopCount -= size;
        } else {
            shopCount = 0;
            shopCount += size;
        }
        mTitle.setText("购物车（" + shopCount + "）");
        if (!mSettlement.getText().equals("删除")) {
            mSettlement.setText("结算（" + shopCount + "）");
        }

        final StoreBean storeBean = storeBeanList.get(groupPosition);
        storeBean.setSelect(isChecked);
        final List<ShoppingCartBean.MsgBean> msgBeans = shopBeanList.get(storeBean);
        for (ShoppingCartBean.MsgBean msgBean : msgBeans) {
            msgBean.setIscheck(isChecked);
        }
        myAdapter.notifyDataSetChanged();
        calculationMoney();
        allState();
    }

    //购物车 删除功能
    @Override
    public void delete(int groupPosition) {
        final StoreBean storeBean = storeBeanList.get(groupPosition);
        if (storeBean.isSelect()) {
            shopCount -= shopBeanList.get(storeBean).size();
        } else {
            List<ShoppingCartBean.MsgBean> msgBeen = shopBeanList.get(storeBean);
            for (int i = 0; i < msgBeen.size(); i++) {
                msgBeen.get(i).ischeck();
                shopCount -= i;
            }
        }
        mTitle.setText("购物车（" + shopCount + "）");
        if (!mSettlement.getText().equals("删除")) {
            mSettlement.setText("结算（" + shopCount + "）");
        }
        shopBeanList.remove(storeBean);
        storeBeanList.remove(storeBean);
        calculationMoney();
        myAdapter.notifyDataSetChanged();
    }

}
