package com.miaskor.todo.spring.config;

import by.miaskor.rest.connector.ClientConnector;
import by.miaskor.rest.connector.TaskConnector;
import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {
  //Redundant, but if you wanna set particular URL, must used this bean
    /*@Bean
    public FilterRegistrationBean<MainFilter> filterRegistrationBean(){
        FilterRegistrationBean<MainFilter> filterBean = new FilterRegistrationBean<>();
        filterBean.setFilter(new MainFilter());
        filterBean.addUrlPatterns("*");
        return filterBean;
    }*/

  @Bean
  public ClientConnector clientConnector() {
    return Feign.builder()
        .client(new OkHttpClient())
        .decoder(new GsonDecoder())
        .encoder(new GsonEncoder())
        .logger(new Slf4jLogger(ClientConnector.class))
        .logLevel(Logger.Level.FULL)
        .target(ClientConnector.class, "http://localhost:8080/api/clients");
  }

  @Bean
  public TaskConnector taskConnector() {
    return Feign.builder()
        .client(new OkHttpClient())
        .decoder(new GsonDecoder())
        .encoder(new GsonEncoder())
        .logger(new Slf4jLogger(TaskConnector.class))
        .logLevel(Logger.Level.FULL)
        .target(TaskConnector.class, "http://localhost:8080/api/tasks");
  }
}
