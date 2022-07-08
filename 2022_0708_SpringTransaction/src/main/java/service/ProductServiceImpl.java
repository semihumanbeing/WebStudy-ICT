package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.ProductDao;
import vo.ProductVo;

public class ProductServiceImpl implements ProductService {
	
	ProductDao product_in_dao;
	ProductDao product_out_dao;
	ProductDao product_remain_dao;
	
	public ProductServiceImpl(ProductDao product_in_dao, ProductDao product_out_dao, ProductDao product_remain_dao) {
		super();
		this.product_in_dao = product_in_dao;
		this.product_out_dao = product_out_dao;
		this.product_remain_dao = product_remain_dao;
	}

	@Override
	public Map selectList() {
		// 입고목록
		List<ProductVo> in_list = product_in_dao.list();
		// 출고목록
		List<ProductVo> out_list = product_out_dao.list();
		// 재고목록
		List<ProductVo> remain_list = product_remain_dao.list();
		
		Map map = new HashMap();
		map.put("in_list", in_list);
		map.put("out_list", out_list);
		map.put("remain_list", remain_list);
		
		return map;
	}

	@Override
	public int insert_in(ProductVo vo) throws Exception {
		int res = 0;
		// 입고테이블에 등록하기
		res = product_in_dao.insert(vo);
		// 입고된 상품이 재고 테이블에 존재하는 지 여부
		ProductVo remainVo = product_remain_dao.selectOne(vo.getName());
		if(remainVo == null) {
			// 재고 테이블에 없는 경우, 입고 정보와 동일한 상품 내역을 재고에 등록
			res = product_remain_dao.insert(vo);
		} else {
			// 재고량 = 재고수량 + 입고수량
			int cnt = remainVo.getCnt() + vo.getCnt();
			// 수정된 수량을 재고 vo에 반영
			remainVo.setCnt(cnt);
			
			res = product_remain_dao.update(remainVo);
			
		}
		
		return res;
	}

	@Override
	public int insert_out(ProductVo vo) throws Exception {
		int res = 0;
		
		// 출고등록
		res = product_out_dao.insert(vo);
		// 재고테이블에서 출고된 상품정보 읽어오기
		ProductVo remainVo = product_remain_dao.selectOne(vo.getName());
		
		if(remainVo==null) { // 재고상품이 없으면
			throw new Exception("remain_not");
			
		} else {// 재고상품이 있으면 
			// 재고수량 = 재고수량 - 출고수량
			int cnt = remainVo.getCnt() - vo.getCnt();
			
			if(cnt < 0) { // 재고 수량이 부족할 때
				throw new Exception("remain_lack");
			} else { // 재고처리
				remainVo.setCnt(cnt);
				res = product_remain_dao.update(remainVo);
			}
		}
		
		return res;
	}

}
