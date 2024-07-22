package io.github.coupon.calc.template;

import io.github.coupon.calc.api.beans.ShoppingCart;
import io.github.coupon.calc.template.impl.*;
import io.github.coupon.template.api.beans.CouponTemplateInfo;
import io.github.coupon.template.api.enums.CouponType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

/**
 * CouponTemplateFactory
 *
 * @author Jackie Hou
 * @date 2024/7/17 20:53
 * @version 1.0
 */
@Component
public class CouponTemplateFactory {

    @Autowired
    private MoneyOffTemplate moneyOffTemplate;

    @Autowired
    private DiscountTemplate discountTemplate;

    @Autowired
    private RandomReductionTemplate randomReductionTemplate;

    @Autowired
    private LonelyNightTemplate lonelyNightTemplate;

    @Autowired
    private DummyTemplate dummyTemplate;

    @Autowired
    private AntiPauTemplate antiPauTemplate;

    public RuleTemplate getTemplate(ShoppingCart cart) {
        if (CollectionUtils.isEmpty(cart.getCouponInfos())) {
            return dummyTemplate;
        }

        CouponTemplateInfo templateInfo = cart.getCouponInfos().get(0).getTemplate();
        CouponType type = CouponType.convert(templateInfo.getType());

        switch (type) {
            // 订单满减券
            case MONEY_OFF:
                return moneyOffTemplate;
            // 随机立减券
            case RANDOM_DISCOUNT:
                return randomReductionTemplate;
            // 午夜下单优惠翻倍
            case LONELY_NIGHT_MONEY_OFF:
                return lonelyNightTemplate;
            // 打折券
            case DISCOUNT:
                return discountTemplate;
            case ANTI_PUA:
                return antiPauTemplate;
            // 未知类型的券模板
            default:
                return dummyTemplate;
        }



    }
}
