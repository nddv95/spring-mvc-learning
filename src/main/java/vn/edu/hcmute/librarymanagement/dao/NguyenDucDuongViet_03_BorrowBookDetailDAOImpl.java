/**
 * 
 */
package vn.edu.hcmute.librarymanagement.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.edu.hcmute.librarymanagement.model.NguyenDucDuongViet_03_BorrowBookDetail;

/**
 * @author Nguyen Duc Duong Viet
 *
 *         Dec 12, 2016
 * 
 *         Implement BorrowBookDetailDAO
 */

@Repository
@Transactional
public class NguyenDucDuongViet_03_BorrowBookDetailDAOImpl implements NguyenDucDuongViet_03_BorrowBookDetailDAO {

	/**
	 * dùng để xuất thông tin ra console
	 */
	private static final Logger logger = LoggerFactory.getLogger(NguyenDucDuongViet_03_BorrowBookDetailDAOImpl.class);

	/**
	 * sessionFactory dùng để truy cập với cơ sở dữ liệu thông qua hibernate 
	 */
	@Autowired
	private SessionFactory sessionFactory;

	/* (non-Javadoc)
	 * @see vn.edu.hcmute.librarymanagement.dao.NguyenDucDuongViet_03_BorrowBookDetailDAO#findBorrowBookDetailByBorrowId(int)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<NguyenDucDuongViet_03_BorrowBookDetail> findBorrowBookDetailByBorrowId(int borrowId) {
		logger.info("Get list detail borrow book of a borrow");
		return sessionFactory.getCurrentSession()
				.createQuery(
						"from NguyenDucDuongViet_03_BorrowBookDetail b where b.borrowBook.id = :id and b.isReturn = :isReturn")
				.setBoolean("isReturn", false).setParameter("id", borrowId).list();
	}

	/* (non-Javadoc)
	 * @see vn.edu.hcmute.librarymanagement.dao.NguyenDucDuongViet_03_BorrowBookDetailDAO#findById(int)
	 */
	@Override
	public NguyenDucDuongViet_03_BorrowBookDetail findById(int id) {
		logger.info("Get a borrow book detail");
		return (NguyenDucDuongViet_03_BorrowBookDetail) sessionFactory.getCurrentSession()
				.get(NguyenDucDuongViet_03_BorrowBookDetail.class, id);
	}

	/* (non-Javadoc)
	 * @see vn.edu.hcmute.librarymanagement.dao.NguyenDucDuongViet_03_BorrowBookDetailDAO#save(vn.edu.hcmute.librarymanagement.model.NguyenDucDuongViet_03_BorrowBookDetail)
	 */
	@Override
	public boolean save(NguyenDucDuongViet_03_BorrowBookDetail detail) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(detail);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		logger.info("Save a borrow book detail success");
		return true;
	}

	/* (non-Javadoc)
	 * @see vn.edu.hcmute.librarymanagement.dao.NguyenDucDuongViet_03_BorrowBookDetailDAO#delete(int)
	 */
	@Override
	public boolean delete(int id) {
		try {
			sessionFactory.getCurrentSession()
					.createQuery("delete from NguyenDucDuongViet_03_BorrowBookDetail b where id = :id")
					.setParameter("id", id).executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		logger.info("Delete a borrow book detail success");
		return true;
	}

	/* (non-Javadoc)
	 * @see vn.edu.hcmute.librarymanagement.dao.NguyenDucDuongViet_03_BorrowBookDetailDAO#findBorrowBookDetailNotReturn()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<NguyenDucDuongViet_03_BorrowBookDetail> findBorrowBookDetailNotReturn() {
		logger.info("Get list detail borrow with book not return");
		return sessionFactory.getCurrentSession()
				.createQuery(
						"from NguyenDucDuongViet_03_BorrowBookDetail b where b.isReturn = :isReturn")
				.setBoolean("isReturn", false).list();
	}

}
