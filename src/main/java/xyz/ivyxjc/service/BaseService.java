package xyz.ivyxjc.service;

import xyz.ivyxjc.bean.Category;

import java.util.List;

/**
 * Created by jc on 3/24/2017.
 */


public interface BaseService<T> {
    List<T> list(int start, int count);

    default List<T> list(){
        return list(0,getTotal());
    }

    T get(int id);

    void update(T bean);

    void add(T bean);
    void delete(int id);

    int getTotal();
}
