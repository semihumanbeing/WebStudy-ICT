package advice;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.springframework.beans.factory.annotation.Autowired;

public class Advice {
	
	// Advice��ü�� ���������Ǹ� @Autowired�� ���� �ʴ´�.
	// context-7-myaop���� <context:annotation-config/> ���ش�.
	@Autowired
	HttpServletRequest request;
	
	public void before(JoinPoint jp){
		Signature s =  jp.getSignature();
		
		long start = System.currentTimeMillis();
		request.setAttribute("start", start);
		
		System.out.println("----before:" + s);
	}
	
	public void after(JoinPoint jp){
		Signature s =  jp.getSignature();
		
		long end = System.currentTimeMillis();
		long start = (long) request.getAttribute("start");
				
		System.out.println("----after:" + s.toLongString());
		System.out.printf("����ð�: %s(ms)\n", end-start);
	}
}
