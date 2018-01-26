package com.tsy.sdk.myokhttp.util;

import android.util.Log;

import java.net.URLEncoder;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * 项目名称:
 * 类描述:
 * 创建人:lenovo
 * 创建时间:2017/11/10
 * 修改人:
 * 修改内容:
 */
public class ParamsUtils {
    private Map<String, String> map;

    private ParamsUtils() {
    }

    private static ParamsUtils paramsUtils = new ParamsUtils();

    public static ParamsUtils getInstance() {

        return paramsUtils;

    }

    public ParamsUtils params(String key, String value) {
        if (map == null) {
            map = new TreeMap<>(new Comparator<String>() {
                @Override
                public int compare(String s, String t1) {
                    return s.compareTo(t1);
                }
            });

        }
        map.put(key, value);

        return this;
    }

    public String build() {
        StringBuilder sb = new StringBuilder();
             sb.append("&");
        if (map != null && !map.isEmpty()) {
            for (String key : map.keySet()) {
                sb.append(key).append("=").append(map.get(key)).append("&");
            }
        }

        sb = sb.deleteCharAt(sb.length() - 1);
        String trim = sb.toString().replace(" ","");
        Log.e("TAG","http&===="+sb.toString());
        String stt = URLEncoder.encode(trim);
        String construct_key = ModelUtilds.construct_key;//签名密钥
        if (construct_key.contains("-_")) {
            construct_key = construct_key.replaceAll("-_", "+/");
        }
        String stringha = HMACSHA1.hmac_sha1(construct_key, stt);
        Log.e("ParamsUtils", "s===="+stringha);
        map.clear();
        return stringha.trim();

    }
}
