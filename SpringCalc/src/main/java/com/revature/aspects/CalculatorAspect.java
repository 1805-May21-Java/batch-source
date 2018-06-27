package com.revature.aspects;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CalculatorAspect {

	public static Logger logger = Logger.getRootLogger();
	
	
	//prevent division
	@Around("execution(* divide(..))")
	//@Around("com.revature.beans.Calculator.divide(..)")
	public double stopDivisionZero(ProceedingJoinPoint proceedingJoinPoint) {
		Object[] args = proceedingJoinPoint.getArgs();
		if(Double.parseDouble(args[1].toString()) == 0.0) {
			System.out.println("Cannot divide by 0!");
		}else {
			try {
				return (double) proceedingJoinPoint.proceed();
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
	
	@AfterReturning(pointcut="within(com.revature.beans.Calculator)",returning="result")
	public void showMethod(JoinPoint joinPoint,double result) {
		String signature = joinPoint.getSignature().toShortString();
		logger.info(signature);
		Object[] args = joinPoint.getArgs();
		char symbol;
		switch (signature.substring(11,12)) {
		//tests for a, s, m,d and changes the symbol to be appropriate to that
		case "a":
			symbol = '+';
			break;
		case "s":
			symbol = '-';
			break;
		case "m":
			symbol = '*';
			break;
		case "d":
			symbol = '/';
			break;
		default:
			//shouldn't get here
			symbol = ' ';
			break;
		}
		logger.info(String.format("%s %s %s = %s", args[0],symbol,args[1],result));
	}
}
