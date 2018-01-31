package hlks.hualiangou.com.ks_android.modle.adapter.classIfy;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import hlks.hualiangou.com.ks_android.R;
import hlks.hualiangou.com.ks_android.modle.bean.ClassIfygragmentBean;

/**
 * 项目名称:
 * 类描述:
 * 创建人:lenovo
 * 创建时间:2017/11/17
 * 修改人:
 * 修改内容:
 */
public class IfyLeftAdapter extends BaseAdapter {
    private Context mContext;
    private int mSelect = 0;//选中项
    private List<ClassIfygragmentBean.MsgBean> mList = new ArrayList<>();
    private View view;

    public IfyLeftAdapter(Context mContext, List<ClassIfygragmentBean.MsgBean> mList) {
        this.mContext = mContext;
        this.mList = mList;

    }

    public void setmList(List<ClassIfygragmentBean.MsgBean> mList) {
        this.mList = mList;
        this.notifyDataSetChanged();
    }

    public void setView(View view) {
        this.view = view;
    }

    public void getData(List<ClassIfygragmentBean.MsgBean> mList) {
        this.mList = mList;
        notifyDataSetChanged();
    }

    public int getmSelect() {
        return mSelect;
    }

    public void setmSelect(int mSelect) {
        this.mSelect = mSelect;
    }

    public void setmContext(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return mList.isEmpty() ? 0 : mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.item_type, null);
            holder = new ViewHolder();
            holder.tv_name = (TextView) convertView.findViewById(R.id.tv_title);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tv_name.setText(mList.get(position).getCategroy_name());
        if (mSelect == position) {
            convertView.setBackgroundResource(R.drawable.type_item_background_selector);  //选中项背景
            holder.tv_name.setTextColor(Color.parseColor("#323437"));
        } else {
            convertView.setBackgroundResource(R.drawable.bg2);  //其他项背景
            holder.tv_name.setTextColor(Color.parseColor("#323437"));
        }

        convertView.setBackgroundResource(R.color.white);
        if (position==0){
            convertView.setBackgroundResource(R.drawable.lift_back);
        }
        if (position == mSelect) {
            this.view = convertView;
        }
        return convertView;
    }

    public View getFirsiView() {
        return view;
    }

    public void changeSelected(int positon) { //刷新方法
        if (positon != mSelect) {
            mSelect = positon;
            notifyDataSetChanged();
        }
    }

    static class ViewHolder {
        private TextView tv_name;
    }


}
