package io.github.coupon.template.api.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * PagedCouponTemplateInfo
 *
 * @author Jackie Hou
 * @date 2024/7/16 08:09
 * @version 1.0
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PagedCouponTemplateInfo {

    private List<CouponTemplateInfo> templates;

    private int page;

    private int total;


}
