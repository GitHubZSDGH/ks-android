package hlks.hualiangou.com.ks_android.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.PopupWindow;
import android.widget.TextView;

import hlks.hualiangou.com.ks_android.R;


/**
 * Created by Administrator on 2017/10/12.
 */

public class forgetLoginPopuwindow extends PopupWindow{
    private View mMenuView;
    private TextView forget_pop_tv;
    public forgetLoginPopuwindow(Activity context, final NewOnClickListener listener) {
        super(context);
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mMenuView = inflater.inflate(R.layout.forget_login_popu, null);
        forget_pop_tv = (TextView) mMenuView.findViewById(R.id.No_forgister_tv1);
//        forget_pop_tv.setOnClickListener(itemsOnClick);
        forget_pop_tv.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
               listener.okClickListener();
            }
        });
        //设置按钮监听
        //	mMerchant.setOnClickListener(itemsOnClick);

        //设置SelectPicPopupWindow的View
        this.setContentView(mMenuView);
        //设置SelectPicPopupWindow弹出窗体的宽
        this.setWidth(LayoutParams.FILL_PARENT);
        //设置SelectPicPopupWindow弹出窗体的高
        this.setHeight(LayoutParams.FILL_PARENT);
        //设置SelectPicPopupWindow弹出窗体可点击
        this.setFocusable(true);
        //设置SelectPicPopupWindow弹出窗体动画效果
        //  this.setAnimationStyle(R.style.AnimBottom);
        //实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(0x1f000000);
        //设置SelectPicPopupWindow弹出窗体的背景
        this.setBackgroundDrawable(dw);
        //mMenuView添加OnTouchListener监听判断获取触屏位置如果在选择框外面则销毁弹出框
        mMenuView.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {

                int height = mMenuView.findViewById(R.id.forget_pop).getTop();
                int y=(int) event.getY();
                if(event.getAction()==MotionEvent.ACTION_UP){
                    if(y<height){
                        dismiss();
                    }
                }
                return true;
            }
        });

    }


    /* 点击的监听 */
    public interface NewOnClickListener{

        // 确定
        public void okClickListener();
    }
}
