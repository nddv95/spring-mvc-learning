/**
 * 
 */
package vn.edu.hcmute.librarymanagement.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.edu.hcmute.librarymanagement.model.NguyenDucDuongViet_03_BorrowBook;
import vn.edu.hcmute.librarymanagement.model.NguyenDucDuongViet_03_BorrowBookDetail;

/**
 * @author Nguyen Duc Duong Viet
 *
 *         Dec 12, 2016
 * 
 *         Implement BorrowBookDAO
 */
@Repository
@Transactional
public class NguyenDucDuongViet_03_BorrowBookDAOImpl implements NguyenDucDuongViet_03_BorrowBookDAO {

	/**
	 * dùng để xuất thông tin ra console
	 */
	private static final Logger logger = LoggerFactory.getLogger(NguyenDucDuongViet_03_BorrowBookDAOImpl.class);

	/**
	 *sessionFactory dùng để truy cập với cơ sở dữ liệu thông qua hibernate 
	 */
	@Autowired
	private SessionFactory sessionFactory;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * vn.edu.hcmute.librarymanagement.dao.NguyenDucDuongViet_03_BorrowBookDAO#
	 * findAll()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<NguyenDucDuongViet_03_BorrowBook> findAll() {

		// Chỉ lấy những thông tin mượn mà chưa trả sách xong

		List<NguyenDucDuongViet_03_BorrowBook> lstResult = new ArrayList<>();
		List<NguyenDucDuongViet_03_BorrowBook> lstAll = sessionFactory.getCurrentSession()
				.createQuery("from NguyenDucDuongViet_03_BorrowBook b order by b.dateReturn").list();
		for (NguyenDucDuongViet_03_BorrowBook borrowBook : lstAll) {
			for (NguyenDucDuongViet_03_BorrowBookDetail borrowDetail : borrowBook.getBorrowBookDetails()) {
				if (!borrowDetail.isReturn()) {
					lstResult.add(borrowBook);
					break;
				}
			}
		}
		return lstResult;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * vn.edu.hcmute.librarymanagement.dao.NguyenDucDuongViet_03_BorrowBookDAO#
	 * findById(int)
	 */
	@Override
	public NguyenDucDuongViet_03_BorrowBook findById(int id) {

		return (NguyenDucDuongViet_03_BorrowBook) sessionFactory.getCurrentSession()
				.get(NguyenDucDuongViet_03_BorrowBook.class, id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * vn.edu.hcmute.librarymanagement.dao.NguyenDucDuongViet_03_BorrowBookDAO#
	 * findByUser(int)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NguyenDucDuongViet_03_BorrowBook findByUser(int userId) {

		// Nguyen Tac: Chưa mượn được nếu chưa trả xong => có duy nhất một
		// borrowBook của user có trạng thái chưa trả
		// Tìm những sách chưa trả của user để đưa ra thông tin mượn

		logger.info("Get info borrow of user");

		List<NguyenDucDuongViet_03_BorrowBookDetail> detail = sessionFactory.getCurrentSession()
				.createQuery(
						"from NguyenDucDuongViet_03_BorrowBookDetail b where b.isReturn = :isReturn and b.borrowBook.user.id = :userId")
				.setBoolean("isReturn", false).setParameter("userId", userId).list();
		if (detail == null || detail.isEmpty())
			return null;
		return detail.get(0).getBorrowBook();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * vn.edu.hcmute.librarymanagement.dao.NguyenDucDuongViet_03_BorrowBookDAO#
	 * save(vn.edu.hcmute.librarymanagement.model.
	 * NguyenDucDuongViet_03_BorrowBook)
	 */
	@Override
	public int save(NguyenDucDuongViet_03_BorrowBook borrowBook) {
		int id = 0;
		try {
			id = (int) sessionFactory.getCurrentSession().save(borrowBook);
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
		return id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * vn.edu.hcmute.librarymanagement.dao.NguyenDucDuongViet_03_BorrowBookDAO#
	 * delete(int)
	 */
	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * vn.edu.hcmute.librarymanagement.dao.NguyenDucDuongViet_03_BorrowBookDAO#
	 * findAllBorrow()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<NguyenDucDuongViet_03_BorrowBook> findAllBorrow() {
		return sessionFactory.getCurrentSession().createQuery("from NguyenDucDuongViet_03_BorrowBook").list();
	}

}
