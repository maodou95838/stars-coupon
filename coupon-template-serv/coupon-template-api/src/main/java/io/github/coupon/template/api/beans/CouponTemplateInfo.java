package io.github.coupon.template.api.beans;

import io.github.coupon.template.api.beans.rules.TemplateRule;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * CouponTemplateInfo
 *
 * @author Jackie Hou
 * @date 2024/7/15 19:37
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CouponTemplateInfo {

    private Long id;

    @NotNull
    private String name;

    private String desc;

    /**
     * 优惠券类型
     */
    private String type;

    /**
     * 优惠券适用门店
     * 为空，则适用于所有门店
     */
    private Long shopId;

    /**
     * 优惠券使用规则
     */
    @NotNull
    private TemplateRule rule;

    /**
     * 是否可用
     */
    private Boolean available;
}
