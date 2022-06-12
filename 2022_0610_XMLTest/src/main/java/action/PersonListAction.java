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
			// parser ����
			SAXBuilder builder = new SAXBuilder();
			// path ���ϱ�
			String path = request.getServletContext().getRealPath("/");
			File f = new File(path, "person.xml");
			// ��ü ������������
			Document doc = builder.build(f);
			
			// root element ������ ���Ѵ�
			Element root = doc.getRootElement();
			
			// root element �� ���� ��� ���ϱ� - ArrayList �� ���ϵȴ�.
			List<Element> personList = root.getChildren("person");
			
			for(Element person : personList) {
				// element �� ���ϱ�
				String name = person.getChildText("name");
				// attribute �� ���ϱ�
				String nickname = person.getChild("name").getAttributeValue("nickname");
				
				int age = 0;
				try {
					age = Integer.parseInt(person.getChildText("age"));
				} catch (Exception e) {
					// age ���� ���� ���� ����Ͽ� try catch �� ����Ѵ�. 
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
