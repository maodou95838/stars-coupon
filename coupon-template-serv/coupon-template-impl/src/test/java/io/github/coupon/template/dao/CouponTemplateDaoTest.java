package io.github.coupon.template.dao;

import io.github.coupon.template.dao.entity.CouponTemplate;
import io.github.coupon.template.impl.TemplateServiceApplication;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

/**
 * CouponTemplateDaoTest
 *
 * @author Jackie Hou
 * @date 2024/7/19 15:40
 * @version 1.0
 */
@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestPropertySource("classpath:test.properties")
@ContextConfiguration(classes = TemplateServiceApplication.class)
public class CouponTemplateDaoTest {

    @Test
    public void testCouponTemplateDao() {
        System.out.println("---------------");
        List<CouponTemplate> templates = templateDao.findAllByShopId(1L);
        System.out.println("================");
    }

    @Autowired
    private CouponTemplateDao templateDao;
}
