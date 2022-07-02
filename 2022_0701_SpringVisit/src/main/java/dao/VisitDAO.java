package dao;

import java.util.List;
import java.util.Map;

import vo.VisitVO;

public interface VisitDAO {
	
	public List<VisitVO> selectList();
	
	public List<VisitVO> selectList(Map map);
	
	public VisitVO selectOne(int idx);
	
	public int insert(VisitVO vo);
	
	public int delete(int idx);
	
	public int update(VisitVO vo);
	
	
	
	
	
	
	
	
}
