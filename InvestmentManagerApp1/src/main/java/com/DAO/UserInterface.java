package com.DAO;
import com.model.User;

public interface UserInterface {
			public int insertUser(User u);
			public User userLogin(String username , String password);
				
}
