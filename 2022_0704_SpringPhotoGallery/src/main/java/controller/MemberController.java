package controller;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.MemberDAO;
import vo.MemberVO;

@Controller
@RequestMapping("/member/")
public class MemberController {
	
	MemberDAO memberDAO;
	
	@Autowired
	ServletContext application;
	@Autowired
	HttpServletRequest request; 
	@Autowired
	HttpSession session;

	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	
	// 멤버목록보기
	@RequestMapping("list.do")
	public String MemberList(Model model) {
		List<MemberVO> list = memberDAO.selectList();
		model.addAttribute("list",list);
		return "member/memberList";
	}
	
	//로그인폼
	@RequestMapping("memberLoginForm.do")
	public String MemberLoginForm() {
		return "member/memberLoginForm";
	}
	
	//로그인
	@RequestMapping("login.do")
	public String MemberLogin(String m_id, String m_pwd, Model model) {
		
		MemberVO user = memberDAO.selectOne(m_id);
		//아이디체크
		if(user == null) {
			// model을 통해서 DS로 전달된 데이터는 redirect시 파라미터로 처리된다.
			model.addAttribute("reason","failedID");
			return "redirect:memberLoginForm.do";
		}
		//비번체크
		if(user.getM_pwd().equals(m_pwd)==false) {
			model.addAttribute("reason","failedPWD");
			model.addAttribute("m_id",m_id);
			return "redirect:memberLoginForm.do";
		}
		session.setAttribute("user", user);
		
		return "redirect:../photo/list.do";
	}
	
	//로그아웃
	@RequestMapping("logout.do")
	public String MemberLogout() {
		session.removeAttribute("user");
		return "redirect:../photo/list.do";
	}
	
	//아이디체크
	@RequestMapping(value="checkID.do", produces="text/json; charset=utf-8")
	@ResponseBody
	public String MemberCheckID(String m_id) {
		MemberVO vo = memberDAO.selectOne(m_id);
		// id 사용유무
		boolean bResult = false;
		if(vo==null) bResult = true;
		
		// 결과전송데이터 json으로
		JSONObject json = new JSONObject();
		json.put("result", bResult);
		String jsonStr = json.toJSONString();

		return jsonStr;
	}
	
	//회원가입폼
	@RequestMapping("insertForm.do")
	public String MemberInsertForm() {
		return "member/memberInsertForm";
	}
	
	//회원가입
	@RequestMapping("insert.do")
	public String MemberInsert(MemberVO vo) {
		
		String m_ip = request.getRemoteAddr();
		vo.setM_ip(m_ip);
		vo.setM_grade("일반");
		
		int res = memberDAO.insert(vo);
		
		return "redirect:memberLoginForm.do";
	}
	
	//회원탈퇴
	@RequestMapping("delete.do")
	public String MemberDelete(int m_idx) {
		int res = memberDAO.delete(m_idx);
		return "redirect:list.do";
	}
	
	//회원정보수정폼
	@RequestMapping("updateForm.do")
	public String MemberUpdateForm(int m_idx, Model model) {
		MemberVO vo = memberDAO.selectOne(m_idx);
		model.addAttribute("vo",vo);
		return "member/memberUpdateForm";
	}
	
	//회원정보수정
	@RequestMapping("update.do")
	public String MemberUpdate(MemberVO vo, int m_idx) {
		String ip = request.getRemoteAddr();
		vo.setM_ip(ip);
		
		int res = memberDAO.update(vo);
		return "redirect:list.do";
	}
	
	
}
