package com.revature.pojos;

import java.util.HashMap;
import java.util.Map;

//this class will be an enum class
// we will use a map for this
public enum Role {
	EMPLOYEE(1),MANAGER(2);
	private final int id;
	private Role(int id) { //private constructor taking in id
		this.id = id;
	}
	public int getId() {
		return id;
	}
	private static Map<Integer, Role> map = new HashMap<Integer, Role>();
	static {
		for (Role r : Role.values()) {
			map.put(r.id, r);
		}
	}
	public static Role valueOf(int id) {
		return map.get(id);
	}
}
