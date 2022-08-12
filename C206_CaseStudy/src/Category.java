/**
 * I declare that this code was written by me on 2022-Aug-11 4:28:48 PM 
 * @author 20011490
 * 
 */

public class Category {
	
	private String ctName;
	private int ctId;
	private String ctDescription;

	public Category(String ctName, int ctId, String ctDescription) {
		this.ctName = ctName;
		this.ctId = ctId;
		this.ctDescription = ctDescription;
	}
	
	public Category(String ctName) {
		this.ctName = ctName;
	}

	public String getctName() {
		return ctName;
	}

	public void setctName(String ctName) {
		this.ctName = ctName;
	}

	public int getctId() {
		return ctId;
	}

	public void setctId(int ctId) {
		this.ctId = ctId;
	}

	public String getctDescription() {
		return ctDescription;
	}
	
	public void setctDescription(String ctDescription) {
		this.ctDescription = ctDescription;
	}
	}
