package io.github.coupon.template.api.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.Stream;

/**
 * CouponType
 *
 * @author Jackie Hou
 * @date 2024/7/15 18:18
 * @version 1.0
 */
@Getter
@AllArgsConstructor
public enum CouponType {

    UNKNOW("unknow", "0"),
    MONEY_OFF("满减券", "1"),
    DISCOUNT("打折", "2"),
    RANDOM_DISCOUNT("随机减", "3"),
    LONELY_NIGHE_MONEY_OFF("晚间双倍优惠券","4")
    ;

    public static CouponType convert(String code) {
        return Stream.of(values()).filter(e -> e.code.equalsIgnoreCase(code)).findFirst().orElse(UNKNOW);
    }

    private String description;

    private String code;
}
