package io.github.coupon.customer.feign;

import io.github.coupon.template.api.beans.CouponTemplateInfo;
import javafx.print.Collation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;
import java.util.Map;

/**
 * TemplateService 远程接口
 *
 * @author Jackie Hou
 * @date 2024/7/23 18:13
 * @version 1.0
 */
@FeignClient(value = "coupon-template-serv", path = "/template")
public interface TemplateService {

    @GetMapping("/getTemplate")
    CouponTemplateInfo getTemplate(@RequestParam("id") Long id);

    @GetMapping("/getBatch")
    Map<Long, CouponTemplateInfo> getTemplateInBatch(@RequestParam("ids") Collection<Long> ids);
}
