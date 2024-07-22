package io.github.coupon.template.dao.entity;

import io.github.coupon.template.api.beans.rules.TemplateRule;
import io.github.coupon.template.api.enums.CouponType;
import io.github.coupon.template.dao.convert.RuleConverter;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * CouponTemplate
 *
 * @author Jackie Hou
 * @date 2024/7/15 21:12
 * @version 1.0
 */
@Entity
@Table(name = "coupon_template")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Builder
public class CouponTemplate implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "available", nullable = false)
    private Boolean available;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "shop_id", nullable = false)
    private Long shopId;


    @Column(name = "type", nullable = false)
    private CouponType couponType;

    @CreatedDate
    @Column(name = "created_time", nullable = false)
    private Date createdTime;


    @Column(name = "rule", nullable = false)
    @Convert(converter = RuleConverter.class)
    private TemplateRule rule;
}
