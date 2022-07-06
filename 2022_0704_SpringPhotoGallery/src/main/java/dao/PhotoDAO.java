package dao;

import java.util.List;

import vo.PhotoVO;

public interface PhotoDAO {

	// 전체조회
	public List<PhotoVO> selectList();

	// 1개만 조회
	public PhotoVO selectOne(int p_idx);
	
	// 사진 등록
	public int insert(PhotoVO vo);
	
	// 사진 삭제
	public int delete(int idx);

	// 사진 수정
	public int update(PhotoVO vo);

}
