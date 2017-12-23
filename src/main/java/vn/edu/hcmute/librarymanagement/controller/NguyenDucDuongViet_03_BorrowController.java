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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import vn.edu.hcmute.librarymanagement.dto.book.NguyenDucDuongViet_03_BorrowBookDTO;
import vn.edu.hcmute.librarymanagement.dto.book.NguyenDucDuongViet_03_BorrowDTO;
import vn.edu.hcmute.librarymanagement.dto.book.NguyenDucDuongViet_03_UserDTO;
import vn.edu.hcmute.librarymanagement.param.NguyenDucDuongViet_03_ReturnBookParam;
import vn.edu.hcmute.librarymanagement.service.NguyenDucDuongViet_03_BorrowService;

/**
 * @author Nguyen Duc Duong Viet
 *
 *         Dec 22, 2016
 * 
 *         Denfine handle event when client access to url
 * 
 *         This class work with BorrowBook/Mượn, trả sách
 * 
 */

@Controller
public class NguyenDucDuongViet_03_BorrowController {

	/**
	 * borrowService chứa danh sách các hàm để thực hiện các chức năng chính về BorrowBook/Mượn, trả sách
	 */
	@Autowired
	private NguyenDucDuongViet_03_BorrowService borrowService;

	/**
	 * logger dùng để hiển thị thông báo lên console
	 */
	private static final Logger logger = LoggerFactory.getLogger(NguyenDucDuongViet_03_BorrowController.class);

	/**
	 * @param session xách định user, quyền user
	 * @return Thông tin về phiếu mượn của user đang đăng nhập, dạng json
	 */
	@RequestMapping(value = "/getBorrowListByUser", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> getBorrowDetailByUser(HttpSession session) {
		logger.info("get data borrow of user");
		Map<String, Object> map = new HashMap<>();
		NguyenDucDuongViet_03_UserDTO user = (NguyenDucDuongViet_03_UserDTO) session.getAttribute("user");
		if (user != null) {
			NguyenDucDuongViet_03_BorrowDTO dto = borrowService.getBorrowBookDetailByUser(user.getId());
			if (dto != null) {
				map.put("status", "200");
				map.put("message", "Data found");
				map.put("data", dto);
			} else {
				map.put("status", "404");
				map.put("message", "Data not found");
			}
		}
		return map;
	}

	/**
	 * @param session xách định user, quyền user
	 * @return danh sách tất cả các thông tin phiếu mượn, dạng json
	 */
	@RequestMapping(value = "/getAllBorrow", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> getAllBorrow(HttpSession session) {
		logger.info("Find all borrow...");
		Map<String, Object> map = new HashMap<>();
		NguyenDucDuongViet_03_UserDTO user = (NguyenDucDuongViet_03_UserDTO) session.getAttribute("user");
		if (user != null) {
			if (user.getRole() == 2) {
				List<NguyenDucDuongViet_03_BorrowBookDTO> lstBorrow = borrowService.findAllBorrow();
				if (lstBorrow != null) {
					map.put("status", "200");
					map.put("message", "Data found");
					map.put("data", lstBorrow);
				} else {
					map.put("status", "404");
					map.put("message", "Data not found");
				}
			}
		}
		return map;
	}

	/**
	 * @param session xách định user, quyền user
	 * @param id
	 * @return thông tin chi tiết của một phiếu mượn, dạng json
	 */
	@RequestMapping(value = "/getBorrowDetail/{id}", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> getBorrowById(HttpSession session, @PathVariable int id) {
		logger.info("Find a borrow detail: " + id);
		Map<String, Object> map = new HashMap<>();
		NguyenDucDuongViet_03_UserDTO user = (NguyenDucDuongViet_03_UserDTO) session.getAttribute("user");
		if (user != null) {
			if (user.getRole() == 2) {
				NguyenDucDuongViet_03_BorrowDTO borrow = borrowService.getBorrowBookDetailById(id);
				if (borrow != null) {
					map.put("status", "200");
					map.put("message", "Data found");
					map.put("data", borrow);
				} else {
					map.put("status", "404");
					map.put("message", "Data not found");
				}
			}
		}
		return map;
	}
	
	/** 
	 * Trả một cuốn sách
	 * @param session xách định user, quyền user
	 * @param param ánh xạ dữ liệu từ request của client
	 * @return Thành công hay thất bại, dạng json
	 */
	@RequestMapping(value = "/returnBook", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> returnBook(HttpSession session, @RequestBody NguyenDucDuongViet_03_ReturnBookParam param) {
		logger.info("Return a book where:" + param.getBorrowId() + " book:" + param.getBookId());
		Map<String, Object> map = new HashMap<>();
		NguyenDucDuongViet_03_UserDTO user = (NguyenDucDuongViet_03_UserDTO) session.getAttribute("user");
		if (user != null) {
			if (user.getRole() == 2) {
				if (borrowService.returnBook(param.getBorrowId(), param.getBookId())) {
					map.put("status", "200");
					map.put("message", "Update object successfully");
				} else {
					map.put("status", "500");
					map.put("message", "Occur error when update object");
				}
			}
		}
		return map;
	}
	
	/**
	 * Trả tất cả sách của một phiếu mượn
	 * @param session xách định user, quyền user
	 * @param borrowId id phiếu mươn
	 * @return Thành công hay thất bại, dạng json
	 */
	@RequestMapping(value = "/returnBook/{borrowId}", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> returnAllBook(HttpSession session, @PathVariable int borrowId) {
		logger.info("return all borrow book where:" + borrowId);
		Map<String, Object> map = new HashMap<>();
		NguyenDucDuongViet_03_UserDTO user = (NguyenDucDuongViet_03_UserDTO) session.getAttribute("user");
		if (user != null) {
			if (user.getRole() == 2) {
				if (borrowService.returnAllBook(borrowId)) {
					map.put("status", "200");
					map.put("message", "Update object successfully");
				} else {
					map.put("status", "500");
					map.put("message", "Occur error when update object");
				}
			}
		}
		return map;
	}
	
	/**
	 * @param session xách định user, quyền user
	 * @param param
	 * @return kết quả thực hiện việc cho mượn, dạng json
	 */
	@RequestMapping(value = "/borrowBook", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> borrowBook(HttpSession session, @RequestBody NguyenDucDuongViet_03_BorrowDTO param) {
		logger.info("Add borrow infor:" + param.getBooks().size() + " book:" + param.getUser().getUsername());
		Map<String, Object> map = new HashMap<>();
		NguyenDucDuongViet_03_UserDTO user = (NguyenDucDuongViet_03_UserDTO) session.getAttribute("user");
		if (user != null) {
			if (user.getRole() != 1) {
				if (borrowService.borrowBook(param)) {
					map.put("status", "200");
					map.put("message", "Save object successfully");
				} else {
					map.put("status", "500");
					map.put("message", "Occur error when update object");
				}
			}
		}
		return map;
	}
	
	/**
	 * @param session xách định user, quyền user
	 * @param id
	 * @return thông tin một phiếu mượn(Không bao gồm danh sách sách đang mượn), dạng json
	 */
	@RequestMapping(value = "/getBorrow/{id}", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> getBorrow(HttpSession session, @PathVariable int id) {
		logger.info("Find a borrow detail: " + id);
		Map<String, Object> map = new HashMap<>();
		NguyenDucDuongViet_03_UserDTO user = (NguyenDucDuongViet_03_UserDTO) session.getAttribute("user");
		if (user != null) {
			if (user.getRole() != 1) {
				NguyenDucDuongViet_03_BorrowBookDTO borrow = borrowService.findBorrowInfoById(id);
				if (borrow != null) {
					map.put("status", "200");
					map.put("message", "Data found");
					map.put("data", borrow);
				} else {
					map.put("status", "404");
					map.put("message", "Data not found");
				}
			}
		}
		return map;
	}
}
