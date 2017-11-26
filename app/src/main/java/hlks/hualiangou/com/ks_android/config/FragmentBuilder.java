package
        hlks.hualiangou.com.ks_android.config;


import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import hlks.hualiangou.com.ks_android.App;
import hlks.hualiangou.com.ks_android.base.BaseActivity;
import hlks.hualiangou.com.ks_android.base.BaseFragment;


/**
 * Created by localadmin on 2017/7/28.
 */

public class FragmentBuilder {
    public static List<BaseFragment> linkList = new ArrayList<>();//存放医患沟通回退栈的集合
    public static List<BaseFragment> worlkList = new ArrayList<>();//存放工作站回退栈集合
    public static List<BaseFragment> personList = new ArrayList<>();//存放患者管理回退栈集合
    public static List<BaseFragment> myList = new ArrayList<>();//存放我的回退栈集合
    private FragmentTransaction transaction;  //Fragment事物
    private boolean isReplace;//是否是替换 true则为添加
    private int viewID;//布局id
    private boolean isLast;//是否添加到自定义回退栈 为true添加

    private FragmentBuilder() {

    }

    public BaseFragment getBaseFragment(Class<? extends BaseFragment> classFragment) {
        return (BaseFragment) manager.findFragmentByTag(classFragment.getSimpleName());
    }

    private static FragmentBuilder fragmentBuilder = new FragmentBuilder();
    private static FragmentManager manager;
    private String simpleName;
    private BaseFragment baseFragment;
//    private Map<String>

    public static FragmentBuilder getInstance(BaseActivity baseActivity) {
        manager = baseActivity.getSupportFragmentManager();
        return fragmentBuilder;
    }

    public static FragmentBuilder getInstance(BaseFragment baseFragment) {
        manager = baseFragment.getChildFragmentManager();
        return fragmentBuilder;
    }

    public FragmentBuilder start(Class<? extends BaseFragment> classFragment) {
        start(classFragment,null);
        return this;
    }
    public FragmentBuilder start(Class<? extends BaseFragment> classFragment,String name){
        isLast = false;
        if(name==null){
            simpleName = classFragment.getSimpleName();
        }else{
            simpleName = name;
        }
        if (manager.findFragmentByTag(simpleName) == null) {
            try {
                baseFragment = classFragment.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        } else {
            baseFragment = (BaseFragment) manager.findFragmentByTag(simpleName);
        }

        return this;
    }

    public void putLast(int viewid) {
        App.lastSparse.put(viewid, baseFragment);
        baseFragment = null;
        simpleName = null;

    }

    public FragmentBuilder add(int viewid) {
        add(viewid, false);
        return this;
    }

    public FragmentBuilder add(int viewid, boolean istoback) {
        transaction = manager.beginTransaction();
        viewID = viewid;
        if (manager.findFragmentByTag(simpleName) == null) {
            transaction.add(viewid, baseFragment, simpleName);
        }
        transaction.show(baseFragment);
        isReplace = true;
        if (!istoback && App.lastSparse.get(viewid) != baseFragment && App.lastSparse.get(viewid) != null) {
            transaction.hide(App.lastSparse.get(viewid));

        }

        return this;
    }

    /**
     *
     */
    public void remove() {
        if (manager.findFragmentByTag(simpleName) != null) {
            transaction = manager.beginTransaction();
            transaction.remove(baseFragment);

            transaction.commit();
//            App.lastSparse.remove(R.id.home_MessageFrame);
            transaction = null;
            baseFragment = null;
            manager = null;

        }

    }

    public void hide(int type) {
        transaction = manager.beginTransaction();
        BaseFragment baseFragment = null;
        try {
            switch (type) {
                case 1:
                    baseFragment = linkList.get(linkList.size() - 1);
                    break;
                case 2:
                    baseFragment = worlkList.get(worlkList.size() - 1);
                    break;
                case 3:
                    baseFragment = personList.get(personList.size() - 1);
                    break;
                case 4:
                    baseFragment = myList.get(myList.size() - 1);
                    break;
            }
        } catch (Exception e) {
            Log.e("YYYY","失败"+e.getMessage());
            return;
        }
        transaction.hide(baseFragment);
        transaction.commit();
        transaction = null;
        baseFragment = null;
    }

    public void hideLast(int viewID) {
        transaction = manager.beginTransaction();
        if (App.lastSparse.get(viewID) != null) {
            transaction.hide(App.lastSparse.get(viewID));
            transaction.commit();

        }
        transaction = null;
    }

    public BaseFragment commit() {
        if (isReplace && !isLast) {
            App.lastSparse.put(viewID, baseFragment);
            Log.e("TAGGGG", baseFragment.getClass().getSimpleName());
            isReplace = false;
        } else {
            isLast = false;
        }
        transaction.commit();
        transaction = null;
        simpleName = null;
        return baseFragment;
    }


    public boolean popTask() {
        return manager.popBackStackImmediate();
    }

    /**
     * 自定义回退栈
     *
     * @param i 回退栈类型  1为加入回退栈 2为加入工作站回退栈  3 加入患者管理回退栈 4为加入我的回退栈
     * @return
     */
    public FragmentBuilder addToback(int i) {
        isLast = true;

        switch (i) {
            case 1:
                if (linkList.isEmpty()) {
                    if (App.lastSparse.get(viewID) != null)
                        transaction.hide(App.lastSparse.get(viewID));
                } else {
                    transaction.hide(linkList.get(linkList.size() - 1));
                }
                linkList.add(baseFragment);
                break;
            case 2:
                if (worlkList.isEmpty()) {
                    if (App.lastSparse.get(viewID) != null)
                        transaction.hide(App.lastSparse.get(viewID));
                } else {
                    transaction.hide(worlkList.get(worlkList.size() - 1));
                }
                worlkList.add(baseFragment);
                break;
            case 3:
                if (personList.isEmpty()) {
                    if (App.lastSparse.get(viewID) != null)
                        transaction.hide(App.lastSparse.get(viewID));
                } else {
                    transaction.hide(personList.get(personList.size() - 1));
                }
                personList.add(baseFragment);
                break;
            case 4:
                if (myList.isEmpty()) {
                    if (App.lastSparse.get(viewID) != null)
                        transaction.hide(App.lastSparse.get(viewID));
                } else {
                    transaction.hide(myList.get(myList.size() - 1));
                }
                myList.add(baseFragment);
                break;
        }
        return this;
    }

    /**
     * 添加到系统回退栈
     *
     * @return
     */
    public FragmentBuilder addToTask() {
        transaction.addToBackStack(simpleName);
//        isLast=  true;
        return this;
    }

    public FragmentBuilder setBundle(Bundle bundle) {
        try {
            baseFragment.setArguments(bundle);
        }catch (Exception e){
        }

        return this;
    }

    /**
     * 开启回退栈 回退
     *
     * @param type   回退栈类型1为加入医患沟通回退栈 2为加入工作站回退栈  3 加入患者管理回退栈 4为加入我的回退栈
     * @param viewID 回退的布局id
     * @return
     */
    public FragmentBuilder removeTask(int type, int viewID) {
        transaction = manager.beginTransaction();
        isLast = true;
        switch (type) {
            //医患沟通
            case 1:
                baseFragment = linkList.get(linkList.size() - 1);
                transaction.remove(baseFragment);
                linkList.remove(linkList.size() - 1);
                if (linkList.isEmpty()) {
                    //为空的时候  显示
                    if (App.lastSparse.get(viewID) != null)
                        transaction.show(App.lastSparse.get(viewID));
                } else {
                    transaction.show(linkList.get(linkList.size() - 1));
                }

                break;
            //工作站
            case 2:
                baseFragment = worlkList.get(worlkList.size() - 1);
                transaction.remove(baseFragment);
                worlkList.remove(worlkList.size() - 1);
                if (worlkList.isEmpty()) {
                    //为空的时候  显示
                    if (App.lastSparse.get(viewID) != null)
                        transaction.show(App.lastSparse.get(viewID));
                } else {
                    transaction.show(worlkList.get(worlkList.size() - 1));
                }
                break;
            //患者管理
            case 3:
                baseFragment = personList.get(personList.size() - 1);
                transaction.remove(baseFragment);
                personList.remove(personList.size() - 1);
                if (personList.isEmpty()) {
                    //为空的时候  显示
                    if (App.lastSparse.get(viewID) != null)
                        transaction.show(App.lastSparse.get(viewID));
                } else {
                    transaction.show(personList.get(personList.size() - 1));
                }
                break;
            //我的
            case 4:
                baseFragment = myList.get(myList.size() - 1);
                transaction.remove(baseFragment);
                myList.remove(myList.size() - 1);
                if (myList.isEmpty()) {
                    //为空的时候  显示
                    if (App.lastSparse.get(viewID) != null)
                        transaction.show(App.lastSparse.get(viewID));

                } else {
                    transaction.show(myList.get(myList.size() - 1));
                }
                break;

        }
        return this;
    }

    public void remove(int type, BaseFragment baseFragment) {
        transaction = manager.beginTransaction();
        switch (type) {
            case 1:
                linkList.remove(baseFragment);
                break;
            case 2:
                worlkList.remove(baseFragment);
                break;
            case 3:
                personList.remove(baseFragment);
                break;
            case 4:
                myList.remove(baseFragment);
                break;
        }
        transaction.hide(baseFragment);
        transaction.remove(baseFragment);
        transaction.commit();
        transaction = null;
    }

    /**
     * 调度线程开始清理
     *
     * @param index
     */
    public void clear(int index) {
        List<BaseFragment> list = new ArrayList<>();

        switch (index) {
            case 1:
                list = linkList;
//                linkList.clear();
                break;
            case 2:
                list = worlkList;
//                worlkList.clear();
                break;
            case 3:
                list = personList;
//                personList.clear();
                break;
            case 4:
                list = myList;
//                myList.clear();
                break;
        }
        final List<BaseFragment> finalList = list;
        new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < finalList.size(); i++) {
                    transaction = manager.beginTransaction();
                    transaction.remove(finalList.get(i));
                    transaction.commit();
                }
            }
        }.run();
        finalList.clear();
        transaction = null;
    }

    /**
     * 清理栈定内存
     *
     * @param type
     */
    public void clearFragments(int type) {
        switch (type) {
            case 1:
                if (linkList.isEmpty()) return;
//                start(linkList.get(linkList.size() - 1).getClass()).putLast(R.id.home_MessageFrame);
                break;
            case 2:
                if (worlkList.isEmpty()) return;
//                start(worlkList.get(worlkList.size() - 1).getClass()).putLast(R.id.home_MessageFrame);
                break;
            case 3:
                if (personList.isEmpty()) return;
//                start(personList.get(personList.size() - 1).getClass()).putLast(R.id.home_MessageFrame);
                break;
            case 4:
                if (myList.isEmpty()) return;
//                start(myList.get(myList.size() - 1).getClass()).putLast(R.id.home_MessageFrame);
                break;
        }
        clear(type);
    }

    /**
     * 查询fragment是否在栈中
     *
     * @param type       查询的类型
     * @param simpleName 查询的Fragment的simplename
     * @return false代表栈中有 true代表没有
     */
    public static boolean seachFragment(int type, String simpleName) {
        List<BaseFragment> list = new ArrayList<>();
        switch (type) {
            case 1:
                list.addAll(linkList);
                break;
            case 2:
                list.addAll(worlkList);
                break;
            case 3:
                list.addAll(personList);
                break;
            case 4:
                list.addAll(myList);
                break;
        }
        if (!list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getClass().getSimpleName().equals(simpleName)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 调用系统回退栈
     */
    public void popTasks() {
        manager.popBackStackImmediate(simpleName, 1);
    }


}
