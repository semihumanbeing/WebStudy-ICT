package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.ProductVo;

public class Product_Remain_DaoImpl implements ProductDao {
	
	SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	

	@Override
	public List<ProductVo> list() {
		return sqlSession.selectList("product_remain.product_remain_list");
	}
	
	@Override
	public ProductVo selectOne(String name) {
		return sqlSession.selectOne("product_remain.product_remain_one",name);
	}

	@Override
	public int insert(ProductVo vo) throws Exception {
		return sqlSession.insert("product_remain.product_remain_insert",vo);
	}

	@Override
	public int update(ProductVo vo) throws Exception {
		return sqlSession.update("product_remain.product_remain_update",vo);
	}

	@Override
	public int delete(int idx) throws Exception {
		return sqlSession.delete("product_remain.product_remain_delete",idx);
	}


}
