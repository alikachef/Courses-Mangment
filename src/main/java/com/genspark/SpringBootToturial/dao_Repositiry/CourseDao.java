package com.genspark.SpringBootToturial.dao_Repositiry;

import com.genspark.SpringBootToturial.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CourseDao extends JpaRepository<Course, Integer> {
}
