package io.github.coupon.template.dao;

import io.github.coupon.template.dao.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * MyTestDao
 *
 * @author Jackie Hou
 * @date 2024/7/17 10:10
 * @version 1.0
 */
public interface MyTestDao extends JpaRepository<User, Integer> {
}
