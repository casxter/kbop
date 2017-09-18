package com.kbop.config;

import com.github.pagehelper.PageInterceptor;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.plugin.Interceptor;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by WallaceTang on 2017/4/28.
 */
@Configuration
@MapperScan("com.kbop.mapper")
@PropertySource("classpath:jdbc.properties")
@EnableTransactionManagement
public class DataConfig {
    @Autowired
    Environment env;
    @Value("${jdbc.driverClassName}")
    private String JDBC_DRIVERCLASSNAME;
    @Value("${jdbc.url}")
    private String JDBC_URL;
    @Value("${jdbc.username}")
    private String JDBC_USERNAME;
    @Value("${jdbc.password}")
    private String JDBC_PASSWORD;

    //测试 mysql
    @Bean
//    @Profile("dev")
    public DataSource devdataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//        dataSource.setUrl("jdbc:mysql://127.0.0.1/kboptest");
//        dataSource.setUrl("jdbc:mysql://23.106.135.43/kboptest?useSSL=false");
        dataSource.setUrl("jdbc:mysql://127.0.0.1/kboptest?useSSL=false");
        dataSource.setUsername("casxter");
        dataSource.setPassword("JNaRKZytA7PpbrXe");

        return dataSource;
    }

    //生成mysql
    @Bean
    @Profile("prod")
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(JDBC_DRIVERCLASSNAME);
        dataSource.setUrl(JDBC_URL);
        dataSource.setUsername(JDBC_USERNAME);
        dataSource.setPassword(JDBC_PASSWORD);

        return dataSource;
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
//        sessionFactory.setMapperLocations(new Resource[]{"classpath:com.kbop.mapper/*.xml"});
        //mybatis 分页插件 支持
        PageInterceptor pageInterceptor = new PageInterceptor();
        Properties pro = new Properties();
        pro.setProperty("helperDialect", "mysql");
//        pro.setProperty("reasonable", "true");
        pro.setProperty("supportMethodsArguments", "true");
        //使用参数方式
        /*
          List<Country> selectByPageNumSize(
                             @Param("user") User user,
                             @Param("pageNumKey") int pageNum,
                             @Param("pageSizeKey") int pageSize);
         */
//        pro.setProperty("params", "count=countSql;pageNum=pageNumKey;pageSize=pageSizeKey;");
        pro.setProperty("autoRuntimeDialect", "true");

        pageInterceptor.setProperties(pro);
        sessionFactory.setPlugins(new Interceptor[]{pageInterceptor});
        return sessionFactory;
    }

//    @Bean
//    @Profile("dev")
//    public JdbcTemplate jdbcTemplate(DataSource dataSource) throws Exception {
//        return new JdbcTemplate(dataSource);
//    }

    @Bean
    public PlatformTransactionManager txManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

}
