/**
 * 
 */
package vn.edu.hcmute.librarymanagement.service;

import java.util.List;

import vn.edu.hcmute.librarymanagement.dto.book.NguyenDucDuongViet_03_BookDTO;
import vn.edu.hcmute.librarymanagement.dto.book.NguyenDucDuongViet_03_BookListDTO;
import vn.edu.hcmute.librarymanagement.model.NguyenDucDuongViet_03_User;

/**
 * @author Nguyen Duc Duong Viet
 *
 *         Dec 13, 2016
 * 
 *         Service for BookController
 *         
 *         Define function about Book
 * 
 */
public interface NguyenDucDuongViet_03_BookService {

	/**
	 * @param
	 * @return list all book
	 */
	public List<NguyenDucDuongViet_03_BookDTO> findAll();

	/**
	 * @param
	 * @return find all book in book_list
	 */
	public List<NguyenDucDuongViet_03_BookListDTO> findAllBookList();

	/**
	 * @param id
	 * @return Info book by id
	 */
	public NguyenDucDuongViet_03_BookDTO findBookById(int id);

	/**
	 * @param category_id
	 * @return list book find by category
	 */
	public List<NguyenDucDuongViet_03_BookDTO> findBookByCategory(int category_id);

	/**
	 * @param category_id
	 * @return list book related by category
	 */
	public List<NguyenDucDuongViet_03_BookDTO> findBookRelatedByCategory(int category_id);

	/**
	 * @param
	 * @return list book hot in month
	 */
	public List<NguyenDucDuongViet_03_BookDTO> findBookHotInMonth();

	/**
	 * @param user
	 * @return list book by user dept (major)
	 */
	public List<NguyenDucDuongViet_03_BookDTO> findBookByUserDept(NguyenDucDuongViet_03_User user);

	/**
	 * @param search
	 *            param
	 * @return list book by name book or author's book
	 */
	public List<NguyenDucDuongViet_03_BookDTO> findBookByNameOrAuthor(String search);

	/**
	 * @param book
	 * @return true if save or update book success
	 */
	public boolean saveOrUpdate(NguyenDucDuongViet_03_BookDTO book);

	/**
	 * @param book
	 * @return true if delete book succes
	 */
	public boolean delete(int book_id);

}
