package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.GogekVo;

public class GogekDao {
	
	SqlSessionFactory factory;
	//single-ton : 객체 1개만 생성해서 사용하자!
	//스태틱객체는 무조건 하나만 만들어진다.
	static GogekDao single = null;

	//스태틱은 무조건 스태틱으로만
	public static GogekDao getInstance() {

		//객체가 없으면 생성해라 호출된 한번만 객체를 생성
		if (single == null)
			single = new GogekDao();

		return single;
	}

	//외부에서 객체를 생성하지 못하게 막음
	private GogekDao() {
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
		// TODO Auto-generated constructor stub
	}
	
	public List<GogekVo> selectList(){
		
		List<GogekVo> list = null;
		
		SqlSession sqlSession = factory.openSession();
		
		list = sqlSession.selectList("gogek.gogekList");
		
		sqlSession.close();
		
		return list;
		
	}

}
