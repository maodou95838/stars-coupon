package io.github.coupon.template.dao.convert;

import io.github.coupon.template.api.enums.CouponType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * CouponTypeConverter
 *
 * @author Jackie Hou
 * @date 2024/7/15 22:55
 * @version 1.0
 */
@Converter
public class CouponTypeConverter implements AttributeConverter<CouponType, String> {

    @Override
    public String convertToDatabaseColumn(CouponType type) {
        return type.getCode();
    }

    @Override
    public CouponType convertToEntityAttribute(String code) {
        return CouponType.convert(code);
    }
}
