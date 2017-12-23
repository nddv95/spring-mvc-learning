package vn.edu.hcmute.librarymanagement.service;

import java.util.List;

import vn.edu.hcmute.librarymanagement.dto.book.NguyenDucDuongViet_03_BorrowBookDTO;
import vn.edu.hcmute.librarymanagement.dto.book.NguyenDucDuongViet_03_BorrowDTO;

/**
 * @author Nguyen Duc Duong Viet
 *
 * Dec 22, 2016
 * 
 * Sevice for BookOffsetController
 * 
 * Define function for BorrowBook use case
 * 
 */
public interface NguyenDucDuongViet_03_BorrowService {
	
	/**
	 * @param userId
	 * @return borrow book with full info detail by user
	 */
	public NguyenDucDuongViet_03_BorrowDTO getBorrowBookDetailByUser(int userId);
	
	/** 
	 * @param id borrowId
	 * @return borrow book with full info detail by id
	 */
	public NguyenDucDuongViet_03_BorrowDTO getBorrowBookDetailById(int id);
	
	/**
	 * @return List borrow info
	 */
	public List<NguyenDucDuongViet_03_BorrowBookDTO> findAllBorrow();
	
	/**
	 * @param borrowId
	 * @param bookId
	 * @return true if success 
	 */
	public boolean returnBook(int borrowId, int bookId);

	/**
	 * @param borrowId
	 * @return true if success
	 */
	public boolean returnAllBook(int borrowId);
	
	/**
	 * @param borrowInfo
	 * @return true if save success
	 */
	public boolean borrowBook(NguyenDucDuongViet_03_BorrowDTO borrowInfo);
	
	/**
	 * @param borrowId
	 * @return borrow info(not include list borrow)
	 */
	public NguyenDucDuongViet_03_BorrowBookDTO findBorrowInfoById(int id);
}
