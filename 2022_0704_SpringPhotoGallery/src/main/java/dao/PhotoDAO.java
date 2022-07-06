package dao;

import java.util.List;

import vo.PhotoVO;

public interface PhotoDAO {

	// ��ü��ȸ
	public List<PhotoVO> selectList();

	// 1���� ��ȸ
	public PhotoVO selectOne(int p_idx);
	
	// ���� ���
	public int insert(PhotoVO vo);
	
	// ���� ����
	public int delete(int idx);

	// ���� ����
	public int update(PhotoVO vo);

}
