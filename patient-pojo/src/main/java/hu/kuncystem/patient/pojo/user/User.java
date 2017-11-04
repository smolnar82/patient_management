package hu.kuncystem.patient.pojo.user;

public interface User {
	long getId();

	public void setId(long id);

	String getUserName();

	public void setUserName(String name);

	String getPassword();

	public void setPassword(String psw);

	String getFullname();

	public void setFullname(String name);

	String getEmail();

	public void setEmail(String email);

	public void setActive(boolean active);

	boolean isActive();

	@SuppressWarnings("rawtypes")
	public Class getType();

}
