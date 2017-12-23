/**
 * 
 */
package vn.edu.hcmute.librarymanagement.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Nguyen Duc Duong Viet
 *
 *         Dec 11, 2016
 *         
 *         model mapping to borrow_book table in database
 */
@Entity
@Table(name = "borrow_book")
public class NguyenDucDuongViet_03_BorrowBook {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id", nullable = false)
	private NguyenDucDuongViet_03_User user;

	@Column(name = "date_borrow")
	private Timestamp dateBorrow;

	@Column(name = "date_return")
	private Timestamp dateReturn;
	
	@OneToMany(mappedBy = "borrowBook", fetch = FetchType.EAGER)
	private List<NguyenDucDuongViet_03_BookOffset> bookOffsets;
	
	@OneToMany(mappedBy = "borrowBook", fetch = FetchType.EAGER)
	private List<NguyenDucDuongViet_03_BorrowBookDetail> borrowBookDetails;

		
	/**
	 * 
	 */
	public NguyenDucDuongViet_03_BorrowBook() {

	}

	/**
	 * @param id
	 * @param user
	 * @param bookList
	 * @param dateBorrow
	 * @param dateReturn
	 */
	public NguyenDucDuongViet_03_BorrowBook(int id, NguyenDucDuongViet_03_User user,
			NguyenDucDuongViet_03_BookList bookList, Timestamp dateBorrow, Timestamp dateReturn) {
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
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the user
	 */
	public NguyenDucDuongViet_03_User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(NguyenDucDuongViet_03_User user) {
		this.user = user;
	}

	/**
	 * @return the dateBorrow
	 */
	public Timestamp getDateBorrow() {
		return dateBorrow;
	}

	/**
	 * @param dateBorrow the dateBorrow to set
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
	 * @param dateReturn the dateReturn to set
	 */
	public void setDateReturn(Timestamp dateReturn) {
		this.dateReturn = dateReturn;
	}

	/**
	 * @return the bookOffsets
	 */
	public List<NguyenDucDuongViet_03_BookOffset> getBookOffsets() {
		return bookOffsets;
	}

	/**
	 * @param bookOffsets the bookOffsets to set
	 */
	public void setBookOffsets(List<NguyenDucDuongViet_03_BookOffset> bookOffsets) {
		this.bookOffsets = bookOffsets;
	}

	/**
	 * @return the borrowBookDetails
	 */
	public List<NguyenDucDuongViet_03_BorrowBookDetail> getBorrowBookDetails() {
		return borrowBookDetails;
	}

	/**
	 * @param borrowBookDetails the borrowBookDetails to set
	 */
	public void setBorrowBookDetails(List<NguyenDucDuongViet_03_BorrowBookDetail> borrowBookDetails) {
		this.borrowBookDetails = borrowBookDetails;
	}
	
	

}
