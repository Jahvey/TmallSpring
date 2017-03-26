package xyz.ivyxjc.mapper;

import org.apache.ibatis.annotations.Mapper;
import xyz.ivyxjc.bean.Category;
import xyz.ivyxjc.utils.DataOffsetSetting;

import java.util.List;

/**
 * Created by jc on 3/19/2017.
 */

@Mapper
public interface CategoryMapper extends BaseMapper<Category>{

    @Override
    void add(Category bean);

    //删除一般会按照primary key来删除, 所以只需要传递key进去即可
    @Override
    void delete(int id);

    @Override
    List<Category> list(DataOffsetSetting s);

    @Override
    Category get(int id);

    @Override
    void update(Category bean);

    @Override
    int getTotal();

}
