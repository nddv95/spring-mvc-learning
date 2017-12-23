/**
 * 
 */
package vn.edu.hcmute.librarymanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.edu.hcmute.librarymanagement.dao.NguyenDucDuongViet_03_BookDAO;
import vn.edu.hcmute.librarymanagement.dao.NguyenDucDuongViet_03_BookFavoriteDAO;
import vn.edu.hcmute.librarymanagement.dao.NguyenDucDuongViet_03_UserDAO;
import vn.edu.hcmute.librarymanagement.dto.book.NguyenDucDuongViet_03_BookDTO;
import vn.edu.hcmute.librarymanagement.dto.book.NguyenDucDuongViet_03_BookFavoriteDTO;
import vn.edu.hcmute.librarymanagement.dto.book.NguyenDucDuongViet_03_CategoryDTO;
import vn.edu.hcmute.librarymanagement.dto.book.NguyenDucDuongViet_03_UserDTO;
import vn.edu.hcmute.librarymanagement.model.NguyenDucDuongViet_03_BookFavorite;

/**
 * @author Nguyen Duc Duong Viet
 *
 *         Dec 14, 2016
 *         
 *         implement BookFavoriteService interface
 */

@Service
public class NguyenDucDuongViet_03_BookFavoriteServiceImpl implements NguyenDucDuongViet_03_BookFavoriteService {

	/**
	 * bookFavoriteDAO chứa các hàm truy cấp csdl bảng book_favorite
	 */
	@Autowired
	private NguyenDucDuongViet_03_BookFavoriteDAO bookFavoriteDAO;

	/**
	 * userDAO chứa các hàm truy cấp csdl bảng book
	 */
	@Autowired
	private NguyenDucDuongViet_03_BookDAO bookDAO;

	/**
	 * userDAO chứa các hàm truy cấp csdl bảng user
	 */
	@Autowired
	private NguyenDucDuongViet_03_UserDAO userDAO;

	/* (non-Javadoc)
	 * @see vn.edu.hcmute.librarymanagement.service.NguyenDucDuongViet_03_BookFavoriteService#findBookFavoriteByUser(int)
	 */
	@Override
	public List<NguyenDucDuongViet_03_BookFavoriteDTO> findBookFavoriteByUser(int userId) {
		//biến kết quả
		List<NguyenDucDuongViet_03_BookFavoriteDTO> lstDTO = new ArrayList<>();
		//lấy danh sách yêu thích cưa user
		List<NguyenDucDuongViet_03_BookFavorite> lstBookFavorite = bookFavoriteDAO.findBookFavoriteByUser(userId);
		
		//đưa thông tin vào kết quả
		for (NguyenDucDuongViet_03_BookFavorite bookFav : lstBookFavorite) {
			NguyenDucDuongViet_03_BookFavoriteDTO dto = new NguyenDucDuongViet_03_BookFavoriteDTO();
			dto.setId(bookFav.getId());
			dto.setBook(new NguyenDucDuongViet_03_BookDTO(bookFav.getBook().getId(), bookFav.getBook().getName(),
					new NguyenDucDuongViet_03_CategoryDTO(bookFav.getBook().getCategory().getId(),
							bookFav.getBook().getCategory().getCategoryName()),
					bookFav.getBook().getPublishingFirm(), bookFav.getBook().getPublishDate(),
					bookFav.getBook().getAuthor(), bookFav.getBook().getImage(), bookFav.getBook().getAmount()));
			dto.setUser(new NguyenDucDuongViet_03_UserDTO(bookFav.getUser().getId(), bookFav.getUser().getUsername(),
					bookFav.getUser().getPassword(), bookFav.getUser().getFullName(), bookFav.getUser().getDept(),
					bookFav.getUser().getClassName(), bookFav.getUser().getDateOfBirth(),
					bookFav.getUser().getAddress(), bookFav.getUser().getIndentification(),
					bookFav.getUser().getPhone(), bookFav.getUser().getAvatar(), bookFav.getUser().getRole()));
			lstDTO.add(dto);
		}
		return lstDTO;
	}

	/* (non-Javadoc)
	 * @see vn.edu.hcmute.librarymanagement.service.NguyenDucDuongViet_03_BookFavoriteService#findBookFavoriteById(int)
	 */
	@Override
	public NguyenDucDuongViet_03_BookFavoriteDTO findBookFavoriteById(int id) {
		//biến lưu kết quả
		NguyenDucDuongViet_03_BookFavoriteDTO dto = new NguyenDucDuongViet_03_BookFavoriteDTO();
		//lây sách yêu thích bằng id yêu thích
		NguyenDucDuongViet_03_BookFavorite bookFav = bookFavoriteDAO.findBookFavoriteById(id);
		
		//set dữ liệu cho kết quả
		dto.setId(bookFav.getId());
		dto.setBook(new NguyenDucDuongViet_03_BookDTO(bookFav.getBook().getId(), bookFav.getBook().getName(),
				new NguyenDucDuongViet_03_CategoryDTO(bookFav.getBook().getCategory().getId(),
						bookFav.getBook().getCategory().getCategoryName()),
				bookFav.getBook().getPublishingFirm(), bookFav.getBook().getPublishDate(),
				bookFav.getBook().getAuthor(), bookFav.getBook().getImage(), bookFav.getBook().getAmount()));
		dto.setUser(new NguyenDucDuongViet_03_UserDTO(bookFav.getUser().getId(), bookFav.getUser().getUsername(),
				bookFav.getUser().getPassword(), bookFav.getUser().getFullName(), bookFav.getUser().getDept(),
				bookFav.getUser().getClassName(), bookFav.getUser().getDateOfBirth(), bookFav.getUser().getAddress(),
				bookFav.getUser().getIndentification(), bookFav.getUser().getPhone(), bookFav.getUser().getAvatar(),
				bookFav.getUser().getRole()));
		return dto;
	}

	/* (non-Javadoc)
	 * @see vn.edu.hcmute.librarymanagement.service.NguyenDucDuongViet_03_BookFavoriteService#delete(int)
	 */
	@Override
	public boolean delete(int id) {
		NguyenDucDuongViet_03_BookFavorite bf = bookFavoriteDAO.findBookFavoriteById(id);
		return bookFavoriteDAO.delete(bf);
	}

	/* (non-Javadoc)
	 * @see vn.edu.hcmute.librarymanagement.service.NguyenDucDuongViet_03_BookFavoriteService#deleteAll(int)
	 */
	@Override
	public boolean deleteAll(int userId) {
		return bookFavoriteDAO.deleteAll(userId);
	}

	/* (non-Javadoc)
	 * @see vn.edu.hcmute.librarymanagement.service.NguyenDucDuongViet_03_BookFavoriteService#save(int, int)
	 */
	@Override
	public boolean save(int bookId, int userId) {
		NguyenDucDuongViet_03_BookFavorite bf = new NguyenDucDuongViet_03_BookFavorite();
		//lưu khi chưa tồn tại
		if (bookFavoriteDAO.findBookFavoriteExist(userId, bookId) == null) {
			bf.setBook(bookDAO.findBookById(bookId));
			bf.setUser(userDAO.findUserById(userId));
			return bookFavoriteDAO.save(bf);
		}
		return false;
	}

}
