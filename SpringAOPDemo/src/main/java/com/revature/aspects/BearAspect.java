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
	public void stockedUpForWinter(JoinPoint jPoint) {
		Bear bear = (Bear) jPoint.getTarget();
		if (bear.isFull()) {
			System.out.println("Bear was stocked up and ready for winter");
		} else {
			System.out.println("Bear is going to be hungry when he wakes up");
		}
	}
	
	@Around("execution(* wake*())") // * is a wildcard for values/parameters
	public void wakeAnimal(ProceedingJoinPoint jpx) throws Throwable {
		Bear bear = (Bear) jpx.getTarget();
		if (bear.isFull() || !bear.isAwake()) {
			System.out.println("You got lucky");
		} else {
			System.out.println("You became lunch");
		}
		jpx.proceed();
	}
}
