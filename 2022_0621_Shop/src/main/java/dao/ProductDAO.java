package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.ProductVO;

public class ProductDAO {
	
	// mybatis 객체
	SqlSessionFactory factory;
	
	//single-ton : 객체 1개만 생성해서 사용하자!
	//스태틱객체는 무조건 하나만 만들어진다.
	static ProductDAO single = null;

	//스태틱은 무조건 스태틱으로만
	public static ProductDAO getInstance() {

		//객체가 없으면 생성해라 호출된 한번만 객체를 생성
		if (single == null)
			single = new ProductDAO();

		return single;
	}

	//외부에서 객체를 생성하지 못하게 막음
	private ProductDAO() {
		// TODO Auto-generated constructor stub
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}
	
	// 카테고리별 조회
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
