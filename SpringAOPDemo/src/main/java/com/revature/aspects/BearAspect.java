package com.revature.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.revature.beans.Bear;

@Aspect
@Component
public class BearAspect {
	
	@Before("execution(* bearHibernates())")
	public void stockedUpForWinter(JoinPoint jp) {
		Bear b = (Bear) jp.getTarget();
		if(b.isFull()) {
			System.out.println("Bear was stocked up and ready for winter.");
		}else {
			System.out.println("Bear is going to be hungry when he wakes up");
		}
	}
	
	@Around("execution(* wake())")//is wildcard for parameters and values
	public void wakeAnimal(ProceedingJoinPoint jpx) {
		Bear b = (Bear) jpx.getTarget();
		try {
			jpx.proceed();
		}catch (Throwable e) {
			e.printStackTrace();
		}
		if(b.isFull() || b.isAwake()) {
			System.out.println("You got lucky");
		}else {
			System.out.println("You became lunch");
		}
	}
	

}
