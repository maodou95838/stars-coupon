package io.github.coupon.template.api.beans.rules;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Discount
 *
 * @author Jackie Hou
 * @date 2024/7/15 19:35
 * @version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Discount {

    /**
     *  对于满减券 - quota是减掉的钱数，单位是分
     *  对于打折券 - quota是折扣(以100表示原价)，90就是打9折, 95就是95折
     *  对于随机立减券 - quota是最高的随机立减额
     *  对于晚间特别优惠券 - quota是日间优惠额，晚间优惠翻倍
     */
    private Long quota;

    private Long threshold;
}
