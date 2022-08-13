public class students {
	
	private String sName;
	private int sId;
	private int sGrade;
	private String sClass;
	private String sTeacher;
	private String role;
	
	public students(String sName, int sId, int sGrade, String sClass, String sTeacher) {
		this.sName = sName;
		this.sId = sId;
		this.sGrade = sGrade;
		this.sClass = sClass;
		this.sTeacher = sTeacher;
		this.role = "student";
	}
	
	public students(String sName, int sGrade, String sClass, String sTeacher) {
		this.sName = sName;
		this.sGrade = sGrade;
		this.sClass = sClass;
		this.sTeacher = sTeacher;
	}
	
	public students(String sName) {
		this.sName = sName;
	}
	
	public String getsName() {
		return sName;
	}
	
	public int getsId() {
		return sId;
	}
	
	public int getsGrade() {
		return sGrade;
	}
	
	public String getsClass() {
		return sClass;
	}
	
	public String getsTeacher() {
		return sTeacher;
	}
	
	public String getRole() {
		return role;
	}
}
	
