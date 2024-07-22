package io.github.coupon.customer.api.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * RequestCoupon
 *
 * @author Jackie Hou
 * @date 2024/7/17 21:57
 * @version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestCoupon {

    private Long userId;

    private Long couponTemplateId;
}
