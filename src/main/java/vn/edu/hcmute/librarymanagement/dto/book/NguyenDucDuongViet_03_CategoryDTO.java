/**
 * 
 */
package vn.edu.hcmute.librarymanagement.dto.book;

/**
 * @author Nguyen Duc Duong Viet
 *
 *         Dec 13, 2016
 * 
 *         Data Tranfer Object for json response
 *         
 *         Use to tranfer info category
 * 
 */
public class NguyenDucDuongViet_03_CategoryDTO {

	private Integer id;

	private String categoryName;

	/**
	 * 
	 */
	public NguyenDucDuongViet_03_CategoryDTO() {
	}

	/**
	 * @param id
	 * @param categoryName
	 */
	public NguyenDucDuongViet_03_CategoryDTO(Integer id, String categoryName) {
		super();
		this.id = id;
		this.categoryName = categoryName;
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
	 * @return the categoryName
	 */
	public String getCategoryName() {
		return categoryName;
	}

	/**
	 * @param categoryName
	 *            the categoryName to set
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

}
