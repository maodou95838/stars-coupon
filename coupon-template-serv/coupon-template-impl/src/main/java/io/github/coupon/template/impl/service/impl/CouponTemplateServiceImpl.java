package io.github.coupon.template.impl.service.impl;

import io.github.coupon.template.api.beans.CouponTemplateInfo;
import io.github.coupon.template.api.beans.PagedCouponTemplateInfo;
import io.github.coupon.template.api.beans.TemplateSearchParams;
import io.github.coupon.template.api.enums.CouponType;
import io.github.coupon.template.dao.CouponTemplateDao;
import io.github.coupon.template.dao.entity.CouponTemplate;
import io.github.coupon.template.impl.converter.CouponTemplateConverter;
import io.github.coupon.template.impl.service.CouponTemplateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;

/**
 * CouponTemplateServiceImpl
 *
 * @author Jackie Hou
 * @date 2024/7/16 08:32
 * @version 1.0
 */
@Slf4j
@Service
public class CouponTemplateServiceImpl implements CouponTemplateService {

    @Override
    public CouponTemplateInfo createTemplate(CouponTemplateInfo request) {
        if (request.getShopId() != null) {
            Integer count = templateDao.countByShopIdAndAvailable(request.getShopId(), true);
            if (count >= 100) {
                log.error("门店创建的优惠券模板数>100");
                throw new UnsupportedOperationException("exceede the max of coupon templates that you can create!");
            }
        }

        CouponTemplate template = new CouponTemplate();
        template.setName(request.getName());
        template.setDescription(request.getDesc());
        template.setCouponType(CouponType.convert(request.getType()));

        template.setAvailable(true);
        template.setShopId(request.getShopId());
        template.setRule(request.getRule());

        templateDao.save(template);
        return CouponTemplateConverter.convert2TemplateInfo(template);
    }

    @Override
    public CouponTemplateInfo loadTemplateInfo(Long id) {
        Optional<CouponTemplate> template = templateDao.findById(id);
        return template.isPresent() ? CouponTemplateConverter.convert2TemplateInfo(template.get()) : null;
    }

    @Override
    public CouponTemplateInfo cloneTemplate(Long templateId) {
        log.info("cloning template id {}", templateId);
        CouponTemplate source = templateDao.findById(templateId)
                .orElseThrow(() -> new IllegalArgumentException("invalid template ID"));

        CouponTemplate target = new CouponTemplate();
        BeanUtils.copyProperties(source, target);

        target.setAvailable(true);
        target.setShopId(null);

        templateDao.save(target);
        return CouponTemplateConverter.convert2TemplateInfo(target);
    }

    @Override
    public PagedCouponTemplateInfo search(TemplateSearchParams request) {
        return null;
    }

    @Override
    public void deleteTemplate(Long id) {
        int rowCount = templateDao.makeCouponUnavailable(id);
        if (rowCount == 0) {
            throw new IllegalArgumentException("Template Not found! id = " + id);
        }
    }

    @Override
    public Map<Long, CouponTemplateInfo> getTemplateInfoMap(Collection<Long> ids) {
        return null;
    }

    @Autowired
    private CouponTemplateDao templateDao;
}
