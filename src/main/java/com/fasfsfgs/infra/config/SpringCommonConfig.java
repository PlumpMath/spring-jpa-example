package com.fasfsfgs.infra.config;

import java.util.Properties;

import javax.annotation.Nullable;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.fasfsfgs.example.business._BusinessPackage;
import com.fasfsfgs.example.dao._DAOPackage;
import com.fasfsfgs.example.entity._EntityPackage;

@Configuration
@Import(SpringQuerydslConfig.class)
@ComponentScan(basePackageClasses = {_DAOPackage.class, _BusinessPackage.class})
@EnableTransactionManagement
public abstract class SpringCommonConfig {

  @Bean
  protected abstract DataSource dataSource();

  @Bean
  protected LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean(
      final DataSource ds) {
    LocalContainerEntityManagerFactoryBean lcemfb = new LocalContainerEntityManagerFactoryBean();
    lcemfb.setDataSource(ds);
    lcemfb.setPackagesToScan(_EntityPackage.class.getPackage().getName());
    lcemfb.setJpaProperties(getJPAProperties());

    HibernateJpaVendorAdapter hjva = new HibernateJpaVendorAdapter();
    lcemfb.setJpaVendorAdapter(hjva);

    return lcemfb;
  }

  private Properties getJPAProperties() {
    Properties properties = new Properties();

    if (getJPACustomProperties() != null) {
      properties.putAll(getJPACustomProperties());
    }

    return properties;
  }

  @Nullable
  protected Properties getJPACustomProperties() {
    return null;
  }

  @Bean
  protected PlatformTransactionManager platformTransactionManager(final EntityManagerFactory emf) {
    return new JpaTransactionManager(emf);
  }

}
