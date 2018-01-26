package hlks.hualiangou.com.ks_android.activity.orderdetails;

import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bigkoo.pickerview.OptionsPickerView;
import com.tsy.sdk.myokhttp.response.GsonResponseHandler;
import com.tsy.sdk.myokhttp.response.RawResponseHandler;
import com.tsy.sdk.myokhttp.util.ToastUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import hlks.hualiangou.com.ks_android.App;
import hlks.hualiangou.com.ks_android.R;
import hlks.hualiangou.com.ks_android.base.BaseActivity;
import hlks.hualiangou.com.ks_android.modle.bean.PopupAddressSelectorBean;
import hlks.hualiangou.com.ks_android.modle.url.UrlUtilds;
import hlks.hualiangou.com.ks_android.utils.UserUtils;
import hlks.hualiangou.com.ks_android.utils.util.KeyBoardUtils;

import static hlks.hualiangou.com.ks_android.App.baseActivity;

/**
 * 项目名称:
 * 类描述:
 * 创建时间:2017/11/26
 */
public class NewAddressShopActivity extends BaseActivity implements View.OnClickListener {

    private ImageView mReceivingAddressReturn;
    /**
     * 完成
     */
    private TextView mAddressComplete;
    /**
     * 李大眼
     */
    private TextView mCompleteName;
    /**
     * shou ji hao
     */
    private EditText mCompletePoperPhone;
    /**
     * 省
     */
    private TextView mCompleteProvince;
    /**
     * 市
     */
    private TextView mCompleteCity;
    /**
     * 区
     */
    private TextView mCompleteRegion;
    /**
     * 详细地址
     */
    private EditText mCompleteAddress;
    /**
     * 设为默认
     */
    private CheckBox mAddressDefault;
    /**
     * 完成
     */
    private TextView mAddressCompleteBottom;

    private LinearLayout mLlPleaseChoose;
    private List<PopupAddressSelectorBean.MsgBean.RegionBean> mList;
    /**
     * 所有省
     */

    private String time;
    private List<String> list;
    private OptionsPickerView optionsPickerView;
    private List<String> list4;
    private List<List<String>> list5;
    private String isdefaultText;

    @Override
    public int getLayoutId() {
        return R.layout.activity_new_address_shop;
    }

    @Override
    public void initView() {
        mList = new ArrayList<>();
        //获取时间
        Date dt = new Date();
        time = String.valueOf(dt.getTime());
        mReceivingAddressReturn = (ImageView) findViewById(R.id.receiving_address_return);
        mReceivingAddressReturn.setOnClickListener(this);
        mAddressComplete = (TextView) findViewById(R.id.address_complete);
        mAddressComplete.setOnClickListener(this);
        mCompleteName = (TextView) findViewById(R.id.complete_name);
        mCompleteName.setOnClickListener(this);
        mCompletePoperPhone = (EditText) findViewById(R.id.complete_poper_phone);
        mCompletePoperPhone.setOnClickListener(this);
        mCompleteProvince = (TextView) findViewById(R.id.complete_province);
        mCompleteProvince.setOnClickListener(this);
        mCompleteCity = (TextView) findViewById(R.id.complete_city);
        mCompleteCity.setOnClickListener(this);
        mCompleteRegion = (TextView) findViewById(R.id.complete_region);
        mCompleteRegion.setOnClickListener(this);
        mCompleteAddress = (EditText) findViewById(R.id.complete_address);
        mAddressDefault = (CheckBox) findViewById(R.id.item_address_checkBox);
        mAddressDefault.setOnClickListener(this);
        mAddressCompleteBottom = (TextView) findViewById(R.id.address_complete_bottom);
        mAddressCompleteBottom.setOnClickListener(this);
        mLlPleaseChoose = (LinearLayout) findViewById(R.id.ll_please_choose);
        mLlPleaseChoose.setOnClickListener(this);
    }

    @Override
    public void loadData() {
        initAddressOkHttp();
//        hideEditext(R.id.complete_poper_phone);
    }

    private void initAddressOkHttp() {
        App.myOkHttp
                .postParams()
                .url(UrlUtilds.GET_REGION)
                .addParam("api", "region/getRegion")
                .addParam("appid", UrlUtilds.APPID)
                .addParam("t", time)
                .addParam("token", UserUtils.getToken())
                .enqueue(new GsonResponseHandler<PopupAddressSelectorBean>() {
                    @Override
                    public void onSuccess(int statusCode, PopupAddressSelectorBean response) {


                        final List<String> list1 = new ArrayList<String>();
                        final List<List<String>> list2 = new ArrayList<List<String>>();
                        final List<List<List<String>>> list3 = new ArrayList<List<List<String>>>();
                        List<PopupAddressSelectorBean.MsgBean.RegionBean> region = response.getMsg().getRegion();

                        int length = region.size();
                        for (int i = 0; i < length; i++) {
                            list = new ArrayList<String>();
                            list5 = new ArrayList<List<String>>();

                            //省
                            PopupAddressSelectorBean.MsgBean.RegionBean regionBean = region.get(i);
                            list1.add(regionBean.getLocal_name());
                            //市
                            List<PopupAddressSelectorBean.MsgBean.RegionBean.CRegionBean> c_region = regionBean.getC_region();
                            int cityLength = c_region.size();
                            for (int j = 0; j < cityLength; j++) {

                                list4 = new ArrayList<String>();
                                PopupAddressSelectorBean.MsgBean.RegionBean.CRegionBean cRegionBean = c_region.get(j);
                                list.add(cRegionBean.getLocal_name());
                                //县
                                List<PopupAddressSelectorBean.MsgBean.RegionBean.CRegionBean.ZRegionBean> z_region = cRegionBean.getZ_region();
                                int xianLength = z_region.size();
                                for (int k = 0; k < xianLength; k++) {
                                    PopupAddressSelectorBean.MsgBean.RegionBean.CRegionBean.ZRegionBean zRegionBean = z_region.get(k);

                                    list4.add(zRegionBean.getLocal_name());
                                }
                                list5.add(list4);
                            }
                            list2.add(list);
                            list3.add(list5);
                        }

                        optionsPickerView = new OptionsPickerView.Builder(NewAddressShopActivity.this, new OptionsPickerView.OnOptionsSelectListener() {
                            @Override
                            public void onOptionsSelect(int options1, int options2, int options3, View v) {
//                                    ToastUtils.showSingleLongToast(list1.get(options1) + "  " + list2.get(options1).get(options2) + " " + list3.get(options1).get(options2).get(options3));
                                mCompleteProvince.setText(list1.get(options1));
                                mCompleteCity.setText(list2.get(options1).get(options2));
                                List<String> list = list3.get(options1).get(options2);
                                if (list!=null&!list.isEmpty()){
                                mCompleteRegion.setText(list3.get(options1).get(options2).get(options3));
                                }else {
                                    mAddressComplete.setText("");
                                }
                            }
                        }).build();

                        optionsPickerView.setPicker(list1, list2, list3);

                    }

                    @Override
                    public void onFailure(int statusCode, String error_msg) {

                    }
                });
    }

    @Override
    public void setListener() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            /**
             * 返回
             */
            case R.id.receiving_address_return:
                finish();
                break;
            /**
             * 收货人姓名
             */
            case R.id.complete_name:
                break;
            /**
             * 收货人手机号
             */
            case R.id.complete_poper_phone:

                break;
            /**
             * 详细地址
             */
            case R.id.complete_address:
                break;
            /**
             * 设为默认
             */
            case R.id.item_address_checkBox:
                break;
            /**
             * 确认textbtn
             */
            case R.id.address_complete_bottom:
                if (mCompleteName.getText().toString() != null & mCompleteName.getText().toString().isEmpty()) {
                    ToastUtils.showSingleToast("请填写收货人姓名");
                } else if (mCompletePoperPhone.getText().toString() != null & mCompletePoperPhone.getText().toString().isEmpty()) {
                    ToastUtils.showSingleToast("请填写联系人手机号");
                } else if (mCompleteProvince.getText().toString() != null & mCompleteProvince.getText().toString().isEmpty()) {
                    ToastUtils.showSingleToast("请选择城市");
                } else if (mCompleteAddress.getText().toString() != null & mCompleteAddress.getText().toString().isEmpty()) {
                    ToastUtils.showSingleToast("请填写详细地址");
                } else {
                    if (mAddressDefault.isChecked()) {
                        isdefaultText = "1";
                        initCompleteOkhttp();
                    } else {
                        isdefaultText = "0";
                        initCompleteOkhttp();
                    }
                }
                break;
            /**
             * 完成
             */
            case R.id.address_complete:
                if (mCompleteAddress.getText().toString() != null & mCompleteAddress.getText().toString().isEmpty()) {
                    ToastUtils.showSingleToast("请填写详细地址");
                } else if (mCompleteName.getText().toString() != null & mCompleteName.getText().toString().isEmpty()) {
                    ToastUtils.showSingleToast("请填写收货人");
                } else if (mCompletePoperPhone.getText().toString() != null & mCompletePoperPhone.getText().toString().isEmpty()) {
                    ToastUtils.showSingleToast("请填写联系人手机号");
                } else if (mCompleteProvince.getText().toString() != null & mCompleteProvince.getText().toString().isEmpty()) {
                    ToastUtils.showSingleToast("请选择城市");
                } else {
                    if (mAddressDefault.isChecked()) {
                        isdefaultText = "1";
                        initCompleteOkhttp();

                    } else {
                        isdefaultText = "0";
                        initCompleteOkhttp();
                    }
                }

                break;
            /**
             * 请选择 弹出选择器
             */
            case R.id.ll_please_choose:
                KeyBoardUtils.closeKeybord(mCompletePoperPhone,this);
                if (optionsPickerView != null) {
                    optionsPickerView.show();
                } else {
                    ToastUtils.showSingleToast("您当前网络缓慢，请稍后尝试...");
                }

                break;
        }
    }

    private void initCompleteOkhttp() {
        App.myOkHttp
                .postParams()
                .url(UrlUtilds.ADD_USERADDR)
                .addParam("api", "addr/AddUserAddr")
                .addParam("appid", UrlUtilds.APPID)
                .addParam("t", time)
                .addParam("token", UserUtils.getToken())
                .addParam("user_id", UserUtils.getUserId())
                .addParam("addr", mCompleteAddress.getText().toString())//详细地址
                .addParam("receiver", mCompleteName.getText().toString())//收货人姓名
                .addParam("receiver_phone", mCompletePoperPhone.getText().toString())//电话
                .addParam("area", mCompleteProvince.getText().toString())//省
                .addParam("city", mCompleteCity.getText().toString())//市
                .addParam("domain", mCompleteRegion.getText().toString())//区
                .addParam("is_default", isdefaultText)//是否默认
                .enqueue(new RawResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, String response) {
                        myDialogText();
                    }

                    @Override
                    public void onFailure(int statusCode, String error_msg) {

                    }
                });
    }

    private void myDialogText() {
        AlertDialog.Builder builder = new AlertDialog.Builder(baseActivity, R.style.MyCommonDialog);
        builder.setView(R.layout.newadd_addrss_dialog);
        final AlertDialog dialog = builder.create();
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
        TextView textView = (TextView) dialog.findViewById(R.id.address_dialog_yes);
        TextView textView1 = (TextView) dialog.findViewById(R.id.address_dialog_no);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 mCompleteAddress.setText("");//详细地址
                         mCompleteName.setText("");//收货人姓名
                        mCompletePoperPhone.setText("");//电话
                     mCompleteProvince.setText("");//省
                      mCompleteCity.setText("");//市
                        mCompleteRegion.setText("");//区
                      mAddressDefault.setChecked(false);
                dialog.dismiss();
            }
        });
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                finish();
            }
        });
    }



}
