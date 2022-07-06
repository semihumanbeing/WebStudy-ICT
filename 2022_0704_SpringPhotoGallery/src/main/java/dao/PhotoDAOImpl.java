package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.PhotoVO;

public class PhotoDAOImpl implements PhotoDAO {

	SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	// ��ü��ȸ
	public List<PhotoVO> selectList() {
		List<PhotoVO> list = null;
		list = sqlSession.selectList("photo.selectPhotoList");
		return list;
	}

	// 1���� ��ȸ
	public PhotoVO selectOne(int p_idx) {
		PhotoVO vo = null;
		vo = sqlSession.selectOne("photo.selectOnePhotoIdx", p_idx);
		return vo;
	}
	
	// ���� ���
	public int insert(PhotoVO vo) { // ȣ���� ����ڰ� ������ ��
		int res = 0;
		res = sqlSession.insert("photo.insertPhoto", vo);
		return res;
	}
	
	// ���� ����
	public int delete(int idx) { // ȣ���� ����ڰ� ������ ��
		int res = 0;
		res = sqlSession.delete("photo.deletePhoto", idx);
		return res;
	}

	// ���� ����
	public int update(PhotoVO vo) { // ȣ���� ����ڰ� ������ ��
		int res = 0;
		res = sqlSession.delete("photo.updatePhoto", vo);
		return res;
	}

}
