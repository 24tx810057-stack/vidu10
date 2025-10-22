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

    //  register bằng object UserModel
    @Override
    public boolean register(UserModel user) {
        // Kiểm tra username trùng
        if (userDao.checkExistUsername(user.getUsername())) {
            return false;
        }

        // Lấy ngày hiện tại
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        user.setCreatedate(date);

        // Set roleid mặc định cho user (2 = user)
        user.setRoleid(2);

        // Gọi insert xuống DAO
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
