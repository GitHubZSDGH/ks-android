package hlks.hualiangou.com.ks_android.modle.adapter.home;

import java.util.List;

/**
 * 作者：liukai
 * 创建时间：2017/10/19 10:19
 * 邮箱：liukai3099@163.com
 * 特色险种
 */
public class TeSeXianZhongResult {

    private List<ProductFeatureCategoryModelListBean> productFeatureCategoryModelList;

    public List<ProductFeatureCategoryModelListBean> getProductFeatureCategoryModelList() {
        return productFeatureCategoryModelList;
    }

    public void setProductFeatureCategoryModelList(List<ProductFeatureCategoryModelListBean> productFeatureCategoryModelList) {
        this.productFeatureCategoryModelList = productFeatureCategoryModelList;
    }

    public static class ProductFeatureCategoryModelListBean {
        /**
         * imageUrl : http://112.126.85.22:7500/dev1/0/000/063/0000063616.fid
         * productFeatureCategoryUuid : reCategory0000000008T
         */

        private String imageUrl;
        private String productFeatureCategoryUuid;

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public String getProductFeatureCategoryUuid() {
            return productFeatureCategoryUuid;
        }

        public void setProductFeatureCategoryUuid(String productFeatureCategoryUuid) {
            this.productFeatureCategoryUuid = productFeatureCategoryUuid;
        }
    }
}

