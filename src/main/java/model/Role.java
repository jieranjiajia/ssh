package model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Role implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7866268301527913501L;
	private Integer id;
	private String name;
	private String description;
	private Integer status;
	
	private Set<User> users = new HashSet<User>();
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
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
