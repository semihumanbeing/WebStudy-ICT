package dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.PhotoVO;

public class PhotoDAO {

	SqlSessionFactory factory;
	// single-ton : ��ü 1���� �����ؼ� �������!
	// ����ƽ��ü�� ������ �ϳ��� ���������.
	static PhotoDAO single = null;

	// ����ƽ�� ������ ����ƽ���θ�
	public static PhotoDAO getInstance() {

		// ��ü�� ������ �����ض� ȣ��� �ѹ��� ��ü�� ����
		if (single == null)
			single = new PhotoDAO();

		return single;
	}

	// �ܺο��� ��ü�� �������� ���ϰ� ����
	private PhotoDAO() {
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();

	}

	// ��ü��ȸ
	public List<PhotoVO> selectList() {

		List<PhotoVO> list = null;
		SqlSession sqlSession = factory.openSession();
		list = sqlSession.selectList("photo.selectPhotoList");
		sqlSession.close();

		return list;
	}

	// 1���� ��ȸ
	public PhotoVO selectOne(int p_idx) {
		PhotoVO vo = null;

		SqlSession sqlSession = factory.openSession();
		vo = sqlSession.selectOne("photo.selectOnePhotoIdx", p_idx);
		sqlSession.close();

		return vo;
	}
	
	// ���� ���
	public int insert(PhotoVO vo) { // ȣ���� ����ڰ� ������ ��
		int res = 0;

		SqlSession sqlSession = factory.openSession(true);
		res = sqlSession.insert("photo.insertPhoto", vo);
		sqlSession.close();

		// ������ 0���� ������ ��� ����!
		return res;
	}
	
	// ���� ����
	public int delete(int idx) { // ȣ���� ����ڰ� ������ ��
		int res = 0;

		SqlSession sqlSession = factory.openSession(true);
		res = sqlSession.delete("photo.deletePhoto", idx);
		sqlSession.close();
		// ������ 0���� ������ ��� ����!
		return res;
	}

	// ���� ����
	public int update(PhotoVO vo) { // ȣ���� ����ڰ� ������ ��
		int res = 0;

		SqlSession sqlSession = factory.openSession(true);
		res = sqlSession.delete("photo.updatePhoto", vo);
		sqlSession.close();
		// ������ 0���� ������ ��� ����!
		return res;
	}

}
