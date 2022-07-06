package controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import dao.PhotoDAO;
import vo.MemberVO;
import vo.PhotoVO;

@Controller
@RequestMapping("/photo/")
public class PhotoController {

	@Autowired
	ServletContext application;
	@Autowired
	HttpServletRequest request;
	@Autowired
	HttpSession session;

	PhotoDAO photoDAO;

	public void setPhotoDAO(PhotoDAO photoDAO) {
		this.photoDAO = photoDAO;
	}

	// ��ü��� ��������
	@RequestMapping("list.do")
	public String PhotoList(Model model) {
		List<PhotoVO> list = photoDAO.selectList();
		model.addAttribute("list", list);

		return "photo/photoList";
	}

	// ���������
	@RequestMapping("insertForm.do")
	public String PhotoInsertForm() {
		return "photo/photoInsertForm";
	}

	// �������
	@RequestMapping("insert.do")
	public String PhotoInsert(PhotoVO vo, @RequestParam MultipartFile p_photo, Model model) throws Exception {
		// photo/insert.do?p_subject=����&p_content=����&p_photo=a.jpg
		// �α������� �о����
		MemberVO user = (MemberVO) session.getAttribute("user");
		if (user == null) {
			model.addAttribute("reason", "sessionTimeOut");
			return "redirect:../member/memberLoginForm.do";
		}

		int m_idx = user.getM_idx();

		// ���ε� ��ġ
		String webpath = "/resources/upload/"; // �����
		String path = application.getRealPath(webpath); // ������

		// ���ε�� ���ϸ� ������
		String p_filename = "no_file";

		if (!p_photo.isEmpty()) { // ���ε�� ������ �����ϸ�
			p_filename = p_photo.getOriginalFilename();
			File f = new File(path, p_filename); // multipartFile�� �ӽ� ������ �������� File

			if (f.exists()) { // ���� ���� �̸��� �����ϸ� �̸� �ٲٱ�
				long time = System.currentTimeMillis();
				p_filename = String.format("%d_%s", time, p_filename);
			}
			// �ӽ���������� ������ File�� �����ϱ�
			p_photo.transferTo(f);
		}
		vo.setP_filename(p_filename);

		// ip
		String ip = request.getRemoteAddr();
		vo.setP_ip(ip);

		// ����
		String p_content = vo.getP_content().replaceAll("\r\n", "<br>");
		vo.setP_content(p_content);

		// ����ε���
		vo.setM_idx(m_idx);

		int res = photoDAO.insert(vo);

		return "redirect:list.do";
	}

	// ����������
	@RequestMapping("updateForm.do")
	public String PhotoUpdateForm(int p_idx, Model model) {
		PhotoVO vo = photoDAO.selectOne(p_idx);
		model.addAttribute("vo", vo);
		return "/photo/photoUpdateForm";
	}

	// TODO: ��������
	@RequestMapping("update.do")
	public String PhotoUpdate(PhotoVO vo, @RequestParam MultipartFile p_photo, Model model) throws Exception {

		int p_idx = vo.getP_idx();
		MemberVO user = (MemberVO) session.getAttribute("user");
		if (user == null) {
			model.addAttribute("reason", "sessionTimeOut");
			return "redirect:../member/memberLoginForm.do";
		}

		// ������
		String webPath = "/resources/upload/";
		String path = application.getRealPath(webPath);
		// ���ε�� ���ϸ� ������
		String p_filename = "no_file";

		if (!p_photo.isEmpty()) { // ���ε�� ������ �����ϸ�
			p_filename = p_photo.getOriginalFilename();
			File f = new File(path, p_filename); // multipartFile�� �ӽ� ������ �������� File

			if (f.exists()) { // ���� ���� �̸��� �����ϸ� �̸� �ٲٱ�
				long time = System.currentTimeMillis();
				p_filename = String.format("%d_%s", time, p_filename);
			}
			// �ӽ���������� ������ File�� �����ϱ�
			p_photo.transferTo(f);
		}
		
		// �������ϻ���
		File f = new File(path, vo.getP_filename());
		f.delete();
		photoDAO.delete(p_idx);

		String ip = request.getRemoteAddr();
		vo.setP_filename(p_filename);

		vo = new PhotoVO(vo.getP_subject(), vo.getP_content(),p_filename, ip, p_idx);
		photoDAO.update(vo);

		model.addAttribute("vo", vo);
		return "redirect:list.do";
	}

	// ��������
	@RequestMapping("delete.do")
	public String PhotoDelete(int p_idx) {
		PhotoVO vo = photoDAO.selectOne(p_idx);

		// ������
		String webPath = "/resources/upload/";
		String path = application.getRealPath(webPath);

		File f = new File(path, vo.getP_filename());
		f.delete();
		int res = photoDAO.delete(p_idx);

		return "redirect:list.do";
	}

	// �˾���������
	@RequestMapping("photoView.do")
	@ResponseBody
	public PhotoVO PhotoView(int p_idx) {
		PhotoVO vo = photoDAO.selectOne(p_idx);

		return photoDAO.selectOne(p_idx);
	}

}
