package com.revature.dao;
import java.util.*;
import com.revature.pojos.*;

public interface UserInfoDao
{
	public Map<String,UserInfo> getUserInfo();
	public UserInfo getUserById(int id);
	public int updateUser(UserInfo ui);
	public int createUser(UserInfo ui);
	public int deleteUser(UserInfo ui);
}
