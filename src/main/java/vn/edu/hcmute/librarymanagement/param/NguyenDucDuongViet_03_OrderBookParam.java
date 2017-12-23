/**
 * 
 */
package vn.edu.hcmute.librarymanagement.param;

import java.util.List;

import vn.edu.hcmute.librarymanagement.dto.book.NguyenDucDuongViet_03_BookDTO;

/**
 * @author Nguyen Duc Duong Viet
 *
 *         Dec 14, 2016
 * 
 *         param to mapping data from request
 *         
 *         use in OrderBookController
 * 
 */
public class NguyenDucDuongViet_03_OrderBookParam {

	private int userId;
	//danh sách sách đặt
	private List<NguyenDucDuongViet_03_BookDTO> books;

	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * @return the books
	 */
	public List<NguyenDucDuongViet_03_BookDTO> getBooks() {
		return books;
	}

	/**
	 * @param books
	 *            the books to set
	 */
	public void setBooks(List<NguyenDucDuongViet_03_BookDTO> books) {
		this.books = books;
	}

	/**
	 * @param userId
	 * @param books
	 */
	public NguyenDucDuongViet_03_OrderBookParam(int userId, List<NguyenDucDuongViet_03_BookDTO> books) {
		this.userId = userId;
		this.books = books;
	}

	/**
	 * 
	 */
	public NguyenDucDuongViet_03_OrderBookParam() {
	}

}
