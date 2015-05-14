package com.sds.icto.mysite.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sds.icto.mysite.vo.BoardVO;

public class BoardDAO {

	private Connection getConnection() throws ClassNotFoundException,
			SQLException {

		Connection con = null;

		Class.forName("oracle.jdbc.driver.OracleDriver");
		String dbURL = "jdbc:oracle:thin:@localhost:1521:xe";
		con = DriverManager.getConnection(dbURL, "webdb", "webdb");

		return con;
	}

	public void insert(BoardVO vo, String member_name)
			throws ClassNotFoundException, SQLException {
		Connection con = getConnection();

		String sql = "insert into board values(board_seq.nextval, ?, ?, ?, ?, ?, sysdate )";

		PreparedStatement pstmt = con.prepareStatement(sql);

		pstmt.setString(1, vo.getTitle());
		pstmt.setString(2, vo.getContent());
		pstmt.setString(3, vo.getMember_no());
		pstmt.setString(4, member_name);
		pstmt.setString(5, vo.getView_cnt());

		pstmt.executeUpdate();

		if (pstmt != null) {
			pstmt.close();
		}

		if (con != null) {
			con.close();
		}

	}

	public void edit(BoardVO vo, String member_name)
			throws ClassNotFoundException, SQLException {
		Connection con = getConnection();

		String sql = "update board SET title = ?, content = ? where no = ?";

		PreparedStatement pstmt = con.prepareStatement(sql);

		pstmt.setString(1, vo.getTitle());
		pstmt.setString(2, vo.getContent());
		pstmt.setLong(3, vo.getNo());

		pstmt.executeUpdate();

		if (pstmt != null) {
			pstmt.close();
		}

		if (con != null) {
			con.close();
		}

	}

	public void delete(Long no, String password) throws ClassNotFoundException,
			SQLException {

		Connection con = getConnection();
		Statement stmt = con.createStatement();
		String sql = "delete from Board where no = ? and password = ?";

		PreparedStatement pstmt = con.prepareStatement(sql);

		pstmt.setLong(1, no);
		pstmt.setString(2, password);

		pstmt.executeUpdate();

	}

	public void delete() throws ClassNotFoundException, SQLException {

		Connection con = getConnection();

		Statement stmt = con.createStatement();
		String sql = "delete from Board";
		stmt.executeUpdate(sql);

		// 자원정리
		if (stmt != null) {
			stmt.close();
		}

		if (con != null) {
			con.close();
		}

	}

	public BoardVO fetchDetail(Long no) throws ClassNotFoundException,
			SQLException {

		List<BoardVO> list = new ArrayList<BoardVO>();

		// 1 connection 생성
		Connection con = getConnection();

		// 2 statement 생성

		String sql = "select * from board where no = ?";

		PreparedStatement pstmt = con.prepareStatement(sql);

		pstmt.setLong(1, no);

		// rs 생성
		ResultSet rs = pstmt.executeQuery(sql);

		BoardVO vo = new BoardVO();
		// 결과처리
		if (rs.next()) {

			Long no2 = rs.getLong(1);
			String title = rs.getString(2);
			String content = rs.getString(3);
			String member_no = rs.getString(4);
			String member_name = rs.getString(5);
			String view_cnt = rs.getString(5);
			String reg_date = rs.getString(5);

			vo.setNo(no2);
			vo.setTitle(title);
			vo.setContent(content);
			vo.setMember_no(member_no);
			vo.setMember_name(member_name);
			vo.setView_cnt(view_cnt);
			vo.setReg_date(reg_date);

		}

		// 자원정리
		if (rs != null) {
			rs.close();
		}

		if (pstmt != null) {
			pstmt.close();
		}

		if (con != null) {
			con.close();
		}

		return vo;
	}

	public List<BoardVO> fetchList() throws ClassNotFoundException,
			SQLException {

		List<BoardVO> list = new ArrayList<BoardVO>();

		// 1 connection 생성
		Connection con = getConnection();

		// 2 statement 생성
		Statement stmt = con.createStatement();
		String sql = "select * from Board";

		// rs 생성
		ResultSet rs = stmt.executeQuery(sql);

		// 결과처리
		while (rs.next()) {

			Long no = rs.getLong(1);
			String title = rs.getString(2);
			String content = rs.getString(3);
			String member_no = rs.getString(4);
			String member_name = rs.getString(5);
			String view_cnt = rs.getString(5);
			String reg_date = rs.getString(5);

			BoardVO vo = new BoardVO();
			vo.setNo(no);
			vo.setTitle(title);
			vo.setContent(content);
			vo.setMember_no(member_no);
			vo.setMember_name(member_name);
			vo.setView_cnt(view_cnt);
			vo.setReg_date(reg_date);
			list.add(vo);

		}

		// 자원정리
		if (rs != null) {
			rs.close();
		}

		if (stmt != null) {
			stmt.close();
		}

		if (con != null) {
			con.close();
		}

		return list;
	}

}
