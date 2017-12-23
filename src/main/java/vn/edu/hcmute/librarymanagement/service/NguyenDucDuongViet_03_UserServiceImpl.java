/**
 * 
 */
package vn.edu.hcmute.librarymanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.edu.hcmute.librarymanagement.dao.NguyenDucDuongViet_03_UserDAO;
import vn.edu.hcmute.librarymanagement.dto.book.NguyenDucDuongViet_03_UserDTO;
import vn.edu.hcmute.librarymanagement.model.NguyenDucDuongViet_03_User;

/**
 * @author Nguyen Duc Duong Viet
 *
 *         Dec 14, 2016
 * 
 *         Implement UserService interface
 * 
 */

@Service
public class NguyenDucDuongViet_03_UserServiceImpl implements NguyenDucDuongViet_03_UserService {

	/**
	 * userDAO chứa các hàm truy cập csdl bảng user
	 */
	@Autowired
	private NguyenDucDuongViet_03_UserDAO userDAO;

	/* (non-Javadoc)
	 * @see vn.edu.hcmute.librarymanagement.service.NguyenDucDuongViet_03_UserService#findAll()
	 */
	@Override
	public List<NguyenDucDuongViet_03_UserDTO> findAll() {
		List<NguyenDucDuongViet_03_UserDTO> lstUserDTO = new ArrayList<NguyenDucDuongViet_03_UserDTO>();
		//tìm tất cả user
		List<NguyenDucDuongViet_03_User> lstUser = userDAO.findAll();
		//set dữ liệu
		for (NguyenDucDuongViet_03_User user : lstUser) {
			NguyenDucDuongViet_03_UserDTO userDTO = new NguyenDucDuongViet_03_UserDTO();
			userDTO.setId(user.getId());
			userDTO.setUsername(user.getUsername());
			userDTO.setPassword(user.getPassword());
			userDTO.setFullName(user.getFullName());
			userDTO.setDept(user.getDept());
			userDTO.setClassName(user.getClassName());
			userDTO.setDateOfBirth(user.getDateOfBirth());
			userDTO.setAddress(user.getAddress());
			userDTO.setIndentification(user.getIndentification());
			userDTO.setAvatar(user.getAvatar());
			userDTO.setPhone(user.getPhone());
			userDTO.setRole(user.getRole());
			lstUserDTO.add(userDTO);
		}
		return lstUserDTO;
	}

	/* (non-Javadoc)
	 * @see vn.edu.hcmute.librarymanagement.service.NguyenDucDuongViet_03_UserService#findUserById(int)
	 */
	@Override
	public NguyenDucDuongViet_03_UserDTO findUserById(int userId) {

		NguyenDucDuongViet_03_UserDTO userDTO = new NguyenDucDuongViet_03_UserDTO();
		//lấy một user theo userId
		NguyenDucDuongViet_03_User user = userDAO.findUserById(userId);
		
		//set dữ liệu
		userDTO.setId(user.getId());
		userDTO.setUsername(user.getUsername());
		userDTO.setPassword(user.getPassword());
		userDTO.setFullName(user.getFullName());
		userDTO.setDept(user.getDept());
		userDTO.setClassName(user.getClassName());
		userDTO.setDateOfBirth(user.getDateOfBirth());
		userDTO.setAddress(user.getAddress());
		userDTO.setIndentification(user.getIndentification());
		userDTO.setAvatar(user.getAvatar());
		userDTO.setPhone(user.getPhone());
		userDTO.setRole(user.getRole());
		return userDTO;
	}

	/* (non-Javadoc)
	 * @see vn.edu.hcmute.librarymanagement.service.NguyenDucDuongViet_03_UserService#saveOrUpdate(vn.edu.hcmute.librarymanagement.dto.book.NguyenDucDuongViet_03_UserDTO)
	 */
	@Override
	public boolean saveOrUpdate(NguyenDucDuongViet_03_UserDTO user) {
		//thêm mới hoặc cập nhật thông tin user
		NguyenDucDuongViet_03_User u;
		if (user.getId() != null) {
			u = userDAO.findUserById(user.getId());
			u.setPassword(user.getPassword());
			u.setFullName(user.getFullName());
			u.setDept(user.getDept());
			u.setClassName(user.getClassName());
			u.setDateOfBirth(user.getDateOfBirth());
			u.setAddress(user.getAddress());
			u.setIndentification(user.getIndentification());
			u.setAvatar(user.getAvatar());
			u.setPhone(user.getPhone());
			u.setRole(user.getRole());
		} else {
			u = new NguyenDucDuongViet_03_User();
			u.setUsername(user.getUsername());
			u.setPassword(user.getPassword());
			u.setFullName(user.getFullName());
			u.setDept(user.getDept());
			u.setClassName(user.getClassName());
			u.setDateOfBirth(user.getDateOfBirth());
			u.setAddress(user.getAddress());
			u.setIndentification(user.getIndentification());
			u.setAvatar(user.getAvatar());
			u.setPhone(user.getPhone());
			u.setRole(user.getRole());
		}
		return userDAO.saveOrUpdate(u);
	}

	/* (non-Javadoc)
	 * @see vn.edu.hcmute.librarymanagement.service.NguyenDucDuongViet_03_UserService#delete(int)
	 */
	@Override
	public boolean delete(int userId) {
		NguyenDucDuongViet_03_User user = userDAO.findUserById(userId);
		return userDAO.delete(user);
	}

	/* (non-Javadoc)
	 * @see vn.edu.hcmute.librarymanagement.service.NguyenDucDuongViet_03_UserService#findByUsernameAndPassword(java.lang.String, java.lang.String)
	 */
	@Override
	public NguyenDucDuongViet_03_UserDTO findByUsernameAndPassword(String username, String password) {
		NguyenDucDuongViet_03_UserDTO userDTO = new NguyenDucDuongViet_03_UserDTO();
		//tìm user theo username và password
		NguyenDucDuongViet_03_User user = userDAO.findByUsernameAndPassword(username, password);
		//nếu tồn tại thì set dữ liệu
		if (user != null) {
			userDTO.setId(user.getId());
			userDTO.setUsername(user.getUsername());
			userDTO.setPassword(user.getPassword());
			userDTO.setFullName(user.getFullName());
			userDTO.setDept(user.getDept());
			userDTO.setClassName(user.getClassName());
			userDTO.setDateOfBirth(user.getDateOfBirth());
			userDTO.setAddress(user.getAddress());
			userDTO.setIndentification(user.getIndentification());
			userDTO.setAvatar(user.getAvatar());
			userDTO.setPhone(user.getPhone());
			userDTO.setRole(user.getRole());
			return userDTO;
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see vn.edu.hcmute.librarymanagement.service.NguyenDucDuongViet_03_UserService#checkUsernameIsExist(java.lang.String)
	 */
	@Override
	public boolean checkUsernameIsExist(String username) {
		return userDAO.checkUsernameIsExist(username);
	}

	/* (non-Javadoc)
	 * @see vn.edu.hcmute.librarymanagement.service.NguyenDucDuongViet_03_UserService#getAllStudent()
	 */
	@Override
	public List<NguyenDucDuongViet_03_UserDTO> getAllStudent() {
		List<NguyenDucDuongViet_03_UserDTO> lstStudentDTO = new ArrayList<NguyenDucDuongViet_03_UserDTO>();
		//lấy tất cả student
		List<NguyenDucDuongViet_03_User> lstUser = userDAO.findAllStudent();
		//set dữ liệu
		for (NguyenDucDuongViet_03_User user : lstUser) {
			NguyenDucDuongViet_03_UserDTO userDTO = new NguyenDucDuongViet_03_UserDTO();
			userDTO.setId(user.getId());
			userDTO.setUsername(user.getUsername());
			userDTO.setPassword(user.getPassword());
			userDTO.setFullName(user.getFullName());
			userDTO.setDept(user.getDept());
			userDTO.setClassName(user.getClassName());
			userDTO.setDateOfBirth(user.getDateOfBirth());
			userDTO.setAddress(user.getAddress());
			userDTO.setIndentification(user.getIndentification());
			userDTO.setAvatar(user.getAvatar());
			userDTO.setPhone(user.getPhone());
			userDTO.setRole(user.getRole());
			lstStudentDTO.add(userDTO);
		}
		return lstStudentDTO;
	}

}
