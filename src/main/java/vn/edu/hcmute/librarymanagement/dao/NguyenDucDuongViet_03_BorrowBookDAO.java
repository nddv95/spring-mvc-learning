/**
 * 
 */
package vn.edu.hcmute.librarymanagement.dao;

import java.util.List;

import vn.edu.hcmute.librarymanagement.model.NguyenDucDuongViet_03_BorrowBook;

/**
 * @author Nguyen Duc Duong Viet
 *
 *         Dec 12, 2016
 * 
 *         Access to borrow_book table
 */
public interface NguyenDucDuongViet_03_BorrowBookDAO {

	/**
	 * @return List all info borrow not return
	 */
	public List<NguyenDucDuongViet_03_BorrowBook> findAll();
	
	/**
	 * @return list all info borrow in database
	 */
	public List<NguyenDucDuongViet_03_BorrowBook> findAllBorrow();

	/**
	 * @param id borrowId
	 * @return a Info borrow book by id
	 */
	public NguyenDucDuongViet_03_BorrowBook findById(int id);

	/**
	 * @param userId
	 * @return a Info borrow book by user
	 */
	public NguyenDucDuongViet_03_BorrowBook findByUser(int userId);

	/**
	 * save new borrow
	 * @param borrowBook
	 * @return id of new borrow if save success
	 */
	public int save(NguyenDucDuongViet_03_BorrowBook borrowBook);

	/**
	 * @param id
	 * @return true if delete success
	 */
	public boolean delete(int id);

}
