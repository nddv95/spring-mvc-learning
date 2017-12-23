/**
 * 
 */
package vn.edu.hcmute.librarymanagement.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.edu.hcmute.librarymanagement.dao.NguyenDucDuongViet_03_BookDAO;
import vn.edu.hcmute.librarymanagement.dao.NguyenDucDuongViet_03_OrderBookDAO;
import vn.edu.hcmute.librarymanagement.dao.NguyenDucDuongViet_03_UserDAO;
import vn.edu.hcmute.librarymanagement.dto.book.NguyenDucDuongViet_03_BookDTO;
import vn.edu.hcmute.librarymanagement.dto.book.NguyenDucDuongViet_03_CategoryDTO;
import vn.edu.hcmute.librarymanagement.dto.book.NguyenDucDuongViet_03_OrderBookDTO;
import vn.edu.hcmute.librarymanagement.dto.book.NguyenDucDuongViet_03_OrderDTO;
import vn.edu.hcmute.librarymanagement.dto.book.NguyenDucDuongViet_03_UserDTO;
import vn.edu.hcmute.librarymanagement.model.NguyenDucDuongViet_03_Book;
import vn.edu.hcmute.librarymanagement.model.NguyenDucDuongViet_03_OrderBook;
import vn.edu.hcmute.librarymanagement.model.NguyenDucDuongViet_03_OrderBookDetail;
import vn.edu.hcmute.librarymanagement.model.NguyenDucDuongViet_03_User;
import vn.edu.hcmute.librarymanagement.param.NguyenDucDuongViet_03_OrderBookParam;
import vn.edu.hcmute.librarymanagement.param.NguyenDucDuongViet_03_OrderDetailParam;

/**
 * @author Nguyen Duc Duong Viet
 *
 *         Dec 14, 2016
 * 
 *         Implement OrderBookService interface
 */

@Service
public class NguyenDucDuongViet_03_OrderBookServiceImpl implements NguyenDucDuongViet_03_OrderBookService {

	/**
	 * orderBookDAO chứa các hàm truy cập csdl bảng order_book/order_detail
	 */
	@Autowired
	private NguyenDucDuongViet_03_OrderBookDAO orderBookDAO;
	
	/**
	 * bookDAO chứa các hàm truy cập csdl bảng book
	 */
	@Autowired
	private NguyenDucDuongViet_03_BookDAO bookDAO;
	
	/**
	 * userDAO chứa các hàm truy cập csdl bảng user
	 */
	@Autowired
	private NguyenDucDuongViet_03_UserDAO userDAO;

	/* (non-Javadoc)
	 * @see vn.edu.hcmute.librarymanagement.service.NguyenDucDuongViet_03_OrderBookService#findAllOrderBook()
	 */
	@Override
	public List<NguyenDucDuongViet_03_OrderBookDTO> findAllOrderBook() {
		List<NguyenDucDuongViet_03_OrderBookDTO> lstOrderDTO = new ArrayList<>();
		//lấy tất cả thông tin đặt
		List<NguyenDucDuongViet_03_OrderBook> lstOrder = orderBookDAO.findAllOrderBook();
		
		//set dữ liệu
		for (NguyenDucDuongViet_03_OrderBook orderBook : lstOrder) {
			NguyenDucDuongViet_03_OrderBookDTO dto = new NguyenDucDuongViet_03_OrderBookDTO();
			dto.setId(orderBook.getId());
			dto.setUser(new NguyenDucDuongViet_03_UserDTO(orderBook.getUser().getId(), orderBook.getUser().getUsername(),
					orderBook.getUser().getPassword(), orderBook.getUser().getFullName(), orderBook.getUser().getDept(),
					orderBook.getUser().getClassName(), orderBook.getUser().getDateOfBirth(),
					orderBook.getUser().getAddress(), orderBook.getUser().getIndentification(),
					orderBook.getUser().getPhone(), orderBook.getUser().getAvatar(), orderBook.getUser().getRole()));
			dto.setDateOrder(orderBook.getDateOrder());
			dto.setDateEnd(orderBook.getDateEnd());
			lstOrderDTO.add(dto);
		}

		return lstOrderDTO;
	}

	/* (non-Javadoc)
	 * @see vn.edu.hcmute.librarymanagement.service.NguyenDucDuongViet_03_OrderBookService#findOrderDetail(int)
	 */
	@Override
	public NguyenDucDuongViet_03_OrderDTO findOrderDetail(int orderDetailId) {
		NguyenDucDuongViet_03_OrderDTO dto = new NguyenDucDuongViet_03_OrderDTO();
		//lấy thông tin đặt  theo một order id
		NguyenDucDuongViet_03_OrderBook orderBook = orderBookDAO.findOrderBookById(orderDetailId);
		if (orderBook == null)
			return null;
		
		//lấy danh sách sách đặt của order id
		List<NguyenDucDuongViet_03_OrderBookDetail> orderDetail = orderBookDAO
				.findOrderBookDetailByOrder(orderDetailId);

		//set dữ liệu
		dto.setId(orderBook.getId());
		dto.setDateOrder(orderBook.getDateOrder());
		dto.setDateEnd(orderBook.getDateEnd());
		dto.setUser(new NguyenDucDuongViet_03_UserDTO(orderBook.getUser().getId(), orderBook.getUser().getUsername(),
				orderBook.getUser().getPassword(), orderBook.getUser().getFullName(), orderBook.getUser().getDept(),
				orderBook.getUser().getClassName(), orderBook.getUser().getDateOfBirth(),
				orderBook.getUser().getAddress(), orderBook.getUser().getIndentification(),
				orderBook.getUser().getPhone(), orderBook.getUser().getAvatar(), orderBook.getUser().getRole()));
		List<NguyenDucDuongViet_03_BookDTO> lstBookOrder = new ArrayList<>();
		for (NguyenDucDuongViet_03_OrderBookDetail detail : orderDetail) {
			lstBookOrder.add(new NguyenDucDuongViet_03_BookDTO(detail.getBook().getId(), detail.getBook().getName(),
					new NguyenDucDuongViet_03_CategoryDTO(detail.getBook().getCategory().getId(),
							detail.getBook().getCategory().getCategoryName()),
					detail.getBook().getPublishingFirm(), detail.getBook().getPublishDate(),
					detail.getBook().getAuthor(), detail.getBook().getImage(), detail.getBook().getAmount()));
		}
		dto.setBooks(lstBookOrder);
		return dto;
	}

	/* (non-Javadoc)
	 * @see vn.edu.hcmute.librarymanagement.service.NguyenDucDuongViet_03_OrderBookService#findOrderDetailByUser(int)
	 */
	@Override
	public NguyenDucDuongViet_03_OrderDTO findOrderDetailByUser(int userId) {
		NguyenDucDuongViet_03_OrderDTO dto = new NguyenDucDuongViet_03_OrderDTO();
		//lấy thông tin đặt theo user
		NguyenDucDuongViet_03_OrderBook orderBook = orderBookDAO.findOrderBookByUser(userId);
		if (orderBook == null)
			return null;
		//lấy danh sách sách đặt của orderBook lấy được
		List<NguyenDucDuongViet_03_OrderBookDetail> orderDetail = orderBookDAO
				.findOrderBookDetailByOrder(orderBook.getId());

		//set dữ liệu
		dto.setId(orderBook.getId());
		dto.setDateOrder(orderBook.getDateOrder());
		dto.setDateEnd(orderBook.getDateEnd());
		dto.setUser(new NguyenDucDuongViet_03_UserDTO(orderBook.getUser().getId(), orderBook.getUser().getUsername(),
				orderBook.getUser().getPassword(), orderBook.getUser().getFullName(), orderBook.getUser().getDept(),
				orderBook.getUser().getClassName(), orderBook.getUser().getDateOfBirth(),
				orderBook.getUser().getAddress(), orderBook.getUser().getIndentification(),
				orderBook.getUser().getPhone(), orderBook.getUser().getAvatar(), orderBook.getUser().getRole()));
		List<NguyenDucDuongViet_03_BookDTO> lstBookOrder = new ArrayList<>();
		for (NguyenDucDuongViet_03_OrderBookDetail detail : orderDetail) {
			lstBookOrder.add(new NguyenDucDuongViet_03_BookDTO(detail.getBook().getId(), detail.getBook().getName(),
					new NguyenDucDuongViet_03_CategoryDTO(detail.getBook().getCategory().getId(),
							detail.getBook().getCategory().getCategoryName()),
					detail.getBook().getPublishingFirm(), detail.getBook().getPublishDate(),
					detail.getBook().getAuthor(), detail.getBook().getImage(), detail.getBook().getAmount()));
		}
		dto.setBooks(lstBookOrder);
		return dto;
	}

	/* (non-Javadoc)
	 * @see vn.edu.hcmute.librarymanagement.service.NguyenDucDuongViet_03_OrderBookService#orderBook(vn.edu.hcmute.librarymanagement.param.NguyenDucDuongViet_03_OrderBookParam)
	 */
	@Override
	public boolean orderBook(NguyenDucDuongViet_03_OrderBookParam param) {
		//lấy user
		NguyenDucDuongViet_03_User user = userDAO.findUserById(param.getUserId());
		
		//set thông tin order mới
		NguyenDucDuongViet_03_OrderBook orderBook = new NguyenDucDuongViet_03_OrderBook();
		orderBook.setUser(user);
		orderBook.setTakenBook(false);
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime end = now.plusDays(2);
		orderBook.setDateOrder(Timestamp.valueOf(now));
		orderBook.setDateEnd(Timestamp.valueOf(end));
		int id = 0;
		//check đã phiếu đặt của user trước chưa, nếu có thì thêm sách vào order đã có, chưa thì thêm mới
		NguyenDucDuongViet_03_OrderBook orderBefore = orderBookDAO.findOrderBookByUser(param.getUserId());
		if (orderBefore == null)
			id = orderBookDAO.saveOrderBook(orderBook);
		else
			id = orderBefore.getId();
		if (id == -1) {
			return false;
		}
		
		//lưu chi tiết sách thông tin đặt
		for (NguyenDucDuongViet_03_BookDTO dto : param.getBooks()) {
			NguyenDucDuongViet_03_Book book = bookDAO.findBookById(dto.getId());
			NguyenDucDuongViet_03_OrderBookDetail orderBookDetail = new NguyenDucDuongViet_03_OrderBookDetail();
			orderBookDetail.setBook(book);
			orderBookDetail.setOrderBook(orderBookDAO.findOrderBookById(id));
			if (orderBookDAO.findOrderBookDetailByOrderAndBook(orderBookDetail.getOrderBook().getId(),
					orderBookDetail.getBook().getId()) == null)
				orderBookDAO.saveOrderBookDetail(orderBookDetail);
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see vn.edu.hcmute.librarymanagement.service.NguyenDucDuongViet_03_OrderBookService#deleteOrder(int)
	 */
	@Override
	public boolean deleteOrder(int orderId) {
		return orderBookDAO.deleteOrder(orderId);
	}

	/* (non-Javadoc)
	 * @see vn.edu.hcmute.librarymanagement.service.NguyenDucDuongViet_03_OrderBookService#deleteOrderDetail(int)
	 */
	@Override
	public boolean deleteOrderDetail(int orderDetailId) {
		return orderBookDAO.deleteOrder(orderDetailId);
	}

	/* (non-Javadoc)
	 * @see vn.edu.hcmute.librarymanagement.service.NguyenDucDuongViet_03_OrderBookService#deleteOrderDetail(vn.edu.hcmute.librarymanagement.param.NguyenDucDuongViet_03_OrderDetailParam)
	 */
	@Override
	public boolean deleteOrderDetail(NguyenDucDuongViet_03_OrderDetailParam param) {
		//tìm kiếm thông tin đặt chi tiết theo OrderId và BookId
		NguyenDucDuongViet_03_OrderBookDetail orderBookDetail = orderBookDAO
				.findOrderBookDetailByOrderAndBook(param.getOrderId(), param.getBookId());
		if (orderBookDetail == null)
			return false;
		//xóa thông tin đặt chi tiết
		orderBookDAO.deleteOrderDetail(orderBookDetail.getId());
		
		//nếu đã xóa hết thì xóa luôn Order
		if (orderBookDAO.findOrderBookDetailByOrder(param.getOrderId()) == null
				|| orderBookDAO.findOrderBookDetailByOrder(param.getOrderId()).isEmpty()) {
			orderBookDAO.deleteOrder(param.getOrderId());
		}
		return true;
	}

}
