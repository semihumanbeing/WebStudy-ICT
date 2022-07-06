package dao;

import java.util.List;

import vo.MemberVO;

public interface MemberDAO {

	// selectOne(idx)
	public MemberVO selectOne(int m_idx);

	// selectOne(id)
	public MemberVO selectOne(String m_id);
	
	// 전체조회
	public List<MemberVO> selectList();
	
	// 회원가입
	public int insert(MemberVO vo);
	
	// 회원삭제
	public int delete(int idx);
	
	// 회원수정
	public int update(MemberVO vo);

}
