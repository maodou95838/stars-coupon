package io.github.coupon.customer.service;

import io.github.coupon.customer.dao.entity.Coupon;
import io.github.coupon.template.api.beans.CouponInfo;

/**
 * CouponConverter
 *
 * @author Jackie Hou
 * @date 2024/7/22 16:27
 * @version 1.0
 */
public class CouponConverter {

    public static CouponInfo convert2Coupon(Coupon coupon) {
        return CouponInfo.builder()
                .id(coupon.getId())
                .status(coupon.getStatus().getCode())
                .templateId(coupon.getTemplateId())
                .shopId(coupon.getShopId())
                .userId(coupon.getUserId())
                .template(coupon.getTemplateInfo())
                .build();
    }
}
