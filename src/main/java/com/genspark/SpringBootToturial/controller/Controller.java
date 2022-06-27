package com.genspark.SpringBootToturial.controller;

import com.genspark.SpringBootToturial.entity.Course;
import com.genspark.SpringBootToturial.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class Controller {

    @Autowired
    private CourseService courseService;

    @RequestMapping("/")
    public String home(){
        return "<html><h1>Welcome to the Course Project</h1></html>";
    }

    @GetMapping("/courses")
    public List<Course> getCourses(){
        return this.courseService.getAllCourse();
    }

    @GetMapping("/courses/{id}")
    public Course getCourse(@PathVariable int id){
        return  this.courseService.getCourseById(id);
    }

    @PostMapping("/courses")
    public Course addCourse(@RequestBody Course course){
        return this.courseService.addCourse(course);
    }

    @PutMapping("/courses")
    public Course updateCourse(@RequestBody Course course){
        return this.courseService.updateCourse(course);
    }

    @DeleteMapping("/courses/{id}")
    public String deleteCourse(@PathVariable int id){
        return this.courseService.deleteCourse(id);
    }


}
