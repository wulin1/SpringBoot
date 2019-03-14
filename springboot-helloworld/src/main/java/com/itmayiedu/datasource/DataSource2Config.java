//package com.itmayiedu.datasource;
//
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.SqlSessionTemplate;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//
//import javax.sql.DataSource;
//
//@Configuration // 注册到springboot容器中
//@MapperScan(basePackages = "com.itmayiedu.test02", sqlSessionFactoryRef = "test2SqlSessionFactory")
//public class DataSource2Config {
//
//    /**
//     *
//     * @methodDesc: 功能描述:(配置test2数据库)
//     */
//    @Bean(name = "test2DataSource")
//    @ConfigurationProperties(prefix = "spring.datasource.test2")
//    public DataSource testDataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//    /**
//     *
//     * @methodDesc: 功能描述:(test2 sql会话工厂)
//     * @author: 吴林
//
//     */
//    @Bean(name = "test2SqlSessionFactory")
//
//    public SqlSessionFactory testSqlSessionFactory(@Qualifier("test2DataSource") DataSource dataSource)
//            throws Exception {
//        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
//        bean.setDataSource(dataSource);
////		bean.setMapperLocations(
////				new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mapper/test2/*.xml"));
//        return bean.getObject();
//    }
//
//    /**
//     *
//     * @methodDesc: 功能描述:(test2 事物管理)
//     */
//    @Bean(name = "test2TransactionManager")
//
//    public DataSourceTransactionManager testTransactionManager(@Qualifier("test2DataSource") DataSource dataSource) {
//        return new DataSourceTransactionManager(dataSource);
//    }
//
//    @Bean(name = "test2SqlSessionTemplate")
//    public SqlSessionTemplate testSqlSessionTemplate(
//            @Qualifier("test2SqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
//        return new SqlSessionTemplate(sqlSessionFactory);
//    }
//
//}