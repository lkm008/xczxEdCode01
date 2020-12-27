package com.xuecheng.learning.client;

import com.xuecheng.framework.domain.course.TeachplanMediaPub;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;


@FeignClient(value = "xc-service-search")
public interface CourseSearchClient {
    @GetMapping(value="/search/course/getmedia/{teachplanId}")
    @ResponseBody
    public TeachplanMediaPub getmedia(@PathVariable("teachplanId") String teachplanId);
}

