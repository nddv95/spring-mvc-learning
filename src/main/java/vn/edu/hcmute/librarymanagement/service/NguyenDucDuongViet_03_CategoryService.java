/**
 * 
 */
package vn.edu.hcmute.librarymanagement.service;

import java.util.List;

import vn.edu.hcmute.librarymanagement.dto.book.NguyenDucDuongViet_03_CategoryDTO;

/**
 * @author Nguyen Duc Duong Viet
 *
 *         Dec 13, 2016
 * 
 *         Service for CategoryController
 * 
 *         Define function about Category
 * 
 */
public interface NguyenDucDuongViet_03_CategoryService {

	/**
	 * Get all category
	 */
	public List<NguyenDucDuongViet_03_CategoryDTO> findAll();

	/**
	 * Get a category by id
	 */
	public NguyenDucDuongViet_03_CategoryDTO findById(int id);

	/**
	 * Insert or Update category
	 */
	public boolean saveOrUpdate(NguyenDucDuongViet_03_CategoryDTO category);

	/**
	 * delete a category
	 */
	public boolean delete(int category_id);

}
