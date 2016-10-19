package com.hloong.news.ui.news.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

import com.hloong.base.base.BaseActivity;
import com.hloong.news.R;
import com.hloong.news.app.AppConstant;
import com.hloong.news.bean.NewsChannelTable;
import com.hloong.news.ui.news.adapter.ChannelAdapter;
import com.hloong.news.ui.news.contract.NewsChannelContract;
import com.hloong.news.ui.news.event.ChannelItemMoveEvent;
import com.hloong.news.ui.news.model.NewsChannelModel;
import com.hloong.news.ui.news.presenter.NewsChannelPresenter;
import com.hloong.news.widget.ItemDragHelperCallback;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import rx.functions.Action1;

public class NewsChannelActivity extends BaseActivity<NewsChannelPresenter,NewsChannelModel> implements NewsChannelContract.View {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.news_channel_mine_rv)
    RecyclerView newsChannelMineRv;
    @Bind(R.id.news_channel_more_rv)
    RecyclerView newsChannelMoreRv;

    private ChannelAdapter channelAdapterMine;
    private ChannelAdapter channelAdapterMore;
    /**
     * 入口
     * @param context
     */
    public static void startAction(Context context){
        Intent intent = new Intent(context, NewsChannelActivity.class);
        context.startActivity(intent);
    }
    @Override
    public int getLayoutId() {
        return R.layout.activity_news_channel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRxManager.on(AppConstant.CHANNEL_SWAP, new Action1<ChannelItemMoveEvent>() {
            @Override
            public void call(ChannelItemMoveEvent channelItemMoveEvent) {
                mPresenter.onItemSwap((ArrayList<NewsChannelTable>)channelAdapterMine.getAll(),
                        channelItemMoveEvent.getFromPosition(),channelItemMoveEvent.getToPosition());
            }
        });
    }

    @Override
    protected void initPresenter() {
        mPresenter.setVM(this,mModel);
    }


    @Override
    protected void initViews(Bundle savedInstanceState) {
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    finishAfterTransition();
                } else {
                    finish();
                }
            }
        });
        mPresenter.loadChannelRequest();
    }

    @Override
    public void returnNewsChannels(List<NewsChannelTable> newsChannels) {
        channelAdapterMine = new ChannelAdapter(mContext,R.layout.item_news_channel);
        newsChannelMineRv.setLayoutManager(new GridLayoutManager(this,4, LinearLayoutManager.VERTICAL,false));
        newsChannelMineRv.setItemAnimator(new DefaultItemAnimator());
        newsChannelMineRv.setAdapter(channelAdapterMine);
        channelAdapterMine.replaceAll(newsChannels);
        channelAdapterMine.setOnItemClickListener(new ChannelAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                NewsChannelTable newsChannel = channelAdapterMine.get(position);
                channelAdapterMore.add(newsChannel);
                channelAdapterMore.removeAt(position);
                mPresenter.onItemAddOrRemove((ArrayList<NewsChannelTable>)channelAdapterMine.getAll(),
                        (ArrayList<NewsChannelTable>)channelAdapterMore.getAll());
            }
        });
        ItemDragHelperCallback itemDragHelperCallback = new ItemDragHelperCallback(channelAdapterMine);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(itemDragHelperCallback);
        itemTouchHelper.attachToRecyclerView(newsChannelMineRv);
        channelAdapterMine.setItemDragHelperCallback(itemDragHelperCallback);
    }

    @Override
    public void returnMoreNewsChannels(List<NewsChannelTable> newsMoreChannels) {
        channelAdapterMore = new ChannelAdapter(mContext,R.layout.item_news_channel);
        newsChannelMoreRv.setLayoutManager(new GridLayoutManager(this,4,LinearLayoutManager.VERTICAL,false));
        newsChannelMoreRv.setItemAnimator(new DefaultItemAnimator());
        newsChannelMoreRv.setAdapter(channelAdapterMore);
        channelAdapterMore.replaceAll(newsMoreChannels);
        channelAdapterMore.setOnItemClickListener(new ChannelAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                NewsChannelTable newsChannel = channelAdapterMore.get(position);
                channelAdapterMine.add(newsChannel);
                channelAdapterMore.removeAt(position);
                mPresenter.onItemAddOrRemove((ArrayList<NewsChannelTable>)channelAdapterMine.getAll(),
                        (ArrayList<NewsChannelTable>)channelAdapterMore.getAll());
            }
        });
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
