/**
 * 
 */
package vn.edu.hcmute.librarymanagement.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import vn.edu.hcmute.librarymanagement.dto.book.NguyenDucDuongViet_03_UserDTO;
import vn.edu.hcmute.librarymanagement.service.NguyenDucDuongViet_03_UserService;

/**
 * @author Nguyen Duc Duong Viet
 *
 *         Dec 14, 2016
 * 
 *         Denfine handle event when client access to url
 * 
 *         This class work with User/Người dùng
 * 
 */

@Controller
public class NguyenDucDuongViet_03_UserController {

	/**
	 * dùng để xuất thông tin ra console
	 */
	private static final Logger logger = LoggerFactory.getLogger(NguyenDucDuongViet_03_UserController.class);

	/**
	 * userService chứa danh sách các hàm để thực hiện các chức năng chính về User
	 */
	@Autowired
	private NguyenDucDuongViet_03_UserService userService;

	/**
	 * @return view danh sách user
	 */
	@RequestMapping(value = "/users")
	public String user() {
		return "userpage";
	}

	/**
	 * @return tất cả cách user, dạng json
	 */
	@RequestMapping(value = "/findAllUser", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> findAllUser() {
		logger.info("Find all user");
		Map<String, Object> map = new HashMap<String, Object>();
		List<NguyenDucDuongViet_03_UserDTO> listUser = userService.findAll();
		if (listUser != null) {
			map.put("status", "200");
			map.put("message", "Data found");
			map.put("data", listUser);
		} else {
			map.put("status", "404");
			map.put("message", "Not found data");
		}
		return map;
	}

	/**
	 * Đăng nhập
	 * @param username
	 * @param password
	 * @param model chuyển dữ liệu đến view
	 * @param session tạo session, lưu trữ thông tin
	 * @return view tương ứng với mỗi loại user hoặc trang đăng nhập
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam String username, @RequestParam String password, Model model,
			HttpSession session) {
		logger.info("Login with username: " + username + "password: " + password);
		NguyenDucDuongViet_03_UserDTO user = userService.findByUsernameAndPassword(username, password);
		String url = "";
		if (user != null) {
			session.setAttribute("user", user);
			switch (user.getRole()) {
			case 1:

				url = "redirect:/home";
				break;
			case 2:
				url = "redirect:/borrow";
				break;
			case 0:
				url = "redirect:/admin/books";
				break;
			}
		} else {
			url = "login";
			model.addAttribute("loginError", "Invalid username or password, Please try again!");
		}

		return url;
	}

	/**
	 * Đăng xuất
	 * @param session hủy session
	 * @return trang chủ
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute("user");
		session.invalidate();
		logger.info("Loging succes");
		return "redirect:/home";
	}

	/**
	 * @param id userId
	 * @return dữ liệu về một user theo id, dạng json
	 */
	@RequestMapping(value = "/findUserById/{id}", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> findUserById(@PathVariable int id) {
		logger.info("Find user by id:" + id);
		Map<String, Object> map = new HashMap<String, Object>();
		NguyenDucDuongViet_03_UserDTO user = userService.findUserById(id);
		if (user != null) {
			map.put("status", "200");
			map.put("message", "Data found");
			map.put("data", user);
		} else {
			map.put("status", "404");
			map.put("message", "Not found data");
		}
		return map;
	}

	/**
	 * @param id userId
	 * @return xóa một user theo id, kết quả thành công hay thất bại trả về dạng json
	 */
	@RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> deleteUserId(@PathVariable int id) {
		logger.info("Delete user, userid:" + id);
		Map<String, Object> map = new HashMap<String, Object>();
		if (userService.delete(id)) {
			map.put("status", "200");
			map.put("message", "Delete user successfully");
		}
		return map;
	}

	/**
	 * Thêm user mới
	 * @param user thông tin user mới
	 * @return thành công hay thất bại, dạng json
	 */
	@RequestMapping(value = "/saveOrUpdateUser", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> deleteUserId(@RequestBody NguyenDucDuongViet_03_UserDTO user) {
		logger.info("Create or update user, user:" + user);
		Map<String, Object> map = new HashMap<String, Object>();
		if (userService.saveOrUpdate(user)) {
			map.put("status", "200");
			map.put("message", "Save user successfully");
		}
		return map;
	}
	
	/**
	 * Check exist username
	 * @param username
	 * @return tồn tại hay không dạng json
	 */
	@RequestMapping(value = "/checkUsername/{username}", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> CheckUserName(@PathVariable String username) {
		logger.info("Cheking exist of username:" + username);
		Map<String, Object> map = new HashMap<String, Object>();
		if (!userService.checkUsernameIsExist(username)) {
			map.put("status", "200");
			map.put("message", "can use");
		}else{
			map.put("status", "403");
			map.put("message", "exist");
		}
		return map;
	}
	
	/**
	 * @return danh sách thông tin tất cả những sinh viên, dạng json
	 */
	@RequestMapping(value = "/findAllStudent", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> getAllStudent() {
		logger.info("Find all student");
		Map<String, Object> map = new HashMap<String, Object>();
		List<NguyenDucDuongViet_03_UserDTO> listStudent = userService.getAllStudent();
		if (listStudent != null) {
			map.put("status", "200");
			map.put("message", "Data found");
			map.put("data", listStudent);
		} else {
			map.put("status", "404");
			map.put("message", "Not found data");
		}
		return map;
	}

}
