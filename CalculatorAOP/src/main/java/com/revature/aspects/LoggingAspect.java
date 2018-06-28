package com.revature.aspects;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	private static Logger log = Logger.getRootLogger();

	@AfterReturning(pointcut = "within(com.revature.beans.*)", returning = "result")
	public void logAfter(JoinPoint jp, int result) {
		
		log.info(jp.getSignature());
		log.info(jp.getSignature().getName());
		Object[] arr = jp.getArgs();
		
		if(jp.getSignature().getName() == "add"){
			log.info(arr[0]+"+"+arr[1]+"= "+result);
		}
		if(jp.getSignature().getName() == "subtract"){
			log.info(arr[0]+"-"+arr[1]+"= "+result);
		}
		if(jp.getSignature().getName() == "multiply"){
			log.info(arr[0]+"*"+arr[1]+"= "+result);
		}
		if(jp.getSignature().getName() == "divide") { 
			log.info(arr[0]+"/"+arr[1]+"= "+result);
		}
	}
	
	@Around("execution(* divide(int, int))")
	public int divErrorLog(ProceedingJoinPoint jpx) {
		Object[] arr = jpx.getArgs();
		if((Integer)arr[1] != 0) {
			try {
				return (Integer) jpx.proceed();
			} 
			catch (Throwable  e) {
				e.printStackTrace();
			}
		}else {
			log.error("You cannot divide by 0");
		}
		return 0;
	}
	
	
}
