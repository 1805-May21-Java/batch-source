package com.revature.aspects;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	private static Logger logger = Logger.getRootLogger();
	
	@AfterReturning(pointcut = "within(com.revature.beans.*)") // when this advice is injected
	public void logAfter(JoinPoint jp) {
		logger.info(jp.getSignature()); // advice to be injected
	}
	
	@AfterThrowing(pointcut = "within(com.revature.beans.*)")
	public void logAfterException(JoinPoint jp) {
		logger.error(jp.getSignature());
	}
	
	@Before("execution(* bearHibernates())")
	public void hibernateAttempt() {
		logger.info("bear is trying to hibernate");
	}
	
	/*
	 * trace
	 * debug
	 * info
	 * warn
	 * error
	 * fatal
	 * 
	 */

}
