package com.revature.pojos;
import java.util.HashMap;
import java.util.Map;
public enum ReimbursementStatus {
	PENDING(1), DENIED(2), APPROVED(3);
	private final int id;
	private ReimbursementStatus(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	private static Map<Integer, ReimbursementStatus> map = new HashMap<Integer, ReimbursementStatus>();
	static {
		for(ReimbursementStatus r : ReimbursementStatus.values()) {
			map.put(r.id, r);
		}
	}
	public static ReimbursementStatus valueOf(int id) {
		return map.get(id);
	}
}
