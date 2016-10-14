package com.hloong.base.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hloong.base.R;
import com.hloong.base.utils.DisplayUtil;

/**
 * Created by hloong on 2016/10/14.
 */

public class NormalTitleBar extends RelativeLayout{
    private ImageView ivRight;
    private TextView tvBack,tvTitle,tvRight;
    private RelativeLayout rlCommonTitle;
    private Context context;

    public NormalTitleBar(Context context) {
        super(context);
        this.context = context;
    }

    public NormalTitleBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        View.inflate(context, R.layout.bar_normal,this);
        ivRight = (ImageView) findViewById(R.id.image_right);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        tvRight = (TextView) findViewById(R.id.tv_right);
        tvBack = (TextView) findViewById(R.id.tv_back);
        rlCommonTitle = (RelativeLayout) findViewById(R.id.common_title);
    }

    public void setHeaderHeight(){
        rlCommonTitle.setPadding(0, DisplayUtil.getStatusBarHeight(context),0,0);
        rlCommonTitle.requestLayout();
    }

    public void setBackVisibility(boolean visible){
        if (visible){
            tvBack.setVisibility(View.VISIBLE);
        }else {
            tvBack.setVisibility(View.GONE);
        }
    }

    /**
     * 设置标题栏左侧字符串
     * @param visiable
     */
    public void setTvLeftVisiable(boolean visiable){
        if (visiable){
            tvBack.setVisibility(View.VISIBLE);
        }else{
            tvBack.setVisibility(View.GONE);
        }
    }
    /**
     * 管理标题
     */
    public void setTitleVisibility(boolean visible) {
        if (visible) {
            tvTitle.setVisibility(View.VISIBLE);
        } else {
            tvTitle.setVisibility(View.GONE);
        }
    }

    public void setTitleText(String string) {
        tvTitle.setText(string);
    }

    public void setTitleText(int string) {
        tvTitle.setText(string);
    }

    public void setTitleColor(int color) {
        tvTitle.setTextColor(color);
    }

    /**
     * 右图标
     */
    public void setRightImagVisibility(boolean visible) {
        ivRight.setVisibility(visible ? View.VISIBLE : View.GONE);
    }

    public void setRightImagSrc(int id) {
        ivRight.setVisibility(View.VISIBLE);
        ivRight.setImageResource(id);
    }

    /**
     * 获取右按钮
     * @return
     */
    public View getRightImage() {
        return ivRight;
    }

    /**
     * 左图标
     *
     * @param id
     */
    public void setLeftImagSrc(int id) {
        tvBack.setCompoundDrawables(getResources().getDrawable(id),null,null,null);
    }
    /**
     * 左文字
     *
     * @param str
     */
    public void setLeftTitle(String str) {
        tvBack.setText(str);
    }

    /**
     * 右标题
     */
    public void setRightTitleVisibility(boolean visible) {
        tvRight.setVisibility(visible ? View.VISIBLE : View.GONE);
    }

    public void setRightTitle(String text) {
        tvRight.setText(text);
    }

    /*
     * 点击事件
     */
    public void setOnBackListener(OnClickListener listener) {
        tvBack.setOnClickListener(listener);
    }

    public void setOnRightImagListener(OnClickListener listener) {
        ivRight.setOnClickListener(listener);
    }

    public void setOnRightTextListener(OnClickListener listener) {
        tvRight.setOnClickListener(listener);
    }

    /**
     * 标题背景颜色
     *
     * @param color
     */
    public void setBackGroundColor(int color) {
        rlCommonTitle.setBackgroundColor(color);
    }
    public Drawable getBackGroundDrawable() {
        return rlCommonTitle.getBackground();
    }

}
