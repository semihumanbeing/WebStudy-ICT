package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import service.DBService;
import vo.SawonVO;

public class SawonDAO {
	//single-ton : ��ü 1���� �����ؼ� �������!
	//����ƽ��ü�� ������ �ϳ��� ���������.
	static SawonDAO single = null;

	//����ƽ�� ������ ����ƽ���θ�
	public static SawonDAO getInstance() {

		//��ü�� ������ �����ض� ȣ��� �ѹ��� ��ü�� ����
		if (single == null)
			single = new SawonDAO();

		return single;
	}

	//�ܺο��� ��ü�� �������� ���ϰ� ����
	private SawonDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public List<SawonVO> selectList() {

		List<SawonVO> list = new ArrayList<SawonVO>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from sawon order by sabun";

		try {
			//1.connection ������
			//				 Ŀ���� ��ü����, DB���� Ŀ���Ǿ��
			conn = DBService.getInstance().getConnection();

			//2.PreparedStatement ������
			pstmt = conn.prepareStatement(sql);

			//3.ResultSet ������

			rs = pstmt.executeQuery();

			//4.����(record -> Vo -> list)

			while (rs.next()) {
				//rs�� ����Ű�� ��(���ڵ�)�� ���� �о�´�.

				//Vo�� ����
				SawonVO vo = new SawonVO();
				
				vo.setSabun(rs.getInt("sabun"));
				vo.setSaname(rs.getString("saname"));
				vo.setSasex(rs.getString("sasex"));
				vo.setDeptno(rs.getInt("deptno"));
				vo.setSajob(rs.getString("sajob"));
				vo.setSahire(rs.getDate("sahire"));
				vo.setSamgr(rs.getInt("samgr"));
				vo.setSapay(rs.getInt("sapay"));
				
				//list�� �߰�

				list.add(vo);

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			try {
				//����(����) �Ǿ����� �ݾƶ�.(���� �������� �ݱ�)
				if (rs != null)
					rs.close(); // 3
				if (pstmt != null)
					pstmt.close(); // 2
				if (conn != null)
					conn.close(); // 1

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return list;
	}

}
