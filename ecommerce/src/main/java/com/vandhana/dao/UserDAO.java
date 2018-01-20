package com.vandhana.dao;

	import java.util.List;

import com.vandhana.model.User;

public interface UserDAO {
		public void addUser(User user);
		public void upUser(User user);
		public User getUserById(int id);
		public List getAlluser();
		public User getUserByUsername(String username);

		

	}


