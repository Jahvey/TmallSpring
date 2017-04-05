package xyz.ivyxjc.mapper;

import org.apache.ibatis.annotations.Mapper;
import xyz.ivyxjc.bean.User;
import xyz.ivyxjc.utils.DataOffsetSetting;

import java.util.List;

/**
 * Created by jc on 4/3/2017.
 */

@Mapper
public interface UserMapper extends BaseMapper<User>{
    @Override
    void add(User bean);

    @Override
    void delete(int id);

    @Override
    List<User> list(DataOffsetSetting s);

    @Override
    List<User> list();

    @Override
    User get(int id);

    @Override
    void update(User bean);

    @Override
    int getTotal();

    User getByname(String name);
}
