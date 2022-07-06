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

	// �ڵ� ������ ���
	// �ش� controller�� �ڵ�����(auto-detecting)�� Autowired �����ϴ�.
	// ���� �����ÿ��� ���� �ʴ´�.
	@Autowired
	ServletContext application;

	@Autowired
	HttpServletRequest request;

	@Autowired
	HttpSession session;

	// /upload1.do?title=����&photo=����.jpg
	// DispatcherServlet�� �Ķ���͸� �޾Ƽ� �Ѱ��ش�.
	// -> ���ε����������� MultipartFile��ü�� �Ѱ��ش�.(����:�ӽ������̱� ������ �����ؾ��Ѵ�)
	@RequestMapping("/upload1.do")
	public String upload1(String title, @RequestParam("photo") MultipartFile photo, Model model) throws Exception {

		// ����θ� �����η� �ٲٱ�
		String webPath = "/resources/upload/";
		String absPath = application.getRealPath(webPath);

		// ���ε�� ���ϸ� ������
		String filename = photo.getOriginalFilename();
		File f = new File(absPath, filename);

		// ���� ���ϸ��� �ִ��� Ȯ���ϱ�
		if (f.exists()) {
			long time = System.currentTimeMillis(); // ����ð��� 1/1000�� ������ ���ϱ�
			filename = String.format("%d%s", time, filename);
			f = new File(absPath, filename);
		}
		// �ӽ����� ������ ���� ���ϴ� ��ġ�� �����Ѵ�.
		photo.transferTo(f);

		// model�� �����͸� ���� -> ��������� request�� binding�ȴ�.
		model.addAttribute("title", title);
		model.addAttribute("filename", filename);

		return "resultPhoto1";
	}

	// �Ķ���� ������ vo�� �����ؼ� �ٷ� �����Ѵ�.
	@RequestMapping("/upload2.do")
	public String upload2(PhotoVO vo, Model model) throws Exception {

		// ����θ� �����η� �ٲٱ�
		String webPath = "/resources/upload/";
		String absPath = application.getRealPath(webPath);

		MultipartFile photo = vo.getPhoto();

		// ���ε�� ���ϸ� ������
		String filename = photo.getOriginalFilename();
		File f = new File(absPath, filename);

		// ���� ���ϸ��� �ִ��� Ȯ���ϱ�
		if (f.exists()) {
			long time = System.currentTimeMillis(); // ����ð��� 1/1000�� ������ ���ϱ�
			filename = String.format("%d%s", time, filename);
			f = new File(absPath, filename);
		}
		// �ӽ����� ������ ���� ���ϴ� ��ġ�� �����Ѵ�.
		photo.transferTo(f);

		// model�� �����͸� ���� -> ��������� request�� binding�ȴ�.
		vo.setFilename(filename);

		model.addAttribute("vo", vo);

		return "resultPhoto2";
	}

	@RequestMapping("/upload3.do")
	public String upload3(String title, @RequestParam("photo") MultipartFile[] photoArray, Model model) {

		// ����θ� �����η� �ٲٱ�
		String webPath = "/resources/upload/";
		String absPath = application.getRealPath(webPath);
		
		String filename1 = "no_file";
		String filename2 = "no_file";
		int i = 0;
		for(MultipartFile photo: photoArray) {
			String filename = photo.getOriginalFilename();
			File f = new File(absPath, filename);
			// ���� ���ϸ��� �ִ��� Ȯ���ϱ�
			if (f.exists()) {
				long time = System.currentTimeMillis(); // ����ð��� 1/1000�� ������ ���ϱ�
				filename = String.format("%d%s", time, filename);
				f = new File(absPath, filename);
			}
			// �ӽ����� ������ ���� ���ϴ� ��ġ�� �����Ѵ�.
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
