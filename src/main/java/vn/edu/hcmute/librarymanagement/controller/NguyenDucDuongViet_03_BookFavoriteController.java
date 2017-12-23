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

import vn.edu.hcmute.librarymanagement.dto.book.NguyenDucDuongViet_03_BookFavoriteDTO;
import vn.edu.hcmute.librarymanagement.dto.book.NguyenDucDuongViet_03_UserDTO;
import vn.edu.hcmute.librarymanagement.param.NguyenDucDuongViet_03_BookFavoriteParam;
import vn.edu.hcmute.librarymanagement.service.NguyenDucDuongViet_03_BookFavoriteService;

/**
 * @author Nguyen Duc Duong Viet
 *
 *         Dec 14, 2016
 * 
 *         Denfine handle event when client access to url
 *         
 *         This class work with BookFavorite/Quan tâm
 * 
 */
@Controller
public class NguyenDucDuongViet_03_BookFavoriteController {
	
	/**
	 * logger dùng để hiển thị thông báo lên console
	 */
	private static final Logger logger = LoggerFactory.getLogger(NguyenDucDuongViet_03_BookFavoriteController.class);

	/**
	 * bookFavoriteService chứa danh sách các hàm để thực hiện các chức năng chính về BookFavorite
	 */
	@Autowired
	private NguyenDucDuongViet_03_BookFavoriteService bookFavoriteService;


	/**
	 * @param session xách định user, quyền user
	 * @return danh sách các cuốn sách quan tâm của user, dữ liệu dạng json cho client
	 */
	@RequestMapping(value = "/getBookFavoriteByUser", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> getBookFavoriteByUser(HttpSession session) {
		NguyenDucDuongViet_03_UserDTO user = (NguyenDucDuongViet_03_UserDTO) session.getAttribute("user");
		Map<String, Object> map = new HashMap<String, Object>();
		if (user != null) {
			if (user.getRole() == 1) {
				logger.info("Find book favorite by userid:" + user.getId());
				List<NguyenDucDuongViet_03_BookFavoriteDTO> listBook = bookFavoriteService.findBookFavoriteByUser(user.getId());
				if (listBook != null) {
					map.put("status", "200");
					map.put("message", "Data found");
					map.put("data", listBook);
				} else {
					map.put("status", "404");
					map.put("message", "Not found data");
				}
			} else {
				map.put("status", "403");
				map.put("message", "You don't have permision access this data");
			}
		} else {
			map.put("status", "403");
			map.put("message", "You don't have permision access this data");
		}
		return map;
	}

	/**
	 * Lưu sách quan tâm mới
	 * @param bookParam biến để ánh xạ dữ liệu từ request của client
	 * @param session xách định user, quyền user
	 * @return kết quả trả về thành công hay thất bại, dạng json
	 */
	@RequestMapping(value = "/saveBookFavorite", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> saveBookFavorite(@RequestBody NguyenDucDuongViet_03_BookFavoriteParam bookParam, HttpSession session) {
		logger.info("Save book favorite:" + bookParam);
		Map<String, Object> map = new HashMap<String, Object>();
		NguyenDucDuongViet_03_UserDTO user = (NguyenDucDuongViet_03_UserDTO) session.getAttribute("user");
		if(user.getRole()!=1){
			map.put("status", "400");
			map.put("message", "Not have permision");
			return map;
		}
		if (bookFavoriteService.save(bookParam.getBookId(), bookParam.getUserId())) {
			map.put("status", "200");
			map.put("message", "Your record book has been saved successfully");
		} else {
			map.put("status", "403");
			map.put("message", "This book already have been in list");
		}
		return map;
	}

	/**
	 * Xóa một sách trong danh sách quan tâm theo id
	 * @param id
	 * @return kết quả trả về thành công hay thất bại, dạng json
	 */
	@RequestMapping(value = "/deleteBookFavorite/{id}", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> deleteBookFavorite(@PathVariable int id) {
		logger.info("Delete book favorite at id:" + id);
		Map<String, Object> map = new HashMap<String, Object>();
		if (bookFavoriteService.delete(id)) {
			map.put("status", "200");
			map.put("message", "Your record book has been delete successfully");
		}
		return map;
	}

	/**
	 * Xóa tất cả danh sách yêu thích của user
	 * @param userId
	 * @return kết quả trả về thành công hay thất bại, dạng json
	 */
	@RequestMapping(value = "/deleteBookFavoriteUser/{userId}", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> deleteBookFavoriteUser(@PathVariable int userId) {
		logger.info("Delete book favorite at userid:" + userId);
		Map<String, Object> map = new HashMap<String, Object>();
		if (bookFavoriteService.deleteAll(userId)) {
			map.put("status", "200");
			map.put("message", "Your record book has been delete successfully");
		}
		return map;
	}

}
