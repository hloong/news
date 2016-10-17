package com.hloong.news.ui.zone.spannable;

import android.text.SpannableString;

import com.hloong.base.utils.ToastUitl;


/**
 * des:点赞和评论中人名的点击事件回调
 * Created by xsf
 * on 2016.07.11:14
 */
public class NameClickListener implements ISpanClick {
    private SpannableString userName;
    private String userId;

    public NameClickListener(SpannableString name, String userid) {
        this.userName = name;
        this.userId = userid;
    }

    @Override
    public void onClick(int position) {
        ToastUitl.showShort("点击了"+position);
    }
}
