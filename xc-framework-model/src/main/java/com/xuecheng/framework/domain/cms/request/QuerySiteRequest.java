package com.xuecheng.framework.domain.cms.request;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class QuerySiteRequest {
    //站点名称
    private String siteName;
    //站点名称
    private String siteDomain;
    //站点端口
    private String sitePort;
    //站点访问地址
    private String siteWebPath;
    //创建时间
    private Date siteCreateTime;
    //站点物理路径
    private String sitePhysicalPath;
}
