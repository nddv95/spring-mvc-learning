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

import vn.edu.hcmute.librarymanagement.model.NguyenDucDuongViet_03_BookFavorite;

/**
 * @author Nguyen Duc Duong Viet
 *
 *         Dec 12, 2016
 * 
 *         Implement BookFavoriteDAO
 * 
 */
@Repository
@Transactional
public class NguyenDucDuongViet_03_BookFavoriteDAOImpl implements NguyenDucDuongViet_03_BookFavoriteDAO {

	/**
	 * dùng để xuất thông tin ra console
	 */
	private static final Logger logger = LoggerFactory.getLogger(NguyenDucDuongViet_03_BookFavoriteDAOImpl.class);

	/**
	 * sessionFactory dùng để truy cập với cơ sở dữ liệu thông qua hibernate
	 */
	@Autowired
	private SessionFactory sessionFactory;

	/* (non-Javadoc)
	 * @see vn.edu.hcmute.librarymanagement.dao.NguyenDucDuongViet_03_BookFavoriteDAO#findBookFavoriteByUser(int)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<NguyenDucDuongViet_03_BookFavorite> findBookFavoriteByUser(int userId) {
		logger.info("Get all book favorite of user");
		return sessionFactory.getCurrentSession()
				.createQuery("from NguyenDucDuongViet_03_BookFavorite b where b.user.id = :id order by b.book.id")
				.setParameter("id", userId).list();
	}

	/* (non-Javadoc)
	 * @see vn.edu.hcmute.librarymanagement.dao.NguyenDucDuongViet_03_BookFavoriteDAO#save(vn.edu.hcmute.librarymanagement.model.NguyenDucDuongViet_03_BookFavorite)
	 */
	@Override
	public boolean save(NguyenDucDuongViet_03_BookFavorite bookFavorite) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(bookFavorite);
			logger.info("Save new book success");
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see vn.edu.hcmute.librarymanagement.dao.NguyenDucDuongViet_03_BookFavoriteDAO#delete(vn.edu.hcmute.librarymanagement.model.NguyenDucDuongViet_03_BookFavorite)
	 */
	@Override
	public boolean delete(NguyenDucDuongViet_03_BookFavorite bookFavorite) {
		try {
			sessionFactory.getCurrentSession()
					.createQuery("delete from NguyenDucDuongViet_03_BookFavorite b where b.id = :id")
					.setParameter("id", bookFavorite.getId()).executeUpdate();
			logger.info("delete a book favorite success");
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see vn.edu.hcmute.librarymanagement.dao.NguyenDucDuongViet_03_BookFavoriteDAO#deleteAll(int)
	 */
	@Override
	public boolean deleteAll(int userId) {
		try {
			sessionFactory.getCurrentSession()
					.createQuery("delete from NguyenDucDuongViet_03_BookFavorite b where b.user.id = :id")
					.setParameter("id", userId).executeUpdate();
			logger.info("Delete bookfavorite's user success");
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see vn.edu.hcmute.librarymanagement.dao.NguyenDucDuongViet_03_BookFavoriteDAO#findBookFavoriteById(int)
	 */
	@Override
	public NguyenDucDuongViet_03_BookFavorite findBookFavoriteById(int id) {
		// TODO Auto-generated method stub
		return (NguyenDucDuongViet_03_BookFavorite) sessionFactory.getCurrentSession()
				.get(NguyenDucDuongViet_03_BookFavorite.class, id);
	}

	/* (non-Javadoc)
	 * @see vn.edu.hcmute.librarymanagement.dao.NguyenDucDuongViet_03_BookFavoriteDAO#findBookFavoriteExist(int, int)
	 */
	@Override
	public NguyenDucDuongViet_03_BookFavorite findBookFavoriteExist(int userId, int bookId) {
		String hql = "from NguyenDucDuongViet_03_BookFavorite b where b.user.id = :userId and b.book.id = :bookId";
		return (NguyenDucDuongViet_03_BookFavorite) sessionFactory.getCurrentSession().createQuery(hql)
				.setParameter("userId", userId).setParameter("bookId", bookId).uniqueResult();
	}

}
