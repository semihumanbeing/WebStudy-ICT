package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.SawonVo;

public class SawonDao {
	
	SqlSessionFactory factory;
	
	//single-ton : ��ü 1���� �����ؼ� �������!
	//����ƽ��ü�� ������ �ϳ��� ���������.
	static SawonDao single = null;

	//����ƽ�� ������ ����ƽ���θ�
	public static SawonDao getInstance() {

		//��ü�� ������ �����ض� ȣ��� �ѹ��� ��ü�� ����
		if (single == null)
			single = new SawonDao();

		return single;
	}

	//�ܺο��� ��ü�� �������� ���ϰ� ����
	private SawonDao() {
		factory = MyBatisConnector.getInstance().getSqlSessionFactory(); 
	}
	
	// ������ ��������
	public List<SawonVo> selectList(){
		
		List<SawonVo> list = null;
		
		// 1. SqlSession ����
		SqlSession sqlSession = factory.openSession(); // connection ������
		// 2. �۾� ����				name space / mapperID
		list = sqlSession.selectList("sawon.sawonList");
		
		// 3. sqlSession�� ���� connection �ݱ�
		sqlSession.close();
		
		return list;
		
		
	}

	public List<SawonVo> selectListByDeptno(int deptno) {

		List<SawonVo> list = null;
		
		// 1. SqlSession ����
		SqlSession sqlSession = factory.openSession(); // connection ������
		// 2. �۾� ����				name space / mapperID		parameter
		list = sqlSession.selectList("sawon.sawonList_deptno", deptno);
		// mapper�� �ִ� id "sawonList_deptno" �� �ش��ϴ� SQL���� �̿��ؼ� Vo ���� -> ArrayList�� ����
		
		// 3. sqlSession�� ���� connection �ݱ�
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
