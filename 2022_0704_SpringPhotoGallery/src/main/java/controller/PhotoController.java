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

	// 전체목록 가져오기
	@RequestMapping("list.do")
	public String PhotoList(Model model) {
		List<PhotoVO> list = photoDAO.selectList();
		model.addAttribute("list", list);

		return "photo/photoList";
	}

	// 사진등록폼
	@RequestMapping("insertForm.do")
	public String PhotoInsertForm() {
		return "photo/photoInsertForm";
	}

	// 사진등록
	@RequestMapping("insert.do")
	public String PhotoInsert(PhotoVO vo, @RequestParam MultipartFile p_photo, Model model) throws Exception {
		// photo/insert.do?p_subject=제목&p_content=내용&p_photo=a.jpg
		// 로그인정보 읽어오기
		MemberVO user = (MemberVO) session.getAttribute("user");
		if (user == null) {
			model.addAttribute("reason", "sessionTimeOut");
			return "redirect:../member/memberLoginForm.do";
		}

		int m_idx = user.getM_idx();

		// 업로드 위치
		String webpath = "/resources/upload/"; // 웹경로
		String path = application.getRealPath(webpath); // 절대경로

		// 업로드된 파일명 얻어오기
		String p_filename = "no_file";

		if (!p_photo.isEmpty()) { // 업로드된 파일이 존재하면
			p_filename = p_photo.getOriginalFilename();
			File f = new File(path, p_filename); // multipartFile이 임시 파일을 가져오면 File

			if (f.exists()) { // 동일 파일 이름이 존재하면 이름 바꾸기
				long time = System.currentTimeMillis();
				p_filename = String.format("%d_%s", time, p_filename);
			}
			// 임시저장공간의 파일을 File로 복사하기
			p_photo.transferTo(f);
		}
		vo.setP_filename(p_filename);

		// ip
		String ip = request.getRemoteAddr();
		vo.setP_ip(ip);

		// 내용
		String p_content = vo.getP_content().replaceAll("\r\n", "<br>");
		vo.setP_content(p_content);

		// 멤버인덱스
		vo.setM_idx(m_idx);

		int res = photoDAO.insert(vo);

		return "redirect:list.do";
	}

	// 사진수정폼
	@RequestMapping("updateForm.do")
	public String PhotoUpdateForm(int p_idx, Model model) {
		PhotoVO vo = photoDAO.selectOne(p_idx);
		model.addAttribute("vo", vo);
		return "/photo/photoUpdateForm";
	}

	// TODO: 사진수정
	@RequestMapping("update.do")
	public String PhotoUpdate(PhotoVO vo, @RequestParam MultipartFile p_photo, Model model) throws Exception {

		int p_idx = vo.getP_idx();
		MemberVO user = (MemberVO) session.getAttribute("user");
		if (user == null) {
			model.addAttribute("reason", "sessionTimeOut");
			return "redirect:../member/memberLoginForm.do";
		}

		// 절대경로
		String webPath = "/resources/upload/";
		String path = application.getRealPath(webPath);
		// 업로드된 파일명 얻어오기
		String p_filename = "no_file";

		if (!p_photo.isEmpty()) { // 업로드된 파일이 존재하면
			p_filename = p_photo.getOriginalFilename();
			File f = new File(path, p_filename); // multipartFile이 임시 파일을 가져오면 File

			if (f.exists()) { // 동일 파일 이름이 존재하면 이름 바꾸기
				long time = System.currentTimeMillis();
				p_filename = String.format("%d_%s", time, p_filename);
			}
			// 임시저장공간의 파일을 File로 복사하기
			p_photo.transferTo(f);
		}
		
		// 기존파일삭제
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

	// 사진삭제
	@RequestMapping("delete.do")
	public String PhotoDelete(int p_idx) {
		PhotoVO vo = photoDAO.selectOne(p_idx);

		// 절대경로
		String webPath = "/resources/upload/";
		String path = application.getRealPath(webPath);

		File f = new File(path, vo.getP_filename());
		f.delete();
		int res = photoDAO.delete(p_idx);

		return "redirect:list.do";
	}

	// 팝업사진보기
	@RequestMapping("photoView.do")
	@ResponseBody
	public PhotoVO PhotoView(int p_idx) {
		PhotoVO vo = photoDAO.selectOne(p_idx);

		return photoDAO.selectOne(p_idx);
	}

}
