package controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import vo.PhotoVO;

@Controller
public class FileUploadController {

	// 자동 인젝션 기법
	// 해당 controller가 자동생성(auto-detecting)시 Autowired 가능하다.
	// 수동 생성시에는 되지 않는다.
	@Autowired
	ServletContext application;

	@Autowired
	HttpServletRequest request;

	@Autowired
	HttpSession session;

	// /upload1.do?title=제목&photo=사진.jpg
	// DispatcherServlet이 파라미터를 받아서 넘겨준다.
	// -> 업로드파일정보를 MultipartFile객체로 넘겨준다.(주의:임시파일이기 때문에 복사해야한다)
	@RequestMapping("/upload1.do")
	public String upload1(String title, @RequestParam("photo") MultipartFile photo, Model model) throws Exception {

		// 웹경로를 절대경로로 바꾸기
		String webPath = "/resources/upload/";
		String absPath = application.getRealPath(webPath);

		// 업로드된 파일명 얻어오기
		String filename = photo.getOriginalFilename();
		File f = new File(absPath, filename);

		// 동일 파일명이 있는지 확인하기
		if (f.exists()) {
			long time = System.currentTimeMillis(); // 현재시간을 1/1000초 단위로 구하기
			filename = String.format("%d%s", time, filename);
			f = new File(absPath, filename);
		}
		// 임시파일 정보를 내가 원하는 위치로 복사한다.
		photo.transferTo(f);

		// model에 데이터를 저장 -> 결과적으로 request에 binding된다.
		model.addAttribute("title", title);
		model.addAttribute("filename", filename);

		return "resultPhoto1";
	}

	// 파라미터 정보를 vo로 포장해서 바로 전달한다.
	@RequestMapping("/upload2.do")
	public String upload2(PhotoVO vo, Model model) throws Exception {

		// 웹경로를 절대경로로 바꾸기
		String webPath = "/resources/upload/";
		String absPath = application.getRealPath(webPath);

		MultipartFile photo = vo.getPhoto();

		// 업로드된 파일명 얻어오기
		String filename = photo.getOriginalFilename();
		File f = new File(absPath, filename);

		// 동일 파일명이 있는지 확인하기
		if (f.exists()) {
			long time = System.currentTimeMillis(); // 현재시간을 1/1000초 단위로 구하기
			filename = String.format("%d%s", time, filename);
			f = new File(absPath, filename);
		}
		// 임시파일 정보를 내가 원하는 위치로 복사한다.
		photo.transferTo(f);

		// model에 데이터를 저장 -> 결과적으로 request에 binding된다.
		vo.setFilename(filename);

		model.addAttribute("vo", vo);

		return "resultPhoto2";
	}

	@RequestMapping("/upload3.do")
	public String upload3(String title, @RequestParam("photo") MultipartFile[] photoArray, Model model) {

		// 웹경로를 절대경로로 바꾸기
		String webPath = "/resources/upload/";
		String absPath = application.getRealPath(webPath);
		
		String filename1 = "no_file";
		String filename2 = "no_file";
		int i = 0;
		for(MultipartFile photo: photoArray) {
			String filename = photo.getOriginalFilename();
			File f = new File(absPath, filename);
			// 동일 파일명이 있는지 확인하기
			if (f.exists()) {
				long time = System.currentTimeMillis(); // 현재시간을 1/1000초 단위로 구하기
				filename = String.format("%d%s", time, filename);
				f = new File(absPath, filename);
			}
			// 임시파일 정보를 내가 원하는 위치로 복사한다.
			try {
				photo.transferTo(f);
				if(i==0) filename1 = filename;
				if(i==1) filename2 = filename;
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			i++;
			
		}
		model.addAttribute("title", title);
		model.addAttribute("filename1",filename1);
		model.addAttribute("filename2",filename2);
		
		return "resultPhoto3";
	}

}
