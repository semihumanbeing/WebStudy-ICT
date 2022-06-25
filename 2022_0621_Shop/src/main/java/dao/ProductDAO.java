package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.ProductVO;

public class ProductDAO {
	
	// mybatis ��ü
	SqlSessionFactory factory;
	
	//single-ton : ��ü 1���� �����ؼ� �������!
	//����ƽ��ü�� ������ �ϳ��� ���������.
	static ProductDAO single = null;

	//����ƽ�� ������ ����ƽ���θ�
	public static ProductDAO getInstance() {

		//��ü�� ������ �����ض� ȣ��� �ѹ��� ��ü�� ����
		if (single == null)
			single = new ProductDAO();

		return single;
	}

	//�ܺο��� ��ü�� �������� ���ϰ� ����
	private ProductDAO() {
		// TODO Auto-generated constructor stub
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}
	
	// ī�װ��� ��ȸ
	public List<ProductVO> selectList(String category){
		
		List<ProductVO> list = null;
		
		SqlSession sqlSession = factory.openSession();
		
		list = sqlSession.selectList("product.product_list", category);
		
		sqlSession.close();
		
		return list;
	}
	
	// 
	public ProductVO selectOne(int p_idx) {
		
		ProductVO vo = null;
		
		SqlSession sqlSession = factory.openSession();
		
		vo = sqlSession.selectOne("product.product_one",p_idx);
		
		sqlSession.close();
		
		return vo;
	}

	public int insert(ProductVO vo) {
		
		int res = 0;
		SqlSession sqlSession = factory.openSession(true);
		res = sqlSession.insert("product.insert",vo);
		sqlSession.close();
		
		return res;
	}

}
