package com.car.courseservice.dto;


import com.car.courseservice.entity.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class FullCourseResponse {
    private Course course;
    private List<StudentDto> students;
}
