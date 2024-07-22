package io.github.coupon.customer.controller;

import io.github.coupon.calc.api.beans.ShoppingCart;
import io.github.coupon.calc.api.beans.SimulationOrder;
import io.github.coupon.calc.api.beans.SimulationResponse;
import io.github.coupon.customer.service.CouponCustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * CouponCustomerController
 *
 * @author Jackie Hou
 * @date 2024/7/22 16:45
 * @version 1.0
 */
@RestController
@Slf4j
@RequestMapping("/coupon-customer")
public class CouponCustomerController {

    @DeleteMapping("deleteCoupon")
    public void deleteCoupon(@RequestParam("userId") Long userId, @RequestParam("couponId") Long couponId) {
        customerService.deleteCoupon(userId, couponId);
    }


    @PostMapping("/simulateOrder")
    public SimulationResponse simulate(@RequestBody SimulationOrder order) {
        return customerService.simulateOrderPrice(order);
    }

    @PostMapping("checkout")
    public ShoppingCart checkout(@RequestBody ShoppingCart cart) {
        return customerService.placeOrder(cart);
    }

    @Autowired
    private CouponCustomerService customerService;
}
