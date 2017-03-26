package xyz.ivyxjc.service.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import xyz.ivyxjc.bean.Product;
import xyz.ivyxjc.mapper.ProductMapper;
import xyz.ivyxjc.service.ProductService;
import xyz.ivyxjc.utils.DataOffsetSetting;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductMapper mapper;

    @Autowired
    SqlSession sqlSession;

    @Override
    public void add(Product product) {
        mapper.add(product);
        sqlSession.commit();

    }

    @Override
    public void delete(int id) {
        mapper.delete(id);
        sqlSession.commit();

    }

    @Override
    public Product get(int id) {
        return mapper.get(id);
    }


    @Override
    public List<Product> list(int start, int count) {
        List<Product> products=mapper.list(new DataOffsetSetting(start,count));
        return products;
    }


    @Override
    public void update(Product product) {
        mapper.update(product);
        sqlSession.commit();
    }

    @Override
    public int getTotal() {
        return mapper.getTotal();

    }
}
