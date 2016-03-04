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

    @Resource(name = "teachersServiceImpl")
    TeachersService teachersService;

    public String query(){
        List<Teacher> list=teachersService.queryAll();
        session.setAttribute("teachers_list",list);
        return "query_success";
    }

    public String add(){
        teachersService.add(teacher);
        return "add_success";
    }

    public String delete(){
        teachersService.delete(teacher);
        return "delete_success";
    }

    public String modify(){
        String tid=request.getParameter("tid");
        Teacher teacher1=teachersService.queryById(tid);
       // System.out.println(teacher1);
        session.setAttribute("modify_teacher",teacher1);
        return "teachers_modify";
    }

    public String update(){
       // System.out.println(teacher);
        teachersService.update(teacher);
        return "update_success";
    }

    public String find(){
        List<Teacher> list=teachersService.findByCondtion(teacher);
        session.setAttribute("teachers_listByFind",list);
        return "find_success";
    }

    @Override
    public Teacher getModel() {
        return teacher;
    }
}
