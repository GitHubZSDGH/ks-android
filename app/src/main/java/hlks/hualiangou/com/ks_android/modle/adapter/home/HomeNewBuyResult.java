package hlks.hualiangou.com.ks_android.modle.adapter.home;

import java.util.List;

/**
 * 创建时间：2017/10/19 10:19
 * 最近购买
 */
public class HomeNewBuyResult {


    private List<RecentPurchaseListBean> recentPurchaseList;

    public List<RecentPurchaseListBean> getRecentPurchaseList() {
        return recentPurchaseList;
    }

    public void setRecentPurchaseList(List<RecentPurchaseListBean> recentPurchaseList) {
        this.recentPurchaseList = recentPurchaseList;
    }

    public static class RecentPurchaseListBean {


        private String productName;
        private String productUuid;
        private String remotePaths;
        private String shopPrice;

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public String getProductUuid() {
            return productUuid;
        }

        public void setProductUuid(String productUuid) {
            this.productUuid = productUuid;
        }

        public String getRemotePaths() {
            return remotePaths;
        }

        public void setRemotePaths(String remotePaths) {
            this.remotePaths = remotePaths;
        }

        public String getShopPrice() {
            return shopPrice;
        }

        public void setShopPrice(String shopPrice) {
            this.shopPrice = shopPrice;
        }
    }
}
