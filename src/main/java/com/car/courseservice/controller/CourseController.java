package com.car.courseservice.controller;


import com.car.courseservice.dto.FullCourseResponse;
import com.car.courseservice.entity.Course;
import com.car.courseservice.service.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/course")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }


    @PostMapping("/create")
    public ResponseEntity<Course> createCourse(@RequestBody Course course) {
        Course createdCourse = courseService.createCourse(course);
        return ResponseEntity.ok(createdCourse);
    }
    @GetMapping("/{courseId}")
    public ResponseEntity<FullCourseResponse> getFullCourseData(@PathVariable Long courseId) {
        FullCourseResponse fullCoureseData = courseService.getFullCoureseData(courseId);
        return ResponseEntity.ok(fullCoureseData);
    }

}
