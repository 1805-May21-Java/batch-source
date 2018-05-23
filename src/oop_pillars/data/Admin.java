package oop_pillars.data;

public class Admin implements User{
	
	private String name;
	
	public Admin (String name) {
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
		return true;
	}

	@Override
	public Boolean getAdminPrivileges() {
		return true;
	}

}
