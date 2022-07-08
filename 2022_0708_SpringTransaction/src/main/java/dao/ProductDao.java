package dao;

import java.util.List;

import vo.ProductVo;

public interface ProductDao {
	List<ProductVo> list();
	
	int insert(ProductVo vo) throws Exception;
	int update(ProductVo vo) throws Exception;
	int delete(int idx) throws Exception;
	
	// �̸��� �Է��ؼ� ��ǰ�� �˻�
	default ProductVo selectOne(String name) {return null;}
	

}
