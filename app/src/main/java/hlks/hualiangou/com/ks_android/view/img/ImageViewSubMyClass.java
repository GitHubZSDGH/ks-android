package hlks.hualiangou.com.ks_android.view.img;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * 项目名称:
 * 类描述:
 * 创建时间:2017/12/6
 */
public class ImageViewSubMyClass extends ImageView {
    public ImageViewSubMyClass(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public ImageViewSubMyClass(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ImageViewSubMyClass(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //获取控件需要重新绘制的区域
        Rect rect=canvas.getClipBounds();
        rect.bottom--;
        rect.right--;
        Paint paint=new Paint();
        paint.setColor(Color.parseColor("#30ffffff"));
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);
        canvas.drawRect(rect, paint);
    }
}
