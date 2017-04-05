//package xyz.ivyxjc.config;
//
//import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
//import org.apache.shiro.cache.ehcache.EhCacheManager;
//import org.apache.shiro.mgt.DefaultSecurityManager;
//import org.apache.shiro.mgt.SecurityManager;
//import org.apache.shiro.realm.Realm;
//import org.apache.shiro.spring.config.ShiroAnnotationProcessorConfiguration;
//import org.apache.shiro.spring.config.ShiroBeanConfiguration;
//import org.apache.shiro.spring.remoting.SecureRemoteInvocationExecutor;
//import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
//import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
//import org.apache.shiro.spring.web.config.ShiroWebConfiguration;
//import org.apache.shiro.spring.web.config.ShiroWebFilterConfiguration;
//import org.apache.shiro.util.Factory;
//import org.springframework.beans.MethodInvocationException;
//import org.springframework.beans.factory.FactoryBean;
//import org.springframework.beans.factory.annotation.Configurable;
//import org.springframework.beans.factory.config.ConfigurableBeanFactory;
//import org.springframework.beans.factory.config.MethodInvokingFactoryBean;
//import org.springframework.context.annotation.*;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.web.context.WebApplicationContext;
//import xyz.ivyxjc.security.realm.UserRealm;
//
//import javax.crypto.SecretKey;
//import javax.sql.DataSource;
//
///**
// * Created by jc on 4/3/2017.
// */
//
//@Configuration
//@PropertySource("classpath:application_shiro.properties")
//@Import({
//        ShiroBeanConfiguration.class,
//        ShiroAnnotationProcessorConfiguration.class,
//        ShiroWebConfiguration.class,
//        ShiroWebFilterConfiguration.class,
//        JspViewConfig.class})
//@ComponentScan("xyz.ivyxjc")
//public class ShiroConfig {
////
////    @Bean
////    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON,
////            proxyMode = ScopedProxyMode.INTERFACES)
////    public SecurityManager securityManager(Realm realm){
////
////        return new DefaultSecurityManager(realm);
////    }
//
//    @Bean(name = "userRealm")
//    public UserRealm jdbcRealm(DataSource dataSource) {
//
//        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
//        credentialsMatcher.setHashAlgorithmName("SHA-512");
//        credentialsMatcher.setStoredCredentialsHexEncoded(false);
//
//        UserRealm jdbcRealm = new UserRealm();
//        jdbcRealm.setName("jdbcRealm");
//        jdbcRealm.setCredentialsMatcher(credentialsMatcher);
//        jdbcRealm.setDataSource(dataSource);
//
//        return jdbcRealm;
//    }
//
//    @Bean
//    public DriverManagerDataSource dataSource(){
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//        dataSource.setUrl("jdbc:mysql://localhost:3306/tmall_t_fore?serverTimezone=UTC");
//        dataSource.setUsername("ivyxjc");
//        dataSource.setPassword("123456");
//        return dataSource;
//    }
//
//
//    @Bean
//    public EhCacheManager cacheManager() {
//
//        EhCacheManager ehCacheManager = new EhCacheManager();
//
//        // Set a net.sf.ehcache.CacheManager instance here if you already have one.
//        // If not, a new one will be creaed with a default config:
//        // ehCacheManager.setCacheManager(...);
//
//        // If you don't have a pre-built net.sf.ehcache.CacheManager instance to inject, but you want
//        // a specific Ehcache configuration to be used, specify that here.  If you don't, a default
//        //will be used.:
//        // ehCacheManager.setCacheManagerConfigFile("classpath:some/path/to/ehcache.xml");
//
//        return ehCacheManager;
//    }
//
//
//
//
//
//
//}
