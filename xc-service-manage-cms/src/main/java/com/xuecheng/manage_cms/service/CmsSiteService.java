package com.xuecheng.manage_cms.service;

import com.xuecheng.framework.domain.cms.CmsSite;
import com.xuecheng.framework.model.response.CommonCode;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.framework.model.response.QueryResult;
import com.xuecheng.manage_cms.dao.CmsSiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CmsSiteService {
    @Autowired
    CmsSiteRepository siteRepository;

    public QueryResponseResult findAll(){
        List<CmsSite> all = siteRepository.findAll();
        QueryResult<CmsSite> cmsPageQueryResult = new QueryResult<CmsSite>();
        cmsPageQueryResult.setList(all);
        cmsPageQueryResult.setTotal(all.size());
        //返回结果
        return new QueryResponseResult(CommonCode.SUCCESS, cmsPageQueryResult);
    }
}
