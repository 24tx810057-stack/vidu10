package vn.iotstart.services.impl;

import java.io.File;
import java.util.List;

import vn.iotstart.daos.CategoryDao;
import vn.iotstart.daos.impl.CategoryDaoImpl;
import vn.iotstart.models.Category;
import vn.iotstart.services.CategoryService;
import vn.iotstart.utils.Constant;

public class CategoryServiceImpl implements CategoryService {

	// Gọi xuống tầng DAO
	CategoryDao categoryDao = new CategoryDaoImpl();

	@Override
	public void insert(Category category) {
		categoryDao.insert(category);
	}

	/*@Override
	public void edit(Category category) {
		categoryDao.edit(category);
	}*/

	@Override
	public void delete(int id) {
		categoryDao.delete(id);
	}

	@Override
	public Category get(int id) {
		return categoryDao.get(id);
	}

	@Override
	public void edit(Category newCategory) {
		//lấy data cũ từ DB
		Category oldCategory = categoryDao.get(newCategory.getId());
		
		//Cập nhật tên mới
		oldCategory.setName(newCategory.getName());
		
		
		if (newCategory.getIcon() != null) {
			// XOA ANH CU DI
			String fileName = oldCategory.getIcon();
			final String dir = "D:\\upload";
			File file = new File(Constant.class + "/category/" + fileName);
			if (file.exists()) {
				file.delete();
			}
			
			oldCategory.setIcon(newCategory.getIcon());
		}
		categoryDao.edit(oldCategory);
	}

	@Override
	public Category get(String name) {
		return categoryDao.get(name);
	}

	@Override
	public List<Category> getAll() {
		return categoryDao.getAll();
	}

	@Override
	public List<Category> search(String catename) {
		return categoryDao.search(catename);
	}
}
