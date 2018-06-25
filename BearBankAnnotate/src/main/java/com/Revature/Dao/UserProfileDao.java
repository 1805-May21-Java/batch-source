package com.Revature.Dao;

import com.Revature.pojos.UserProfile;

public interface UserProfileDao {
	public int createUserProfile(UserProfile up) throws Exception; // Creates a new user
	
	public boolean checkUsername(String username ) throws Exception;

	public UserProfile getUserProfile(String username, String password) throws Exception; // Returns existing user

	public int updateUserProfile(UserProfile up) throws Exception; // Updates user password

	public int deleteUserProfile(String username) throws Exception; // Deletes a user and all single-owned bank accounts and links

}
