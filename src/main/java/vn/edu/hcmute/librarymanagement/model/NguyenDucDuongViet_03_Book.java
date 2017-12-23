package vn.edu.hcmute.librarymanagement.model;

/**
 * @author Nguyen Duc Duong Viet
 *
 * Dec 9, 2016
 * 
 * model mapping to book table in database
 */

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

@Entity
@Table(name = "book")
public class NguyenDucDuongViet_03_Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "name", length = 50)
	private String name;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "category_id", nullable = false)
	private NguyenDucDuongViet_03_Category category;

	// NXB
	@Column(name = "publishing_firm", length = 100)
	private String publishingFirm;

	// Ngày xuất bản
	@Column(name = "publish_date")
	private Timestamp publishDate;

	@Column(name = "author", length = 50)
	private String author;

	@Column(name = "image", length = 50)
	private String image;

	@Column(name = "amount")
	private int amount;

	@OneToMany(mappedBy = "book")
	private List<NguyenDucDuongViet_03_OrderBookDetail> orderBookDetails;

	@OneToMany(mappedBy = "book")
	private List<NguyenDucDuongViet_03_BookFavorite> bookFavorites;

	@OneToMany(mappedBy = "book")
	private List<NguyenDucDuongViet_03_BookList> bookLists;

	@OneToMany(mappedBy = "book")
	private List<NguyenDucDuongViet_03_BookOffset> bookOffsets;

	public NguyenDucDuongViet_03_Book() {
	}

	public NguyenDucDuongViet_03_Book(int id, String name, NguyenDucDuongViet_03_Category category,
			String publishingFirm, Timestamp publishDate, String author, String image, int amount) {
		this.id = id;
		this.name = name;
		this.category = category;
		this.publishingFirm = publishingFirm;
		this.publishDate = publishDate;
		this.author = author;
		this.image = image;
		this.amount = amount;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public NguyenDucDuongViet_03_Category getCategory() {
		return category;
	}

	public void setCategory(NguyenDucDuongViet_03_Category category) {
		this.category = category;
	}

	public String getPublishingFirm() {
		return publishingFirm;
	}

	public void setPublishingFirm(String publishingFirm) {
		this.publishingFirm = publishingFirm;
	}

	public Timestamp getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Timestamp publishDate) {
		this.publishDate = publishDate;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}

	/**
	 * @param image
	 *            the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}

	/**
	 * @return the orderBookDetails
	 */
	public List<NguyenDucDuongViet_03_OrderBookDetail> getOrderBookDetails() {
		return orderBookDetails;
	}

	/**
	 * @param orderBookDetails
	 *            the orderBookDetails to set
	 */
	public void setOrderBookDetails(List<NguyenDucDuongViet_03_OrderBookDetail> orderBookDetails) {
		this.orderBookDetails = orderBookDetails;
	}

	/**
	 * @return the bookFavorites
	 */
	public List<NguyenDucDuongViet_03_BookFavorite> getBookFavorites() {
		return bookFavorites;
	}

	/**
	 * @param bookFavorites
	 *            the bookFavorites to set
	 */
	public void setBookFavorites(List<NguyenDucDuongViet_03_BookFavorite> bookFavorites) {
		this.bookFavorites = bookFavorites;
	}

	/**
	 * @return the bookLists
	 */
	public List<NguyenDucDuongViet_03_BookList> getBookLists() {
		return bookLists;
	}

	/**
	 * @param bookLists
	 *            the bookLists to set
	 */
	public void setBookLists(List<NguyenDucDuongViet_03_BookList> bookLists) {
		this.bookLists = bookLists;
	}

	/**
	 * @return the bookOffsets
	 */
	public List<NguyenDucDuongViet_03_BookOffset> getBookOffsets() {
		return bookOffsets;
	}

	/**
	 * @param bookOffsets
	 *            the bookOffsets to set
	 */
	public void setBookOffsets(List<NguyenDucDuongViet_03_BookOffset> bookOffsets) {
		this.bookOffsets = bookOffsets;
	}

}
