package cn.edu.uestc.action.students;

import java.util.List;

import com.opensymphony.xwork2.ModelDriven;

import cn.edu.uestc.entity.Students;

import cn.edu.uestc.service.StudentsService;
import cn.edu.uestc.action.SuperAction;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component("studentsAction")
@Scope("prototype")

/**
 * 学生类的Action，实现了学生的增加，查询，修改，删除操作
 * 继承于superAction，实现ModelDriven接口，模型驱动方式接收表单提交的数据来创建学生对象
 */
public class StudentsAction extends SuperAction implements ModelDriven<Students> {
    Students student = new Students();

    private StudentsService studentsService;

    //自动注入
    @Resource(name = "studentsServiceImpl")
    public void setStudentsService(StudentsService studentsService) {
        this.studentsService = studentsService;
    }


    //查询所有学生,只查询姓名和学号
    public String query() {
        //调用service层获取所有学生的列表
        List<Students> slist = studentsService.queryAll();
       // for(Students stu: slist){
          //  System.out.println(slist);
        //}
        //将学生列表放入session中，在jsp页面通过struts2标签迭代输出
        session.setAttribute("students_list", slist);
        return "query_success";
    }

    //查询所有学生,只查询姓名和学号
    public String queryDetailed() {
        String sid = request.getParameter("sid");
        //调用service层获取所有学生的列表
        Students student = studentsService.queryById(sid);
        //将学生列表放入session中，在jsp页面通过struts2标签迭代输出
        session.setAttribute("students_detailed", student);
        return "query_detailed_success";
    }

    public StudentsAction() {
        super();
    }

    public String update() {
        //调用service层更新学生
        studentsService.update(student);
        return "update_success";
    }

    public String modify() {
        //获取要修改的学生sid，sid通过get请求。。。？sid=**
        String sid = request.getParameter("sid");
        //通过sid查询学生信息，返回学生实例，放在session中，在前端通过ognl表达式取出
        Students student = studentsService.queryById(sid);
        session.setAttribute("modify_student", student);
        return "student_modify";
    }

    public String delete() {
        //获取要删除的学生sid，sid通过get请求。。。？sid=**
        String sid = (String) request.getParameter("sid");
        //查询后删除
        Students student = studentsService.queryById(sid);
        studentsService.delete(student);
        return "delete_success";
    }

    //添加一个学生
    public String add() {
        studentsService.add(student);
        return "add_success";
    }

    //根据条件查询一个学生，条件有学号或者姓名
    public String find() {
        List<Students> students_listByFind = studentsService.findByCondtion(student);
        session.setAttribute("students_listByFind", students_listByFind);
        return "find_success";
    }

    @Override
    public Students getModel() {
        return this.student;
    }

}
