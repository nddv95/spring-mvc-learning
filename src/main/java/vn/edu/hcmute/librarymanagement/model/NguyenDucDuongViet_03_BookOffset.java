/**
 * 
 */
package vn.edu.hcmute.librarymanagement.model;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Nguyen Duc Duong Viet
 *
 * Dec 11, 2016
 * 
 * model mapping to book_offset table in database
 */

@Entity
@Table(name = "book_offset")
public class NguyenDucDuongViet_03_BookOffset {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "borrow_book_id", nullable = false)
	private NguyenDucDuongViet_03_BorrowBook borrowBook;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "book_id", nullable = false)
	private NguyenDucDuongViet_03_Book book;
	
	@Column(name = "book_code")
	private String bookCode;
	
	@Column(name = "offset_date")
	private Timestamp offsetDate;

	/**
	 * 
	 */
	public NguyenDucDuongViet_03_BookOffset() {

	}

	/**
	 * @param id
	 * @param borrowBook
	 * @param book
	 * @param bookCode
	 * @param offsetDate
	 */
	public NguyenDucDuongViet_03_BookOffset(int id, NguyenDucDuongViet_03_BorrowBook borrowBook,
			NguyenDucDuongViet_03_Book book, String bookCode, Timestamp offsetDate) {
		this.id = id;
		this.borrowBook = borrowBook;
		this.book = book;
		this.bookCode = bookCode;
		this.offsetDate = offsetDate;
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
	 * @return the borrowBook
	 */
	public NguyenDucDuongViet_03_BorrowBook getBorrowBook() {
		return borrowBook;
	}

	/**
	 * @param borrowBook the borrowBook to set
	 */
	public void setBorrowBook(NguyenDucDuongViet_03_BorrowBook borrowBook) {
		this.borrowBook = borrowBook;
	}

	/**
	 * @return the book
	 */
	public NguyenDucDuongViet_03_Book getBook() {
		return book;
	}

	/**
	 * @param book the book to set
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
	 * @param bookCode the bookCode to set
	 */
	public void setBookCode(String bookCode) {
		this.bookCode = bookCode;
	}

	/**
	 * @return the offsetDate
	 */
	public Timestamp getOffsetDate() {
		return offsetDate;
	}

	/**
	 * @param offsetDate the offsetDate to set
	 */
	public void setOffsetDate(Timestamp offsetDate) {
		this.offsetDate = offsetDate;
	}	
	

}
