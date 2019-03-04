package what.the.bus.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Aspect
@Service
public class LogAdvice extends HandlerInterceptorAdapter {
	private static Logger logger = LoggerFactory.getLogger(LogAdvice.class);

	@Pointcut("execution(* what.the.bus..*Impl.*(..))")
	public void allPointcut() {
	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 현재 시간을 가져온다
		long currentTime = System.currentTimeMillis();
		// 컨트롤러 -> DS : 응답을 받아주기 위헤
		// 현재 시간을 모델에 넣는다.
		request.setAttribute("bTime", currentTime);
		return true;
	}

	@Before("allPointcut()")
	public void afterCompletion(JoinPoint jp) throws Exception {
		//System.out.println("AOP 실행중!");
		// View를 리턴하기 직전 실행 됨
		// 현재 시간을 구한다.

		long currentTime = System.currentTimeMillis();
		HttpServletRequest request = null;
		HttpServletResponse response = null;
		Object handler = null;
		Exception ex = null;
		for (Object o : jp.getArgs()) {
			if (o instanceof HttpServletRequest) {
				request = (HttpServletRequest) o;
			}
			if (o instanceof HttpServletResponse) {
				response = (HttpServletResponse) o;
			}
			if (o instanceof Object) {
				handler = (Object) o;
			}
			if (o instanceof Exception) {
				ex = (Exception) o;
			}
		} // 요청이 시작된 시간을 가져온다
			// long beginTime = (long) request.getAttribute("bTime");

		// 현재 시간에서 요청이 시작된 시간을 뺀다. // --> 총 처리 시간을 구한다.
		// long processedTime = currentTime - beginTime;

		/*
		 * // 대부분 실무에서는 debug, info만을 사용 logger.trace("Trace 입니다."); // 보안상 중요한 자료 - 로그인
		 * 과정에서 이사람이 보내준 id와 pwd의 로그 logger.debug("Debug 입니다."); // 다른 사람들이 굳이 봐도 쓸모 없는
		 * 것들 - 로그인 성공인지 실패인지, 언제했는지 logger.info("Info 입니다."); logger.warn("Warn 입니다.");
		 * logger.error("Error 입니다.");
		 */

		String method = jp.getSignature().getName();
		// logger.info("요청된 URL : " + request.getRequestURI());
		// logger.info(method + "요청 리턴값 : " + handler.toString());
		// logger.info("총 처리 시간은 " + processedTime);

		logger.info(jp.getSignature().toString());
		super.afterCompletion(request, response, handler, ex);

	}
}
