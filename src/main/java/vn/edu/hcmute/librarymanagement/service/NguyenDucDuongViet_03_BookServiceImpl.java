/**
 * 
 */
package vn.edu.hcmute.librarymanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.edu.hcmute.librarymanagement.dao.NguyenDucDuongViet_03_BookDAO;
import vn.edu.hcmute.librarymanagement.dao.NguyenDucDuongViet_03_BookListDAO;
import vn.edu.hcmute.librarymanagement.dto.book.NguyenDucDuongViet_03_BookDTO;
import vn.edu.hcmute.librarymanagement.dto.book.NguyenDucDuongViet_03_BookListDTO;
import vn.edu.hcmute.librarymanagement.dto.book.NguyenDucDuongViet_03_CategoryDTO;
import vn.edu.hcmute.librarymanagement.model.NguyenDucDuongViet_03_Book;
import vn.edu.hcmute.librarymanagement.model.NguyenDucDuongViet_03_BookList;
import vn.edu.hcmute.librarymanagement.model.NguyenDucDuongViet_03_User;

/**
 * @author Nguyen Duc Duong Viet
 *
 *         Dec 13, 2016
 * 
 *         Implement BookService interface
 * 
 */

@Service
public class NguyenDucDuongViet_03_BookServiceImpl implements NguyenDucDuongViet_03_BookService {

	/**
	 * dùng để xuất thông tin trên console
	 */
	private static final Logger logger = LoggerFactory.getLogger(NguyenDucDuongViet_03_BookServiceImpl.class);
	
	/**
	 * bookDAO chứa các hàm truy cấp csdl bảng book
	 */
	@Autowired
	private NguyenDucDuongViet_03_BookDAO bookDAO;
	
	/**
	 * bookListDAO chứa các hàm truy cấp csdl bảng book_list
	 */
	@Autowired
	private NguyenDucDuongViet_03_BookListDAO bookListDAO;

	/* (non-Javadoc)
	 * @see vn.edu.hcmute.librarymanagement.service.NguyenDucDuongViet_03_BookService#findAll()
	 */
	@Override
	public List<NguyenDucDuongViet_03_BookDTO> findAll() {
		//lấy tất cả sách
		List<NguyenDucDuongViet_03_Book> books = bookDAO.findAll();
		
		//set dữ liệu
		List<NguyenDucDuongViet_03_BookDTO> bookDTOs = new ArrayList<NguyenDucDuongViet_03_BookDTO>();
		for (NguyenDucDuongViet_03_Book book : books) {
			NguyenDucDuongViet_03_BookDTO dto = new NguyenDucDuongViet_03_BookDTO();
			dto.setId(book.getId());
			dto.setName(book.getName());
			dto.setCategory(new NguyenDucDuongViet_03_CategoryDTO(book.getCategory().getId(), book.getCategory().getCategoryName()));
			dto.setAuthor(book.getAuthor());
			dto.setPublishingFirm(book.getPublishingFirm());
			dto.setImage(book.getImage());
			dto.setAmount(book.getAmount());
			dto.setPublishDate(book.getPublishDate());
			bookDTOs.add(dto);
		}
		return bookDTOs;
	}

	/* (non-Javadoc)
	 * @see vn.edu.hcmute.librarymanagement.service.NguyenDucDuongViet_03_BookService#findBookByCategory(int)
	 */
	@Override
	public List<NguyenDucDuongViet_03_BookDTO> findBookByCategory(int category_id) {
		//lấy sách theo loại cách
		List<NguyenDucDuongViet_03_Book> books = bookDAO.findBookByCategory(category_id);
		logger.info(books.size() + "");
		
		//set dữ liệu
		List<NguyenDucDuongViet_03_BookDTO> bookDTOs = new ArrayList<NguyenDucDuongViet_03_BookDTO>();
		for (NguyenDucDuongViet_03_Book book : books) {
			NguyenDucDuongViet_03_BookDTO dto = new NguyenDucDuongViet_03_BookDTO();
			dto.setId(book.getId());
			dto.setName(book.getName());
			dto.setCategory(new NguyenDucDuongViet_03_CategoryDTO(book.getCategory().getId(), book.getCategory().getCategoryName()));
			dto.setAuthor(book.getAuthor());
			dto.setPublishingFirm(book.getPublishingFirm());
			dto.setAmount(book.getAmount());
			dto.setImage(book.getImage());
			dto.setPublishDate(book.getPublishDate());
			bookDTOs.add(dto);
		}
		return bookDTOs;
	}

	/* (non-Javadoc)
	 * @see vn.edu.hcmute.librarymanagement.service.NguyenDucDuongViet_03_BookService#findBookHotInMonth()
	 */
	@Override
	public List<NguyenDucDuongViet_03_BookDTO> findBookHotInMonth() {
		//lấy sách hot
		List<NguyenDucDuongViet_03_Book> books = bookDAO.findBookHotInMonth();
		
		//set dữ liệu
		List<NguyenDucDuongViet_03_BookDTO> bookDTOs = new ArrayList<NguyenDucDuongViet_03_BookDTO>();
		for (NguyenDucDuongViet_03_Book book : books) {
			NguyenDucDuongViet_03_BookDTO dto = new NguyenDucDuongViet_03_BookDTO();
			dto.setId(book.getId());
			dto.setName(book.getName());
			dto.setCategory(new NguyenDucDuongViet_03_CategoryDTO(book.getCategory().getId(), book.getCategory().getCategoryName()));
			dto.setAuthor(book.getAuthor());
			dto.setImage(book.getImage());
			dto.setPublishingFirm(book.getPublishingFirm());
			dto.setAmount(book.getAmount());
			dto.setPublishDate(book.getPublishDate());
			bookDTOs.add(dto);
		}
		return bookDTOs;
	}

	/* (non-Javadoc)
	 * @see vn.edu.hcmute.librarymanagement.service.NguyenDucDuongViet_03_BookService#findBookByUserDept(vn.edu.hcmute.librarymanagement.model.NguyenDucDuongViet_03_User)
	 */
	@Override
	public List<NguyenDucDuongViet_03_BookDTO> findBookByUserDept(NguyenDucDuongViet_03_User user) {
		return null;
	}

	/* (non-Javadoc)
	 * @see vn.edu.hcmute.librarymanagement.service.NguyenDucDuongViet_03_BookService#findBookByNameOrAuthor(java.lang.String)
	 */
	@Override
	public List<NguyenDucDuongViet_03_BookDTO> findBookByNameOrAuthor(String search) {
		//search sách
		List<NguyenDucDuongViet_03_Book> books = bookDAO.findBookByNameOrAuthor(search);
		logger.info(books.size() + "");
		//set dữ liệu kết quả
		List<NguyenDucDuongViet_03_BookDTO> bookDTOs = new ArrayList<NguyenDucDuongViet_03_BookDTO>();
		for (NguyenDucDuongViet_03_Book book : books) {
			NguyenDucDuongViet_03_BookDTO dto = new NguyenDucDuongViet_03_BookDTO();
			dto.setId(book.getId());
			dto.setName(book.getName());
			dto.setCategory(new NguyenDucDuongViet_03_CategoryDTO(book.getCategory().getId(), book.getCategory().getCategoryName()));
			dto.setAuthor(book.getAuthor());
			dto.setPublishingFirm(book.getPublishingFirm());
			dto.setAmount(book.getAmount());
			dto.setImage(book.getImage());
			dto.setPublishDate(book.getPublishDate());
			bookDTOs.add(dto);
		}
		return bookDTOs;
	}

	/* (non-Javadoc)
	 * @see vn.edu.hcmute.librarymanagement.service.NguyenDucDuongViet_03_BookService#saveOrUpdate(vn.edu.hcmute.librarymanagement.dto.book.NguyenDucDuongViet_03_BookDTO)
	 */
	@Override
	public boolean saveOrUpdate(NguyenDucDuongViet_03_BookDTO bookDTO) {
		return false;
	}

	/* (non-Javadoc)
	 * @see vn.edu.hcmute.librarymanagement.service.NguyenDucDuongViet_03_BookService#delete(int)
	 */
	@Override
	public boolean delete(int book_id) {
		NguyenDucDuongViet_03_Book book = bookDAO.findBookById(book_id);
		return bookDAO.delete(book);
	}

	/* (non-Javadoc)
	 * @see vn.edu.hcmute.librarymanagement.service.NguyenDucDuongViet_03_BookService#findBookById(int)
	 */
	@Override
	public NguyenDucDuongViet_03_BookDTO findBookById(int id) {
		//lấy sách theo id
		NguyenDucDuongViet_03_Book book = bookDAO.findBookById(id);
		
		//set dữ liệu 
		NguyenDucDuongViet_03_BookDTO dto = new NguyenDucDuongViet_03_BookDTO();
		dto.setId(book.getId());
		dto.setName(book.getName());
		dto.setCategory(new NguyenDucDuongViet_03_CategoryDTO(book.getCategory().getId(), book.getCategory().getCategoryName()));
		dto.setAuthor(book.getAuthor());
		dto.setPublishingFirm(book.getPublishingFirm());
		dto.setImage(book.getImage());
		dto.setAmount(book.getAmount());
		dto.setPublishDate(book.getPublishDate());
		return dto;
	}

	/* (non-Javadoc)
	 * @see vn.edu.hcmute.librarymanagement.service.NguyenDucDuongViet_03_BookService#findBookRelatedByCategory(int)
	 */
	@Override
	public List<NguyenDucDuongViet_03_BookDTO> findBookRelatedByCategory(int category_id) {
		//lấy sách liên quan trong cùng loại
		List<NguyenDucDuongViet_03_Book> books = bookDAO.findRelatedByCategory(category_id);
		//set dữ liệu
		List<NguyenDucDuongViet_03_BookDTO> bookDTOs = new ArrayList<NguyenDucDuongViet_03_BookDTO>();
		for (NguyenDucDuongViet_03_Book book : books) {
			NguyenDucDuongViet_03_BookDTO dto = new NguyenDucDuongViet_03_BookDTO();
			dto.setId(book.getId());
			dto.setName(book.getName());
			dto.setCategory(new NguyenDucDuongViet_03_CategoryDTO(book.getCategory().getId(), book.getCategory().getCategoryName()));
			dto.setAuthor(book.getAuthor());
			dto.setPublishingFirm(book.getPublishingFirm());
			dto.setAmount(book.getAmount());
			dto.setImage(book.getImage());
			dto.setPublishDate(book.getPublishDate());
			bookDTOs.add(dto);
		}
		return bookDTOs;
	}

	/* (non-Javadoc)
	 * @see vn.edu.hcmute.librarymanagement.service.NguyenDucDuongViet_03_BookService#findAllBookList()
	 */
	@Override
	public List<NguyenDucDuongViet_03_BookListDTO> findAllBookList() {
		//lất tất cả sách, chỉ phân biệt bằng mã vạch
		List<NguyenDucDuongViet_03_BookList> books = bookListDAO.findAll();
		List<NguyenDucDuongViet_03_BookListDTO> bookDTOs = new ArrayList<NguyenDucDuongViet_03_BookListDTO>();
		//set dữ liệu
		for (NguyenDucDuongViet_03_BookList book : books) {
			NguyenDucDuongViet_03_BookListDTO dto = new NguyenDucDuongViet_03_BookListDTO();
			dto.setId(book.getBook().getId());
			dto.setName(book.getBook().getName());
			dto.setCode(book.getBookCode());
			dto.setCategory(new NguyenDucDuongViet_03_CategoryDTO(book.getBook().getCategory().getId(), book.getBook().getCategory().getCategoryName()));
			dto.setAuthor(book.getBook().getAuthor());
			dto.setPublishingFirm(book.getBook().getPublishingFirm());
			dto.setAmount(book.getBook().getAmount());
			dto.setPublishDate(book.getBook().getPublishDate());
			bookDTOs.add(dto);
		}
		return bookDTOs;
	}

}
