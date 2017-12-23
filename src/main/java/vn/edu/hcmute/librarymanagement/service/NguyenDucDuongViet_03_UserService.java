/**
 * 
 */
package vn.edu.hcmute.librarymanagement.service;

import java.util.List;

import vn.edu.hcmute.librarymanagement.dto.book.NguyenDucDuongViet_03_UserDTO;

/**
 * @author Nguyen Duc Duong Viet
 *
 *         Dec 13, 2016
 * 
 *         Service for UserController
 *         
 *         Define function about User
 */
public interface NguyenDucDuongViet_03_UserService {
	/**
	 * @return All user
	 */
	public List<NguyenDucDuongViet_03_UserDTO> findAll();

	/**
	 * @param userId
	 * @return User by id
	 */
	public NguyenDucDuongViet_03_UserDTO findUserById(int userId);


	/**
	 * @param user
	 * @return true if save or update success
	 */
	public boolean saveOrUpdate(NguyenDucDuongViet_03_UserDTO user);

	/**
	 * @param user
	 * @return true if delete success
	 */
	public boolean delete(int userId);

	/**
	 * @param username
	 * @param password
	 * @return user if exist
	 */
	public NguyenDucDuongViet_03_UserDTO findByUsernameAndPassword(String username, String password);
	
	/**
	 * @param username
	 * @return true if exist
	 */
	public boolean checkUsernameIsExist(String username);
	
	/**
	 * @return List student in database
	 */
	public List<NguyenDucDuongViet_03_UserDTO> getAllStudent();
}
