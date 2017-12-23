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

import vn.edu.hcmute.librarymanagement.model.NguyenDucDuongViet_03_User;

/**
 * @author Nguyen Duc Duong Viet
 *
 *         Dec 12, 2016
 * 
 *         Implement UserDAO
 * 
 */
@Repository
@Transactional
public class NguyenDucDuongViet_03_UserDAOImpl implements NguyenDucDuongViet_03_UserDAO {

	/**
	 * dùng để xuất thông tin ra console
	 */
	private static final Logger logger = LoggerFactory.getLogger(NguyenDucDuongViet_03_UserDAOImpl.class);
	
	/**
	 * sessionFactory dùng để truy cập với cơ sở dữ liệu thông qua hibernate
	 */
	@Autowired
	private SessionFactory sessionFactory;

	/* (non-Javadoc)
	 * @see vn.edu.hcmute.librarymanagement.dao.NguyenDucDuongViet_03_UserDAO#findAll()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<NguyenDucDuongViet_03_User> findAll() {
		logger.info("Find all user...");
		return sessionFactory.getCurrentSession().createQuery("from NguyenDucDuongViet_03_User").list();
	}

	/* (non-Javadoc)
	 * @see vn.edu.hcmute.librarymanagement.dao.NguyenDucDuongViet_03_UserDAO#findUserById(int)
	 */
	@Override
	public NguyenDucDuongViet_03_User findUserById(int userId) {
		logger.info("Find user by i...d");
		return (NguyenDucDuongViet_03_User) sessionFactory.getCurrentSession().get(NguyenDucDuongViet_03_User.class,
				userId);
	}

	/* (non-Javadoc)
	 * @see vn.edu.hcmute.librarymanagement.dao.NguyenDucDuongViet_03_UserDAO#saveOrUpdate(vn.edu.hcmute.librarymanagement.model.NguyenDucDuongViet_03_User)
	 */
	@Override
	public boolean saveOrUpdate(NguyenDucDuongViet_03_User user) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(user);
			logger.info("Save user susscess");
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see vn.edu.hcmute.librarymanagement.dao.NguyenDucDuongViet_03_UserDAO#delete(vn.edu.hcmute.librarymanagement.model.NguyenDucDuongViet_03_User)
	 */
	@Override
	public boolean delete(NguyenDucDuongViet_03_User user) {
		try {
			sessionFactory.getCurrentSession().createQuery("delete from NguyenDucDuongViet_03_User u where u.id = :id")
					.setParameter("id", user.getId()).executeUpdate();
			logger.info("Delete user susscess");
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see vn.edu.hcmute.librarymanagement.dao.NguyenDucDuongViet_03_UserDAO#checkUsernameIsExist(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean checkUsernameIsExist(String username) {
		String hql = "From NguyenDucDuongViet_03_User u where u.username = :username";
		List<NguyenDucDuongViet_03_User> user = sessionFactory.getCurrentSession().createQuery(hql)
				.setParameter("username", username).list();
		logger.info("Check user exist, list size:" + user.size());
		if (user.isEmpty() || user == null)
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see vn.edu.hcmute.librarymanagement.dao.NguyenDucDuongViet_03_UserDAO#findByUsernameAndPassword(java.lang.String, java.lang.String)
	 */
	@Override
	public NguyenDucDuongViet_03_User findByUsernameAndPassword(String username, String password) {
		String hql = "From NguyenDucDuongViet_03_User u where u.username = :username and password = :password";
		logger.info("Login with username and password");
		return (NguyenDucDuongViet_03_User) sessionFactory.getCurrentSession().createQuery(hql)
				.setParameter("username", username).setParameter("password", password).uniqueResult();
	}

	/* (non-Javadoc)
	 * @see vn.edu.hcmute.librarymanagement.dao.NguyenDucDuongViet_03_UserDAO#findAllStudent()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<NguyenDucDuongViet_03_User> findAllStudent() {
		List<NguyenDucDuongViet_03_User> result = sessionFactory.getCurrentSession()
				.createQuery("from NguyenDucDuongViet_03_User u where u.role = :role order by u.username").setParameter("role", 1).list();
		logger.info(result.size() + "");
		return result;
	}

}
