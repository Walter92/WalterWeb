package cn.edu.uestc.entity;

import java.util.Date;


public class StudentsProxy implements StudentsApi {

    private StudentsApi student;

    public StudentsProxy(StudentsApi student){
        this.student = student;
    }

    @Override
    public String getMajor() {
        return student.getMajor();
    }

    @Override
    public void setMajor(String major) {
        student.setMajor(major);
    }

    @Override
    public String getProject() {
        return student.getProject();
    }

    @Override
    public void setProject(String project) {
        student.setProject(project);
    }

    @Override
    public String getTel() {
        return student.getTel();
    }

    @Override
    public void setTel(String tel) {
        student.setTel(tel);
    }

    @Override
    public String getSid() {
        return student.getSid();
    }

    @Override
    public void setSid(String sid) {
        student.setSid(sid);
    }

    @Override
    public String getSname() {
        return student.getSname();
    }

    @Override
    public void setSname(String sname) {
        student.setSname(sname);
    }

    @Override
    public String getGender() {
        return student.getGender();
    }

    @Override
    public void setGender(String gender) {
        student.setGender(gender);
    }

    @Override
    public Date getBirthday() {
        return student.getBirthday();
    }

    @Override
    public void setBirthday(Date birthday) {
        student.setBirthday(birthday);
    }

    @Override
    public String getAddress() {
        return student.getAddress();
    }

    @Override
    public void setAddress(String address) {
        student.setAddress(address);
    }
}
