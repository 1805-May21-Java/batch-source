package com.revature.aspects;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	private static Logger log = Logger.getRootLogger();
	
	@AfterReturning(pointcut = "within(com.revature.beans.*)") //when/where this advice is injected
	public void logAfter(JoinPoint jp) {
		log.info(jp.getSignature()); // advice to be injected
	}
	
	@AfterThrowing(pointcut = "within(com.revature.beans.*)")
	public void logAfterException(JoinPoint jp) {
		log.error(jp.getSignature());
	}
	
	@Before("execution(* bearHibernates())")
	public void hibernateAttempt() {
		log.info("bear is trying to hibernate");
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
