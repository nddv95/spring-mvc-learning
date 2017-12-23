/**
 * 
 */
package vn.edu.hcmute.librarymanagement.dao;

import java.util.List;

import vn.edu.hcmute.librarymanagement.model.NguyenDucDuongViet_03_BookOffset;

/**
 * @author Nguyen Duc Duong Viet
 *
 * Dec 12, 2016
 * 
 * Access to book_offset table
 */
public interface NguyenDucDuongViet_03_BookOffsetDAO {
	
	/**
	 * @return List all info offset book
	 */
	public List<NguyenDucDuongViet_03_BookOffset> findAll();
	
	/**
	 * @return list info offset book by borrow
	 */
	public List<NguyenDucDuongViet_03_BookOffset> findByBorrow(int borrowId);
	
	/**
	 * @param id
	 * @return a book offset by id
	 */
	public NguyenDucDuongViet_03_BookOffset findById(int id);
	
	/**
	 * save new bookOffset
	 * @param bookOffset
	 * @return true if success
	 */
	public boolean save(NguyenDucDuongViet_03_BookOffset bookOffset);

}
