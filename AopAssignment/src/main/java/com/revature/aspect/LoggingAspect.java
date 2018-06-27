package com.revature.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.*;

@Aspect
@Component
public class LoggingAspect {
	
	public static Logger log = Logger.getRootLogger();
	
//	@AfterReturning(pointcut = "within(com.revature.bean.Calculator)", returning = "val")
//	public void logAfter(JoinPoint jp, double val) {
//		String methodName = jp.getSignature().getName();
//		Object[] args = jp.getArgs();
//		double a = (Double) args[0];
//		double b = (Double) args[1];
//		if(methodName.equals("add"))
//			log.info(a + " + " + b + " = " + val);
//		else if(methodName.equals("sub"))
//			log.info(a + " - " + b + " = " + val);
//		else if(methodName.equals("mul"))
//			log.info(a + " * " + b + " = " + val);
//		else if(methodName.equals("div"))
//			log.info(a + " / " + b + " = " + val);
//	}
//	
//	@AfterThrowing(pointcut = "execution(* div(..))", throwing = "ex")
//	public void logAfterDivByZero(ArithmeticException ex) {
//		log.error(ex.getMessage());
//	}
	
	@Around("within(com.revature.bean.Calculator)")
	public double logAfter(ProceedingJoinPoint jpx) throws Throwable {
		String methodName = jpx.getSignature().getName();
		Object[] args = jpx.getArgs();
		double a = (Double) args[0];
		double b = (Double) args[1];
		char arithType = ':';
		
		if(methodName.equals("add"))
			arithType = '+';
		else if(methodName.equals("sub"))
			arithType = '-';
		else if(methodName.equals("mul"))
			arithType = '*';
		else if(methodName.equals("div"))
			arithType = '/';
		
		double val;
		if(arithType == '/' && b == 0) {
			log.error("stop that");
			val = Double.NaN;
		}
		else {
			val = (Double) jpx.proceed();
			log.info(a + " " + arithType + " " + b + " = " + val);
		}
		return val;
	}
}
