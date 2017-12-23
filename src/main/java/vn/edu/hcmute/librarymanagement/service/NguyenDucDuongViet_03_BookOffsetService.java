/**
 * 
 */
package vn.edu.hcmute.librarymanagement.service;

import java.util.List;

import vn.edu.hcmute.librarymanagement.dto.book.NguyenDucDuongViet_03_BookOffsetDTO;
import vn.edu.hcmute.librarymanagement.dto.book.NguyenDucDuongViet_03_BorrowOffsetDTO;

/**
 * @author Nguyen Duc Duong Viet
 *
 * Dec 24, 2016
 * 
 * Sevice for BookOffsetController
 * 
 * Define function for BookOffset use case
 */
public interface NguyenDucDuongViet_03_BookOffsetService {
	
	
	/**
	 * @return all book offset info
	 */
	public List<NguyenDucDuongViet_03_BookOffsetDTO> findAll();
	
	/**
	 * @param id borrow id
	 * @return a book offset info by borrow id
	 */
	public NguyenDucDuongViet_03_BookOffsetDTO findByBorrowId(int id);
	
	/**
	 * @param data
	 * @return true if success
	 */
	public boolean save(NguyenDucDuongViet_03_BookOffsetDTO data);
	
	/**
	 * 
	 * @return book can offset with borrow info
	 */
	public List<NguyenDucDuongViet_03_BorrowOffsetDTO> getAllBookCanOffset();
	
	/**
	 * @param bookCode
	 * @return true if exist
	 */
	public boolean CheckBookCodeExist(String bookCode);

}
