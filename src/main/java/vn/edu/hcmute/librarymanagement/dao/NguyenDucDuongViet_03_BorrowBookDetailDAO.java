/**
 * 
 */
package vn.edu.hcmute.librarymanagement.dao;

import java.util.List;

import vn.edu.hcmute.librarymanagement.model.NguyenDucDuongViet_03_BorrowBookDetail;

/**
 * @author Nguyen Duc Duong Viet
 *
 * Dec 12, 2016
 * 
 * Access to borrow_book_detail
 */
public interface NguyenDucDuongViet_03_BorrowBookDetailDAO {
	
	/**
	 * @param borrowId
	 * @return list borrow detail of borrow
	 */
	public List<NguyenDucDuongViet_03_BorrowBookDetail> findBorrowBookDetailByBorrowId(int borrowId);
	
	/**
	 * @param 
	 * @return list borrow detail not return book yet
	 */
	public List<NguyenDucDuongViet_03_BorrowBookDetail> findBorrowBookDetailNotReturn();
	
	/**
	 * @param id
	 * @return a borrow detail by id
	 */
	public NguyenDucDuongViet_03_BorrowBookDetail findById(int id);
	
	/**
	 * @param detail
	 * @return true if save success
	 */
	public boolean save(NguyenDucDuongViet_03_BorrowBookDetail detail);
	
	/**
	 * @param id
	 * @return true if delete success
	 */
	public boolean delete(int id);

}
