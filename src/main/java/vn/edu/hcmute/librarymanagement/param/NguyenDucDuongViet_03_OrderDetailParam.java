/**
 * 
 */
package vn.edu.hcmute.librarymanagement.param;

/**
 * @author Nguyen Duc Duong Viet
 *
 *         Dec 22, 2016
 * 
 *         param to mapping data from request
 *         
 *         use in OrderBookController
 * 
 */
public class NguyenDucDuongViet_03_OrderDetailParam {

	//mã đặt
	private int orderId;
	//mã sách đặt
	private int bookId;

	/**
	 * 
	 */
	public NguyenDucDuongViet_03_OrderDetailParam() {
	}

	/**
	 * @param orderId
	 * @param bookId
	 */
	public NguyenDucDuongViet_03_OrderDetailParam(int orderId, int bookId) {
		this.orderId = orderId;
		this.bookId = bookId;
	}

	/**
	 * @return the orderId
	 */
	public int getOrderId() {
		return orderId;
	}

	/**
	 * @param orderId
	 *            the orderId to set
	 */
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	/**
	 * @return the bookId
	 */
	public int getBookId() {
		return bookId;
	}

	/**
	 * @param bookId
	 *            the bookId to set
	 */
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

}
