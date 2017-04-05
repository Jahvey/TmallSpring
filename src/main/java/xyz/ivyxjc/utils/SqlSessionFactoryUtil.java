//package xyz.ivyxjc.utils;
//
//import org.apache.ibatis.io.Resources;
//import org.apache.ibatis.session.SqlSession;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.apache.ibatis.session.SqlSessionFactoryBuilder;
//
//import java.io.IOException;
//import java.io.InputStream;
//
///**
// * Created by ivxyjc on 2017/2/21.
// */
//public class SqlSessionFactoryUtil {
//
//    private static SqlSessionFactory sSqlSessionFactory=null;
//
//
//    private static final Class CLASS_LOCK=SqlSessionFactoryUtil.class;
//
//
//    private SqlSessionFactoryUtil(){
//    }
//
//    private static SqlSessionFactory initSqlSessionFactory(){
//        String resource= "mybatis_config.xml";
//        InputStream inputStream=null;
//
//        try{
//            inputStream=Resources.getResourceAsStream(resource);
//        }catch (IOException e){
//
//        }
//        synchronized (CLASS_LOCK){
//            if(sSqlSessionFactory==null){
//                SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
//                sSqlSessionFactory=builder.build(inputStream);
//            }
//        }
//        return sSqlSessionFactory;
//    }
//
//    /**
//     * open sqlSessionFactory
//     */
//    public static SqlSession openSqlSession(){
//        if(sSqlSessionFactory==null) {
//            initSqlSessionFactory();
//        }
//        return sSqlSessionFactory.openSession();
//    }
//
//
//}
