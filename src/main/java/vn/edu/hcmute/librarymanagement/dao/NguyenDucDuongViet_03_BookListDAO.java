package vn.edu.hcmute.librarymanagement.dao;

import java.util.List;

import vn.edu.hcmute.librarymanagement.model.NguyenDucDuongViet_03_BookList;

/**
 * @author Nguyen Duc Duong Viet
 *
 *         Dec 15, 2016
 * 
 *         Access to book_list table
 * 
 */
public interface NguyenDucDuongViet_03_BookListDAO {

	/**
	 * @return All book list can borrow
	 */
	public List<NguyenDucDuongViet_03_BookList> findAll();

	/**
	 * @param idBook
	 * @return list bookList by book
	 */
	public List<NguyenDucDuongViet_03_BookList> findBookListByBook(int idBook);

	/**
	 * @param id
	 * @return a bookList by id
	 */
	public NguyenDucDuongViet_03_BookList findBookListById(int id);
	
	/**
	 * @param book code
	 * @return a bookList by book code/mã vạch
	 */
	public NguyenDucDuongViet_03_BookList findBookListByCode(String code);

	/**
	 * @param bookList
	 * @return true if success
	 */
	public boolean save(NguyenDucDuongViet_03_BookList bookList);

	/**
	 * @param id
	 * @return true if success
	 */
	public boolean delete(int id);

}
