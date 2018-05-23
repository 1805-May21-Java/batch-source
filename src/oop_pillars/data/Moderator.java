package oop_pillars.data;

public class Moderator implements User{
	
	private String name;
	
	public Moderator (String name) {
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
		return false;
	}

}
