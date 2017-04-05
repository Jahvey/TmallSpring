package xyz.ivyxjc.service.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.ivyxjc.bean.User;
import xyz.ivyxjc.mapper.UserMapper;
import xyz.ivyxjc.service.UserService;
import xyz.ivyxjc.utils.DataOffsetSetting;

import java.util.List;

/**
 * Created by jc on 4/3/2017.
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper mapper;

    @Autowired
    private SqlSession sqlSession;

    @Override
    public List<User> list(int start, int count) {
        List<User> users=mapper.list(new DataOffsetSetting(start,count));
        return users;
    }

    @Override
    public User get(int id) {
        return mapper.get(id);
    }

    @Override
    public void update(User bean) {
        mapper.update(bean);
        sqlSession.commit();
    }

    @Override
    public void add(User bean) {
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

    @Override
    public User get(String username) {
        return mapper.getByname(username);
    }
}
