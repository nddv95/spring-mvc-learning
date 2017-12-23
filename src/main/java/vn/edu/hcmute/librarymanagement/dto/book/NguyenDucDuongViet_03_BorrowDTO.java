/**
 * 
 */
package vn.edu.hcmute.librarymanagement.dto.book;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author Nguyen Duc Duong Viet
 *
 *         Dec 22, 2016
 *         
 *         Data Tranfer Object for json response
 *         
 *         Use to tranfer info borrow book with borrow book detail
 */
public class NguyenDucDuongViet_03_BorrowDTO {
	
	private Integer id;
	
	//thông tin sv 
	private NguyenDucDuongViet_03_UserDTO user;
	
	//danh sách sách mượn
	private List<NguyenDucDuongViet_03_BookListDTO> books;
	
	//ngày mượn
	private Timestamp dateBorrow;
	
	//ngày trả
	private Timestamp dateReturn;

	/**
	 * 
	 */
	public NguyenDucDuongViet_03_BorrowDTO() {
	}

	/**
	 * @param id
	 * @param user
	 * @param books
	 * @param dateBorrow
	 * @param dateReturn
	 */
	public NguyenDucDuongViet_03_BorrowDTO(Integer id, NguyenDucDuongViet_03_UserDTO user, List<NguyenDucDuongViet_03_BookListDTO> books, Timestamp dateBorrow, Timestamp dateReturn) {
		this.id = id;
		this.user = user;
		this.books = books;
		this.dateBorrow = dateBorrow;
		this.dateReturn = dateReturn;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the user
	 */
	public NguyenDucDuongViet_03_UserDTO getUser() {
		return user;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(NguyenDucDuongViet_03_UserDTO user) {
		this.user = user;
	}

	/**
	 * @return the books
	 */
	public List<NguyenDucDuongViet_03_BookListDTO> getBooks() {
		return books;
	}

	/**
	 * @param books
	 *            the books to set
	 */
	public void setBooks(List<NguyenDucDuongViet_03_BookListDTO> books) {
		this.books = books;
	}

	/**
	 * @return the dateBorrow
	 */
	public Timestamp getDateBorrow() {
		return dateBorrow;
	}

	/**
	 * @param dateBorrow
	 *            the dateBorrow to set
	 */
	public void setDateBorrow(Timestamp dateBorrow) {
		this.dateBorrow = dateBorrow;
	}

	/**
	 * @return the dateReturn
	 */
	public Timestamp getDateReturn() {
		return dateReturn;
	}

	/**
	 * @param dateReturn
	 *            the dateReturn to set
	 */
	public void setDateReturn(Timestamp dateReturn) {
		this.dateReturn = dateReturn;
	}

}
