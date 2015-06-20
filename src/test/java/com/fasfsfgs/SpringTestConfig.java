package com.fasfsfgs;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.cfg.Environment;
import org.hsqldb.jdbcDriver;
import org.springframework.context.annotation.Configuration;

import com.fasfsfgs.SpringCommonConfig;

@Configuration
public class SpringTestConfig extends SpringCommonConfig {

  @Override
  protected DataSource dataSource() {
    BasicDataSource bds = new BasicDataSource();
    bds.setDriverClassName(jdbcDriver.class.getName());
    bds.setUrl("jdbc:hsqldb:mem:mydb");
    bds.setUsername("sa");
    bds.setPassword("");

    return bds;
  }

  @Override
  protected Properties getJPACustomProperties() {
    Properties jpaProperties = new Properties();
    jpaProperties.setProperty(Environment.HBM2DDL_AUTO, "create-drop");

    return jpaProperties;
  }

}
