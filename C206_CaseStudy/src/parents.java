
public class parents extends students{
	
	private String pName;
	private String pEmail;
	private int pContactNo;
	private String role;
	
	public parents(String sName, int sGrade, String sClass, String sTeacher, 
			String pName, String pEmail, int pContactNo, String role) {
		super(sName, sGrade, sClass, sTeacher);
		this.pName = pName;
		this.pEmail = pEmail;
		this.pContactNo = pContactNo;
		this.role = role;
	}
	
	public String getpName() {
		return pName;
	}
	public String getpEmail() {
		return pEmail;
	}
	public int getpContactNo() {
		return pContactNo;
	}
	
	public String getRole() {
		return role;
	}
}
