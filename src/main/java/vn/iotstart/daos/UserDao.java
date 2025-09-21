package vn.iotstart.daos;

import vn.iotstart.models.UserModel;

public interface UserDao {
	
	void insert(UserModel user);
	
	UserModel login(String username, String password);

	boolean checkExistEmail(String email);

	boolean checkExistPhone(String phone);

	boolean checkExistUsername(String username);

	UserModel findByUser(String username);
}
