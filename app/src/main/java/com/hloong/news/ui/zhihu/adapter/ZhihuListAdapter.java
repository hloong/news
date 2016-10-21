package com.hloong.news.ui.zhihu.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.aspsine.irecyclerview.universaladapter.ViewHolderHelper;
import com.aspsine.irecyclerview.universaladapter.recyclerview.CommonRecycleViewAdapter;
import com.hloong.base.image.ImageLoader;
import com.hloong.base.utils.TimeUtil;
import com.hloong.news.R;
import com.hloong.news.bean.Story;
import com.hloong.news.ui.zhihu.activity.ZhihuDetailActivity;

import java.util.List;

/**
 * Created by hloong on 2016/10/20.
 */

public class ZhihuListAdapter extends CommonRecycleViewAdapter<Story> {

    private int page = 0;

    public ZhihuListAdapter(Context context, int layoutId, List<Story> mDatass) {
        super(context, layoutId, mDatass);
    }

    public ZhihuListAdapter(Context context, int layoutId) {
        super(context, layoutId);
    }

    @Override
    public void convert(ViewHolderHelper helper, final Story story) {
        ImageView imageView = helper.getView(R.id.zhihu_photo_iv);
        ImageLoader.display(mContext,imageView,story.getImages().get(0));
        helper.setText(R.id.zhihu_title_tv,story.getTitle());
        helper.setText(R.id.zhihu_ptime_tv, TimeUtil.getNextDay(page));
        helper.setOnClickListener(R.id.rl_root, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ZhihuDetailActivity.startAction(mContext,story.getId());
            }
        });
    }

    @Override
    public void add(Story elem) {
        page--;
        super.add(elem);
    }
}
