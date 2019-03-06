package what.the.bus.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import what.the.bus.driver.DriverVO;
import what.the.bus.member.MemberVO;

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

	@Around("allPointcut()")
	public Object afterCompletion(ProceedingJoinPoint jp) throws Throwable {
		String id = null;
		HttpSession session = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest()
				.getSession();
		// HttpServletResponse response = null;
		/*
		 * for (Object o : jp.getArgs()) { if (o instanceof HttpServletRequest) { req =
		 * (HttpServletRequest) o; System.out.println("리퀘스트 받음 : " + req); }
		 */
		try {
			if (session.getAttribute("member").getClass() == MemberVO.class) {
				MemberVO vo = (MemberVO) session.getAttribute("member");
				id = vo.getId();
			}
			if (session.getAttribute("member").getClass() == DriverVO.class) {
				DriverVO vo = (DriverVO) session.getAttribute("member");
				id = vo.getId();
			}
		} catch (Exception e) {

		}
		Object obj = jp.proceed();
		logger.info("id : " + id);
		logger.info(jp.getSignature().toString());
		return obj;
	}

}
