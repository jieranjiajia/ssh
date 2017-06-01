package action;

import com.opensymphony.xwork2.ActionSupport;

import model.User;

public class UserAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private User user;
	
	public String toLogin() {
		return "login";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
