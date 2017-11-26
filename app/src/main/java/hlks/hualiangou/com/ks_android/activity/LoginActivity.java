package hlks.hualiangou.com.ks_android.activity;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.OnClick;
import hlks.hualiangou.com.ks_android.R;
import hlks.hualiangou.com.ks_android.base.BaseActivity;
import hlks.hualiangou.com.ks_android.config.FragmentBuilder;
import hlks.hualiangou.com.ks_android.fragment.login.LoginFragment;
import hlks.hualiangou.com.ks_android.fragment.login.RegisterFragment;

/**
 * 项目名称:
 * 类描述:登录页面
 */
public class LoginActivity extends BaseActivity {
    @BindView(R.id.Register_img)
    ImageView RegisterImg;
    @BindView(R.id.Register_RelativeLayout)
    RelativeLayout RegisterRelativeLayout;
    @BindView(R.id.login_img)
    ImageView loginImg;
    @BindView(R.id.Login_RelativeLayout)
    RelativeLayout LoginRelativeLayout;
    @BindView(R.id.Login_Register)
    FrameLayout LoginRegister;
    private LoginFragment loginFragment;
    private RegisterFragment registerFragment;

    @Override
    public int getLayoutId() {
        return R.layout.login_activity;
    }

    @Override
    public void initView() {
        registerFragment = new RegisterFragment();
        loginFragment = new LoginFragment();
        FragmentBuilder.getInstance(this).start(LoginFragment.class)
                .add(R.id.Login_Register)
                .commit();
    }

    @Override
    public void loadData() {

    }

    @Override
    public void setListener() {

    }


    @OnClick({R.id.Register_RelativeLayout, R.id.Login_RelativeLayout})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.Register_RelativeLayout:
                getSupportFragmentManager().beginTransaction().
                        replace(R.id.Login_Register,registerFragment)
                        .commitAllowingStateLoss();
                RegisterImg.setVisibility(View.VISIBLE);
                loginImg.setVisibility(View.GONE);
                break;
            case R.id.Login_RelativeLayout:
                getSupportFragmentManager().beginTransaction().
                        replace(R.id.Login_Register,loginFragment).commitAllowingStateLoss();
                RegisterImg.setVisibility(View.GONE);
                loginImg.setVisibility(View.VISIBLE);
                break;
        }
    }
    public void ShowSelectPicture(int type){
        if(type==1){
            RegisterImg.setVisibility(View.VISIBLE);
            loginImg.setVisibility(View.GONE);
        }else if(type==2){
            RegisterImg.setVisibility(View.GONE);
            loginImg.setVisibility(View.VISIBLE);
        }
    }
}
