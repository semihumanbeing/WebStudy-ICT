package controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.DeptDao;
import vo.DeptVo;

@Controller
public class DeptController {
	
	DeptDao deptDao;

	// contructor injection
	public DeptController(DeptDao deptDao) {
		this.deptDao = deptDao;
	}
	
	@RequestMapping("/dept/list.do")
	public String list(Model model) {
		
		List<DeptVo> list = deptDao.selectList();
		
		// ������ �����͸� DispatcherServlet���� �����Ѵ�.
		// model�� ���� �����ϸ� DS�� request binding�ϰ� �� ������ �������� forward��Ų��.
		model.addAttribute("list",list);
		
		return "dept/dept_list"; // forward ��ų �� ����
		
		
	}
	
	
}
