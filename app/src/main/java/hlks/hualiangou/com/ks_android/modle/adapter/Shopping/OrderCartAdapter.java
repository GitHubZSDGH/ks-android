package hlks.hualiangou.com.ks_android.modle.adapter.Shopping;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

import hlks.hualiangou.com.ks_android.R;
import hlks.hualiangou.com.ks_android.modle.bean.ShoppingCartBean;
import hlks.hualiangou.com.ks_android.modle.bean.StoreBean;

/**
 * 项目名称:
 * 类描述:
 * 创建时间:2017/11/28
 */
public class OrderCartAdapter<T> extends BaseExpandableListAdapter {
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

    public OrderCartAdapter(List<StoreBean> storeList, Map<StoreBean, List<T>> shopList, Context mContext) {
        this.storeList = storeList;
        this.shopList = shopList;
        this.mContext = mContext;
    }

    @Override
    public int getGroupCount() {
        return storeList.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return shopList.get(storeList.get(i)).size();
    }

    @Override
    public Object getGroup(int i) {
        return null;
    }

    @Override
    public Object getChild(int i, int i1) {
        return null;
    }

    @Override
    public long getGroupId(int i) {
        return 0;
    }

    @Override
    public long getChildId(int i, int i1) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        StoreViewHolder storeViewHolder = null;
if (view==null){
    view = LayoutInflater.from(mContext).inflate(R.layout.item_confirm_order, null);
    storeViewHolder = new StoreViewHolder();
    storeViewHolder.storeTitle = view.findViewById(R.id.item_title);
    view.setTag(storeViewHolder);

} else {
    storeViewHolder = (StoreViewHolder) view.getTag();
}
        final StoreBean storeBean = storeList.get(i);
        storeViewHolder.storeTitle.setText("华联可溯");
        return null;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        T t = shopList.get(storeList.get(i)).get(i1);

        if(t instanceof ShoppingCartBean.MsgBean){
            ShoppingCartBean.MsgBean bean = (ShoppingCartBean.MsgBean) t;
        }
        ShopViewHolder shopViewHolder = null;
        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.item_shop, null);
            shopViewHolder = new ShopViewHolder();
            shopViewHolder.shopCount = view.findViewById(R.id.item_count);
            shopViewHolder.shopImage = view.findViewById(R.id.item_shop_img);
            shopViewHolder.shopTitle = view.findViewById(R.id.item_shop_name);
            shopViewHolder.shopSmallTitle = view.findViewById(R.id.item_shop_name_name);
            shopViewHolder.shopMoney = view.findViewById(R.id.item_money);

            view.setTag(shopViewHolder);

        } else {
            shopViewHolder = (ShopViewHolder) view.getTag();
        }

//        shopViewHolder.shopTitle.setText(shopBean.getShop_name());
//        shopViewHolder.shopMoney.setText("￥" + shopBean.getShop_end_money());
//        shopViewHolder.shopCount.setText(shopBean.getShop_num());
//        shopViewHolder.shopSmallTitle.setText("后台没数据");
//        Glide.with(mContext).load(UrlUtilds.IMG_URL+shopBean.getImage_path()).into(shopViewHolder.shopImage);
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }
    class StoreViewHolder {
        TextView storeTitle;
    }
    class ShopViewHolder {

        TextView shopTitle;
        TextView shopSmallTitle;
        ImageView shopImage;
        TextView shopMoney;
        TextView shopCount;

    }
}
