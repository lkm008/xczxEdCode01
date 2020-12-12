package com.xuecheng.manage_cms.dao;

import com.xuecheng.framework.domain.cms.CmsTemplate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CmsTemplateRepositoryTest {
    @Autowired
    CmsTemplateRepository cmsTemplateRepository;

    @Test
    public void testName() {
        List<CmsTemplate> all = cmsTemplateRepository.findAll();
        System.out.println("all = " + all.toString());
    }
}