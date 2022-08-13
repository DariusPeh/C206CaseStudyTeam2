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
		studentList.add(new students("Jason Lim", 22222, 3, "3A", "Jennifer Tan"));
		
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
		
		//CCA Categories
		ArrayList<Category> categoryList = new ArrayList<Category>();
		categoryList.add(new Category(0, "Basketball"));
		categoryList.add(new Category(1, "Robotics club"));
		
		//Student CCA list
		ArrayList<StudentHasCCA> studentccaList = new ArrayList<StudentHasCCA>();
		studentccaList.add(new StudentHasCCA("Timothy Tan", "Basketball", null, null));
		studentccaList.add(new StudentHasCCA("Jason Lim", "Robotics club", null, null));
		
		//Login/Register
		while(true) {
			boolean isLogin = false;
			String studentName = "";
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
						studentccaList.add(new StudentHasCCA(name, null, null, null));
						
						Random r = new Random();
						regID = r.nextInt(9000) + 1000;
						System.out.println("Your registration ID is " + regID);
						
						Helper.line(20, "=");
						System.out.println("LOGIN PARENT ACCOUNT");
						
						int logStudentID = Helper.readInt("Enter student ID > ");
						int logRegID = Helper.readInt("Enter registration ID > ");
						
						isLogin = C206_CaseStudy.loginParent(studentList, logStudentID, logRegID, regID);
						studentName = name;
						if (isLogin == false) {
							System.out.println("Your student ID or registration ID was incorrect. Please try again!");
						}
					} else {
						System.out.println("Parent registration failed. Try again.");
					}
					
				} else if (logreg == 'l' || logreg == 'L') {
					Helper.line(20, "=");
					System.out.println("LOGIN PARENT ACCOUNT");
					
					int logStudentID = Helper.readInt("Enter student ID > "); 
					int logRegID = Helper.readInt("Enter registration ID > ");
					
					//getting name of student of the parent
					for (int i = 0; i < studentList.size(); i++) {
						if (studentList.get(i).getsId() == logStudentID) {
							studentName = studentList.get(i).getsName();
						}
					}
					
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
						studentccaList.add(new StudentHasCCA(name, null, null, null));
						
						Helper.line(20, "=");
						System.out.println("LOGIN STUDENT ACCOUNT");
						
						int logStudentID = Helper.readInt("Enter student ID > ");
						
						studentName = name;
						isLogin = C206_CaseStudy.loginStudent(studentList, logStudentID);
						if (isLogin == false) {
							System.out.println("Your student ID or registration ID was incorrect. Please try again!");
						}
					} else {
						System.out.println("Student registration failed. Try again");
					}
					
				} else if (logreg == 'l' || logreg == 'L') {
					Helper.line(20, "=");
					System.out.println("LOGIN STUDENT ACCOUNT");
					
					int logStudentID = Helper.readInt("Enter student ID > "); 
					
					for (int i = 0; i < studentList.size(); i++) {
						if (studentList.get(i).getsId() == logStudentID) {
							studentName = studentList.get(i).getsName();
						}
					}
					isLogin = C206_CaseStudy.loginStudent(studentList, logStudentID);
					if (isLogin == false) {
						System.out.println("Your student ID or registration ID was incorrect. Please try again!");
					}
				}
				
				
			//Instructor login/register
			} else if (roleSelect == 'i' || roleSelect == 'I') {
				Helper.line(20, "=");
				System.out.println("LOGIN INSTRUCTOR ACCOUNT");
				
				String instructorName = Helper.readString("Enter your name > ");
				
				isLogin = C206_CaseStudy.loginInstructor(instructorList, instructorName);
				if (isLogin == false) {
					System.out.println("Your username was incorrect. Please try again.");
				}
				
			} else {
				System.out.println("Invalid option. Please try again!");
			}
			
			while(isLogin == true) {
				//The Menu for parents/students
				if ((roleSelect == 'p' || roleSelect == 'P') || (roleSelect == 's' || roleSelect == 'S')) {
					C206_CaseStudy.showMenu();
					int option = Helper.readInt("Enter option > ");
					
					if (option == 1) {
						String StudentsCCAsInString = C206_CaseStudy.getStudentCCA
								(studentccaList, studentList, parentList, roleSelect, studentName);
						System.out.println(StudentsCCAsInString);
					}
				}
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
	
	public static boolean loginInstructor (ArrayList<instructors> instructorList, String instructorName) {
		boolean iValid = false;
		for(int i = 0; i < instructorList.size(); i++) {
			if(instructorName.equalsIgnoreCase(instructorList.get(i).getcInstructor())) {
				iValid = true;
			}
		}
		return iValid;
	}
	
	public static void showMenu() {
		Helper.line(30, "=");
		System.out.println("MENU");
		Helper.line(30, "=");
		System.out.println("1. View all registered CCAs");
		System.out.println("2. Add student to CCA");
		System.out.println("3. Drop student from CCA");
		System.out.println("0. Log out");
	}
	
	public static void showMenuInstructor() {
		Helper.line(30, "=");
		System.out.println("MENU");
		Helper.line(30, "=");
		System.out.println("1. View all CCAs");
		System.out.println("2. Add CCAs");
		System.out.println("3. Edit CCAs");
		System.out.println("4. Delete CCAs");
		System.out.println("5. View all categories");
		System.out.println("6. Add category");
		System.out.println("7. Delete category");
		System.out.println("0. Log out");
	}
	
	public static String getStudentCCA(ArrayList<StudentHasCCA> studentccaList, 
			ArrayList<students> studentList, ArrayList<parents> parentList, char roleSelect,
			String studentName) {
		String output = "";
		output += String.format("%-15s %-15s %-15s %-15s\n", "STUDENT", "CCA 1", "CCA 2", "CCA 3");
		
		if (roleSelect == 'p' || roleSelect == 'P') {
			for (int i = 0; i < studentccaList.size(); i++) {
				if (studentccaList.get(i).getsName().equalsIgnoreCase(studentName)) {
					output += String.format("%-15s %-15s %-15s %-15s\n",
							studentccaList.get(i).getsName(), studentccaList.get(i).getCCA1(),
							studentccaList.get(i).getCCA2(), studentccaList.get(i).getCCA3());
				}
			}
		} else if (roleSelect == 's' || roleSelect == 'S') {
			for (int i = 0; i < studentccaList.size(); i++) {
				if (studentccaList.get(i).getsName().equalsIgnoreCase(studentName)) {
					output += String.format("%-15s %-15s %-15s %-15s\n",
							studentccaList.get(i).getsName(), studentccaList.get(i).getCCA1(),
							studentccaList.get(i).getCCA2(), studentccaList.get(i).getCCA3());
				}
			}
		}
		return output;
	}
}
