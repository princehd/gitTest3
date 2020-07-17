package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MemberDAO;
import model.MemberDTO;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		MemberDTO dto = new MemberDTO(id, pw,null);
		MemberDAO dao = new MemberDAO();
		String name = dao.login(dto);
			
		if(name == null) // �α��� ����
			response.sendRedirect("view/loginFail.html");
		else {// �α��� ����
			// ���ǿ� ����� �̸��� ��������.
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", name);
			response.sendRedirect("view/loginSuccess.jsp");
		}
	}
}


