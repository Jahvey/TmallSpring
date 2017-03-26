package xyz.ivyxjc.config;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import xyz.ivyxjc.mapper.CategoryMapper;
import xyz.ivyxjc.mapper.ProductMapper;
import xyz.ivyxjc.utils.SqlSessionFactoryUtil;

/**
 * Created by jc on 3/19/2017.
 */


@ComponentScan(basePackages = {"xyz.ivyxjc"},
                    excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION,value = EnableWebMvc.class)
                    })
public class RootConfig {

    @Autowired
    SqlSession sqlSession;

    @Bean
    @Scope(value = WebApplicationContext.SCOPE_SESSION,
            proxyMode = ScopedProxyMode.INTERFACES)
    public SqlSession getSqlSession(){
        return SqlSessionFactoryUtil.openSqlSession();
    }

    @Bean
    @Scope(value = WebApplicationContext.SCOPE_SESSION,
            proxyMode = ScopedProxyMode.INTERFACES)
    public CategoryMapper getCategoryMapper(){
        return sqlSession.getMapper(CategoryMapper.class);
    }


    @Bean
    @Scope(value = WebApplicationContext.SCOPE_SESSION,
            proxyMode = ScopedProxyMode.INTERFACES)
    public ProductMapper getProductMapper(){
        return sqlSession.getMapper(ProductMapper.class);
    }

//    @Bean
//    public SqlSessionFactory sqlSessionFactory() throws Exception {
//        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
//        sqlSessionFactory.setDataSource(dataSource());
//        return (SqlSessionFactory) sqlSessionFactory.getObject();
//    }
//
//    @Bean
//    public CategoryMapper userMapper() throws Exception {
//        SqlSessionTemplate sessionTemplate = new SqlSessionTemplate(sqlSessionFactory());
//        return sessionTemplate.getMapper(CategoryMapper.class);
//    }
}
