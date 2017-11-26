package hlks.hualiangou.com.ks_android.view.bannerpager;

import android.content.Context;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

import hlks.hualiangou.com.ks_android.R;


/**
 * Created by shijian
 * version: 1.1
 * updatetime: 2015-12-2
 */
public class BannerPager extends RelativeLayout {

    public BannerPager(Context context) {
        super(context);
        mContext = context;

        init();
    }

    public BannerPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        init();
    }

    Context mContext;
    Handler mHandler = new Handler();

    CircleIndicator mIndicator;
    ViewPager mViewPager;
    ImageAdapter mAdapter;
    List<BannerViewData> mRealList;

    int currentItem;
    int time = 2000;

    OnBannerListener onBannerListener;

    @SuppressWarnings("deprecation")
    private void init() {
        View rootView = inflate(mContext, R.layout.layout_banner_pager, this);
        mIndicator = (CircleIndicator) rootView.findViewById(R.id.indicator);
        mViewPager = (ViewPager) rootView.findViewById(R.id.viewpager);
        mViewPager.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        mAdapter = new ImageAdapter();
        mViewPager.setAdapter(mAdapter);
        mViewPager.setOnPageChangeListener(new OnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                currentItem = position;
            }

            @Override
            public void onPageScrolled(int position, float arg1, int arg2) {
                if (mRealList != null && mRealList.size() > 0) {
                    int realIndex = position - 1;
                    if (realIndex >= mRealList.size()) {
                        realIndex = 0;
                    } else if (realIndex < 0) {
                        realIndex = mRealList.size() - 1;
                    }
                    if (realIndex == mRealList.size() - 1 && arg1 != 0) {
                    } else {
                        mIndicator.onPageScrolled(realIndex, arg1, arg2);
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
                if (mRealList != null && mRealList.size() > 0) {
                    switch (arg0) {
                        case 0:
                            int pageIndex = currentItem;
                            if (currentItem == 0) {
                                pageIndex = mRealList.size();
                            } else if (currentItem == mRealList.size() + 1) {
                                pageIndex = 1;
                            }
                            if (currentItem != pageIndex) {
                                mViewPager.setCurrentItem(pageIndex, false);
                            }
                            mIndicator.onPageSelected(pageIndex - 1);
                            mHandler.removeCallbacks(autoNextRunnable);
                            mHandler.postDelayed(autoNextRunnable, time);
                            break;
                        case 1:
                            mHandler.removeCallbacks(autoNextRunnable);
                            break;
                    }
                }
            }
        });
        mIndicator.setSize(0);
    }

    public ViewPager getViewPager() {
        return mViewPager;
    }

    public void setOnBannerListener(OnBannerListener listener) {
        onBannerListener = listener;
    }

    @SuppressWarnings("deprecation")
    public void setData(final List<BannerViewData> list) {
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                list.get(i).setRealIndex(i);
            }
            mRealList = list;
            List<BannerViewData> newList = new ArrayList<BannerViewData>();
            if (list.size() > 1) {
                newList.add(list.get(list.size() - 1));
                newList.addAll(list);
                newList.add(list.get(0));
            } else {
                newList.addAll(list);
            }
            mIndicator.setSize(list.size());
            mAdapter.setList(newList);
            mHandler.removeCallbacks(autoNextRunnable);
            if (list.size() > 1) {
                mViewPager.setCurrentItem(1, false);
                mHandler.postDelayed(autoNextRunnable, time);
            }
        }
    }

    Runnable autoNextRunnable = new Runnable() {
        @Override
        public void run() {
            currentItem++;
            mViewPager.setCurrentItem(currentItem);
            if (currentItem >= mRealList.size() + 1) {
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        currentItem = 1;
                        mViewPager.setCurrentItem(currentItem, false);
                    }
                }, 1000);
            }
            mHandler.removeCallbacks(autoNextRunnable);
            mHandler.postDelayed(autoNextRunnable, time);
        }
    };

    private class ImageAdapter extends PagerAdapter {

        List<ImageView> viewlist = new ArrayList<ImageView>();

        public void setList(List<BannerViewData> list) {
            viewlist.clear();
            for (final BannerViewData data : list) {
                ImageView imageView = new ImageView(mContext);
                imageView.setScaleType(ScaleType.CENTER_CROP);
                imageView.setLayoutParams(new ViewGroup.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
                imageView.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (onBannerListener != null) {
                            onBannerListener.onClick(data.getRealIndex(), data);
                        }
                    }
                });

//                if (!StringUtils.isEmpty(data.getImgUrl())) {
//
//                    Glide.with(mContext).
//                            load(data.getImgUrl()).
//                            diskCacheStrategy(DiskCacheStrategy.ALL)
//                            .centerCrop()
//                            .error(R.drawable.default_errow).
//                            into(imageView);
//                } else {
//                    imageView.setImageResource(R.drawable.default_errow);
//                }

                viewlist.add(imageView);

            }
            notifyDataSetChanged();
        }

        @Override
        public int getCount() {
            return viewlist.size();
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1;
        }

        @Override
        public void destroyItem(View container, int position, Object object) {
            ((ViewPager) container).removeView(viewlist.get(position % viewlist.size()));
        }

        public Object instantiateItem(View container, int position) {
            View view = viewlist.get(position % viewlist.size());
            ((ViewPager) container).addView(view, 0);
            return view;
        }
    }

    public void onPause() {
        mHandler.removeCallbacks(autoNextRunnable);
    }

    public void onResume() {
        if (mRealList != null && mRealList.size() > 0) {
            mHandler.removeCallbacks(autoNextRunnable);
            mHandler.postDelayed(autoNextRunnable, time);
        }
    }

    @Override
    public void setOnTouchListener(OnTouchListener l) {
        super.setOnTouchListener(l);
        mViewPager.setOnTouchListener(l);
    }


    public interface OnBannerListener {
        public void onClick(int position, BannerViewData obj);
    }
}
