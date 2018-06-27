package com.revature.aspects;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.*;

@Aspect
@Component
public class LoggingAspect
{
	private static Logger log = Logger.getRootLogger();
	
    @AfterReturning(pointcut = "within(com.revature.beans.*)") //when/where this advice is injected
    public void logAfter(JoinPoint jp) {
    	log.info(jp.getSignature()); //advice to be injected
    }
    
    @AfterThrowing(pointcut = "within(com.revature.beans.*)")
    public void logError(JoinPoint jp) {
    	log.error(jp.getSignature());
    }
    
    @AfterReturning(pointcut="execution(double add(..))", returning="returnValue")
    public void logAddResult(JoinPoint jp, Object returnValue) {
    	Object[] args = jp.getArgs();
    	if(returnValue != null) {
    		log.info(args[0] + " + " + args[1] + " = " + returnValue);
    	}
    }
    
    @AfterReturning(pointcut="execution(double subtract(..))", returning="returnValue")
    public void logSubtractResult(JoinPoint jp, Object returnValue) {
    	Object[] args = jp.getArgs();
    	if(returnValue != null) {
    		log.info(args[0] + " - " + args[1] + " = " + returnValue);
    	}
    }
    
    @AfterReturning(pointcut="execution(double multiply(..))", returning="returnValue")
    public void logMultiplyResult(JoinPoint jp, Object returnValue) {
    	Object[] args = jp.getArgs();
    	if(returnValue != null) {
    		log.info(args[0] + " * " + args[1] + " = " + returnValue);
    	}
    }
    
    @Around(value="execution(* divide(..))")
    public double checkZero(ProceedingJoinPoint jpx) throws Throwable {
    	Object[] args = jpx.getArgs();
    	Object returnValue = 0.0;
    	double arg = (Double)args[1];
    	if(arg != 0) {
    		returnValue = jpx.proceed();
        	log.info(args[0] + " / " + args[1] + " = " + returnValue);
    	}
    	else {
    		log.error("Dividing by zero.");
    	}
    	return (Double)returnValue;
    }
}
