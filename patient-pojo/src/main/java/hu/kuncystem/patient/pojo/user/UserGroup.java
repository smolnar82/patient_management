package hu.kuncystem.patient.pojo.user;

public class UserGroup {
	private long id;
	private String name;
	private String note;

	public UserGroup() {}
	
	public UserGroup(long id) {
		setId(id);
	}

	public UserGroup(String name) {
		setName(name);
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getNote() {
		return note;
	}
}
