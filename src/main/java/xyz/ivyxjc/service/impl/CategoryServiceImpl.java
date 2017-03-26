package xyz.ivyxjc.service.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.ivyxjc.bean.Category;
import xyz.ivyxjc.bean.Product;
import xyz.ivyxjc.mapper.CategoryMapper;
import xyz.ivyxjc.service.CategoryService;
import xyz.ivyxjc.utils.DataOffsetSetting;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jc on 3/21/2017.
 */

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryMapper mapper;

    @Autowired
    SqlSession sqlSession;


    @Override
    public List<Category> list(int start, int count) {
        List<Category> cs=mapper.list(new DataOffsetSetting(start,count));
        List<Product> products=cs.get(0).getProducts();
        System.out.println("----------------");
        System.out.println(products.get(0));
        System.out.println(products.get(0).getProductImages()==null);
        fillByRow(cs);
        return cs;
    }

    @Override
    public Category get(int id) {
        return mapper.get(id);
    }

    /**
     * 需要sqlSession.commit()才能将更改提交到数据库中.
     * @param bean
     */
    @Override
    public void update(Category bean) {
        mapper.update(bean);
        sqlSession.commit();

    }

    @Override
    public void add(Category bean) {
        mapper.add(bean);
        sqlSession.commit();
    }

    @Override
    public void delete(int id) {
        mapper.delete(id);
        sqlSession.commit();

    }

    @Override
    public int getTotal() {
        return mapper.getTotal();
    }

    public void fillByRow(List<Category> cs) {
        int productNumberEachRow = 8;
        for (Category c : cs) {
            List<Product> products =  c.getProducts();
            List<List<Product>> productsByRow =  new ArrayList<>();
            for (int i = 0; i < products.size(); i+=1) {
                int size = i+productNumberEachRow;
                size= size>products.size()?products.size():size;
                List<Product> productsOfEachRow =products.subList(i, size);
                productsByRow.add(productsOfEachRow);
            }
            c. setProductsByRow(productsByRow);
        }
    }
}
