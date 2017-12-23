/**
 * 
 */
package vn.edu.hcmute.librarymanagement.dto.book;

import java.sql.Timestamp;

/**
 * @author Nguyen Duc Duong Viet
 *
 *         Dec 14, 2016
 *         
 *         Data Tranfer Object for json response
 *         
 *         Use to tranfer info user
 */
public class NguyenDucDuongViet_03_UserDTO {

	private Integer id;

	private String username;

	private String password;

	private String fullName;

	/// Khoa
	private String dept;

	// Lop
	private String className;

	private Timestamp dateOfBirth;

	private String address;

	//cmnd
	private String indentification;

	private String phone;

	private String avatar;

	// Quyen dang nhap
	private int role;

	/**
	 * 
	 */
	public NguyenDucDuongViet_03_UserDTO() {
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
	public NguyenDucDuongViet_03_UserDTO(Integer id, String username, String password, String fullName, String dept, String className,
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
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the fullName
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * @param fullName
	 *            the fullName to set
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	/**
	 * @return the dept
	 */
	public String getDept() {
		return dept;
	}

	/**
	 * @param dept
	 *            the dept to set
	 */
	public void setDept(String dept) {
		this.dept = dept;
	}

	/**
	 * @return the className
	 */
	public String getClassName() {
		return className;
	}

	/**
	 * @param className
	 *            the className to set
	 */
	public void setClassName(String className) {
		this.className = className;
	}

	/**
	 * @return the dateOfBirth
	 */
	public Timestamp getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @param dateOfBirth
	 *            the dateOfBirth to set
	 */
	public void setDateOfBirth(Timestamp dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the indentification
	 */
	public String getIndentification() {
		return indentification;
	}

	/**
	 * @param indentification
	 *            the indentification to set
	 */
	public void setIndentification(String indentification) {
		this.indentification = indentification;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone
	 *            the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the avatar
	 */
	public String getAvatar() {
		return avatar;
	}

	/**
	 * @param avatar
	 *            the avatar to set
	 */
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	/**
	 * @return the role
	 */
	public int getRole() {
		return role;
	}

	/**
	 * @param role
	 *            the role to set
	 */
	public void setRole(int role) {
		this.role = role;
	}

}
