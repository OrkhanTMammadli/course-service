package com.car.courseservice.dto;


import com.car.courseservice.entity.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
public class FullCourseResponse {
    private Course course;
    private List<StudentDto> students;

    public FullCourseResponse(Course course, List<StudentDto> students) {
        this.course = course;
        this.students = students;
    }
}
