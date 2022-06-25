package mycontroller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import annotation.RequestMapping;
import annotation.ResponseBody;
import dao.VisitDAO;
import vo.VisitVO;

public class VisitController {
	
	@RequestMapping("/visit/list.do")
	public String list(HttpServletRequest request, HttpServletResponse response) {
		
		String search = request.getParameter("search");
		String searchText = request.getParameter("searchText");
		
		if(search==null || search.isEmpty()) {
			search = "all";
		}
		// �˻������� ���� Map
		Map<String, String> map = new HashMap<String,String>();
		if(!search.equals("all")) {
			if(search.equals("name_content")) {
				map.put("name", searchText);
				map.put("content", searchText);
			} else if(search.equals("name")) {
				map.put("name", searchText);
			} else if(search.equals("content")) {
				map.put("content", searchText);
			}
			
		}
		
		// ��� ��������		
		List<VisitVO> list = VisitDAO.getInstance().selectList(map);
		
		request.setAttribute("list", list);
		
		return "visitList.jsp";
	}
	
	//��й�ȣ üũ
	@RequestMapping("/visit/checkPwd.do")
	@ResponseBody
	public String checkPwd(HttpServletRequest request, HttpServletResponse response) {
		// �Ķ���͹ޱ�
		int idx = Integer.parseInt(request.getParameter("idx"));
		String cfmPwd = request.getParameter("cfmPwd");
		
		// idx�� �ش��ϴ� �Խù� ������
		VisitVO vo = VisitDAO.getInstance().selectOne(idx);
		// ���üũ�ϱ�
		boolean bResult = vo.getPwd().equals(cfmPwd);
		
		// json���� �����ϱ�
		JSONObject json = new JSONObject();
		json.put("result", bResult);
		String jsonStr = json.toJSONString();
		
		return jsonStr;
	}
	
	// �Խñ� �Է���
	@RequestMapping("/visit/insertForm.do")
	public String insertForm(HttpServletRequest request, HttpServletResponse response) {
		
		return "visitInsertForm.jsp";
	}
	
	// �Խñ� �Է�
	@RequestMapping("/visit/insert.do")
	public String insert(HttpServletRequest request, HttpServletResponse response) {
		
		// �Ķ��������
		String name = request.getParameter("name");
		String content = request.getParameter("content");
		String pwd = request.getParameter("pwd");
		
		// ���� �߿� \r \n�� ������ <br>�� ����
		content = content.replaceAll("\r\n", "<br>");
		
		// ip���ϱ�
		String ip = request.getRemoteAddr();
		// visitVO����
		VisitVO vo = new VisitVO(name, content, pwd);
		vo.setIp(ip);
		
		// DB insert
		int res = VisitDAO.getInstance().insert(vo);
		
		return "redirect:list.do";
	}
	
	// ������Ʈ��
	@RequestMapping("/visit/updateForm.do")
	public String updateForm(HttpServletRequest request, HttpServletResponse response) {
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		// ��� ��������		
		VisitVO vo = VisitDAO.getInstance().selectOne(idx);
		
		// ���� ������ �ٽ� �����ϱ�
		String content = vo.getContent().replaceAll("<br>", "\r\n");
		vo.setContent(content);
		
		request.setAttribute("vo", vo);
		
		return "visitUpdateForm.jsp";
	}
	
	// ������Ʈ ����
	@RequestMapping("/visit/update.do")
	public String update(HttpServletRequest request, HttpServletResponse response) {
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		String content = request.getParameter("content").replaceAll("\r\n", "<br>");
		String ip = request.getRemoteAddr();
		
		VisitVO vo = new VisitVO(idx, content);
		vo.setIp(ip);
		
		int res = VisitDAO.getInstance().update(vo);
		
		return "redirect:list.do";
	}
	
	// ����
	@RequestMapping("/visit/delete.do")
	public String delete(HttpServletRequest request, HttpServletResponse response) {
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		int res = VisitDAO.getInstance().delete(idx);
		
		return "redirect:list.do";
	}

}
