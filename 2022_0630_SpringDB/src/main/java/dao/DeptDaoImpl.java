package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.DeptVo;

public class DeptDaoImpl implements DeptDao{
	
	// SqlSession�� SqlSessionTemplate�� �޴� �������̽��̴�. 
	// deptdaoimpl�� sqlsession�� �������� �޾ƾ� ����� �� �ִ�.
	// deptdao�� sqlsessiontemplate�� �������̹Ƿ� ������ ������ �ʿ��ϴ�.
	SqlSession sqlSession;
	
	// sqlSession�� ���ڷ� �޴� �⺻ ������
	// �⺻�����ڸ� ���� sqlSession�� �����ϰ� �ִ� ���°� �ƴϱ� ������ �ǹ̰� ����.
	// ���� �⺻ ������ ���� �����ε�� �����ڸ� ������ش�. 
	public DeptDaoImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}



	@Override
	public List<DeptVo> selectList() {
		
		return sqlSession.selectList("dept.deptList");
	}

}
