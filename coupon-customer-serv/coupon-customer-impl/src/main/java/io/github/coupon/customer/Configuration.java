package io.github.coupon.customer;


import feign.Logger;
import org.springframework.context.annotation.Bean;

/**
 * webclient Configuration
 *
 * @author Jackie Hou
 * @date 2024/7/23 16:58
 * @version 1.0
 */

@org.springframework.context.annotation.Configuration
public class Configuration {

//    @Bean
//    @LoadBalanced
//    public WebClient.Builder register() {
//        return WebClient.builder();
//    }

    @Bean
    Logger.Level feignLogger() {
        return  Logger.Level.FULL;
    }
}
