/**
 * 
 */
package vn.edu.hcmute.librarymanagement.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import vn.edu.hcmute.librarymanagement.dto.book.NguyenDucDuongViet_03_BookDTO;
import vn.edu.hcmute.librarymanagement.dto.book.NguyenDucDuongViet_03_UserDTO;
import vn.edu.hcmute.librarymanagement.service.NguyenDucDuongViet_03_BookService;

/**
 * @author Nguyen Duc Duong Viet
 *
 *         Dec 18, 2016
 * 
 *         Return view for student's functionalities
 */
@Controller
public class NguyenDucDuongViet_03_StudentController {

	/**
	 * dùng xuất thông tin ra console
	 */
	private static final Logger logger = LoggerFactory.getLogger(NguyenDucDuongViet_03_StudentController.class);
	/**
	 * orderService chứa danh sách các hàm để thực hiện các chức năng chính về Book
	 */
	@Autowired
	private NguyenDucDuongViet_03_BookService bookService;

	/**
	 * @param session xách định user, quyền user
	 * @return
	 */
	@RequestMapping(value = "/mybook")
	public String myBook(HttpSession session) {
		NguyenDucDuongViet_03_UserDTO user = (NguyenDucDuongViet_03_UserDTO) session.getAttribute("user");
		if (user == null) {
			return "redirect:/login";
		}
		if (user.getRole() != 1) {
			return "redirect:/borrow";
		}
		return "mybook";
	}

	/**
	 * @param session xách định user, quyền user
	 * @return
	 */
	@RequestMapping(value = "/cart")
	public String myCart(HttpSession session) {
		NguyenDucDuongViet_03_UserDTO user = (NguyenDucDuongViet_03_UserDTO) session.getAttribute("user");
		if (user == null) {
			return "redirect:/login";
		}
		if (user.getRole() != 1) {
			return "redirect:/borrow";
		}
		return "cart";
	}
	
	/**
	 * @param session xách định user, quyền user
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/order-detail")
	public String orderBook(HttpSession session) {
		NguyenDucDuongViet_03_UserDTO user = (NguyenDucDuongViet_03_UserDTO) session.getAttribute("user");
		List<NguyenDucDuongViet_03_BookDTO> bookOrder = (List<NguyenDucDuongViet_03_BookDTO>) session.getAttribute("lstBookOrder");
		if (user == null) {
			return "redirect:/login";
		}
		if (user.getRole() != 1) {
			return "redirect:/borrow";
		}
		if(bookOrder == null){
			return "redirect:/book";
		}
		return "order";
	}

	/**
	 * 
	 * thực hiện đặt sách, những sách đặt được lưu vào session để gọi lần sau
	 * @param session xách định user, quyền user
	 * @param bookId
	 * @return chuyển đến màn hình đặt sách
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/order-book", method = RequestMethod.POST)
	public String addOrder(HttpSession session, @RequestParam int bookId) {
		logger.info("Add order with bookId:" + bookId);
		NguyenDucDuongViet_03_UserDTO user = (NguyenDucDuongViet_03_UserDTO) session.getAttribute("user");
		if (user == null) {
			return "redirect:/login";
		}
		if (user.getRole() != 1) {
			return "redirect:/borrow";
		}
		List<NguyenDucDuongViet_03_BookDTO> bookOrder = (List<NguyenDucDuongViet_03_BookDTO>) session.getAttribute("lstBookOrder");
		if (bookOrder != null) {
			logger.info("List order:" + bookOrder);
			if (!checkBookExistInCart(bookOrder, bookId)) {
				bookOrder.add(bookService.findBookById(bookId));
				session.setAttribute("lstBookOrder", bookOrder);
			}
		} else {
			bookOrder = new ArrayList<>();
			bookOrder.add(bookService.findBookById(bookId));
			session.setAttribute("lstBookOrder", bookOrder);
		}
		return "redirect:/order-detail";
	}

	/**
	 * check sách đã có trong danh sách đặt chưa
	 * @param lst
	 * @param bookId
	 * @return true if exist
	 */
	private boolean checkBookExistInCart(List<NguyenDucDuongViet_03_BookDTO> lst, int bookId) {
		for (NguyenDucDuongViet_03_BookDTO bookDTO : lst) {
			if (bookDTO.getId() == bookId)
				return true;
		}
		return false;
	}
}
