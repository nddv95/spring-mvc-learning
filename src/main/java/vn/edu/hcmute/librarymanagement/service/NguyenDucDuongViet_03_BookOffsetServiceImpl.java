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
import vn.edu.hcmute.librarymanagement.dao.NguyenDucDuongViet_03_BookOffsetDAO;
import vn.edu.hcmute.librarymanagement.dao.NguyenDucDuongViet_03_BorrowBookDAO;
import vn.edu.hcmute.librarymanagement.dao.NguyenDucDuongViet_03_BorrowBookDetailDAO;
import vn.edu.hcmute.librarymanagement.dto.book.NguyenDucDuongViet_03_BookDTO;
import vn.edu.hcmute.librarymanagement.dto.book.NguyenDucDuongViet_03_BookListDTO;
import vn.edu.hcmute.librarymanagement.dto.book.NguyenDucDuongViet_03_BookOffsetDTO;
import vn.edu.hcmute.librarymanagement.dto.book.NguyenDucDuongViet_03_BorrowBookDTO;
import vn.edu.hcmute.librarymanagement.dto.book.NguyenDucDuongViet_03_BorrowOffsetDTO;
import vn.edu.hcmute.librarymanagement.dto.book.NguyenDucDuongViet_03_CategoryDTO;
import vn.edu.hcmute.librarymanagement.dto.book.NguyenDucDuongViet_03_UserDTO;
import vn.edu.hcmute.librarymanagement.model.NguyenDucDuongViet_03_Book;
import vn.edu.hcmute.librarymanagement.model.NguyenDucDuongViet_03_BookList;
import vn.edu.hcmute.librarymanagement.model.NguyenDucDuongViet_03_BookOffset;
import vn.edu.hcmute.librarymanagement.model.NguyenDucDuongViet_03_BorrowBook;
import vn.edu.hcmute.librarymanagement.model.NguyenDucDuongViet_03_BorrowBookDetail;

/**
 * @author Nguyen Duc Duong Viet
 *
 *         Dec 24, 2016
 *         
 *         implement BookOffsetService interface
 */

@Service
public class NguyenDucDuongViet_03_BookOffsetServiceImpl implements NguyenDucDuongViet_03_BookOffsetService {

	/**
	 * dùng để xuất thông tin trên console
	 */
	private static final Logger logger = LoggerFactory.getLogger(NguyenDucDuongViet_03_BookOffsetServiceImpl.class);

	/**
	 * bookOffsetDAO chứa các hàm truy cập csdl bảng book_offset
	 */
	@Autowired
	private NguyenDucDuongViet_03_BookOffsetDAO bookOffsetDAO;

	/**
	 * borrowDAO chứa các hàm truy cập csdl bảng borrow_book
	 */
	@Autowired
	private NguyenDucDuongViet_03_BorrowBookDAO borrowDAO;

	/**
	 * borrowDetailDAO chứa các hàm truy cập csdl bảng borrow_book_detail
	 */
	@Autowired
	private NguyenDucDuongViet_03_BorrowBookDetailDAO borrowDetailDAO;

	/**
	 * bookListDAO chứa các hàm truy cập csdl bảng book_list
	 */
	@Autowired
	private NguyenDucDuongViet_03_BookListDAO bookListDAO;

	/**
	 * bookDAO chứa các hàm truy cập csdl bảng book
	 */
	@Autowired
	private NguyenDucDuongViet_03_BookDAO bookDAO;

	/* (non-Javadoc)
	 * @see vn.edu.hcmute.librarymanagement.service.NguyenDucDuongViet_03_BookOffsetService#findAll()
	 */
	@Override
	public List<NguyenDucDuongViet_03_BookOffsetDTO> findAll() {

		//khai báo biến kết quả
		List<NguyenDucDuongViet_03_BookOffsetDTO> dtos = new ArrayList<>();
		
		//lấy tất cả thông tin mượn
		List<NguyenDucDuongViet_03_BorrowBook> lstBorrow = borrowDAO.findAllBorrow();
		for (NguyenDucDuongViet_03_BorrowBook borrow : lstBorrow) {
			//xác định phiếu mượn có sách nào đền bù ko
			if (borrow.getBookOffsets() != null && !borrow.getBookOffsets().isEmpty()) {

				//lấy thông tin đền bù
				NguyenDucDuongViet_03_BookOffsetDTO dto = new NguyenDucDuongViet_03_BookOffsetDTO();				
				dto.setBorrowBookId(borrow.getId());
				dto.setOffsetDate(borrow.getBookOffsets().get(0).getOffsetDate());
				dto.setUser(new NguyenDucDuongViet_03_UserDTO(borrow.getUser().getId(), borrow.getUser().getUsername(),
						borrow.getUser().getPassword(), borrow.getUser().getFullName(), borrow.getUser().getDept(),
						borrow.getUser().getClassName(), borrow.getUser().getDateOfBirth(),
						borrow.getUser().getAddress(), borrow.getUser().getIndentification(),
						borrow.getUser().getPhone(), borrow.getUser().getAvatar(), borrow.getUser().getRole()));
				List<NguyenDucDuongViet_03_BookListDTO> books = new ArrayList<>();
				for (NguyenDucDuongViet_03_BookOffset offset : borrow.getBookOffsets()) {
					books.add(new NguyenDucDuongViet_03_BookListDTO(offset.getBook().getId(), offset.getBookCode(),
							offset.getBook().getName(),
							new NguyenDucDuongViet_03_CategoryDTO(offset.getBook().getCategory().getId(),
									offset.getBook().getCategory().getCategoryName()),
							offset.getBook().getPublishingFirm(), offset.getBook().getPublishDate(),
							offset.getBook().getAuthor(), offset.getBook().getImage(), offset.getBook().getAmount()));
				}

				dto.setBooks(books);
				dtos.add(dto);
			}
		}

		return dtos;
	}

	/* (non-Javadoc)
	 * @see vn.edu.hcmute.librarymanagement.service.NguyenDucDuongViet_03_BookOffsetService#findByBorrowId(int)
	 */
	@Override
	public NguyenDucDuongViet_03_BookOffsetDTO findByBorrowId(int id) {
		//lấy thông tin mượn theo id
		NguyenDucDuongViet_03_BorrowBook borrow = borrowDAO.findById(id);
		logger.info(borrow.getId() + " " + borrow.getBookOffsets().size());
		//set dữ liệu cho kết quả 
		NguyenDucDuongViet_03_BookOffsetDTO dto = new NguyenDucDuongViet_03_BookOffsetDTO();
		dto.setBorrowBookId(borrow.getId());
		dto.setOffsetDate(borrow.getBookOffsets().get(0).getOffsetDate());
		dto.setUser(new NguyenDucDuongViet_03_UserDTO(borrow.getUser().getId(), borrow.getUser().getUsername(),
				borrow.getUser().getPassword(), borrow.getUser().getFullName(), borrow.getUser().getDept(),
				borrow.getUser().getClassName(), borrow.getUser().getDateOfBirth(), borrow.getUser().getAddress(),
				borrow.getUser().getIndentification(), borrow.getUser().getPhone(), borrow.getUser().getAvatar(),
				borrow.getUser().getRole()));
		List<NguyenDucDuongViet_03_BookListDTO> books = new ArrayList<>();

		for (NguyenDucDuongViet_03_BookOffset offset : borrow.getBookOffsets()) {
			logger.info(books.size() + "");
			if (!checkExist(books, offset.getBookCode())) {
				books.add(new NguyenDucDuongViet_03_BookListDTO(offset.getBook().getId(), offset.getBookCode(), offset.getBook().getName(),
						new NguyenDucDuongViet_03_CategoryDTO(offset.getBook().getCategory().getId(),
								offset.getBook().getCategory().getCategoryName()),
						offset.getBook().getPublishingFirm(), offset.getBook().getPublishDate(),
						offset.getBook().getAuthor(), offset.getBook().getImage(), offset.getBook().getAmount()));
			}
		}

		dto.setBooks(books);
		return dto;
	}

	/**
	 * @param lst
	 * @param code
	 * @return
	 */
	private boolean checkExist(List<NguyenDucDuongViet_03_BookListDTO> lst, String code) {
		for (NguyenDucDuongViet_03_BookListDTO book : lst) {
			if (book.getCode().equals(code)) {
				return true;
			}
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see vn.edu.hcmute.librarymanagement.service.NguyenDucDuongViet_03_BookOffsetService#save(vn.edu.hcmute.librarymanagement.dto.book.NguyenDucDuongViet_03_BookOffsetDTO)
	 */
	@Override
	public boolean save(NguyenDucDuongViet_03_BookOffsetDTO data) {
		try {
			NguyenDucDuongViet_03_BorrowBook borrow = borrowDAO.findById(data.getBorrowBookId());
			List<NguyenDucDuongViet_03_BorrowBookDetail> borrowDetail = borrowDetailDAO
					.findBorrowBookDetailByBorrowId(data.getBorrowBookId());
			for (NguyenDucDuongViet_03_BookListDTO book : data.getBooks()) {
				// insert new offset
				NguyenDucDuongViet_03_BookOffset bookOffset = new NguyenDucDuongViet_03_BookOffset();
				NguyenDucDuongViet_03_Book b = bookDAO.findBookById(book.getId());
				bookOffset.setBookCode(book.getCode());
				bookOffset.setBook(b);
				bookOffset.setBorrowBook(borrow);
				bookOffset.setOffsetDate(data.getOffsetDate());
				bookOffsetDAO.save(bookOffset);

				// update state borrow
				for (int i = 0; i < borrowDetail.size(); i++) {
					if (borrowDetail.get(i).getBookList().getBook().getId() == book.getId()) {
						NguyenDucDuongViet_03_BorrowBookDetail temp = borrowDetail.get(i);
						temp.setReturn(true);
						borrowDetailDAO.save(temp);
					}
				}
				// insert new book list
				NguyenDucDuongViet_03_BookList bookList = new NguyenDucDuongViet_03_BookList();
				bookList.setBookCode(book.getCode());
				bookList.setReturn(true);
				bookList.setBook(b);
				bookListDAO.save(bookList);

				// update amount book
				b.setAmount(b.getAmount() + 1);
				bookDAO.saveOrUpdate(b);

			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see vn.edu.hcmute.librarymanagement.service.NguyenDucDuongViet_03_BookOffsetService#getAllBookCanOffset()
	 */
	@Override
	public List<NguyenDucDuongViet_03_BorrowOffsetDTO> getAllBookCanOffset() {
		List<NguyenDucDuongViet_03_BorrowOffsetDTO> dtos = new ArrayList<>();
		List<NguyenDucDuongViet_03_BorrowBookDetail> details = borrowDetailDAO.findBorrowBookDetailNotReturn();
		if (details.isEmpty() || details == null) {
			return null;
		}
		for (NguyenDucDuongViet_03_BorrowBookDetail detail : details) {
			NguyenDucDuongViet_03_BorrowOffsetDTO dto = new NguyenDucDuongViet_03_BorrowOffsetDTO();
			// set book
			NguyenDucDuongViet_03_BookDTO book = new NguyenDucDuongViet_03_BookDTO();
			book.setId(detail.getBookList().getBook().getId());
			book.setName(detail.getBookList().getBook().getName());
			book.setCategory(new NguyenDucDuongViet_03_CategoryDTO(detail.getBookList().getBook().getCategory().getId(),
					detail.getBookList().getBook().getCategory().getCategoryName()));
			book.setAuthor(detail.getBookList().getBook().getAuthor());
			book.setPublishingFirm(detail.getBookList().getBook().getPublishingFirm());
			book.setAmount(detail.getBookList().getBook().getAmount());
			book.setPublishDate(detail.getBookList().getBook().getPublishDate());
			dto.setBook(book);

			// set borrow info
			NguyenDucDuongViet_03_BorrowBookDTO borrow = new NguyenDucDuongViet_03_BorrowBookDTO();
			borrow.setId(detail.getBorrowBook().getId());
			borrow.setUser(new NguyenDucDuongViet_03_UserDTO(detail.getBorrowBook().getUser().getId(),
					detail.getBorrowBook().getUser().getUsername(), detail.getBorrowBook().getUser().getPassword(),
					detail.getBorrowBook().getUser().getFullName(), detail.getBorrowBook().getUser().getDept(),
					detail.getBorrowBook().getUser().getClassName(), detail.getBorrowBook().getUser().getDateOfBirth(),
					detail.getBorrowBook().getUser().getAddress(),
					detail.getBorrowBook().getUser().getIndentification(), detail.getBorrowBook().getUser().getPhone(),
					detail.getBorrowBook().getUser().getAvatar(), detail.getBorrowBook().getUser().getRole()));
			borrow.setDateBorrow(detail.getBorrowBook().getDateBorrow());
			borrow.setDateReturn(detail.getBorrowBook().getDateReturn());
			dto.setBorrow(borrow);

			// add to list
			dtos.add(dto);
		}
		return dtos;
	}

	/* (non-Javadoc)
	 * @see vn.edu.hcmute.librarymanagement.service.NguyenDucDuongViet_03_BookOffsetService#CheckBookCodeExist(java.lang.String)
	 */
	@Override
	public boolean CheckBookCodeExist(String bookCode) {
		if (bookListDAO.findBookListByCode(bookCode) != null)
			return true;
		return false;
	}

}
