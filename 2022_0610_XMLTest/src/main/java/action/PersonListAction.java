package action;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import vo.PersonVO;

/**
 * Servlet implementation class PersonListAction
 */
@WebServlet("/person/list.do")
public class PersonListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<PersonVO> list = new ArrayList<PersonVO>();
		
		// XML Parsing
		try {
			// parser 생성
			SAXBuilder builder = new SAXBuilder();
			// path 구하기
			String path = request.getServletContext().getRealPath("/");
			File f = new File(path, "person.xml");
			// 전체 문서정보구함
			Document doc = builder.build(f);
			
			// root element 정보를 구한다
			Element root = doc.getRootElement();
			
			// root element 의 하위 요소 구하기 - ArrayList 로 리턴된다.
			List<Element> personList = root.getChildren("person");
			
			for(Element person : personList) {
				// element 값 구하기
				String name = person.getChildText("name");
				// attribute 값 구하기
				String nickname = person.getChild("name").getAttributeValue("nickname");
				
				int age = 0;
				try {
					age = Integer.parseInt(person.getChildText("age"));
				} catch (Exception e) {
					// age 값이 없을 때를 대비하여 try catch 를 사용한다. 
				}
				
				String tel = person.getChildText("tel");
				String hometel = person.getChild("tel").getAttributeValue("hometel");
				
				PersonVO vo = new PersonVO(name, nickname, age, tel, hometel);
				list.add(vo);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		request.setAttribute("list", list);
		
		//forward
		String forward_page = "personList.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);

	}

}
