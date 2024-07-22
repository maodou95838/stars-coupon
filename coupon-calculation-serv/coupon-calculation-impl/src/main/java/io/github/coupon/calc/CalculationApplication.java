package io.github.coupon.calc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * CalculationApplication
 *
 * @author Jackie Hou
 * @date 2024/7/17 21:48
 * @version 1.0
 */
@SpringBootApplication
@ComponentScan(basePackages = "io.github.coupon")
public class CalculationApplication {
    public static void main(String[] args) {
        SpringApplication.run(CalculationApplication.class, args);
        System.out.println("Hi, there! 启动成功！");
    }
}
