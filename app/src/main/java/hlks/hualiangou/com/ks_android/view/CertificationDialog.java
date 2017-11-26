package hlks.hualiangou.com.ks_android.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;

import hlks.hualiangou.com.ks_android.R;


/**
 * Created by Administrator on 2017/10/30.
 */

public class CertificationDialog extends PopupWindow {

    private View mMenuView;

    private TextView mVerify_Now_tv;//立即验证
    private TextView mclose_real_name;//取消对话框
    public CertificationDialog(Activity context, View.OnClickListener itemsOnClick) {
        super(context);
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mMenuView = inflater.inflate(R.layout.cartification_dialog, null);
       // textView = (TextView) mMenuView.findViewById(R.id.dialog_tv);
        mVerify_Now_tv  = (TextView) mMenuView.findViewById(R.id.Verify_Now_tv);
        mclose_real_name = (TextView) mMenuView.findViewById(R.id.close_real_name);
        mVerify_Now_tv.setOnClickListener(itemsOnClick);
        mclose_real_name.setOnClickListener(itemsOnClick);
        //   textView.setOnClickListener(itemsOnClick);
        //设置按钮监听
        //	mMerchant.setOnClickListener(itemsOnClick);

        //设置SelectPicPopupWindow的View
        this.setContentView(mMenuView);
        //设置SelectPicPopupWindow弹出窗体的宽
        this.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        //设置SelectPicPopupWindow弹出窗体的高
        this.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
        //设置SelectPicPopupWindow弹出窗体可点击
        this.setFocusable(true);
        //设置SelectPicPopupWindow弹出窗体动画效果
        this.setAnimationStyle(R.style.AnimBottom);
        //实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(0x1f000000);
        //设置SelectPicPopupWindow弹出窗体的背景
        this.setBackgroundDrawable(dw);
        //mMenuView添加OnTouchListener监听判断获取触屏位置如果在选择框外面则销毁弹出框
        mMenuView.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {

                int height = mMenuView.findViewById(R.id.Verify_Linear).getTop();
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
}
