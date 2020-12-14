package com.xuecheng.manage_cms.service;

import com.xuecheng.framework.domain.cms.CmsSite;
import com.xuecheng.framework.domain.cms.request.QuerySiteRequest;
import com.xuecheng.framework.domain.cms.response.CmsSiteResult;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.framework.model.response.ResponseResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.*;
@SpringBootTest
@RunWith(SpringRunner.class)
public class CmsSiteServiceTest {
@Autowired
CmsSiteService cmsSiteService;
    @Test
    public void testFindAll() {
        QueryResponseResult all = cmsSiteService.findAll();
        System.out.println("all = " + all);
    }

    @Test
    public void testFindList() {
        QuerySiteRequest querySiteRequest = new QuerySiteRequest();
        querySiteRequest.setSiteName("门户");
        QueryResponseResult list = cmsSiteService.findList(1, 5, querySiteRequest);
        System.out.println("list = " + list);
    }

    @Test
    public void testAdd() {
        CmsSite cmsSite = new CmsSite();
        cmsSite.setSiteName("测试站点名称");
        cmsSite.setSiteDomain("测试站点域名");
        cmsSite.setSiteWebPath("测试站点web路径");
        cmsSite.setSitePort("测试站点端口");
        cmsSite.setSiteCreateTime(new Date());
        cmsSite.setSitePhysicalPath("测试物理路径");
        CmsSiteResult add = cmsSiteService.add(cmsSite);
        System.out.println("add = " + add);
    }

    @Test
    public void testGetById() {
        CmsSiteResult byId = cmsSiteService.getById("5fd7907abe3d0c07d0aa2470");
        System.out.println("byId = " + byId);
    }

    @Test
    public void testUpdate() {
        CmsSite cmsSite = new CmsSite();
        cmsSite.setSiteName("测试站点名称001");
        CmsSiteResult update = cmsSiteService.update("5fd7907abe3d0c07d0aa2470", cmsSite);
        System.out.println("update = " + update);
    }

    @Test
    public void testDelete() {
        ResponseResult delete = cmsSiteService.delete("5fd7907abe3d0c07d0aa2470");
        System.out.println("delete = " + delete);
    }
}