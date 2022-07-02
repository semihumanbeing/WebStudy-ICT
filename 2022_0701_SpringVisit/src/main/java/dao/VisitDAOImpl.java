package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import vo.VisitVO;

public class VisitDAOImpl implements VisitDAO {

	SqlSession sqlSession;
	
	//setter injection
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<VisitVO> selectList() {
		List<VisitVO> list = null;
		list = sqlSession.selectList("visit.visitList");
		return list;
	}
	
	public List<VisitVO> selectList(Map map) {
		List<VisitVO> list = null;
		list = sqlSession.selectList("visit.visitList_condition",map);
		return list;
	}
	
	public VisitVO selectOne(int idx) {
		VisitVO vo = null;
		vo = sqlSession.selectOne("visit.visitOne",idx);
		return vo;
	}
	

	public int insert(VisitVO vo) { // 호출한 사용자가 전달한 값
		int res =0;
		res = sqlSession.insert("visit.visitInsert",vo);
		return res;
	}
	
	public int delete(int idx) { // 호출한 사용자가 전달한 값
		int res = 0;
		res = sqlSession.delete("visit.visitDelete", idx);
		return res;
	}
	
	
	public int update(VisitVO vo) { // 호출한 사용자가 전달한 값
		int res = 0;
		res = sqlSession.insert("visit.visitUpdate",vo);
		return res;
	}
	
	
	
	
}
