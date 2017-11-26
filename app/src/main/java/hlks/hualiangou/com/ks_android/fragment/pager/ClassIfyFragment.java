package hlks.hualiangou.com.ks_android.fragment.pager;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.tsy.sdk.myokhttp.response.GsonResponseHandler;
import com.tsy.sdk.myokhttp.util.ParamsUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import hlks.hualiangou.com.ks_android.App;
import hlks.hualiangou.com.ks_android.R;
import hlks.hualiangou.com.ks_android.activity.CommoditiesActivity;
import hlks.hualiangou.com.ks_android.base.BaseAdapterb.BaseRecyclerAdapter;
import hlks.hualiangou.com.ks_android.base.BaseAdapterb.ViewHolder;
import hlks.hualiangou.com.ks_android.base.BaseFragment;
import hlks.hualiangou.com.ks_android.config.FragmentBuilder;
import hlks.hualiangou.com.ks_android.listener.MainListener;
import hlks.hualiangou.com.ks_android.modle.adapter.classIfy.IfyLeftAdapter;
import hlks.hualiangou.com.ks_android.modle.adapter.classIfy.IfyReghtAdapter;
import hlks.hualiangou.com.ks_android.modle.bean.ClassIfygragmentBean;
import hlks.hualiangou.com.ks_android.modle.url.UrlUtilds;
import hlks.hualiangou.com.ks_android.utils.DimenUtils;
import hlks.hualiangou.com.ks_android.utils.encryption.NetUtils;

/**
 * 项目名称:
 * 类描述:
 * 创建人:lenovo
 * 创建时间:2017/11/10
 * 修改人:
 * 修改内容:
 */
public class ClassIfyFragment extends BaseFragment implements AdapterView.OnItemClickListener {
    private ListView lv_left;
    private ScrollView rv_right;
    private ImageView lfyreturn;
    private LinearLayout linearLayout;
    private String time;//当前时间戳
    private List<ClassIfygragmentBean.MsgBean> menuList1 = new ArrayList<>();  //左侧集合
    private List<ClassIfygragmentBean.MsgBean.TwoBean> menuList2 = new ArrayList<>();  //左侧集合
    private List<ClassIfygragmentBean.MsgBean.TwoBean.ThreeBean> threeBeanList = new ArrayList<>();  //左侧集合
    private IfyLeftAdapter ifyLeftAdapter;
    private IfyReghtAdapter ifyReghtAdapter;
    private ClassIfygragmentBean.MsgBean msgBean;
    private ClassIfygragmentBean classIfygragmentBean;
    private View lastView;
    private MainListener mainCLicter;
    private HomePagerFragment homePagerFragment;//首页

    @Override
    public int getLayoutId() {
        return R.layout.class_ify_fragment;
    }

    @Override
    public void initView(View view) {
        lv_left = (ListView) view.findViewById(R.id.lv_left);
        rv_right = (ScrollView) view.findViewById(R.id.rv_right);
        linearLayout = view.findViewById(R.id.category_lin);
        lfyreturn = view.findViewById(R.id.return_lfy);
        lfyreturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentBuilder.getInstance(App.baseActivity)
                        .start(HomePagerFragment.class)
                        .add(R.id.main_home)
                        .commit();
                mainCLicter.onCheckdListener();
//                homePagerFragment = new HomePagerFragment();
//                baseActivity.getSupportFragmentManager().beginTransaction().
//                        replace(R.id.main_home, homePagerFragment)
//                        .commitAllowingStateLoss();
//                StatusBarCompat.setStatusBarColor(baseActivity, getResources()
//                        .getColor(R.color.corlorsearch), true);
            }
        });
        Date dt = new Date();
        time = String.valueOf(dt.getTime());

    }

    @Override
    public void loadData() {
        initOkHttp();

    }

    private void initOkHttp() {
        String build = ParamsUtils.getInstance()
                .params("api", "categroy/getCategroy")
                .params("appid", UrlUtilds.APPID)
                .params("t", time)
                .params("token", "")
                .build();
        NetUtils netUtils = new NetUtils(getActivity());
        if (netUtils.isNet()) {
            App.myOkHttp.post().tag(this)
                    .url(UrlUtilds.categroy)
                    .addParam("s", build)
                    .addParam("api", "categroy/getCategroy")
                    .addParam("appid", UrlUtilds.APPID)
                    .addParam("t", time)
                    .addParam("token", "")
                    .enqueue(new GsonResponseHandler<ClassIfygragmentBean>() {
                        @Override
                        public void onSuccess(int statusCode, ClassIfygragmentBean response) {
                            classIfygragmentBean = response;


                            Log.e("ClassIfyFragment", "response.getMsg():" + response.getMsg());
                            menuList1.addAll(response.getMsg());
                            if (ifyLeftAdapter == null) {
                                ifyLeftAdapter = new IfyLeftAdapter(getActivity(), menuList1);
                                lv_left.setAdapter(ifyLeftAdapter);
                                drawLeftView(classIfygragmentBean.getMsg().get(0).getTwo());
                            } else {

                            }

                        }

                        @Override
                        public void onFailure(int statusCode, String error_msg) {

                        }
                    });

        }
    }

    @Override
    public void setListener() {
        lv_left.setOnItemClickListener(this);
    }

    /**
     * listview点击事件
     *
     * @param adapterView
     * @param view
     * @param i
     * @param l
     */
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        if (lastView == null) {
            lastView = ifyLeftAdapter.getFirsiView();
        } else if (lastView != ifyLeftAdapter.getFirsiView()) {
            lastView = ifyLeftAdapter.getFirsiView();
        }

        lastView.setBackgroundResource(R.drawable.bg2);
        ((TextView) lastView.findViewById(R.id.tv_title)).setTextColor(Color.parseColor("#323437"));
        if (view != null) {
            view.setBackgroundResource(R.drawable.type_item_background_selector);
            ((TextView) view.findViewById(R.id.tv_title)).setTextColor(Color.parseColor("#fd3f3f"));
            ifyLeftAdapter.setmSelect(i);
            ifyLeftAdapter.setView(view);
            lastView = view;
            drawLeftView(classIfygragmentBean.getMsg().get(i).getTwo());

        }

    }

    private void drawLeftView(List<ClassIfygragmentBean.MsgBean.TwoBean> twoBeanList) {

        linearLayout.removeAllViews();
        int length = twoBeanList.size();


        for (int i = 0; i < length; i++) {
            final ClassIfygragmentBean.MsgBean.TwoBean twoBean = twoBeanList.get(i);
            Log.e("catrog", twoBean.toString());
            TextView textView = new TextView(baseActivity);
            textView.setText(twoBean.getCategroy_name());
            textView.setTextColor(baseActivity.getResources().getColor(R.color.color_1a1a1a));
            textView.setPadding(0, 0, 0, (int) DimenUtils.pxToDp(10));
            textView.setGravity(Gravity.LEFT);
            textView.setTextSize(DimenUtils.pxToSp(50));
            RecyclerView recyclerView = new RecyclerView(baseActivity);
            GridLayoutManager manager = new GridLayoutManager(baseActivity, 3);
            recyclerView.setLayoutManager(manager);
            recyclerView.setPadding(0, 0, 0, 0);
            BaseRecyclerAdapter<ClassIfygragmentBean.MsgBean.TwoBean.ThreeBean> baseRecyclerAdapter = new BaseRecyclerAdapter<ClassIfygragmentBean.MsgBean.TwoBean.ThreeBean>(twoBean.getThree(), R.layout.item_grid_category) {

                @Override
                protected void conver(ViewHolder holder, ClassIfygragmentBean.MsgBean.TwoBean.ThreeBean modle, int position) {
                    holder.setText(R.id.item_category_title, modle.getCategroy_name());


                    holder.setRoundImages(R.id.item_category_img, UrlUtilds.IMG_URL + modle.getImage());
                }

            };
            recyclerView.setAdapter(baseRecyclerAdapter);
            baseRecyclerAdapter.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Intent intent = new Intent(getActivity(), CommoditiesActivity.class);
                    intent.putExtra("categroy_id", twoBean.getThree().get(i).getId());
                    startActivity(intent);
//

                }
            });

            linearLayout.addView(textView);
            linearLayout.addView(recyclerView);

        }


    }
}
