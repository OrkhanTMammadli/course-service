package com.car.courseservice.controller;


import com.car.courseservice.dto.FullCourseResponse;
import com.car.courseservice.entity.Course;
import com.car.courseservice.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/course")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }


    @PostMapping("/create")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Course> createCourse(@RequestBody Course course) {
        log.info("Received request to create course: {}", course);
        Course createdCourse = courseService.createCourse(course);
        return ResponseEntity.ok(createdCourse);
    }


    @GetMapping("/{courseId}")
    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    public ResponseEntity<FullCourseResponse> getFullCourseData(@PathVariable Long courseId) {
        log.info("Received request to get all courses");
        FullCourseResponse fullCoureseData = courseService.getFullCoureseData(courseId);
        return ResponseEntity.ok(fullCoureseData);
    }

}
