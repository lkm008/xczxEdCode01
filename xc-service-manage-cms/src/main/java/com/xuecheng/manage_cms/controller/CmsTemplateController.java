package com.xuecheng.manage_cms.controller;

import com.xuecheng.api.cms.CmsTemplateControllerApi;
import com.xuecheng.framework.domain.cms.CmsTemplate;
import com.xuecheng.framework.domain.cms.request.QueryTemplateRequest;
import com.xuecheng.framework.domain.cms.response.CmsTemplateResult;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.framework.model.response.ResponseResult;
import com.xuecheng.manage_cms.service.CmsTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cms/template")
public class CmsTemplateController implements CmsTemplateControllerApi {
    @Autowired
    CmsTemplateService templateService;

    @Override
    @GetMapping("/findAll")
    public QueryResponseResult findAll() {
        return templateService.findAll();
    }

    @Override
    @GetMapping("/list/{page}/{size}")
    public QueryResponseResult findList(@PathVariable("page") int page, @PathVariable("size") int size, QueryTemplateRequest queryTemplateRequest) {
        return templateService.findList(page,size,queryTemplateRequest);
    }

    @Override
    @PostMapping("/add")
    public CmsTemplateResult add(@RequestBody CmsTemplate cmsTemplate) {
        return templateService.add(cmsTemplate);
    }

    @Override
    @GetMapping("/get/{id}")
    public CmsTemplateResult findById(@PathVariable("id") String id) {
        return templateService.getById(id);
    }

    @Override
    @PutMapping("/edit/{id}")//这里使用put方法，http 方法中put表示更新
    public CmsTemplateResult edit(@PathVariable("id")String id,@RequestBody CmsTemplate cmsTemplate) {
        return templateService.update(id,cmsTemplate);
    }

    @Override
    @DeleteMapping("/del/{id}") //使用http的delete方法完成岗位操作
    public ResponseResult delete(@PathVariable("id") String id) {
        return templateService.delete(id);
    }
}
