/**
 * 
 */
package vn.edu.hcmute.librarymanagement.dao;

import java.util.List;

import vn.edu.hcmute.librarymanagement.model.NguyenDucDuongViet_03_BookFavorite;

/**
 * @author Nguyen Duc Duong Viet
 *
 * Dec 12, 2016
 * 
 * Access to book_favorite table
 * 
 */
public interface NguyenDucDuongViet_03_BookFavoriteDAO {
	
	/**
	 * @param userId
	 * @return list book user's favorite
	 */
	public List<NguyenDucDuongViet_03_BookFavorite> findBookFavoriteByUser(int userId);
	
	/**
	 * @param id
	 * @return a book user's favorite by id
	 */
	public NguyenDucDuongViet_03_BookFavorite findBookFavoriteById(int id);
	
	/**
	 * @param userId, bookId
	 * @return a book user's favorite
	 */
	public NguyenDucDuongViet_03_BookFavorite findBookFavoriteExist(int userId, int bookId);
	
	/**
	 * @param bookFavorite
	 * @return insert new book favorite, true if success
	 */
	public boolean save(NguyenDucDuongViet_03_BookFavorite bookFavorite);
	
	/**
	 * @param bookFavorite
	 * @return delete a book favorite, true if success
	 */
	public boolean delete(NguyenDucDuongViet_03_BookFavorite bookFavorite);
	
	/**
	 * @param bookFavorite
	 * @return delete all book favorite of user, true if success
	 */
	public boolean deleteAll(int userId);

}
