package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.DBService;
import service.MyBatisConnector;
import vo.VisitVO;

public class VisitDAO {
	
	SqlSessionFactory factory;
	//single-ton : 객체 1개만 생성해서 사용하자!
	//스태틱객체는 무조건 하나만 만들어진다.
	static VisitDAO single = null;

	//스태틱은 무조건 스태틱으로만
	public static VisitDAO getInstance() {

		//객체가 없으면 생성해라 호출된 한번만 객체를 생성
		if (single == null)
			single = new VisitDAO();

		return single;
	}

	//외부에서 객체를 생성하지 못하게 막음
	private VisitDAO() {
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
		
	}
	
	public List<VisitVO> selectList() {

		List<VisitVO> list = null;
		// sqlsession 얻어오기
		SqlSession sqlSession = factory.openSession();
		// 실행
		list = sqlSession.selectList("visit.visitList");
		// 닫기
		sqlSession.close();

		return list;
	}
	public List<VisitVO> selectList(Map map) {

		List<VisitVO> list = null;
		// sqlsession 얻어오기
		SqlSession sqlSession = factory.openSession();
		// 실행
		list = sqlSession.selectList("visit.visitList_condition",map);
		// 닫기
		sqlSession.close();

		return list;
	}
	
	
	public VisitVO selectOne(int idx) {
		VisitVO vo = null;
		// sqlsession 얻어오기
		SqlSession sqlSession = factory.openSession();
		// 실행
		vo = sqlSession.selectOne("visit.visitOne",idx);
		// 닫기
		sqlSession.close();
		
		
		return vo;
	}
	

	public int insert(VisitVO vo) { // 호출한 사용자가 전달한 값
		int res =0;

		// 1. sqlsession 얻어오기
		SqlSession sqlSession = factory.openSession(true);
		// 2. 실행
		res = sqlSession.insert("visit.visitInsert",vo);
		// 3. transaction 적용
		//sqlSession.commit();
		// 4. 닫기
		sqlSession.close();
		
		return res;
		
		
	}
	
	public int delete(int idx) { // 호출한 사용자가 전달한 값
		// TODO Auto-generated method stub
		
		int res = 0;
		
		Connection		   conn  = null;
		PreparedStatement  pstmt = null;
		
		
		String sql = "delete from visit where idx=?";
		
		
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
	
	
	public int update(VisitVO vo) { // 호출한 사용자가 전달한 값
		// TODO Auto-generated method stub
		
		int res = 0;
		
		Connection		   conn  = null;
		PreparedStatement  pstmt = null;
		
		
		String sql = "update visit set content = ? where idx = ?";
		
		
		try {
			//1.Connection 얻어오기
			conn = DBService.getInstance().getConnection();
			
			//2.PreparedStatement 얻어오기
			pstmt = conn.prepareStatement(sql); // 캐싱
			
			//3.pstmt의 변수처리된 parameter 설정과정
			pstmt.setString(1, vo.getContent());
			pstmt.setInt(2, vo.getIdx());
			
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
