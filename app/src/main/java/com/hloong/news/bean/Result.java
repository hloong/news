package com.hloong.news.bean;

import com.aspsine.irecyclerview.bean.PageBean;
import com.hloong.news.ui.zone.bean.CircleItem;

import java.util.List;


/**
 * des:接口返回数据基类
 * Created by xsf
 * on 2016.06.13:05
 *
 * 备份
 */
public class Result {

    /**
     * status : 1
     * msg : {"page":{"sort":"","rownum_":0,"order":"","totalCount":13,"page":1,"toNumber":10,"fromNumber":0,"totalPage":2,"rows":10},"list":[{"appointUserid":0,"createTime":1471943240000,"icon":"Image/20160819/1471570856669.jpeg","takeTimes":"12","goodjobCount":0,"replys":[],"replyCount":0,"pictures":"","type":"0","goodjobs":[],"isvalid":"0","content":"不他苦苦他哭哭啼啼call call call把啦啦啦比较不同不把它徒步把基础八级bat tata table tata club吃茶比如步步B app啊app奔驰才承认失败哈哈啊哈哈哈哈怕拆改才此白菜练车教练同谋偷偷某透明Jack ta CT tab BL ta她不\n他卡路里途径\n\n他夫妇开疆拓土拒绝","id":15,"appointUserNickname":"","nickName":"锋","address":"","userId":10000,"longitude":"0","latitude":"0"},{"appointUserid":0,"createTime":1471942968000,"icon":"Image/20160819/1471570856669.jpeg","takeTimes":"12","goodjobCount":0,"replys":[],"replyCount":0,"pictures":"Image/20160823/1471942933390.1471865953838.jpeg;Image/20160823/1471942933488.jpeg;Image/20160823/1471942934413.jianshu.haruki.jpeg;Image/20160823/1471942935325.jpeg","type":"0","goodjobs":[],"isvalid":"0","content":"开疆拓土吧练车教练了他不踏踏步步同步步步步步啊不踏步踏踏踏我的中断向量表了肯定有不踏踏步踏步步步步步踏踏踏踏来不他催促Ella参考参考咔咔卡啊啦啦啦巴卡啦啦啦比较啦啦啦陈康灵长卡拉but actually不不不步步卡布他旅途么也门类不啊啦啦啦啦啦啊拉里邋遢了啊Java TVB他不拉开啊啦啦啦啦啦啦参考参考步步他踏步步","id":14,"appointUserNickname":"","nickName":"锋","address":"","userId":10000,"longitude":"0","latitude":"0"},{"appointUserid":0,"createTime":1471398857000,"icon":"Image/20160817/1471398965572.jpeg","takeTimes":"14","goodjobCount":1,"replys":[{"id":22,"content":"肥死你","createTime":1471399614000,"appointUserid":0,"publishId":13,"appointUserNickname":"","userId":10005,"pictures":"","userNickname":"燕子"},{"id":23,"content":"肥死你","createTime":1471406871000,"appointUserid":0,"publishId":13,"appointUserNickname":"","userId":10000,"pictures":"","userNickname":"锋"},{"id":24,"content":"肥死你","createTime":1471489658000,"appointUserid":0,"publishId":13,"appointUserNickname":"","userId":10002,"pictures":"","userNickname":"小鹏"}],"replyCount":3,"pictures":"Image/20160817/1471398852032.jpeg;Image/20160817/1471398852069.jpeg","type":"0","goodjobs":[{"id":11,"createTime":1471406833000,"publishId":13,"userId":10000,"userNickname":"锋"}],"isvalid":"0","content":"么么","id":13,"appointUserNickname":"","nickName":"雷菁","address":"","userId":10013,"longitude":"0","latitude":"0"},{"appointUserid":0,"createTime":1471398806000,"icon":"Image/20160817/1471398965572.jpeg","takeTimes":"14","goodjobCount":1,"replys":[],"replyCount":0,"pictures":"Image/20160817/1471398798359.jpeg;Image/20160817/1471398798394.jpeg;Image/20160817/1471398798435.jpeg;Image/20160817/1471398799094.jpeg;Image/20160817/1471398800487.jpeg;Image/20160817/1471398800809.jpeg;Image/20160817/1471398801197.jpeg;Image/20160817/1471398801527.jpeg;Image/20160817/1471398801867.jpeg","type":"0","goodjobs":[{"id":12,"createTime":1471406839000,"publishId":12,"userId":10000,"userNickname":"锋"}],"isvalid":"0","content":"吃吃吃","id":12,"appointUserNickname":"","nickName":"雷菁","address":"","userId":10013,"longitude":"0","latitude":"0"},{"appointUserid":0,"createTime":1471394956000,"icon":"","takeTimes":"0","goodjobCount":1,"replys":[],"replyCount":0,"pictures":"Image/20160817/1471394954041.jpeg","type":"0","goodjobs":[{"id":10,"createTime":1471401148000,"publishId":11,"userId":10000,"userNickname":"锋"}],"isvalid":"0","content":"你好牛逼","id":11,"appointUserNickname":"","nickName":"carter","address":"","userId":10102,"longitude":"0","latitude":"0"},{"appointUserid":0,"createTime":1471233432000,"icon":"","takeTimes":"0","goodjobCount":2,"replys":[{"id":11,"content":"啾啾啾","createTime":1471233460000,"appointUserid":0,"publishId":9,"appointUserNickname":"","userId":10102,"pictures":"","userNickname":"carter"}],"replyCount":1,"pictures":"Image/20160815/1471233430776.jpeg","type":"0","goodjobs":[{"id":7,"createTime":1471233446000,"publishId":9,"userId":10102,"userNickname":"carter"},{"id":15,"createTime":1472006199000,"publishId":9,"userId":10000,"userNickname":"锋"}],"isvalid":"0","content":"陈v刚回家","id":9,"appointUserNickname":"","nickName":"carter","address":"","userId":10102,"longitude":"0","latitude":"0"},{"appointUserid":0,"createTime":1471229159000,"icon":"Image/20160819/1471570856669.jpeg","takeTimes":"12","goodjobCount":1,"replys":[],"replyCount":0,"pictures":"Image/20160815/1471229143095.jpeg;Image/20160815/1471229143130.jpeg","type":"0","goodjobs":[{"id":17,"createTime":1472006209000,"publishId":7,"userId":10000,"userNickname":"锋"}],"isvalid":"0","content":"莫练车教练","id":7,"appointUserNickname":"","nickName":"锋","address":"","userId":10000,"longitude":"0","latitude":"0"},{"appointUserid":0,"createTime":1471227441000,"icon":"Image/20160819/1471570856669.jpeg","takeTimes":"12","goodjobCount":1,"replys":[],"replyCount":0,"pictures":"Image/20160815/1471227434250.jpeg;Image/20160815/1471227434373.jpeg","type":"0","goodjobs":[{"id":6,"createTime":1471227450000,"publishId":6,"userId":10000,"userNickname":"锋"}],"isvalid":"0","content":"know与练车教练了了魔力好归宿","id":6,"appointUserNickname":"","nickName":"锋","address":"","userId":10000,"longitude":"0","latitude":"0"},{"appointUserid":0,"createTime":1471224271000,"icon":"Image/20160819/1471570856669.jpeg","takeTimes":"12","goodjobCount":1,"replys":[],"replyCount":0,"pictures":"Image/20160815/1471224256630.jpg;Image/20160815/1471224256945.png","type":"0","goodjobs":[{"id":14,"createTime":1471406854000,"publishId":4,"userId":10000,"userNickname":"锋"}],"isvalid":"0","content":"墨玉兔就那么重要","id":4,"appointUserNickname":"","nickName":"锋","address":"宝轩酒店","userId":10000,"longitude":"113.2686712109507","latitude":"23.123064640399328"}]}
     */

    private String status;
    /**
     * page : {"sort":"","rownum_":0,"order":"","totalCount":13,"page":1,"toNumber":10,"fromNumber":0,"totalPage":2,"rows":10}
     * list : [{"appointUserid":0,"createTime":1471943240000,"icon":"Image/20160819/1471570856669.jpeg","takeTimes":"12","goodjobCount":0,"replys":[],"replyCount":0,"pictures":"","type":"0","goodjobs":[],"isvalid":"0","content":"不他苦苦他哭哭啼啼call call call把啦啦啦比较不同不把它徒步把基础八级bat tata table tata club吃茶比如步步B app啊app奔驰才承认失败哈哈啊哈哈哈哈怕拆改才此白菜练车教练同谋偷偷某透明Jack ta CT tab BL ta她不\n他卡路里途径\n\n他夫妇开疆拓土拒绝","id":15,"appointUserNickname":"","nickName":"锋","address":"","userId":10000,"longitude":"0","latitude":"0"},{"appointUserid":0,"createTime":1471942968000,"icon":"Image/20160819/1471570856669.jpeg","takeTimes":"12","goodjobCount":0,"replys":[],"replyCount":0,"pictures":"Image/20160823/1471942933390.1471865953838.jpeg;Image/20160823/1471942933488.jpeg;Image/20160823/1471942934413.jianshu.haruki.jpeg;Image/20160823/1471942935325.jpeg","type":"0","goodjobs":[],"isvalid":"0","content":"开疆拓土吧练车教练了他不踏踏步步同步步步步步啊不踏步踏踏踏我的中断向量表了肯定有不踏踏步踏步步步步步踏踏踏踏来不他催促Ella参考参考咔咔卡啊啦啦啦巴卡啦啦啦比较啦啦啦陈康灵长卡拉but actually不不不步步卡布他旅途么也门类不啊啦啦啦啦啦啊拉里邋遢了啊Java TVB他不拉开啊啦啦啦啦啦啦参考参考步步他踏步步","id":14,"appointUserNickname":"","nickName":"锋","address":"","userId":10000,"longitude":"0","latitude":"0"},{"appointUserid":0,"createTime":1471398857000,"icon":"Image/20160817/1471398965572.jpeg","takeTimes":"14","goodjobCount":1,"replys":[{"id":22,"content":"肥死你","createTime":1471399614000,"appointUserid":0,"publishId":13,"appointUserNickname":"","userId":10005,"pictures":"","userNickname":"燕子"},{"id":23,"content":"肥死你","createTime":1471406871000,"appointUserid":0,"publishId":13,"appointUserNickname":"","userId":10000,"pictures":"","userNickname":"锋"},{"id":24,"content":"肥死你","createTime":1471489658000,"appointUserid":0,"publishId":13,"appointUserNickname":"","userId":10002,"pictures":"","userNickname":"小鹏"}],"replyCount":3,"pictures":"Image/20160817/1471398852032.jpeg;Image/20160817/1471398852069.jpeg","type":"0","goodjobs":[{"id":11,"createTime":1471406833000,"publishId":13,"userId":10000,"userNickname":"锋"}],"isvalid":"0","content":"么么","id":13,"appointUserNickname":"","nickName":"雷菁","address":"","userId":10013,"longitude":"0","latitude":"0"},{"appointUserid":0,"createTime":1471398806000,"icon":"Image/20160817/1471398965572.jpeg","takeTimes":"14","goodjobCount":1,"replys":[],"replyCount":0,"pictures":"Image/20160817/1471398798359.jpeg;Image/20160817/1471398798394.jpeg;Image/20160817/1471398798435.jpeg;Image/20160817/1471398799094.jpeg;Image/20160817/1471398800487.jpeg;Image/20160817/1471398800809.jpeg;Image/20160817/1471398801197.jpeg;Image/20160817/1471398801527.jpeg;Image/20160817/1471398801867.jpeg","type":"0","goodjobs":[{"id":12,"createTime":1471406839000,"publishId":12,"userId":10000,"userNickname":"锋"}],"isvalid":"0","content":"吃吃吃","id":12,"appointUserNickname":"","nickName":"雷菁","address":"","userId":10013,"longitude":"0","latitude":"0"},{"appointUserid":0,"createTime":1471394956000,"icon":"","takeTimes":"0","goodjobCount":1,"replys":[],"replyCount":0,"pictures":"Image/20160817/1471394954041.jpeg","type":"0","goodjobs":[{"id":10,"createTime":1471401148000,"publishId":11,"userId":10000,"userNickname":"锋"}],"isvalid":"0","content":"你好牛逼","id":11,"appointUserNickname":"","nickName":"carter","address":"","userId":10102,"longitude":"0","latitude":"0"},{"appointUserid":0,"createTime":1471233432000,"icon":"","takeTimes":"0","goodjobCount":2,"replys":[{"id":11,"content":"啾啾啾","createTime":1471233460000,"appointUserid":0,"publishId":9,"appointUserNickname":"","userId":10102,"pictures":"","userNickname":"carter"}],"replyCount":1,"pictures":"Image/20160815/1471233430776.jpeg","type":"0","goodjobs":[{"id":7,"createTime":1471233446000,"publishId":9,"userId":10102,"userNickname":"carter"},{"id":15,"createTime":1472006199000,"publishId":9,"userId":10000,"userNickname":"锋"}],"isvalid":"0","content":"陈v刚回家","id":9,"appointUserNickname":"","nickName":"carter","address":"","userId":10102,"longitude":"0","latitude":"0"},{"appointUserid":0,"createTime":1471229159000,"icon":"Image/20160819/1471570856669.jpeg","takeTimes":"12","goodjobCount":1,"replys":[],"replyCount":0,"pictures":"Image/20160815/1471229143095.jpeg;Image/20160815/1471229143130.jpeg","type":"0","goodjobs":[{"id":17,"createTime":1472006209000,"publishId":7,"userId":10000,"userNickname":"锋"}],"isvalid":"0","content":"莫练车教练","id":7,"appointUserNickname":"","nickName":"锋","address":"","userId":10000,"longitude":"0","latitude":"0"},{"appointUserid":0,"createTime":1471227441000,"icon":"Image/20160819/1471570856669.jpeg","takeTimes":"12","goodjobCount":1,"replys":[],"replyCount":0,"pictures":"Image/20160815/1471227434250.jpeg;Image/20160815/1471227434373.jpeg","type":"0","goodjobs":[{"id":6,"createTime":1471227450000,"publishId":6,"userId":10000,"userNickname":"锋"}],"isvalid":"0","content":"know与练车教练了了魔力好归宿","id":6,"appointUserNickname":"","nickName":"锋","address":"","userId":10000,"longitude":"0","latitude":"0"},{"appointUserid":0,"createTime":1471224271000,"icon":"Image/20160819/1471570856669.jpeg","takeTimes":"12","goodjobCount":1,"replys":[],"replyCount":0,"pictures":"Image/20160815/1471224256630.jpg;Image/20160815/1471224256945.png","type":"0","goodjobs":[{"id":14,"createTime":1471406854000,"publishId":4,"userId":10000,"userNickname":"锋"}],"isvalid":"0","content":"墨玉兔就那么重要","id":4,"appointUserNickname":"","nickName":"锋","address":"宝轩酒店","userId":10000,"longitude":"113.2686712109507","latitude":"23.123064640399328"}]
     */

    private MsgBean msg;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public MsgBean getMsg() {
        return msg;
    }

    public void setMsg(MsgBean msg) {
        this.msg = msg;
    }

    public static class MsgBean {
        /**
         * sort :
         * rownum_ : 0
         * order :
         * totalCount : 13
         * page : 1
         * toNumber : 10
         * fromNumber : 0
         * totalPage : 2
         * rows : 10
         */

        private PageBean page;
        /**
         * appointUserid : 0
         * createTime : 1471943240000
         * icon : Image/20160819/1471570856669.jpeg
         * takeTimes : 12
         * goodjobCount : 0
         * replys : []
         * replyCount : 0
         * pictures :
         * type : 0
         * goodjobs : []
         * isvalid : 0
         * content : 不他苦苦他哭哭啼啼call call call把啦啦啦比较不同不把它徒步把基础八级bat tata table tata club吃茶比如步步B app啊app奔驰才承认失败哈哈啊哈哈哈哈怕拆改才此白菜练车教练同谋偷偷某透明Jack ta CT tab BL ta她不
         他卡路里途径

         他夫妇开疆拓土拒绝
         * id : 15
         * appointUserNickname :
         * nickName : 锋
         * address :
         * userId : 10000
         * longitude : 0
         * latitude : 0
         */

        private List<CircleItem> list;

        public PageBean getPage() {
            return page;
        }

        public void setPage(PageBean page) {
            this.page = page;
        }

        public List<CircleItem> getList() {
            return list;
        }

        public void setList(List<CircleItem> list) {
            this.list = list;
        }
    }


}
