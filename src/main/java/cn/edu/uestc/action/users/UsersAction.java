package cn.edu.uestc.action.users;


import org.apache.struts2.interceptor.validation.SkipValidation;

import cn.edu.uestc.service.UserService;

import com.opensymphony.xwork2.ModelDriven;

import cn.edu.uestc.entity.Users;

import cn.edu.uestc.action.SuperAction;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component("usersAction")
@Scope("prototype")
public class UsersAction extends SuperAction implements ModelDriven<Users>{
	private Users user=new Users();

    private UserService userService;

    @Resource(name="userServiceImpl")
    public void setStudentsService(UserService userService){
        this.userService=userService;
    }
    public UsersAction(){
        super();
    }

	@Override
	public void validate() {
		String name=user.getUsername();
		String pass=user.getPassword();
		if(name==null||name.trim().equals("")){
			this.addFieldError("nameError", "名字不能为空！");
		}
		if(pass==null||pass.length()<6){
			this.addFieldError("passError", "密码不能小于六位！");
		}
	}

	public String login(){
		 if(userService.login(user)){
			 session.setAttribute("loginUserName", user.getUsername());
			 return "login_success";
		 }
		 return "login_failure";	 
	}
	@SkipValidation
	public String logout(){
		if(session.getAttribute("loginUserName")!=null&&!"".equals(session.getAttribute("loginUserName")))
		{
			session.removeAttribute("loginUserName");
		}
		return "logout_success";
	}
	@Override
	public Users getModel() {
		return this.user;
	}
}
