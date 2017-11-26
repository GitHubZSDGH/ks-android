package hlks.hualiangou.com.ks_android.fragment.pager;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.tsy.sdk.myokhttp.response.GsonResponseHandler;
import com.tsy.sdk.myokhttp.util.ParamsUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import hlks.hualiangou.com.ks_android.App;
import hlks.hualiangou.com.ks_android.R;
import hlks.hualiangou.com.ks_android.activity.LoginActivity;
import hlks.hualiangou.com.ks_android.base.BaseFragment;
import hlks.hualiangou.com.ks_android.config.FragmentBuilder;
import hlks.hualiangou.com.ks_android.listener.MainListener;
import hlks.hualiangou.com.ks_android.modle.adapter.Shopping.ShppingCartAdapter;
import hlks.hualiangou.com.ks_android.modle.bean.ShoppingCartBean;
import hlks.hualiangou.com.ks_android.modle.bean.StoreBean;
import hlks.hualiangou.com.ks_android.modle.url.UrlUtilds;
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
    private int allMoney;

    /**
     * 商品的总数
     */
    private int shopCount;
    private List<StoreBean> storeBeanList;
    private Map<StoreBean, List<ShoppingCartBean.MsgBean>> shopBeanList;
    private RelativeLayout empRealayout;
    private RelativeLayout mBottonRelayout;
    private TextView shopping;
    private MainListener mainCLicter;

    public void setMainCLicter(MainListener mainCLicter) {
        this.mainCLicter = mainCLicter;
    }

    @Override
    public int getLayoutId() {
        return R.layout.shoppingcart_fragment;
    }

    @Override
    public void initView(View view) {
        mTitle = view.findViewById(R.id.shoppingCart_title);
        mAllSlect = view.findViewById(R.id.shopping_all_check);
        mMoney = view.findViewById(R.id.shopping_monery);
        mExpandableListView = view.findViewById(R.id.shopping_expandListView);
        mSettlement = view.findViewById(R.id.shopping_settlement);
        empRealayout = view.findViewById(R.id.shopping_isemp);
        mBottonRelayout = view.findViewById(R.id.shopping_bottom_rel);
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
        Log.d("ShoppingCartFragment", "user=="+ UserUtils.getToken());
    }

    private void loadShopping() {


        if(UserUtils.getToken().isEmpty()){
            startActivity( new Intent(baseActivity, LoginActivity.class));
            return;
        }
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
                        final List<ShoppingCartBean.MsgBean> msg = response.getMsg();
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
                            shopCount+=1;
                        }
                    }
                    shopCount = 0;
                } else {
                    shopCount = 0;
                    for (StoreBean storeBean : storeBeanList) {
                        storeBean.setSelect(true);
                        final List<ShoppingCartBean.MsgBean> msgBeans = shopBeanList.get(storeBean);
                        for (ShoppingCartBean.MsgBean msgBean : msgBeans) {
                            msgBean.setIscheck(true);
                          shopCount+=1;
                        }
                    }
                }
                calculationMoney();
                myAdapter.notifyDataSetChanged();
                mTitle.setText("购物车（"+shopCount+"）");
                mSettlement.setText("购物车（"+shopCount+"）");

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
                break;
            /**
             * 结算
             */
            case R.id.shopping_settlement:
                break;

            case R.id.start_buy_shop:
                FragmentBuilder.getInstance(App.baseActivity)
                        .start(ClassIfyFragment.class)
                        .add(R.id.main_home)
                        .commit();
                mainCLicter.onCheckdListener();
                break;
            default:


        }
    }

    @Override
    public void onCheckEd(int groupPosttion, int childPosition, boolean ischecked) {
        calculationMoney();
        final StoreBean storeBean = storeBeanList.get(groupPosttion);
        final List<ShoppingCartBean.MsgBean> msgBeans = shopBeanList.get(storeBean);
        if (ischecked) {
            shopCount += 1;
        } else {
            shopCount -= 1;
        }
        boolean allState = false;
        for (ShoppingCartBean.MsgBean msgBean : msgBeans) {
            if (msgBean.isIscheck() != ischecked) {
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
        mSettlement.setText("购物车（" + shopCount + "）");
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
                if (msgBean.isIscheck()) {
                    allMoney += Integer.parseInt(msgBean.getShop_money()) * Integer.parseInt(msgBean.getShop_num());
                }

            }
        }
        mMoney.setText(String.valueOf(allMoney));
    }

    @Override
    public void storeCheckEd(int groupPosition, boolean isChecked) {
        final int size = shopBeanList.get(storeBeanList.get(groupPosition)).size();
        if (isChecked) {
            shopCount -= size;
        } else {
            shopCount += size;
        }
        mTitle.setText("购物车（" + shopCount + "）");
        mSettlement.setText("购物车（" + shopCount + "）");
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

    @Override
    public void delete(int groupPosition) {
        final StoreBean storeBean = storeBeanList.get(groupPosition);
        shopCount -= shopBeanList.get(storeBean).size();
        mTitle.setText("购物车（" + shopCount + "）");
        mSettlement.setText("购物车（" + shopCount + "）");
        shopBeanList.remove(storeBean);
        storeBeanList.remove(storeBean);
        calculationMoney();
        myAdapter.notifyDataSetChanged();
    }
}
