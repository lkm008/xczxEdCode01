package com.xuecheng.search.service;

import com.xuecheng.framework.domain.course.CoursePub;
import com.xuecheng.framework.domain.search.CourseSearchParam;
import com.xuecheng.framework.model.response.QueryResponseResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
@SpringBootTest
@RunWith(SpringRunner.class)
public class EsCourseServiceTest {
@Autowired
EsCourseService esCourseService;
    @Test
    public void testList() {
        CourseSearchParam courseSearchParam = new CourseSearchParam();
        courseSearchParam.setKeyword("java");
        QueryResponseResult queryResponseResult = esCourseService.list(1, 10, courseSearchParam);
//        System.out.println("queryResponseResult = " + queryResponseResult.getQueryResult());
        List<CoursePub> list = queryResponseResult.getQueryResult().getList();
        for (CoursePub coursePub : list) {
            System.out.println("name = " + coursePub.getName());
            System.out.println("Pic = " + coursePub.getPic());
            System.out.println("Price = " + coursePub.getPrice());
            System.out.println("Price_old = " + coursePub.getPrice_old());
        }
    }
}