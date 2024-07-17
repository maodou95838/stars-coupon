package io.github.coupon.template.api.beans.rules;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * TemplateRule
 *
 * @author Jackie Hou
 * @date 2024/7/15 19:33
 * @version 1.0
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TemplateRule {

    private Discount discount;

    /**
     * 每个人最多可以领取的数量
     */
    private Integer limition;

    /**
     * 过期时间
     */
    private long deadtime;
}
