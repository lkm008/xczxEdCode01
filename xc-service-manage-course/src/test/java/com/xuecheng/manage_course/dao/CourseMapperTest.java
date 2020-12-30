package com.xuecheng.manage_course.dao;

import static org.junit.Assert.*;

import com.github.pagehelper.Page;
import com.xuecheng.framework.domain.course.ext.CourseInfo;
import com.xuecheng.framework.domain.course.request.CourseListRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CourseMapperTest {
    @Autowired
    CourseMapper courseMapper;

    @Test
    public void testFindCourseBaseById() {
    }

    @Test
    public void testFindCourseListPage() {
        CourseListRequest courseListRequest = new CourseListRequest();
        courseListRequest.setCompanyId("1");
        Page<CourseInfo> courseListPage = courseMapper.findCourseListPage(courseListRequest);
        System.out.println("courseListPage = " + courseListPage.getResult());
    }
}