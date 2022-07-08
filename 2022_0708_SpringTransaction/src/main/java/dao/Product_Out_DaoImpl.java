package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.ProductVo;

public class Product_Out_DaoImpl implements ProductDao {
	
	SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	

	@Override
	public List<ProductVo> list() {
		return sqlSession.selectList("product_out.product_out_list");
	}

	@Override
	public int insert(ProductVo vo) throws Exception {
		return sqlSession.insert("product_out.product_out_insert",vo);
	}

	@Override
	public int update(ProductVo vo) throws Exception {
		return sqlSession.update("product_out.product_out_update",vo);
	}

	@Override
	public int delete(int idx) throws Exception {
		return sqlSession.delete("product_out.product_out_delete",idx);
	}


}
