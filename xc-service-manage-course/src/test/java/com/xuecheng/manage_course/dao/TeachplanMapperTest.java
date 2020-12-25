package com.xuecheng.manage_course.dao;

import com.xuecheng.framework.domain.course.ext.TeachplanNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TeachplanMapperTest {
@Autowired
TeachplanMapper teachplanMapper;
    @Test
    public void testSelectList() {
        TeachplanNode teachplanNode = teachplanMapper.selectList("402885816243d2dd016243f24c030002");
        System.out.println("id1 = " + teachplanNode.getId());
        System.out.println("pname1 = " + teachplanNode.getPname());
        System.out.println("grade1 = " + teachplanNode.getGrade());
        List<TeachplanNode> children = teachplanNode.getChildren();
        for (TeachplanNode teachplanNode2:children) {
            System.out.println("id2 = " + teachplanNode2.getId());
            System.out.println("pname2 = " + teachplanNode2.getPname());
            System.out.println("grade2 = " + teachplanNode2.getGrade());
            for (TeachplanNode teachplanNode3:teachplanNode2.getChildren()) {
                System.out.println("id3 = " + teachplanNode3.getId());
                System.out.println("pname3 = " + teachplanNode3.getPname());
                System.out.println("grade3 = " + teachplanNode3.getGrade());
                System.out.println("mediaId = " + teachplanNode3.getMediaId());
                System.out.println("mediaFileOriginalName3 = " + teachplanNode3.getMediaFileOriginalName());
            }
        }

    }


    @Test
    public void testFindById() {

    }
}