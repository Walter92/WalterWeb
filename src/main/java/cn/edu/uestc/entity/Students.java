package cn.edu.uestc.entity;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component("students")
public class Students //implements StudentsApi
 {
    //
    private String sid;
    private String sname;
    private String gender;
    private Date birthday;
    private String address;

    private String major;

    private String project;

    private String tel;

    public Students() {
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "Students{" +
                "sid='" + sid + '\'' +
                ", sname='" + sname + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday=" + birthday +
                ", address='" + address + '\'' +
                ", major='" + major + '\'' +
                ", project='" + project + '\'' +
                ", tel='" + tel + '\'' +
                '}';
    }


    public Students(String sid, String sname) {
        this.sid = sid;
        this.sname = sname;
    }

    public Students(String sid, String sname, String gender, Date birthday, String address, String major, String project, String tel) {
        this.sid = sid;
        this.sname = sname;
        this.gender = gender;
        this.birthday = birthday;
        this.address = address;
        this.major = major;
        this.project = project;
        this.tel = tel;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


}
