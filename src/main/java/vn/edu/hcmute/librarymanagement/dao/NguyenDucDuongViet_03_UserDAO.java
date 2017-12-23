/**
 * 
 */
package vn.edu.hcmute.librarymanagement.dao;

import java.util.List;

import vn.edu.hcmute.librarymanagement.model.NguyenDucDuongViet_03_User;

/**
 * @author Nguyen Duc Duong Viet
 *
 *         Dec 12, 2016
 * 
 *         Define method access to user table
 * 
 */
public interface NguyenDucDuongViet_03_UserDAO {

	/**
	 * @return All user
	 */
	public List<NguyenDucDuongViet_03_User> findAll();
	
	/**
	 * @return All student
	 */
	public List<NguyenDucDuongViet_03_User> findAllStudent();

	/**
	 * @param userId
	 * @return a User by id
	 */
	public NguyenDucDuongViet_03_User findUserById(int userId);
	

	/**
	 * @param user
	 * @return true if save or update user success
	 */
	public boolean saveOrUpdate(NguyenDucDuongViet_03_User user);

	/**
	 * @param user
	 * @return true if delete user success
	 */
	public boolean delete(NguyenDucDuongViet_03_User user);
	
	/**
	 * @param username
	 * @return true if user name exist
	 */
	public boolean checkUsernameIsExist(String username);

	/**
	 * @param username
	 * @param password
	 * @return user if exist
	 */
	public NguyenDucDuongViet_03_User findByUsernameAndPassword(String username, String password);
}
