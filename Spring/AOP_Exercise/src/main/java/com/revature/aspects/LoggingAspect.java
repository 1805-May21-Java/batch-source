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
public class LoggingAspect {
	private static Logger log = Logger.getRootLogger();
	
	@AfterReturning(pointcut = "within(com.revature.beans.*)", returning = "result")
	public void logAfter(JoinPoint jp, Object result) {
		String operation = "";
		switch(jp.getSignature().getName()) {
		case "add":
			operation = "+";
			break;
		case "subtract":
			operation = "-";
			break;
		case "multiply":
			operation = "*";
			break;
		case "divide":
			operation = "/";
			break;
		}
		log.info(jp.getSignature());
		log.info(jp.getArgs()[0] + " " + operation + " " + jp.getArgs()[1] + " = " +  result);
	}
	
	@Around("execution(* divide(..))")
	public Double preventDivideByZero(ProceedingJoinPoint jpx) throws Throwable {
		if((Double)jpx.getArgs()[1] == 0) {
			log.error("Cannot divide by 0.");
		} else {
			return (Double)jpx.proceed();
		}
		return Double.POSITIVE_INFINITY;
	}
}
