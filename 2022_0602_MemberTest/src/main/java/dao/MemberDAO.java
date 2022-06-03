package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import service.DBService;
import vo.MemberVO;

public class MemberDAO {
	// single-ton : 객체 1개만 생성해서 사용하자!
	// 스태틱객체는 무조건 하나만 만들어진다.
	static MemberDAO single = null;

	// 스태틱은 무조건 스태틱으로만
	public static MemberDAO getInstance() {

		// 객체가 없으면 생성해라 호출된 한번만 객체를 생성
		if (single == null)
			single = new MemberDAO();

		return single;
	}

	// 외부에서 객체를 생성하지 못하게 막음
	private MemberDAO() {
		// TODO Auto-generated constructor stub
	}

	// selectOne(idx)
	public MemberVO selectOne(int m_idx) {
		MemberVO vo = null;
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from member2 where m_idx =?";

		try {
			// 1. connection 얻어오기
			connection = DBService.getInstance().getConnection(); // connection 은 연결하고나면 꼭 닫아준다.
			// 2. prepared statement 얻어오기
			pstmt = connection.prepareStatement(sql);
			// 3. pstmt 세팅
			pstmt.setInt(1, m_idx);
			// 4. result set 구하기
			rs = pstmt.executeQuery();
			// 5. 포장하기
			if (rs.next()) {
				// vo로 포장
				vo = new MemberVO();
				vo.setM_idx(rs.getInt("m_idx"));
				vo.setM_name(rs.getString("m_name"));
				vo.setM_id(rs.getString("m_id"));
				vo.setM_pwd(rs.getString("m_pwd"));
				vo.setM_zipcode(rs.getString("m_zipcode"));
				vo.setM_address(rs.getString("m_address"));
				vo.setM_grade(rs.getString("m_grade"));
				vo.setM_ip(rs.getString("m_ip"));
				vo.setM_regdate(rs.getString("m_regdate"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// 연결되어있으면 close 해준다.(열린 역순으로)
				if (rs != null)
					rs.close(); // 3.
				if (pstmt != null)
					pstmt.close(); // 2.
				if (connection != null)
					connection.close(); // 1.
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return vo;
	}

	// selectOne(id)
	public MemberVO selectOne(String m_id) {
		MemberVO vo = null;
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from member2 where m_id =?";

		try {
			// 1. connection 얻어오기
			connection = DBService.getInstance().getConnection(); // connection 은 연결하고나면 꼭 닫아준다.
			// 2. prepared statement 얻어오기
			pstmt = connection.prepareStatement(sql);
			// 3. pstmt 세팅
			pstmt.setString(1, m_id);
			// 4. result set 구하기
			rs = pstmt.executeQuery();
			// 5. 포장하기
			if (rs.next()) {
				// vo로 포장
				vo = new MemberVO();
				vo.setM_idx(rs.getInt("m_idx"));
				vo.setM_name(rs.getString("m_name"));
				vo.setM_id(rs.getString("m_id"));
				vo.setM_pwd(rs.getString("m_pwd"));
				vo.setM_zipcode(rs.getString("m_zipcode"));
				vo.setM_address(rs.getString("m_address"));
				vo.setM_grade(rs.getString("m_grade"));
				vo.setM_ip(rs.getString("m_ip"));
				vo.setM_regdate(rs.getString("m_regdate"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// 연결되어있으면 close 해준다.(열린 역순으로)
				if (rs != null)
					rs.close(); // 3.
				if (pstmt != null)
					pstmt.close(); // 2.
				if (connection != null)
					connection.close(); // 1.
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return vo;
	}
	
	public int insert(MemberVO vo) { // 호출한 사용자가 전달한 값
		// TODO Auto-generated method stub
		
		int res = 0;
		
		Connection		   conn  = null;
		PreparedStatement  pstmt = null;
		
		
		String sql = "insert into member2 values(seq_member_m_idx.nextVal, ?,?,?,?,?,?,?,sysdate)";
		
		
		try {
			//1.Connection 얻어오기
			conn = DBService.getInstance().getConnection();
			
			//2.PreparedStatement 얻어오기
			pstmt = conn.prepareStatement(sql); // 캐싱
			
			//3.pstmt의 변수처리된 parameter 설정과정
			
			pstmt.setString(1, vo.getM_name());
			pstmt.setString(2, vo.getM_id());
			pstmt.setString(3, vo.getM_pwd());
			pstmt.setString(4, vo.getM_zipcode());
			pstmt.setString(5, vo.getM_address());
			pstmt.setString(6, vo.getM_grade());
			pstmt.setString(7, vo.getM_ip());
			
			//4.DML(insert/update/delete)명령 실행, res는 처리된 행수를반환
			res = pstmt.executeUpdate();
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}finally {
			
			try {
				//닫기 (열린 역순)
				if(pstmt != null) pstmt.close(); // 2
				if(conn != null) conn.close();   // 1
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		
		//리턴을 0으로 받으면 명령 실패!
		return res;
	}
	
	// 전체조회
	public List<MemberVO> selectList() {

		List<MemberVO> list = new ArrayList<MemberVO>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from member2";

		try {
			// 1.Connection얻어오기
			conn = DBService.getInstance().getConnection();

			// 2.PreparedStatment얻어오기
			pstmt = conn.prepareStatement(sql);

			// 3.ResultSet얻어오기
			rs = pstmt.executeQuery();

			// 4.포장(record->Vo->list)
			while (rs.next()) {
				// rs가 가리키는 행(레코드)의 값을 읽어온다

				// Vo로 포장
				MemberVO vo = new MemberVO();

				vo.setM_idx(rs.getInt("m_idx"));
				vo.setM_name(rs.getString("m_name"));
				vo.setM_id(rs.getString("m_id"));
				vo.setM_pwd(rs.getString("m_pwd"));
				vo.setM_zipcode(rs.getString("m_zipcode"));
				vo.setM_address(rs.getString("m_address"));
				vo.setM_grade(rs.getString("m_grade"));
				vo.setM_ip(rs.getString("m_ip"));
				vo.setM_regdate(rs.getString("m_regdate"));

				// list추가
				list.add(vo);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			try {
				// 연결(생성)되었으면 닫아라(생성역순으로)
				if (rs != null)
					rs.close(); // 3
				if (pstmt != null)
					pstmt.close();// 2
				if (conn != null)
					conn.close(); // 1
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return list;
	}

	public int delete(int idx) { // 호출한 사용자가 전달한 값
		// TODO Auto-generated method stub
		
		int res = 0;
		
		Connection		   conn  = null;
		PreparedStatement  pstmt = null;
		
		
		String sql = "delete from member2 where m_idx=?";
		
		
		try {
			//1.Connection 얻어오기
			conn = DBService.getInstance().getConnection();
			
			//2.PreparedStatement 얻어오기
			pstmt = conn.prepareStatement(sql); // 캐싱
			
			//3.pstmt의 변수처리된 parameter 설정과정
			pstmt.setInt(1, idx);
			
			//4.DML(insert/update/delete)명령 실행, res는 처리된 행수를반환
			res = pstmt.executeUpdate();
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}finally {
			
			try {
				//닫기 (열린 역순)
				if(pstmt != null) pstmt.close(); // 2
				if(conn != null) conn.close();   // 1
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		
		//리턴을 0으로 받으면 명령 실패!
		return res;
	}

	public int update(MemberVO vo) { // 호출한 사용자가 전달한 값
		
		int res = 0;
		
		Connection		   conn  = null;
		PreparedStatement  pstmt = null;
		
		
		String sql = "update member2 set m_name=?, m_pwd=?, m_zipcode=?, m_address=?, m_grade=?, m_ip =? where m_idx= ?";
		
		
		try {
			//1.Connection 얻어오기
			conn = DBService.getInstance().getConnection();
			
			//2.PreparedStatement 얻어오기
			pstmt = conn.prepareStatement(sql); // 캐싱
			
			//3.pstmt의 변수처리된 parameter 설정과정
			pstmt.setString(1, vo.getM_name());
			pstmt.setString(2, vo.getM_pwd());
			pstmt.setString(3, vo.getM_zipcode());
			pstmt.setString(4, vo.getM_address());
			pstmt.setString(5, vo.getM_grade());
			pstmt.setString(6, vo.getM_ip());
			pstmt.setInt(7, vo.getM_idx());
			
			//4.DML(insert/update/delete)명령 실행, res는 처리된 행수를반환
			res = pstmt.executeUpdate();
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}finally {
			
			try {
				//닫기 (열린 역순)
				if(pstmt != null) pstmt.close(); // 2
				if(conn != null) conn.close();   // 1
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		
		//리턴을 0으로 받으면 명령 실패!
		return res;
	}

}
