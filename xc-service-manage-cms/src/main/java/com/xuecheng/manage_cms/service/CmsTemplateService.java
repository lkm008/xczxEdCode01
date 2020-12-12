package com.xuecheng.manage_cms.service;

import com.xuecheng.framework.domain.cms.CmsTemplate;
import com.xuecheng.framework.domain.cms.request.QueryTemplateRequest;
import com.xuecheng.framework.domain.cms.response.CmsTemplateResult;
import com.xuecheng.framework.model.response.CommonCode;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.framework.model.response.QueryResult;
import com.xuecheng.framework.model.response.ResponseResult;
import com.xuecheng.manage_cms.dao.CmsTemplateRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CmsTemplateService {
    @Autowired
    CmsTemplateRepository cmsTemplateRepository;

    public QueryResponseResult findAll(){
        List<CmsTemplate> all = cmsTemplateRepository.findAll();
        QueryResult<CmsTemplate> cmsPageQueryResult = new QueryResult<CmsTemplate>();
        cmsPageQueryResult.setList(all);
        cmsPageQueryResult.setTotal(all.size());
        //返回结果
        return new QueryResponseResult(CommonCode.SUCCESS, cmsPageQueryResult);
    }
    /**
     * 模板列表分页查询
     * @param page 当前页码
     * @param size 模板显示个数
     * @param queryTemplateRequest 查询条件
     * @return 模板列表
     */
    public QueryResponseResult findList(int page, int size, QueryTemplateRequest queryTemplateRequest) {
        page=page >= 1?page-1:0;
        size=size >=1?size:1;
        //条件值
        CmsTemplate cmsTemplate = new CmsTemplate();
        //站点ID
        if (StringUtils.isNoneEmpty(queryTemplateRequest.getSiteId())) {
            cmsTemplate.setSiteId(queryTemplateRequest.getSiteId());
        }
        //模板名称
        if (StringUtils.isNoneEmpty(queryTemplateRequest.getTemplateName())) {
            cmsTemplate.setTemplateName(queryTemplateRequest.getTemplateName());
        }
        ExampleMatcher exampleMatcher = ExampleMatcher.matching();
//        exampleMatcher = exampleMatcher.withMatcher("pageAliase", ExampleMatcher.GenericPropertyMatchers.contains());
        exampleMatcher = exampleMatcher.withMatcher("templateName", ExampleMatcher.GenericPropertyMatchers.contains());
        Example<CmsTemplate> example = Example.of(cmsTemplate,exampleMatcher);
        Pageable pageable = new PageRequest(page, size);
        Page<CmsTemplate> all = cmsTemplateRepository.findAll(example, pageable);
        QueryResult<CmsTemplate> cmsPageQueryResult = new QueryResult<CmsTemplate>();
        cmsPageQueryResult.setList(all.getContent());
        cmsPageQueryResult.setTotal(all.getTotalElements());
        //返回结果
        return new QueryResponseResult(CommonCode.SUCCESS, cmsPageQueryResult);
    }

    //添加模板
    public CmsTemplateResult add(CmsTemplate cmsTemplate){
        cmsTemplateRepository.save(cmsTemplate);
        //返回结果
        CmsTemplateResult CmsTemplateResult = new CmsTemplateResult(CommonCode.SUCCESS,cmsTemplate);
        return CmsTemplateResult;

    }

    //根据id查询模板
    public CmsTemplateResult getById(String id){
        Optional<CmsTemplate> optional = cmsTemplateRepository.findById(id);
        if(optional.isPresent()){
            return new CmsTemplateResult(CommonCode.SUCCESS,optional.get());
        }
        //返回空
        return new CmsTemplateResult(CommonCode.FAIL,null);
    }
    //更新模板信息
    public CmsTemplateResult update(String id,CmsTemplate cmsTemplate) {
        //根据id查询模板信息
        CmsTemplate one = this.getById(id).getCmsTemplate();
        if (one != null) {
            //更新所属站点
            one.setSiteId(cmsTemplate.getSiteId());
            //更新模版名称
            one.setTemplateName(cmsTemplate.getTemplateName());
            //更新模版参数
            one.setTemplateParameter(cmsTemplate.getTemplateParameter());
            //更新模版文件Id
            one.setTemplateFileId(cmsTemplate.getTemplateFileId());
            //执行更新
            CmsTemplate save = cmsTemplateRepository.save(one);
            if (save != null) {
                //返回成功
                CmsTemplateResult CmsTemplateResult = new CmsTemplateResult(CommonCode.SUCCESS, save);
                return CmsTemplateResult;
            }
        }
        //返回失败
        return new CmsTemplateResult(CommonCode.FAIL,null);
    }

    //删除模板
    public ResponseResult delete(String id){
        CmsTemplate one = this.getById(id).getCmsTemplate();
        if(one!=null){
            //删除模板
            cmsTemplateRepository.deleteById(id);
            return new ResponseResult(CommonCode.SUCCESS);
        }
        return new ResponseResult(CommonCode.FAIL);
    }
}
