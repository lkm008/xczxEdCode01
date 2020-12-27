package com.xuecheng.learning.client;

import com.xuecheng.framework.domain.course.TeachplanMediaPub;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CourseSearchClientTest {
    @Autowired
    CourseSearchClient courseSearchClient;

    @Autowired
    RestTemplate restTemplate;

    @Test
    public void testGetmedia() {
        TeachplanMediaPub getmedia = courseSearchClient.getmedia("40288581632b593e01632bd606480004");
        System.out.println("getmedia = " + getmedia);
    }

    @Test
    public void testName() {
        ResponseEntity<TeachplanMediaPub> forEntity = restTemplate.getForEntity("http://localhost:40100/search/course/getmedia/40288581632b593e01632bd606480004", TeachplanMediaPub.class);
        System.out.println("forEntity = " + forEntity);
    }
}