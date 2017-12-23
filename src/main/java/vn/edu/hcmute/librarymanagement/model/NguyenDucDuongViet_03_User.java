package vn.edu.hcmute.librarymanagement.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * @author Nguyen Duc Duong Viet
 *
 * Dec 9, 2016
 * 
 * model mapping to user table in database
 */

@Entity
@Table(name = "user", uniqueConstraints = @UniqueConstraint(columnNames = { "username" }))
public class NguyenDucDuongViet_03_User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "username", length = 16, nullable = false)
	private String username;

	@Column(name = "password", length = 30, nullable = false)
	private String password;

	@Column(name = "full_name", length = 100)
	private String fullName;

	/// Khoa
	@Column(name = "dept", length = 50)
	private String dept;

	// Lop
	@Column(name = "class", length = 15)
	private String className;

	@Column(name = "date_of_birth")
	private Timestamp dateOfBirth;

	@Column(name = "address", length = 100)
	private String address;

	// CMND
	@Column(name = "indentification", length = 15)
	private String indentification;

	@Column(name = "phone", length = 15)
	private String phone;

	@Column(name = "avatar", length = 20)
	private String avatar;

	// Quyen dang nhap
	@Column(name = "role", nullable = false)
	private int role;

	@OneToMany(mappedBy = "user")
	private List<NguyenDucDuongViet_03_OrderBook> orderBooks;
	
	@OneToMany(mappedBy = "user")
	private List<NguyenDucDuongViet_03_BookFavorite> bookFavorites;

	/**
	 * 
	 */
	public NguyenDucDuongViet_03_User() {

	}

	/**
	 * @param id
	 * @param username
	 * @param password
	 * @param fullName
	 * @param dept
	 * @param className
	 * @param dateOfBirth
	 * @param address
	 * @param indentification
	 * @param phone
	 * @param avatar
	 * @param role
	 */
	public NguyenDucDuongViet_03_User(int id, String username, String password, String fullName, String dept, String className,
			Timestamp dateOfBirth, String address, String indentification, String phone, String avatar, int role) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.fullName = fullName;
		this.dept = dept;
		this.className = className;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.indentification = indentification;
		this.phone = phone;
		this.avatar = avatar;
		this.role = role;
	}


	/**
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * @param fullName
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	/**
	 * @return
	 */
	public String getDept() {
		return dept;
	}

	/**
	 * @param dept
	 */
	public void setDept(String dept) {
		this.dept = dept;
	}

	/**
	 * @return
	 */
	public String getClassName() {
		return className;
	}

	/**
	 * @param className
	 */
	public void setClassName(String className) {
		this.className = className;
	}

	/**
	 * @return
	 */
	public Timestamp getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @param dateOfBirth
	 */
	public void setDateOfBirth(Timestamp dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * @return
	 */
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getIndentification() {
		return indentification;
	}

	public void setIndentification(String indentification) {
		this.indentification = indentification;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public List<NguyenDucDuongViet_03_OrderBook> getListBookOrder() {
		return orderBooks;
	}

	public void setListBookOrder(List<NguyenDucDuongViet_03_OrderBook> listBookOrder) {
		this.orderBooks = listBookOrder;
	}

}