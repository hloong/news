package com.hloong.news.ui.zone;


import com.hloong.base.utils.JsonUtils;
import com.hloong.news.bean.Result;

import java.util.Random;

/**
 * des:假数据
 * Created by xsf
 * on 2016.07.11:14
 */
public class DatasUtil {
    /**
     * 获取列表数据
     * @return
     */
	public static Result getZoneListDatas(){
        String str="{\n" +
                "\"status\": \"1\",\n" +
                "\"msg\": {\n" +
                "\"page\": {\n" +
                "\"sort\": \"\",\n" +
                "\"rownum_\": 0,\n" +
                "\"order\": \"\",\n" +
                "\"totalCount\": 13,\n" +
                "\"page\": 1,\n" +
                "\"toNumber\": 10,\n" +
                "\"fromNumber\": 0,\n" +
                "\"totalPage\": 2,\n" +
                "\"rows\": 10\n" +
                "},\n" +
                "\"list\": [\n" +
                "{\n" +
                "\"appointUserid\": 0,\n" +
                "\"createTime\": 1471943240000,\n" +
                "\"icon\": \"Image/20160819/1471570856669.jpeg\",\n" +
                "\"takeTimes\": \"12\",\n" +
                "\"goodjobCount\": 0,\n" +
                "\"replys\": [],\n" +
                "\"replyCount\": 0,\n" +
                "\"pictures\": \"\",\n" +
                "\"type\": \"0\",\n" +
                "\"goodjobs\": [],\n" +
                "\"isvalid\": \"0\",\n" +
                "\"content\": \"在2015年Google的年度大会上，已经升级了新的Support Library，视觉效果及用户体验毋庸置疑，所以今天主要简单主要介绍Material Design中最主要的二个控件，RecyclerView的上拉加载更多和CoordinatorLayout的结合使用\",\n" +
                "\"id\": 15,\n" +
                "\"appointUserNickname\": \"\",\n" +
                "\"nickName\": \"隆\",\n" +
                "\"address\": \"\",\n" +
                "\"userId\": 10000,\n" +
                "\"longitude\": \"0\",\n" +
                "\"latitude\": \"0\"\n" +
                "},\n" +
                "{\n" +
                "\"appointUserid\": 0,\n" +
                "\"createTime\": 1471942968000,\n" +
                "\"icon\": \"Image/20160819/1471570856669.jpeg\",\n" +
                "\"takeTimes\": \"12\",\n" +
                "\"goodjobCount\": 0,\n" +
                "\"replys\": [],\n" +
                "\"replyCount\": 0,\n" +
                "\"pictures\": \"Image/20160823/1471942933390.1471865953838.jpeg;Image/20160823/1471942933488.jpeg;Image/20160823/1471942934413.jianshu.haruki.jpeg;Image/20160823/1471942935325.jpeg\",\n" +
                "\"type\": \"0\",\n" +
                "\"goodjobs\": [],\n" +
                "\"isvalid\": \"0\",\n" +
                "\"content\": \"这篇文章教我们如何根据 material 设计指南 来创建一个 material 风格的安卓天气 APP。Google Material 设计包含了一系列可视化设计、用户交互、手势等的规范。这些规范帮助开发人员设计和创建一个安卓应用程序。\",\n" +
                "\"id\": 14,\n" +
                "\"appointUserNickname\": \"\",\n" +
                "\"nickName\": \"隆\",\n" +
                "\"address\": \"\",\n" +
                "\"userId\": 10000,\n" +
                "\"longitude\": \"0\",\n" +
                "\"latitude\": \"0\"\n" +
                "},\n" +
                "{\n" +
                "\"appointUserid\": 0,\n" +
                "\"createTime\": 1471398857000,\n" +
                "\"icon\": \"Image/20160817/1471398965572.jpeg\",\n" +
                "\"takeTimes\": \"14\",\n" +
                "\"goodjobCount\": 1,\n" +
                "\"replys\": [\n" +
                "{\n" +
                "\"id\": 22,\n" +
                "\"content\": \"肥死你\",\n" +
                "\"createTime\": 1471399614000,\n" +
                "\"appointUserid\": 0,\n" +
                "\"publishId\": 13,\n" +
                "\"appointUserNickname\": \"\",\n" +
                "\"userId\": 10005,\n" +
                "\"pictures\": \"\",\n" +
                "\"userNickname\": \"燕子\"\n" +
                "},\n" +
                "{\n" +
                "\"id\": 23,\n" +
                "\"content\": \"肥死你\",\n" +
                "\"createTime\": 1471406871000,\n" +
                "\"appointUserid\": 0,\n" +
                "\"publishId\": 13,\n" +
                "\"appointUserNickname\": \"\",\n" +
                "\"userId\": 10000,\n" +
                "\"pictures\": \"\",\n" +
                "\"userNickname\": \"隆\"\n" +
                "},\n" +
                "{\n" +
                "\"id\": 24,\n" +
                "\"content\": \"肥死你\",\n" +
                "\"createTime\": 1471489658000,\n" +
                "\"appointUserid\": 0,\n" +
                "\"publishId\": 13,\n" +
                "\"appointUserNickname\": \"\",\n" +
                "\"userId\": 10002,\n" +
                "\"pictures\": \"\",\n" +
                "\"userNickname\": \"小鹏\"\n" +
                "}\n" +
                "],\n" +
                "\"replyCount\": 3,\n" +
                "\"pictures\": \"Image/20160817/1471398852032.jpeg;Image/20160817/1471398852069.jpeg\",\n" +
                "\"type\": \"0\",\n" +
                "\"goodjobs\": [\n" +
                "{\n" +
                "\"id\": 11,\n" +
                "\"createTime\": 1471406833000,\n" +
                "\"publishId\": 13,\n" +
                "\"userId\": 10000,\n" +
                "\"userNickname\": \"隆\"\n" +
                "}\n" +
                "],\n" +
                "\"isvalid\": \"0\",\n" +
                "\"content\": \"么么\",\n" +
                "\"id\": 13,\n" +
                "\"appointUserNickname\": \"\",\n" +
                "\"nickName\": \"雷菁\",\n" +
                "\"address\": \"\",\n" +
                "\"userId\": 10013,\n" +
                "\"longitude\": \"0\",\n" +
                "\"latitude\": \"0\"\n" +
                "},\n" +
                "{\n" +
                "\"appointUserid\": 0,\n" +
                "\"createTime\": 1471398806000,\n" +
                "\"icon\": \"Image/20160817/1471398965572.jpeg\",\n" +
                "\"takeTimes\": \"14\",\n" +
                "\"goodjobCount\": 1,\n" +
                "\"replys\": [],\n" +
                "\"replyCount\": 0,\n" +
                "\"pictures\": \"Image/20160817/1471398798359.jpeg;Image/20160817/1471398798394.jpeg;Image/20160817/1471398798435.jpeg;Image/20160817/1471398799094.jpeg;Image/20160817/1471398800487.jpeg;Image/20160817/1471398800809.jpeg;Image/20160817/1471398801197.jpeg;Image/20160817/1471398801527.jpeg;Image/20160817/1471398801867.jpeg\",\n" +
                "\"type\": \"0\",\n" +
                "\"goodjobs\": [\n" +
                "{\n" +
                "\"id\": 12,\n" +
                "\"createTime\": 1471406839000,\n" +
                "\"publishId\": 12,\n" +
                "\"userId\": 10000,\n" +
                "\"userNickname\": \"张\"\n" +
                "}\n" +
                "],\n" +
                "\"isvalid\": \"0\",\n" +
                "\"content\": \"吃吃吃\",\n" +
                "\"id\": 12,\n" +
                "\"appointUserNickname\": \"\",\n" +
                "\"nickName\": \"婉莹\",\n" +
                "\"address\": \"\",\n" +
                "\"userId\": 10013,\n" +
                "\"longitude\": \"0\",\n" +
                "\"latitude\": \"0\"\n" +
                "},\n" +
                "{\n" +
                "\"appointUserid\": 0,\n" +
                "\"createTime\": 1471394956000,\n" +
                "\"icon\": \"\",\n" +
                "\"takeTimes\": \"0\",\n" +
                "\"goodjobCount\": 1,\n" +
                "\"replys\": [],\n" +
                "\"replyCount\": 0,\n" +
                "\"pictures\": \"Image/20160817/1471394954041.jpeg\",\n" +
                "\"type\": \"0\",\n" +
                "\"goodjobs\": [\n" +
                "{\n" +
                "\"id\": 10,\n" +
                "\"createTime\": 1471401148000,\n" +
                "\"publishId\": 11,\n" +
                "\"userId\": 10000,\n" +
                "\"userNickname\": \"三\"\n" +
                "}\n" +
                "],\n" +
                "\"isvalid\": \"0\",\n" +
                "\"content\": \"你好牛逼\",\n" +
                "\"id\": 11,\n" +
                "\"appointUserNickname\": \"\",\n" +
                "\"nickName\": \"carter\",\n" +
                "\"address\": \"\",\n" +
                "\"userId\": 10102,\n" +
                "\"longitude\": \"0\",\n" +
                "\"latitude\": \"0\"\n" +
                "},\n" +
                "{\n" +
                "\"appointUserid\": 0,\n" +
                "\"createTime\": 1471233432000,\n" +
                "\"icon\": \"\",\n" +
                "\"takeTimes\": \"0\",\n" +
                "\"goodjobCount\": 2,\n" +
                "\"replys\": [\n" +
                "{\n" +
                "\"id\": 11,\n" +
                "\"content\": \"啾啾啾\",\n" +
                "\"createTime\": 1471233460000,\n" +
                "\"appointUserid\": 0,\n" +
                "\"publishId\": 9,\n" +
                "\"appointUserNickname\": \"\",\n" +
                "\"userId\": 10102,\n" +
                "\"pictures\": \"\",\n" +
                "\"userNickname\": \"carter\"\n" +
                "}\n" +
                "],\n" +
                "\"replyCount\": 1,\n" +
                "\"pictures\": \"Image/20160815/1471233430776.jpeg\",\n" +
                "\"type\": \"0\",\n" +
                "\"goodjobs\": [\n" +
                "{\n" +
                "\"id\": 7,\n" +
                "\"createTime\": 1471233446000,\n" +
                "\"publishId\": 9,\n" +
                "\"userId\": 10102,\n" +
                "\"userNickname\": \"carter\"\n" +
                "},\n" +
                "{\n" +
                "\"id\": 15,\n" +
                "\"createTime\": 1472006199000,\n" +
                "\"publishId\": 9,\n" +
                "\"userId\": 10000,\n" +
                "\"userNickname\": \"里\"\n" +
                "}\n" +
                "],\n" +
                "\"isvalid\": \"0\",\n" +
                "\"content\": \"陈v刚回家\",\n" +
                "\"id\": 9,\n" +
                "\"appointUserNickname\": \"\",\n" +
                "\"nickName\": \"carter\",\n" +
                "\"address\": \"\",\n" +
                "\"userId\": 10102,\n" +
                "\"longitude\": \"0\",\n" +
                "\"latitude\": \"0\"\n" +
                "},\n" +
                "{\n" +
                "\"appointUserid\": 0,\n" +
                "\"createTime\": 1471229159000,\n" +
                "\"icon\": \"Image/20160819/1471570856669.jpeg\",\n" +
                "\"takeTimes\": \"12\",\n" +
                "\"goodjobCount\": 1,\n" +
                "\"replys\": [],\n" +
                "\"replyCount\": 0,\n" +
                "\"pictures\": \"Image/20160815/1471229143095.jpeg;Image/20160815/1471229143130.jpeg\",\n" +
                "\"type\": \"0\",\n" +
                "\"goodjobs\": [\n" +
                "{\n" +
                "\"id\": 17,\n" +
                "\"createTime\": 1472006209000,\n" +
                "\"publishId\": 7,\n" +
                "\"userId\": 10000,\n" +
                "\"userNickname\": \"是\"\n" +
                "}\n" +
                "],\n" +
                "\"isvalid\": \"0\",\n" +
                "\"content\": \"暗喜教练\",\n" +
                "\"id\": 7,\n" +
                "\"appointUserNickname\": \"\",\n" +
                "\"nickName\": \"啥\",\n" +
                "\"address\": \"\",\n" +
                "\"userId\": 10000,\n" +
                "\"longitude\": \"0\",\n" +
                "\"latitude\": \"0\"\n" +
                "},\n" +
                "{\n" +
                "\"appointUserid\": 0,\n" +
                "\"createTime\": 1471227441000,\n" +
                "\"icon\": \"Image/20160819/1471570856669.jpeg\",\n" +
                "\"takeTimes\": \"12\",\n" +
                "\"goodjobCount\": 1,\n" +
                "\"replys\": [],\n" +
                "\"replyCount\": 0,\n" +
                "\"pictures\": \"Image/20160815/1471227434250.jpeg;Image/20160815/1471227434373.jpeg\",\n" +
                "\"type\": \"0\",\n" +
                "\"goodjobs\": [\n" +
                "{\n" +
                "\"id\": 6,\n" +
                "\"createTime\": 1471227450000,\n" +
                "\"publishId\": 6,\n" +
                "\"userId\": 10000,\n" +
                "\"userNickname\": \"哦\"\n" +
                "}\n" +
                "],\n" +
                "\"isvalid\": \"0\",\n" +
                "\"content\": \"know与练车教练了了魔力好归宿\",\n" +
                "\"id\": 6,\n" +
                "\"appointUserNickname\": \"\",\n" +
                "\"nickName\": \"啥\",\n" +
                "\"address\": \"\",\n" +
                "\"userId\": 10000,\n" +
                "\"longitude\": \"0\",\n" +
                "\"latitude\": \"0\"\n" +
                "},\n" +
                "{\n" +
                "\"appointUserid\": 0,\n" +
                "\"createTime\": 1471224271000,\n" +
                "\"icon\": \"Image/20160819/1471570856669.jpeg\",\n" +
                "\"takeTimes\": \"12\",\n" +
                "\"goodjobCount\": 1,\n" +
                "\"replys\": [],\n" +
                "\"replyCount\": 0,\n" +
                "\"pictures\": \"Image/20160815/1471224256630.jpg;Image/20160815/1471224256945.png\",\n" +
                "\"type\": \"0\",\n" +
                "\"goodjobs\": [\n" +
                "{\n" +
                "\"id\": 14,\n" +
                "\"createTime\": 1471406854000,\n" +
                "\"publishId\": 4,\n" +
                "\"userId\": 10000,\n" +
                "\"userNickname\": \"特\"\n" +
                "}\n" +
                "],\n" +
                "\"isvalid\": \"0\",\n" +
                "\"content\": \"小白兔就那么重要\",\n" +
                "\"id\": 4,\n" +
                "\"appointUserNickname\": \"\",\n" +
                "\"nickName\": \"比\",\n" +
                "\"address\": \"如今酒店\",\n" +
                "\"userId\": 10000,\n" +
                "\"longitude\": \"113.2686712109507\",\n" +
                "\"latitude\": \"23.123064640399328\"\n" +
                "}\n" +
                "]\n" +
                "}\n" +
                "}";
        return (Result) JsonUtils.fromJson(str,Result.class);
    }

    /**
     * 图片
     */
    private static String[]Urls={"http://d.hiphotos.baidu.com/image/pic/item/e4dde71190ef76c6e453882a9f16fdfaaf516729.jpg", "http://h.hiphotos.baidu.com/image/pic/item/30adcbef76094b36db47d2e4a1cc7cd98c109de6.jpg","http://g.hiphotos.baidu.com/image/pic/item/0d338744ebf81a4c27dc0dcdd52a6059242da6cc.jpg"
            ,"http://c.hiphotos.baidu.com/image/h%3D200/sign=d21f63f99d3df8dcb93d8891fd1072bf/78310a55b319ebc415951b978026cffc1f1716ca.jpg","http://d.hiphotos.baidu.com/image/pic/item/54fbb2fb43166d22dc28839a442309f79052d265.jpg"
    ,"http://c.hiphotos.baidu.com/image/pic/item/03087bf40ad162d9d0e7560313dfa9ec8a13cda7.jpg","http://g.hiphotos.baidu.com/image/h%3D200/sign=16f4ef3e35adcbef1e3479069cae2e0e/6d81800a19d8bc3e7763d030868ba61ea9d345e5.jpg"
    ,"http://g.hiphotos.baidu.com/image/pic/item/8d5494eef01f3a29a3b0e6c49b25bc315c607cbb.jpg","http://c.hiphotos.baidu.com/image/h%3D200/sign=548da2d73f6d55fbdac671265d224f40/a044ad345982b2b7a2b8f7cd33adcbef76099b90.jpg"
    ,"http://g.hiphotos.baidu.com/image/pic/item/7acb0a46f21fbe09359315d16f600c338644ad22.jpg","http://h.hiphotos.baidu.com/image/h%3D200/sign=9d4948d52c738bd4db21b531918a876c/6a600c338744ebf85db15337dbf9d72a6159a7f1.jpg"
    ,"http://e.hiphotos.baidu.com/image/h%3D200/sign=7683f02abc096b639e1959503c328733/203fb80e7bec54e74a142d1bbb389b504fc26a3e.jpg"};

    /**
     * 获取随机图片串
     * @param num
     * @return
     */
    public static String getRandomPhotoUrlString(int num) {
        StringBuilder sdbResult = new StringBuilder();
        if(num>0) {
            String[] photoUrls = new String[num>9?9:num];
            for (int i = 0; i< num ; i++) {
                if ( sdbResult.length() > 0 )
                {
                    sdbResult.append( ";" ).append( Urls[new Random().nextInt(Urls.length)] );
                }else{
                    sdbResult.append( Urls[new Random().nextInt(Urls.length)] );
                }

            }
        }
        return sdbResult.toString();
    }
    /**
     * 获取随机图片串
     * @return
     */
    public static String getRandomPhotoUrl() {
        return  Urls[new Random().nextInt(Urls.length)];
    }
}
