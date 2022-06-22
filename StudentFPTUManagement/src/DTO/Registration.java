/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author PC
 */
public class Registration implements Comparable<Registration>{
    Student student;
    Course course;
    int index;

    public Registration(Student student, Course course) {
        this.student = student;
        this.course = course;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void output() {
        System.out.printf("|%-8s|%-15s|%-5s|%-15s|%7d|\n", student.getId(), student.getName(), course.getCode(), course.getName(), course.getCredits());
    }

    @Override
    public int compareTo(Registration o) {
        if (index == o.getIndex()) {
            return 0;
        } else if (index > o.getIndex()) {
            return 1;
        } else {
            return -1;
        }
    }
}
