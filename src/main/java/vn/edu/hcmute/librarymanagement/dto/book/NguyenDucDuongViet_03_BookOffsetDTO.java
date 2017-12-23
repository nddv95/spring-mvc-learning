/**
 * 
 */
package vn.edu.hcmute.librarymanagement.dto.book;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author Nguyen Duc Duong Viet
 *
 *         Dec 24, 2016
 * 
 *         Data Tranfer Object for json response
 *         
 *         Use to tranfer info book offset 
 * 
 */
public class NguyenDucDuongViet_03_BookOffsetDTO {

	//Mã mượn được thực hiện đền bù
	private int borrowBookId;
	
	//Thông tin Sinh viên đền bù
	private NguyenDucDuongViet_03_UserDTO user;

	//Thông tin sách được đền bù
	private List<NguyenDucDuongViet_03_BookListDTO> books;

	//Ngày đền bù
	private Timestamp offsetDate;

	/**
	 * 
	 */
	public NguyenDucDuongViet_03_BookOffsetDTO() {

	}

	


	/**
	 * @param borrowBookId
	 * @param user
	 * @param books
	 * @param offsetDate
	 */
	public NguyenDucDuongViet_03_BookOffsetDTO(int borrowBookId, NguyenDucDuongViet_03_UserDTO user, List<NguyenDucDuongViet_03_BookListDTO> books, Timestamp offsetDate) {
		this.borrowBookId = borrowBookId;
		this.user = user;
		this.books = books;
		this.offsetDate = offsetDate;
	}




	/**
	 * @return the borrowBookId
	 */
	public int getBorrowBookId() {
		return borrowBookId;
	}

	/**
	 * @param borrowBookId
	 *            the borrowBookId to set
	 */
	public void setBorrowBookId(int borrowBookId) {
		this.borrowBookId = borrowBookId;
	}

	/**
	 * @return the book
	 */
	public List<NguyenDucDuongViet_03_BookListDTO> getBooks() {
		return books;
	}

	/**
	 * @param book
	 *            the book to set
	 */
	public void setBooks(List<NguyenDucDuongViet_03_BookListDTO> books) {
		this.books = books;
	}

	/**
	 * @return the offsetDate
	 */
	public Timestamp getOffsetDate() {
		return offsetDate;
	}

	/**
	 * @param offsetDate
	 *            the offsetDate to set
	 */
	public void setOffsetDate(Timestamp offsetDate) {
		this.offsetDate = offsetDate;
	}

	/**
	 * @return the user
	 */
	public NguyenDucDuongViet_03_UserDTO getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(NguyenDucDuongViet_03_UserDTO user) {
		this.user = user;
	}
	
	

}
