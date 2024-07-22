package io.github.coupon.calc.api.beans;

import io.github.coupon.template.api.beans.CouponInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * SimulationOrder
 *
 * @author Jackie Hou
 * @date 2024/7/17 17:26
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SimulationOrder {

    private List<Product> products;

    private List<Long> couponIds;

    private List<CouponInfo> couponInfos;

    private Long userId;
}
