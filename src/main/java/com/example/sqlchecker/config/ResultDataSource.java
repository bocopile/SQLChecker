//package imqa.office.imqabackoffice.config;
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
//        entityManagerFactoryRef = "informationEntityManagerFactory",
//        transactionManagerRef = "resultTransactionManager",
//        basePackages = "com.example.sqlchecker.repository.result"
//)
//public class ResultDataSourceConfig {
//    @Bean
//    @Primary
//    @ConfigurationProperties(prefix = "result.datasource")
//    public DataSourceProperties resultDataSourceProperties() {
//        return new DataSourceProperties();
//    }
//
//    @Bean(name = "resultDataSource")
//    @Primary
//    public DataSource userDataSource(
//            @Qualifier("resultDataSourceProperties") DataSourceProperties dataSourceProperties) {
//        return dataSourceProperties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
//    }
//
//    @Bean(name = "resultEntityManagerFactory")
//    @Primary
//    public LocalContainerEntityManagerFactoryBean resultEntityManagerFactory(
//            EntityManagerFactoryBuilder builder,
//            @Qualifier("informationDataSource") DataSource dataSource) {
//        return builder
//                .dataSource(dataSource)
//                .packages("com.example.sqlchecker.repository.domain.result")
//                .persistenceUnit("informationEntityManager")
//                .build();
//    }
//
//    @Bean
//    @Primary
//    public PlatformTransactionManager resultTransactionManager(
//            @Qualifier("informationEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
//        return new JpaTransactionManager(entityManagerFactory);
//    }
//}