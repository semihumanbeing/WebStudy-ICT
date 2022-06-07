package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import service.DBService;
import vo.PhotoVO;

public class PhotoDAO {
	
	//single-ton : ��ü 1���� �����ؼ� �������!
	//����ƽ��ü�� ������ �ϳ��� ���������.
	static PhotoDAO single = null;

	//����ƽ�� ������ ����ƽ���θ�
	public static PhotoDAO getInstance() {

		//��ü�� ������ �����ض� ȣ��� �ѹ��� ��ü�� ����
		if (single == null)
			single = new PhotoDAO();

		return single;
	}

	//�ܺο��� ��ü�� �������� ���ϰ� ����
	private PhotoDAO() {
		// TODO Auto-generated constructor stub
	}
	
	//��ü��ȸ
	public List<PhotoVO> selectList() {

		List<PhotoVO> list = new ArrayList<PhotoVO>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from photo order by p_idx desc";

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
				PhotoVO vo = new PhotoVO();
				vo.setP_idx(rs.getInt("p_idx"));
				vo.setP_subject(rs.getString("p_subject"));
				vo.setP_content(rs.getString("p_content"));
				vo.setP_filename(rs.getString("p_filename"));
				vo.setP_ip(rs.getString("p_ip"));
				vo.setRegdate(rs.getString("regdate"));
				vo.setM_idx(rs.getInt("m_idx"));

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
	
	public PhotoVO selectOne(int p_idx) {
		PhotoVO vo = null;
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from photo where p_idx = ?";

		try {
			// 1. connection ������
			connection = DBService.getInstance().getConnection(); // connection �� �����ϰ��� �� �ݾ��ش�.
			// 2. prepared statement ������
			pstmt = connection.prepareStatement(sql);
			// 3. pstmt ����
			pstmt.setInt(1, p_idx);
			// 4. result set ���ϱ�
			rs = pstmt.executeQuery();
			// 5. �����ϱ�
			if (rs.next()) {
				// vo�� ����
				vo = new PhotoVO();
				vo.setP_idx(rs.getInt("p_idx"));
				vo.setP_subject(rs.getString("p_subject"));
				vo.setP_content(rs.getString("p_content"));
				vo.setP_filename(rs.getString("p_filename"));
				vo.setP_ip(rs.getString("p_ip"));
				vo.setRegdate(rs.getString("regdate"));
				vo.setM_idx(rs.getInt("m_idx"));

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
