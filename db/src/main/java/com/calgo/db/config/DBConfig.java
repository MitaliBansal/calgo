//package com.calgo.db.config;
//
//import com.zaxxer.hikari.HikariDataSource;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.env.Environment;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import javax.persistence.EntityManagerFactory;
//import javax.sql.DataSource;
//
//import static com.calgo.db.constants.DBConstants.DB_CONSTANTS.*;
//
//@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories(
//        basePackages = "com.calgo.db.repository",
//        entityManagerFactoryRef = "calgoEntityManagerFactory",
//        transactionManagerRef = "calgoTransactionManager"
//)
//public class DBConfig {
//
//    @Autowired
//    private Environment env;
//
//    @Bean
//    public DataSource dataSource(){
//        HikariDataSource hikariDataSource= (HikariDataSource) DataSourceBuilder.create().build();
//        hikariDataSource.setConnectionTimeout(Long.parseLong(env.getProperty(CONNECTION_TIMEOUT)));
//        hikariDataSource.setMaximumPoolSize(Integer.parseInt(env.getProperty(MAX_POOL_SIZE)));
//        hikariDataSource.setMinimumIdle(Integer.parseInt(env.getProperty(MIN_IDLE)));
//        hikariDataSource.setPoolName(env.getProperty(POOL_NAME));
//        hikariDataSource.setJdbcUrl(env.getProperty(JDBC_URL));
//        hikariDataSource.setUsername(env.getProperty(USERNAME));
//        hikariDataSource.setPassword(env.getProperty(PASSWORD));
//        hikariDataSource.setDriverClassName(env.getProperty(DRIVER_CLASS_NAME));
//        return hikariDataSource;
//    }
//
//    @Bean(name = "calgoEntityManagerFactory")
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder, DataSource dataSource) {
//        return builder
//                .dataSource(dataSource)
//                .packages("com.calgo.db.entities")
//                .build();
//    }
//
//    @Bean(name = "calgoTransactionManager")
//    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
//        return new JpaTransactionManager(entityManagerFactory);
//    }
//
//}
