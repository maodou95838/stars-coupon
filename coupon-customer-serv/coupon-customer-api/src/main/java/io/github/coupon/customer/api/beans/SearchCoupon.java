package io.github.coupon.customer.api.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * SearchCoupon
 *
 * @author Jackie Hou
 * @date 2024/7/17 21:58
 * @version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchCoupon {

    private Long userId;

    private Long shopId;

    private Integer couponStatus;
}
