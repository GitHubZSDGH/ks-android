package hlks.hualiangou.com.ks_android.fragment.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.tsy.sdk.myokhttp.MyOkHttp;
import com.tsy.sdk.myokhttp.response.GsonResponseHandler;
import com.tsy.sdk.myokhttp.response.IResponseHandler;
import com.tsy.sdk.myokhttp.util.ParamsUtils;
import com.tsy.sdk.myokhttp.util.ToastUtils;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import hlks.hualiangou.com.ks_android.R;
import hlks.hualiangou.com.ks_android.activity.LoginActivity;
import hlks.hualiangou.com.ks_android.activity.zhengce.PrivacyPolicy;
import hlks.hualiangou.com.ks_android.activity.zhengce.ZhuCePolicy;
import hlks.hualiangou.com.ks_android.base.BaseFragment;
import hlks.hualiangou.com.ks_android.config.FragmentBuilder;
import hlks.hualiangou.com.ks_android.modle.bean.LoginBean;
import hlks.hualiangou.com.ks_android.modle.bean.NoRegisterRespon;
import hlks.hualiangou.com.ks_android.modle.url.UrlUtilds;
import hlks.hualiangou.com.ks_android.utils.encryption.MD5Utils;
import hlks.hualiangou.com.ks_android.utils.encryption.ModelUtilds;
import hlks.hualiangou.com.ks_android.utils.encryption.NetUtils;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import okhttp3.Response;

import static hlks.hualiangou.com.ks_android.App.myOkHttp;

/**
 * 项目名称:
 * 类描述:
 * 创建人:lenovo
 * 创建时间:2017/11/13
 * 修改人:
 * 修改内容:
 */
public class RegisterFragment extends BaseFragment implements View.OnClickListener {
    @BindView(R.id.register_phone)//注册手机号
            EditText registerPhone;
    @BindView(R.id.Code_et)//验证码
            EditText CodeEt;
    @BindView(R.id.get_code)//获取验证码按钮
            TextView getCode;
    @BindView(R.id.Register_passWord)//密码
            EditText RegisterPassWord;
    @BindView(R.id.delete_password)//删除密码
            ImageView deletePassword;
    @BindView(R.id.open_eyes)//看见密码按钮
            ImageView openEyes;
    @BindView(R.id.affirm_Register_passWord)//确认密码
            EditText affirmRegisterPassWord;
    @BindView(R.id.register_Btn)//注册按钮
            Button registerBtn;
    @BindView(R.id.register_Linear)
    LinearLayout registerLinear;
    Unbinder unbinder;
    @BindView(R.id.register_xieyi)
    TextView registerXieyi;
    @BindView(R.id.yinsi_xieyi)
    TextView yinsiXieyi;
    Unbinder unbinder1;

    //成员变量
    private View v;
    private boolean canSee;//密码可见不可见
    private Timer timer;
    private int recLen = 60;
    private String Register_phone;//获取注册手机号码
    private String Register_PassWord;//获取注册密码
    private String OK_RegisterPassWord;//获取确认密码
    private String time;//时间戳
    private String secret;//签名密钥
    private NoRegisterRespon noRegisterRespon;
    private int ret;
    private NetUtils netUtils;//判断是否有网工具类
    private String mobile;
    /**
     * 随机生成的验证码
     */
    private int numcode;
    private Disposable disposable;

    @Override
    public int getLayoutId() {
        return R.layout.register_fragment;
    }

    @Override
    public void initView(View view) {
        timer = new Timer();
        Date dt = new Date();
        time = String.valueOf(dt.getTime());
        netUtils = new NetUtils(getActivity());
        setOnClick();
    }

    @Override
    public void loadData() {

    }

    @Override
    public void setListener() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        unbinder.unbind();
        unbinder1.unbind();
    }

    private void setOnClick() {
        openEyes.setOnClickListener(this);
        getCode.setOnClickListener(this);
        deletePassword.setOnClickListener(this);
        registerBtn.setOnClickListener(this);
        RegisterPassWord.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                openEyes.setVisibility(View.VISIBLE);
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }

    //手机号输入请求
    private void PhoneText() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.get_code:
                mobile = registerPhone.getText().toString();
                if (!TextUtils.isEmpty(registerPhone.getText())) {

                    Register_phone = registerPhone.getText().toString();//用户名
                    String build = ParamsUtils.getInstance()
                            .params("api", "user/userValid")
                            .params("appid", UrlUtilds.APPID)
                            .params("t", time)
                            .params("token", "")
                            .params("uid", "")
                            .params("username", Register_phone)
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
                            .addParam("username", Register_phone)
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
                                    if ("存在".equals(message)) {
                                        ToastUtils.showSingleToast("此用户已注册");
                                    } else {
                                        note();

                                        final int count = 60;
                                        Observable<Long> longObservable = Observable.interval(0, 1, TimeUnit.SECONDS)
                                                .take(count + 1)
                                                .map(new Function<Long, Long>() {
                                                    @Override
                                                    public Long apply(@NonNull Long aLong) throws Exception {
                                                        return count - aLong;
                                                    }
                                                }).doOnSubscribe(new Consumer<Disposable>() {
                                                    @Override
                                                    public void accept(Disposable disposable) throws Exception {
                                                        getCode.setEnabled(false);
                                                    }
                                                }).observeOn(AndroidSchedulers.mainThread());//操作UI主要在UI线程

                                        longObservable.subscribe(new Observer<Long>() {
                                            @Override
                                            public void onSubscribe(@NonNull Disposable d) {
                                                disposable = d;
                                            }

                                            @Override
                                            public void onNext(@NonNull Long aLong) {
                                                try {
                                                    getCode.setText(aLong + "秒后重发");
                                                } catch (Exception e) {

                                                }
                                            }

                                            @Override
                                            public void onError(@NonNull Throwable e) {

                                            }

                                            @Override
                                            public void onComplete() {
                                                getCode.setText("发送验证码");
                                                getCode.setEnabled(true);
                                            }
                                        });
                                        getCode.setEnabled(false);


                                    }
                                }
                            });


                } else {
                    Toast.makeText(getActivity(), "手机号码不能为空", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.open_eyes:
                if (canSee == false) {
                    //如果是不能看到密码的情况下，
                    RegisterPassWord.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    canSee = true;
                } else {
                    //如果是能看到密码的状态下
                    RegisterPassWord.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    canSee = false;
                }
                break;
            case R.id.delete_password:
                RegisterPassWord.setText("");
                break;
            case R.id.register_Btn:
                Register();
                break;
            default:
         /*   case R.id.Register_passWord:
                mOpen_eyes.setVisibility(View.VISIBLE);
                break;*/
        }
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    if (ret == 0) {
                        Toast.makeText(getActivity(), "注册成功，请登录使用", Toast.LENGTH_SHORT).show();
                        RegisterFragment loginFragment = new RegisterFragment();
                        FragmentBuilder.getInstance(baseActivity)
                                .start(LoginFragment.class)
                                .add(R.id.Login_Register)
                                .commit();
                        LoginActivity activity = (LoginActivity) getActivity();
                        activity.ShowSelectPicture(2);
                    } else if (ret == -100) {
                        Toast.makeText(getActivity(), "用户已注册", Toast.LENGTH_SHORT).show();
                    }
                    break;

            }
        }
    };
    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    recLen--;
                    getCode.setText(recLen + "s");
                    if (recLen < 0) {
                        timer.cancel();
                        getCode.setText("获取验证码");
                        getCode.setTextSize(12);
                        getCode.setEnabled(true);
                        getCode.setBackgroundResource(R.drawable.text_code);
                    }

                }
            });
        }
    };

    /**
     * 获取验证码
     */
    private void note() {
        final String MD5PassWord = MD5Utils.encrypt("1qa2ws3ed1QA2WS3ED");
        mobile = registerPhone.getText().toString();
        numcode = (int) ((Math.random() * 9 + 1) * 100000);
        // final String Md5PassWord = MD
        final String content = URLEncoder.encode("【华联购】尊敬的用户您好：欢迎注册华联购平台，您此次注册的验证码为:" + numcode +
                "，工作人员不会向您索取，请勿透漏他人。");
        if (netUtils.isNet()) {
            myOkHttp
                    .post()
                    .url(ModelUtilds.NotURL)
                    .addParam("username", "hlks")
                    .addParam("password_md5", MD5PassWord)
                    .addParam("apikey", "931171edcdc841ed32b74929580b6f26")
                    .addParam("mobile", mobile)
                    .addParam("content", content)
                    .addParam("encode", "UTF-8")
                    .enqueue(new IResponseHandler() {
                        @Override
                        public void onSuccess(Response response) {


                            try {
                                Log.e("RegisterFragment", response.body().string());

                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void onFailure(int statusCode, String error_msg) {

                        }

                        @Override
                        public void onProgress(long currentBytes, long totalBytes) {

                        }
                    });


        }
    }

    private void Register() {

        /**
         *   String string = "&api=user/registerUser" + "&appid=" + ModelUtilds.APPID + "&password=" + Register_PassWord
         + "&phone=" + Register_phone + "&t=" +time+ "&token=" + "" + "&uid=" + "" ;
         */
        Register_phone = registerPhone.getText().toString();//注册用户名
        Register_PassWord = RegisterPassWord.getText().toString();//注册密码
        OK_RegisterPassWord = affirmRegisterPassWord.getText().toString();
        final String viriton = CodeEt.getText().toString();
        if (!Register_PassWord.equals(OK_RegisterPassWord)) {
            Toast.makeText(getContext(), R.string.regist_noPwd_toast, Toast.LENGTH_SHORT).show();
            return;
        }
        if (!String.valueOf(numcode).equals(viriton)) {
            Toast.makeText(getContext(), R.string.regist_virrton_no_toast, Toast.LENGTH_SHORT).show();
            return;
        }
        String build = ParamsUtils.getInstance()
                .params("api", "user/registerUser")
                .params("appid", UrlUtilds.APPID)
                .params("password", Register_PassWord)
                .params("phone", Register_phone)
                .params("t", time)
                .params("token", "")
                .params("uid", "")
                .build();
        Log.e("TAG", "build===" + build);
        MyOkHttp myOkHttp = new MyOkHttp();
        myOkHttp
                .post()
                .url(UrlUtilds.RegisterPhone)
                .addParam("api", "user/registerUser")
                .addParam("appid", UrlUtilds.APPID)
                .addParam("password", Register_PassWord)
                .addParam("phone", Register_phone)
                .addParam("s", build)
                .addParam("t", time)
                .addParam("token", "")
                .addParam("uid", "")
                .enqueue(new GsonResponseHandler<NoRegisterRespon>() {
                    @Override
                    public void onSuccess(int statusCode, NoRegisterRespon response) {
                        switch (response.getRet()) {
                            //改用户已被注册
                            case "100":
                                Toast.makeText(getContext(), R.string.regist_now_toast, Toast.LENGTH_SHORT).show();

                                break;
                            //注册成功
                            case "0":
                                Toast.makeText(getContext(), R.string.regist_toast, Toast.LENGTH_SHORT).show();
                                Message msg = new Message();
                                msg.what = 0;
                                handler.sendMessage(msg);
                                break;
                            default:
//                                if (!TextUtils.isEmpty(response.getMsg())) {
//                                    Toast.makeText(getContext(), response.getMsg(), Toast.LENGTH_SHORT).show();
//                                }
                        }
                    }

                    @Override
                    public void onFailure(int statusCode, String error_msg) {

                    }

                    @Override
                    public void onSuccfulString(int code, String message) {
                        super.onSuccfulString(code, message);


                    }
                });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder1 = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @OnClick({R.id.register_xieyi, R.id.yinsi_xieyi})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.register_xieyi:
                Intent intent = new Intent(baseActivity, ZhuCePolicy.class);
                startActivity(intent);
                break;
            case R.id.yinsi_xieyi:
                Intent intent1 = new Intent(baseActivity, PrivacyPolicy.class);
                startActivity(intent1);
                break;
        }
    }
}
