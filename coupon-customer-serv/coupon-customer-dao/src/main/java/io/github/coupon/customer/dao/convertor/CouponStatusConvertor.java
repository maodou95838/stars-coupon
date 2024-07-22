package io.github.coupon.customer.dao.convertor;

import io.github.coupon.customer.api.enums.CouponStatus;

import javax.persistence.AttributeConverter;

/**
 * CouponStatusConvertor
 *
 * @author Jackie Hou
 * @date 2024/7/17 22:18
 * @version 1.0
 */
public class CouponStatusConvertor implements AttributeConverter<CouponStatus, Integer> {

    @Override
    public Integer convertToDatabaseColumn(CouponStatus couponStatus) {
        return null;
    }

    @Override
    public CouponStatus convertToEntityAttribute(Integer integer) {
        return null;
    }
}
