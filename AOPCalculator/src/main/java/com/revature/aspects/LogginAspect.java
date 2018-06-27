package com.revature.aspects;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.revature.beans.Calculator;

@Aspect
@Component
public class LogginAspect {
	
	
	private static Logger log = Logger.getRootLogger();
	
	
	@AfterReturning (pointcut = "within(com.revature.beans.*)", returning="result")
	public void logAfter(JoinPoint jp, double result) {
		log.info(jp.getSignature());
		Object[] args = jp.getArgs();
		if(args[0].equals("add")) {
			args[0] = "+";
		} else if (args[0].equals("subtract")) {
			args[0] = "-";
		} else if (args[0].equals("multiplty")) {
			args[0] = "*";
		} else if (args[0].equals("divide")) {
			args[0] = "/";
		}
		log.info(args[1] + " " + args[0] + " "+ args[2] + "  = " + result);
	}
	
	
	@Around ("execution(double calculate(..))")
	public double logZero(ProceedingJoinPoint jpx) throws Throwable {
		Object[] args = jpx.getArgs();
		if(args[2].equals(0.0)) {
			log.info(jpx.getSignature());
			log.error("Can't divide by zero");
			return 0;
		} else {
			return (Double) jpx.proceed();
		}
		
	}
	
	
	

}
