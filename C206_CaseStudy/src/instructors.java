
public class instructors extends CCA{
	private String iEmail;
	private String password;
	private String role;
	
	public instructors(String cInstructor, String cTitle, String ctName, String iEmail,
			String password) {
		super(cInstructor, cTitle, ctName);
		this.iEmail = iEmail;
		this.password = password;
		this.role = "instructor";
	}

	public String getiEmail() {
		return iEmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}
	
}