/**
 * 
 */
package vn.edu.hcmute.librarymanagement.dao;

import java.util.List;

import vn.edu.hcmute.librarymanagement.model.NguyenDucDuongViet_03_Book;
import vn.edu.hcmute.librarymanagement.model.NguyenDucDuongViet_03_User;

/**
 * @author Nguyen Duc Duong Viet
 *
 * Dec 12, 2016
 * 
 * Access to Book table in database
 */


public interface NguyenDucDuongViet_03_BookDAO {
	
	/**
	 * @return list all book in database
	 */
	public List<NguyenDucDuongViet_03_Book> findAll();
	
	/**
	 * @param id
	 * @return find a book by id
	 */
	public NguyenDucDuongViet_03_Book findBookById(int id);
	
	/**
	 * @param category_id
	 * @return list book find by category
	 */
	public List<NguyenDucDuongViet_03_Book> findBookByCategory(int category_id);
	
	/**
	 * @param category_id
	 * @return list book related find by category
	 */
	public List<NguyenDucDuongViet_03_Book> findRelatedByCategory(int category_id);
	
	/**
	 * @param 
	 * @return list book hot in month
	 */
	public List<NguyenDucDuongViet_03_Book> findBookHotInMonth();
	
	/**
	 * @param user
	 * @return list book by user dept (major)
	 */
	public List<NguyenDucDuongViet_03_Book> findBookByUserDept(NguyenDucDuongViet_03_User user);
	
	/**
	 * @param search param
	 * @return list book by name book or author's book
	 */
	public List<NguyenDucDuongViet_03_Book> findBookByNameOrAuthor(String search);
	
	/**
	 * @param book
	 * @return save or update book
	 */
	public boolean saveOrUpdate(NguyenDucDuongViet_03_Book book);
	
	/**
	 * @param book
	 * @return delete book
	 */
	public boolean delete(NguyenDucDuongViet_03_Book book);

}
