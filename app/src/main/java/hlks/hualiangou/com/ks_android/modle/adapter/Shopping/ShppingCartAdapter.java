package hlks.hualiangou.com.ks_android.modle.adapter.Shopping;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tsy.sdk.myokhttp.util.ToastUtils;

import java.util.List;
import java.util.Map;
import java.util.Set;

import hlks.hualiangou.com.ks_android.R;
import hlks.hualiangou.com.ks_android.modle.bean.ShoppingCartBean;
import hlks.hualiangou.com.ks_android.modle.bean.StoreBean;
import hlks.hualiangou.com.ks_android.modle.url.UrlUtilds;
import hlks.hualiangou.com.ks_android.utils.ShoppingUtils;

import static hlks.hualiangou.com.ks_android.App.baseActivity;

/**
 * Created by localadmin on 2017/11/19.
 */

public class ShppingCartAdapter extends BaseExpandableListAdapter implements ShoppingStateListener {
    /**
     * 店铺集合
     */
    private List<StoreBean> storeList;

    /**
     * 商品集合
     */
    private Map<StoreBean, List<ShoppingCartBean.MsgBean>> shopList;


    /**
     * 只要一个商品有积分  就是true
     */
    private boolean isJifen;

    public boolean isJifen() {
        return isJifen;
    }

    /**
     * 已经选择的的数量包含积分的
     */
    private int count;

    private ShopState selectJifen = ShopState.CLICKDEFAULT;
    /**
     * 上下文对象
     */
    private Context mContext;

    private ShoppingStateListener shoppingStateListener;

    public ShoppingStateListener getShoppingStateListener() {
        return shoppingStateListener;
    }

    public ShppingCartAdapter(List<StoreBean> storeList, Map<StoreBean, List<ShoppingCartBean.MsgBean>> shopList, Context mContext) {
        this.storeList = storeList;
        this.shopList = shopList;
        shoppingStateListener = this;
        this.mContext = mContext;
        count = 0;
    }

    private StateListener stateListener;

    public void setStateListener(StateListener stateListener) {
        this.stateListener = stateListener;
    }

    @Override
    public int getGroupCount() {
//        Log.e("ADAPTER", "view个数" + storeList.size());
        if (storeList == null) {
            return 0;
        }

        return storeList.size();
    }

    @Override
    public int getChildrenCount(int position) {
//        Log.e("ADAPTER", "子view个数" + shopList.get(storeList.get(position)).size());
        return shopList.get(storeList.get(position)).size();
    }

    @Override
    public Object getGroup(int i) {
        return null;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
//        return shopList.get(storeList.get(groupPosition)).get(childPosition);
        return null;
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(final int groupPostion, boolean b, View view, ViewGroup viewGroup) {
        StoreViewHolder storeViewHolder = null;
        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.item_business, null);
            storeViewHolder = new StoreViewHolder();
            storeViewHolder.storeDelete = view.findViewById(R.id.item_delete);
            storeViewHolder.storeTitle = view.findViewById(R.id.item_title);
            storeViewHolder.storeSelect = view.findViewById(R.id.item_checkBox);

            view.setTag(storeViewHolder);

        } else {
            storeViewHolder = (StoreViewHolder) view.getTag();
        }
        final StoreBean storeBean = storeList.get(groupPostion);
        storeViewHolder.storeSelect.setChecked(storeBean.isSelect());
        storeViewHolder.storeTitle.setText(storeBean.getStoreName());
        final StoreViewHolder finalStoreViewHolder = storeViewHolder;
        storeViewHolder.storeDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stateListener.delete(groupPostion);
            }
        });
        storeViewHolder.storeSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!finalStoreViewHolder.storeSelect.isChecked()) {
                    finalStoreViewHolder.storeSelect.setChecked(false);
                    stateListener.storeCheckEd(groupPostion, false);
                } else {
                    finalStoreViewHolder.storeSelect.setChecked(true);
                    stateListener.storeCheckEd(groupPostion, true);

                }
            }
        });
        return view;
    }

    @Override
    public View getChildView(final int groupPosition, final int childPosition, boolean b, View view, ViewGroup viewGroup) {
        final ShoppingCartBean.MsgBean shopBean = shopList.get(storeList.get(groupPosition)).get(childPosition);
        ShopViewHolder shopViewHolder = null;
        if (!isJifen) {
            isJifen = shopBean.getIs_integral() == 1 ? true : false;
        }
        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.item_shop, null);
            shopViewHolder = new ShopViewHolder();
            shopViewHolder.shopCount = view.findViewById(R.id.item_count);
            shopViewHolder.shopCountAdd = view.findViewById(R.id.item_add_count);
            shopViewHolder.shopCountRemove = view.findViewById(R.id.item_remove_count);
            shopViewHolder.shopImage = view.findViewById(R.id.item_shop_img);
            shopViewHolder.shopCountNum = view.findViewById(R.id.item_count_num);
            shopViewHolder.shopTitle = view.findViewById(R.id.item_shop_name);
            //规格
            shopViewHolder.shopSmallTitle = view.findViewById(R.id.item_shop_name_name);
            shopViewHolder.shopMoney = view.findViewById(R.id.item_money);
            shopViewHolder.shopSelect = view.findViewById(R.id.item_checkBox);
            shopViewHolder.itemShaoYes = view.findViewById(R.id.item_shop_yes);
            shopViewHolder.itemShaoNo = view.findViewById(R.id.item_shop_no);
            shopViewHolder.shopGuige = view.findViewById(R.id.item_shop_guige);
            shopViewHolder.shopGuigeSelect = view.findViewById(R.id.item_shop_iv);
            shopViewHolder.jifen = view.findViewById(R.id.jifen_back);
            view.setTag(shopViewHolder);

        } else {
            shopViewHolder = (ShopViewHolder) view.getTag();
        }
        if (shopBean.isBianji()) {
            shopViewHolder.itemShaoNo.setVisibility(View.VISIBLE);
            shopViewHolder.itemShaoYes.setVisibility(View.GONE);
        } else {
            shopViewHolder.itemShaoNo.setVisibility(View.GONE);
            shopViewHolder.itemShaoYes.setVisibility(View.VISIBLE);
        }
//        Glide.with(mContext).load(UrlUtilds.IMG_URL + shopBean.getImage_path()).into(shopViewHolder.shopImage);
        shopViewHolder.shopTitle.setText(shopBean.getShop_name());
        shopViewHolder.shopMoney.setText("￥" + shopBean.getShop_end_money());
        shopViewHolder.shopCountNum.setText(shopBean.getShop_num());
        shopViewHolder.shopCount.setText(shopBean.getShop_num());
        shopViewHolder.shopSmallTitle.setText(shopBean.getShop_spec().getSpec_one_name() + ("、" + shopBean.getShop_spec().getSpec_two_name()));
        Glide.with(mContext).load(UrlUtilds.IMG_URL + shopBean.getImage_path()).into(shopViewHolder.shopImage);
        Log.d("ShppingCartAdapter", "url++++++" + (UrlUtilds.IMG_URL + shopBean.getImage_path()));
        if (shopBean.getIs_integral() != 0) {
            shopViewHolder.jifen.setVisibility(View.VISIBLE);
            shopViewHolder.jifen.setText("可用 " + shopBean.getIntegral() + " 积分兑换");
        } else {
            shopViewHolder.jifen.setVisibility(View.GONE);
        }

        shopViewHolder.shopSelect.setChecked(shopBean.ischeck());
        final ShopViewHolder finalShopViewHolder = shopViewHolder;
        shopViewHolder.shopCountAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int cum = Integer.parseInt(shopBean.getShop_num()) + 1;
                shopBean.setShop_num(String.valueOf(cum));
                upDate(shopBean);
                finalShopViewHolder.shopCount.setText(shopBean.getShop_num());
                stateListener.onCountState(shopBean.getShop_money(), cum, true);
            }
        });
        shopViewHolder.shopCountRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (shopBean.getShop_num().equals("0")) {
                    return;
                }
                int cum = Integer.parseInt(shopBean.getShop_num()) - 1;
                shopBean.setShop_num(String.valueOf(cum));
                upDate(shopBean);
                finalShopViewHolder.shopCount.setText(shopBean.getShop_num());
                stateListener.onCountState(shopBean.getShop_money(), cum, false);
            }
        });
        shopViewHolder.shopSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!finalShopViewHolder.shopSelect.isChecked()) {
                    finalShopViewHolder.shopSelect.setChecked(false);
                    shopBean.setIscheck(false);
                    count--;
                    /**
                     * 当前是否积分商品
                     * 积分商品数量-1
                     */
                    if (shopBean.getIs_integral() == 1) {
                        selectJifen.num--;
                        /**
                         * 积分商品数量是否为0
                         */
                        if (selectJifen.num == 0) {
                            selectJifen = ShopState.CLICKNOJIFEN;
                        }
                    }
                    /**
                     * 如果总数==0
                     * 会把状态改为
                     * 没有选择任何商品
                     */
                    if (count == 0) {
                        selectJifen = ShopState.CLICKDEFAULT;
                    }
                    stateListener.onCheckEd(groupPosition, childPosition, false);
                } else {


                    if (getIsSelect(shopBean)) {

                        myDialogText1();
                        finalShopViewHolder.shopSelect.setChecked(false);
                    } else {
                        finalShopViewHolder.shopSelect.setChecked(true);
                        shopBean.setIscheck(true);
                        /**
                         * 如果当前点击的是积分商品
                         * 状态更改为已选择积分商品状态
                         * 数量++
                         *
                         * 反之状态改为选择没有积分商品
                         */
                        if (shopBean.getIs_integral() == 1) {
                            selectJifen = ShopState.CLICKJIFEN;
                            selectJifen.num++;
                        } else {
                            selectJifen = ShopState.CLICKNOJIFEN;
                        }
                        count++;
                        stateListener.onCheckEd(groupPosition, childPosition, true);
                    }

                }
            }
        });
        Log.e("ADAPTER", "cildview" + childPosition + "====" + shopBean.getShop_name());
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }

    @Override
    public void bianji(boolean isbianji) {
        Set<StoreBean> storeBeen = shopList.keySet();
        for (StoreBean storeBean : storeBeen) {
            List<ShoppingCartBean.MsgBean> msgBeen = shopList.get(storeBean);
            for (ShoppingCartBean.MsgBean msgBean : msgBeen) {
                msgBean.setBianji(isbianji);
            }
        }


        notifyDataSetChanged();
    }

    private void myDialogText1() {
        AlertDialog.Builder builder = new AlertDialog.Builder(baseActivity, R.style.MyCommonDialog);
        builder.setView(R.layout.shop_dialog_custom);
        final AlertDialog dialog = builder.create();
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
        TextView textView = (TextView) dialog.findViewById(R.id.home_dialog_determine);
        textView.setVisibility(View.GONE);
        TextView textView1 = (TextView) dialog.findViewById(R.id.home_dialog);
        TextView textView2 = (TextView) dialog.findViewById(R.id.dialog_text);
        textView2.setText("您已选择了积分商品，不能再选非积分换购商品");
        textView1.setTextColor(Color.parseColor("#BEA571"));
        textView1.setText("好的");
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

    }
    /**
     * 当前是否可以选择
     *
     * @param shopBean
     * @return
     */
    private boolean getIsSelect(ShoppingCartBean.MsgBean shopBean) {
        /**
         * 当前的状态是有积分商品
         * 当前点击的没有积分
         */
        if ((selectJifen == ShopState.CLICKJIFEN) && shopBean.getIs_integral() != 1) {
            return true;
        }
        /**
         * 没有积分商品
         * 当前选择的是有积分的
         */
        if (selectJifen == ShopState.CLICKNOJIFEN && shopBean.getIs_integral() == 1) {
            return true;
        }
        return false;
    }

    class StoreViewHolder {
        TextView storeTitle;
        CheckBox storeSelect;
        ImageView storeDelete;
    }

    class ShopViewHolder {

        TextView shopTitle;
        TextView shopSmallTitle;
        ImageView shopImage;
        CheckBox shopSelect;
        TextView shopMoney;
        TextView shopCount;
        TextView shopCountAdd;
        TextView shopCountRemove;
        TextView shopCountNum;
        TextView shopGuige;
        TextView jifen;
        ImageView shopGuigeSelect;
        LinearLayout itemShaoYes, itemShaoNo;


    }

    public interface StateListener {
        void onCheckEd(int groupPosttion, int childPosition, boolean ischecked);

        void onCountState(String money, int count, boolean isAdd);

        void storeCheckEd(int groupPosition, boolean isChecked);

        void delete(int groupPosition);
    }

    private void upDate(ShoppingCartBean.MsgBean msgBean) {

        ShoppingUtils.update(msgBean);


    }

    enum ShopState {
        CLICKDEFAULT, CLICKJIFEN, CLICKNOJIFEN;
        /**
         * 已经选择积分商品
         */
        int num = 0;
    }

}
