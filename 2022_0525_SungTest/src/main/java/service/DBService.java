package service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBService {
	
	DataSource ds;
	
	static DBService single = null;

	public static DBService getInstance() {

		//��ü�� ������ �����ض� ȣ��� �ѹ��� ��ü�� ����
		if (single == null)
			single = new DBService();

		return single;
	}

	//�ܺο��� ��ü�� �������� ���ϰ� ����
	private DBService() {
		// JNDI(java naming directory(�˻�) interface) �������̽��� �˻��ؼ� ���� ��� 
		try {
			
			// 1. InitialContext ����
			InitialContext ic = new InitialContext();
			
			// 2. Resource�� ����� Context������ ���ϱ�
			Context context = (Context) ic.lookup("java:comp/env"); //context.xml�� ��ġ�� �����ش�.
			
			// 3. name�� ������ Context���� Resource������ ȹ���ϱ�
			ds = (DataSource) context.lookup("jdbc/oracle_test");
			
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
	}
	
	// DBCP�� ����� Ŀ�ؼ� ������
	public Connection getConnection() throws SQLException {
		return ds.getConnection(); // �������� data source���� connection�� �����´�.
	}
	
	
}
