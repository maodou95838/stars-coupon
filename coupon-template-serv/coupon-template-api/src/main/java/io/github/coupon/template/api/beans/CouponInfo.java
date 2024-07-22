package io.github.coupon.template.api.beans;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * CouponInfo
 *
 * @author Jackie Hou
 * @date 2024/7/17 17:21
 * @version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CouponInfo {

    private Long id;

    private Long templateId;

    private Long userId;

    private long shopId;

    private Integer status;

    private CouponTemplateInfo template;
}
