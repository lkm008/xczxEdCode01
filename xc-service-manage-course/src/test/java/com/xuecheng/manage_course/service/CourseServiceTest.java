package com.xuecheng.manage_course.service;

import com.xuecheng.framework.domain.course.Teachplan;
import com.xuecheng.framework.model.response.ResponseResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CourseServiceTest {
    @Autowired
    CourseService courseService;

    @Test
    public void testFindTeachplanList() {
    }

    @Test
    public void testGetTeachplanRoot() {
        String teachplanRoot = courseService.getTeachplanRoot("4028e581617f945f01617f9dabc40000");
        System.out.println("teachplanRoot = " + teachplanRoot);
    }

    @Test
    public void testAddTeachplan() {
        Teachplan teachplan = new Teachplan();
        teachplan.setCourseid("4028e581617f945f01617f9dabc40000");
        teachplan.setPname("测试lkm2");
        teachplan.setDescription("描述lkm");
        teachplan.setTimelength((double) 10);
        teachplan.setOrderby(1);
        teachplan.setParentid("2");
        ResponseResult responseResult = courseService.addTeachplan(teachplan);
        System.out.println("responseResult = " + responseResult);
    }
}