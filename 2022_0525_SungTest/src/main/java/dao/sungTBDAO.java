package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import service.DBService;
import vo.SungVO;

public class sungTBDAO {
	static sungTBDAO single = null;

	public static sungTBDAO getInstance() {
		if (single == null)
			single = new sungTBDAO();

		return single;
	}

	private sungTBDAO() {
		// �����̺� �����ڸ� ������־� �ܺο��� �������� �ʵ��� �Ѵ�.

	}

	public List<SungVO> selectList() {
		List<SungVO> list = new ArrayList<SungVO>();

		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from sungtb_view order by rank";

		try {
			// 1. connection ������
			connection = DBService.getInstance().getConnection(); // connection �� �����ϰ��� �� �ݾ��ش�.
			// 2. prepared statement ������
			pstmt = connection.prepareStatement(sql);
			// 3. result set ���ϱ�
			rs = pstmt.executeQuery();
			// 4. �����ϱ�
			while (rs.next()) {
				// rs�� ����Ű�� ���� ���� �о�´�.

				// vo�� ����
				SungVO vo = new SungVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setKor(rs.getInt("kor"));
				vo.setEng(rs.getInt("eng"));
				vo.setMat(rs.getInt("mat"));

				// db�� �ִ� �÷� Ÿ�԰� �����ϰ� String ������ �о�� �� �ִ�.
				vo.setTot(rs.getString("tot"));
				vo.setAvg(rs.getString("avg"));
				vo.setRank(rs.getString("rank"));

				// while �� �ѹ������� vo���� ���� ���ͼ� ����Ʈ�� �߰��Ѵ�.
				list.add(vo);
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

		return list;
	}

	public SungVO selectList(int idx) {
		SungVO vo = null;
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from sungtb_view where idx = ?";

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
				vo = new SungVO();
				// vo�� ����
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setKor(rs.getInt("kor"));
				vo.setEng(rs.getInt("eng"));
				vo.setMat(rs.getInt("mat"));
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

	public int insert(SungVO vo) {
		int res = 0;
		Connection connection = null;
		PreparedStatement pstmt = null; // 1 2 3 4 <- parameter index
		String sql = "insert into sungtb values(seq_sungtb_idx.nextVal,?,?,?,?)";
		try {
			// 1. connection ������
			connection = DBService.getInstance().getConnection();

			// 2. prepared statement ������
			pstmt = connection.prepareStatement(sql);

			// 3. pstmt�� �Ķ���� ����
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getKor());
			pstmt.setInt(3, vo.getEng());
			pstmt.setInt(4, vo.getMat());

			// 4. insert : res <- ó���� �� �� ��ȯ
			res = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close(); // 2
				connection.close(); // 1
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return res;
	}

	public int delete(int idx) {
		int res = 0;
		Connection connection = null;
		PreparedStatement pstmt = null;
		String sql = "delete from sungtb where idx = ?";
		try {
			// 1. connection ������
			connection = DBService.getInstance().getConnection();

			// 2. prepared statement ������
			pstmt = connection.prepareStatement(sql);

			// 3. pstmt�� �Ķ���� ����
			pstmt.setInt(1, idx);

			// 4. dml(insert,update,delete) : res <- ó���� �� �� ��ȯ
			res = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close(); // 2
				connection.close(); // 1
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return res;
	}

	public int update(SungVO vo) {
		int res = 0;
		Connection connection = null;
		PreparedStatement pstmt = null; // 1 2 3 4 5 <- parameter index
		String sql = "update sungtb set name = ?, kor = ?, eng = ?, mat = ? where idx = ?";
		try {
			// 1. connection ������
			connection = DBService.getInstance().getConnection();

			// 2. prepared statement ������
			pstmt = connection.prepareStatement(sql);

			// 3. pstmt�� �Ķ���� ����
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getKor());
			pstmt.setInt(3, vo.getEng());
			pstmt.setInt(4, vo.getMat());
			pstmt.setInt(5, vo.getIdx());

			// 4. dml(insert,update,delete) : res <- ó���� �� �� ��ȯ
			res = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close(); // 2
				connection.close(); // 1
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return res;
	}

}
