package com.xuecheng.manage_cms.service;

import com.xuecheng.framework.domain.cms.request.QueryPageRequest;
import com.xuecheng.framework.model.response.QueryResponseResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PageServiceTest {
    @Autowired
    PageService pageService;

    @Test
    public void findList() {

        QueryPageRequest queryPageRequest = new QueryPageRequest();
        queryPageRequest.setPageAliase("首页");
        QueryResponseResult list = pageService.findList(1, 5, queryPageRequest);
        System.out.println("list = " + list.getQueryResult().getList());
        System.out.println("total = " + list.getQueryResult().getTotal());
    }
}