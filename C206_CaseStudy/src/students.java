public class students{
	
	private String sName;
	private String sEmail;
	private int sContactNo;
	private int sStudentId;

	public students(String sName, String sEmail, int sContactNo, int sStudentId) {
		super();
		this.sName = sName;
		this.sEmail = sEmail;
		this.sContactNo = sContactNo;
		this.sStudentId = sStudentId;
	}
	
	public String getsName() {
		return sName;
	}
	public String getsEmail() {
		return sEmail;
	}
	public int getsContactNo() {
		return sContactNo;
	}
	public int getsStudentId() {
		return sStudentId;
	}
	
	
}
	
