package com.revature.htulipan.springbeans.aspects;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.revature.htulipan.springbeans.beans.Calculator;

@Aspect
@Component
public class LoggerAspect {
	
	private static Logger log = Logger.getRootLogger();
	
	@Before("within(com.revature.htulipan.springbeans.beans.Calculator)")
	public void logCalculatorCall(JoinPoint jp) {
		log.info(jp.getSignature());
	}
	
	@AfterReturning(pointcut = "within(com.revature.htulipan.springbeans.beans.Calculator)",
					returning = "returnValue")
	public void logOperation(JoinPoint jp, Integer returnValue) {
		
		ArrayList<Integer> params = new ArrayList<>();
		String operation = jp.getSignature().getName();
		for (Object o : jp.getArgs()) {
			params.add((Integer) o);
		}
		
		// This is the case of division by 0. Don't print anything.
		if (operation.equals("div") && params.get(1) == 0) {
			return;
		}
		
		switch (operation) {
		case "add":
			log.info(params.get(0).toString() + " + " + params.get(1).toString() + " = " + returnValue);
			break;
		case "sub":
			log.info(params.get(0).toString() + " - " + params.get(1).toString()  + " = " + returnValue);
			break;
		case "mul":
			log.info(params.get(0).toString() + " * " + params.get(1).toString()  + " = " + returnValue);
			break;
		case "div":
			log.info(params.get(0).toString() + " / " + params.get(1).toString()  + " = " + returnValue);
			break;
		}
	}
	
	@Around("execution(int div(int, int))")
	public Integer logDivisionError(ProceedingJoinPoint jpx) throws Throwable {
		
		if (((Integer) jpx.getArgs()[1]).equals(0)) {
			log.error("Cannot Divide By Zero");
			return 0;
		} else {
			return ((Integer)jpx.proceed());
		}
		
	}
	
	
}
