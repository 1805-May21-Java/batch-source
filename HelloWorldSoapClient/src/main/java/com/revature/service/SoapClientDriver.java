package com.revature.service;

public class SoapClientDriver {

	public static void main(String[] args) {
		
		HelloWorldImplService helloService = new HelloWorldImplService();
		HelloWorld hello = helloService.getHelloWorldImplPort();
		
		hello.sayHi("hi I'm making this request from the client application");

	}

}
