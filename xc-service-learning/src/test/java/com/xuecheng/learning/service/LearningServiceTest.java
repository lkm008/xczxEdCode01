package com.xuecheng.learning.service;

import static org.junit.Assert.*;

import com.xuecheng.framework.domain.learning.response.GetMediaResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class LearningServiceTest {
    @Autowired
    LearningService learningService;

    @Test
    public void testGetMedia() {
        GetMediaResult media = learningService.getMedia("297e7c7c62b888f00162b8a7dec20000", "40288581632b593e01632bd606480004");
        System.out.println("media = " + media);
    }
}