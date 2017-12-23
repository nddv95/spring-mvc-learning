/**
 * 
 */
package vn.edu.hcmute.librarymanagement.service;

import java.util.List;

import vn.edu.hcmute.librarymanagement.dto.book.NguyenDucDuongViet_03_BookFavoriteDTO;

/**
 * @author Nguyen Duc Duong Viet
 *
 *         Dec 14, 2016
 * 
 *         BookFavoriteService for controller
 *         
 *         Define function for BookFavorite use case
 *
 */
public interface NguyenDucDuongViet_03_BookFavoriteService {

	/**
	 * @param userId
	 * @return list book user's favorite
	 */
	public List<NguyenDucDuongViet_03_BookFavoriteDTO> findBookFavoriteByUser(int userId);

	/**
	 * @param id
	 * @return a book user's favorite by id
	 */
	public NguyenDucDuongViet_03_BookFavoriteDTO findBookFavoriteById(int id);

	/**
	 * @param bookId, userId
	 * @return true if insert new book favorite success
	 */
	public boolean save(int bookId, int userId);

	/**
	 * @param bookFavorite
	 * @return true if delete a book favorite success
	 */
	public boolean delete(int id);

	/**
	 * @param bookFavorite
	 * @return true if delete all book favorite of user success
	 */
	public boolean deleteAll(int userId);

}
