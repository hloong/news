package com.hloong.news.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by hloong on 2016/10/18.
 */

public class ResultCopy implements Parcelable{
    /**
     * status : 1
     * msg : {"user":{"account":"15999761380","createTime":1460444414000,"id":51,"isCoutier":"0","phone":"15999761380","status":"0"},"userToken":"0f31fdd97a44fe324c18053a2d8e3d3f","lsRebate":{"courierCash":0,"courierCashInCode":"2854cb93620140a146fd4ac02ae13f27","id":11,"lastUpdateTime":1460343614000,"rebate":0,"rebateInCode":"2854cb93620140a146fd4ac02ae13f27","status":"0","userId":51}}
     */

    private String status;
    /**
     * user : {"account":"15999761380","createTime":1460444414000,"id":51,"isCoutier":"0","phone":"15999761380","status":"0"}
     * userToken : 0f31fdd97a44fe324c18053a2d8e3d3f
     * lsRebate : {"courierCash":0,"courierCashInCode":"2854cb93620140a146fd4ac02ae13f27","id":11,"lastUpdateTime":1460343614000,"rebate":0,"rebateInCode":"2854cb93620140a146fd4ac02ae13f27","status":"0","userId":51}
     */

    private String msg;



    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.status);
        dest.writeString(this.msg);
    }

    public ResultCopy() {
    }

    protected ResultCopy(Parcel in) {
        this.status = in.readString();
        this.msg = in.readString();
    }

    public static final Creator<ResultCopy> CREATOR = new Creator<ResultCopy>() {
        @Override
        public ResultCopy createFromParcel(Parcel in) {
            return new ResultCopy(in);
        }

        @Override
        public ResultCopy[] newArray(int size) {
            return new ResultCopy[size];
        }
    };
    @Override
    public String toString() {
        return "Result{" +
                "status='" + status + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}
