package com.fasfsfgs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.jta.JtaTransactionManager;

@Configuration
@Import(SpringConfig.class)
@ImportResource("classpath:/com/fasfsfgs/entitymanagerfactory.production.xml")
public class SpringProductionConfig {

  @Bean
  public PlatformTransactionManager transactionManager() {
    return new JtaTransactionManager();
  }

}
