package com.DAO;
import com.model.User;

public interface UserInterface {
			public int insertUser(User u);
			public boolean userLogin(String username , String password);
				
}
