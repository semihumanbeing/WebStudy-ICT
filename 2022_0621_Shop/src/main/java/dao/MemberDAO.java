package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.MemberVO;

public class MemberDAO {

	SqlSessionFactory factory;
	// single-ton : 객체 1개만 생성해서 사용하자!
	// 스태틱객체는 무조건 하나만 만들어진다.
	static MemberDAO single = null;

	// 스태틱은 무조건 스태틱으로만
	public static MemberDAO getInstance() {

		// 객체가 없으면 생성해라 호출된 한번만 객체를 생성
		if (single == null)
			single = new MemberDAO();

		return single;
	}

	// 외부에서 객체를 생성하지 못하게 막음
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
	
	// 전체조회
	public List<MemberVO> selectList() {

		List<MemberVO> list = null;

		SqlSession sqlSession = factory.openSession();
		list = sqlSession.selectList("member.selectList");
		
		sqlSession.close();

		return list;
	}
	
	// 회원가입
	public int insert(MemberVO vo) { // 호출한 사용자가 전달한 값
		int res = 0;
		
		SqlSession sqlSession = factory.openSession(true);
		res = sqlSession.insert("member.insertMember", vo);
		sqlSession.close();
		// 리턴을 0으로 받으면 명령 실패!
		return res;
	}
	
	// 회원삭제
	public int delete(int idx) { // 호출한 사용자가 전달한 값
		// TODO Auto-generated method stub

		int res = 0;

		SqlSession sqlSession = factory.openSession(true);
		res = sqlSession.delete("member.deleteMember", idx);
		sqlSession.close();
		// 리턴을 0으로 받으면 명령 실패!
		return res;
	}
	
	// 회원수정
	public int update(MemberVO vo) { // 호출한 사용자가 전달한 값

		int res = 0;

		SqlSession sqlSession = factory.openSession(true);
		res = sqlSession.update("member.updateMember",vo);
		sqlSession.close();
		// 리턴을 0으로 받으면 명령 실패!
		return res;
	}

}
