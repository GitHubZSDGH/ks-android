package hlks.hualiangou.com.ks_android.fragment.detailPages;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import hlks.hualiangou.com.ks_android.R;
import hlks.hualiangou.com.ks_android.base.BaseFragment;
import hlks.hualiangou.com.ks_android.modle.bean.DetailPagesBean;
import hlks.hualiangou.com.ks_android.modle.url.UrlUtilds;

/**
 * 项目名称:
 * 类描述:
 * 创建时间:2017/12/5
 */
public class XiangQingFragment extends BaseFragment {
    private LinearLayout mListView;
    private ArrayList<DetailPagesBean.MsgBean.ShopFeaturesBean> mList  = new ArrayList<>();

    @Override
    public int getLayoutId() {
        return R.layout.shop_detalpages;
    }

    @Override
    public void initView(View view) {
     mListView = view.findViewById(R.id.id_lin);
    }

    @Override
    public void loadData() {
        for (DetailPagesBean.MsgBean.ShopFeaturesBean shopFeaturesBean : mList) {
            ImageView imageView = new ImageView(baseActivity);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            imageView.setLayoutParams(params);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            Glide.with(getContext()).load(UrlUtilds.IMG_URL + shopFeaturesBean.getPath()).into(imageView);
            mListView.addView(imageView);
        }
   }

    @Override
    public void getBundle(Bundle bundle) {
        super.getBundle(bundle);
       ArrayList<DetailPagesBean.MsgBean.ShopFeaturesBean> list = bundle.getParcelableArrayList("shopImage");
        mList.addAll(list);
    }

    @Override
    public void setListener() {

    }

}
