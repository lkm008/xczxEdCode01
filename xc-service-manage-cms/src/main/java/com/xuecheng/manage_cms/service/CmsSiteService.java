package com.xuecheng.manage_cms.service;

import com.xuecheng.framework.domain.cms.CmsSite;
import com.xuecheng.framework.domain.cms.request.QuerySiteRequest;
import com.xuecheng.framework.domain.cms.response.CmsSiteResult;
import com.xuecheng.framework.model.response.CommonCode;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.framework.model.response.QueryResult;
import com.xuecheng.framework.model.response.ResponseResult;
import com.xuecheng.manage_cms.dao.CmsSiteRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CmsSiteService {
    @Autowired
    CmsSiteRepository siteRepository;

    public QueryResponseResult findAll(){
        List<CmsSite> all = siteRepository.findAll();
        QueryResult<CmsSite> cmsSiteQueryResult = new QueryResult<CmsSite>();
        cmsSiteQueryResult.setList(all);
        cmsSiteQueryResult.setTotal(all.size());
        //返回结果
        return new QueryResponseResult(CommonCode.SUCCESS, cmsSiteQueryResult);
    }

    /**
     * 分页查询站点列表
     * @param page 初始页
     * @param size 每页记录数
     * @param querySiteRequest 站点查询条件
     * @return 查询结果
     */
    public QueryResponseResult findList(int page, int size, QuerySiteRequest querySiteRequest) {
        page=page >= 1?page-1:0;
        size=size >=1?size:1;
        //条件值
        CmsSite cmsSite = new CmsSite();
        //站点名称
        if (StringUtils.isNoneEmpty(querySiteRequest.getSiteName())) {
            cmsSite.setSiteName(querySiteRequest.getSiteName());
        }
        //站点域名
        if (StringUtils.isNoneEmpty(querySiteRequest.getSiteDomain())) {
            cmsSite.setSiteDomain(querySiteRequest.getSiteDomain());
        }
        //站点端口
        if (StringUtils.isNoneEmpty(querySiteRequest.getSitePort())) {
            cmsSite.setSitePort(querySiteRequest.getSitePort());
        }
        //站点访问地址
        if (StringUtils.isNoneEmpty(querySiteRequest.getSiteWebPath())) {
            cmsSite.setSiteWebPath(querySiteRequest.getSiteWebPath());
        }
        //站点访问地址
        if (StringUtils.isNoneEmpty(querySiteRequest.getSiteWebPath())) {
            cmsSite.setSiteWebPath(querySiteRequest.getSiteWebPath());
        }
        //创建时间
        if (Objects.nonNull(querySiteRequest.getSiteCreateTime())) {
            cmsSite.setSiteWebPath(querySiteRequest.getSiteWebPath());
        }
        //站点物理路径
        if (Objects.nonNull(querySiteRequest.getSitePhysicalPath())) {
            cmsSite.setSitePhysicalPath(querySiteRequest.getSitePhysicalPath());
        }
        ExampleMatcher exampleMatcher = ExampleMatcher.matching();
        exampleMatcher = exampleMatcher.withMatcher("siteName", ExampleMatcher.GenericPropertyMatchers.contains());
        exampleMatcher = exampleMatcher.withMatcher("sitePhysicalPath", ExampleMatcher.GenericPropertyMatchers.contains());
        Example<CmsSite> example = Example.of(cmsSite,exampleMatcher);
        Pageable pageable = new PageRequest(page, size);
        Page<CmsSite> all = siteRepository.findAll(example, pageable);
        QueryResult<CmsSite> cmsSiteQueryResult = new QueryResult<CmsSite>();
        cmsSiteQueryResult.setList(all.getContent());
        cmsSiteQueryResult.setTotal(all.getTotalElements());
        //返回结果
        return new QueryResponseResult(CommonCode.SUCCESS, cmsSiteQueryResult);
    }

    //添加模板
    public CmsSiteResult add(CmsSite cmsSite){
        siteRepository.save(cmsSite);
        //返回结果
        CmsSiteResult cmsSiteResult = new CmsSiteResult(CommonCode.SUCCESS,cmsSite);
        return cmsSiteResult;

    }

    //根据id查询模板
    public CmsSiteResult getById(String id){
        Optional<CmsSite> optional = siteRepository.findById(id);
        if(optional.isPresent()){
            return new CmsSiteResult(CommonCode.SUCCESS,optional.get());
        }
        //返回空
        return new CmsSiteResult(CommonCode.FAIL,null);
    }
    //更新模板信息
    public CmsSiteResult update(String id,CmsSite cmsSite) {
        //根据id查询模板信息
        CmsSite one = this.getById(id).getCmsSite();
        if (one != null) {
            //更新站点名称
            one.setSiteName(cmsSite.getSiteName());
            //更新站点域名
            one.setSiteDomain(cmsSite.getSiteDomain());
            //更新站点web路径
            one.setSiteWebPath(cmsSite.getSiteWebPath());
            //更新站点端口
            one.setSitePort(cmsSite.getSitePort());
            //更新站点创建时间
            one.setSiteCreateTime(cmsSite.getSiteCreateTime());
            //更新站点物理路径
            one.setSitePhysicalPath(cmsSite.getSitePhysicalPath());
            //执行更新
            CmsSite save = siteRepository.save(one);
            if (save != null) {
                //返回成功
                CmsSiteResult CmsSiteResult = new CmsSiteResult(CommonCode.SUCCESS, save);
                return CmsSiteResult;
            }
        }
        //返回失败
        return new CmsSiteResult(CommonCode.FAIL,null);
    }

    //删除模板
    public ResponseResult delete(String id){
        CmsSite one = this.getById(id).getCmsSite();
        if(one!=null){
            //删除模板
            siteRepository.deleteById(id);
            return new ResponseResult(CommonCode.SUCCESS);
        }
        return new ResponseResult(CommonCode.FAIL);
    }
}
