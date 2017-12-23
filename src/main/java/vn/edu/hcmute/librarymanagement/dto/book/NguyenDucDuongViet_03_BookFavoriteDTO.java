/**
 * 
 */
package vn.edu.hcmute.librarymanagement.dto.book;

/**
 * @author Nguyen Duc Duong Viet
 *
 *         Dec 14, 2016
 * 
 *         Data Tranfer Object for json response
 * 
 *         Use to tranfer book BookFavorite info
 */
public class NguyenDucDuongViet_03_BookFavoriteDTO {

	private Integer id;
	private NguyenDucDuongViet_03_BookDTO book;
	private NguyenDucDuongViet_03_UserDTO user;

	/**
	 * 
	 */
	public NguyenDucDuongViet_03_BookFavoriteDTO() {

	}

	/**
	 * @param id
	 * @param book
	 * @param user
	 */
	public NguyenDucDuongViet_03_BookFavoriteDTO(Integer id, NguyenDucDuongViet_03_BookDTO book,
			NguyenDucDuongViet_03_UserDTO user) {

		this.id = id;
		this.book = book;
		this.user = user;
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
	 * @return the book
	 */
	public NguyenDucDuongViet_03_BookDTO getBook() {
		return book;
	}

	/**
	 * @param book
	 *            the book to set
	 */
	public void setBook(NguyenDucDuongViet_03_BookDTO book) {
		this.book = book;
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

}
