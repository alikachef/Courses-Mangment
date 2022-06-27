package com.genspark.SpringBootToturial.service;

import com.genspark.SpringBootToturial.entity.Course;

import java.util.List;

public interface CourseService {
    List<Course> getAllCourse();

    Course getCourseById(int courseId);

    Course addCourse(Course course);

    Course updateCourse(Course course);

    String deleteCourse(int courseId);
}
