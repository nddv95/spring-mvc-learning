/**
 * 
 */
package vn.edu.hcmute.librarymanagement.dto.book;

import java.sql.Timestamp;

/**
 * @author Nguyen Duc Duong Viet
 *
 *         Dec 22, 2016
 * 
 *         Data Tranfer Object for json response
 *         
 *         Use to tranfer info borrow book info
 * 
 */
public class NguyenDucDuongViet_03_BorrowBookDTO {
	
	private int id;
	
	//thông tin sv mượn
	private NguyenDucDuongViet_03_UserDTO user;
	
	//ngày mượn
	private Timestamp dateBorrow;
	
	//ngày trả
	private Timestamp dateReturn;

	/**
	 * 
	 */
	public NguyenDucDuongViet_03_BorrowBookDTO() {

	}

	/**
	 * @param id
	 * @param user
	 * @param dateBorrow
	 * @param dateReturn
	 */
	public NguyenDucDuongViet_03_BorrowBookDTO(int id, NguyenDucDuongViet_03_UserDTO user, Timestamp dateBorrow, Timestamp dateReturn) {
		this.id = id;
		this.user = user;
		this.dateBorrow = dateBorrow;
		this.dateReturn = dateReturn;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
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
