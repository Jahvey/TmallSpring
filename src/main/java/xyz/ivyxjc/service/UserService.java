package xyz.ivyxjc.service;

import xyz.ivyxjc.bean.User;

/**
 * Created by jc on 4/3/2017.
 */


public interface UserService extends BaseService<User>{

    public User get(String username);
}
