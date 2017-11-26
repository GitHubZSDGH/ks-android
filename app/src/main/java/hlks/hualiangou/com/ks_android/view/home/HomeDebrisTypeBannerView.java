package hlks.hualiangou.com.ks_android.view.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import hlks.hualiangou.com.ks_android.R;
import hlks.hualiangou.com.ks_android.utils.encryption.DensityUtil;
import hlks.hualiangou.com.ks_android.view.BaseDevrisLayoutView;
import hlks.hualiangou.com.ks_android.view.bannerpager.BannerViewData;


/**
 * Created by cjl
 */

public class HomeDebrisTypeBannerView extends BaseDevrisLayoutView {
    public  final float BANNER_HEIGHT_WIDTH = 0.457f;


    public HomeDebrisTypeBannerView(Context context) {
        super(context);
    }
    //Banner高度
    int bannerHeight = 0;
    Banner mBanner;

    @Override
    public View initView() {
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_debris_banner, null);
        int screenWidth = DensityUtil.getDisplayWidth(mContext);
        bannerHeight = (int) (screenWidth * BANNER_HEIGHT_WIDTH);
        mBanner = $(view, R.id.home_banner);

        return view;
    }

    public Banner getBanner() {
        return mBanner;
    }



    public void setList(List<BannerViewData> bannerlists) {
        if (bannerlists != null && bannerlists.size() > 0) {
            List<BannerViewData> bList = new ArrayList<>();
            for (BannerViewData model : bannerlists) {
                String imgUrl = model.getImgUrl();
                bList.add(new BannerViewData(imgUrl, model));
            }
            mBanner.setImages(bList);
        }
    }
}
