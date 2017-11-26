package hlks.hualiangou.com.ks_android.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * Created by Administrator on 2017/10/23.
 */

public class HomePagerGridView extends GridView {

    public HomePagerGridView(Context context) {
        super(context);
    }

    public HomePagerGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public HomePagerGridView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(
                Integer.MAX_VALUE >>2,MeasureSpec.AT_MOST);
        super.onMeasure(expandSpec, expandSpec);
    }
}
