package dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.PhotoVO;

public class PhotoDAO {

	SqlSessionFactory factory;
	// single-ton : 객체 1개만 생성해서 사용하자!
	// 스태틱객체는 무조건 하나만 만들어진다.
	static PhotoDAO single = null;

	// 스태틱은 무조건 스태틱으로만
	public static PhotoDAO getInstance() {

		// 객체가 없으면 생성해라 호출된 한번만 객체를 생성
		if (single == null)
			single = new PhotoDAO();

		return single;
	}

	// 외부에서 객체를 생성하지 못하게 막음
	private PhotoDAO() {
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();

	}

	// 전체조회
	public List<PhotoVO> selectList() {

		List<PhotoVO> list = null;
		SqlSession sqlSession = factory.openSession();
		list = sqlSession.selectList("photo.selectPhotoList");
		sqlSession.close();

		return list;
	}

	// 1개만 조회
	public PhotoVO selectOne(int p_idx) {
		PhotoVO vo = null;

		SqlSession sqlSession = factory.openSession();
		vo = sqlSession.selectOne("photo.selectOnePhotoIdx", p_idx);
		sqlSession.close();

		return vo;
	}
	
	// 사진 등록
	public int insert(PhotoVO vo) { // 호출한 사용자가 전달한 값
		int res = 0;

		SqlSession sqlSession = factory.openSession(true);
		res = sqlSession.insert("photo.insertPhoto", vo);
		sqlSession.close();

		// 리턴을 0으로 받으면 명령 실패!
		return res;
	}
	
	// 사진 삭제
	public int delete(int idx) { // 호출한 사용자가 전달한 값
		int res = 0;

		SqlSession sqlSession = factory.openSession(true);
		res = sqlSession.delete("photo.deletePhoto", idx);
		sqlSession.close();
		// 리턴을 0으로 받으면 명령 실패!
		return res;
	}

	// 사진 수정
	public int update(PhotoVO vo) { // 호출한 사용자가 전달한 값
		int res = 0;

		SqlSession sqlSession = factory.openSession(true);
		res = sqlSession.delete("photo.updatePhoto", vo);
		sqlSession.close();
		// 리턴을 0으로 받으면 명령 실패!
		return res;
	}

}
