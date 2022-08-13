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
		
		//Login/Register
		while(true) {
			boolean isLogin = false;
			Helper.line(30, "=");
			System.out.println("SCHOOL CCA REGISTRATION - REGISTER/LOGIN");
			Helper.line(30, "=");
			
			char roleSelect = Helper.readChar("Are you a parent/student/instructor? (Enter p/s/i) > ");
			
			//Parent register/login
			if (roleSelect == 'p' || roleSelect == 'P') {
				int regID = 0;
				char logreg = Helper.readChar("Login or register? (Enter l/r) > ");
				
				if (logreg == 'r' || logreg == 'R') {
					Helper.line(20, "=");
					System.out.println("REGISTER PARENT ACCOUNT");
					
					int studentID = Helper.readInt("Enter student ID > ");
					String name = Helper.readString("Enter student name > ");
					int studentGrade = Helper.readInt("Enter student grade > ");
					String studentClass = Helper.readString("Enter student class > ");
					String formTeacher = Helper.readString("Enter Form Teacher's name > ");
					String parentName = Helper.readString("Enter parent's name > ");
					String parentEmail = Helper.readString("Enter parent's Email > ");
					int parentContact = Helper.readInt("Enter parent's contact number > ");
					boolean isVerified = C206_CaseStudy.verify(studentList, studentID);
					
					if (isVerified == true) {
						parentList.add(new parents(name, studentGrade, studentClass, formTeacher, 
								parentName, parentEmail, parentContact));
						studentList.add(new students(name, studentID, studentGrade, studentClass,
								formTeacher));
						
						Random r = new Random();
						regID = r.nextInt(9000) + 1000;
						System.out.println("Your registration ID is " + regID);
						
						int logStudentID = Helper.readInt("Enter student ID > ");
						int logRegID = Helper.readInt("Enter registration ID > ");
						
						isLogin = C206_CaseStudy.loginParent(studentList, logStudentID, logRegID, regID);
						if (isLogin == false) {
							System.out.println("Your student ID or registration ID was incorrect. Please try again!");
						}
					} else {
						System.out.println("Parent registration failed. Try again.");
					}
					
				} else if (logreg == 'l' || logreg == 'L') {
					int logStudentID = Helper.readInt("Enter student ID > "); 
					int logRegID = Helper.readInt("Enter registration ID > ");
					
					isLogin = C206_CaseStudy.loginParent(studentList, logStudentID, logRegID, regID);
					if (isLogin == false) {
						System.out.println("Your student ID or registration ID was incorrect. Please try again!");
					}
				}
				
			//Student login/register	
			} else if (roleSelect == 's' || roleSelect == 'S'){
				char logreg = Helper.readChar("Login or register? (Enter l/r) > ");
				
				if (logreg == 'r' || logreg == 'R') {
					Helper.line(20, "=");
					System.out.println("REGISTER STUDENT ACCOUNT");
					
					int studentID = Helper.readInt("Enter student ID > ");
					String name = Helper.readString("Enter student name > ");
					int studentGrade = Helper.readInt("Enter student grade > ");
					String studentClass = Helper.readString("Enter student class > ");
					String formTeacher = Helper.readString("Enter Form Teacher's name > ");
					boolean isVerified = C206_CaseStudy.verify(studentList, studentID);
					
					if (isVerified == true) {
						studentList.add(new students(name, studentID, studentGrade, studentClass,
								formTeacher));
						
						int logStudentID = Helper.readInt("Enter student ID > ");
						
						isLogin = C206_CaseStudy.loginStudent(studentList, logStudentID);
						if (isLogin == false) {
							System.out.println("Your student ID or registration ID was incorrect. Please try again!");
						}
					} else {
						System.out.println("Student registration failed. Try again");
					}
				} else if (logreg == 'l' || logreg == 'L') {
					int logStudentID = Helper.readInt("Enter student ID > "); 
					
					isLogin = C206_CaseStudy.loginStudent(studentList, logStudentID);
					if (isLogin == false) {
						System.out.println("Your student ID or registration ID was incorrect. Please try again!");
					}
				}
			} else {
				System.out.println("Invalid option. Please try again!");
			}
			while(isLogin == true) {
				
			}
		}
	}
	
	public static boolean verify (ArrayList<students> studentList, int studentID) {
		boolean verified = false;
		String id = "";
		id = id + studentID;
		if (id != "") {
			for (int i = 0; i < studentList.size(); i++) {
				if (studentID == studentList.get(i).getsId()) {
					System.out.println("Duplicate student found!");
					verified = false;
				} else {
					verified = true;
				}
			}
		}
		return verified;
	}
	
	public static boolean loginParent (ArrayList<students> studentList, int logStudentID, int logRegID, int regID) {
		boolean valid = false;
		for(int i = 0; i < studentList.size(); i++) {
			if(logStudentID == studentList.get(i).getsId() && logRegID == regID) {
				valid = true;
			}
		}
		return valid;
	}
	
	public static boolean loginStudent (ArrayList<students> studentList, int logStudentID) {
		boolean sValid = false;
		for(int i = 0; i < studentList.size(); i++) {
			if(logStudentID == studentList.get(i).getsId()) {
				sValid = true;
			}
		}
		return sValid;
	}
}
