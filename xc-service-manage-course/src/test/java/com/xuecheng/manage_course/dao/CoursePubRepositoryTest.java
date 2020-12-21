package com.xuecheng.manage_course.dao;

import com.xuecheng.framework.domain.course.CoursePub;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@SpringBootTest
@RunWith(SpringRunner.class)
public class CoursePubRepositoryTest {
@Autowired
    CoursePubRepository coursePubRepository;

    @Test
    public void testName() {
        CoursePub coursePub =new CoursePub() ;
//        * CoursePub(id=40289981768605cd0176860671260000,
//        * name=null,
        coursePub.setName("heheh");
//        *  users=null,

//        * mt=null,
        coursePub.setMt("1-1");
//        *  st=null,
        coursePub.setSt("1-1-9");
//        *  grade=null,
        coursePub.setGrade("200002");
//        *  studymodel=null,
        coursePub.setStudymodel("201001");
//        *  teachmode=null,
//        *  description=null,
//        *  pic=5fe0c652a513c213dc57b8f9,
//        *  timestamp=Tue Dec 22 00:38:00 CST 2020,
//        *  charge=203001,
//        *  valid=204001,
//        *  qq=去去去,
//        * price=null,
//        * price_old=null,
//        * expires=null,
//        *  teachplan=null,
//        * pubTime=null)
        coursePub.setId("40289981768605cd0176860671260000");
        coursePub.setQq("去去去");
        coursePub.setValid("204001");
        coursePub.setDescription("hehehehe");
        coursePub.setGrade("20010");
        CoursePub save = coursePubRepository.save(coursePub);
    }
}