package io.github.coupon.calc.service.impl;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import io.github.coupon.calc.api.beans.ShoppingCart;
import io.github.coupon.calc.api.beans.SimulationOrder;
import io.github.coupon.calc.api.beans.SimulationResponse;
import io.github.coupon.calc.service.CouponCalculationService;
import io.github.coupon.calc.template.CouponTemplateFactory;
import io.github.coupon.calc.template.RuleTemplate;
import io.github.coupon.template.api.beans.CouponInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * CouponCalculationServiceImpl
 *
 * @author Jackie Hou
 * @date 2024/7/17 20:01
 * @version 1.0
 */
@Slf4j
@Service
public class CouponCalculationServiceImpl implements CouponCalculationService {

    @Override
    public ShoppingCart calculateOrderPrice(@RequestBody ShoppingCart cart) {
        //个人认为将json放到这里不太好！！！
        log.info("calculate order price: {}", JSON.toJSONString(cart));
        RuleTemplate template = factory.getTemplate(cart);
        return template.calculate(cart);
    }

    @Override
    public SimulationResponse simulateOrder(@RequestBody SimulationOrder order) {
        SimulationResponse response = new SimulationResponse();
        Long minOrderPrice = Long.MAX_VALUE;

        for (CouponInfo coupon : order.getCouponInfos()) {
            ShoppingCart cart = new ShoppingCart();
            cart.setProducts(order.getProducts());
            cart.setCouponInfos(Lists.newArrayList(coupon));
            cart = factory.getTemplate(cart).calculate(cart);

            Long couponId = coupon.getId();
            Long orderPrice = cart.getCost();

            // 设置当前优惠券对应的订单价格
            response.getCoupon2OrderPrice().put(couponId, orderPrice);

            // 比较订单价格，设置当前最优优惠券的ID
            if (minOrderPrice > orderPrice) {
                response.setBestCouponId(coupon.getId());
                minOrderPrice = orderPrice;
            }
        }
        return null;
    }

    @Autowired
    private CouponTemplateFactory factory;
}
