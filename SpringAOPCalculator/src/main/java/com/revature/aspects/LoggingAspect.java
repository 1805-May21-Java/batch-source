package com.revature.aspects;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	private static Logger log = Logger.getRootLogger();
	
	@AfterReturning(pointcut = "within(com.revature.beans.*)") //when/where this advice is injected
	public void logAfter(JoinPoint jp) {
		log.info(jp.getSignature());
	}
	
	@AfterReturning(pointcut="execution(double add(..))", returning = "returnValue") //when/where this advice is injected
	public void logAddition(JoinPoint jp, Object returnValue) {
		Object[] vars = jp.getArgs();
		log.info(vars[0] + " + " + vars[1] + " = " + returnValue); //advice to be injected
	}
	
	@AfterReturning(pointcut="execution(double subtract(..))", returning = "returnValue") //when/where this advice is injected
	public void logSubtraction(JoinPoint jp, Object returnValue) {
		Object[] vars = jp.getArgs();
		log.info(vars[0] + " - " + vars[1] + " = " + returnValue); //advice to be injected
	}
	
	@AfterReturning(pointcut="execution(double multiply(..))", returning = "returnValue") //when/where this advice is injected
	public void logMultiplication(JoinPoint jp, Object returnValue) {
		Object[] vars = jp.getArgs();
		log.info(vars[0] + " * " + vars[1] + " = " + returnValue); //advice to be injected
	}
	
	 @Around(value="execution(* divide(..))")
	    public double checkZero(ProceedingJoinPoint jpx) throws Throwable {
	    	Object[] vars = jpx.getArgs();
	    	Object returnValue = 0.0;
	    	double arg = (Double)vars[1];
	    	if(arg != 0) {
	    		returnValue = jpx.proceed();
	        	log.info(vars[0] + " / " + vars[1] + " = " + returnValue);
	    	}
	    	else {
	    		log.error("Cannot divide by zero.");
	    	}
	    	return (Double)returnValue;
	    }

}
