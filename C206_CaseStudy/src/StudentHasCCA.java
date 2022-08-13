/*
 * I declare that this code was written by me. 
 * I do not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Quah Ming Yao
 * Student ID: 21023135
 * Class: W64N
 * Date/Time created: Saturday 13-08-2022 16:29
 */

/**
 * @author MY_NB
 *
 */
public class StudentHasCCA extends students{
	private String CCA1;
	private String CCA2;
	private String CCA3;
	
	public StudentHasCCA(String sName, String CCA1, String CCA2, String CCA3) {
		super(sName);
		this.CCA1 = CCA1;
		this.CCA2 = CCA2;
		this.CCA3 = CCA3;
	}

	public String getCCA1() {
		return CCA1;
	}

	public void setCCA1(String cCA1) {
		this.CCA1 = cCA1;
	}

	public String getCCA2() {
		return CCA2;
	}

	public void setCCA2(String cCA2) {
		this.CCA2 = cCA2;
	}

	public String getCCA3() {
		return CCA3;
	}

	public void setCCA3(String cCA3) {
		this.CCA3 = cCA3;
	}
	
}
