package hlks.hualiangou.com.ks_android.activity.orderdetails;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.tsy.sdk.myokhttp.response.GsonResponseHandler;
import com.tsy.sdk.myokhttp.response.RawResponseHandler;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import hlks.hualiangou.com.ks_android.App;
import hlks.hualiangou.com.ks_android.R;
import hlks.hualiangou.com.ks_android.base.BaseActivity;
import hlks.hualiangou.com.ks_android.bean.UserAdressBean;
import hlks.hualiangou.com.ks_android.modle.adapter.Shopping.ReceivingAddressAdapter;
import hlks.hualiangou.com.ks_android.modle.url.UrlUtilds;
import hlks.hualiangou.com.ks_android.utils.UserUtils;

/**
 * 接收地址
 */
public class ReceivingAddressActivity extends BaseActivity implements View.OnClickListener,ReceivingAddressAdapter.OnItemClick {

    private ImageView mReceivingAddressReturn;
    private ListView mLlReceivingAddress;
    private String time;
    private ReceivingAddressAdapter mReceAdapter;
    private List<UserAdressBean.MsgBean.UserAddrBean> mUserAddrBean;



    /**
     * 新增地址
     */
    private TextView mNewAddAddress;
    private String id;

    @Override
    public int getLayoutId() {
        return R.layout.activity_receiving_address;
    }

    @Override
    public void initView() {
        //获取时间
        Date dt = new Date();
        time = String.valueOf(dt.getTime());
        mReceivingAddressReturn = (ImageView) findViewById(R.id.receiving_address_return);
        mReceivingAddressReturn.setOnClickListener(this);
        mLlReceivingAddress = (ListView) findViewById(R.id.ll_receiving_address);
        mNewAddAddress = (TextView) findViewById(R.id.new_add_address);
        mNewAddAddress.setOnClickListener(this);

    }

    @Override
    public void loadData() {
      loadAdress();
        mUserAddrBean = new ArrayList<>();
       mReceAdapter = new ReceivingAddressAdapter((ArrayList<UserAdressBean.MsgBean.UserAddrBean>)
       mUserAddrBean,ReceivingAddressActivity.this);
        mReceAdapter.setOnItemClick(this);

        mLlReceivingAddress.setAdapter(mReceAdapter);

    }
    private void loadAdress() {
        App.myOkHttp
                .postParams()
                .url(UrlUtilds.GET_USERADDR)
                .addParam("api", "addr/getUserAddr")
                .addParam("appid", UrlUtilds.APPID)
                .addParam("t", time)
                .addParam("token", UserUtils.getToken())
                .addParam("user_id", UserUtils.getUserId())
                .enqueue(new GsonResponseHandler<UserAdressBean>() {
                    @Override
                    public void onSuccess(int statusCode, UserAdressBean response) {
                          mUserAddrBean.addAll(response.getMsg().getUser_addr());
                          mReceAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onFailure(int statusCode, String error_msg) {

                    }

                    @Override
                    public void onSuccfulString(int code, String message) {
                        super.onSuccfulString(code, message);
                    }
                });

    }
    @Override
    public void setListener() {

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        mUserAddrBean.clear();
        loadAdress();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.receiving_address_return:
                finish();
                break;
            case R.id.new_add_address:
                Intent intent = new Intent(ReceivingAddressActivity.this,NewAddressShopActivity.class);
                startActivity(intent);
                break;
        }
    }

    private int DeleteId;

    /**
     *  回调的删除与修改
     * @param view
     * @param positon
     */
    @Override
    public void Delete(View view, int positon) {
        id = mUserAddrBean.get(positon).getId();
        DeleteId = positon;

        initDeleteOkHttp();
    }
    @Override
    public void Change(View view, int positon) {

    }

    private void initDeleteOkHttp() {
        App.myOkHttp
                .postParams()
                .url(UrlUtilds.DELEDT_USERADDR)
                .addParam("api", "addr/deledtUserAddr")
                .addParam("appid", UrlUtilds.APPID)
                .addParam("t", time)
                .addParam("token", UserUtils.getToken())
                .addParam("user_id", UserUtils.getUserId())
                .addParam("addr_id",id)
                .enqueue(new RawResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, String response) {
                        mUserAddrBean.remove(DeleteId);
                        mReceAdapter.notifyDataSetChanged();
                        Log.d("ReceivingAddressActivit", "删除成功");
                    }

                    @Override
                    public void onFailure(int statusCode, String error_msg) {

                    }
                });
    }


}
