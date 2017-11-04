package hu.kuncystem.patient.pojo.session;

public class Session {
	private long id;
	private long userId;
	private String ip;
	private String userAgent;
	private boolean disable;
	
	public Session() {}
	
	public Session(long id) {
		setId(id);
	}

	public Session(long userId, String ip) {
		setId(userId);
		setIp(ip);
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getUserId() {
		return userId;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getIp() {
		return ip;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public void setDisabled(boolean disabled) {
		this.disable = disabled;
	}

	public boolean isDisabled() {
		return disable;
	}
}
