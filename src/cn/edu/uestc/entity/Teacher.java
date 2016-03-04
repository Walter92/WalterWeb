package cn.edu.uestc.entity;

import org.springframework.stereotype.Component;

import java.util.*;

@Component("teacher")
public class Teacher {
    private Integer tid;
    private String name;
    private String gender;
    private String subject;
    private String address;

    private Set<Students> studentsList;



    public Teacher() {
       // this.tid = tid;
    }

    public Teacher(Integer tid, String name, String gender, String subject, String address) {
        this.tid = tid;
        this.name = name;
        this.gender = gender;
        this.subject = subject;
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Teacher teacher = (Teacher) o;

        if (tid != null ? !tid.equals(teacher.tid) : teacher.tid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    public Set<Students> getStudentsList() {
        return studentsList;
    }

    public void setStudentsList(Set<Students> studentsList) {
        this.studentsList = studentsList;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "tid=" + tid +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", subject='" + subject + '\'' +
                ", address='" + address + '\'' +
                ", studentsList=" + studentsList +
                '}';
    }

}
