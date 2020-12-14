package com.xuecheng.api.cms;

import com.xuecheng.framework.domain.cms.CmsSite;
import com.xuecheng.framework.domain.cms.request.QuerySiteRequest;
import com.xuecheng.framework.domain.cms.response.CmsSiteResult;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.framework.model.response.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value="cms站点管理接口",description = "cms站点管理接口，提供站点的增、删、改、查")
public interface CmsSiteControllerApi {
    @ApiOperation("查询站点列表")
    public QueryResponseResult findAll() ;

    @ApiOperation("分页查询站点列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name="page",value = "页码",required=true,paramType="path",dataType="int"),
            @ApiImplicitParam(name="size",value = "每页记录数",required=true,paramType="path",dataType="int")
    })
    public QueryResponseResult findList(int page, int size, QuerySiteRequest querySiteRequest) ;

    @ApiOperation("添加站点")
    public CmsSiteResult add(CmsSite cmsSite);

    @ApiOperation("通过ID查询站点")
    public CmsSiteResult findById(String id);

    @ApiOperation("修改站点")
    public CmsSiteResult edit(String id,CmsSite cmsSite);

    @ApiOperation("通过ID删除站点")
    public ResponseResult delete(String id);
}
