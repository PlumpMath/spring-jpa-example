package com.fasfsfgs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.jta.JtaTransactionManager;

@Configuration
@ComponentScan
@ImportResource("classpath:/com/fasfsfgs/entitymanagerfactory.production.xml")
@EnableTransactionManagement
public class SpringProductionConfig {

  @Bean
  public PlatformTransactionManager transactionManager() {
    return new JtaTransactionManager();
  }

}
