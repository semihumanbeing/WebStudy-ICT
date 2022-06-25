package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.ListAction;
import action.ViewAction;

/**
 * Servlet implementation class FrontController
 */
//@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// System.out.println(2);

		String uri = request.getRequestURI();
		System.out.println(uri);

		// uri = "2022_0623_MVCTest/view.do?book=java"
		int index = uri.lastIndexOf('/');// ���ʺ��� �˻�
		// System.out.println(index);
		String cmd = uri.substring(index + 1).replaceAll(".do", "");
		// System.out.println(cmd);
		
		if (cmd.equals("list")) {

			// ListAction��ü�� ���� ����
			ListAction action = new ListAction();
			String forward = action.execute(request, response);
			// ������
			RequestDispatcher disp = request.getRequestDispatcher(forward);
			disp.forward(request, response);

		} else if (cmd.equals("view")) {
			// ListAction��ü�� ���� ����
			ViewAction action = new ViewAction();
			String forward = action.execute(request, response);
			// ������
			RequestDispatcher disp = request.getRequestDispatcher(forward);
			disp.forward(request, response);
		}

	}

}
