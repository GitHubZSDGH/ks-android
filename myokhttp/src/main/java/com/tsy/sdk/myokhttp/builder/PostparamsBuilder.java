package com.tsy.sdk.myokhttp.builder;

import android.util.Log;

import com.tsy.sdk.myokhttp.MyOkHttp;
import com.tsy.sdk.myokhttp.callback.MyCallback;
import com.tsy.sdk.myokhttp.response.IResponseHandler;
import com.tsy.sdk.myokhttp.util.LogUtils;
import com.tsy.sdk.myokhttp.util.ParamsUtils;

import java.util.Map;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * post builder
 * Created by tsy on 16/9/18.
 */
public class PostparamsBuilder extends OkHttpRequestBuilderHasParam<PostparamsBuilder> {

    private String mJsonParams = "";

    public PostparamsBuilder(MyOkHttp myOkHttp) {
        super(myOkHttp);
    }

    /**
     * json格式参数
     * @param json
     * @return
     */
    public PostparamsBuilder jsonParams(String json) {
        this.mJsonParams = json;
        return this;
    }

    @Override
    public void enqueue(IResponseHandler responseHandler) {
        try {
            if(mUrl == null || mUrl.length() == 0) {
                throw new IllegalArgumentException("url can not be null !");
            }

            Request.Builder builder = new Request.Builder().url(mUrl);
            appendHeaders(builder, mHeaders);

            if (mTag != null) {
                builder.tag(mTag);
            }

            if(mJsonParams.length() > 0) {      //上传json格式参数
                RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), mJsonParams);
                builder.post(body);
            } else {        //普通kv参数
                FormBody.Builder encodingBuilder = new FormBody.Builder();
                appendParams(encodingBuilder, mParams);
                builder.post(encodingBuilder.build());
            }

            Request request = builder.build();
            Log.e("TAGDSDS","网址+----"+request.url().toString());
            mMyOkHttp.getOkHttpClient()
                    .newCall(request)
                    .enqueue(new MyCallback(responseHandler));
        } catch (Exception e) {
            LogUtils.e("Post enqueue error:" + e.getMessage());
            responseHandler.onFailure(0, e.getMessage());
        }
    }

    //append params to form builder
    private void appendParams(FormBody.Builder builder, Map<String, String> params) {
        ParamsUtils instance = ParamsUtils.getInstance();
        if (params != null && !params.isEmpty()) {
            for (String key : params.keySet()) {
                builder.add(key, params.get(key));
                instance.params(key, params.get(key));
            }
            String build = instance.build();
            Log.e("Myokhttp", "paramas===>" + params.toString());
            builder.add("s",build);
        }
    }
}
