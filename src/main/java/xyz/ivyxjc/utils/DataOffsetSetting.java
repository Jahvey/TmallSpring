package xyz.ivyxjc.utils;

/**
 * Created by jc on 3/24/2017.
 */


public class DataOffsetSetting {
    int start;
    int count;
    public DataOffsetSetting(int start, int count){
        this.start=start;
        this.count=count;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
