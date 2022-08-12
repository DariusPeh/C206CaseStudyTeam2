import java.util.ArrayList;
import java.util.Random;
public class C206_CaseStudy {

	public static void main(String[] args) {
		//Parents accounts
		ArrayList<parents> parentList = new ArrayList<parents>();
		parentList.add(new parents("Jason Lim", 3, "3A", "Jennifer Tan", "Amy Lim",
				"amylim@gmail.com", 12345678));
		//Student accounts
		ArrayList<students> studentList = new ArrayList<students>();
		studentList.add(new students("Timothy Tan", 11111, 4, "4D", "Theresa Jiang"));
		
		//Instructors accounts
		ArrayList<instructors> instructorList = new ArrayList<instructors>();
		instructorList.add(new instructors("Dennis Chang", "Basketball", "Physical Sports",
				"dennischang@school.edu.sg"));
		instructorList.add(new instructors("Thomas Liang", "Robotics club", "Clubs and Societies",
				"thomasliang@school.edu.sg"));
		
		//CCAs
		ArrayList<CCA> ccaList = new ArrayList<CCA>();
		ccaList.add(new CCA("Basketball", "Play basketball here!", 35, "Monday", "3:30PM - 4:30PM",
				"Basketball court", "Physical Sports", true, "Dennis Chang"));
		ccaList.add(new CCA("Robotics club", "Create and experiment with robots!", 30, "Thursday",
				"2:30PM - 3:30PM", "Com Lab 4", "Clubs and Societies", true, "Thomas Liang"));
		
		int regID = 0;
		
		//Login/Register
		while(true) {
			Helper.line(30, "=");
			System.out.println("SCHOOL CCA REGISTRATION - REGISTER/LOGIN");
			Helper.line(30, "=");
			
			String role = Helper.readString("Are you a parent/student/instructor? (Enter p/s/i) > ");
			if (role == "p" || role == "P") {
				String logreg = Helper.readString("Login or register? (Enter l/r) > ");
				if (logreg == "r" || logreg == "R") {
					Helper.line(20, "=");
					System.out.println("REGISTER PARENT ACCOUNT");
					
					String name = Helper.readString("Enter student name > ");
					int studentGrade = Helper.readInt("Enter student grade > ");
					String studentClass = Helper.readString("Enter student class > ");
					String formTeacher = Helper.readString("Enter Form Teacher's name > ");
					String parentName = Helper.readString("Enter parent's name > ");
					String parentEmail = Helper.readString("Enter parent's Email > ");
					int parentContact = Helper.readInt("Enter parent's contact number > ");
					boolean isVerified = C206_CaseStudy.verify(parentList, name);
					
					if (isVerified == true) {
						parentList.add(new parents(name, studentGrade, studentClass, formTeacher, 
								parentName, parentEmail, parentContact));
						Random r = new Random();
						regID = r.nextInt(9000) + 1000;
						System.out.println("Your registration ID is " + regID);
					} else {
						System.out.println("Registration failed. Try again.");
					}
				} else if (logreg == "l" || logreg == "L") {
					int studentID = Helper.readInt("Enter student ID > "); 
					int logRegID = Helper.readInt("Enter registration ID > ");
				}
			}
		}
	}
	
	public static boolean verify (ArrayList<parents> parentList, String name) {
		boolean verified = false;
		if (name != "") {
			for (int i = 0; i < parentList.size(); i++) {
				if (name.equalsIgnoreCase(parentList.get(i).getsName())) {
					System.out.println("Duplicate student found!");
					verified = false;
				} else {
					verified = true;
				}
			}
		}
		return verified;
	}
}
