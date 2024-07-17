package io.github.coupon.template.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * TemplateServiceApplication
 *
 * @author Jackie Hou
 * @date 2024/7/16 17:35
 * @version 1.0
 *
 * 说明：
 * 如果使用的jpa， 这两个注解加上，我折腾了一天
 * @EntityScan(basePackages = {"io.github.coupon"})
 * @EnableJpaRepositories(basePackages = {"io.github.coupon"})
 */
@SpringBootApplication
@ComponentScan(basePackages = {"io.github.coupon.template"})
@EnableJpaAuditing
@EntityScan(basePackages = {"io.github.coupon"})
@EnableJpaRepositories(basePackages = {"io.github.coupon"})
@Slf4j
public class TemplateServiceApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(TemplateServiceApplication.class, args);

        String[] names = context.getBeanDefinitionNames();
        List<String> filtedNames = Arrays.stream(names)
                .filter(e -> e.contains("coupon")).collect(Collectors.toList());
       filtedNames.forEach(e -> log.info(e));

        System.out.println("成功启动");
    }


}
