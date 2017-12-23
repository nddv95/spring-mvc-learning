/**
 * 
 */
package vn.edu.hcmute.librarymanagement.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
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
import vn.edu.hcmute.librarymanagement.dto.book.NguyenDucDuongViet_03_OrderBookDTO;
import vn.edu.hcmute.librarymanagement.dto.book.NguyenDucDuongViet_03_OrderDTO;
import vn.edu.hcmute.librarymanagement.dto.book.NguyenDucDuongViet_03_UserDTO;
import vn.edu.hcmute.librarymanagement.param.NguyenDucDuongViet_03_OrderBookParam;
import vn.edu.hcmute.librarymanagement.param.NguyenDucDuongViet_03_OrderDetailParam;
import vn.edu.hcmute.librarymanagement.service.NguyenDucDuongViet_03_OrderBookService;

/**
 * @author Nguyen Duc Duong Viet
 *
 *         Dec 24, 2016
 * 
 *         Denfine handle event when client access to url
 * 
 *         This class work with OrderBook/Đặt sách
 * 
 *         Nguyên tăc: Thông tin đặt sách được lưu trong session =>> Đăng xuất
 *         sẽ mất Có thể đặt sách bổ sung tiếp khi thông tin đặt còn trong hạn
 *         lấy sách
 */
@Controller
public class NguyenDucDuongViet_03_OrderBookController {

	/**
	 * orderService chứa danh sách các hàm để thực hiện các chức năng chính về
	 * OrderBook/Đặt sách
	 */
	@Autowired
	private NguyenDucDuongViet_03_OrderBookService orderService;

	/**
	 * dùng xuất thông tin ra console
	 */
	private static final Logger logger = LoggerFactory.getLogger(NguyenDucDuongViet_03_OrderBookController.class);

	/**
	 * 
	 * @param session
	 *            xách định user, quyền user
	 * @return Thông tin chi tiết về việc đặt sách (Thông tin user, danh sách
	 *         sách đặt) của user, dạng json
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getOrderDetail", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> getOrderDetail(HttpSession session) {
		logger.info("Get order detail");
		Map<String, Object> map = new HashMap<String, Object>();
		NguyenDucDuongViet_03_UserDTO user = (NguyenDucDuongViet_03_UserDTO) session.getAttribute("user");
		List<NguyenDucDuongViet_03_BookDTO> bookOrder = (List<NguyenDucDuongViet_03_BookDTO>) session.getAttribute("lstBookOrder");
		if (user == null || bookOrder == null) {
			map.put("status", "404");
			map.put("message", "Data Not Found");
		} else {
			NguyenDucDuongViet_03_OrderDTO order = new NguyenDucDuongViet_03_OrderDTO();
			order.setBooks(bookOrder);
			order.setUser(user);
			map.put("status", "200");
			map.put("message", "Data found");
			map.put("data", order);
		}
		return map;
	}

	/**
	 * Xóa một sách đặt trong danh sách tạm thời
	 * @param bookId
	 * @param session
	 *            xách định user, quyền user
	 * @return xóa thành công hay thất bại, dạng json
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/deleteOrderDetail/{bookId}", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> deletOrderDetail(@PathVariable int bookId, HttpSession session) {
		logger.info("delete order detail");
		Map<String, Object> map = new HashMap<String, Object>();
		NguyenDucDuongViet_03_UserDTO user = (NguyenDucDuongViet_03_UserDTO) session.getAttribute("user");
		List<NguyenDucDuongViet_03_BookDTO> bookOrder = (List<NguyenDucDuongViet_03_BookDTO>) session.getAttribute("lstBookOrder");
		if (user == null || bookOrder == null) {
			map.put("status", "400");
			map.put("message", "Bad request");
		} else {
			if (bookOrder.size() > 1) {
				Iterator<NguyenDucDuongViet_03_BookDTO> iterator = bookOrder.iterator();
				List<NguyenDucDuongViet_03_BookDTO> bookOrderNew = new ArrayList<>();
				while (iterator.hasNext()) {
					NguyenDucDuongViet_03_BookDTO dto = iterator.next();
					if (dto.getId() == bookId)
						iterator.remove();
					else
						bookOrderNew.add(dto);
				}
				session.setAttribute("lstBookOrder", bookOrderNew);
			} else {
				session.removeAttribute("lstBookOrder");
			}
			map.put("status", "200");
			map.put("message", "Delete success");
		}
		return map;
	}

	/**
	 * 
	 * Lưu thông tin đặt sách
	 * @param session
	 *            xách định user, quyền user
	 * @param model
	 * @return thành công chuyển về view xem danh sách sách đặt
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/addOrder", method = RequestMethod.GET)
	public String addOrder(HttpSession session, Model model) {
		logger.info("Add order book");
		//get user
		NguyenDucDuongViet_03_UserDTO user = (NguyenDucDuongViet_03_UserDTO) session.getAttribute("user");
		//get thông tin sách đặt trong session
		List<NguyenDucDuongViet_03_BookDTO> bookOrder = (List<NguyenDucDuongViet_03_BookDTO>) session.getAttribute("lstBookOrder");
		//object chua 2 thong tin tre
		NguyenDucDuongViet_03_OrderBookParam param = new NguyenDucDuongViet_03_OrderBookParam();
		param.setUserId(user.getId());
		param.setBooks(bookOrder);
		//save database
		if (orderService.orderBook(param)) {
			session.removeAttribute("lstBookOrder");
			return "redirect:/mybook";
		}
		model.addAttribute("error", "Đã xãy ra lỗi khi đặt sách");
		return "order";
	}

	/**
	 * @param session
	 *            xách định user, quyền user
	 * @return Thông tin sách mượn theo user, dạng json
	 */
	@RequestMapping(value = "/getOrderListByUser", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> getOrderListByUser(HttpSession session) {
		logger.info("Get order detail of user");
		Map<String, Object> map = new HashMap<String, Object>();
		NguyenDucDuongViet_03_UserDTO user = (NguyenDucDuongViet_03_UserDTO) session.getAttribute("user");
		if (user == null) {
			map.put("status", "403");
			map.put("message", "Bad request");
		} else {
			NguyenDucDuongViet_03_OrderDTO order = orderService.findOrderDetailByUser(user.getId());
			if (order != null) {
				map.put("status", "200");
				map.put("message", "Data found");
				map.put("data", order);
			}
		}
		return map;
	}

	/**
	 * @param param Ánh xạ dữ liệu từ request có: borrowId and bookId
	 * @param session
	 *            xách định user, quyền user
	 * @return kết quả thực hiện việc xóa sách đặt, dạng json
	 */
	@RequestMapping(value = "/deteteOrderDetail", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> deleteOrderDetail(@RequestBody NguyenDucDuongViet_03_OrderDetailParam param,
			HttpSession session) {
		logger.info("delete order detail of user");
		Map<String, Object> map = new HashMap<String, Object>();
		NguyenDucDuongViet_03_UserDTO user = (NguyenDucDuongViet_03_UserDTO) session.getAttribute("user");
		if (user == null) {
			map.put("status", "403");
			map.put("message", "Bad request");
		} else {
			if (orderService.deleteOrderDetail(param)) {
				map.put("status", "200");
				map.put("message", "Delete successfully");
			}
		}
		return map;
	}

	/**
	 * @param session
	 *            xách định user, quyền user
	 * @return tất cả thông tin đặt sách, dạng json
	 */
	@RequestMapping(value = "/getAllOrder", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> getAllOrder(HttpSession session) {
		logger.info("Get all order...");
		Map<String, Object> map = new HashMap<String, Object>();
		NguyenDucDuongViet_03_UserDTO user = (NguyenDucDuongViet_03_UserDTO) session.getAttribute("user");
		if (user == null) {
			map.put("status", "403");
			map.put("message", "Bad request");
		} else {
			if (user.getRole() == 2) {
				List<NguyenDucDuongViet_03_OrderBookDTO> orders = orderService.findAllOrderBook();
				if (orders != null) {
					map.put("status", "200");
					map.put("message", "Data found");
					map.put("data", orders);
				}
			}
		}
		return map;
	}

	/**
	 * @param session
	 *            xách định user, quyền user
	 * @param id order id
	 * @return thông tin đặt sách chi tiết theo 1 id, dạng json
	 */
	@RequestMapping(value = "/getOrder/{id}", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> getOrder(HttpSession session, @PathVariable int id) {
		logger.info("Get info order by id: " + id);
		Map<String, Object> map = new HashMap<String, Object>();
		NguyenDucDuongViet_03_UserDTO user = (NguyenDucDuongViet_03_UserDTO) session.getAttribute("user");
		if (user != null) {
			if (user.getRole() == 2) {
				NguyenDucDuongViet_03_OrderDTO order = orderService.findOrderDetail(id);
				if (order != null) {
					map.put("status", "200");
					map.put("message", "Data found");
					map.put("data", order);
				} else {
					map.put("status", "404");
					map.put("message", "Data not found");
				}
			}
		}
		return map;
	}

	/**
	 * Xóa một cuốn sách trong danh sách sách đặt
	 * @param id orderDetailId
	 * @param session
	 *            xách định user, quyền user
	 * @return thành công hay thất bại dạng json
	 */
	@RequestMapping(value = "/deteteOrder/{id}", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> deleteOrderById(@PathVariable int id, HttpSession session) {
		logger.info("delete order detail of user");
		Map<String, Object> map = new HashMap<String, Object>();
		NguyenDucDuongViet_03_UserDTO user = (NguyenDucDuongViet_03_UserDTO) session.getAttribute("user");
		if (user == null) {
			map.put("status", "403");
			map.put("message", "Bad request");
		} else {
			if (orderService.deleteOrder(id)) {
				map.put("status", "200");
				map.put("message", "Delete successfully");
			}
		}
		return map;
	}

}
