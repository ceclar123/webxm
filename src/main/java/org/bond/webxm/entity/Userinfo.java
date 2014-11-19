package org.bond.webxm.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * SpringMVC+Hibernate +MySql+ EasyUI ---CRUD
 * 
 * @author 宗潇帅 类名称：Userinfo
 * @date 2014-11-15 下午1:37:47 备注：
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "userinfo", catalog = "test")
public class Userinfo implements java.io.Serializable {

	// Fields

	private Integer id; // 主键
	private String name;// 名字
	private Integer age;// 年龄
	private Date birthday;// 生日
	private String address;// 地址
	private String password;// 密码

	// Constructors

	/** default constructor */
	public Userinfo() {
	}

	/** full constructor */

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public Userinfo(Integer id, String name, Integer age, Date birthday, String address, String password) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.birthday = birthday;
		this.address = address;
		this.password = password;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "name")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "age")
	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Column(name = "birthday", length = 19)
	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Column(name = "address")
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "password")
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}