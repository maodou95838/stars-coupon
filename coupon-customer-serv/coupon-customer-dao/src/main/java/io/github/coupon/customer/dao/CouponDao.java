package io.github.coupon.customer.dao;

import io.github.coupon.customer.dao.entity.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * CouponDao
 *
 * @author Jackie Hou
 * @date 2024/7/17 22:01
 * @version 1.0
 */
public interface CouponDao extends JpaRepository<Coupon, Long> {

    Long countByUserIdAndTemplateId(Long useId, Long templateId);
}
