package com.car.courseservice.client;

import com.car.courseservice.dto.StudentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "student-service", url = "${application.config.student-url}")
public interface StudentClient {

    @GetMapping("/students/getStudentByCourseID/{courseID}")
    List<StudentDto> getStudentByCourseID(@PathVariable("courseID") Long courseID);
}
