package vn.edu.hcmute.librarymanagement.dao;

import java.util.List;

import vn.edu.hcmute.librarymanagement.model.NguyenDucDuongViet_03_OrderBook;
import vn.edu.hcmute.librarymanagement.model.NguyenDucDuongViet_03_OrderBookDetail;

/**
 * @author Nguyen Duc Duong Viet
 *
 *         Dec 14, 2016
 * 
 *         Define method access to order_book and order_book_detail table
 * 
 */
public interface NguyenDucDuongViet_03_OrderBookDAO {

	/**
	 * @return list orderBooks
	 */
	public List<NguyenDucDuongViet_03_OrderBook> findAllOrderBook();

	/**
	 * @param id
	 * @return orderBook by id
	 */
	public NguyenDucDuongViet_03_OrderBook findOrderBookById(int id);
	
	/**
	 * @param userId
	 * @return orderBook by userId
	 */
	public NguyenDucDuongViet_03_OrderBook findOrderBookByUser(int userId);

	/**
	 * @param id order id
	 * @return list order book detail of order book
	 */
	public List<NguyenDucDuongViet_03_OrderBookDetail> findOrderBookDetailByOrder(int orderBookId);

	/**
	 * @param id
	 * @return orderBookDetail by id
	 */
	public NguyenDucDuongViet_03_OrderBookDetail findOrderBookDetailById(int id);
	
	/**
	 * @param orderId, bookId
	 * @return orderBookDetail by order and book
	 */
	public NguyenDucDuongViet_03_OrderBookDetail findOrderBookDetailByOrderAndBook(int orderId, int bookId);

	/**
	 * @param orderBook
	 * @return true if save/update order success
	 */
	public int saveOrderBook(NguyenDucDuongViet_03_OrderBook orderBook);

	/**
	 * @param orderBookDetail
	 * @return true if save order detail success
	 */
	public boolean saveOrderBookDetail(NguyenDucDuongViet_03_OrderBookDetail orderBookDetail);
	
	/**
	 * @param orderId
	 * @return true if delete order success
	 */
	public boolean deleteOrder(int orderId);
	
	/**
	 * @param orderDetailId
	 * @return true if delete order detail success
	 */
	public boolean deleteOrderDetail(int orderDetailId);

}
