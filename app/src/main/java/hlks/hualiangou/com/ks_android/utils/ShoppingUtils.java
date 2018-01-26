package hlks.hualiangou.com.ks_android.utils;

import android.util.Log;

import com.google.gson.Gson;
import com.tsy.sdk.myokhttp.response.RawResponseHandler;

import java.util.ArrayList;
import java.util.List;

import hlks.hualiangou.com.ks_android.App;
import hlks.hualiangou.com.ks_android.bean.UpdateShopping;
import hlks.hualiangou.com.ks_android.modle.bean.ShoppingCartBean;
import hlks.hualiangou.com.ks_android.modle.url.UrlUtilds;

/**
 * 项目名称:
 * 类描述:
 * 创建时间:2017/11/30
 */
public class ShoppingUtils {

    /**
     * 删除商品
     *
     * @param msgBeen
     * @return
     */
    public static boolean deleteShop(List<ShoppingCartBean.MsgBean> msgBeen) {
        if (msgBeen == null || msgBeen.isEmpty() ) {
            return false;
        }
        List<UpdateShopping> list = new ArrayList<>();
        for (ShoppingCartBean.MsgBean bean : msgBeen) {
            UpdateShopping bean1 = new UpdateShopping();
            bean1.setStaff("1");
            bean1.setCart_id(bean.getCart_id());
            bean1.setShop_id(bean.getShop_id());
            bean1.setShop_num(bean.getShop_num());
            bean1.setShop_money(bean.getShop_money());
            bean1.setShop_spec_id(bean.getShop_spec_id());
            list.add(bean1);
        }
        return euuae(list);
    }


    /**
     * 修改购物车
     *
     * @param msgBeen
     * @return
     */
    public static boolean update(ShoppingCartBean.MsgBean... msgBeen) {
        if (msgBeen == null || msgBeen.length == 0) {
            return false;
        }
        List<UpdateShopping> list = new ArrayList<>();
        for (ShoppingCartBean.MsgBean bean : msgBeen) {
            UpdateShopping bean1 = new UpdateShopping();
            bean1.setStaff("0");
            bean1.setCart_id(bean.getCart_id());
            bean1.setShop_id(bean.getShop_id());
            bean1.setShop_num(bean.getShop_num());
            bean1.setShop_money(bean.getShop_money());
            bean1.setShop_spec_id(bean.getShop_spec_id());
            list.add(bean1);
        }
        return euuae(list);
    }


    private static boolean euuae(List<UpdateShopping> uploadShopping) {
        final boolean[] isSuccful = {false};
        Gson gson = new Gson();
        Log.d("ShoppingUtils", gson.toJson(uploadShopping));
        String s = gson.toJson(uploadShopping);
//        String s1 = "{\"shoping\":\""+s+"\"}";
//        String s1 = "{\"shoping\":"+s+"}";

        Log.d("ShoppingUtils", s);
        App.myOkHttp
                .postParams()
                .url(UrlUtilds.UPDATE_SHOPING)
                .addParam("api", "shop/updateShoping")
                .addParam("appid", UrlUtilds.APPID)
                .addParam("t", String.valueOf(System.currentTimeMillis()))
                .addParam("token", UserUtils.getToken())
                .addParam("shoping",s)
                .enqueue(new RawResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, String response) {
                        Log.e("chat","onsuccful==="+response);
                        isSuccful[0] = true;
                    }

                    @Override
                    public void onFailure(int statusCode, String error_msg) {
                        Log.e("chat","onfile==="+error_msg);
                        isSuccful[0] = false;
                    }

                });
        return isSuccful[0];
    }

}
