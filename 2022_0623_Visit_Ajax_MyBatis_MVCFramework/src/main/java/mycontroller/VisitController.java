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
		// 검색조건을 담을 Map
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
		
		// 목록 가져오기		
		List<VisitVO> list = VisitDAO.getInstance().selectList(map);
		
		request.setAttribute("list", list);
		
		return "visitList.jsp";
	}
	
	//비밀번호 체크
	@RequestMapping("/visit/checkPwd.do")
	@ResponseBody
	public String checkPwd(HttpServletRequest request, HttpServletResponse response) {
		// 파라미터받기
		int idx = Integer.parseInt(request.getParameter("idx"));
		String cfmPwd = request.getParameter("cfmPwd");
		
		// idx에 해당하는 게시물 얻어오기
		VisitVO vo = VisitDAO.getInstance().selectOne(idx);
		// 비번체크하기
		boolean bResult = vo.getPwd().equals(cfmPwd);
		
		// json으로 포장하기
		JSONObject json = new JSONObject();
		json.put("result", bResult);
		String jsonStr = json.toJSONString();
		
		return jsonStr;
	}
	
	// 게시글 입력폼
	@RequestMapping("/visit/insertForm.do")
	public String insertForm(HttpServletRequest request, HttpServletResponse response) {
		
		return "visitInsertForm.jsp";
	}
	
	// 게시글 입력
	@RequestMapping("/visit/insert.do")
	public String insert(HttpServletRequest request, HttpServletResponse response) {
		
		// 파라미터지정
		String name = request.getParameter("name");
		String content = request.getParameter("content");
		String pwd = request.getParameter("pwd");
		
		// 내용 중에 \r \n이 있으면 <br>로 변경
		content = content.replaceAll("\r\n", "<br>");
		
		// ip구하기
		String ip = request.getRemoteAddr();
		// visitVO포장
		VisitVO vo = new VisitVO(name, content, pwd);
		vo.setIp(ip);
		
		// DB insert
		int res = VisitDAO.getInstance().insert(vo);
		
		return "redirect:list.do";
	}
	
	// 업데이트폼
	@RequestMapping("/visit/updateForm.do")
	public String updateForm(HttpServletRequest request, HttpServletResponse response) {
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		// 목록 가져오기		
		VisitVO vo = VisitDAO.getInstance().selectOne(idx);
		
		// 변경 내용을 다시 세팅하기
		String content = vo.getContent().replaceAll("<br>", "\r\n");
		vo.setContent(content);
		
		request.setAttribute("vo", vo);
		
		return "visitUpdateForm.jsp";
	}
	
	// 업데이트 실행
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
	
	// 삭제
	@RequestMapping("/visit/delete.do")
	public String delete(HttpServletRequest request, HttpServletResponse response) {
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		int res = VisitDAO.getInstance().delete(idx);
		
		return "redirect:list.do";
	}

}
