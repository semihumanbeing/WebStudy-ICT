package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.CartVO;
import vo.PaymentVO;

public class PaymentDAO {

	SqlSessionFactory factory;
	static PaymentDAO single = null;

	public static PaymentDAO getInstance() {

		if (single == null)
			single = new PaymentDAO();

		return single;
	}

	private PaymentDAO() {
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}

	// 결제 결과 불러오기
	public List<PaymentVO> selectPaymentResult(int order_idx) {
		List<PaymentVO> list = null;

		SqlSession sqlSession = factory.openSession();
		list = sqlSession.selectList("payment.selectPaymentResult", order_idx);
		sqlSession.close();

		return list;
	}

	// 결제하기
	public int insertPayment(int m_idx, int[] c_idx_array, String pay_method, int order_idx) {
		int res = 0;
		// Array나 ArrayList 를 parameter로 넘길 경우 Map의 형태로 넘긴다.
		Map map = new HashMap();
		map.put("c_idx_array", c_idx_array);

		// 결제목록 가져오기
		List<CartVO> cartList = CartDAO.getInstance().selectList(map);
		
				
		// 파라미터: c_idx, pay_method ok
		// 삭제하기: cart의 c_idx ok
		// pay_method ok
		// cartview에 있는거: p_num, p_name, p_price, p_saleprice, c_cnt, amount, m_idx

		SqlSession sqlSession = factory.openSession(true);
		// 장바구니 내역 입력하기
		for (CartVO v : cartList) {
			String pay_num = v.getP_num();
			String pay_name = v.getP_name();
			int pay_price = v.getP_price();
			int pay_saleprice = v.getP_saleprice();
			int pay_cnt = v.getC_cnt();
			int pay_amount = v.getAmount();
			PaymentVO vo = new PaymentVO(pay_num, pay_name, pay_price, pay_saleprice, pay_cnt, pay_amount, m_idx,
					pay_method, order_idx);
			res = sqlSession.insert("payment.insertPayment", vo);
		}

		sqlSession.close();

		return res;
	}

}
