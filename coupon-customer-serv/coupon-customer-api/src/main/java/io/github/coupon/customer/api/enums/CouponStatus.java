package io.github.coupon.customer.api.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * CouponStatus
 *
 * @author Jackie Hou
 * @date 2024/7/17 22:20
 * @version 1.0
 */
@Getter
@AllArgsConstructor
public enum CouponStatus {

    AVAILABLE("未使用", 1),
    USED("已使用", 2),
    INACTIVE("已注销", 3)
    ;

    private String desc;

    private Integer code;

    public static CouponStatus convert(Integer code) {

        return null;
    }
}
