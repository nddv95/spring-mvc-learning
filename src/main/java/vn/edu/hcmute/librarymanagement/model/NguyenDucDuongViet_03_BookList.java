/**
 * 
 */
package vn.edu.hcmute.librarymanagement.model;

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
import javax.persistence.UniqueConstraint;

/**
 * @author Nguyen Duc Duong Viet
 *
 *         Dec 11, 2016
 *         
 *         model mapping to book_list table in database
 */
@Entity
@Table(name = "book_list", uniqueConstraints = @UniqueConstraint(columnNames = { "book_code" }))
public class NguyenDucDuongViet_03_BookList {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "book_id", nullable = false)
	private NguyenDucDuongViet_03_Book book;

	// mã vạch
	@Column(name = "book_code", nullable = false)
	private String bookCode;

	@OneToMany(mappedBy = "bookList")
	private List<NguyenDucDuongViet_03_BorrowBookDetail> borrowBookDetails;

	@Column(name = "is_return")
	private boolean isReturn;

	/**
	 * 
	 */
	public NguyenDucDuongViet_03_BookList() {

	}

	/**
	 * @param id
	 * @param book
	 * @param bookCode
	 * @param borrowBookDetails
	 * @param isReturn
	 */
	public NguyenDucDuongViet_03_BookList(int id, NguyenDucDuongViet_03_Book book, String bookCode, boolean isReturn) {
		this.id = id;
		this.book = book;
		this.bookCode = bookCode;
		this.isReturn = isReturn;
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
	 * @return the book
	 */
	public NguyenDucDuongViet_03_Book getBook() {
		return book;
	}

	/**
	 * @param book
	 *            the book to set
	 */
	public void setBook(NguyenDucDuongViet_03_Book book) {
		this.book = book;
	}

	/**
	 * @return the bookCode
	 */
	public String getBookCode() {
		return bookCode;
	}

	/**
	 * @param bookCode
	 *            the bookCode to set
	 */
	public void setBookCode(String bookCode) {
		this.bookCode = bookCode;
	}
	
	

	/**
	 * @return the isReturn
	 */
	public boolean isReturn() {
		return isReturn;
	}

	/**
	 * @param isReturn the isReturn to set
	 */
	public void setReturn(boolean isReturn) {
		this.isReturn = isReturn;
	}

	/**
	 * @return the borrowBookDetails
	 */
	public List<NguyenDucDuongViet_03_BorrowBookDetail> getBorrowBookDetails() {
		return borrowBookDetails;
	}

	/**
	 * @param borrowBookDetails
	 *            the borrowBookDetails to set
	 */
	public void setBorrowBookDetails(List<NguyenDucDuongViet_03_BorrowBookDetail> borrowBookDetails) {
		this.borrowBookDetails = borrowBookDetails;
	}

}
