/**
 * 
 */
package vn.edu.hcmute.librarymanagement.param;

/**
 * @author Nguyen Duc Duong Viet
 *
 *         Dec 23, 2016
 *         
 *         param to mapping data from request
 *         
 *         use in BorrowBookController to return book
 *         
 */
public class NguyenDucDuongViet_03_ReturnBookParam {

	//mã mượn
	private Integer borrowId;
	
	//mã sách mượn
	private Integer bookId;

	/**
	 * 
	 */
	public NguyenDucDuongViet_03_ReturnBookParam() {

	}

	/**
	 * @param borrowId
	 * @param bookId
	 */
	public NguyenDucDuongViet_03_ReturnBookParam(Integer borrowId, Integer bookId) {

		this.borrowId = borrowId;
		this.bookId = bookId;
	}

	/**
	 * @return the borrowId
	 */
	public Integer getBorrowId() {
		return borrowId;
	}

	/**
	 * @param borrowId
	 *            the borrowId to set
	 */
	public void setBorrowId(Integer borrowId) {
		this.borrowId = borrowId;
	}

	/**
	 * @return the bookId
	 */
	public Integer getBookId() {
		return bookId;
	}

	/**
	 * @param bookId
	 *            the bookId to set
	 */
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

}
