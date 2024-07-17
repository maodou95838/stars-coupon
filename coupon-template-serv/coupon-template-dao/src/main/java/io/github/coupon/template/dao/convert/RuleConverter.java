package io.github.coupon.template.dao.convert;

import com.alibaba.fastjson.JSON;
import io.github.coupon.template.api.beans.rules.TemplateRule;

import javax.persistence.AttributeConverter;

/**
 * RuleConverter
 *
 * @author Jackie Hou
 * @date 2024/7/15 22:58
 * @version 1.0
 */
public class RuleConverter implements AttributeConverter<TemplateRule, String> {
    @Override
    public String convertToDatabaseColumn(TemplateRule rule) {
        return JSON.toJSONString(rule);
    }

    @Override
    public TemplateRule convertToEntityAttribute(String dbData) {
        return JSON.parseObject(dbData, TemplateRule.class);
    }
}
