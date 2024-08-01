package io.github.coupon.customer.feign;

import io.github.coupon.calc.api.beans.ShoppingCart;
import io.github.coupon.calc.api.beans.SimulationOrder;
import io.github.coupon.calc.api.beans.SimulationResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * CalculationService 远程feign接口
 *
 * @author Jackie Hou
 * @date 2024/7/23 19:22
 * @version 1.0
 */
@FeignClient(value = "coupon-calculation-serv", path="/calculator")
public interface CalculationService {

    @PostMapping("/checkout")
    ShoppingCart checkout(ShoppingCart settlement);


    @PostMapping("/simulate")
    SimulationResponse simulate(SimulationOrder simulationOrder);

}
