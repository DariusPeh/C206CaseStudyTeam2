
public class parents extends students{
	
	private String pName;
	private String pEmail;
	private int pContactNo;
	
	public parents(String sName, int sGrade, String sClass, String sTeacher, 
			String pName, String pEmail, int pContactNo) {
		super(sName, sGrade, sClass, sTeacher);
		this.pName = pName;
		this.pEmail = pEmail;
		this.pContactNo = pContactNo;
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
}
