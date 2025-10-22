package vn.iotstart.services;

import vn.iotstart.models.UserModel;

public interface UserService {
	public void insert(UserModel user);

	boolean register(UserModel user);

	boolean checkExistEmail(String email);

	boolean checkExistUsername(String username);

	boolean checkExistPhone(String phone);

	UserModel findByUser(String username);

	UserModel login(String username, String password);
}
