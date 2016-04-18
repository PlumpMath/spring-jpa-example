package com.fasfsfgs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("com.fasfsfgs.example")
@EnableTransactionManagement
public class SpringConfig {

}
