package io.github.coupon.calc.controller;

import com.alibaba.fastjson.JSON;
import io.github.coupon.calc.api.beans.ShoppingCart;
import io.github.coupon.calc.api.beans.SimulationOrder;
import io.github.coupon.calc.api.beans.SimulationResponse;
import io.github.coupon.calc.service.CouponCalculationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * CouponCalculationController
 *
 * @author Jackie Hou
 * @date 2024/7/17 21:35
 * @version 1.0
 */
@Slf4j
@RestController
@RequestMapping("/calculate")
public class CouponCalculationController {

    /**
     * 用优惠券结算
     * @param cart
     * @return
     */
    @PostMapping("/checkout")
    @ResponseBody
    public ShoppingCart calculateOrderPrice(@RequestBody ShoppingCart cart) {
        log.info("do calculate: {}", JSON.toJSONString(cart));
        return calculationService.calculateOrderPrice(cart);
    }


    @PostMapping("/simulate")
    @ResponseBody
    public SimulationResponse simulate(@RequestBody SimulationOrder order) {
        log.info("do simulation: {}", JSON.toJSONString(order));
        return calculationService.simulateOrder(order);
    }


    @Autowired
    private CouponCalculationService calculationService;
}
