package hlks.hualiangou.com.ks_android.modle.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import hlks.hualiangou.com.ks_android.R;

/**
 * Created by Administrator on 2017/10/31.
 */

public class BeanDetailAdapter extends BaseAdapter {
    private Context context;
    private List<String>beantetailList;

    public BeanDetailAdapter(Context context , List<String>beantetailList){
            this.context = context;
        this.beantetailList = beantetailList;
    }
    @Override
    public int getCount() {
        return beantetailList.size();
    }

    @Override
    public Object getItem(int i) {
        return beantetailList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        ViewHodler hodler;
        if(convertView==null){
            hodler = new ViewHodler();
            convertView = View.inflate(context, R.layout.bean_detail_adapter,null);
            hodler.macceptance_type = (TextView) convertView.findViewById(R.id.acceptance_type);
            hodler.mrecord_img = (ImageView) convertView.findViewById(R.id.record_img);
            convertView.setTag(hodler);
        }else {
            hodler = (ViewHodler) convertView.getTag();
        }
        if(i%2==0){
            hodler.mrecord_img.setBackgroundResource(R.drawable.recharge_img3);
        }else if(i%2==1){
            hodler.mrecord_img.setBackgroundResource(R.drawable.withdraw_img3);
        }
        if(i%3==0){
            hodler.macceptance_type.setText("已受理");
           // hodler.macceptance_type.setTextColor(Integer.parseInt("#999999"));
            hodler.macceptance_type.setTextColor(Color.parseColor("#999999"));
        }
        if(i%3==1){
            hodler.macceptance_type.setText("等待受理");
            hodler.macceptance_type.setTextColor(Color.parseColor("#6A8CF7"));
        }
        if(i%3==2){
            hodler.macceptance_type.setText("受理失败");
            hodler.macceptance_type.setTextColor(Color.parseColor("#FF5555"));
        }
        return convertView;
    }
    public static class ViewHodler{
         TextView macceptance_type;
        ImageView mrecord_img;
    }
}
