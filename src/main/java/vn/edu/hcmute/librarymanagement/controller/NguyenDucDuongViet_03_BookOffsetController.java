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

import vn.edu.hcmute.librarymanagement.dto.book.NguyenDucDuongViet_03_BookOffsetDTO;
import vn.edu.hcmute.librarymanagement.dto.book.NguyenDucDuongViet_03_BorrowOffsetDTO;
import vn.edu.hcmute.librarymanagement.dto.book.NguyenDucDuongViet_03_UserDTO;
import vn.edu.hcmute.librarymanagement.service.NguyenDucDuongViet_03_BookOffsetService;

/**
 * @author Nguyen Duc Duong Viet
 *
 *         Dec 24, 2016
 * 
 *         Denfine handle event when client access to url
 * 
 *         This class work with BookOffset/Đền bù sách
 * 
 */
@Controller
public class NguyenDucDuongViet_03_BookOffsetController {

	/**
	 * logger dùng để hiển thị thông báo lên console
	 */
	private static final Logger logger = LoggerFactory.getLogger(NguyenDucDuongViet_03_BookOffsetController.class);

	/**
	 * bookOffsetService chứa danh sách các hàm để thực hiện các chức năng chính về BookOffset/Đền bù sách
	 */
	@Autowired
	private NguyenDucDuongViet_03_BookOffsetService bookOffsetService;

	/**
	 * @param session xách định user, quyền user
	 * @return danh sách thông tin đền bù lưu trong csdl, dạng json
	 */
	@RequestMapping(value = "/getAllBookOffset", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> getAllBorrow(HttpSession session) {
		logger.info("Find all book offset...");
		Map<String, Object> map = new HashMap<>();
		NguyenDucDuongViet_03_UserDTO user = (NguyenDucDuongViet_03_UserDTO) session.getAttribute("user");
		if (user != null) {
			if (user.getRole() != 1) {
				List<NguyenDucDuongViet_03_BookOffsetDTO> lstOffset = bookOffsetService.findAll();
				if (lstOffset != null) {
					map.put("status", "200");
					map.put("message", "Data found");
					map.put("data", lstOffset);
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
	 * @return Thông tin một đền bù theo id, dạng json
	 */
	@RequestMapping(value = "/getBookOffset/{id}", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> getBookOffsetById(HttpSession session, @PathVariable int id) {
		logger.info("Get a offset by id...");
		Map<String, Object> map = new HashMap<>();
		NguyenDucDuongViet_03_UserDTO user = (NguyenDucDuongViet_03_UserDTO) session.getAttribute("user");
		if (user != null) {
			if (user.getRole() != 1) {
				NguyenDucDuongViet_03_BookOffsetDTO offset = bookOffsetService.findByBorrowId(id);
				if (offset != null) {
					map.put("status", "200");
					map.put("message", "Data found");
					map.put("data", offset);
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
	 * @param param dùng để ánh xạ dữ liệu từ request của client
	 * @return kết quả lưu thông tin đền bù thành công hay thất bại, dạng json
	 */
	@RequestMapping(value = "/saveBookOffset", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> saveBookOffset(HttpSession session, @RequestBody NguyenDucDuongViet_03_BookOffsetDTO param) {
		logger.info("Save new offset..." + param.getBooks().size() + " " + param.getBorrowBookId());
		Map<String, Object> map = new HashMap<>();
		NguyenDucDuongViet_03_UserDTO user = (NguyenDucDuongViet_03_UserDTO) session.getAttribute("user");
		if (user != null) {
			if (user.getRole() != 1) {
				if (bookOffsetService.save(param)) {
					map.put("status", "200");
					map.put("message", "Save success");
				} else {
					map.put("status", "500");
					map.put("message", "Fail to save");
				}
			}
		}
		return map;
	}

	/**
	 * @param session xách định user, quyền user
	 * @return danh sách những cuốn sách có thể đền bù/danh sách sách đang mượn
	 */
	@RequestMapping(value = "/getAllBookCanOffset", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> getAllBookCanOffset(HttpSession session) {
		logger.info("Find all book can offset...");
		Map<String, Object> map = new HashMap<>();
		NguyenDucDuongViet_03_UserDTO user = (NguyenDucDuongViet_03_UserDTO) session.getAttribute("user");
		if (user != null) {
			if (user.getRole() != 1) {
				List<NguyenDucDuongViet_03_BorrowOffsetDTO> lstOffset = bookOffsetService.getAllBookCanOffset();
				if (lstOffset != null) {
					map.put("status", "200");
					map.put("message", "Data found");
					map.put("data", lstOffset);
				} else {
					map.put("status", "404");
					map.put("message", "Data not found");
				}
			}
		}
		return map;
	}

	/**
	 * kiểm tra tồn tại của mã vạch
	 * @param session xách định user, quyền user
	 * @param code mã vạch trên sách
	 * @return exist/or not dạng json
	 */
	@RequestMapping(value = "/checkBookCodeExist/{code}", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> checkBookCode(HttpSession session, @PathVariable String code) {
		logger.info("Check book code exist...");
		Map<String, Object> map = new HashMap<>();
		NguyenDucDuongViet_03_UserDTO user = (NguyenDucDuongViet_03_UserDTO) session.getAttribute("user");
		if (user != null) {
			if (user.getRole() != 1) {
				if (!bookOffsetService.CheckBookCodeExist(code)) {
					map.put("status", "200");
					map.put("message", "Can use this code");
				} else {
					map.put("status", "403");
					map.put("message", "This code exist");
				}
			}
		}
		return map;
	}

}
