package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.MemberVO;

public class MemberDAOImpl implements MemberDAO {
	
	SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	// selectOne(idx)
	public MemberVO selectOne(int m_idx) {
		MemberVO vo = null;
		vo = sqlSession.selectOne("member.selectOneIdx", m_idx);
		return vo;
	}

	// selectOne(id)
	public MemberVO selectOne(String m_id) {
		MemberVO vo = null;
		vo = sqlSession.selectOne("member.selectOneID", m_id);
		return vo;
	}
	
	// 전체조회
	public List<MemberVO> selectList() {
		List<MemberVO> list = null;
		list = sqlSession.selectList("member.selectList");
		return list;
	}
	
	// 회원가입
	public int insert(MemberVO vo) { // 호출한 사용자가 전달한 값
		int res = 0;
		res = sqlSession.insert("member.insertMember", vo);
		return res;
	}
	
	// 회원삭제
	public int delete(int idx) { // 호출한 사용자가 전달한 값
		int res = 0;
		res = sqlSession.delete("member.deleteMember", idx);
		return res;
	}
	
	// 회원수정
	public int update(MemberVO vo) { // 호출한 사용자가 전달한 값
		int res = 0;
		res = sqlSession.update("member.updateMember",vo);
		return res;
	}

}
