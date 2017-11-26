package com.tsy.sdk.myokhttp.response;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.internal.$Gson$Types;
import com.tsy.sdk.myokhttp.MyOkHttp;
import com.tsy.sdk.myokhttp.util.LogUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Gson类型的回调接口
 * Created by tsy on 16/8/15.
 */
public abstract class GsonResponseHandler<T> implements IResponseHandler {

    private Type mType;

    public GsonResponseHandler() {
        Type myclass = getClass().getGenericSuperclass();    //反射获取带泛型的class
        if (myclass instanceof Class) {
            throw new RuntimeException("Missing type parameter.");
        }
        ParameterizedType parameter = (ParameterizedType) myclass;      //获取所有泛型
        mType = $Gson$Types.canonicalize(parameter.getActualTypeArguments()[0]);  //将泛型转为type
    }

    private Type getType() {
        return mType;
    }

    @Override
    public final void onSuccess(final Response response) {
        ResponseBody responseBody = response.body();
        String responseBodyStr = "";

        try {
            responseBodyStr = responseBody.string();
        } catch (IOException e) {
            e.printStackTrace();
            LogUtils.e("onResponse fail read response body");
            MyOkHttp.mHandler.post(new Runnable() {
                @Override
                public void run() {
                    onFailure(response.code(), "fail read response body");
                }
            });
            return;
        } finally {
            responseBody.close();
        }


//        final String finalResponseBodyStr = "{\"code\":\"200\"," +
//                "\"message\":{\"name\":\"txl\",\"age\":\"23\"}}";
        final String finalResponseBodyStr = responseBodyStr;

        try {
            MyOkHttp.mHandler.post(new Runnable() {
                @Override
                public void run() {
                    Gson gson = new Gson();
//                    try {
//                        if ("200".equals(new JSONObject(finalResponseBodyStr).optString("code"))) {
//
//                            gson = new Gson();
//
//                        }else{
//                            gson = new GsonBuilder().setVersion(2.0).create();
//
//                        }
//
//                    } catch (JSONException e) {
//                        gson = new Gson();
//                    }
                    Log.e("TAGSS", finalResponseBodyStr + "");
                    try {
                        onSuccess(response.code(), (T) gson.fromJson(finalResponseBodyStr, getType()));

                    } catch (Exception e) {
                        try {
                            onSuccfulString(response.code(),new JSONObject(finalResponseBodyStr).optString("msg"));
                        } catch (JSONException e1) {
                           onFailure(5,"gson -- llegst");
                        }
                        e.printStackTrace();
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            LogUtils.e("onResponse fail parse gson, body=" + finalResponseBodyStr);
            MyOkHttp.mHandler.post(new Runnable() {
                @Override
                public void run() {
                    onFailure(response.code(), "fail parse gson, body=" + finalResponseBodyStr);
                }
            });

        }
    }

    public abstract void onSuccess(int statusCode, T response);

    @Override
    public void onProgress(long currentBytes, long totalBytes) {

    }

    public void onSuccfulString(int code, String message) {


    }
}
