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
	
	private static Logger logger = Logger.getRootLogger();
	
	@AfterReturning(pointcut = "within(com.revature.beans.Calculator)", returning="result") 
	public void logAfter(JoinPoint jp, double result) {
		logger.info(jp.getSignature()); 
//		System.out.println(jp.getSignature());
//		System.out.println(jp.getSignature().getName());
//		System.out.println(jp.getArgs()[0]);
//		System.out.println(jp.getSignature().getDeclaringTypeName());
//		System.out.println(jp.getSignature().getModifiers());
//		System.out.println(result);
		
		String operation = jp.getSignature().getName();
		
		if (operation.equals("add")) {
			logger.info(operation + ": " + jp.getArgs()[0] + " + " + jp.getArgs()[1] + " = " + result);
		} else if (operation.equals("subtract")) {
			logger.info(operation + ": " + jp.getArgs()[0] + " - " + jp.getArgs()[1] + " = " + result);
		} else if (operation.equals("multiply")) {
			logger.info(operation + ": " + jp.getArgs()[0] + " * " + jp.getArgs()[1] + " = " + result);
		} else { // division
			if (jp.getArgs()[1].equals(0)) {
				logger.error("can't divide by zero!");
			} else {
				logger.info(operation + ": " + jp.getArgs()[0] + " / " + jp.getArgs()[1] + " = " + result);
			}
		}
	}
	
	
	@Around("within(com.revature.beans.Calculator)")
	public double logAfter(ProceedingJoinPoint jpx) throws Throwable {
		String operation = jpx.getSignature().getName();
		double b = (Double) jpx.getArgs()[1];
		double result; // returns with nothing or the division quotient
		if (operation.equals("divide") && b == 0) {
			logger.error("DIVISION BY ZERO");
			System.out.println("divide by zero");
			result = 0;
		} else {
			result = (Double) jpx.proceed();
			logger.info(operation + ": " + jpx.getArgs()[0] + " / " + b + " = " + result);
		}
		return result;
	}
	

}
