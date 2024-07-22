package io.github.coupon.calc.api.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Product
 *
 * @author Jackie Hou
 * @date 2024/7/17 17:15
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    private long price;

    private Integer count;

    private Long shopId;
}
