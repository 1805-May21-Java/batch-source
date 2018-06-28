package aspects;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.*;

@Aspect
@Component
public class LoggerAspect {
private static Logger log = Logger.getRootLogger();
	
	@AfterReturning(pointcut = "within(data.*)", returning = "result") //when/where this advice is injected
	public void logAfter(JoinPoint jp, double result) {
		String signature = jp.getSignature().toShortString();
		
		Object[] args = jp.getArgs();
		
//		for(Object object: args) {
//			System.out.println(object);
//		}
		log.info(jp.getSignature());
		if(signature.contains("add")) {
			log.info("Calculator adds " + args[0] + " + " + args[1] + " = " + result);
		} else if(signature.contains("subtract")) {
			log.info("Calculator subtracts " + args[0] + " - " + args[1] + " = " + result);
		} else if(signature.contains("multiply")) {
			log.info("Calculator multiplies " + args[0] + " * " + args[1] + " = " + result);
		} else if(signature.contains("divide")) {
			log.info("Calculator divides " + args[0] + " / " + args[1] + " = " + result);
		}
	}
	
	@Around("execution(* divide(..))")
	public double stopDivisionZero(ProceedingJoinPoint proceedingJp) throws NumberFormatException, Throwable {
		Object[] args = proceedingJp.getArgs();
		if(args[1].equals(0.)) {
			log.info("Divided by 0.");;
		}else {
			return Double.parseDouble(proceedingJp.proceed().toString());
		}
		return 0;
	}
		
}
