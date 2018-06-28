package com.revature.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import com.revature.beans.Calculator;

@Aspect
@Component
public class myLogger {
	
	private static Logger log = Logger.getRootLogger();
	
	@AfterReturning(pointcut = "within(com.revature.beans.Calculator)")
	public void logMethod(JoinPoint jp) {
		log.info(jp.getSignature());
	}
	
	@AfterReturning(pointcut = "within(com.revature.beans.Calculator)", returning="result")
	public void logAritmatic(JoinPoint jp, Object result) {
		log.info(result);
	}
	
	@Before("execution(String div(int, int))")
	public void testDiv(JoinPoint jp) throws Exception{
		if((Integer) jp.getArgs()[1]==0) {
			Exception divideByZeroException = new Exception("Cannot divide by 0");
			log.error(divideByZeroException);
			throw divideByZeroException;
		}
	}
}
