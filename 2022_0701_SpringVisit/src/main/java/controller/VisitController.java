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
	// /visit/list.do?search=all&searchText=길동

	@RequestMapping("/visit/list.do")
	public String list(@RequestParam(value = "search", required = false, defaultValue = "all") String search,
			@RequestParam(value = "searchText", required = false) String searchText, Model model) {

		// 검색조건을 담을 Map
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

		// 목록 가져오기
		List<VisitVO> list = visitDAO.selectList(map);

		// DispatcherServlet이 전달해준 저장소 정보(model)을 이용해서 데이터 삽입(Map의 형태로)
		model.addAttribute("list", list);

		return "visit/visitList";
	}

	// 게시글 입력폼
	@RequestMapping("/visit/insertForm.do")
	public String insertForm(HttpServletRequest request, HttpServletResponse response) {

		return "visit/visitInsertForm";
	}

	// 게시글 입력
	// VisitVO 객체로 받기(조건: parameter와 vo의 속성명이 같아야한다)
	@RequestMapping("/visit/insert.do")
	public String insert(VisitVO vo, HttpServletRequest request, HttpServletResponse response) {

		// ip구하기
		String ip = request.getRemoteAddr();
		// vo에 ip추가
		vo.setIp(ip);

		// DB insert
		int res = visitDAO.insert(vo);

		return "redirect:list.do";
	}

	// 업데이트폼
	@RequestMapping("/visit/updateForm.do")
	public String updateForm(int idx, Model model) {

		// 목록 가져오기
		VisitVO vo = visitDAO.selectOne(idx);
		
		/*// 변경 내용을 다시 세팅하기 
		String content = vo.getContent().replaceAll("<br>","\r\n").replaceAll("<p>","\n").replaceAll("</p>",""); 
		vo.setContent(content);*/

		model.addAttribute("vo", vo);

		return "visit/visitUpdateForm";
	}

	// 업데이트 실행
	@RequestMapping("/visit/update.do")
	public String update(VisitVO vo, HttpServletRequest request) {

		String ip = request.getRemoteAddr();
		vo.setIp(ip);

		int res = visitDAO.update(vo);

		return "redirect:list.do";
	}

	// 삭제
	@RequestMapping("/visit/delete.do")
	public String delete(int idx) {

		int res = visitDAO.delete(idx);

		return "redirect:list.do";
	}

	// 비밀번호 체크
	@RequestMapping("/visit/checkPwd.do")
	@ResponseBody
	public String checkPwd(int idx, String cfmPwd) {
		// idx에 해당하는 게시물 얻어오기
		VisitVO vo = visitDAO.selectOne(idx);
		// 비번체크하기
		boolean bResult = vo.getPwd().equals(cfmPwd);

		// json으로 포장하기
		JSONObject json = new JSONObject();
		json.put("result", bResult);
		String jsonStr = json.toJSONString();

		return jsonStr;
	}

}
