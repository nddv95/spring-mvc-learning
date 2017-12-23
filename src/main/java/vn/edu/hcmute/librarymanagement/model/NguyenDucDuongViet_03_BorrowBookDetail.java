/**
 * 
 */
package vn.edu.hcmute.librarymanagement.model;

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
 * model mapping to borrow_book_detail table in database
 */

@Entity
@Table(name = "borrow_book_detail")
public class NguyenDucDuongViet_03_BorrowBookDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "borrow_id",nullable = false)
	private NguyenDucDuongViet_03_BorrowBook borrowBook;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "book_list_id",nullable = false)
	private NguyenDucDuongViet_03_BookList bookList;
	
	@Column(name = "is_return")
	private boolean isReturn;
	
	
	/**
	 * 
	 */
	public NguyenDucDuongViet_03_BorrowBookDetail() {}

	

	/**
	 * @param id
	 * @param borrowBook
	 * @param bookList
	 * @param isReturn
	 */
	public NguyenDucDuongViet_03_BorrowBookDetail(int id, NguyenDucDuongViet_03_BorrowBook borrowBook,
			NguyenDucDuongViet_03_BookList bookList, boolean isReturn) {
		this.id = id;
		this.borrowBook = borrowBook;
		this.bookList = bookList;
		this.isReturn = isReturn;
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
	 * @return the bookList
	 */
	public NguyenDucDuongViet_03_BookList getBookList() {
		return bookList;
	}

	/**
	 * @param bookList the bookList to set
	 */
	public void setBookList(NguyenDucDuongViet_03_BookList bookList) {
		this.bookList = bookList;
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
	
	
	
}
