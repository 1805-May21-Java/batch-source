package com.revature.dao;
import java.util.Map;
import com.revature.pojos.UserInfo;

//It's an interface
public interface UserInfoDao
{
	public Map<String,UserInfo> getUserInfo();
	public UserInfo getUserById(int id);
	public int createUser(UserInfo user);
	public int updateUser(UserInfo user);
	public int deleteUser(UserInfo user);
}
