package com.hloong.news.ui.main.fragment;


import android.support.v4.app.Fragment;

import com.aspsine.irecyclerview.IRecyclerView;
import com.hloong.base.base.BaseFragment;
import com.hloong.base.widget.LoadingTip;
import com.hloong.news.R;
import com.hloong.news.bean.ZhihuBeforeNews;
import com.hloong.news.bean.ZhihuLastsNews;
import com.hloong.news.ui.zhihu.adapter.ZhihuListAdapter;
import com.hloong.news.ui.zhihu.contract.ZhihuListContract;
import com.hloong.news.ui.zhihu.model.ZhihuListModel;
import com.hloong.news.ui.zhihu.presenter.ZhihuListPresenter;

import butterknife.Bind;

/**
 * A simple {@link Fragment} subclass.
 */
public class ZhihuMainFragment extends BaseFragment<ZhihuListPresenter,ZhihuListModel> implements ZhihuListContract.View {
    @Bind(R.id.irc)
    IRecyclerView irc;
    @Bind(R.id.loadedTip)
    LoadingTip loadedTip;
    ZhihuListAdapter adapter;
    @Override
    protected void initPresenter() {

    }

    @Override
    protected void initView() {
        adapter = new ZhihuListAdapter(getContext(),R.layout.item_zhihu);
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_zhihu_main;
    }

    @Override
    public void scorlltoTop() {

    }

    @Override
    public void returnTopData(ZhihuLastsNews zhihuLastsNews) {

    }

    @Override
    public void returnMoreData(String date, ZhihuBeforeNews zhihuBeforeNews) {

    }

    @Override
    public void showLoading(String title) {

    }

    @Override
    public void stopLoading() {

    }

    @Override
    public void showErrorTip(String msg) {

    }
}
