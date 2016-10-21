package com.hloong.news.ui.main.fragment;


import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.aspsine.irecyclerview.IRecyclerView;
import com.aspsine.irecyclerview.OnLoadMoreListener;
import com.aspsine.irecyclerview.OnRefreshListener;
import com.aspsine.irecyclerview.animation.ScaleInAnimation;
import com.hloong.base.base.BaseFragment;
import com.hloong.base.utils.TimeUtil;
import com.hloong.base.widget.LoadingTip;
import com.hloong.base.widget.NormalTitleBar;
import com.hloong.news.R;
import com.hloong.news.app.AppConstant;
import com.hloong.news.bean.Story;
import com.hloong.news.bean.ZhihuBeforeNews;
import com.hloong.news.bean.ZhihuLastsNews;
import com.hloong.news.ui.zhihu.adapter.ZhihuListAdapter;
import com.hloong.news.ui.zhihu.contract.ZhihuListContract;
import com.hloong.news.ui.zhihu.model.ZhihuListModel;
import com.hloong.news.ui.zhihu.presenter.ZhihuListPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * A simple {@link Fragment} subclass.
 */
public class ZhihuMainFragment extends BaseFragment<ZhihuListPresenter,ZhihuListModel> implements ZhihuListContract.View {
    @Bind(R.id.ntb)
    NormalTitleBar ntb;
    @Bind(R.id.irc)
    IRecyclerView irc;
    @Bind(R.id.loadedTip)
    LoadingTip loadedTip;
    @Bind(R.id.fab)
    FloatingActionButton fab;
    private int page = -1;//分页是是昨日
    private List<Story> datas = new ArrayList<>();
    ZhihuListAdapter adapter;
    @Override
    protected void initPresenter() {
        mPresenter.setVM(this,mModel);
    }

    @Override
    protected void initView() {
        ntb.setTvLeftVisiable(false);
        ntb.setTitleText("知乎日报");
        adapter = new ZhihuListAdapter(getContext(),R.layout.item_zhihu);
        adapter.openLoadAnimation(new ScaleInAnimation());
        irc.setLayoutManager(new LinearLayoutManager(getContext()));
        irc.setAdapter(adapter);
        irc.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh() {
                page = -1;
                mPresenter.getTopDataRequest();
            }
        });
        irc.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(View loadMoreView) {
                String time = TimeUtil.getNextDayYMD(page);
                mPresenter.getListDataRequest(time);
            }
        });
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //此处完全可以用 scorlltoTop(),但是此时为测试Rx的功能
                mRxManager.post(AppConstant.NEWS_LIST_TO_TOP,"");
            }
        });
        if (adapter.getSize() <= 0){
            mPresenter.getTopDataRequest();
        }
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_zhihu_main;
    }

    @Override
    public void scorlltoTop() {
        irc.smoothScrollToPosition(0);
    }

    @Override
    public void returnTopData(ZhihuLastsNews zhihuLastsNews) {
        if (zhihuLastsNews != null){
            page=-1;
            irc.setRefreshing(false);
            adapter.addAll(zhihuLastsNews.getStories());
        }
    }

    @Override
    public void returnMoreData(String date, ZhihuBeforeNews zhihuBeforeNews) {
        if (date == TimeUtil.getNextDayYMD(page)){//拿到更新的数据了
            adapter.addAllAt(-page,zhihuBeforeNews.getStories());
            page--;
        }
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
