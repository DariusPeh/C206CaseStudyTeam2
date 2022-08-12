import java.util.ArrayList;
public class C206_CaseStudy {

	public static void main(String[] args) {
		//Parents accounts
		ArrayList<parents> parentList = new ArrayList<parents>();
		parentList.add(new parents("Jason Lim", 3, "3A", "Jennifer Tan", "Amy Lim",
				"amylim@gmail.com", 12345678));
		
		//Instructors accounts
		ArrayList<instructors> instructorList = new ArrayList<instructors>();
		instructorList.add(new instructors("Dennis Chang", "Basketball", "Physical Sports",
				"dennischang@school.edu.sg", "dennis"));
		instructorList.add(new instructors("Thomas Liang", "Robotics club", "Clubs and Societies",
				"thomasliang@school.edu.sg", "thomas"));
		
		//CCAs
		ArrayList<CCA> ccaList = new ArrayList<CCA>();
		ccaList.add(new CCA("Basketball", "Play basketball here!", 35, "Monday", 1330,
				"Basketball court", "Physical Sports", true, "Dennis Chang"));
		ccaList.add(new CCA("Robotics club", "Create and experiment with robots!", 30, "Thursday",
				1430, "Com Lab 4", "Clubs and Societies", true, "Thomas Liang"));
	}

}
