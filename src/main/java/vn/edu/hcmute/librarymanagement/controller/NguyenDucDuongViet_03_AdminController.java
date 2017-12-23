/**
 * 
 */
package vn.edu.hcmute.librarymanagement.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.edu.hcmute.librarymanagement.dto.book.NguyenDucDuongViet_03_UserDTO;

/**
 * @author Nguyen Duc Duong Viet
 *
 *         Dec 25, 2016
 * 
 *         This class define which view will return each url
 * 
 *         View of Admin's functionalities
 */
@Controller
public class NguyenDucDuongViet_03_AdminController {
	
	/**
	 * @param session session xách định user, quyền user
	 * @return view hiển thị danh sách sách
	 */
	@RequestMapping(value = "/admin/books")
	public String adminHome(HttpSession session){
		NguyenDucDuongViet_03_UserDTO user = (NguyenDucDuongViet_03_UserDTO) session.getAttribute("user");
		if (user == null) {
			return "redirect:/login";
		}
		if (user.getRole() != 0)
			return "redirect:/home";
		return "admin/books";
	}
	
	/**
	 * @param session session xách định user, quyền user
	 * @param id
	 * @return view hiển thị chi tiết sách
	 */
	@RequestMapping(value = "/admin/book/{id}")
	public String adminBookDetail(HttpSession session, @PathVariable int id, Model model){
		NguyenDucDuongViet_03_UserDTO user = (NguyenDucDuongViet_03_UserDTO) session.getAttribute("user");
		if (user == null) {
			return "redirect:/login";
		}
		if (user.getRole() != 0)
			return "redirect:/home";
		model.addAttribute("bookId", id);
		return "admin/book-detail";
	}
	
	/**
	 * @param session session xách định user, quyền user
	 * @return view để thêm sách mới
	 */
	@RequestMapping(value = "/admin/book/create")
	public String adminCreateBook(HttpSession session){
		NguyenDucDuongViet_03_UserDTO user = (NguyenDucDuongViet_03_UserDTO) session.getAttribute("user");
		if (user == null) {
			return "redirect:/login";
		}
		if (user.getRole() != 0)
			return "redirect:/home";
		return "admin/add-book";
	}
	
	/**
	 * @param session session xách định user, quyền user
	 * @return view hiển thị danh sách user
	 */
	@RequestMapping(value = "/admin/users")
	public String adminUser(HttpSession session){
		NguyenDucDuongViet_03_UserDTO user = (NguyenDucDuongViet_03_UserDTO) session.getAttribute("user");
		if (user == null) {
			return "redirect:/login";
		}
		if (user.getRole() != 0)
			return "redirect:/home";
		return "admin/users";
	}
	
	/**
	 * @param session session xách định user, quyền user
	 * @param id 
	 * @return view hiển thị chi tiết user
	 */
	@RequestMapping(value = "/admin/user/{id}")
	public String adminUserDetail(HttpSession session, @PathVariable int id, Model model){
		NguyenDucDuongViet_03_UserDTO user = (NguyenDucDuongViet_03_UserDTO) session.getAttribute("user");
		if (user == null) {
			return "redirect:/login";
		}
		if (user.getRole() != 0)
			return "redirect:/home";
		model.addAttribute("userId", id);
		return "admin/user-detail";
	}
	
	/**
	 * @param session session xách định user, quyền user
	 * @return view để thêm danh sách mới
	 */
	@RequestMapping(value = "/admin/user/add")
	public String adminAddUser(HttpSession session){
		NguyenDucDuongViet_03_UserDTO user = (NguyenDucDuongViet_03_UserDTO) session.getAttribute("user");
		if (user == null) {
			return "redirect:/login";
		}
		if (user.getRole() != 0)
			return "redirect:/home";
		return "admin/add-user";
	}

}
