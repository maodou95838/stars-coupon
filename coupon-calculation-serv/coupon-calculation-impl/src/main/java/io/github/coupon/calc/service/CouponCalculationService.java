package io.github.coupon.calc.service;

import io.github.coupon.calc.api.beans.ShoppingCart;
import io.github.coupon.calc.api.beans.SimulationOrder;
import io.github.coupon.calc.api.beans.SimulationResponse;

/**
 * CouponCalculationService
 *
 * @author Jackie Hou
 * @date 2024/7/17 19:59
 * @version 1.0
 */
public interface CouponCalculationService {

    ShoppingCart calculateOrderPrice(ShoppingCart cart);

    SimulationResponse simulateOrder(SimulationOrder order);
}
