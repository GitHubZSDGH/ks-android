package hlks.hualiangou.com.ks_android.modle.adapter.Shopping;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.tsy.sdk.myokhttp.response.RawResponseHandler;
import com.tsy.sdk.myokhttp.util.ToastUtils;

import java.util.ArrayList;

import hlks.hualiangou.com.ks_android.App;
import hlks.hualiangou.com.ks_android.R;
import hlks.hualiangou.com.ks_android.bean.UserAdressBean;
import hlks.hualiangou.com.ks_android.modle.url.UrlUtilds;
import hlks.hualiangou.com.ks_android.utils.UserUtils;

/**
 * 项目名称:
 * 类描述:
 * 创建时间:2017/11/28
 */
public class ReceivingAddressAdapter extends BaseAdapter {
    ArrayList<UserAdressBean.MsgBean.UserAddrBean> userAddrList;
    Context context;
    private OnItemClick onItemClick;

    public void setOnItemClick(OnItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }

    public ReceivingAddressAdapter(ArrayList<UserAdressBean.MsgBean.UserAddrBean> userAddrList,
                                   Context context) {
        this.userAddrList = userAddrList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return userAddrList.size();
    }

    @Override
    public Object getItem(int i) {
        return userAddrList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHold holder;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.item_receiving_address, null);
            holder = new ViewHold();
            holder.receName = convertView.findViewById(R.id.item_recriving_name);
            holder.recePhone = convertView.findViewById(R.id.item_recriving_phone);
            holder.receAdaress = convertView.findViewById(R.id.item_recriving_address_tv);
            holder.receAddressDefault = convertView.findViewById(R.id.item_address_default);
            holder.receAddressEdit = convertView.findViewById(R.id.item_order_address_edit);
            holder.receAddressDelete = convertView.findViewById(R.id.item_delete_address);
            convertView.setTag(holder);
        } else {
            holder = (ViewHold) convertView.getTag();
        }

        final UserAdressBean.MsgBean.UserAddrBean userAddrBean = userAddrList.get(position);
        if ("1".equals(userAddrBean.getIs_default())){
            holder.receAddressDefault.setChecked(true);
        }else {
            holder.receAddressDefault.setChecked(false);
        }
//        holder.receAddressDefault.setChecked(userAddrBean.isChecked());
        holder.receAddressDefault.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!holder.receAddressDefault.isChecked()) {
                    holder.receAddressDefault.setChecked(false);
                    userAddrBean.setChecked(false);
                } else {
                    holder.receAddressDefault.setChecked(true);

                    for (UserAdressBean.MsgBean.UserAddrBean addrBean : userAddrList) {
                       if("1".equals(addrBean.getIs_default())){
                           addrBean.setIs_default("2");
                       }
                    }
                    userAddrBean.setIs_default("1");
                    userAddrBean.setChecked(true);
                    notifyDataSetChanged();
                    initCheckedOkHttp(userAddrBean.getId());
                }

            }
        });
        holder.receName.setText(userAddrBean.getReceiver());
        holder.recePhone.setText(userAddrBean.getReceiver_phone());
        if (userAddrBean.getAddr().toString().equals("") && userAddrBean.getAddr().toString().trim() == null) {
            holder.receAdaress.setText(userAddrBean.getArea() + userAddrBean.getCity() + userAddrBean.getDomain());
        } else {
            holder.receAdaress.setText(userAddrBean.getArea() + userAddrBean.getCity() + userAddrBean.getDomain() + userAddrBean.getAddr());
        }

        holder.receAddressDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                onItemClick.Delete(view, position);
            }
        });

        holder.receAddressEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClick.Change(view, position);
            }
        });

        return convertView;
    }

    private void initCheckedOkHttp(String id) {
        App.myOkHttp
                .postParams()
                .url(UrlUtilds.UPDATE_USER_ADDRDEFAULT)
                .addParam("api", "addr/updateUserAddrDefault")
                .addParam("appid", UrlUtilds.APPID)
                .addParam("t", String.valueOf(System.currentTimeMillis()))
                .addParam("token", UserUtils.getToken())
                .addParam("user_id", UserUtils.getUserId())
                .addParam("addr_id",id)
                .enqueue(new RawResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, String response) {
                        ToastUtils.showSingleToast("用户地址修改成功");
                    }

                    @Override
                    public void onFailure(int statusCode, String error_msg) {

                    }
                });
    }

    class ViewHold {
        TextView receName;
        TextView recePhone;
        TextView receAdaress;
        CheckBox receAddressDefault;
        TextView receAddressEdit;
        TextView receAddressDelete;
    }

    public interface OnItemClick {

        void Delete(View view, int positon);

        void Change(View view, int positon);

    }

}
