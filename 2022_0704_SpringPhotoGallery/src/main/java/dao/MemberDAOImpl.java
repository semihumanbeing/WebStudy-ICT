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
	
	// ��ü��ȸ
	public List<MemberVO> selectList() {
		List<MemberVO> list = null;
		list = sqlSession.selectList("member.selectList");
		return list;
	}
	
	// ȸ������
	public int insert(MemberVO vo) { // ȣ���� ����ڰ� ������ ��
		int res = 0;
		res = sqlSession.insert("member.insertMember", vo);
		return res;
	}
	
	// ȸ������
	public int delete(int idx) { // ȣ���� ����ڰ� ������ ��
		int res = 0;
		res = sqlSession.delete("member.deleteMember", idx);
		return res;
	}
	
	// ȸ������
	public int update(MemberVO vo) { // ȣ���� ����ڰ� ������ ��
		int res = 0;
		res = sqlSession.update("member.updateMember",vo);
		return res;
	}

}
