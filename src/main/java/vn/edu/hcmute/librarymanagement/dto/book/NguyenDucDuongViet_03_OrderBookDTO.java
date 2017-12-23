/**
 * 
 */
package vn.edu.hcmute.librarymanagement.dto.book;

import java.sql.Timestamp;

/**
 * @author Nguyen Duc Duong Viet
 *
 *         Dec 14, 2016
 * 
 *         Data Tranfer Object for json response
 *         
 *         Use to tranfer info order book
 * 
 */
public class NguyenDucDuongViet_03_OrderBookDTO {

	private int id;

	//thông tin sv
	private NguyenDucDuongViet_03_UserDTO user;

	//ngày đặt
	private Timestamp dateOrder;

	//ngày kết thúc
	private Timestamp dateEnd;

	/**
	 * 
	 */
	public NguyenDucDuongViet_03_OrderBookDTO() {
	}

	/**
	 * @param id
	 * @param user
	 * @param dateOrder
	 * @param dateEnd
	 */
	public NguyenDucDuongViet_03_OrderBookDTO(int id, NguyenDucDuongViet_03_UserDTO user, Timestamp dateOrder, Timestamp dateEnd) {
		this.id = id;
		this.user = user;
		this.dateOrder = dateOrder;
		this.dateEnd = dateEnd;
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
	 * @return the dateOrder
	 */
	public Timestamp getDateOrder() {
		return dateOrder;
	}

	/**
	 * @param dateOrder
	 *            the dateOrder to set
	 */
	public void setDateOrder(Timestamp dateOrder) {
		this.dateOrder = dateOrder;
	}

	/**
	 * @return the dateEnd
	 */
	public Timestamp getDateEnd() {
		return dateEnd;
	}

	/**
	 * @param dateEnd
	 *            the dateEnd to set
	 */
	public void setDateEnd(Timestamp dateEnd) {
		this.dateEnd = dateEnd;
	}

}
