package com.revature.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	private static Logger log = Logger.getRootLogger();
	
	
	@Around("execution(* divide(..))")
	public int attemptDivide(ProceedingJoinPoint jpx) throws Throwable {
		if(Integer.parseInt(jpx.getArgs()[1].toString()) == 0) {
			log.error("Divide by 0 error");
			return 0;
		} else {
			return (Integer) jpx.proceed();
		}
	}
	
	@AfterReturning(pointcut="within(com.revature.beans.Calculator)", returning="result")
	public void logIt(JoinPoint jp, int result) {
		log.info(jp.getSignature());
		String string = jp.getArgs()[0].toString();
		if(jp.getSignature().toString().contains("add")) {
			string+=" + ";
		} else if(jp.getSignature().toString().contains("subtract")) {
			string+=" - ";
		} else if(jp.getSignature().toString().contains("multiply")) {
			string+=" * ";
		} else if(jp.getSignature().toString().contains("divide")) {
			string+=" / ";
		} else if(jp.getSignature().toString().contains("mod")) {
			string+=" % ";
		} else if(jp.getSignature().toString().contains("xor")) {
			string+=" ^ ";
		}
		
		string+=jp.getArgs()[1].toString()+" = "+result;
		
		
		log.info(string);
		
	}

}
