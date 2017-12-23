/**
 * 
 */
package vn.edu.hcmute.librarymanagement.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.edu.hcmute.librarymanagement.model.NguyenDucDuongViet_03_Book;
import vn.edu.hcmute.librarymanagement.model.NguyenDucDuongViet_03_User;

/**
 * @author Nguyen Duc Duong Viet
 *
 *         Dec 12, 2016
 * 
 *         Implement BookDAO
 * 
 */
@Repository
@Transactional
public class NguyenDucDuongViet_03_BookDAOImpl implements NguyenDucDuongViet_03_BookDAO {

	/**
	 * dùng để xuất thông tin ra console
	 */
	private static final Logger logger = LoggerFactory.getLogger(NguyenDucDuongViet_03_BookDAOImpl.class);

	/**
	 * sessionFactory dùng để truy cập với cơ sở dữ liệu thông qua hibernate
	 */
	@Autowired
	private SessionFactory sessionFactory;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * vn.edu.hcmute.librarymanagement.dao.NguyenDucDuongViet_03_BookDAO#findAll
	 * ()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<NguyenDucDuongViet_03_Book> findAll() {
		logger.info("Get all book...");
		return sessionFactory.getCurrentSession().createQuery("from NguyenDucDuongViet_03_Book").list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vn.edu.hcmute.librarymanagement.dao.NguyenDucDuongViet_03_BookDAO#
	 * findBookByCategory(int)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<NguyenDucDuongViet_03_Book> findBookByCategory(int category_id) {
		logger.info("Get books by category...");
		// String sql = "select * from book where book.category_id = ?";
		String hql = "from NguyenDucDuongViet_03_Book e where e.category.id = :categoryId";
		return sessionFactory.getCurrentSession().createQuery(hql).setParameter("categoryId", category_id).list();
		// return
		// sessionFactory.getCurrentSession().createSQLQuery(sql).setParameter(0,
		// category_id).list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vn.edu.hcmute.librarymanagement.dao.NguyenDucDuongViet_03_BookDAO#
	 * findBookHotInMonth()
	 * 
	 * Chưa có dữ liệu nên chỉ lấy dữ liệu ngẫu nhiên
	 */
	@Override
	public List<NguyenDucDuongViet_03_Book> findBookHotInMonth() {
		logger.info("Get books hot in month...");
		List<NguyenDucDuongViet_03_Book> books = findAll();
		//đảo ngẫu nhiên list
		Collections.shuffle(books);
		List<NguyenDucDuongViet_03_Book> booksResult = new ArrayList<>();
		for (int i = 0; i < 6; i++) {
			booksResult.add(books.get(i));
		}

		return booksResult;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vn.edu.hcmute.librarymanagement.dao.NguyenDucDuongViet_03_BookDAO#
	 * findBookByUserDept(vn.edu.hcmute.librarymanagement.model.
	 * NguyenDucDuongViet_03_User)
	 * 
	 * Chưa thực hiện được
	 */
	@Override
	public List<NguyenDucDuongViet_03_Book> findBookByUserDept(NguyenDucDuongViet_03_User user) {
		logger.info("Get books by user dept...");
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vn.edu.hcmute.librarymanagement.dao.NguyenDucDuongViet_03_BookDAO#
	 * findBookByNameOrAuthor(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<NguyenDucDuongViet_03_Book> findBookByNameOrAuthor(String search) {
		logger.info("Search book...");
		String hql = "from NguyenDucDuongViet_03_Book e where e.name like :search or e.author like :search";
		return sessionFactory.getCurrentSession().createQuery(hql).setString("search", "%" + search + "%").list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vn.edu.hcmute.librarymanagement.dao.NguyenDucDuongViet_03_BookDAO#
	 * saveOrUpdate(vn.edu.hcmute.librarymanagement.model.
	 * NguyenDucDuongViet_03_Book)
	 */
	@Override
	public boolean saveOrUpdate(NguyenDucDuongViet_03_Book book) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(book);
			logger.info("Saved book successfully...");
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * vn.edu.hcmute.librarymanagement.dao.NguyenDucDuongViet_03_BookDAO#delete(
	 * vn.edu.hcmute.librarymanagement.model.NguyenDucDuongViet_03_Book)
	 */
	@Override
	public boolean delete(NguyenDucDuongViet_03_Book book) {
		try {
			sessionFactory.getCurrentSession().createQuery("delete from NguyenDucDuongViet_03_Book b where b.id = :id")
					.setParameter("id", book.getId()).executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		logger.info("Delete book successfully...");
		return true;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vn.edu.hcmute.librarymanagement.dao.NguyenDucDuongViet_03_BookDAO#
	 * findBookById(int)
	 */
	@Override
	public NguyenDucDuongViet_03_Book findBookById(int id) {
		logger.info("Find book by id...");
		return (NguyenDucDuongViet_03_Book) sessionFactory.getCurrentSession().get(NguyenDucDuongViet_03_Book.class,
				id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vn.edu.hcmute.librarymanagement.dao.NguyenDucDuongViet_03_BookDAO#
	 * findRelatedByCategory(int)
	 * 
	 * Lấy ngẫu nhiên những sách cùng loại
	 */
	@Override
	public List<NguyenDucDuongViet_03_Book> findRelatedByCategory(int category_id) {
		logger.info("Get books hot in month...");
		List<NguyenDucDuongViet_03_Book> books = findBookByCategory(category_id);
		Collections.shuffle(books);
		List<NguyenDucDuongViet_03_Book> booksResult = new ArrayList<>();
		if (books.size() < 6) {
			for (int i = 0; i < books.size(); i++) {
				booksResult.add(books.get(i));
			}
		} else {
			for (int i = 0; i < 6; i++) {
				booksResult.add(books.get(i));
			}
		}

		return booksResult;
	}

}
