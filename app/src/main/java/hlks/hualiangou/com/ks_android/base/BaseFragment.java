package hlks.hualiangou.com.ks_android.base;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import butterknife.ButterKnife;
import hlks.hualiangou.com.ks_android.App;


public abstract class BaseFragment extends Fragment {
    @IdRes
    private int mTopViewRes = -1;
    private Bundle bundle;
    public View mView;
    protected boolean isNeedBind;
    private ProgressDialog mProgressDialog;

    protected BaseActivity baseActivity;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        isNeedBind = true;
        if (savedInstanceState != null) {
            getSavedInstanceState(savedInstanceState);
        }
//        Log.e("chao", "onCreateView");
        return inflater.inflate(getLayoutId(), container, false);

    }

    protected void getSavedInstanceState(Bundle savedInstanceState) {

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        baseActivity = (BaseActivity) context;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        Log.e("chao", "onViewCreated");
        mView = view;
        if (isNeedBind) {
            ButterKnife.bind(this, view);
        }

        initView(view);
        //解决崩溃问题
        if (getArguments() != null) {
            getBundle(getArguments());
        }
        loadData();

        setListener();

    }

    //传值
    public void getBundle(Bundle bundle) {

    }

    public abstract int getLayoutId();

    public abstract void initView(View view);

    public abstract void loadData();

    public abstract void setListener();

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        cancleRequest();

    }

    //页面隐藏时
    public void onHide() {
        cancleRequest();
    }

    //页面显示时
    public void onShow() {

    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (hidden) {
            onHide();
        } else {
            onShow();
        }
    }

    public void showProgressDialog(Context context, String msg) {
        showProgressDialog(context, msg, true);
    }

    /**
     * 弹出加载等待窗口
     *
     * @param context
     * @param msg
     */
    public void showProgressDialog(Context context, String msg, boolean cancel) {
        try {
            if (null != mProgressDialog) {
                mProgressDialog.dismiss();
            }
            if (!isDetached())
                mProgressDialog = ProgressDialog.show(context, "", msg, true, cancel);
        } catch (WindowManager.BadTokenException e) {
            e.printStackTrace();
        }
    }

    /**
     * 取消ProgressDialog
     */
    public void dismissDialog() {
        try {
            if (null != mProgressDialog) {
                mProgressDialog.dismiss();
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    protected void cancleRequest() {
        App.myOkHttp.cancel(this);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        cancleRequest();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        baseActivity = null;
    }
}
