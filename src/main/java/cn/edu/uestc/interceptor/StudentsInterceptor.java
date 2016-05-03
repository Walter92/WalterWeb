package cn.edu.uestc.interceptor;

import java.util.*;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class StudentsInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		ActionContext actionContext=ActionContext.getContext();
		Map<String,Object> session=actionContext.getSession();
		if(session.get("loginUserName")!=null)
			return invocation.invoke();
		return "login_failure";
	}

}
