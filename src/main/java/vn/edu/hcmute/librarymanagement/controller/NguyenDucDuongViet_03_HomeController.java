/**
 * 
 */
package vn.edu.hcmute.librarymanagement.controller;


import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vn.edu.hcmute.librarymanagement.dto.book.NguyenDucDuongViet_03_UserDTO;

/**
 * @author Nguyen Duc Duong Viet
 *
 *         Dec 15, 2016
 * 
 *         Denfine handle event when client access to url
 * 
 *         This class define home page and login page 
 */

@Controller
public class NguyenDucDuongViet_03_HomeController {

	/**
	 * dùng hiển thị thông tin ra console
	 */
	private static final Logger logger = LoggerFactory.getLogger(NguyenDucDuongViet_03_HomeController.class);
	
	/**
	 * @param session xách định user, quyền user
	 * @param model chuyên data to view
	 * @return view trang chủ
	 */
	@RequestMapping(value = { "/", "/home" })
	public ModelAndView home(HttpSession session, Model model) {
		NguyenDucDuongViet_03_UserDTO user = (NguyenDucDuongViet_03_UserDTO) session.getAttribute("user");
		if (user != null) {
			logger.info(user.getUsername());
			model.addAttribute("user", user);
		}
		return new ModelAndView("home");
	}

	/**
	 * @return view login
	 */
	@RequestMapping(value = { "/login" })
	public ModelAndView login() {
		return new ModelAndView("login");
	}

}
