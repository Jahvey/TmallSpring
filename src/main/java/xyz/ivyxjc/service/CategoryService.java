package xyz.ivyxjc.service;

import xyz.ivyxjc.bean.Category;

import java.util.List;

/**
 * Created by jc on 3/21/2017.
 */


public interface CategoryService extends BaseService<Category>{

    @Override
    List<Category> list(int start, int count);

    @Override
    Category get(int id);

    @Override
    void update(Category bean);

    @Override
    void add(Category bean);

    @Override
    void delete(int id);
}
