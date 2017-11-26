package hlks.hualiangou.com.ks_android.modle.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;

import java.util.List;

import hlks.hualiangou.com.ks_android.R;

/**
 * Created by Administrator on 2017/10/31.
 * 银行卡列表适配器
 *
 */

public class BackListAdapter extends BaseAdapter {
    private Context context;
    private List<String>backlist ;
    public BackListAdapter(Context context, List<String> backlist) {
        this.backlist = backlist;
        this.context = context;
    }
    @Override
    public int getCount() {
        return backlist.size();
    }

    @Override
    public Object getItem(int i) {
        return backlist.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        ViewHolder holder ;
        if(convertView == null){
           holder = new ViewHolder();
            convertView = View.inflate(context, R.layout.back_list_adapter,null);
            holder.back_item_linear = (LinearLayout) convertView.findViewById(R.id.back_item_linear);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        if(i%3==0){
            holder.back_item_linear.setBackgroundResource(R.drawable.back_item_red);
        }
        if(i%3==1){
            holder.back_item_linear.setBackgroundResource(R.drawable.back_item_green);
        }
        if(i%3==2){
            holder.back_item_linear.setBackgroundResource(R.drawable.back_item_blue);
        }
        return convertView;
    }
    public  static class ViewHolder {
        private LinearLayout back_item_linear;
    }
}
