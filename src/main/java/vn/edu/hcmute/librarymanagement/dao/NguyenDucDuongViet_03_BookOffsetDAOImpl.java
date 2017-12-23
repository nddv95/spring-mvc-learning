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

import vn.edu.hcmute.librarymanagement.model.NguyenDucDuongViet_03_BookOffset;

/**
 * @author Nguyen Duc Duong Viet
 *
 * Dec 12, 2016
 * 
 * Implement BookOffsetDAO
 */
@Repository
@Transactional
public class NguyenDucDuongViet_03_BookOffsetDAOImpl implements NguyenDucDuongViet_03_BookOffsetDAO {

	/**
	 * dùng để xuất thông tin ra console
	 */
	private static final Logger logger =  LoggerFactory.getLogger(NguyenDucDuongViet_03_BookOffsetDAOImpl.class);
	
	/**
	 * sessionFactory dùng để truy cập với cơ sở dữ liệu thông qua hibernate
	 */
	@Autowired
	private SessionFactory sessionFactory;

	/* (non-Javadoc)
	 * @see vn.edu.hcmute.librarymanagement.dao.NguyenDucDuongViet_03_BookOffsetDAO#findAll()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<NguyenDucDuongViet_03_BookOffset> findAll() {
		logger.info("Find all book offset");
		return sessionFactory.getCurrentSession().createQuery("from NguyenDucDuongViet_03_BookOffset").list();
	}

	/* (non-Javadoc)
	 * @see vn.edu.hcmute.librarymanagement.dao.NguyenDucDuongViet_03_BookOffsetDAO#findById(int)
	 */
	@Override
	public NguyenDucDuongViet_03_BookOffset findById(int id) {
		logger.info("Find book offset by id:" + id);
		return sessionFactory.getCurrentSession().get(NguyenDucDuongViet_03_BookOffset.class, id);
	}

	/* (non-Javadoc)
	 * @see vn.edu.hcmute.librarymanagement.dao.NguyenDucDuongViet_03_BookOffsetDAO#save(vn.edu.hcmute.librarymanagement.model.NguyenDucDuongViet_03_BookOffset)
	 */
	@Override
	public boolean save(NguyenDucDuongViet_03_BookOffset bookOffset) {
		logger.info("Save book offset...");
		try{
			sessionFactory.getCurrentSession().saveOrUpdate(bookOffset);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see vn.edu.hcmute.librarymanagement.dao.NguyenDucDuongViet_03_BookOffsetDAO#findByBorrow(int)
	 */
	@Override
	public List<NguyenDucDuongViet_03_BookOffset> findByBorrow(int borrowId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
