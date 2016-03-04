package cn.edu.uestc.test;

import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import cn.edu.uestc.dao.impl.StudentsDaoImpl;
import org.junit.Test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.edu.uestc.dao.StudentsDao;
import cn.edu.uestc.entity.Students;

public class StudentsTest {
    StudentsDao sdao;
    {
        ApplicationContext act =
                new ClassPathXmlApplicationContext("spring-config.xml");
        sdao = (StudentsDao) act.getBean("studentsDaoImpl");
        System.out.println(sdao.getClass().getName());


    }

//	@Test
//	public void testSchem(){
//		Configuration cong=new Configuration().configure();
//		ServiceRegistry serviceRegistry=new ServiceRegistryBuilder()
//				.applySettings(cong.getProperties()).buildServiceRegistry();
//		SessionFactory sessionFactory=cong.buildSessionFactory(serviceRegistry);
//		Session session=sessionFactory.getCurrentSession();
//		SchemaExport export=new SchemaExport(cong);
//		export.create(true, true);
//	}
	
	@Test
	public void testQueryAll(){
		List<Students> list=sdao.queryAll();
		for(Students stu:list)
			System.out.println(stu);
	}
	@Test
	public void testQuery(){
		Students stu=sdao.query("S0000001");
		System.out.println(stu);
	}
	@Test
	public void testAdd(){
		List<Students> list=new ArrayList<Students>();
		list.add(new Students( "S0000006",  "孙悟空",  "男",  new Date(), "花果山"));
		list.add(new Students( "S0000006",  "孙悟空",  "男",  new Date(), "花果山"));
		for(Students stu:list)
			sdao.add(stu);
	}
	@Test
	public void testUpdate(){
		Students stu=new Students( "S0000001",  "王母",  "女",  new Date(), "天庭");
		sdao.update(stu);
	}
//	@Test
//	public void testNewSid(){
//		StudentsServiceImpl sdao=new StudentsServiceImpl();
//		System.out.println(sdao.getNewStudent());
//	}

}
