package dao;

import java.util.List;

import vo.MemberVO;

public interface MemberDAO {

	// selectOne(idx)
	public MemberVO selectOne(int m_idx);

	// selectOne(id)
	public MemberVO selectOne(String m_id);
	
	// ��ü��ȸ
	public List<MemberVO> selectList();
	
	// ȸ������
	public int insert(MemberVO vo);
	
	// ȸ������
	public int delete(int idx);
	
	// ȸ������
	public int update(MemberVO vo);

}
