/**
 * I declare that this code was written by me on 2022-Aug-11 4:28:48 PM 
 * @author 20011490
 * 
 */

public class CCA extends Category{
	
	public String cTitle;
	public String description;
	public int classSize;
	public String day;
	public int time;
	public String venue;
	public boolean isAvailable;
	public String cInstructor;

	public CCA(String cTitle, String description, int classSize, String day, int time, String venue,
			String ctName, int ctId, String ctDescription, boolean isAvailable, String cInstructor) {
		super(ctName, ctId, ctDescription);
		this.cTitle = cTitle;
		this.description = description;
		this.classSize = classSize;
		this.day = day;
		this.time = time;
		this.venue = venue;
		this.isAvailable = isAvailable;
		this.cInstructor = cInstructor;
	}
	
	public CCA(String cInstructor, String cTitle,  String ctName) {
		super(ctName);
		this.cInstructor = cInstructor;
		this.cTitle = cTitle;
	}

	public String getcTitle() {
		return cTitle;
	}

	public void setcTitle(String cTitle) {
		this.cTitle = cTitle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getClassSize() {
		return classSize;
	}

	public void setClassSize(int classSize) {
		this.classSize = classSize;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public String getcInstructor() {
		return cInstructor;
	}

	public void setcInstructor(String cInstructor) {
		this.cInstructor = cInstructor;
	}
	
}
