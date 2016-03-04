package cn.edu.uestc.test;

import cn.edu.uestc.dao.TeacherDao;
import cn.edu.uestc.entity.Teacher;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Iterator;
import java.util.List;

/**
 * Created by walter on 16-3-3.
 */
public class TeachersTest {
    private ApplicationContext applicationContext;
    private TeacherDao teacherDao;

    {
        applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
        teacherDao = applicationContext.getBean(TeacherDao.class);

    }

    @Test
    public void testTeacherDaoQueryAll(){
        List<Teacher> list = teacherDao.queryAll();
        Iterator<Teacher> iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    @Test
    public void testTeacherDaofindByCondition(){
        Teacher teacher = new Teacher();
//        teacher.setTid(1);
        teacher.setName("ter");
        List<Teacher> list = teacherDao.findByCondition(teacher);
        Iterator<Teacher> iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    @Test
    public void testTeacherDaoSave(){
        Teacher teacher = new Teacher(null,"walter","male","java",null);
        Boolean success = teacherDao.add(teacher);
        System.out.print(success);
    }

}
