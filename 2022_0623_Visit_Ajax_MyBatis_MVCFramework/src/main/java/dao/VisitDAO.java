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
	//single-ton : ��ü 1���� �����ؼ� �������!
	//����ƽ��ü�� ������ �ϳ��� ���������.
	static VisitDAO single = null;

	//����ƽ�� ������ ����ƽ���θ�
	public static VisitDAO getInstance() {

		//��ü�� ������ �����ض� ȣ��� �ѹ��� ��ü�� ����
		if (single == null)
			single = new VisitDAO();

		return single;
	}

	//�ܺο��� ��ü�� �������� ���ϰ� ����
	private VisitDAO() {
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
		
	}
	
	public List<VisitVO> selectList() {

		List<VisitVO> list = null;
		// sqlsession ������
		SqlSession sqlSession = factory.openSession();
		// ����
		list = sqlSession.selectList("visit.visitList");
		// �ݱ�
		sqlSession.close();

		return list;
	}
	public List<VisitVO> selectList(Map map) {

		List<VisitVO> list = null;
		// sqlsession ������
		SqlSession sqlSession = factory.openSession();
		// ����
		list = sqlSession.selectList("visit.visitList_condition",map);
		// �ݱ�
		sqlSession.close();

		return list;
	}
	
	
	public VisitVO selectOne(int idx) {
		VisitVO vo = null;
		// sqlsession ������
		SqlSession sqlSession = factory.openSession();
		// ����
		vo = sqlSession.selectOne("visit.visitOne",idx);
		// �ݱ�
		sqlSession.close();
		
		
		return vo;
	}
	

	public int insert(VisitVO vo) { // ȣ���� ����ڰ� ������ ��
		int res =0;

		// 1. sqlsession ������
		SqlSession sqlSession = factory.openSession(true);
		// 2. ����
		res = sqlSession.insert("visit.visitInsert",vo);
		// 3. transaction ����
		//sqlSession.commit();
		// 4. �ݱ�
		sqlSession.close();
		
		return res;
		
		
	}
	
	public int delete(int idx) { // ȣ���� ����ڰ� ������ ��
		// TODO Auto-generated method stub
		
		int res = 0;
		
		Connection		   conn  = null;
		PreparedStatement  pstmt = null;
		
		
		String sql = "delete from visit where idx=?";
		
		
		try {
			//1.Connection ������
			conn = DBService.getInstance().getConnection();
			
			//2.PreparedStatement ������
			pstmt = conn.prepareStatement(sql); // ĳ��
			
			//3.pstmt�� ����ó���� parameter ��������
			pstmt.setInt(1, idx);
			
			//4.DML(insert/update/delete)��� ����, res�� ó���� �������ȯ
			res = pstmt.executeUpdate();
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}finally {
			
			try {
				//�ݱ� (���� ����)
				if(pstmt != null) pstmt.close(); // 2
				if(conn != null) conn.close();   // 1
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		
		//������ 0���� ������ ��� ����!
		return res;
	}
	
	
	public int update(VisitVO vo) { // ȣ���� ����ڰ� ������ ��
		// TODO Auto-generated method stub
		
		int res = 0;
		
		Connection		   conn  = null;
		PreparedStatement  pstmt = null;
		
		
		String sql = "update visit set content = ? where idx = ?";
		
		
		try {
			//1.Connection ������
			conn = DBService.getInstance().getConnection();
			
			//2.PreparedStatement ������
			pstmt = conn.prepareStatement(sql); // ĳ��
			
			//3.pstmt�� ����ó���� parameter ��������
			pstmt.setString(1, vo.getContent());
			pstmt.setInt(2, vo.getIdx());
			
			//4.DML(insert/update/delete)��� ����, res�� ó���� �������ȯ
			res = pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}finally {
			
			try {
				//�ݱ� (���� ����)
				if(pstmt != null) pstmt.close(); // 2
				if(conn != null) conn.close();   // 1
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		
		//������ 0���� ������ ��� ����!
		return res;
	}
	
	
	
	
	
	
}
