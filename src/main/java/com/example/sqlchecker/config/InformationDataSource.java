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
//        transactionManagerRef = "informationTransactionManager",
//        basePackages = "com.example.sqlchecker.repository.information"
//)
//public class UserDataSourceConfig {
//    @Bean
//    @Primary
//    @ConfigurationProperties(prefix = "information.datasource")
//    public DataSourceProperties userDataSourceProperties() {
//        return new DataSourceProperties();
//    }
//
//    @Bean(name = "informationDataSource")
//    @Primary
//    public DataSource userDataSource(
//            @Qualifier("informationDataSourceProperties") DataSourceProperties dataSourceProperties) {
//        return dataSourceProperties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
//    }
//
//    @Bean(name = "informationEntityManagerFactory")
//    @Primary
//    public LocalContainerEntityManagerFactoryBean userEntityManagerFactory(
//            EntityManagerFactoryBuilder builder,
//            @Qualifier("informationDataSource") DataSource dataSource) {
//        return builder
//                .dataSource(dataSource)
//                .packages("com.example.sqlchecker.repository.domain.information")
//                .persistenceUnit("informationEntityManager")
//                .build();
//    }
//
//    @Bean
//    @Primary
//    public PlatformTransactionManager userTransactionManager(
//            @Qualifier("informationEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
//        return new JpaTransactionManager(entityManagerFactory);
//    }
//}