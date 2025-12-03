package com.car.courseservice.repository;


import com.car.courseservice.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Course, Long> {

}
