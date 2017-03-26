//package xyz.ivyxjc.config;
//
//import org.apache.ibatis.session.SqlSession;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Scope;
//import org.springframework.context.annotation.ScopedProxyMode;
//import org.springframework.stereotype.Component;
//import org.springframework.web.context.WebApplicationContext;
//import xyz.ivyxjc.mapper.CategoryMapper;
//import xyz.ivyxjc.utils.SqlSessionFactoryUtil;
//
///**
// * Created by jc on 3/21/2017.
// */
//
//@Component
//public class BeanConfig {
//
//    @Bean
//    @Scope(value = WebApplicationContext.SCOPE_SESSION,
//            proxyMode = ScopedProxyMode.INTERFACES)
//    public SqlSession getSqlSession(){
//        return SqlSessionFactoryUtil.openSqlSession();
//    }
//
//    @Bean
//    @Scope(value = WebApplicationContext.SCOPE_SESSION,
//            proxyMode = ScopedProxyMode.INTERFACES)
//    public CategoryMapper getCategoryMapper(){
//        return getSqlSession().getMapper(CategoryMapper.class);
//    }
//}
