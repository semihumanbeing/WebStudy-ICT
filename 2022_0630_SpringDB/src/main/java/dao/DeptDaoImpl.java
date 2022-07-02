package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.DeptVo;

public class DeptDaoImpl implements DeptDao{
	
	// SqlSession은 SqlSessionTemplate을 받는 인터페이스이다. 
	// deptdaoimpl은 sqlsession의 참조값을 받아야 사용할 수 있다.
	// deptdao는 sqlsessiontemplate에 의존적이므로 의존성 주입이 필요하다.
	SqlSession sqlSession;
	
	// sqlSession을 인자로 받는 기본 생성자
	// 기본생성자를 만들어도 sqlSession에 의존하고 있는 상태가 아니기 때문에 의미가 없다.
	// 따라서 기본 생성자 없이 오버로드된 생성자만 만들어준다. 
	public DeptDaoImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}



	@Override
	public List<DeptVo> selectList() {
		
		return sqlSession.selectList("dept.deptList");
	}

}
