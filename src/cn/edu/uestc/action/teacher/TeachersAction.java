package cn.edu.uestc.action.teacher;

import cn.edu.uestc.action.SuperAction;
import cn.edu.uestc.entity.Teacher;
import cn.edu.uestc.service.TeachersService;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by walter on 16-3-3.
 */
@Component("teachersAction")
@Scope("prototype")
public class TeachersAction extends SuperAction implements ModelDriven<Teacher> {

    Teacher teacher = new Teacher();
    //自动注入
    @Resource(name = "teachersServiceImpl")
    TeachersService teachersService;

    //查询所有教师
    public String query() {
        List<Teacher> list = teachersService.queryAll();
        session.setAttribute("teachers_list", list);
        return "query_success";
    }

    //添加一个教师
    public String add() {
        teachersService.add(teacher);
        return "add_success";
    }

    //删除一个教师
    public String delete() {
        teachersService.delete(teacher);
        return "delete_success";
    }

    //更改教师信息和update配合使用，首先查询出来要更改的教师信息
    public String modify() {
        String tid = request.getParameter("tid");
        Teacher teacher1 = teachersService.queryById(tid);
        // System.out.println(teacher1);
        session.setAttribute("modify_teacher", teacher1);
        return "teachers_modify";
    }

    //将更改后的教师信息写回到服务器数据库
    public String update() {
        // System.out.println(teacher);
        teachersService.update(teacher);
        return "update_success";
    }

    //根据条件查询一个教师信息
    public String find() {
        List<Teacher> list = teachersService.findByCondtion(teacher);
        session.setAttribute("teachers_listByFind", list);
        return "find_success";
    }

    @Override
    public Teacher getModel() {
        return teacher;
    }
}
