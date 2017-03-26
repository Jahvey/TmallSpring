package xyz.ivyxjc.service;

import xyz.ivyxjc.bean.Product;

import java.util.List;

/**
 * Created by jc on 3/24/2017.
 */


public interface ProductService extends BaseService<Product> {

    @Override
    void add(Product product);

    @Override
    void delete(int id);

    @Override
    Product get(int id);

    @Override
    List<Product> list(int start, int count);

    @Override
    void update(Product product);

    //获取总数量
    @Override
    int getTotal();

}
