package hlks.hualiangou.com.ks_android.view.bannerpager;

import java.io.Serializable;

public class BannerViewData implements Serializable {

    public BannerViewData() {
    }

    public BannerViewData(String imgUrl, Object obj) {
        this.imageUrl = imgUrl;
        this.obj = obj;
    }

    private int position;
    private int realIndex;
    private String urlName;
    private String url;
    private String imageUrl;
    private Object obj;

    public int getRealIndex() {
        return realIndex;
    }

    public void setRealIndex(int realIndex) {
        this.realIndex = realIndex;
    }

    public String getImgUrl() {
        return imageUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imageUrl = imgUrl;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getUrlName() {
        return urlName;
    }

    public void setUrlName(String urlName) {
        this.urlName = urlName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
