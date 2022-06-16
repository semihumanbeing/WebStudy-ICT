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

		//객체가 없으면 생성해라 호출된 한번만 객체를 생성
		if (single == null)
			single = new DBService();

		return single;
	}

	//외부에서 객체를 생성하지 못하게 막음
	private DBService() {
		// JNDI(java naming directory(검색) interface) 인터페이스를 검색해서 얻어내는 기술 
		try {
			
			// 1. InitialContext 생성
			InitialContext ic = new InitialContext();
			
			// 2. Resource의 저장소 Context정보를 구하기
			Context context = (Context) ic.lookup("java:comp/env"); //context.xml의 위치를 구해준다.
			
			// 3. name을 가지고 Context내의 Resource정보를 획득하기
			ds = (DataSource) context.lookup("jdbc/oracle_test");
			
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
	}
	
	// DBCP에 저장된 커넥션 얻어오기
	public Connection getConnection() throws SQLException {
		return ds.getConnection(); // 전역변수 data source에서 connection을 가져온다.
	}
	
	
}
