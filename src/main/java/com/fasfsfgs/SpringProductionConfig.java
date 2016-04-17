package com.fasfsfgs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ComponentScan
@ImportResource("classpath:/com/fasfsfgs/entitymanagerfactory.production.xml")
public class SpringProductionConfig {

}
