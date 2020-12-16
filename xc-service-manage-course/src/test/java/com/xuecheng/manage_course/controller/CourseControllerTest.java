package com.xuecheng.manage_course.controller;

import com.xuecheng.framework.domain.course.CourseMarket;
import com.xuecheng.framework.model.response.ResponseResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CourseControllerTest {
@Autowired
CourseController courseController;

    @Test
    public void testUpdateCourseMarket() {
    }

    @Test
    public void testGetCourseMarketById() {
        /*
        CourseMarket courseMarket = courseService.updateCourseMarket("40289981766c49ed01766c56f27f0001", one);
        System.out.println("courseMarket = " + courseMarket);*/
        CourseMarket one = new CourseMarket();
        one.setCharge("203009");
        one.setStartTime(new Date());//课程有效期，开始时间
        one.setEndTime(new Date());//课程有效期，结束时间
        one.setPrice(200f);
        one.setQq("4455432");
        one.setValid("204001");
        ResponseResult responseResult = courseController.updateCourseMarket("40289981766c49ed01766c56f27f0001", one);
        System.out.println("responseResult = " + responseResult);
    }
}