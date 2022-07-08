package service;

import java.util.Map;

import vo.ProductVo;

public interface ProductService {
	
	Map selectList();							  // 전체조회
	int insert_in(ProductVo vo) throws Exception; // 입고처리
	int insert_out(ProductVo vo) throws Exception; // 출고처리
	

}
