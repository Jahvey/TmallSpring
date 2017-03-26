package xyz.ivyxjc.mapper;

import xyz.ivyxjc.bean.Category;
import xyz.ivyxjc.utils.DataOffsetSetting;

import java.util.List;

/**
 * Created by jc on 3/24/2017.
 */


public interface BaseMapper<T> {
    void add(T bean);

    //删除一般会按照primary key来删除, 所以只需要传递key进去即可
    void delete(int id);

    List<T> list(DataOffsetSetting s);

    List<T> list();

    T get(int id);

    void update(T bean);

    int getTotal();
}
