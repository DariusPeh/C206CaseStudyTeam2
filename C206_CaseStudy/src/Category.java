/**
 * I declare that this code was written by me on 2022-Aug-11 4:28:48 PM 
 * @author 20011490
 * 
 */

public class Category {
	private int ctID;
	private String ctName;
	
	public Category(int ctID, String ctName) {
		this.ctID = ctID;
		this.ctName = ctName;
	}

	public Category(String ctName) {
		this.ctName = ctName;
	}
	
	public int getctID() {
		return ctID;
	}
	
	public String getctName() {
		return ctName;
	}

	public void setctName(String ctName) {
		this.ctName = ctName;
	}
	
	
}
