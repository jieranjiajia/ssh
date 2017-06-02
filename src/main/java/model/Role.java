package model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


/**
 * 使用hibernate的注解方式配置持久化映射
 */
@Entity
@Table(name="ROLE")
public class Role implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7866268301527913501L;
	/**主键*/
	private Integer id;
	/**角色名称*/
	private String name;
	/**角色描述*/
	private String description;
	/**排序*/
	private Integer seq;
	/**状态*/
	private Integer status;
	
	private Set<User> users = new HashSet<User>();
	
	/*配置uuid策略
	 *  javax.persistence.GeneratedValue;
	 *	@GenericGenerator(name="paymentableGenerator",strategy="uuid")
	 *  org.hibernate.annotations.GenericGenerator
	 *	@GeneratedValue(generator="paymentableGenerator")
	 */
	@Id
	@Column(name="ID")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="ROLE_NAME",unique=true,nullable=false)
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="DESCRIPTION")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	@Column(name="SEQ")
	public Integer getSeq() {
		return seq;
	}
	public void setSeq(Integer seq) {
		this.seq = seq;
	}
	
	/**
	 * 配置多对多的关联映射
	 */
	@ManyToMany(mappedBy="roles")
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + ", description=" + description + ", status=" + status + "]";
	}
	
}
