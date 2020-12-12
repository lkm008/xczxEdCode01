package com.xuecheng.framework.domain.cms.request;

import com.xuecheng.framework.model.request.RequestData;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class QueryTemplateRequest extends RequestData {
    //站点ID
    @ApiModelProperty("站点id")
    private String siteId;
    //模版名称
    @ApiModelProperty("模版名称")
    private String templateName;
}
