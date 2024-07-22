package io.github.coupon.customer.service;

import io.github.coupon.calc.api.beans.ShoppingCart;
import io.github.coupon.calc.api.beans.SimulationOrder;
import io.github.coupon.calc.api.beans.SimulationResponse;
import io.github.coupon.customer.api.beans.RequestCoupon;
import io.github.coupon.customer.api.beans.SearchCoupon;
import io.github.coupon.customer.dao.entity.Coupon;
import io.github.coupon.template.api.beans.CouponInfo;
import org.hibernate.internal.SharedSessionCreationOptions;

import java.util.List;

/**
 * CouponCustomerService
 *
 * @author Jackie Hou
 * @date 2024/7/20 13:50
 * @version 1.0
 */
public interface CouponCustomerService {

    Coupon requestCoupon(RequestCoupon request);

    ShoppingCart placeOrder(ShoppingCart shoppingCart);

    SimulationResponse simulateOrderPrice(SimulationOrder order);

    void deleteCoupon(Long userId, Long couponId);

    List<CouponInfo> findCoupon(SearchCoupon request);
}
