package com.revature.pojos;

import java.util.HashMap;
import java.util.Map;

public enum ReimbursementType {
	MEDICAL(1), SUPPLIES(2), VACATION(3), TRAINING(4), RELOCATION(5);
	private final int id;
	private ReimbursementType(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	private static Map<Integer, ReimbursementType> map = new HashMap<Integer, ReimbursementType>();
	static {
		for(ReimbursementType r : ReimbursementType.values()) {
			map.put(r.id, r);
		}
	}
	public static ReimbursementType valueOf(int id) {
		return map.get(id);
	}
}
