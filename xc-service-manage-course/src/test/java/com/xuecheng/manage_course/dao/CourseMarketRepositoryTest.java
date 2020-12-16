package com.xuecheng.manage_course.dao;

import com.xuecheng.framework.domain.course.CourseMarket;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.Optional;

import static org.junit.Assert.*;
@SpringBootTest
@RunWith(SpringRunner.class)
public class CourseMarketRepositoryTest {
@Autowired
    CourseMarketRepository courseMarketRepository;

    @Test
    public void testFindById() {
        Optional<CourseMarket> byId = courseMarketRepository.findById("297e7c7c62b888f00162b8a965510001");
        System.out.println("byId = " + byId.isPresent());
        System.out.println("CourseMarket = " + byId.get());
    }

    @Test
    public void testUpdate() {
        /*"id": "4028e581617f945f01617f9dabc40000",
  "charge": "203002",
  "valid": "204001",
  "qq": "4455432",
  "price": 0.01,
  "price_old": null,
  "startTime": "2018-04-01T02:50:31.000+0000",
  "endTime": "2020-04-01T02:50:37.000+0000"*/
        CourseMarket one = new CourseMarket();
        one.setCharge("203002");
        one.setStartTime(new Date());//课程有效期，开始时间
        one.setEndTime(new Date());//课程有效期，结束时间
        one.setPrice(200f);
        one.setQq("4455432");
        one.setValid("204001");
        one.setId("40289981766c49ed01766c56f27f0001");
        courseMarketRepository.save(one);
    }
}