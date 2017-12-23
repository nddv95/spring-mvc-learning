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

import vn.edu.hcmute.librarymanagement.model.NguyenDucDuongViet_03_Category;

/**
 * @author Nguyen Duc Duong Viet
 *
 *         Dec 12, 2016
 * 
 *         Implement CategoryDAO interface
 * 
 */

@Repository
@Transactional
public class NguyenDucDuongViet_03_CategoryDAOImpl implements NguyenDucDuongViet_03_CategoryDAO {

	/**
	 * dùng để xuất thông tin ra console
	 */
	private static final Logger logger = LoggerFactory.getLogger(NguyenDucDuongViet_03_CategoryDAOImpl.class);

	/**
	 * sessionFactory dùng để truy cập với cơ sở dữ liệu thông qua hibernate 
	 */
	@Autowired
	private SessionFactory sessionFactory;

	/* (non-Javadoc)
	 * @see vn.edu.hcmute.librarymanagement.dao.NguyenDucDuongViet_03_CategoryDAO#findAll()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<NguyenDucDuongViet_03_Category> findAll() {
		logger.info("Get all category");
		return sessionFactory.getCurrentSession().createQuery("from NguyenDucDuongViet_03_Category").list();
	}

	/* (non-Javadoc)
	 * @see vn.edu.hcmute.librarymanagement.dao.NguyenDucDuongViet_03_CategoryDAO#findById(int)
	 */
	@Override
	public NguyenDucDuongViet_03_Category findById(int id) {
		logger.info("Get category by id...");
		return (NguyenDucDuongViet_03_Category) sessionFactory.getCurrentSession()
				.get(NguyenDucDuongViet_03_Category.class, id);
	}

	/* (non-Javadoc)
	 * @see vn.edu.hcmute.librarymanagement.dao.NguyenDucDuongViet_03_CategoryDAO#saveOrUpdate(vn.edu.hcmute.librarymanagement.model.NguyenDucDuongViet_03_Category)
	 */
	@Override
	public boolean saveOrUpdate(NguyenDucDuongViet_03_Category category) {
		logger.info("Saved category successfully...");
		sessionFactory.getCurrentSession().saveOrUpdate(category);
		return true;
	}

	/* (non-Javadoc)
	 * @see vn.edu.hcmute.librarymanagement.dao.NguyenDucDuongViet_03_CategoryDAO#delete(vn.edu.hcmute.librarymanagement.model.NguyenDucDuongViet_03_Category)
	 */
	@Override
	public boolean delete(NguyenDucDuongViet_03_Category category) {
		try {
			sessionFactory.getCurrentSession()
					.createQuery("delete from NguyenDucDuongViet_03_Category c where c.id = :id")
					.setParameter("id", category.getId()).executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		logger.info("Delete category successfully...");
		return true;
	}

}
