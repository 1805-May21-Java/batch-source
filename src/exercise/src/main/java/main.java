import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import aspects.LoggerAspect;
import data.Calculator;

public class main {

	public static void main(String[] args) {
		ConfigurableApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		Calculator calculator = ac.getBean(Calculator.class);
		
		System.out.println(calculator.add(1,2));
		System.out.println(calculator.subtract(1,2));
		System.out.println(calculator.multiply(1,2));
		System.out.println(calculator.divide(1,2));
		System.out.println(calculator.divide(1, 0));
		
		ac.close();

	}

}
