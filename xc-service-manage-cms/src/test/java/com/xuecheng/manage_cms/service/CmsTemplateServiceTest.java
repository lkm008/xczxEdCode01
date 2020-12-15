package com.xuecheng.manage_cms.service;

import com.xuecheng.framework.domain.cms.request.QueryTemplateRequest;
import com.xuecheng.framework.model.response.QueryResponseResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

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

    @Test
    public void testSaveTemplate() throws FileNotFoundException {
        //要存储的文件
        File file = new File("H:/Program/code/pj/xuechengzaixian/code/qianduan/xc-ui-pc-static-portal/include/index_banner.html");
        //定义输入流
        FileInputStream inputStram = new FileInputStream(file);
        //向GridFS存储文件
//        ObjectId objectId = gridFsTemplate.store(inputStram, "轮播图测试文件01", "");
//        ObjectId objectId2 = gridFsTemplate.store(inputStram, "轮播图测试文件01", "");
        //得到文件ID
//        String fileId = objectId.toString();
//        System.out.println(fileId);//5fd4ef39a513c20ee0ab59fe
        String s = cmsTemplateService.saveTemplate(inputStram,"轮播图测试文件007");
        System.out.println("s = " + s);
    }
}