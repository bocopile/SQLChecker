//package com.example.sqlchecker.config;
//
//import com.zaxxer.hikari.HikariDataSource;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import javax.persistence.EntityManagerFactory;
//import javax.sql.DataSource;
//
//@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories(
//        entityManagerFactoryRef = "confirmEntityManagerFactory",
//        transactionManagerRef = "confirmTransactionManager",
//        basePackages = "com.example.sqlchecker.repository.confirm"
//)
//public class ConfirmDataSourceConfig {
//    @Bean
//    @Primary
//    @ConfigurationProperties(prefix = "confirm.datasource")
//    public DataSourceProperties confirmDataSourceProperties() {
//        return new DataSourceProperties();
//    }
//
//    @Bean(name = "confirmDataSource")
//    @Primary
//    public DataSource confirmDataSource(
//            @Qualifier("confirmDataSourceProperties") DataSourceProperties dataSourceProperties) {
//        return dataSourceProperties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
//    }
//
//    @Bean(name = "confirmEntityManagerFactory")
//    @Primary
//    public LocalContainerEntityManagerFactoryBean confirmEntityManagerFactory(
//            EntityManagerFactoryBuilder builder,
//            @Qualifier("confirmDataSource") DataSource dataSource) {
//        return builder
//                .dataSource(dataSource)
//                .packages("com.example.sqlchecker.repository.domain.confirm")
//                .persistenceUnit("confirmEntityManager")
//                .build();
//    }
//
//    @Bean
//    @Primary
//    public PlatformTransactionManager confirmTransactionManager(
//            @Qualifier("confirmEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
//        return new JpaTransactionManager(entityManagerFactory);
//    }
//}