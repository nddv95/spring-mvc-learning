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
 *         Dec 9, 2016
 *         
 *         model mapping to book_favorite table in database
 */

@Entity
@Table(name = "book_favorite")
public class NguyenDucDuongViet_03_BookFavorite {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id", nullable = false)
	private NguyenDucDuongViet_03_User user;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "book_id", nullable = false)
	private NguyenDucDuongViet_03_Book book;
	

	/**
	 * 
	 */
	public NguyenDucDuongViet_03_BookFavorite() {
		
	}

	/**
	 * @param id
	 * @param user
	 * @param book
	 * @param creatAt
	 * @param updateAt
	 */
	public NguyenDucDuongViet_03_BookFavorite(int id, NguyenDucDuongViet_03_User user, NguyenDucDuongViet_03_Book book) {
		this.id = id;
		this.user = user;
		this.book = book;
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
	public NguyenDucDuongViet_03_User getUser() {
		return user;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(NguyenDucDuongViet_03_User user) {
		this.user = user;
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
	
	


}
