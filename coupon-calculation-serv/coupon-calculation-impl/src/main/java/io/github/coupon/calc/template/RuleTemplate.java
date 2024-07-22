package io.github.coupon.calc.template;

import io.github.coupon.calc.api.beans.ShoppingCart;

/**
 * RuleTemplate
 *
 * @author Jackie Hou
 * @date 2024/7/17 18:08
 * @version 1.0
 */
public interface RuleTemplate {

    /**
     * 优惠券计算
     * @param shoppingCart
     * @return
     */
    ShoppingCart calculate(ShoppingCart shoppingCart);
}
