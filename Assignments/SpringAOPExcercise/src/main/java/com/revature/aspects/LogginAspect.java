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

	@AfterReturning(pointcut="within(com.revature.beans.Calculator)", returning="result")
	public double logResult(JoinPoint jp, Double result)
	{
		Object num[] = jp.getArgs();

		
		if(jp.getSignature().getName().equals("add"))
		{
			log.info(num[0]+"+"+num[1]+" = "+result);
		}
		else if(jp.getSignature().getName().equals("substract"))
		{
			log.info(num[0]+"-"+num[1]+" = "+result);
		}
		else if(jp.getSignature().getName().equals("multiply"))
		{
			log.info(num[0]+"*"+num[1]+" = "+result);
		}
		else if(jp.getSignature().getName().equals("devide"))
		{
			
			Double devider = (Double) num[1];
			if(devider!=0.0)
			{
				log.info(num[0]+"/"+num[1]+" = "+result);
			}else {
				log.error(num[0]+"/"+num[1]+" = Error!!! --Can't be devided by 0");
			}
			
		}
		return 0;
	}
	
	

}
