package xyz.ivyxjc.mapper;

import xyz.ivyxjc.bean.Product;
import xyz.ivyxjc.service.BaseService;
import xyz.ivyxjc.utils.DataOffsetSetting;

import java.util.List;

/**
 * Created by jc on 3/22/2017.
 */


public interface ProductMapper extends BaseMapper<Product> {
    @Override
    void add(Product product);

    @Override
    void delete(int id);

    @Override
    List<Product> list(DataOffsetSetting s);

    @Override
    Product get(int id);

    @Override
    void update(Product product);

    @Override
    int getTotal();

    List<Product> listFrCategory(int categoryId);
}
