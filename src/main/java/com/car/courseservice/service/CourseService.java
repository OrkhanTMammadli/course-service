package com.car.courseservice.service;

import com.car.courseservice.client.StudentClient;
import com.car.courseservice.dto.FullCourseResponse;
import com.car.courseservice.dto.StudentDto;
import com.car.courseservice.entity.Course;
import com.car.courseservice.repository.ServiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    private final ServiceRepository serviceRepository;
    private final StudentClient studentClient;

    public CourseService(ServiceRepository serviceRepository, StudentClient studentClient) {
        this.serviceRepository = serviceRepository;
        this.studentClient = studentClient;
    }
    public Course createCourse(Course course){
        return serviceRepository.save(course);
    }
    public FullCourseResponse getFullCoureseData(Long courseId){

        Course course = serviceRepository.findById(courseId).orElseThrow(() -> new RuntimeException("Course not found") );
        List<StudentDto> students = studentClient.getStudentByCourseID(course.getId());

        return new FullCourseResponse(course, students);
    }
}
