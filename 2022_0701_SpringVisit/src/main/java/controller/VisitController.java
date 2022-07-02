package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.VisitDAO;
import vo.VisitVO;

@Controller
public class VisitController {

	VisitDAO visitDAO;

	public void setVisitDAO(VisitDAO visitDAO) {
		this.visitDAO = visitDAO;
	}

	// /visit/list.do
	// /visit/list.do?search=all&searchText=
	// /visit/list.do?search=all&searchText=�浿

	@RequestMapping("/visit/list.do")
	public String list(@RequestParam(value = "search", required = false, defaultValue = "all") String search,
			@RequestParam(value = "searchText", required = false) String searchText, Model model) {

		// �˻������� ���� Map
		Map<String, String> map = new HashMap<String, String>();
		if (!search.equals("all")) {
			if (search.equals("name_content")) {
				map.put("name", searchText);
				map.put("content", searchText);
			} else if (search.equals("name")) {
				map.put("name", searchText);
			} else if (search.equals("content")) {
				map.put("content", searchText);
			}

		}

		// ��� ��������
		List<VisitVO> list = visitDAO.selectList(map);

		// DispatcherServlet�� �������� ����� ����(model)�� �̿��ؼ� ������ ����(Map�� ���·�)
		model.addAttribute("list", list);

		return "visit/visitList";
	}

	// �Խñ� �Է���
	@RequestMapping("/visit/insertForm.do")
	public String insertForm(HttpServletRequest request, HttpServletResponse response) {

		return "visit/visitInsertForm";
	}

	// �Խñ� �Է�
	// VisitVO ��ü�� �ޱ�(����: parameter�� vo�� �Ӽ����� ���ƾ��Ѵ�)
	@RequestMapping("/visit/insert.do")
	public String insert(VisitVO vo, HttpServletRequest request, HttpServletResponse response) {

		// ip���ϱ�
		String ip = request.getRemoteAddr();
		// vo�� ip�߰�
		vo.setIp(ip);

		// DB insert
		int res = visitDAO.insert(vo);

		return "redirect:list.do";
	}

	// ������Ʈ��
	@RequestMapping("/visit/updateForm.do")
	public String updateForm(int idx, Model model) {

		// ��� ��������
		VisitVO vo = visitDAO.selectOne(idx);
		
		/*// ���� ������ �ٽ� �����ϱ� 
		String content = vo.getContent().replaceAll("<br>","\r\n").replaceAll("<p>","\n").replaceAll("</p>",""); 
		vo.setContent(content);*/

		model.addAttribute("vo", vo);

		return "visit/visitUpdateForm";
	}

	// ������Ʈ ����
	@RequestMapping("/visit/update.do")
	public String update(VisitVO vo, HttpServletRequest request) {

		String ip = request.getRemoteAddr();
		vo.setIp(ip);

		int res = visitDAO.update(vo);

		return "redirect:list.do";
	}

	// ����
	@RequestMapping("/visit/delete.do")
	public String delete(int idx) {

		int res = visitDAO.delete(idx);

		return "redirect:list.do";
	}

	// ��й�ȣ üũ
	@RequestMapping("/visit/checkPwd.do")
	@ResponseBody
	public String checkPwd(int idx, String cfmPwd) {
		// idx�� �ش��ϴ� �Խù� ������
		VisitVO vo = visitDAO.selectOne(idx);
		// ���üũ�ϱ�
		boolean bResult = vo.getPwd().equals(cfmPwd);

		// json���� �����ϱ�
		JSONObject json = new JSONObject();
		json.put("result", bResult);
		String jsonStr = json.toJSONString();

		return jsonStr;
	}

}
