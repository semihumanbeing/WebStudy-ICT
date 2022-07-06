package advice;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.springframework.beans.factory.annotation.Autowired;

public class Advice {
	
	// Advice객체가 수동생성되면 @Autowired가 되지 않는다.
	// context-7-myaop에서 <context:annotation-config/> 해준다.
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
		System.out.printf("수행시간: %s(ms)\n", end-start);
	}
}
