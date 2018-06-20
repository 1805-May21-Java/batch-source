package com.revature.util;

public final class ERSContract {

	
	 //Employee table
	 public static final String EMPLOYEE_TABLE_NAME = "ERS_EMPLOYEE";
	 public static final String EMPLOYEE_ID = "EMPLOYEE_ID";
	 public static final String EMPLOYEE_NAME ="EMPLOYEE_NAME";
	 public static final String EMPLOYEE_EMAIL = "EMAIL";
	 public static final String EMPLOYEE_PASSWORD = "PASSWORD";
	 public static final String EMPLOYEE_MANAGER_ID = "MANAGER_ID";
	 
	 //Reimbursement table
	 public static final String REIMBURSEMENT_TABLE_NAME = "ERS_REIMBURSEMENT";
	 public static final String REIMBURSEMENT_ID = "REIMBURSEMENT_ID";
	 public static final String REIMBURSEMENT_NAME = "REIMBURSEMENT_NAME";
	 public static final String REIMBURSEMENT_AMOUNT = "AMOUNT";
	 public static final String REIMBURSEMENT_STATUS = "STATUS";
	 public static final String REIMBURSEMENT_DESCRIPTION = "DESCRIPTION";
	 public static final String REIMBURESMENT_EMPLOYEE_ID = "EMPLOYEE_ID";
	 public static final String PHOTO = "PICTURE";
	 
	 //Status for reimbursements
	 public static final int DENY = -1;
	 public static final int PENDING = 0;
	 public static final int APPROVED = 1;
}
