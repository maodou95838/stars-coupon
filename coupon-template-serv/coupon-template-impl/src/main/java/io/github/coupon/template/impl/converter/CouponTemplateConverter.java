package io.github.coupon.template.impl.converter;

import io.github.coupon.template.api.beans.CouponTemplateInfo;
import io.github.coupon.template.dao.entity.CouponTemplate;

/**
 * CouponTemplateConverter
 *
 * @author Jackie Hou
 * @date 2024/7/16 15:26
 * @version 1.0
 */
public class CouponTemplateConverter {

    public static CouponTemplateInfo convert2TemplateInfo(CouponTemplate template) {
        CouponTemplateInfo vo = new CouponTemplateInfo();
        vo.setId(template.getId());
        vo.setName(template.getName());
        vo.setDesc(template.getDescription());

        vo.setRule(template.getRule());
        vo.setAvailable(template.getAvailable());
        vo.setType(template.getCouponType().getCode());

        vo.setShopId(template.getShopId());
        return vo;
    }
}
