package io.github.coupon.template.impl.service;

import io.github.coupon.template.api.beans.CouponTemplateInfo;
import io.github.coupon.template.api.beans.PagedCouponTemplateInfo;
import io.github.coupon.template.api.beans.TemplateSearchParams;

import java.util.Collection;
import java.util.Map;

/**
 * CouponTemplateService
 *
 * @author Jackie Hou
 * @date 2024/7/16 08:04
 * @version 1.0
 */
public interface CouponTemplateService {

    CouponTemplateInfo createTemplate(CouponTemplateInfo request);

    CouponTemplateInfo loadTemplateInfo(Long id);

    CouponTemplateInfo cloneTemplate(Long templateId);

    /**
     * 分页查询
     * @param request
     * @return
     */
    PagedCouponTemplateInfo search(TemplateSearchParams request);

    void deleteTemplate(Long id);

    Map<Long, CouponTemplateInfo> getTemplateInfoMap(Collection<Long> ids);
}
