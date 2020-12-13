package com.xuecheng.manage_cms.service;

import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.framework.domain.cms.request.QueryPageRequest;
import com.xuecheng.framework.model.response.QueryResponseResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

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


    @Test
    public void testGetPageHtml() {
        String pageHtml = pageService.getPageHtml("5a795ac7dd573c04508f3a56");
        System.out.println("pageHtml = " + pageHtml);
    }

    @Test
    public void testGenerateHtml() {
        Map model = pageService.getModelByPageId("5a795ac7dd573c04508f3a56");
        String template = pageService.getTemplateByPageId("5a795ac7dd573c04508f3a56");
        String html = pageService.generateHtml(template, model);
        System.out.println("html = " + html);
    }

    @Test
    public void testGetTemplateByPageId() {
        String template = pageService.getTemplateByPageId("5a795ac7dd573c04508f3a56");
        System.out.println("template = " + template);
    }

    @Test
    public void testGetModelByPageId() {
        Map model = pageService.getModelByPageId("5a795ac7dd573c04508f3a56");
        System.out.println("map = " + model);
    }

    @Test
    public void testPostPage() {
        pageService.sendPostPage("5a795ac7dd573c04508f3a56");
    }

    @Test
    public void testSendPostPage() {
        pageService.sendPostPage("5a795ac7dd573c04508f3a56");
    }

    @Test
    public void testSaveHtml() {
        String pageId = "5a795ac7dd573c04508f3a56";
        String pageHtml = pageService.getPageHtml(pageId);
        CmsPage cmsPage = pageService.saveHtml(pageId, pageHtml);
        System.out.println(cmsPage.getHtmlFileId());
    }
}