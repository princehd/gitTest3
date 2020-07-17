package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardDTO;
import model.MemberDAO;
import model.MemberDTO;

@WebServlet("/join")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public JoinServlet() {
        // TODO Auto-generated constructor stub
    }

    // ����� ��û�� ������ �����ϴ� �޼ҵ�
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		
		System.out.println(id);
		
		// ����� �Է��� ���� ��ü�� ����
		MemberDTO dto = new MemberDTO(id, pw, name);
		// dto�� DAO��ü���� �ѱ��.
		MemberDAO dao = new MemberDAO();
		boolean isJoinSuccess = dao.join(dto);
		
		if(isJoinSuccess) // �����������
			response.sendRedirect("view/joinSuccess.html");
		else // �����������
			response.sendRedirect("view/joinFail.html");
	}

}



