package com.revature.aspect;

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
public class LoggingAspect {

	private static Logger log = Logger.getRootLogger();
	
	@AfterReturning(pointcut = "execution(public int com.revature.beans.Calculator.add())", returning="result") //when and where this advice is injected
	public void logAfter1(JoinPoint jp, int result) {
		Calculator c = (Calculator) jp.getTarget();
		log.info(c.getNum1() + " + " + c.getNum2() + " = " + result);
	}
	
	@AfterReturning(pointcut = "execution(public int com.revature.beans.Calculator.subtract())", returning="result") //when and where this advice is injected
	public void logAfter2(JoinPoint jp, int result) {
		Calculator c = (Calculator) jp.getTarget();
		log.info(c.getNum1() + " - " + c.getNum2() + " = " + result);
	}
	
	@AfterReturning(pointcut = "execution(public int com.revature.beans.Calculator.multiply())", returning="result") //when and where this advice is injected
	public void logAfter3(JoinPoint jp, int result) {
		Calculator c = (Calculator) jp.getTarget();
		log.info(c.getNum1() + " * " + c.getNum2() + " = " + result);
	}
	
	@AfterReturning(pointcut = "execution(public int com.revature.beans.Calculator.divide())", returning="result") //when and where this advice is injected
	public void logAfter4(JoinPoint jp, int result) {
		Calculator c = (Calculator) jp.getTarget();
		if(c.getNum2() != 0) {
			log.info(c.getNum1() + " / " + c.getNum2() + " = " + result);
		}
	}
	@Around("execution(public int com.revature.beans.Calculator.divide())")
	public int logAfter5(ProceedingJoinPoint jpx) {
		Calculator c = (Calculator) jpx.getTarget();
		if(c.getNum2() != 0) {
			try {
				return (Integer) jpx.proceed();
				
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			log.error("You can't divid by zero!");
		}
		return 0;
	}
}
