package com.revature.main;

import java.io.PrintWriter;
import java.util.List;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import com.revature.model.Firework;
import com.revature.service.FireworksStore;

public class ClientDriver {
	
	public static void main(String[] args) {
		
		//String serviceUrl = "http://localhost:8082/SOAPFireworksService/FireworksStore";
		String serviceUrl = "http://fireworkssoap.us-west-2.elasticbeanstalk.com/FireworksStore";
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.setServiceClass(FireworksStore.class);
		factory.setAddress(serviceUrl);
		
		LoggingInInterceptor inInterceptor = new LoggingInInterceptor();
		LoggingOutInterceptor outInterceptor = new LoggingOutInterceptor();
		
		factory.getInInterceptors().add(inInterceptor);
		factory.getOutInterceptors().add(outInterceptor);
		
		inInterceptor.setPrintWriter(new PrintWriter(System.out));
		outInterceptor.setPrintWriter(new PrintWriter(System.out));
		
		FireworksStore fs = (FireworksStore) factory.create();
		List<Firework> fireworkList = fs.getAllFireworks();
		for(Firework f : fireworkList) {
			System.out.println(f);
		}
		
		Firework f1 = new Firework("TNT Poppers", "Colorless", 1);
		System.out.println(fs.addFirework(f1));
		
		//Firework f2 = new Firework("Molotav", "Orange", 10000);
		//System.out.println(fs.addFirework(f2));
		
		Firework f3 = new Firework("Kaboomer", "Mixed", 8000);
		System.out.println(fs.launchFirework(f3));
		Firework f4 = new Firework("Sparkler", "Mixed", 1);
		System.out.println(fs.launchFirework(f4));
		
		System.out.println(fs.launchAllFireworks(fireworkList));
	}

}
