package xyz.ivyxjc.service;

import xyz.ivyxjc.bean.Category;

import java.util.List;

/**
 * Created by jc on 3/21/2017.
 */


public interface CategoryService extends BaseService<Category>{
    void fillByRow(List<Category> cs);
}
