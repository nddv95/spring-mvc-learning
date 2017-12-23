/**
 * 
 */
package vn.edu.hcmute.librarymanagement.model;

import javax.persistence.CascadeType;
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
 * Dec 13, 2016
 * 
 * model mapping to order_book_detail table in database
 */

@Entity
@Table(name = "order_book_detail")
public class NguyenDucDuongViet_03_OrderBookDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "book_id", nullable = false)
	private NguyenDucDuongViet_03_Book book;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "order_book_id", nullable = false)
	private NguyenDucDuongViet_03_OrderBook orderBook;
	
	

	/**
	 * 
	 */
	public NguyenDucDuongViet_03_OrderBookDetail() {}

	/**
	 * @param id
	 * @param book
	 * @param orderBook
	 */
	public NguyenDucDuongViet_03_OrderBookDetail(int id, NguyenDucDuongViet_03_Book book,
			NguyenDucDuongViet_03_OrderBook orderBook) {
		this.id = id;
		this.book = book;
		this.orderBook = orderBook;
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
	 * @return the orderBook
	 */
	public NguyenDucDuongViet_03_OrderBook getOrderBook() {
		return orderBook;
	}

	/**
	 * @param orderBook the orderBook to set
	 */
	public void setOrderBook(NguyenDucDuongViet_03_OrderBook orderBook) {
		this.orderBook = orderBook;
	}
	
	

}
