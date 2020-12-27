package com.xuecheng.learning.controller;

import com.xuecheng.api.learning.CourseLearningControllerApi;
import com.xuecheng.framework.domain.learning.response.GetMediaResult;
import com.xuecheng.learning.service.LearningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/learning/course")
public class CourseLearningController implements CourseLearningControllerApi {

    @Autowired
    LearningService learningService;

    @Override
    @GetMapping("/getmedia/{courseId}/{teachplanId}")
    @ResponseBody
    public GetMediaResult getmedia(@PathVariable(name = "courseId") String courseId,
                                   @PathVariable(name = "teachplanId") String teachplanId) {
        //获取课程学习地址
        return learningService.getMedia(courseId, teachplanId);
    }

}
