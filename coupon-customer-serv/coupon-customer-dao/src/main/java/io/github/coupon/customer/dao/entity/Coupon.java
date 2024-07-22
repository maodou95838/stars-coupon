package io.github.coupon.customer.dao.entity;

import io.github.coupon.customer.api.enums.CouponStatus;
import io.github.coupon.customer.dao.convertor.CouponStatusConvertor;
import io.github.coupon.template.api.beans.CouponTemplateInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

/**
 * Coupon
 *
 * @author Jackie Hou
 * @date 2024/7/17 22:11
 * @version 1.0
 */
@Entity
@Table(name = "coupon")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "template_id", nullable = false)
    private Long templateId;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "shop_id")
    private Long shopId;

    @CreatedDate
    @Column(name = "created_time", nullable = false)
    private Date createdTime;

    @Column(name = "status", nullable = false)
    @Convert(converter = CouponStatusConvertor.class)
    private CouponStatus status;

    @Transient
    private CouponTemplateInfo templateInfo;
}
