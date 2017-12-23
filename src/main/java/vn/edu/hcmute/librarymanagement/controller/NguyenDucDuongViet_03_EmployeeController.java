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
 *         Dec 19, 2016
 * 
 *         Denfine handle event when client access to url
 * 
 *         This class define which view will return each url 
 *         
 *         View of Employee's functionalities
 */

@Controller
public class NguyenDucDuongViet_03_EmployeeController {

	/**
	 * @param session xách định user, quyền user
	 * @return view hiển thị danh sách đang mượn
	 */
	@RequestMapping(value = "/borrow")
	public String home(HttpSession session) {
		NguyenDucDuongViet_03_UserDTO user = (NguyenDucDuongViet_03_UserDTO) session.getAttribute("user");
		if (user == null) {
			return "redirect:/login";
		}
		if (user.getRole() != 2)
			return "redirect:/home";
		return "employee/borrow-list";
	}

	/**
	 * @param session xách định user, quyền user
	 * @param id phiếu mượn id
	 * @param model chuyển data to view
	 * @return view hiển thị thông tin mượn chi tiêt
	 */
	@RequestMapping(value = "/borrow/{id}")
	public String borrowDetai(HttpSession session, @PathVariable int id, Model model) {
		NguyenDucDuongViet_03_UserDTO user = (NguyenDucDuongViet_03_UserDTO) session.getAttribute("user");
		if (user == null) {
			return "redirect:/login";
		}
		if (user.getRole() != 2)
			return "redirect:/home";
		model.addAttribute("borrowId", id);
		return "employee/borrow-detail";
	}

	/**
	 * @param session xách định user, quyền user
	 * @return view hiển thị danh sách đang đặt
	 */
	@RequestMapping(value = "/order")
	public String orderList(HttpSession session) {
		NguyenDucDuongViet_03_UserDTO user = (NguyenDucDuongViet_03_UserDTO) session.getAttribute("user");
		if (user == null) {
			return "redirect:/login";
		}
		if (user.getRole() != 2)
			return "redirect:/home";
		return "employee/orderlist";
	}
	
	/**
	 * @param session xách định user, quyền user
	 * @param id order id
	 * @param model chuyển data to view
	 * @return view hiển thị thông tin đặt chi tiết
	 */
	@RequestMapping(value = "/order/{id}")
	public String orderDetai(HttpSession session, @PathVariable int id, Model model) {
		NguyenDucDuongViet_03_UserDTO user = (NguyenDucDuongViet_03_UserDTO) session.getAttribute("user");
		if (user == null) {
			return "redirect:/login";
		}
		if (user.getRole() != 2)
			return "redirect:/home";
		model.addAttribute("orderId", id);
		return "employee/order-detail";
	}

	/**
	 * @param session xách định user, quyền user
	 * @return view thực hiện chức năng cho mượn sách
	 */
	@RequestMapping(value = "/borrow-book")
	public String borrowBook(HttpSession session) {
		NguyenDucDuongViet_03_UserDTO user = (NguyenDucDuongViet_03_UserDTO) session.getAttribute("user");
		if (user == null) {
			return "redirect:/login";
		}
		if (user.getRole() != 2)
			return "redirect:/home";
		return "employee/borrow-book";
	}
	
	/**
	 * @param session xách định user, quyền user
	 * @param id order id
	 * @param model chuyển data to view
	 * @return view thực hiện chức năng cho mượn sách thông qua order
	 */
	@RequestMapping(value = "/borrow-book/{id}")
	public String borrowBookWithOrder(HttpSession session,@PathVariable int id, Model model) {
		NguyenDucDuongViet_03_UserDTO user = (NguyenDucDuongViet_03_UserDTO) session.getAttribute("user");
		if (user == null) {
			return "redirect:/login";
		}
		if (user.getRole() != 2)
			return "redirect:/home";
		model.addAttribute("orderId",id);
		return "employee/borrow-order";
	}

	/**
	 * @param session xách định user, quyền user
	 * @return view hiển thị danh sách các thông tin đền bù
	 */
	@RequestMapping(value = "/offset")
	public String offsetList(HttpSession session) {
		NguyenDucDuongViet_03_UserDTO user = (NguyenDucDuongViet_03_UserDTO) session.getAttribute("user");
		if (user == null) {
			return "redirect:/login";
		}
		if (user.getRole() != 2)
			return "redirect:/home";
		return "employee/offset";
	}
	
	/**
	 * @param session xách định user, quyền user
	 * @return view cho chức năng đền bù
	 */
	@RequestMapping(value = "/offset/create")
	public String addOffset(HttpSession session) {
		NguyenDucDuongViet_03_UserDTO user = (NguyenDucDuongViet_03_UserDTO) session.getAttribute("user");
		if (user == null) {
			return "redirect:/login";
		}
		if (user.getRole() != 2)
			return "redirect:/home";
		return "employee/add-offset";
	}
	
	/**
	 * @param session xách định user, quyền user
	 * @param id offset id
	 * @param model chuyển data to view
	 * @return view hiển thị thông tin đền bù chi tiết
	 */
	@RequestMapping(value = "/offset/{id}")
	public String offsetDetail(HttpSession session, @PathVariable int id, Model model) {
		NguyenDucDuongViet_03_UserDTO user = (NguyenDucDuongViet_03_UserDTO) session.getAttribute("user");
		if (user == null) {
			return "redirect:/login";
		}
		if (user.getRole() == 1)
			return "redirect:/home";
		model.addAttribute("borowId", id);
		return "employee/offset-detail";
	}

	/**
	 * @param session xách định user, quyền user
	 * @return view hiển thị danh sách sách có trong csdl
	 */
	@RequestMapping(value = "/book-list")
	public String searchBook(HttpSession session) {
		NguyenDucDuongViet_03_UserDTO user = (NguyenDucDuongViet_03_UserDTO) session.getAttribute("user");
		if (user == null) {
			return "redirect:/login";
		}
		if (user.getRole() != 2)
			return "redirect:/home";
		return "employee/book-list";
	}

}
