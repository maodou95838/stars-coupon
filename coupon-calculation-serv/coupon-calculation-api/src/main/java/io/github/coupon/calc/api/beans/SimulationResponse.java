package io.github.coupon.calc.api.beans;

import com.google.common.collect.Maps;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * SimulationResponse
 *
 * @author Jackie Hou
 * @date 2024/7/17 17:28
 * @version 1.0
 */
@Data
@NoArgsConstructor
public class SimulationResponse {

    private Long bestCouponId;

    /**
     * 每一个coupon对应的order价格
     */
    private Map<Long, Long> coupon2OrderPrice = Maps.newHashMap();
}
