package com.car.courseservice.service;

import com.car.courseservice.client.StudentClient;
import com.car.courseservice.dto.FullCourseResponse;
import com.car.courseservice.dto.StudentDto;
import com.car.courseservice.entity.Course;
import com.car.courseservice.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class CourseService {
    private final CourseRepository courseRepository;
    private final StudentClient studentClient;
    private final EmailService emailService;

    public Course createCourse(Course course){
         Course savedCourse = courseRepository.save(course);
         log.info("Success",savedCourse.getId());
         emailService.sendEmail("orkhantmammadli@outlook.com","New Registry","Hello");
         return savedCourse;
    }
    public FullCourseResponse getFullCoureseData(Long courseId){

        Course course = courseRepository.findById(courseId).orElseThrow(() -> new RuntimeException("Course not found") );
        List<StudentDto> students = studentClient.getStudentByCourseID(course.getId());

        return new FullCourseResponse(course, students);
    }
}
