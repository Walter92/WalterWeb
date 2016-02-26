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
public class StudentsAction extends SuperAction implements ModelDriven<Students>{
	Students student=new Students();

    private StudentsService studentsService;
    //自动注入
    @Resource(name="studentsServiceImpl")
    public void setStudentsService(StudentsService studentsService){
        this.studentsService=studentsService;
    }


	public String query(){
		List<Students> slist=studentsService.queryAll();
		session.setAttribute("students_list", slist);
		return "query_success";
	}

    public  StudentsAction(){
        super();
    }

	public String update(){
        studentsService.update(student);
		return "update_success";
	}
	public String modify(){
		String sid=request.getParameter("sid");
		Students student=studentsService.queryById(sid);
		session.setAttribute("modify_student", student);
		return "student_modify";
	}

	public String delete(){
		String sid=(String) request.getParameter("sid");
		Students student=studentsService.queryById(sid);
        studentsService.delete(student);
		return "delete_success";
	}
	
	public String add(){
        studentsService.add(student);
		return "add_success";
	}
	
	public String find(){
		List<Students> students_listByFind=studentsService.findByCondtion(student);
		session.setAttribute("students_listByFind", students_listByFind);
		return "find_success";
	}

	@Override
	public Students getModel() {
		return this.student;
	}
	
}
