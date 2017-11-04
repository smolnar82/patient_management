package hu.kuncystem.patient.pojo.user;

public class Doctor implements User {
	private long id;
	private String userName;
	private String password;
	private String fullname;
	private String email;
	private boolean active;
	
	public Doctor(){}
	
	public Doctor(long id){
		setId(id);
	}
	
	public Doctor(String userName, String password, boolean active){
		setUserName(userName);
		setPassword(password);
		setActive(active);
	}
	
	public long getId() {
		
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String name) {
		this.userName = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String psw) {
		this.password = psw;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String name) {
		this.fullname = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean isActive() {
		return active;
	}

	@SuppressWarnings("rawtypes")
	public Class getType() {
		return Doctor.class;
	}

}
