package cn.edu.uestc.service.impl;

import java.util.List;

import cn.edu.uestc.dao.StudentsDao;

import cn.edu.uestc.entity.Students;
import org.springframework.stereotype.Service;
import cn.edu.uestc.service.StudentsService;

import javax.annotation.Resource;

@Service("studentsServiceImpl")
public class StudentsServiceImpl implements StudentsService {

    private StudentsDao sdao;

    @Resource(name = "studentsDaoImpl")
    public void setSdao(StudentsDao sdao) {
        this.sdao = sdao;
    }

    //增加一个学生
    @Override
    public boolean add(Students stu) {
        //为新增学生设置学号
        stu.setSid(getNewStudent());
        sdao.add(stu);
        return true;
    }

    //删除一个学生
    @Override
    public boolean delete(Students stu) {
        return sdao.delete(stu);
    }

    //查询所有学生列表
    @Override
    public List<Students> queryAll() {
        List<Students> slist = sdao.queryAll();
        return slist;
    }

    //查询所有学生列表
    @Override
    public List<Students> queryDetailedAll() {
        List<Students> slist = sdao.queryDetailAll();
        return slist;
    }



    //更新一个学生信息
    @Override
    public boolean update(Students stu) {
        sdao.update(stu);
        return false;
    }

    //通过id查询一个学生
    @Override
    public Students queryById(String sid) {
        return sdao.query(sid);
    }

    //生成一个新的学生学号，学号格式S0000001
    protected String getNewStudent() {
        //获取当前数据表中最大学生学号
        String maxSid = sdao.getMaxSid();
        int i = Integer.parseInt(maxSid.substring(1));
        //将学号后面部分数字加一
        String temp = String.valueOf(++i);
        int len = temp.length();
        for (int j = 0; j < 7 - len; j++)
            temp = "0" + temp;
        //返回新的学生学号字符串
        String newSid = "S" + temp;
        return newSid;
    }

    //按照条件查
    @Override
    public List<Students> findByCondtion(Students student) {
        return sdao.findBycondition(student);
    }

}
