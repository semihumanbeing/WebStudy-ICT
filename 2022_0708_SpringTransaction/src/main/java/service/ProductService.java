package service;

import java.util.Map;

import vo.ProductVo;

public interface ProductService {
	
	Map selectList();							  // ��ü��ȸ
	int insert_in(ProductVo vo) throws Exception; // �԰�ó��
	int insert_out(ProductVo vo) throws Exception; // ���ó��
	

}
