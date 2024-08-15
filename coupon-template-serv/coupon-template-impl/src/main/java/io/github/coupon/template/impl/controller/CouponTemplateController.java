package io.github.coupon.template.impl.controller;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import io.github.coupon.template.api.beans.CouponTemplateInfo;
import io.github.coupon.template.impl.service.CouponTemplateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.Map;

/**
 * CouponTemplateController
 *
 * @author Jackie Hou
 * @date 2024/7/16 16:53
 * @version 1.0
 */
@Slf4j
@RestController
@RequestMapping("/template")
public class CouponTemplateController {

    @PostMapping("/addTemplate")
    public CouponTemplateInfo addTemplate(@Valid @RequestBody CouponTemplateInfo request) {
        log.info("Create coupon template: data = {}", request);
        return templateService.createTemplate(request);

    }

    @GetMapping("/getTemplate")
    @SentinelResource(value = "getTemplate")
    public CouponTemplateInfo getTemplate(@RequestParam("id") Long id) {
        log.info("Load template, id = {}", id);
        return templateService.loadTemplateInfo(id);
    }


    @GetMapping("/getBatch")
    @SentinelResource(value = "getTemplateInBatch", blockHandler = "getTemplateInBatch_block")
    public Map<Long, CouponTemplateInfo> getTemplateInBatch(
            @RequestParam("ids") Collection<Long> ids) {
        log.info("getTemplateInBatch: {}", JSON.toJSONString(ids));
        return templateService.getTemplateInfoMap(ids);
    }

    public Map<Long, CouponTemplateInfo> getTemplateInBatch_block(Collection<Long> ids, BlockException blockException) {
        log.info("限流逻辑");
        return Maps.newHashMap();
    }

    @GetMapping("/sayhello")
    public String sayHello() {
        return "hello";
    }

    @Autowired
    private CouponTemplateService templateService;
}
