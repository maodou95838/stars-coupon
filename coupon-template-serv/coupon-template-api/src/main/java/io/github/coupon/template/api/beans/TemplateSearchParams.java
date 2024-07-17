package io.github.coupon.template.api.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * TemplateSearchParams
 *
 * @author Jackie Hou
 * @date 2024/7/16 08:12
 * @version 1.0
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TemplateSearchParams {

    private Long id;

    private String name;

    private String type;

    private Long shopId;

    private Boolean available;

    private int page;

    private int pageSize;
}
