package com.xuecheng.manage_course.service;

import com.xuecheng.framework.domain.course.CourseMarket;
import com.xuecheng.framework.domain.course.Teachplan;
import com.xuecheng.framework.model.response.ResponseResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

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

    @Test
    public void testGetCourseMarketById() {
        CourseMarket courseMarketById = courseService.getCourseMarketById("297e7c7c62b888f00162b8a965510001");
        System.out.println("courseMarketById = " + courseMarketById);
    }

    @Test
    public void testUpdateCourseMarket() {
        CourseMarket one = new CourseMarket();
        one.setCharge("203009");
        one.setStartTime(new Date());//课程有效期，开始时间
        one.setEndTime(new Date());//课程有效期，结束时间
        one.setPrice(200f);
        one.setQq("4455432");
        one.setValid("204001");
        CourseMarket courseMarket = courseService.updateCourseMarket("40289981766c49ed01766c56f27f0001", one);
        System.out.println("courseMarket = " + courseMarket);
    }


}