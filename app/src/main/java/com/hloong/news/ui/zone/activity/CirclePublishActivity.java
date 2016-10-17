package com.hloong.news.ui.zone.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.hloong.base.base.BaseActivity;
import com.hloong.base.utils.ToastUitl;
import com.hloong.base.widget.NoScrollGridView;
import com.hloong.base.widget.NormalTitleBar;
import com.hloong.news.R;
import com.hloong.news.app.AppCache;
import com.hloong.news.app.AppConstant;
import com.hloong.news.ui.zone.adapter.NinePicturesAdapter;
import com.hloong.news.ui.zone.bean.CircleItem;
import com.yuyh.library.imgsel.ImageLoader;
import com.yuyh.library.imgsel.ImgSelActivity;
import com.yuyh.library.imgsel.ImgSelConfig;

import java.util.List;

import butterknife.Bind;

public class CirclePublishActivity extends BaseActivity {
    @Bind(R.id.ntb)
    NormalTitleBar ntb;
    @Bind(R.id.et_content)
    EditText etContent;
    @Bind(R.id.gridview)
    NoScrollGridView gridview;
    @Bind(R.id.tv_back)
    TextView tvBack;
    @Bind(R.id.tv_save)
    TextView tvSave;
    private NinePicturesAdapter ninePicturesAdapter;
    private int REQUEST_CODE=120;

    /**
     * 启动入口
     * @param context
     */
    public static void startAction(Context context) {
        Intent intent = new Intent(context, CirclePublishActivity.class);
        context.startActivity(intent);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_circle_publish;
    }

    @Override
    protected void initPresenter() {

    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        ntb.setTitleText(getString(R.string.zone_publish_title));
        ninePicturesAdapter = new NinePicturesAdapter(this,9, new NinePicturesAdapter.OnClickAddListener() {
            @Override
            public void onClickAdd(int positin) {
                choosePhoto();
            }
        });
        gridview.setAdapter(ninePicturesAdapter);
        tvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        tvSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savaContent();
            }
        });
    }
    private void savaContent(){
        if(!TextUtils.isEmpty(etContent.getText().toString())) {
            CircleItem circleItem = new CircleItem();
            circleItem.setContent(etContent.getText().toString());
            circleItem.setPictures(getPictureString());
            circleItem.setIcon(AppCache.getInstance().getIcon());
            circleItem.setUserId(AppCache.getInstance().getUserId());
            circleItem.setNickName(AppCache.getInstance().getUserName());
            circleItem.setCreateTime(Long.parseLong("1471942968000"));
            mRxManager.post(AppConstant.ZONE_PUBLISH_ADD,circleItem);
            finish();
        }else{
            ToastUitl.showToastWithImg(getString(R.string.circle_publish_empty),R.drawable.ic_warm);
        }
    }



    /**
     * 开启图片选择器
     */
    private void choosePhoto() {
        ImgSelConfig config = new ImgSelConfig.Builder(loader)
                // 是否多选
                .multiSelect(true)
                // 确定按钮背景色
                .btnBgColor(Color.TRANSPARENT)
                .titleBgColor(ContextCompat.getColor(this,R.color.main_color))
                // 使用沉浸式状态栏
                .statusBarColor(ContextCompat.getColor(this,R.color.main_color))
                // 返回图标ResId
                .backResId(R.drawable.ic_arrow_back)
                .title("图片")
                // 第一个是否显示相机
                .needCamera(true)
                // 最大选择图片数量
                .maxNum(9-ninePicturesAdapter.getPhotoCount())
                .build();
        ImgSelActivity.startActivity(this, config, REQUEST_CODE);
    }
    private ImageLoader loader = new ImageLoader() {
        @Override
        public void displayImage(Context context, String path, ImageView imageView) {
            com.hloong.base.image.ImageLoader.display(context,imageView,path);
        }
    };


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            List<String> pathList = data.getStringArrayListExtra(ImgSelActivity.INTENT_RESULT);
            if(ninePicturesAdapter!=null){
                ninePicturesAdapter.addAll(pathList);
            }
        }
    }

    /**
     * 获取到拼接好的图片
     * @return
     */
    private String getPictureString(){
        //拼接图片链接
        List<String> strings = ninePicturesAdapter.getData();
        if (strings != null && strings.size() > 0) {
            StringBuilder allUrl = new StringBuilder();
            for (int i = 0; i < strings.size(); i++) {
                if (!TextUtils.isEmpty(strings.get(i))) {
                    allUrl.append(strings.get(i) + ";");
                }
            }
            if (!TextUtils.isEmpty(allUrl)) {
                String url = allUrl.toString();
                url = url.substring(0, url.lastIndexOf(";"));
                return url;
            }else{
                return "";
            }
        }else{
            return "";
        }
    }
}
