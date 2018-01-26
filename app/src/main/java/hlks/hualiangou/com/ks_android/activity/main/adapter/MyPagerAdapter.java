package hlks.hualiangou.com.ks_android.activity.main.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by lenovo on 2018/1/21.
 */

public class MyPagerAdapter extends FragmentPagerAdapter {
    List<Fragment> list;//ViewPager要填充的fragment列表
    List<String> title;//tab中的title文字列表

    public MyPagerAdapter(FragmentManager fm, List<Fragment> list, List<String>title) {
        super(fm);
        this.list = list;
        this.title = title;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }
    //FragmentPager的标题,如果重写这个方法就显示不出tab的标题内容
    @Override
    public CharSequence getPageTitle(int position) {
        return title.get(position);
    }
}
