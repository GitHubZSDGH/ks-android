package hlks.hualiangou.com.ks_android.view;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by cuijl on 2017/2/9.
 */

public abstract class BaseDevrisLayoutView extends LinearLayout {

    protected Context mContext;
    //头部View

    public BaseDevrisLayoutView(Context context) {
        super(context);
        mContext = context;

//        setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
        View view = initView();


        if (view != null) {
            addView(view);
        }
    }



    @SuppressWarnings("unchecked")
    public <T extends View> T $(int id) {
        return (T) super.findViewById(id);
    }

    @SuppressWarnings("unchecked")
    public <T extends View> T $(int id, OnClickListener listener) {
        T t = (T) super.findViewById(id);
        t.setOnClickListener(listener);
        return t;
    }

    @SuppressWarnings("unchecked")
    public <T extends View> T $(View view, int id) {
        return (T) view.findViewById(id);
    }

    @SuppressWarnings("unchecked")
    public <T extends View> T $(View view, int id, OnClickListener listener) {
        T t = (T) view.findViewById(id);
        t.setOnClickListener(listener);
        return t;
    }
    public abstract View initView();

}
