package com.util;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;

public class VerifyResult extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String validateC = ((String) request.getSession().getAttribute("rand"))
				.toLowerCase();//session�е���֤��		
		String veryCode = (request.getParameter("c")).toLowerCase();//�û��������֤�룬������ղ�����ʱ��ע�����ĵ���������
		PrintWriter out = response.getWriter();
		if (veryCode != null) {
			if (validateC.equals(veryCode)) {
				out.println("��֤����ȷ");
			} else {
				out.println("��֤�����");
			}
		} else {
			out.println("��֤��Ϊ��");
		}
		out.flush();
		out.close();
	}

}