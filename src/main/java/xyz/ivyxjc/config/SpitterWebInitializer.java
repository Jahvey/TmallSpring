//package xyz.ivyxjc.config;
//
//import org.springframework.web.context.ContextLoaderListener;
//import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
//import org.springframework.web.filter.DelegatingFilterProxy;
//import org.springframework.web.servlet.DispatcherServlet;
//import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
//import org.springframework.web.util.Log4jConfigListener;
//
//import javax.servlet.*;
//import java.util.EnumSet;
//
///**
// * Created by jc on 3/19/2017.
// */
//
//
//public class SpitterWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{
//    @Override
//    protected Class<?>[] getRootConfigClasses() {
//        return new Class<?>[]{RootConfig.class};
//    }
//
//    @Override
//    protected Class<?>[] getServletConfigClasses() {
//        return new Class<?>[]{JspViewConfig.class};
//    }
//
//    @Override
//    protected String[] getServletMappings() {
//        return new String[]{"/"};
//    }
//
//
//}
//
