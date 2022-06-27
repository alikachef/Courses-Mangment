package com.genspark.SpringBootToturial.service;

import com.genspark.SpringBootToturial.dao_Repositiry.CourseDao;
import com.genspark.SpringBootToturial.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImplementation implements CourseService{
    /*
    List<Course> listOfCourse;

    public CourseServiceImplementation() {
        listOfCourse = new ArrayList<>();
        listOfCourse.add(new Course("Spring Boot Demo", "Predeep"));
        listOfCourse.add(new Course("introduction to Python", "J. Mike"));
        listOfCourse.add(new Course( "Statistics", "F. West"));
    }

    @Override
    public List<Course> getAllCourse() {
        return listOfCourse;
    }

    @Override
    public Course getCourseById(int courseId) {
        Course c = null;
        for (Course course: listOfCourse) {
            if (courseId == course.getCourseid()){
                c = course;
                break;
            }
        }
        return c;
    }

    @Override
    public Course addCourse(Course course) {
        listOfCourse.add(course);
        return course;
    }

    @Override
    public Course updateCourse(Course course) {
        String title = course.getTitle();
        String instructor = course.getInstructor();

        Course c = null;
        for (Course cc: listOfCourse) {
            if(cc.getCourseid() == course.getCourseid()){
                cc.setTitle(title);
                cc.setInstructor(instructor);
                c = cc;
                break;
            }
        }
        return c;
    }

    @Override
    public String deleteCourse(int courseId) {
        for (Course e: listOfCourse) {
            if(e.getCourseid() == courseId){
                listOfCourse.remove(e);
                break;
            }
        }
        return "Deleted Successfully";
    }*/
    @Autowired
    private CourseDao courseDao;

    @Override
    public List<Course> getAllCourse() {
        return this.courseDao.findAll();
    }

    @Override
    public Course getCourseById(int courseId) {
        Optional<Course> c = this.courseDao.findById(courseId);
        Course course = null;
        if(c.isPresent()){
            course = c.get();
        }
        else
            throw  new RuntimeException("ERROR! Course not found for id :: " + courseId);
        return course;
    }

    // Add and Update methods are the same as if an idd dont exist it will
    // Add the new data and if the id exist it will update and save the data
    @Override
    public Course addCourse(Course course) {
        return this.courseDao.save(course);
    }

    @Override
    public Course updateCourse(Course course) {
        return this.courseDao.save(course);
    }

    @Override
    public String deleteCourse(int courseId) {
        this.courseDao.deleteById(courseId);
        return "Deleted Successfully";
    }

}
