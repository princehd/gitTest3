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

    // 사용자 요청이 들어오면 동작하는 메소드
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		
		System.out.println(id);
		
		// 사용자 입력한 값을 객체로 생성
		MemberDTO dto = new MemberDTO(id, pw, name);
		// dto를 DAO객체에게 넘긴다.
		MemberDAO dao = new MemberDAO();
		boolean isJoinSuccess = dao.join(dto);
		
		if(isJoinSuccess) // 성공했을경우
			response.sendRedirect("view/joinSuccess.html");
		else // 실패했을경우
			response.sendRedirect("view/joinFail.html");
	}

}



