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
 *         Dec 9, 2016
 *         
 *         model mapping to order_book table in database
 */

@Entity
@Table(name = "order_book")
public class NguyenDucDuongViet_03_OrderBook {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id", nullable = false)
	private NguyenDucDuongViet_03_User user;

	@Column(name = "date_order", nullable = false)
	private Timestamp dateOrder;

	@Column(name = "date_end", nullable = false)
	private Timestamp dateEnd;

	@Column(name = "is_taken_book")
	private boolean isTakenBook;
	
	@OneToMany(mappedBy = "orderBook", fetch = FetchType.EAGER)
	private List<NguyenDucDuongViet_03_OrderBookDetail> orderBookDetails;

	public NguyenDucDuongViet_03_OrderBook() {

	}



	/**
	 * @param id
	 * @param user
	 * @param dateOrder
	 * @param dateEnd
	 * @param isTakenBook
	 */
	public NguyenDucDuongViet_03_OrderBook(int id, NguyenDucDuongViet_03_User user, Timestamp dateOrder,
			Timestamp dateEnd, boolean isTakenBook) {
		this.id = id;
		this.user = user;
		this.dateOrder = dateOrder;
		this.dateEnd = dateEnd;
		this.isTakenBook = isTakenBook;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public NguyenDucDuongViet_03_User getUser() {
		return user;
	}

	public void setUser(NguyenDucDuongViet_03_User user) {
		this.user = user;
	}

	

	/**
	 * @return the isTakenBook
	 */
	public boolean isTakenBook() {
		return isTakenBook;
	}



	/**
	 * @param isTakenBook the isTakenBook to set
	 */
	public void setTakenBook(boolean isTakenBook) {
		this.isTakenBook = isTakenBook;
	}



	/**
	 * @return the orderBookDetails
	 */
	public List<NguyenDucDuongViet_03_OrderBookDetail> getOrderBookDetails() {
		return orderBookDetails;
	}



	/**
	 * @param orderBookDetails the orderBookDetails to set
	 */
	public void setOrderBookDetails(List<NguyenDucDuongViet_03_OrderBookDetail> orderBookDetails) {
		this.orderBookDetails = orderBookDetails;
	}



	public Timestamp getDateOrder() {
		return dateOrder;
	}

	public void setDateOrder(Timestamp dateOrder) {
		this.dateOrder = dateOrder;
	}

	public Timestamp getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(Timestamp dateEnd) {
		this.dateEnd = dateEnd;
	}

	/**
	 * @return the isTakeBook
	 */
	public boolean isTakeBook() {
		return isTakenBook;
	}

	/**
	 * @param isTakeBook
	 *            the isTakeBook to set
	 */
	public void setTakeBook(boolean isTakeBook) {
		this.isTakenBook = isTakeBook;
	}

}
