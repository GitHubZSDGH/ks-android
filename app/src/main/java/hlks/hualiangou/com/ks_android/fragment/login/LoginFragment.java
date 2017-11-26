package hlks.hualiangou.com.ks_android.fragment.login;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.tsy.sdk.myokhttp.MyOkHttp;
import com.tsy.sdk.myokhttp.response.GsonResponseHandler;
import com.tsy.sdk.myokhttp.util.ParamsUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import hlks.hualiangou.com.ks_android.R;
import hlks.hualiangou.com.ks_android.activity.LoginActivity;
import hlks.hualiangou.com.ks_android.activity.MainActivity;
import hlks.hualiangou.com.ks_android.base.BaseFragment;
import hlks.hualiangou.com.ks_android.modle.bean.LoginBean;
import hlks.hualiangou.com.ks_android.modle.bean.LoginRespon;
import hlks.hualiangou.com.ks_android.modle.bean.NoRegisterRespon;
import hlks.hualiangou.com.ks_android.modle.url.UrlUtilds;
import hlks.hualiangou.com.ks_android.utils.KeyUtils;
import hlks.hualiangou.com.ks_android.utils.SharedPreferencesUtils;
import hlks.hualiangou.com.ks_android.utils.UI.ForgetLoginPopuwindow;
import hlks.hualiangou.com.ks_android.utils.encryption.MD5Utils;
import hlks.hualiangou.com.ks_android.utils.encryption.NetUtils;
import hlks.hualiangou.com.ks_android.view.LoginPopuwindow;

/**
 * 项目名称:
 * 类描述:
 * 创建人:lenovo
 * 创建时间:2017/11/13
 * 修改人:
 * 修改内容:
 */
public class LoginFragment extends BaseFragment implements View.OnClickListener {
    private EditText mlogin_phone_et;//手机号
    private EditText mlogin_password_et;//密码
    private TextView mforget_tv;//忘记密码按钮
    private Button mlogin_btn;//确认登录按钮
    private View v;
    private String mUserName;//获取手机号
    private String mPassWord;//获取密码
    private String secret;//签名密钥
    private int ret;
    private LoginPopuwindow lp;
    private ForgetLoginPopuwindow forgetLoginPopuwindow;
    private RegisterFragment registerFragment;
    private LoginRespon loginRespon;
    private NoRegisterRespon noRegisterRespon;
    private String TOken;//登录获取的ToKEN
    private String UID;//登录获取UID
    private String time;//当前时间戳
    private List<LoginRespon> list = new ArrayList<LoginRespon>();
    private MyOkHttp myOkHttp;

    @Override
    public int getLayoutId() {
        return R.layout.login_fragment;
    }

    @Override
    public void initView(View view) {
        mlogin_phone_et = (EditText) view.findViewById(R.id.login_phone_et1);
        mlogin_password_et = (EditText) view.findViewById(R.id.login_password_et);
        mforget_tv = (TextView) view.findViewById(R.id.forget_tv);
        mlogin_btn = (Button) view.findViewById(R.id.login_btn);
        Date dt = new Date();
        time = String.valueOf(dt.getTime());
//        mlogin_phone_et.setText("15933269431");
//        mlogin_password_et.setText("123456");
    }

    @Override
    public void loadData() {

    }

    @Override
    public void setListener() {
        mlogin_btn.setOnClickListener(this);
        mforget_tv.setOnClickListener(this);
        mlogin_phone_et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (!editable.toString().equals("") && editable.length() == 11) {
                    PhoneText();//发起网络请求
                }
            }
        });
    }

    //手机号输入请求
    private void PhoneText() {
        mUserName = mlogin_phone_et.getText().toString();//用户名
        String build = ParamsUtils.getInstance()
                .params("api", "user/userValid")
                .params("appid", UrlUtilds.APPID)
                .params("t", time)
                .params("token", "")
                .params("uid", "")
                .params("username", mUserName)
                .build();
              myOkHttp = new MyOkHttp();
              myOkHttp.post()
                .url(UrlUtilds.PhoneText)
                .addParam("s", build)
                .addParam("api", "user/userValid")
                .addParam("appid", UrlUtilds.APPID)
                .addParam("t", time)
                .addParam("token", "")
                .addParam("uid", "")
                .addParam("username", mUserName)
                .tag(this)
                .enqueue(new GsonResponseHandler<LoginBean>() {

                    @Override
                    public void onFailure(int statusCode, String error_msg) {
                        Log.e("TAG", "onFailure==" + error_msg);
                    }

                    @Override
                    public void onSuccess(int statusCode, LoginBean response) {
                        Log.e("TAG", "onsuccful===" + response.toString());


                    }

                    @Override
                    public void onSuccfulString(int code, String message) {
                        if (!TextUtils.isEmpty(message)) {
//                            Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
//                            Log.e("TAG", "onSuccfulString===" + message);
                        }
                    }
                });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.forget_tv://忘记密码
//                Intent intent = new Intent(getActivity(),ForgetPassWordAtivity.class);
//                intent.putExtra("手机号",mUserName);
//                startActivity(intent);
                break;
            case R.id.login_btn://登录
                Login();
                break;
        }
    }

    private void Login() {
        mUserName = mlogin_phone_et.getText().toString();//用户名
        mPassWord = mlogin_password_et.getText().toString();//密码
        final String MD5PassWord = MD5Utils.encrypt(mPassWord);

        String build = ParamsUtils.getInstance()
                .params("api", "user/login")
                .params("appid", UrlUtilds.APPID)
                .params("t", time)
                .params("password", MD5PassWord)
                .params("token", "")
                .params("uid", "")
                .params("username", mUserName)
                .build();
        NetUtils netUtils = new NetUtils(getActivity());
        if (netUtils.isNet()) {
            if (TextUtils.isEmpty(mUserName) && TextUtils.isEmpty(mPassWord)) {
                Toast.makeText(getActivity(), "用户名和密码不能为空", Toast.LENGTH_SHORT).show();
            } else {
                myOkHttp = new MyOkHttp();
                myOkHttp.post()
                        .url(UrlUtilds.LoginUrl)
                        .addParam("s", build)
                        .addParam("api", "user/login")
                        .addParam("appid", UrlUtilds.APPID)
                        .addParam("t", time)
                        .addParam("password", MD5PassWord)
                        .addParam("token", "")
                        .addParam("uid", "")
                        .addParam("username", mUserName)
                        .tag(this)
                        .enqueue(new GsonResponseHandler<LoginBean>() {
                            @Override
                            public void onSuccess(int statusCode, LoginBean response) {
//                                Toast.makeText(getContext(), response.toString(), Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getActivity(),MainActivity.class);
                                intent.putExtra("Token",response.getMsgX().getToken());
                                intent.putExtra("UID",response.getMsgX().getStaffNum());
                                startActivityForResult(intent, 1);
                                String ret = response.getRet();
                                String token = response.getMsgX().getToken();
                                String uid = response.getMsgX().getStaffNum();
                                SharedPreferencesUtils.add(KeyUtils.USER_TOKEN,token);
                                SharedPreferencesUtils.add(KeyUtils.USER_ID,uid);
                                Log.d("LoginFragment","uid====="+ uid);
                            }

                            @Override
                            public void onFailure(int statusCode, String error_msg) {

                            }

                            @Override
                            public void onSuccfulString(int code, String message) {

                            }
                        });

            }
        }


    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    if (ret == 100) {
                        //    Toast.makeText(getActivity(), "请检查用户名密码是否正确", Toast.LENGTH_SHORT).show();
                        forgetLoginPopuwindow = new ForgetLoginPopuwindow(getActivity(), new ForgetLoginPopuwindow.NewOnClickListener() {
                            @Override
                            public void okClickListener() {

                            }
                        });
                        forgetLoginPopuwindow.showAtLocation(mlogin_btn, Gravity.CENTER
                                , 0, 0);
                    } else {
                        Intent intent = new Intent(getActivity(), MainActivity.class);
                        intent.putExtra("Token", TOken);
                        intent.putExtra("UID", UID);
                        startActivityForResult(intent, 1);
                    }
                    break;
                case 1:
                    if (ret == 100) {
                        lp = new LoginPopuwindow(getActivity(), new LoginPopuwindow.LoginOnClickListener() {
                            @Override
                            public void okClickListener() {
                                // forgetLoginPopuwindow.dismiss();
                                registerFragment = new RegisterFragment();
                                getFragmentManager().beginTransaction().
                                        replace(R.id.Login_Register, registerFragment)
                                        .commitAllowingStateLoss();
                                LoginActivity activity = (LoginActivity) getActivity();
                                activity.ShowSelectPicture(1);
                            }
                        });
                        lp.showAtLocation(mlogin_phone_et, Gravity.CENTER
                                , 0, 0);
                    }
                    break;
                case 2:

                    break;

            }
        }
    };
}
