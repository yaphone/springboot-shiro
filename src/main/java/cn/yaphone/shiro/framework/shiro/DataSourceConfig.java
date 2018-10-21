package cn.yaphone.shiro.framework.shiro;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author https://github.com/yaphone
 * @version 1.0
 * @date 2018/10/7 1:13
 */
@Configuration
public class DataSourceConfig {

    @Bean(name = "shiroDataSource")
    @Qualifier("shiroDataSource")
    @ConfigurationProperties(prefix="spring.datasource.shiro")
    public DataSource shiroDataSource() {
        return DataSourceBuilder.create().build();
    }

}
