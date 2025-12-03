package com.car.courseservice.service;

import com.car.courseservice.client.StudentClient;
import com.car.courseservice.dto.FullCourseResponse;
import com.car.courseservice.dto.StudentDto;
import com.car.courseservice.entity.Course;
import com.car.courseservice.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    private final CourseRepository courseRepository;
    private final StudentClient studentClient;

    public CourseService(CourseRepository courseRepository, StudentClient studentClient) {
        this.courseRepository = courseRepository;
        this.studentClient = studentClient;
    }
    public Course createCourse(Course course){
        return courseRepository.save(course);
    }
    public FullCourseResponse getFullCoureseData(Long courseId){

        Course course = courseRepository.findById(courseId).orElseThrow(() -> new RuntimeException("Course not found") );
        List<StudentDto> students = studentClient.getStudentByCourseID(course.getId());

        return new FullCourseResponse(course, students);
    }
}
