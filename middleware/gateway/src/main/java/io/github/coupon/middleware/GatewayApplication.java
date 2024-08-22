package io.github.coupon.middleware;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * GatewayApplication
 *
 * @author Jackie Hou
 * @date 2024/8/15 22:32
 * @version 1.0
 */

@SpringBootApplication
public class GatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
        System.out.println("启动成功了");

    }
}
