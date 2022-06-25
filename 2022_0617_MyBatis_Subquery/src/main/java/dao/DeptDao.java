package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.DeptVo;

public class DeptDao {
	
	SqlSessionFactory factory;
	//single-ton : 객체 1개만 생성해서 사용하자!
	//스태틱객체는 무조건 하나만 만들어진다.
	static DeptDao single = null;

	//스태틱은 무조건 스태틱으로만
	public static DeptDao getInstance() {

		//객체가 없으면 생성해라 호출된 한번만 객체를 생성
		if (single == null)
			single = new DeptDao();

		return single;
	}

	//외부에서 객체를 생성하지 못하게 막음
	private DeptDao() {
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
		// TODO Auto-generated constructor stub
	}
	
	//목록보기
	public List<DeptVo> selectList(){
		List<DeptVo> list = null;
		
		// 세션 얻어오기
		SqlSession sqlSession = factory.openSession();
		
		list = sqlSession.selectList("dept.deptList");
		
		sqlSession.close();
		
		return list;
	}
	
}
