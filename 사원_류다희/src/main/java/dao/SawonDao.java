package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.SawonVo;

public class SawonDao {
	
	SqlSessionFactory factory;
	
	//single-ton : 객체 1개만 생성해서 사용하자!
	//스태틱객체는 무조건 하나만 만들어진다.
	static SawonDao single = null;

	//스태틱은 무조건 스태틱으로만
	public static SawonDao getInstance() {

		//객체가 없으면 생성해라 호출된 한번만 객체를 생성
		if (single == null)
			single = new SawonDao();

		return single;
	}

	//외부에서 객체를 생성하지 못하게 막음
	private SawonDao() {
		factory = MyBatisConnector.getInstance().getSqlSessionFactory(); 
	}
	
	// 사원목록 가져오기
	public List<SawonVo> selectList(){
		
		List<SawonVo> list = null;
		
		// 1. SqlSession 생성
		SqlSession sqlSession = factory.openSession(); // connection 얻어오기
		// 2. 작업 수행				name space / mapperID
		list = sqlSession.selectList("sawon.sawonList");
		
		// 3. sqlSession이 얻어온 connection 닫기
		sqlSession.close();
		
		return list;
		
		
	}

	public List<SawonVo> selectListByDeptno(int deptno) {

		List<SawonVo> list = null;
		
		// 1. SqlSession 생성
		SqlSession sqlSession = factory.openSession(); // connection 얻어오기
		// 2. 작업 수행				name space / mapperID		parameter
		list = sqlSession.selectList("sawon.sawonList_deptno", deptno);
		// mapper에 있는 id "sawonList_deptno" 에 해당하는 SQL문을 이용해서 Vo 포장 -> ArrayList로 포장
		
		// 3. sqlSession이 얻어온 connection 닫기
		sqlSession.close();
		
		return list;
	}
	
	public List<SawonVo> sahireList(Map<String, Integer> map){
		List<SawonVo> list = null;
		
		SqlSession sqlSession = factory.openSession();
		
		list = sqlSession.selectList("sawon.sawonList_sahire_year",map);
		
		sqlSession.close();
		
		return list;
	}
	
	
	
	
	
}
