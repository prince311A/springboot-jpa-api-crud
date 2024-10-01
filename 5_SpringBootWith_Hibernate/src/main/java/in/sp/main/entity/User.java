package in.sp.main.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_details")
public class User {
	@Id()
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int userID;
	@Column
	private String name;
	@Column
	private String email;
	@Column
	private String phone;
	@Column
	private String password;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int userID, String name, String email, String phone, String password) {
		super();
		this.userID = userID;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [userID=" + userID + ", name=" + name + ", email=" + email + ", phone=" + phone + ", password="
				+ password + "]";
	}
	
	

}
