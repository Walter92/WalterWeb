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
    @Resource(name="studentsDaoImpl")
    public void setSdao(StudentsDao sdao) {
        this.sdao = sdao;
    }

    @Override
	public boolean add(Students stu) {
		stu.setSid(getNewStudent());
		sdao.add(stu);
		return true;
	}

	@Override
	public boolean delete(Students stu) {
		return sdao.delete(stu);
	}

	@Override
	public List<Students> queryAll() {
		List<Students> slist = sdao.queryAll();
		return slist;
	}

	@Override
	public boolean update(Students stu) {
		sdao.update(stu);
		return false;
	}

	@Override
	public Students queryById(String sid) {
		return sdao.query(sid);

	}

	protected String getNewStudent() {
		String maxSid = sdao.getMaxSid();
		int i = Integer.parseInt(maxSid.substring(1));
		String temp = String.valueOf(++i);
		int len = temp.length();
		for (int j = 0; j < 7 - len; j++)
			temp = "0" + temp;
		String newSid = "S" + temp;
		return newSid;
	}

	@Override
	public List<Students> findByCondtion(Students student) {
		
		return sdao.findBycondition(student);
	}

}
