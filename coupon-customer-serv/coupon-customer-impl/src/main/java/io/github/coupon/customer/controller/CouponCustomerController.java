package io.github.coupon.customer.controller;

import io.github.coupon.calc.api.beans.ShoppingCart;
import io.github.coupon.calc.api.beans.SimulationOrder;
import io.github.coupon.calc.api.beans.SimulationResponse;
import io.github.coupon.customer.api.beans.RequestCoupon;
import io.github.coupon.customer.api.beans.SearchCoupon;
import io.github.coupon.customer.dao.entity.Coupon;
import io.github.coupon.customer.service.CouponCustomerService;
import io.github.coupon.template.api.beans.CouponInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
@RefreshScope
public class CouponCustomerController {

    @PostMapping("requestCoupon")
    public Coupon requestCoupon(@RequestBody RequestCoupon request) {
        if (disableCoupon) {
            log.info("暂停领取优惠券");
            return  null;
        }

        return customerService.requestCoupon(request);
    }

    @PostMapping("/findCoupon")
    public List<CouponInfo> findCoupon(SearchCoupon request) {
        return customerService.findCoupon(request);
    }

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

    @Value("${disableCouponRequest:false}")
    private Boolean disableCoupon;
}
