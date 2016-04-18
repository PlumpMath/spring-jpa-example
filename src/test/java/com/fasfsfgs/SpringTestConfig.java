package com.fasfsfgs;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.dialect.PostgreSQL94Dialect;
import org.postgresql.Driver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import com.fasfsfgs.SpringConfig;

@Configuration
@Import(SpringConfig.class)
public class SpringTestConfig {

  @Bean
  public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
    LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
    emf.setDataSource(dataSource());
    // em.setPackagesToScan(new String[] {"org.baeldung.persistence.model"});

    JpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
    emf.setJpaVendorAdapter(jpaVendorAdapter);
    emf.getJpaPropertyMap().put("hibernate.dialect", PostgreSQL94Dialect.class.getName());

    return emf;
  }

  @Bean
  public DataSource dataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName(Driver.class.getName());
    dataSource.setUrl("jdbc:postgresql://localhost:5432/testdb");
    dataSource.setUsername("testdbuser");
    dataSource.setPassword("123456");
    return dataSource;
  }

  @Bean
  public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
    JpaTransactionManager transactionManager = new JpaTransactionManager();
    transactionManager.setEntityManagerFactory(emf);

    return transactionManager;
  }

  // @Bean
  // public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
  // return new PersistenceExceptionTranslationPostProcessor();
  // }

  // Properties additionalProperties() {
  // Properties properties = new Properties();
  // properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
  // properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
  // return properties;
  // }

}
