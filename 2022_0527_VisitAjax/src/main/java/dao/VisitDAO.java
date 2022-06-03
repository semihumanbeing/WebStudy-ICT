package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import service.DBService;
import vo.VisitVO;

public class VisitDAO {
	
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
		// TODO Auto-generated constructor stub
	}
	
	public List<VisitVO> selectList() {

		List<VisitVO> list = new ArrayList<VisitVO>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from visit order by idx desc";

		try {
			//1.Connection������
			conn = DBService.getInstance().getConnection();

			//2.PreparedStatment������
			pstmt = conn.prepareStatement(sql);

			//3.ResultSet������
			rs = pstmt.executeQuery();

			//4.����(record->Vo->list)
			while (rs.next()) {
				//rs�� ����Ű�� ��(���ڵ�)�� ���� �о�´�

				//Vo�� ����
				VisitVO vo = new VisitVO();
				
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setContent(rs.getString("content"));
				vo.setPwd(rs.getString("pwd"));
				vo.setIp(rs.getString("ip"));
				vo.setRegdate(rs.getString("regdate"));
				

				//list�߰�
				list.add(vo);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			try {
				//����(����)�Ǿ����� �ݾƶ�(������������)
				if (rs != null)
					rs.close(); //3 
				if (pstmt != null)
					pstmt.close();//2
				if (conn != null)
					conn.close(); //1
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return list;
	}

	public int insert(VisitVO vo) { // ȣ���� ����ڰ� ������ ��
		// TODO Auto-generated method stub
		
		int res = 0;
		
		Connection		   conn  = null;
		PreparedStatement  pstmt = null;
		
		
		String sql = "insert into visit values(seq_visit_idx.nextVal,?,?,?,?,sysdate)";
		
		try {
			//1.Connection ������
			conn = DBService.getInstance().getConnection();
			
			//2.PreparedStatement ������
			pstmt = conn.prepareStatement(sql); // ĳ��
			
			//3.pstmt�� ����ó���� parameter ��������
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getPwd());
			pstmt.setString(4, vo.getIp());
			
			
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
	
	public VisitVO selectOne(int idx) {
		VisitVO vo = null;
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from visit where idx = ?";

		try {
			// 1. connection ������
			connection = DBService.getInstance().getConnection(); // connection �� �����ϰ��� �� �ݾ��ش�.
			// 2. prepared statement ������
			pstmt = connection.prepareStatement(sql);
			// 3. pstmt ����
			pstmt.setInt(1, idx);
			// 4. result set ���ϱ�
			rs = pstmt.executeQuery();
			// 5. �����ϱ�
			if (rs.next()) {
				// vo�� ����
				vo = new VisitVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setContent(rs.getString("content"));
				vo.setPwd(rs.getString("pwd"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// ����Ǿ������� close ���ش�.(���� ��������)
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
	
	
	
	
	
	
}
