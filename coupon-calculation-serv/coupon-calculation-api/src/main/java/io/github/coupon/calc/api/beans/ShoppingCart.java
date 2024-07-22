package io.github.coupon.calc.api.beans;

import io.github.coupon.template.api.beans.CouponInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * ShoppingCart
 *
 * @author Jackie Hou
 * @date 2024/7/17 17:06
 * @version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingCart {

    private List<Product> products;

    private Long couponId;

    private List<CouponInfo> couponInfos;

    private Long cost;

    private Long userId;
}
