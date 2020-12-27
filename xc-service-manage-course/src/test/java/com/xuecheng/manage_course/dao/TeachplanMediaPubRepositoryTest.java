package com.xuecheng.manage_course.dao;

import com.xuecheng.framework.domain.course.TeachplanMediaPub;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TeachplanMediaPubRepositoryTest {
    @Autowired
    TeachplanMediaPubRepository teachplanMediaPubRepository;

    @Test
    // @Modifying
    @Transactional
    @Rollback(value = false)
    public void testDeleteByCourseId() {
        teachplanMediaPubRepository.deleteByCourseId("4028e58161bd3b380161bd3bcd2f0000");
    }

    @Test
    public void testFindAll() {
        List<TeachplanMediaPub> all = teachplanMediaPubRepository.findAll();
        System.out.println("all = " + all);
    }

    @Test
    public void testFindById() {
        Optional<TeachplanMediaPub> byId = teachplanMediaPubRepository.findById("4028e58161bd3b380161bd40cf340009");
        System.out.println("byId = " + byId);
    }

    @Test
    public void testFindByCourseId() {
        List<TeachplanMediaPub> byCourseId = teachplanMediaPubRepository.findByCourseId("4028e58161bd3b380161bd3bcd2f0000");
        System.out.println("byCourseId = " + byCourseId);
    }

    @Test
    public void testDeleteById() {
        teachplanMediaPubRepository.deleteById("4028e58161bd3b380161bd40cf340009");
    }
}