package cn.edu.uestc.entity;

import java.util.Date;


public interface StudentsApi {
    public String getMajor();

    public void setMajor(String major) ;

    public String getProject() ;

    public void setProject(String project);

    public String getTel();

    public void setTel(String tel);




    public String getSid();

    public void setSid(String sid);

    public String getSname();

    public void setSname(String sname);

    public String getGender();

    public void setGender(String gender);

    public Date getBirthday();

    public void setBirthday(Date birthday);

    public String getAddress();

    public void setAddress(String address);
}
