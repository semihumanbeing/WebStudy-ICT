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
		// �԰���
		List<ProductVo> in_list = product_in_dao.list();
		// �����
		List<ProductVo> out_list = product_out_dao.list();
		// �����
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
		// �԰����̺� ����ϱ�
		res = product_in_dao.insert(vo);
		// �԰�� ��ǰ�� ��� ���̺� �����ϴ� �� ����
		ProductVo remainVo = product_remain_dao.selectOne(vo.getName());
		if(remainVo == null) {
			// ��� ���̺� ���� ���, �԰� ������ ������ ��ǰ ������ ��� ���
			res = product_remain_dao.insert(vo);
		} else {
			// ��� = ������ + �԰����
			int cnt = remainVo.getCnt() + vo.getCnt();
			// ������ ������ ��� vo�� �ݿ�
			remainVo.setCnt(cnt);
			
			res = product_remain_dao.update(remainVo);
			
		}
		
		return res;
	}

	@Override
	public int insert_out(ProductVo vo) throws Exception {
		int res = 0;
		
		// �����
		res = product_out_dao.insert(vo);
		// ������̺��� ���� ��ǰ���� �о����
		ProductVo remainVo = product_remain_dao.selectOne(vo.getName());
		
		if(remainVo==null) { // ����ǰ�� ������
			throw new Exception("remain_not");
			
		} else {// ����ǰ�� ������ 
			// ������ = ������ - ������
			int cnt = remainVo.getCnt() - vo.getCnt();
			
			if(cnt < 0) { // ��� ������ ������ ��
				throw new Exception("remain_lack");
			} else { // ���ó��
				remainVo.setCnt(cnt);
				res = product_remain_dao.update(remainVo);
			}
		}
		
		return res;
	}

}
