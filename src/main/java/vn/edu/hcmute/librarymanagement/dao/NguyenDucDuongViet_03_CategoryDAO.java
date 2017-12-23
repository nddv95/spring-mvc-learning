/**
 * 
 */
package vn.edu.hcmute.librarymanagement.dao;

import java.util.List;

import vn.edu.hcmute.librarymanagement.model.NguyenDucDuongViet_03_Category;

/**
 * @author Nguyen Duc Duong Viet
 *
 * Dec 12, 2016
 * 
 * Define method access to category table
 */
public interface NguyenDucDuongViet_03_CategoryDAO {
	
	

	/**
	 * Get all categories 
	 */
	public List<NguyenDucDuongViet_03_Category> findAll();
	
	/**
	 * Get a category by id
	 */
	public NguyenDucDuongViet_03_Category findById(int id);
	
	/**
	 * Insert or Update category
	 */
	public boolean saveOrUpdate(NguyenDucDuongViet_03_Category category);
	
	/**
	 * delete a category
	 */
	public boolean delete(NguyenDucDuongViet_03_Category category);
	


}
