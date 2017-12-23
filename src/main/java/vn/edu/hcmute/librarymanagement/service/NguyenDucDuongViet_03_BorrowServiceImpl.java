package vn.edu.hcmute.librarymanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.edu.hcmute.librarymanagement.dao.NguyenDucDuongViet_03_BookDAO;
import vn.edu.hcmute.librarymanagement.dao.NguyenDucDuongViet_03_BookListDAO;
import vn.edu.hcmute.librarymanagement.dao.NguyenDucDuongViet_03_BorrowBookDAO;
import vn.edu.hcmute.librarymanagement.dao.NguyenDucDuongViet_03_BorrowBookDetailDAO;
import vn.edu.hcmute.librarymanagement.dao.NguyenDucDuongViet_03_UserDAO;
import vn.edu.hcmute.librarymanagement.dto.book.NguyenDucDuongViet_03_BookListDTO;
import vn.edu.hcmute.librarymanagement.dto.book.NguyenDucDuongViet_03_BorrowBookDTO;
import vn.edu.hcmute.librarymanagement.dto.book.NguyenDucDuongViet_03_BorrowDTO;
import vn.edu.hcmute.librarymanagement.dto.book.NguyenDucDuongViet_03_CategoryDTO;
import vn.edu.hcmute.librarymanagement.dto.book.NguyenDucDuongViet_03_UserDTO;
import vn.edu.hcmute.librarymanagement.model.NguyenDucDuongViet_03_Book;
import vn.edu.hcmute.librarymanagement.model.NguyenDucDuongViet_03_BookList;
import vn.edu.hcmute.librarymanagement.model.NguyenDucDuongViet_03_BorrowBook;
import vn.edu.hcmute.librarymanagement.model.NguyenDucDuongViet_03_BorrowBookDetail;
import vn.edu.hcmute.librarymanagement.model.NguyenDucDuongViet_03_User;

/**
 * @author Nguyen Duc Duong Viet
 *
 *         Dec 22, 2016
 * 
 *         Implement BorrowService interface
 * 
 */

@Service
public class NguyenDucDuongViet_03_BorrowServiceImpl implements NguyenDucDuongViet_03_BorrowService {

	/**
	 * userDAO chứa các hàm truy cập csdl bảng user
	 */
	@Autowired
	private NguyenDucDuongViet_03_UserDAO userDAO;

	/**
	 * bookDAO chứa các hàm truy cập csdl book
	 */
	@Autowired
	private NguyenDucDuongViet_03_BookDAO bookDAO;
	/**
	 * bookListDAO chứa các hàm truy cập csdl bảng book_list
	 */
	@Autowired
	private NguyenDucDuongViet_03_BookListDAO bookListDAO;
	/**
	 * borrowBookDAO chứa các hàm truy cập csdl bảng borrow_book
	 */
	@Autowired
	private NguyenDucDuongViet_03_BorrowBookDAO borrowBookDAO;
	/**
	 * borrowDetailDAO chứa các hàm truy cập csdl bảng borrow_book_detail
	 */
	@Autowired
	private NguyenDucDuongViet_03_BorrowBookDetailDAO borrowDetailDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see vn.edu.hcmute.librarymanagement.service.
	 * NguyenDucDuongViet_03_BorrowService#getBorrowBookDetailByUser(int)
	 */
	@Override
	public NguyenDucDuongViet_03_BorrowDTO getBorrowBookDetailByUser(int userId) {
		NguyenDucDuongViet_03_BorrowDTO dto = new NguyenDucDuongViet_03_BorrowDTO();
		//get thông tin mượn theo user
		NguyenDucDuongViet_03_BorrowBook borrow = borrowBookDAO.findByUser(userId);
		if (borrow == null)
			return null;
		//get danh sách sách mượn theo thông tin mượn
		List<NguyenDucDuongViet_03_BorrowBookDetail> borrowDetail = borrowDetailDAO
				.findBorrowBookDetailByBorrowId(borrow.getId());
		//set dữ liệu
		dto.setId(borrow.getId());
		dto.setDateBorrow(borrow.getDateBorrow());
		dto.setDateReturn(borrow.getDateReturn());
		dto.setUser(new NguyenDucDuongViet_03_UserDTO(borrow.getUser().getId(), borrow.getUser().getUsername(),
				borrow.getUser().getPassword(), borrow.getUser().getFullName(), borrow.getUser().getDept(),
				borrow.getUser().getClassName(), borrow.getUser().getDateOfBirth(), borrow.getUser().getAddress(),
				borrow.getUser().getIndentification(), borrow.getUser().getPhone(), borrow.getUser().getAvatar(),
				borrow.getUser().getRole()));
		List<NguyenDucDuongViet_03_BookListDTO> lstBookBorrow = new ArrayList<>();
		for (NguyenDucDuongViet_03_BorrowBookDetail detail : borrowDetail) {
			lstBookBorrow.add(new NguyenDucDuongViet_03_BookListDTO(detail.getBookList().getBook().getId(),
					detail.getBookList().getBookCode(), detail.getBookList().getBook().getName(),
					new NguyenDucDuongViet_03_CategoryDTO(detail.getBookList().getBook().getCategory().getId(),
							detail.getBookList().getBook().getCategory().getCategoryName()),
					detail.getBookList().getBook().getPublishingFirm(), detail.getBookList().getBook().getPublishDate(),
					detail.getBookList().getBook().getAuthor(), detail.getBookList().getBook().getImage(),
					detail.getBookList().getBook().getAmount()));
		}
		dto.setBooks(lstBookBorrow);
		return dto;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vn.edu.hcmute.librarymanagement.service.
	 * NguyenDucDuongViet_03_BorrowService#findAllBorrow()
	 */
	@Override
	public List<NguyenDucDuongViet_03_BorrowBookDTO> findAllBorrow() {
		List<NguyenDucDuongViet_03_BorrowBookDTO> lstDTO = new ArrayList<>();
		//lấy tất cả thông tin mượn đang mượn
		List<NguyenDucDuongViet_03_BorrowBook> lstBorrow = borrowBookDAO.findAll();
		if (lstBorrow == null)
			return null;
		//set dữ liệu
		for (NguyenDucDuongViet_03_BorrowBook borrow : lstBorrow) {
			NguyenDucDuongViet_03_BorrowBookDTO dto = new NguyenDucDuongViet_03_BorrowBookDTO();
			dto.setId(borrow.getId());
			dto.setUser(new NguyenDucDuongViet_03_UserDTO(borrow.getUser().getId(), borrow.getUser().getUsername(),
					borrow.getUser().getPassword(), borrow.getUser().getFullName(), borrow.getUser().getDept(),
					borrow.getUser().getClassName(), borrow.getUser().getDateOfBirth(), borrow.getUser().getAddress(),
					borrow.getUser().getIndentification(), borrow.getUser().getPhone(), borrow.getUser().getAvatar(),
					borrow.getUser().getRole()));
			dto.setDateBorrow(borrow.getDateBorrow());
			dto.setDateReturn(borrow.getDateReturn());
			lstDTO.add(dto);
		}
		return lstDTO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vn.edu.hcmute.librarymanagement.service.
	 * NguyenDucDuongViet_03_BorrowService#getBorrowBookDetailById(int)
	 */
	@Override
	public NguyenDucDuongViet_03_BorrowDTO getBorrowBookDetailById(int id) {
		NguyenDucDuongViet_03_BorrowDTO dto = new NguyenDucDuongViet_03_BorrowDTO();
		//lấy thông tin mượn theo id
		NguyenDucDuongViet_03_BorrowBook borrow = borrowBookDAO.findById(id);
		if (borrow == null)
			return null;
		//lấy danh sách mượn theo thông tin mượn
		List<NguyenDucDuongViet_03_BorrowBookDetail> borrowDetail = borrowDetailDAO
				.findBorrowBookDetailByBorrowId(borrow.getId());
		if (borrowDetail == null || borrowDetail.isEmpty())
			return null;
		//set dữ liệu
		dto.setId(borrow.getId());
		dto.setDateBorrow(borrow.getDateBorrow());
		dto.setDateReturn(borrow.getDateReturn());
		dto.setUser(new NguyenDucDuongViet_03_UserDTO(borrow.getUser().getId(), borrow.getUser().getUsername(),
				borrow.getUser().getPassword(), borrow.getUser().getFullName(), borrow.getUser().getDept(),
				borrow.getUser().getClassName(), borrow.getUser().getDateOfBirth(), borrow.getUser().getAddress(),
				borrow.getUser().getIndentification(), borrow.getUser().getPhone(), borrow.getUser().getAvatar(),
				borrow.getUser().getRole()));
		List<NguyenDucDuongViet_03_BookListDTO> lstBookBorrow = new ArrayList<>();
		for (NguyenDucDuongViet_03_BorrowBookDetail detail : borrowDetail) {
			lstBookBorrow.add(new NguyenDucDuongViet_03_BookListDTO(detail.getBookList().getBook().getId(),
					detail.getBookList().getBookCode(), detail.getBookList().getBook().getName(),
					new NguyenDucDuongViet_03_CategoryDTO(detail.getBookList().getBook().getCategory().getId(),
							detail.getBookList().getBook().getCategory().getCategoryName()),
					detail.getBookList().getBook().getPublishingFirm(), detail.getBookList().getBook().getPublishDate(),
					detail.getBookList().getBook().getAuthor(), detail.getBookList().getBook().getImage(),
					detail.getBookList().getBook().getAmount()));
		}
		dto.setBooks(lstBookBorrow);
		return dto;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vn.edu.hcmute.librarymanagement.service.
	 * NguyenDucDuongViet_03_BorrowService#returnBook(int, int)
	 */
	@Override
	public boolean returnBook(int borrowId, int bookId) {
		//lấy thông tin mượn đang trả
		NguyenDucDuongViet_03_BorrowBook borrow = borrowBookDAO.findById(borrowId);
		if (borrow == null)
			return false;
		//lấy danh sách sách mượn đang trả
		List<NguyenDucDuongViet_03_BorrowBookDetail> borrowDetails = borrowDetailDAO
				.findBorrowBookDetailByBorrowId(borrow.getId());
		
		//trả sách
		for (NguyenDucDuongViet_03_BorrowBookDetail detail : borrowDetails) {
			if (detail.getBookList().getBook().getId() == bookId) {
				if (detail.isReturn())
					return true;

				// Update amount of book return
				NguyenDucDuongViet_03_Book book = detail.getBookList().getBook();
				book.setAmount(book.getAmount() + 1);
				bookDAO.saveOrUpdate(book);

				// Update bookList is return
				NguyenDucDuongViet_03_BookList book_list = detail.getBookList();
				book_list.setReturn(true);
				bookListDAO.save(book_list);

				// Update detail
				detail.setReturn(true);
				borrowDetailDAO.save(detail);
				return true;
			}
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vn.edu.hcmute.librarymanagement.service.
	 * NguyenDucDuongViet_03_BorrowService#returnAllBook(int)
	 */
	@Override
	public boolean returnAllBook(int borrowId) {
		//lấy thông tin mượn đang trả
		NguyenDucDuongViet_03_BorrowBook borrow = borrowBookDAO.findById(borrowId);
		if (borrow == null)
			return false;
		//lấy danh sách mượn theo thông tin mượn
		List<NguyenDucDuongViet_03_BorrowBookDetail> borrowDetails = borrowDetailDAO
				.findBorrowBookDetailByBorrowId(borrow.getId());
		
		//trả tất cả sách đang mượn
		for (NguyenDucDuongViet_03_BorrowBookDetail detail : borrowDetails) {
			// Update amount of book return
			NguyenDucDuongViet_03_Book book = detail.getBookList().getBook();
			book.setAmount(book.getAmount() + 1);
			bookDAO.saveOrUpdate(book);

			// Update bookList is return
			NguyenDucDuongViet_03_BookList book_list = detail.getBookList();
			book_list.setReturn(true);
			bookListDAO.save(book_list);

			// Update detail
			detail.setReturn(true);
			borrowDetailDAO.save(detail);
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vn.edu.hcmute.librarymanagement.service.
	 * NguyenDucDuongViet_03_BorrowService#borrowBook(vn.edu.hcmute.
	 * librarymanagement.dto.book.NguyenDucDuongViet_03_BorrowDTO)
	 */
	@Override
	public boolean borrowBook(NguyenDucDuongViet_03_BorrowDTO borrowInfo) {
		//kiểm tra xem user có đang mượn không
		NguyenDucDuongViet_03_User user = userDAO.findUserById(borrowInfo.getUser().getId());

		// Trả xong mới được mượn
		if (borrowBookDAO.findByUser(user.getId()) != null)
			return false;

		List<NguyenDucDuongViet_03_BookList> lstBook = new ArrayList<>();
		// Sách ko có mượn không được
		for (NguyenDucDuongViet_03_BookListDTO book : borrowInfo.getBooks()) {
			if (bookDAO.findBookById(book.getId()).getAmount() == 0) {
				return false;
			} else {
				lstBook.add(bookListDAO.findBookListByCode(book.getCode()));
			}
		}

		// save borrow info
		NguyenDucDuongViet_03_BorrowBook borrow = new NguyenDucDuongViet_03_BorrowBook();
		borrow.setUser(user);
		borrow.setDateBorrow(borrowInfo.getDateBorrow());
		borrow.setDateReturn(borrowInfo.getDateReturn());
		int id = borrowBookDAO.save(borrow);

		// save borrow fail
		if (id == -1) {
			return false;
		}

		// save borrow detail
		for (NguyenDucDuongViet_03_BookList book : lstBook) {

			// save book detail
			NguyenDucDuongViet_03_BorrowBookDetail detail = new NguyenDucDuongViet_03_BorrowBookDetail();
			detail.setBookList(book);
			detail.setBorrowBook(borrowBookDAO.findById(id));
			detail.setReturn(false);
			borrowDetailDAO.save(detail);

			// update state of book_list after borrow
			book.setReturn(false);
			bookListDAO.save(book);

			// update amount after borrow
			NguyenDucDuongViet_03_Book bookInfo = detail.getBookList().getBook();
			bookInfo.setAmount(bookInfo.getAmount() - 1);
			bookDAO.saveOrUpdate(bookInfo);
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vn.edu.hcmute.librarymanagement.service.
	 * NguyenDucDuongViet_03_BorrowService#findBorrowInfoById(int)
	 */
	@Override
	public NguyenDucDuongViet_03_BorrowBookDTO findBorrowInfoById(int id) {
		
		//tìm borrow theo borrow id
		NguyenDucDuongViet_03_BorrowBook borrow = borrowBookDAO.findById(id);
		
		//set dữ liệu
		NguyenDucDuongViet_03_BorrowBookDTO dto = new NguyenDucDuongViet_03_BorrowBookDTO();
		dto.setId(borrow.getId());
		dto.setUser(new NguyenDucDuongViet_03_UserDTO(borrow.getUser().getId(), borrow.getUser().getUsername(),
				borrow.getUser().getPassword(), borrow.getUser().getFullName(), borrow.getUser().getDept(),
				borrow.getUser().getClassName(), borrow.getUser().getDateOfBirth(), borrow.getUser().getAddress(),
				borrow.getUser().getIndentification(), borrow.getUser().getPhone(), borrow.getUser().getAvatar(),
				borrow.getUser().getRole()));
		dto.setDateBorrow(borrow.getDateBorrow());
		dto.setDateReturn(borrow.getDateReturn());
		return dto;
	}

}
