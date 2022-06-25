package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.MemberVO;

public class MemberDAO {

	SqlSessionFactory factory;
	// single-ton : ��ü 1���� �����ؼ� �������!
	// ����ƽ��ü�� ������ �ϳ��� ���������.
	static MemberDAO single = null;

	// ����ƽ�� ������ ����ƽ���θ�
	public static MemberDAO getInstance() {

		// ��ü�� ������ �����ض� ȣ��� �ѹ��� ��ü�� ����
		if (single == null)
			single = new MemberDAO();

		return single;
	}

	// �ܺο��� ��ü�� �������� ���ϰ� ����
	private MemberDAO() {
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
		// TODO Auto-generated constructor stub
	}

	// selectOne(idx)
	public MemberVO selectOne(int m_idx) {
		MemberVO vo = null;

		SqlSession sqlSession = factory.openSession();
		vo = sqlSession.selectOne("member.selectOneIdx", m_idx);

		sqlSession.close();

		return vo;
	}

	// selectOne(id)
	public MemberVO selectOne(String m_id) {
		MemberVO vo = null;

		SqlSession sqlSession = factory.openSession();
		vo = sqlSession.selectOne("member.selectOneID", m_id);

		sqlSession.close();

		return vo;
	}
	
	// ��ü��ȸ
	public List<MemberVO> selectList() {

		List<MemberVO> list = null;

		SqlSession sqlSession = factory.openSession();
		list = sqlSession.selectList("member.selectList");
		
		sqlSession.close();

		return list;
	}
	
	// ȸ������
	public int insert(MemberVO vo) { // ȣ���� ����ڰ� ������ ��
		int res = 0;
		
		SqlSession sqlSession = factory.openSession(true);
		res = sqlSession.insert("member.insertMember", vo);
		sqlSession.close();
		// ������ 0���� ������ ��� ����!
		return res;
	}
	
	// ȸ������
	public int delete(int idx) { // ȣ���� ����ڰ� ������ ��
		// TODO Auto-generated method stub

		int res = 0;

		SqlSession sqlSession = factory.openSession(true);
		res = sqlSession.delete("member.deleteMember", idx);
		sqlSession.close();
		// ������ 0���� ������ ��� ����!
		return res;
	}
	
	// ȸ������
	public int update(MemberVO vo) { // ȣ���� ����ڰ� ������ ��

		int res = 0;

		SqlSession sqlSession = factory.openSession(true);
		res = sqlSession.update("member.updateMember",vo);
		sqlSession.close();
		// ������ 0���� ������ ��� ����!
		return res;
	}

}
