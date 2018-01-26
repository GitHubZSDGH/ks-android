package hlks.hualiangou.com.ks_android.modle.adapter.Shopping;

import android.content.Context;
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

import java.util.List;
import java.util.Map;

import hlks.hualiangou.com.ks_android.R;
import hlks.hualiangou.com.ks_android.modle.bean.DetailPagesBean;
import hlks.hualiangou.com.ks_android.modle.bean.ShoppingCartBean;
import hlks.hualiangou.com.ks_android.modle.bean.StoreBean;
import hlks.hualiangou.com.ks_android.modle.url.UrlUtilds;

/**
 * Created by localadmin on 2017/11/19.
 */

public class ConFimAdapter<T> extends BaseExpandableListAdapter implements ShoppingStateListener {
    /**
     * 店铺集合
     */
    private List<StoreBean> storeList;

    /**
     * 商品集合
     */
    private Map<StoreBean, List<T>> shopList;

    /**
     * 上下文对象
     */
    private Context mContext;

    private ShoppingStateListener shoppingStateListener;

    public ShoppingStateListener getShoppingStateListener() {
        return shoppingStateListener;
    }

    public ConFimAdapter(List<StoreBean> storeList, Map<StoreBean, List<T>> shopList, Context mContext) {
        this.storeList = storeList;
        this.shopList = shopList;
        shoppingStateListener = this;
        this.mContext = mContext;
    }

    private StateListener stateListener;

    public void setStateListener(StateListener stateListener) {
        this.stateListener = stateListener;
    }

    @Override
    public int getGroupCount() {
        Log.e("ADAPTER", "view个数" + storeList.size());
        if (storeList == null) {
            return 0;
        }

        return storeList.size();
    }

    @Override
    public int getChildrenCount(int position) {
        Log.e("ADAPTER", "子view个数" + shopList.get(storeList.get(position)).size());
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
        storeViewHolder.storeSelect.setVisibility(View.GONE);
//        storeViewHolder.storeDelete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                stateListener.delete(groupPostion);
//            }
//        });
//        storeViewHolder.storeSelect.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (!finalStoreViewHolder.storeSelect.isChecked()) {
//                    finalStoreViewHolder.storeSelect.setChecked(false);
//                    stateListener.storeCheckEd(groupPostion, false);
//                } else {
//                    finalStoreViewHolder.storeSelect.setChecked(true);
//                    stateListener.storeCheckEd(groupPostion, true);
//
//                }
//            }
//        });
        return view;
    }

    @Override
    public View getChildView(final int groupPosition, final int childPosition, boolean b, View view, ViewGroup viewGroup) {
        T t = shopList.get(storeList.get(groupPosition)).get(childPosition);
        ShopViewHolder shopViewHolder = null;
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

            view.setTag(shopViewHolder);

        } else {
            shopViewHolder = (ShopViewHolder) view.getTag();
        }

        shopViewHolder.shopSelect.setVisibility(View.GONE);
        if (t instanceof DetailPagesBean.MsgBean) {
            DetailPagesBean.MsgBean shopBean = (DetailPagesBean.MsgBean) t;

            shopViewHolder.shopTitle.setText(shopBean.getShop_name());


            shopViewHolder.shopMoney.setText("￥" + shopBean.getShop_end_money());
            shopViewHolder.shopCountNum.setText(shopBean.getShop_num());
            shopViewHolder.shopCount.setText(shopBean.getSale_num());
            //*****guige****
            shopViewHolder.shopSmallTitle.setText("规格："+shopBean.getShop_spec().get(childPosition).getSpec_one_name()+("、"+shopBean.getShop_spec().get(childPosition).getSpec_two().get(childPosition).getSpec_two_name()));
            Glide.with(mContext).load(UrlUtilds.IMG_URL + shopBean.getShop_image().get(0).getPath()).into(shopViewHolder.shopImage);
        } else if (t instanceof ShoppingCartBean.MsgBean) {
            ShoppingCartBean.MsgBean shopBean = (ShoppingCartBean.MsgBean) t;
            shopViewHolder.shopTitle.setText(shopBean.getShop_name());


            shopViewHolder.shopMoney.setText("￥" + shopBean.getShop_end_money());
            shopViewHolder.shopCountNum.setText(shopBean.getShop_num());
            shopViewHolder.shopCount.setText(shopBean.getShop_num());

            shopViewHolder.shopSmallTitle.setText("规格："+shopBean.getShop_spec().getSpec_one_name()+("、"+shopBean.getShop_spec().getSpec_two_name()));
            Glide.with(mContext).load(UrlUtilds.IMG_URL + shopBean.getImage_path()).into(shopViewHolder.shopImage);


        }



        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }

    @Override
    public void bianji(boolean isbianji) {

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
        ImageView shopGuigeSelect;
        LinearLayout itemShaoYes, itemShaoNo;


    }

    public interface StateListener {
        void onCheckEd(int groupPosttion, int childPosition, boolean ischecked);

        void onCountState(String money, int count, boolean isAdd);

        void storeCheckEd(int groupPosition, boolean isChecked);

        void delete(int groupPosition);
    }


}
