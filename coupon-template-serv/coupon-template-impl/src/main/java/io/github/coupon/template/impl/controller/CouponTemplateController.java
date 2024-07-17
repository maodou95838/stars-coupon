package io.github.coupon.template.impl.controller;

import io.github.coupon.template.api.beans.CouponTemplateInfo;
import io.github.coupon.template.impl.service.CouponTemplateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
    public CouponTemplateInfo getTemplate(@RequestParam("id") Long id) {
        log.info("Load template, id = {}", id);
        return templateService.loadTemplateInfo(id);
    }

    @GetMapping("/sayhello")
    public String sayHello() {
        return "hello";
    }

    @Autowired
    private CouponTemplateService templateService;
}
