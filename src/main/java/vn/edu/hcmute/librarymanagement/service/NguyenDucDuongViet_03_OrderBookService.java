/**
 * 
 */
package vn.edu.hcmute.librarymanagement.service;

import java.util.List;

import vn.edu.hcmute.librarymanagement.dto.book.NguyenDucDuongViet_03_OrderBookDTO;
import vn.edu.hcmute.librarymanagement.dto.book.NguyenDucDuongViet_03_OrderDTO;
import vn.edu.hcmute.librarymanagement.param.NguyenDucDuongViet_03_OrderBookParam;
import vn.edu.hcmute.librarymanagement.param.NguyenDucDuongViet_03_OrderDetailParam;

/**
 * @author Nguyen Duc Duong Viet
 *
 *         Dec 14, 2016
 * 
 *         OrderBookService for OrderBookController
 *         
 *         Define function for Order book use case
 * 
 */
public interface NguyenDucDuongViet_03_OrderBookService {

	/**
	 * @return all Order
	 */
	public List<NguyenDucDuongViet_03_OrderBookDTO> findAllOrderBook();

	/**
	 * @param orderDetailId orderId
	 * @return Order Info by orderId
	 */
	public NguyenDucDuongViet_03_OrderDTO findOrderDetail(int orderDetailId);

	/**
	 * @param userId
	 * @return Order Info by user
	 */
	public NguyenDucDuongViet_03_OrderDTO findOrderDetailByUser(int userId);

	/**
	 * add new order book
	 * @param param
	 * @return true if success
	 */
	public boolean orderBook(NguyenDucDuongViet_03_OrderBookParam param);

	/**
	 * @param orderId
	 * @return true if success
	 */
	public boolean deleteOrder(int orderId);

	/**
	 * delete orderDetail by orderDetailId
	 * @param orderDetailId
	 * @return true if success
	 */
	public boolean deleteOrderDetail(int orderDetailId);
	
	/**
	 * 
	 * delete orderDetail by orderId and bookId
	 * @param OrderDetailParam
	 * @return true if success
	 */
	public boolean deleteOrderDetail(NguyenDucDuongViet_03_OrderDetailParam param);

}
