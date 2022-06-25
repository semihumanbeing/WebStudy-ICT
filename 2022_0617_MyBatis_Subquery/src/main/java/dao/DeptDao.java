package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.DeptVo;

public class DeptDao {
	
	SqlSessionFactory factory;
	//single-ton : ��ü 1���� �����ؼ� �������!
	//����ƽ��ü�� ������ �ϳ��� ���������.
	static DeptDao single = null;

	//����ƽ�� ������ ����ƽ���θ�
	public static DeptDao getInstance() {

		//��ü�� ������ �����ض� ȣ��� �ѹ��� ��ü�� ����
		if (single == null)
			single = new DeptDao();

		return single;
	}

	//�ܺο��� ��ü�� �������� ���ϰ� ����
	private DeptDao() {
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
		// TODO Auto-generated constructor stub
	}
	
	//��Ϻ���
	public List<DeptVo> selectList(){
		List<DeptVo> list = null;
		
		// ���� ������
		SqlSession sqlSession = factory.openSession();
		
		list = sqlSession.selectList("dept.deptList");
		
		sqlSession.close();
		
		return list;
	}
	
}
