package com.revature.aspects;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.revature.beans.Calculator;

@Aspect
@Component
public class LoggingAspect {

	private static Logger log = Logger.getRootLogger();
	
	@AfterReturning(pointcut = "within(com.revature.beans.*)", returning = "result")
	public void logAfter(JoinPoint jp, int result) {
		
		log.info(jp.getSignature());
		log.info(jp.getSignature().getName());
		Object[] arr = jp.getArgs();
		
		if(jp.getSignature().getName() == "addition"){
			log.info(arr[0]+"+"+arr[1]+"= "+result);
		}
		if(jp.getSignature().getName() == "subtraction"){
			log.info(arr[0]+"-"+arr[1]+"= "+result);
		}
		if(jp.getSignature().getName() == "multiplication"){
			log.info(arr[0]+"*"+arr[1]+"= "+result);
		}
		if(jp.getSignature().getName() == "division") { 
			log.info(arr[0]+"/"+arr[1]+"= "+result);
		}
	}
	
	@Around("execution(* division(..))")
	public Double divisionError(ProceedingJoinPoint jpx){
		
		Object[] arr = jpx.getArgs();
		if((Double)arr[1] != 0){
			
			try {return (Double) jpx.proceed();
			}catch (Throwable  e){
				e.printStackTrace();
			}
		}else{
			log.error("Cannot divide by 0");
		}
		return (double) 0;
	}
	
}
