package com.xuecheng.manage_cms.service;

import com.xuecheng.framework.domain.cms.request.QueryTemplateRequest;
import com.xuecheng.framework.model.response.QueryResponseResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CmsTemplateServiceTest {
    @Autowired
    CmsTemplateService cmsTemplateService;

    @Test
    public void testFindList() {
        QueryTemplateRequest queryTemplateRequest = new QueryTemplateRequest();

        QueryResponseResult list = cmsTemplateService.findList(1, 10, queryTemplateRequest);
        System.out.println("list = " + list.getQueryResult().getTotal());
    }

    @Test
    public void testAdd() {
    }

    @Test
    public void testGetById() {
    }

    @Test
    public void testUpdate() {
    }

    @Test
    public void testDelete() {
    }
}