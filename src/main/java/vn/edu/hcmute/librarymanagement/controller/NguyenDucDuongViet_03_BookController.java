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
import org.springframework.web.bind.annotation.ResponseBody;

import vn.edu.hcmute.librarymanagement.dto.book.NguyenDucDuongViet_03_BookDTO;
import vn.edu.hcmute.librarymanagement.dto.book.NguyenDucDuongViet_03_BookListDTO;
import vn.edu.hcmute.librarymanagement.dto.book.NguyenDucDuongViet_03_CategoryDTO;
import vn.edu.hcmute.librarymanagement.service.NguyenDucDuongViet_03_BookService;
import vn.edu.hcmute.librarymanagement.service.NguyenDucDuongViet_03_CategoryService;

/**
 * @author Nguyen Duc Duong Viet
 *
 *         Dec 13, 2016
 *         
 *         Controller define url to load data 
 */

@Controller
public class NguyenDucDuongViet_03_BookController {

	/**
	 * bookService chứa danh sách các hàm để thực hiện các chức năng chính về Book
	 */
	@Autowired
	private NguyenDucDuongViet_03_BookService bookService;

	/**
	 * categoryService chứa danh sách các hàm để thực hiện các chức năng chính về Category
	 */
	@Autowired
	private NguyenDucDuongViet_03_CategoryService categoryService;

	/**
	 * logger dùng để hiển thị thông báo lên console
	 */
	private static final Logger logger = LoggerFactory.getLogger(NguyenDucDuongViet_03_BookController.class);

	/**
	 * định nghĩa view khi truy cập vào url /book
	 * @return searchbook.jsp view
	 */
	@RequestMapping(value = "/book")
	public String index() {
		return "searchbook";
	}

	/**
	 * định nghĩa view khi truy cập vào url /book/{id}
	 * @param id book
	 * @param model chuyển data xuống view
	 * @return book.jsp view
	 */
	@RequestMapping(value = "/book/{id}")
	public String book(@PathVariable int id, Model model) {
		model.addAttribute("id", id);
		return "book";
	}

	/**
	 * Định nghĩa xử lý khi yêu cầu tới url /getBookHotInMonth
	 * @param session xách định user, quyền user
	 * @return danh sách các sách hot trong tháng, dư liệu dạng json cho client
	 */
	@RequestMapping(value = "/getBookHotInMonth", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> getBookHotInMonth(HttpSession session) {
		logger.info("Find book hot");
		Map<String, Object> map = new HashMap<String, Object>();
		List<NguyenDucDuongViet_03_BookDTO> listBook = null;
		// UserDTO user = (UserDTO) session.getAttribute("user");
		// if (user != null) {
		listBook = bookService.findBookHotInMonth();
		if (listBook != null) {
			map.put("status", "200");
			map.put("message", "Data found");
			map.put("data", listBook);
		} else {
			map.put("status", "404");
			map.put("message", "Not found data");
		}
		// }else{
		// map.put("status", "403");
		// map.put("message", "You haven't premisson to access this resources");
		// }
		return map;
	}

	/**
	 * Định nghĩa xử lý khi yêu cầu tới url /getRelatedBook/{categoryId}
	 * @param categoryId
	 * @param session xách định user, quyền user
	 * @return danh sách các sách liên quan cùng loại sách, dư liệu dạng json cho client
	 */
	@RequestMapping(value = "/getRelatedBook/{categoryId}", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> getReatedBook(@PathVariable int categoryId, HttpSession session) {
		logger.info("Find related book");
		Map<String, Object> map = new HashMap<String, Object>();
		List<NguyenDucDuongViet_03_BookDTO> listBook = null;
		listBook = bookService.findBookRelatedByCategory(categoryId);
		if (listBook != null) {
			map.put("status", "200");
			map.put("message", "Data found");
			map.put("data", listBook);
		} else {
			map.put("status", "404");
			map.put("message", "Not found data");
		}
		return map;
	}

	/**
	 * Định nghĩa xử lý khi yêu cầu tới url /getBooks
	 * @param session xách định user, quyền user
	 * @return danh sách các sách có trong csdl, dư liệu dạng json cho client
	 */
	@RequestMapping(value = "/getBooks", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> getBooks(HttpSession session) {
		logger.info("Find all book");
		Map<String, Object> map = new HashMap<String, Object>();
		List<NguyenDucDuongViet_03_BookDTO> listBook = null;
		listBook = bookService.findAll();
		if (listBook != null) {
			map.put("status", "200");
			map.put("message", "Data found");
			map.put("data", listBook);
		} else {
			map.put("status", "404");
			map.put("message", "Not found data");
		}
		return map;
	}

	/**
	 * Định nghĩa xử lý khi yêu cầu tới url /getBookById/{id}
	 * @param id
	 * @param session xách định user, quyền user
	 * @return một object sách theo id sách, dư liệu dạng json cho client
	 */
	@RequestMapping(value = "/getBookById/{id}", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> getBookById(@PathVariable int id, HttpSession session) {
		logger.info("Find book: " + id);
		Map<String, Object> map = new HashMap<String, Object>();
		NguyenDucDuongViet_03_BookDTO book = bookService.findBookById(id);
		if (book != null) {
			map.put("status", "200");
			map.put("message", "Data found");
			map.put("data", book);
		} else {
			map.put("status", "404");
			map.put("message", "Not found data");
		}
		return map;
	}

	/**
	 * Định nghĩa xử lý khi yêu cầu tới url /getCategories
	 * @param session xách định user, quyền user
	 * @return danh sách các loại sách, dư liệu dạng json cho client
	 */
	@RequestMapping(value = "/getCategories", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> getCategories(HttpSession session) {
		logger.info("Find all book");
		Map<String, Object> map = new HashMap<String, Object>();
		List<NguyenDucDuongViet_03_CategoryDTO> categories = null;
		categories = categoryService.findAll();
		if (categories != null) {
			map.put("status", "200");
			map.put("message", "Data found");
			map.put("data", categories);
		} else {
			map.put("status", "404");
			map.put("message", "Not found data");
		}
		return map;
	}

	/**
	 * Định nghĩa xử lý khi yêu cầu tới url /getBookByCategory/{categoryId}
	 * @param categoryId
	 * @param session xách định user, quyền user
	 * @return danh sách sách theo loại sách, dư liệu dạng json cho client
	 */
	@RequestMapping(value = "/getBookByCategory/{categoryId}", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> getBookByCategory(@PathVariable int categoryId, HttpSession session) {
		logger.info("Find book by id:" + categoryId);
		Map<String, Object> map = new HashMap<String, Object>();
		List<NguyenDucDuongViet_03_BookDTO> listBook = null;
		listBook = bookService.findBookByCategory(categoryId);
		if (listBook != null) {
			map.put("status", "200");
			map.put("message", "Data found");
			map.put("data", listBook);
		} else {
			map.put("status", "404");
			map.put("message", "Not found data");
		}

		return map;
	}

	/**
	 * Định nghĩa xử lý khi yêu cầu tới url /searchBook/{search}
	 * @param search
	 * @return danh sách sách theo điều kiện tìm kiếm, dư liệu dạng json cho client
	 */
	@RequestMapping(value = "/searchBook/{search}", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> searchBookByNameOrAuthor(@PathVariable String search) {
		logger.info("Find book by Name or Author:" + search);
		Map<String, Object> map = new HashMap<String, Object>();
		List<NguyenDucDuongViet_03_BookDTO> listBook = bookService.findBookByNameOrAuthor(search);
		if (listBook != null) {
			map.put("status", "200");
			map.put("message", "Data found");
			map.put("data", listBook);
		} else {
			map.put("status", "404");
			map.put("message", "Not found data");
		}
		return map;
	}

	/**
	 * Định nghĩa xử lý khi yêu cầu tới url /saveOrUpdateBook
	 * @param book
	 * @return kết quả của việc thêm mới/cập nhật sách, kết quả trả về dạng json cho client
	 */
	@RequestMapping(value = "/saveOrUpdateBook", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> saveOrUpdateBook(@RequestBody NguyenDucDuongViet_03_BookDTO book) {
		logger.info("Save or Update book:" + book);
		Map<String, Object> map = new HashMap<String, Object>();
		if (bookService.saveOrUpdate(book)) {
			map.put("status", "200");
			map.put("message", "Your record book has been saved successfully");
		}
		return map;
	}

	/**
	 * Định nghĩa xử lý khi yêu cầu tới url /deleteBook/{id}
	 * @param id
	 * @return kết quả của việc xóa sách theo id sahcs, kết quả trả về dạng json cho client
	 */
	@RequestMapping(value = "/deleteBook/{id}", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> deleteBook(@PathVariable int id) {
		logger.info("Delete book at id:" + id);
		Map<String, Object> map = new HashMap<String, Object>();
		if (bookService.delete(id)) {
			map.put("status", "200");
			map.put("message", "Your record book has been delete successfully");
		}
		return map;
	}
	
	/**
	 * Định nghĩa xử lý khi yêu cầu tới url /getAllBookList
	 * @param session xách định user, quyền user
	 * @return danh sách sách (được phân phiệt bằng mã vạch) có thể mượn, kết quả trả về dạng json cho client
	 */
	@RequestMapping(value = "/getAllBookList", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> getAllBookList(HttpSession session) {
		logger.info("Find all book");
		Map<String, Object> map = new HashMap<String, Object>();
		List<NguyenDucDuongViet_03_BookListDTO> booklists = bookService.findAllBookList();
		if (booklists != null) {
			map.put("status", "200");
			map.put("message", "Data found");
			map.put("data", booklists);
		} else {
			map.put("status", "404");
			map.put("message", "Not found data");
		}
		return map;
	}

}
