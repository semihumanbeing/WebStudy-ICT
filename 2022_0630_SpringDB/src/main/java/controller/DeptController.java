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
		
		// 가져온 데이터를 DispatcherServlet에게 전달한다.
		// model을 통해 전달하면 DS가 request binding하고 그 정보를 바탕으로 forward시킨다.
		model.addAttribute("list",list);
		
		return "dept/dept_list"; // forward 시킬 뷰 정보
		
		
	}
	
	
}
