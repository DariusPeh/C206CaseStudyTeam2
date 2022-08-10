public class students{
	
	private String sName;
	private int sGrade;
	private String sClass;
	private String sTeacher;

	public students(String sName, int sGrade, String sClass, String sTeacher) {
		this.sName = sName;
		this.sGrade = sGrade;
		this.sClass = sClass;
		this.sTeacher = sTeacher;
	}
	
	public String getsName() {
		return sName;
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
}
	
