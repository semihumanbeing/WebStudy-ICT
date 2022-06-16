package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.GogekVo;

public class GogekDao {
	
	SqlSessionFactory factory;
	//single-ton : ��ü 1���� �����ؼ� �������!
	//����ƽ��ü�� ������ �ϳ��� ���������.
	static GogekDao single = null;

	//����ƽ�� ������ ����ƽ���θ�
	public static GogekDao getInstance() {

		//��ü�� ������ �����ض� ȣ��� �ѹ��� ��ü�� ����
		if (single == null)
			single = new GogekDao();

		return single;
	}

	//�ܺο��� ��ü�� �������� ���ϰ� ����
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
