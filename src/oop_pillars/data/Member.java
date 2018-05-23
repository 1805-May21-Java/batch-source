package oop_pillars.data;

public class Member implements User{
	
	private String name;
	
	public Member (String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		
	}

	@Override
	public Boolean getModPrivileges() {
		return false;
	}

	@Override
	public Boolean getAdminPrivileges() {
		return false;
	}

}
