package com.genspark.SpringBootToturial.entity;

import javax.persistence.*;

@Entity
@Table(name="tbl.courses")
public class Course {
    @Id
    @Column(name="cl.courseid")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int courseid;
    @Column(name="cl.title")
    private String title;
    @Column(name="cl.instructor")
    private String instructor;
    @Column (name = "cl.grade")
    private int grade;
    @Column (name = "cl.school")
    private String school;

    public int getCourseid() {return courseid;}
    public void setCourseid(int courseid) {this.courseid = courseid;}

    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}

    public String getInstructor() {return instructor;}
    public void setInstructor(String instructor) {this.instructor = instructor;}

    public int getGrade() {return grade;}
    public void setGrade(int grade) {this.grade = grade;}

    public String getSchool() {return school;}
    public void setSchool(String school) {this.school = school;}
    public Course(){}

    public Course( String title, String instructor, int grade, String school) {
        this.title = title;
        this.instructor = instructor;
        this.grade = grade;
        this.school = school;
    }


}
