package vn.edu.hcmute.librarymanagement.dto.book;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author Nguyen Duc Duong Viet
 *
 *         Dec 25, 2016
 *         
 *         Data Tranfer Object for json response
 *         
 *         Use to tranfer info order book with list order's book detail
 */
public class NguyenDucDuongViet_03_OrderDTO {

	private int id;
	
	//thông tin sv
	private NguyenDucDuongViet_03_UserDTO user;
	
	//danh sách sách đặt
	private List<NguyenDucDuongViet_03_BookDTO> books;
	
	//ngày đặt
	private Timestamp dateOrder;
	
	//ngày kết thúc
	private Timestamp dateEnd;

	/**
	 * 
	 */
	public NguyenDucDuongViet_03_OrderDTO() {
	}

	/**
	 * @param id
	 * @param user
	 * @param books
	 * @param dateOrder
	 * @param dateEnd
	 */
	public NguyenDucDuongViet_03_OrderDTO(int id, NguyenDucDuongViet_03_UserDTO user,
			List<NguyenDucDuongViet_03_BookDTO> books, Timestamp dateOrder, Timestamp dateEnd) {
		this.id = id;
		this.user = user;
		this.books = books;
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
	 * @return the books
	 */
	public List<NguyenDucDuongViet_03_BookDTO> getBooks() {
		return books;
	}

	/**
	 * @param books
	 *            the books to set
	 */
	public void setBooks(List<NguyenDucDuongViet_03_BookDTO> books) {
		this.books = books;
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
