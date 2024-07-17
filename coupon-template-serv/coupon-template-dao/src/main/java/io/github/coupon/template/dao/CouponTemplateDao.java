package io.github.coupon.template.dao;

import io.github.coupon.template.dao.entity.CouponTemplate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * CouponTemplateDao
 *
 * @author Jackie Hou
 * @date 2024/7/15 22:34
 * @version 1.0
 */
public interface CouponTemplateDao extends JpaRepository<CouponTemplate, Long> {

    /**
     * 根据shopId查询模板
     * @param shopId
     * @return
     */
    List<CouponTemplate> findAllByShopId(Long shopId);

    Page<CouponTemplate> findByIdIn(List<Long> id, Pageable page);

    Integer countByShopIdAndAvailable(Long shopId, Boolean avaiable);

    /**
     * 将优惠券设置为不可用
     * @param id
     * @return
     */
    @Modifying
    @Query("update CouponTemplate c set c.available = 0 where c.id = :id")
    int makeCouponUnavailable(@Param("id") Long id);
}
