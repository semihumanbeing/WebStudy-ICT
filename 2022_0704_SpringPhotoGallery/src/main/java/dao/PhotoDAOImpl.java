package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.PhotoVO;

public class PhotoDAOImpl implements PhotoDAO {

	SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	// 전체조회
	public List<PhotoVO> selectList() {
		List<PhotoVO> list = null;
		list = sqlSession.selectList("photo.selectPhotoList");
		return list;
	}

	// 1개만 조회
	public PhotoVO selectOne(int p_idx) {
		PhotoVO vo = null;
		vo = sqlSession.selectOne("photo.selectOnePhotoIdx", p_idx);
		return vo;
	}
	
	// 사진 등록
	public int insert(PhotoVO vo) { // 호출한 사용자가 전달한 값
		int res = 0;
		res = sqlSession.insert("photo.insertPhoto", vo);
		return res;
	}
	
	// 사진 삭제
	public int delete(int idx) { // 호출한 사용자가 전달한 값
		int res = 0;
		res = sqlSession.delete("photo.deletePhoto", idx);
		return res;
	}

	// 사진 수정
	public int update(PhotoVO vo) { // 호출한 사용자가 전달한 값
		int res = 0;
		res = sqlSession.delete("photo.updatePhoto", vo);
		return res;
	}

}
