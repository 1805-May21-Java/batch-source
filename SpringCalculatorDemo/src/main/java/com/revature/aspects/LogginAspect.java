package com.revature.aspects;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.revature.beans.Calculator;

@Aspect
@Component
public class LogginAspect {
	private static Logger log = Logger.getRootLogger();
	
	@AfterReturning(pointcut = "execution(public int com.revature.beans.Calculator.*())", returning="result")
	public void logAfter(JoinPoint jp, int result) {
		Calculator c = (Calculator) jp.getTarget();
		String methodName = jp.getSignature().getName();
		if(methodName.equals("add")) {
			log.info(c.getX() + " + " + c.getY() + " = " + result);
		}else if(methodName.equals("subtract")) {
			log.info(c.getX() + " - " + c.getY() + " = " + result);
		}else if(methodName.equals("multiplication")) {
			log.info(c.getX() + " * " + c.getY() + " = " + result);
		}else {
			log.info(c.getX() + " / " + c.getY() + " = " + result);
		}
	}
	
	@Around("execution(* com.revature.beans.Calculator.division())")
	public Integer handleDivide(ProceedingJoinPoint jpx) {
		Calculator c = (Calculator) jpx.getTarget();
		int divider = c.getY();
		if(divider == 0) {
			log.error("Cannot divide by zero");
		}else {
			try {
				return (Integer)jpx.proceed();
			}catch(Throwable e) {
				e.printStackTrace();
			}
		}
		return -1;
	}
	
}
