/**
 * 
 */
package vn.edu.hcmute.librarymanagement.dao;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.edu.hcmute.librarymanagement.model.NguyenDucDuongViet_03_OrderBook;
import vn.edu.hcmute.librarymanagement.model.NguyenDucDuongViet_03_OrderBookDetail;

/**
 * @author Nguyen Duc Duong Viet
 *
 *         Dec 12, 2016
 */

@Repository
@Transactional
public class NguyenDucDuongViet_03_OrderBookDAOImpl implements NguyenDucDuongViet_03_OrderBookDAO {

	/**
	 * dùng để xuất thông tin ra console
	 */
	private static final Logger logger = LoggerFactory.getLogger(NguyenDucDuongViet_03_OrderBookDAOImpl.class);

	/**
	 * sessionFactory dùng để truy cập với cơ sở dữ liệu thông qua hibernate
	 */
	@Autowired
	private SessionFactory sessionFactory;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * vn.edu.hcmute.librarymanagement.dao.NguyenDucDuongViet_03_OrderBookDAO#
	 * findAllOrderBook()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<NguyenDucDuongViet_03_OrderBook> findAllOrderBook() {
		return sessionFactory.getCurrentSession()
				.createQuery("from NguyenDucDuongViet_03_OrderBook o where o.isTakenBook = :isTaken")
				.setBoolean("isTaken", false).list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * vn.edu.hcmute.librarymanagement.dao.NguyenDucDuongViet_03_OrderBookDAO#
	 * findOrderBookById(int)
	 */
	@Override
	public NguyenDucDuongViet_03_OrderBook findOrderBookById(int id) {
		return (NguyenDucDuongViet_03_OrderBook) sessionFactory.getCurrentSession()
				.get(NguyenDucDuongViet_03_OrderBook.class, id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * vn.edu.hcmute.librarymanagement.dao.NguyenDucDuongViet_03_OrderBookDAO#
	 * findOrderBookByUser(int)
	 */
	@Override
	public NguyenDucDuongViet_03_OrderBook findOrderBookByUser(int userId) {
		NguyenDucDuongViet_03_OrderBook result = (NguyenDucDuongViet_03_OrderBook) sessionFactory.getCurrentSession()
				.createQuery(
						"from NguyenDucDuongViet_03_OrderBook o where o.user.id = :userId and o.isTakenBook = :isTaken")
				.setParameter("userId", userId).setBoolean("isTaken", false).uniqueResult();
		if (result != null) {
			Calendar calendar = Calendar.getInstance();
			Date now = calendar.getTime();
			Timestamp today = new Timestamp(now.getTime());
			if (today.after(result.getDateEnd())) {
				deleteOrder(result.getId());
				return null;
			}
		}
		return result;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * vn.edu.hcmute.librarymanagement.dao.NguyenDucDuongViet_03_OrderBookDAO#
	 * findOrderBookDetailByOrder(int)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<NguyenDucDuongViet_03_OrderBookDetail> findOrderBookDetailByOrder(int orderBookId) {
		return sessionFactory.getCurrentSession()
				.createQuery(
						"from NguyenDucDuongViet_03_OrderBookDetail o where o.orderBook.id = :id order by o.book.id")
				.setParameter("id", orderBookId).list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * vn.edu.hcmute.librarymanagement.dao.NguyenDucDuongViet_03_OrderBookDAO#
	 * findOrderBookDetailById(int)
	 */
	@Override
	public NguyenDucDuongViet_03_OrderBookDetail findOrderBookDetailById(int id) {
		return sessionFactory.getCurrentSession().get(NguyenDucDuongViet_03_OrderBookDetail.class, id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * vn.edu.hcmute.librarymanagement.dao.NguyenDucDuongViet_03_OrderBookDAO#
	 * saveOrderBook(vn.edu.hcmute.librarymanagement.model.
	 * NguyenDucDuongViet_03_OrderBook)
	 */
	@Override
	public int saveOrderBook(NguyenDucDuongViet_03_OrderBook orderBook) {

		int id = 0;
		try {
			id = (int) sessionFactory.getCurrentSession().save(orderBook);
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
	 * vn.edu.hcmute.librarymanagement.dao.NguyenDucDuongViet_03_OrderBookDAO#
	 * saveOrderBookDetail(vn.edu.hcmute.librarymanagement.model.
	 * NguyenDucDuongViet_03_OrderBookDetail)
	 */
	@Override
	public boolean saveOrderBookDetail(NguyenDucDuongViet_03_OrderBookDetail orderBookDetail) {
		try {
			sessionFactory.getCurrentSession().save(orderBookDetail);
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
	 * vn.edu.hcmute.librarymanagement.dao.NguyenDucDuongViet_03_OrderBookDAO#
	 * deleteOrder(int)
	 */
	@Override
	public boolean deleteOrder(int orderId) {
		try {
			sessionFactory.getCurrentSession()
					.createQuery("delete from NguyenDucDuongViet_03_OrderBook c where c.id = :id")
					.setParameter("id", orderId).executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		logger.info("Delete OrderBook successfully...");
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * vn.edu.hcmute.librarymanagement.dao.NguyenDucDuongViet_03_OrderBookDAO#
	 * deleteOrderDetail(int)
	 */
	@Override
	public boolean deleteOrderDetail(int orderDetailId) {
		try {
			sessionFactory.getCurrentSession()
					.createQuery("delete from NguyenDucDuongViet_03_OrderBookDetail c where c.id = :id")
					.setParameter("id", orderDetailId).executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		logger.info("Delete OrderBookDetail successfully...");
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * vn.edu.hcmute.librarymanagement.dao.NguyenDucDuongViet_03_OrderBookDAO#
	 * findOrderBookDetailByOrderAndBook(int, int)
	 */
	@Override
	public NguyenDucDuongViet_03_OrderBookDetail findOrderBookDetailByOrderAndBook(int orderId, int bookId) {
		// TODO Auto-generated method stub
		return (NguyenDucDuongViet_03_OrderBookDetail) sessionFactory.getCurrentSession()
				.createQuery(
						"from NguyenDucDuongViet_03_OrderBookDetail o where o.orderBook.id = :id and o.book.id = :bookId")
				.setParameter("id", orderId).setParameter("bookId", bookId).uniqueResult();
	}

}
