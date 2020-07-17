package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BoardDAO {
	private String user = "system"; 
	private String password = "12345"; 
	private String url = 
			"jdbc:oracle:thin:@localhost:1521:xe";
	private String driver = 
			"oracle.jdbc.driver.OracleDriver";
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	
	private void getConnection() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean write(BoardDTO dto) {
		getConnection();
		String sql = "insert into board " +
		     "values(board_seq.nextval,?,?,'hhd',sysdate)";
		int row = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getBoard_title());
			psmt.setString(2, dto.getBoard_content());
			row = psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		
		if(row == 0)
			return false;
		else
			return true;
	}
	
	private void close() {
		try {
			if(rs != null) rs.close();
			if(psmt != null) psmt.close();
			if(conn != null) conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}



