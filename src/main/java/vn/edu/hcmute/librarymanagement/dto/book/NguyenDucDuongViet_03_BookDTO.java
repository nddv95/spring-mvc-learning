/**
 * 
 */
package vn.edu.hcmute.librarymanagement.dto.book;

import java.sql.Timestamp;

/**
 * @author Nguyen Duc Duong Viet
 *
 *         Dec 13, 2016
 * 
 *         Data Tranfer Object for json response
 *         
 *         Use to tranfer book info
 * 
 */
public class NguyenDucDuongViet_03_BookDTO {

	private Integer id;

	private String name;

	private NguyenDucDuongViet_03_CategoryDTO category;

	//NXB
	private String publishingFirm;

	//Ngày xuất bản
	private Timestamp publishDate;

	private String author;

	private String image;

	private int amount;

	/**
	 * 
	 */
	public NguyenDucDuongViet_03_BookDTO() {
	}

	/**
	 * @param id
	 * @param name
	 * @param category
	 * @param publishingFirm
	 * @param publishDate
	 * @param author
	 * @param image
	 * @param amount
	 */
	public NguyenDucDuongViet_03_BookDTO(Integer id, String name, NguyenDucDuongViet_03_CategoryDTO category, String publishingFirm, Timestamp publishDate,
			String author, String image, int amount) {
		this.id = id;
		this.name = name;
		this.category = category;
		this.publishingFirm = publishingFirm;
		this.publishDate = publishDate;
		this.author = author;
		this.image = image;
		this.amount = amount;
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the category
	 */
	public NguyenDucDuongViet_03_CategoryDTO getCategory() {
		return category;
	}

	/**
	 * @param category
	 *            the category to set
	 */
	public void setCategory(NguyenDucDuongViet_03_CategoryDTO category) {
		this.category = category;
	}

	/**
	 * @return the publishingFirm
	 */
	public String getPublishingFirm() {
		return publishingFirm;
	}

	/**
	 * @param publishingFirm
	 *            the publishingFirm to set
	 */
	public void setPublishingFirm(String publishingFirm) {
		this.publishingFirm = publishingFirm;
	}

	/**
	 * @return the publishDate
	 */
	public Timestamp getPublishDate() {
		return publishDate;
	}

	/**
	 * @param publishDate
	 *            the publishDate to set
	 */
	public void setPublishDate(Timestamp publishDate) {
		this.publishDate = publishDate;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author
	 *            the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
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
	 * @return the amount
	 */
	public int getAmount() {
		return amount;
	}

	/**
	 * @param amount
	 *            the amount to set
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}

}
