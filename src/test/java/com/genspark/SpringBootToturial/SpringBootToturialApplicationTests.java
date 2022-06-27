package com.genspark.SpringBootToturial;

import com.genspark.SpringBootToturial.entity.Course;
import com.genspark.SpringBootToturial.service.CourseService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.Collection;

@SpringBootTest
class SpringBootToturialApplicationTests {

	@Autowired
	CourseService courseService;

	@Test
	void postTest() {
		Course course = new Course();
		course.setTitle("Junit");
		course.setInstructor("Test");
		course.setGrade(100);
		course.setSchool("TestSchool");
		courseService.addCourse(course);
		Assert.isTrue(courseService.getAllCourse().get(courseService.getAllCourse().size() -1).getTitle().contains(course.getTitle()));
	}

	@Test
	void GetAllCourses(){
		Assert.notEmpty(courseService.getAllCourse());
	}

	@Test
	void getCourseById(){
		Course course = courseService.getCourseById(courseService.getAllCourse().size() -1);
		Assert.isTrue(courseService.getCourseById(courseService.getAllCourse().size() -1).getCourseid() == course.getCourseid());
	}

	@Test
	void deleteCourseById(){
		Course course = courseService.getAllCourse().get(courseService.getAllCourse().size() -1);
		courseService.deleteCourse(course.getCourseid());
		Assert.isTrue(courseService.getCourseById(courseService.getAllCourse().size() -1).getCourseid() != course.getCourseid());
	}

}
