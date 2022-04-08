package com.elcom.library.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "LibEntityManagerFactory",
                        basePackages = {"com.elcom.library.repository.lib"},
                        transactionManagerRef = "LibTransactionManager")
public class LibDBConfig {

    @Bean(name = "LibDatasource")
    @ConfigurationProperties(prefix = "spring.db1.datasource")
    public DataSource mySqlSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "LibEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(EntityManagerFactoryBuilder builder,
                                                                           @Qualifier("LibDatasource") DataSource dataSource){
        Map<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl-auto", "update");
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");

        return builder
                .dataSource(dataSource)
                .properties(properties)
                .packages("com.elcom.library.entity.lib")
                .build();

    }

    @Bean(name = "LibTransactionManager")
    public PlatformTransactionManager transactionManager(@Qualifier("LibEntityManagerFactory")EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
