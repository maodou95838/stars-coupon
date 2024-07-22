package io.github.coupon.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * CustomerApplication
 *
 * @author Jackie Hou
 * @date 2024/7/22 17:02
 * @version 1.0
 */
@SpringBootApplication
@ComponentScan("io.github.coupon")
//@EnableJpaAuditing
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"io.github.coupon.customer"})
@EntityScan(basePackages = {"io.github.coupon.customer"})
public class CustomerApplication {


    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class, args);
        System.out.println("------------------------");
        System.out.println("启动成功了");
    }
}
