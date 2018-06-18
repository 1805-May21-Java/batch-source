package com.revature.pojos;

import java.sql.*;
import java.util.Date;

public class Reimbursement {
	private int r_ID;
	private int mod_ID;
	private int amount;
	private String reason;
	private Date date_Made;
	private Date date_Modi;
	private int stateNum;
	private int e_ID;
	private int type_ID;
	
	public int getR_ID() {
		return r_ID;
	}
	public void setR_ID(int r_ID) {
		this.r_ID = r_ID;
	}
	public int getMod_ID() {
		return mod_ID;
	}
	public void setMod_ID(int mod_ID) {
		this.mod_ID = mod_ID;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public Date getDate_Made() {
		return date_Made;
	}
	public void setDate_Made(Date date_Made) {
		this.date_Made = date_Made;
	}
	public Date getDate_Modi() {
		return date_Modi;
	}
	public void setDate_Modi(Date date_Modi) {
		this.date_Modi = date_Modi;
	}
	public int getStateNum() {
		return stateNum;
	}
	public void setStateNum(int stateNum) {
		this.stateNum = stateNum;
	}
	public int getE_ID() {
		return e_ID;
	}
	public void setE_ID(int e_ID) {
		this.e_ID = e_ID;
	}
	public int getType_ID() {
		return type_ID;
	}
	public void setType_ID(int type_ID) {
		this.type_ID = type_ID;
	}
	
	public Reimbursement() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Reimbursement(int r_ID, int mod_ID, int amount, String reason, Date date_Made, Date date_Modi, int stateNum,
			int e_ID, int type_ID) {
		super();
		this.r_ID = r_ID;
		this.mod_ID = mod_ID;
		this.amount = amount;
		this.reason = reason;
		this.date_Made = date_Made;
		this.date_Modi = date_Modi;
		this.stateNum = stateNum;
		this.e_ID = e_ID;
		this.type_ID = type_ID;
	}
	
	@Override
	public String toString() {
		return "Reimbursement [r_ID=" + r_ID + ", mod_ID=" + mod_ID + ", amount=" + amount + ", reason=" + reason
				+ ", date_Made=" + date_Made + ", date_Modi=" + date_Modi + ", stateNum=" + stateNum + ", e_ID=" + e_ID
				+ ", type_ID=" + type_ID + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + amount;
		result = prime * result + ((date_Made == null) ? 0 : date_Made.hashCode());
		result = prime * result + ((date_Modi == null) ? 0 : date_Modi.hashCode());
		result = prime * result + e_ID;
		result = prime * result + mod_ID;
		result = prime * result + r_ID;
		result = prime * result + ((reason == null) ? 0 : reason.hashCode());
		result = prime * result + stateNum;
		result = prime * result + type_ID;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reimbursement other = (Reimbursement) obj;
		if (amount != other.amount)
			return false;
		if (date_Made == null) {
			if (other.date_Made != null)
				return false;
		} else if (!date_Made.equals(other.date_Made))
			return false;
		if (date_Modi == null) {
			if (other.date_Modi != null)
				return false;
		} else if (!date_Modi.equals(other.date_Modi))
			return false;
		if (e_ID != other.e_ID)
			return false;
		if (mod_ID != other.mod_ID)
			return false;
		if (r_ID != other.r_ID)
			return false;
		if (reason == null) {
			if (other.reason != null)
				return false;
		} else if (!reason.equals(other.reason))
			return false;
		if (stateNum != other.stateNum)
			return false;
		if (type_ID != other.type_ID)
			return false;
		return true;
	}
	
	
}
