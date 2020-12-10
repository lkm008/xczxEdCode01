package com.xuecheng.framework.domain.cms;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @Author: mrt.
 * @Description: CmsPage参数
 * @Date:Created in 2018/1/24 10:04.
 * @Modified By:
 */
@Data
@ToString
public class CmsPageParam {
   //参数名称
    private String pageParamName;
    //参数值
    private String pageParamValue;

}
