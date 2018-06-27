package com.adora.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;



@Aspect
@Component
public class CalculatorLoggingAspect {

	private static Logger log = Logger.getRootLogger();
	
	@Around("within(com.adora.beans.Calculator)")
	public double logOperation(ProceedingJoinPoint jpx ) throws Throwable {
		String operation = jpx.getSignature().getName();
		Object args[] =  jpx.getArgs();

		
		String operationSymbol = "";
		Double result = Double.POSITIVE_INFINITY;
		
		switch(operation) {
			case "add":
				operationSymbol = "+";
				break;
			case "subtract":
				operationSymbol = "-";
				break;
			case "multiply":
				operationSymbol = "*";
				break;
			case "divide":
				operationSymbol = "/";
				break;
		}
			
		if(operationSymbol.equals("/") && Double.parseDouble(args[1].toString()) == 0.0) {
			log.error( "please do not divide by zero.");
		} else {		
			result = (Double) jpx.proceed();
			log.info(  args[0] +  " " + operationSymbol + " " + args[1] + " = " + result);
		}
		
		return result;
	}
	
	
}
