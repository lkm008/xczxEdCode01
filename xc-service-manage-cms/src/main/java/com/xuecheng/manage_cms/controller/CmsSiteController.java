package com.xuecheng.manage_cms.controller;

import com.xuecheng.api.cms.CmsSiteControllerApi;
import com.xuecheng.framework.domain.cms.CmsSite;
import com.xuecheng.framework.domain.cms.request.QuerySiteRequest;
import com.xuecheng.framework.domain.cms.response.CmsSiteResult;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.framework.model.response.ResponseResult;
import com.xuecheng.manage_cms.service.CmsSiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cms/site")
public class CmsSiteController implements CmsSiteControllerApi {
    @Autowired
    CmsSiteService siteService;

    @Override
    @GetMapping("/findAll")
    public QueryResponseResult findAll() {
        return siteService.findAll();
    }

    @Override
    @GetMapping("/list/{page}/{size}")
    public QueryResponseResult findList(@PathVariable("page")int page,@PathVariable("size") int size, QuerySiteRequest querySiteRequest) {
        return siteService.findList(page,size,querySiteRequest);
    }

    @Override
    @PostMapping("/add")
    public CmsSiteResult add(@RequestBody CmsSite cmsSite) {
        return siteService.add(cmsSite);
    }

    @Override
    @GetMapping("/get/{id}")
    public CmsSiteResult findById(@PathVariable("id") String id) {
        return siteService.getById(id);
    }

    @Override
    @PutMapping("/edit/{id}")//这里使用put方法，http 方法中put表示更新
    public CmsSiteResult edit(@PathVariable("id") String id, CmsSite cmsSite) {
        return siteService.update(id,cmsSite);
    }

    @Override
    @DeleteMapping("/del/{id}") //使用http的delete方法完成岗位操作
    public ResponseResult delete(@PathVariable("id") String id) {
        return siteService.delete(id);
    }
}
