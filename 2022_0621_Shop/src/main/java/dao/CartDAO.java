package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.CartVO;

public class CartDAO {
	
	SqlSessionFactory factory;
	//single-ton : 객체 1개만 생성해서 사용하자!
	//스태틱객체는 무조건 하나만 만들어진다.
	static CartDAO single = null;

	//스태틱은 무조건 스태틱으로만
	public static CartDAO getInstance() {

		//객체가 없으면 생성해라 호출된 한번만 객체를 생성
		if (single == null)
			single = new CartDAO();

		return single;
	}

	//외부에서 객체를 생성하지 못하게 막음
	private CartDAO() {
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
		// TODO Auto-generated constructor stub
	}
	
	
	public List<CartVO> selectList(int m_idx) {
		List<CartVO> list = null;
		
		SqlSession sqlSession = factory.openSession();
		list = sqlSession.selectList("cart.cart_list", m_idx);
		sqlSession.close();
		
		return list;
	}

	public int selectTotalAmount(int m_idx) {
		int total_amount = 0;
		
		SqlSession sqlSession = factory.openSession();
		total_amount = sqlSession.selectOne("cart.cart_totalAmount",m_idx);
		sqlSession.close();
		
		return total_amount;
	}

	public CartVO selectOne(CartVO vo) {
		CartVO resVO = null;
		
		SqlSession sqlSession = factory.openSession();
		resVO = sqlSession.selectOne("cart.one_exist",vo);
		sqlSession.close();
		
		return resVO;
	}

	public int insert(CartVO vo) {
		int res = 0;
		
		SqlSession sqlSession = factory.openSession(true);
		res = sqlSession.insert("cart.insert",vo);
		sqlSession.close();
		
		return res;
	}

	public int update(CartVO vo) {
		int res = 0 ;
		
		SqlSession sqlSession = factory.openSession(true);
		res = sqlSession.update("cart.update",vo);
		sqlSession.close();
		
		return res;
	}
	
	public int delete(int c_idx) {
		int res = 0;
		
		SqlSession sqlSession = factory.openSession(true);
		res = sqlSession.delete("cart.delete",c_idx);
		sqlSession.close();
		
		return res;
	}

	public List<CartVO> selectList(Map<String, int[]> map) {
		List<CartVO> list = null;
		
		SqlSession sqlSession = factory.openSession();
		
		list = sqlSession.selectList("cart.cart_list_purchase",map);
		
		sqlSession.close();

		return list;
	}

	public int selectTotalAmount(Map<String, int[]> map) {
int total_amount = 0;
		
		SqlSession sqlSession = factory.openSession();
		total_amount = sqlSession.selectOne("cart.cart_totalAmountPurchased",map);
		sqlSession.close();
		
		return total_amount;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
