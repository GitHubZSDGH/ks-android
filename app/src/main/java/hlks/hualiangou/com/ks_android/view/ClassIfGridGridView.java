package hlks.hualiangou.com.ks_android.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * Created by Administrator on 2017/10/25.
 */

public class ClassIfGridGridView extends GridView{

    public ClassIfGridGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ClassIfGridGridView(Context context) {
        super(context);
    }

    public ClassIfGridGridView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);

    }
}