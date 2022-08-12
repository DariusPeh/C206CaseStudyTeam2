
public class instructors extends CCA{
	private String iEmail;
	private String role;
	
	public instructors(String cInstructor, String cTitle, String ctName, String iEmail) {
		super(cInstructor, cTitle, ctName);
		this.iEmail = iEmail;
		this.role = "instructor";
	}

	public String getiEmail() {
		return iEmail;
	}

	public String getRole() {
		return role;
	}
	
}