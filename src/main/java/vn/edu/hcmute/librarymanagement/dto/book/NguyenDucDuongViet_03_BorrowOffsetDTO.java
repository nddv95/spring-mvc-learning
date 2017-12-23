/**
 * 
 */
package vn.edu.hcmute.librarymanagement.dto.book;

/**
 * @author Nguyen Duc Duong Viet
 *
 *         Dec 24, 2016
 * 
 *         Data Tranfer Object for json response
 *         
 *         Use to tranfer info book in borrow book
 * 
 */
public class NguyenDucDuongViet_03_BorrowOffsetDTO {

	//thông tin mượn sách
	private NguyenDucDuongViet_03_BorrowBookDTO borrow;
	
	//thông tin sách
	private NguyenDucDuongViet_03_BookDTO book;

	/**
	 * 
	 */
	public NguyenDucDuongViet_03_BorrowOffsetDTO() {

	}

	/**
	 * @return the borrow
	 */
	public NguyenDucDuongViet_03_BorrowBookDTO getBorrow() {
		return borrow;
	}

	/**
	 * @param borrow
	 *            the borrow to set
	 */
	public void setBorrow(NguyenDucDuongViet_03_BorrowBookDTO borrow) {
		this.borrow = borrow;
	}

	/**
	 * @return the books
	 */
	public NguyenDucDuongViet_03_BookDTO getBook() {
		return book;
	}

	/**
	 * @param books
	 *            the books to set
	 */
	public void setBook(NguyenDucDuongViet_03_BookDTO book) {
		this.book = book;
	}

}
