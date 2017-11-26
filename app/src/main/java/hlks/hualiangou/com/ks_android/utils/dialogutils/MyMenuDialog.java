package hlks.hualiangou.com.ks_android.utils.dialogutils;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import hlks.hualiangou.com.ks_android.R;


/**
 * Created by weidong_li on 2017/10/8.
 */

public class MyMenuDialog extends Dialog {
    public MyMenuDialog(Context context) {
        this(context, R.style.MyDialog);
    }

    public MyMenuDialog(final Context context, int themeResId) {
        super(context, themeResId);
        final View contentView = getLayoutInflater().inflate(R.layout.activity_msg_dialog, null);
//        contentView.findViewById(R.id.msg_dialog_Deleteall).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getContext(), "你好", Toast.LENGTH_SHORT).show();
//                dismiss();
//            }
//        });
        super.setContentView(contentView);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 预先设置Dialog的一些属性
        Window dialogWindow = getWindow();
        WindowManager.LayoutParams p = dialogWindow.getAttributes(); // 获取对话框当前的参数值
        //获取屏幕的高度和宽带
        WindowManager m = getWindow().getWindowManager();
        Display d = m.getDefaultDisplay();
        DisplayMetrics outMetrics = new DisplayMetrics();
        d.getMetrics(outMetrics);
        //设置WindowManager.LayoutParams
       // p.height = (int) (outMetrics.heightPixels * 0.6);
       // p.width = (int) (outMetrics.widthPixels * 0.4);
        //根据s随意来的高度来设置x轴偏移量
        p.x = (int) (15 * outMetrics.density);
        //根据Title的高度来设置y轴偏移量
        p.y = (int) (40 * outMetrics.density);
        p.gravity = Gravity.RIGHT | Gravity.TOP;
        dialogWindow.setAttributes(p);
    }

}
