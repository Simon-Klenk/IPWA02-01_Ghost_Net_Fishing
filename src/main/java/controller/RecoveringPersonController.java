package controller;

import java.io.Serializable;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

@Named
@SessionScoped
public class RecoveringPersonController implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
	private String firstName;
	private String phoneNumber;
	private boolean login;
	
	public RecoveringPersonController() {
		login = false;
	}
	
	public String nextSite() {
		if (name != null & firstName != null & phoneNumber != null) {
			this.setLogin(true);
		}
		return Pages.TABLE_GHOST_NETS;
	}
	
	public String cancel() {
		return Pages.INDEX;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public boolean isLogin() {
		return login;
	}

	public void setLogin(boolean login) {
		this.login = login;
	}
	
}