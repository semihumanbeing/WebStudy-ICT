package dao;

import java.util.List;

import vo.ProductVo;

public interface ProductDao {
	List<ProductVo> list();
	
	int insert(ProductVo vo) throws Exception;
	int update(ProductVo vo) throws Exception;
	int delete(int idx) throws Exception;
	
	// 이름을 입력해서 상품을 검색
	default ProductVo selectOne(String name) {return null;}
	

}
