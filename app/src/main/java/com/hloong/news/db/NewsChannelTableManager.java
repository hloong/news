package com.hloong.news.db;

import com.hloong.news.R;
import com.hloong.news.api.ApiConstants;
import com.hloong.news.app.App;
import com.hloong.news.bean.NewsChannelTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by hloong on 2016/10/12.
 *
 * 在Java语言中，把数组转换成List集合，有个很方便的方法就是 List<String> list = Arrays.asList("a","b","c");

 但你可能不知道这样得到的List它的长度是不能改变的。当你向这个List添加或删除一个元素时（例如 list.add("d");）
 程序就会抛出异常（java.lang.UnsupportedOperationException）。怎么会这样？！
 只需要看看asList()方法是怎么实现的就行了。
 public static <T> List<T> asList(T... a) {
 return new ArrayList<>(a);
 }
 当你看到这段代码时可能觉得没啥问题啊，不就是返回了一个ArrayList对象吗？问题就出在这里。
 这个ArrayList不是java.util包下的，而是java.util.Arrays.ArrayList，显然它是Arrays类自己定义的一个内部类！
 这个内部类没有实现add()、remove()方法，而是直接使用它的父类AbstractList的相应方法。
 而AbstractList中的add()和remove()是直接抛出java.lang.UnsupportedOperationException异常的！

 总结一下吧，如果你的List只是用来遍历，就用Arrays.asList()吧！如果你的List还要添加或删除元素，
 还是乖乖地new一个java.util.ArrayList，然后一个一个的添加元素吧！
 */

public class NewsChannelTableManager {
    /**
     * 加载新闻类型
     * @return
     */
    public static List<NewsChannelTable> loadNewsMain(){
        List<String> channelName = Arrays.asList(
                App.getAppResources().getStringArray(R.array.news_channel_name));
        List<String> channelId = Arrays.asList(
                App.getAppResources().getStringArray(R.array.news_channel_id));
        ArrayList<NewsChannelTable> newsChannelTables = new ArrayList<>();
        for (int i = 0; i < channelName.size(); i++) {
            NewsChannelTable table = new NewsChannelTable(channelName.get(i),channelId.get(i),
                    ApiConstants.getType(channelId.get(i)),i<=5,i,false);
            newsChannelTables.add(table);
        }
        return newsChannelTables;
    }
    /**
     * 加载固定新闻类型
     * @return
     */
    public static List<NewsChannelTable> loadNewsStatic(){
        List<String> channelName = Arrays.asList(
                App.getAppResources().getStringArray(R.array.news_channel_name_static));
        List<String> channelId = Arrays.asList(
                App.getAppResources().getStringArray(R.array.news_channel_id_static));
        ArrayList<NewsChannelTable> newsChannelTables = new ArrayList<>();
        for (int i = 0; i < channelName.size(); i++) {
            NewsChannelTable table = new NewsChannelTable(channelName.get(i),channelId.get(i),
                    ApiConstants.getType(channelId.get(i)),i<=5,i,true);
            newsChannelTables.add(table);
        }
        return newsChannelTables;
    }


}
