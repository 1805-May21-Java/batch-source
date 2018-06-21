package com.revature.app;

import java.util.List;
import java.util.ArrayList;

import com.revature.dao.ERSDaoImpl;
import com.revature.pojos.EmployeeInfo;
import com.revature.pojos.ManagerInfo;

public class Test {
	public static void main(String[] args) {
		ERSDaoImpl edi = new ERSDaoImpl();
		ManagerInfo mi = edi.findManByUP("MAN123", "1234");
		System.out.println(mi);
	}
}
