package com.dhcc.visa.ui.view.home;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.dhcc.visa.R;
import com.dhcc.visa.persenter.VisaServicePresent;
import com.dhcc.visa.ui.adapter.CountyHeaderAdapter;
import com.dhcc.visa.ui.adapter.StartDiscussionAdapter;
import com.dhcc.visa.ui.base.BaseActivity;
import com.dhcc.visa.ui.base.IBaseView;
import com.dhcc.visa.ui.widget.NoScrollGridView;
import com.dhcc.visa.ui.widget.pinyin.CharacterParser;
import com.dhcc.visa.ui.widget.pinyin.Country;
import com.dhcc.visa.ui.widget.pinyin.PinyinComparator;
import com.dhcc.visa.ui.widget.pinyin.SideBar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;

/**
 * Created by m on 2017/4/10.
 * ${describe}
 */

public class VisaServiceActivity extends BaseActivity<IBaseView,VisaServicePresent> implements IBaseView {

    @BindView(R.id.counties_listview)
    ListView counties_lv;

    @BindView(R.id.dis_dialog)
    TextView dis_diglog;

    @BindView(R.id.dis_sidrbar)
    SideBar mSidBar;

    @BindView(R.id.searchview)
    SearchView mSearchView;

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.base_img_left)
    ImageView mIvBack;

    @BindView(R.id.base_toolbar_title)
    TextView mTvTitle;

    /**
     * 汉字转换成拼音的类
     */
    private CharacterParser characterParser;

    private List<Country> sourceDatas = new ArrayList<>();
    private StartDiscussionAdapter adapter;

    @Override
    public int getLayoutResID() {
        return R.layout.activity_visa_service;
    }

    @Override
    protected void initView() {

        mTvTitle.setText("签证服务");

        List<String> hotCounties = new ArrayList<>();
        hotCounties.add("泰国");
        hotCounties.add("日本");
        hotCounties.add("加拿大");
        hotCounties.add("澳大利亚");
        hotCounties.add("美国");
        hotCounties.add("新加坡");

        @SuppressLint("InflateParams")
        View header = LayoutInflater.from(this).inflate(R.layout.item_counties_header, null , false);
        counties_lv.addHeaderView(header);
        NoScrollGridView gridview = (NoScrollGridView) header.findViewById(R.id.hot_counties_gv);
        gridview.setAdapter(new CountyHeaderAdapter(this,hotCounties));

        String[] stringArray = getResources().getStringArray(R.array.countries);
        for (String aStringArray : stringArray) {
            Country country = new Country();
            country.setDisplayName(aStringArray);
            country.setName(aStringArray);
            sourceDatas.add(country);
        }

        // 实例化汉字转拼音类
        characterParser = CharacterParser.getInstance();
        /*
         * 根据拼音来排列ListView里面的数据类
         */
        PinyinComparator pinyinComparator = PinyinComparator.getInstance();
        mSidBar.setTextView(dis_diglog);

        sourceDatas = filledData(sourceDatas); // 过滤数据为有字母的字段
        // 根据a-z进行排序源数据
        Collections.sort(sourceDatas, pinyinComparator);

        adapter = new StartDiscussionAdapter(this, sourceDatas);
        counties_lv.setAdapter(adapter);
        adapter.notifyDataSetChanged();



        initListener();
    }

    private void initListener() {
        // 设置右侧触摸监听
        mSidBar.setOnTouchingLetterChangedListener(new SideBar.OnTouchingLetterChangedListener() {

            @Override
            public void onTouchingLetterChanged(String s) {
                // 该字母首次出现的位置
                int position = adapter.getPositionForSection(s.charAt(0));
                if (position != -1) {
                    counties_lv.setSelection(position - 1);
                }

                if ("热门".equals(s)) {
                    counties_lv.setSelection(0);
                }
            }
        });

        //设置searchview搜索监听
        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (!TextUtils.isEmpty(newText)){
                    setFilter(newText);
                }else{
                    adapter = new StartDiscussionAdapter(VisaServiceActivity.this , sourceDatas);
                    counties_lv.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }
                return false;
            }
        });

        counties_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Country country = (Country) adapter.getItem(position - 1);
                mActivityUtils.showToast(country.getName());
            }
        });
    }
    private List<Country> searchList = new ArrayList<>();
    private void setFilter(String newText) {
        if (!TextUtils.isEmpty(newText)) {
            if (searchList != null && searchList.size() > 0) {
                searchList.clear();
            }
            for (Country country : sourceDatas) {
                String countryName = country.getName();
                if (countryName.contains(newText)) {
                    searchList.add(country);
                }
            }

            adapter = new StartDiscussionAdapter(this , searchList);
            counties_lv.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        }
    }

    @NonNull
    @Override
    public VisaServicePresent createPresenter() {
        return new VisaServicePresent();
    }

    @SuppressLint("DefaultLocale")
    private List<Country> filledData(List<Country> lsit) {
        List<Country> mFriendList = new ArrayList<>();

        for (int i = 0; i < lsit.size(); i++) {
            Country countyrModel = new Country();
            countyrModel.setName(lsit.get(i).getName());
            // 汉字转换成拼音
            String pinyin = characterParser.getSelling(lsit.get(i).getName());

            String sortString = pinyin.substring(0, 1).toUpperCase();

            // 正则表达式，判断首字母是否是英文字母
            if (sortString.matches("[A-Z]")) {
                countyrModel.setLetters(sortString.toUpperCase());
            } else {
                countyrModel.setLetters("#");
            }

            mFriendList.add(countyrModel);
        }
        return mFriendList;

    }



}
