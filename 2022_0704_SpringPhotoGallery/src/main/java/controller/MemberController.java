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
	
	// �����Ϻ���
	@RequestMapping("list.do")
	public String MemberList(Model model) {
		List<MemberVO> list = memberDAO.selectList();
		model.addAttribute("list",list);
		return "member/memberList";
	}
	
	//�α�����
	@RequestMapping("memberLoginForm.do")
	public String MemberLoginForm() {
		return "member/memberLoginForm";
	}
	
	//�α���
	@RequestMapping("login.do")
	public String MemberLogin(String m_id, String m_pwd, Model model) {
		
		MemberVO user = memberDAO.selectOne(m_id);
		//���̵�üũ
		if(user == null) {
			// model�� ���ؼ� DS�� ���޵� �����ʹ� redirect�� �Ķ���ͷ� ó���ȴ�.
			model.addAttribute("reason","failedID");
			return "redirect:memberLoginForm.do";
		}
		//���üũ
		if(user.getM_pwd().equals(m_pwd)==false) {
			model.addAttribute("reason","failedPWD");
			model.addAttribute("m_id",m_id);
			return "redirect:memberLoginForm.do";
		}
		session.setAttribute("user", user);
		
		return "redirect:../photo/list.do";
	}
	
	//�α׾ƿ�
	@RequestMapping("logout.do")
	public String MemberLogout() {
		session.removeAttribute("user");
		return "redirect:../photo/list.do";
	}
	
	//���̵�üũ
	@RequestMapping(value="checkID.do", produces="text/json; charset=utf-8")
	@ResponseBody
	public String MemberCheckID(String m_id) {
		MemberVO vo = memberDAO.selectOne(m_id);
		// id �������
		boolean bResult = false;
		if(vo==null) bResult = true;
		
		// ������۵����� json����
		JSONObject json = new JSONObject();
		json.put("result", bResult);
		String jsonStr = json.toJSONString();

		return jsonStr;
	}
	
	//ȸ��������
	@RequestMapping("insertForm.do")
	public String MemberInsertForm() {
		return "member/memberInsertForm";
	}
	
	//ȸ������
	@RequestMapping("insert.do")
	public String MemberInsert(MemberVO vo) {
		
		String m_ip = request.getRemoteAddr();
		vo.setM_ip(m_ip);
		vo.setM_grade("�Ϲ�");
		
		int res = memberDAO.insert(vo);
		
		return "redirect:memberLoginForm.do";
	}
	
	//ȸ��Ż��
	@RequestMapping("delete.do")
	public String MemberDelete(int m_idx) {
		int res = memberDAO.delete(m_idx);
		return "redirect:list.do";
	}
	
	//ȸ������������
	@RequestMapping("updateForm.do")
	public String MemberUpdateForm(int m_idx, Model model) {
		MemberVO vo = memberDAO.selectOne(m_idx);
		model.addAttribute("vo",vo);
		return "member/memberUpdateForm";
	}
	
	//ȸ����������
	@RequestMapping("update.do")
	public String MemberUpdate(MemberVO vo, int m_idx) {
		String ip = request.getRemoteAddr();
		vo.setM_ip(ip);
		
		int res = memberDAO.update(vo);
		return "redirect:list.do";
	}
	
	
}
