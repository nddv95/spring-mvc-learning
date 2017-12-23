package vn.edu.hcmute.librarymanagement.model;

/**
 * @author Nguyen Duc Duong Viet
 *
 * Dec 9, 2016
 * 
 * model mapping to category table in database
 */

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "category")
public class NguyenDucDuongViet_03_Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "category_name", length = 30, nullable = false)
	private String categoryName;

	
	@OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
	private List<NguyenDucDuongViet_03_Book> booksByCategory;

	/**
	 * 
	 */
	public NguyenDucDuongViet_03_Category() {

	}

	/**
	 * @param id
	 * @param categoryName
	 */
	public NguyenDucDuongViet_03_Category(int id, String categoryName) {

		this.id = id;
		this.categoryName = categoryName;
	}

	/**
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return
	 */
	public String getCategoryName() {
		return categoryName;
	}

	/**
	 * @param categoryName
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	/**
	 * @return
	 */
	public List<NguyenDucDuongViet_03_Book> getBooksByCategory() {
		return booksByCategory;
	}

	/**
	 * @param booksByCategory
	 */
	public void setBooksByCategory(List<NguyenDucDuongViet_03_Book> booksByCategory) {
		this.booksByCategory = booksByCategory;
	}

}
