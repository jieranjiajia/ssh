package org.study.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/**
 * 注意当有默认值的时候，需要把动态插入和动态update添加上
 * 不然当插入的实体类的映射字段为null时，则数据库表中插入
 * 的并不是默认值而是null
 */
@Entity
@Table(name="User")
@DynamicInsert(true)
@DynamicUpdate(true)
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String salt;
	private String loginName;
	private String password;
	private String email;
	private Date createTime;
	private Integer status;
	
	private Set<Role> roles = new HashSet<Role>();
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name="SALT")
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	@Column(name="LOGIN_NAME")
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	@Column(name="PASSWORD")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Column(name="EMAIL")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(name="CREATE_TIME")
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Column(name="STATUS")
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	/**
	 * 配置多对多的关系
	 */
	@ManyToMany(targetEntity=Role.class,fetch=FetchType.EAGER)
	@JoinTable(name="USER_ROLE",
				joinColumns=@JoinColumn(name="USERID"),
				inverseJoinColumns=@JoinColumn(name="ROLEID"))
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", salt=" + salt + ", loginName=" + loginName + ", password=" + password + ", email="
				+ email + ", createTime=" + createTime + ", status=" + status + ", roles=" + roles + "]";
	}
	
	@Transient
	public Set<String> getRolesString() {
		Set<String> _roles = new HashSet<String>();
		
		for(Iterator<Role> it = this.roles.iterator();
				it.hasNext();) {
			Role role = it.next();
			_roles.add(role.getRoleName());
		}
		
		return _roles;
	}
	
}
