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

import vn.edu.hcmute.librarymanagement.model.NguyenDucDuongViet_03_BookList;

/**
 * @author Nguyen Duc Duong Viet
 *
 *         Dec 12, 2016
 *         
 *         Implement BookListDAO
 *         
 */

@Repository
@Transactional
public class NguyenDucDuongViet_03_BookListDAOImpl implements NguyenDucDuongViet_03_BookListDAO {

	/**
	 * dùng để xuất thông tin ra console
	 */
	private static final Logger logger = LoggerFactory.getLogger(NguyenDucDuongViet_03_BookListDAOImpl.class);

	/**
	 * sessionFactory dùng để truy cập với cơ sở dữ liệu thông qua hibernate
	 */
	@Autowired
	private SessionFactory sesionFactory;

	/* (non-Javadoc)
	 * @see vn.edu.hcmute.librarymanagement.dao.NguyenDucDuongViet_03_BookListDAO#findBookListByBook(int)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<NguyenDucDuongViet_03_BookList> findBookListByBook(int idBook) {
		logger.info("Get list book by idbook");
		return sesionFactory.getCurrentSession()
				.createQuery("from NguyenDucDuongViet_03_BookList b where b.book.id = :id").setParameter("id", idBook)
				.list();
	}

	/* (non-Javadoc)
	 * @see vn.edu.hcmute.librarymanagement.dao.NguyenDucDuongViet_03_BookListDAO#findBookListById(int)
	 */
	@Override
	public NguyenDucDuongViet_03_BookList findBookListById(int id) {
		return (NguyenDucDuongViet_03_BookList) sesionFactory.getCurrentSession()
				.get(NguyenDucDuongViet_03_BookList.class, id);
	}

	/* (non-Javadoc)
	 * @see vn.edu.hcmute.librarymanagement.dao.NguyenDucDuongViet_03_BookListDAO#save(vn.edu.hcmute.librarymanagement.model.NguyenDucDuongViet_03_BookList)
	 */
	@Override
	public boolean save(NguyenDucDuongViet_03_BookList bookList) {
		try {
			sesionFactory.getCurrentSession().saveOrUpdate(bookList);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see vn.edu.hcmute.librarymanagement.dao.NguyenDucDuongViet_03_BookListDAO#delete(int)
	 */
	@Override
	public boolean delete(int id) {
		try {
			sesionFactory.getCurrentSession()
					.createQuery("delete from NguyenDucDuongViet_03_BookList b where b.id = :id").setParameter("id", id)
					.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see vn.edu.hcmute.librarymanagement.dao.NguyenDucDuongViet_03_BookListDAO#findAll()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<NguyenDucDuongViet_03_BookList> findAll() {
		logger.info("Get get all book list");
		return sesionFactory.getCurrentSession()
				.createQuery("from NguyenDucDuongViet_03_BookList b where b.isReturn = :isReturn order by b.book.name, b.bookCode").setParameter("isReturn", true)
				.list();
	}

	/* (non-Javadoc)
	 * @see vn.edu.hcmute.librarymanagement.dao.NguyenDucDuongViet_03_BookListDAO#findBookListByCode(java.lang.String)
	 */
	@Override
	public NguyenDucDuongViet_03_BookList findBookListByCode(String code) {
		logger.info("Get get a book list by book code");
		return (NguyenDucDuongViet_03_BookList)sesionFactory.getCurrentSession()
				.createQuery("from NguyenDucDuongViet_03_BookList b where b.bookCode = :code").setParameter("code", code).uniqueResult();
	}

}
