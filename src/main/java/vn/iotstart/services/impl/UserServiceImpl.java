package vn.iotstart.services.impl;

import vn.iotstart.daos.UserDao;
import vn.iotstart.daos.impl.UserDaoImpl;
import vn.iotstart.models.UserModel;
import vn.iotstart.services.UserService;

public class UserServiceImpl implements UserService {

	UserDao userDao = new UserDaoImpl(); // gọi tất cả phương thức của tầng Dao

	@Override
	public UserModel findByUser(String username) {
		return userDao.findByUser(username);
	}

	@Override
	public UserModel login(String username, String password) {
		UserModel user = this.findByUser(username);

		if (user != null && password.equals(user.getPassword())) {
			return user;
		}
		return null;
	}

	@Override
	public void insert(UserModel user) {
		userDao.insert(user);
	}

	
	
	@Override
	public boolean register(String username, String password, String email, String fullname, String phone) {

		if (userDao.checkExistUsername(username)) {
			return false;
		}
		long millis = System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(millis);

		UserModel user = new UserModel(0, username, password, email, fullname, null, 2, phone, date);
		userDao.insert(user);
		return true;
	}
	
	

	@Override
	public boolean checkExistEmail(String email) {
		return userDao.checkExistEmail(email);
	}

	@Override
	public boolean checkExistUsername(String username) {
		return userDao.checkExistUsername(username);
	}

	@Override
	public boolean checkExistPhone(String phone) {
		return userDao.checkExistPhone(phone);
	}
}
