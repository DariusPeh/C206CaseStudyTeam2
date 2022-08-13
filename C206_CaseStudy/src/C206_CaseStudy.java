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
		categoryList.add(new Category(0, "Physical Sports"));
		categoryList.add(new Category(1, "Clubs and Societies"));
		
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
						String StudentsCCAsInString = C206_CaseStudy.getStudentCCA(studentccaList, studentName);
						System.out.println(StudentsCCAsInString);
						
					} else if (option == 2) {
						String name = Helper.readString("Enter Student Name > ");
						String cca = Helper.readString("Enter CCA to add > ");
						boolean isAdded = C206_CaseStudy.addStudentCCA(studentccaList, 
								ccaList, name, cca);
						
						if (isAdded == true) {
							System.out.println("New CCA added to student!");
						} else {
							System.out.println("Failed to add. Check name and CCA entered.");
						}
						
					} else if (option == 3) {
						String name = Helper.readString("Enter Student Name > ");
						String cca = Helper.readString("Enter CCA to drop > ");
						boolean isDropped = C206_CaseStudy.dropStudentCCA(studentccaList, name, cca);
						
						if(isDropped == true) {
							System.out.println("CCA successfully dropped!");
						} else {
							System.out.println("Failed to drop. Check name and CCA entered.");
						}
					} else if (option == 0) {
						isLogin = false;
						System.out.println("See you!");
					} else {
						System.out.println("Invalid option!");
					}
					
				//The Menu for Instructors
				} else if (roleSelect == 'i' || roleSelect == 'I') {
					C206_CaseStudy.showMenuInstructor();
					int option = Helper.readInt("Enter option > ");
					
					if (option == 1) {
						String CCAsInString = C206_CaseStudy.getCCA(ccaList);
						System.out.println(CCAsInString);
						
					} else if (option == 2) {
						String title = Helper.readString("Enter CCA title > ");
						String description = Helper.readString("Enter Description > ");
						int classSize = Helper.readInt("Enter class size > ");
						String day = Helper.readString("Enter day > ");
						String time = Helper.readString("Enter time > ");
						String venue = Helper.readString("Enter venue > ");
						String ctName = Helper.readString("Enter Category name > ");
						boolean available = Helper.readBoolean("Enter Availability > ");
						String instructoric = Helper.readString("Enter instructor's name > ");
						
						boolean isAdded = C206_CaseStudy.addCCA(ccaList, categoryList, title,
								description, classSize, day, time, venue, ctName, available,
								instructoric);
						
						if (isAdded == true) {
							System.out.println("New CCA added!");
						} else {
							System.out.println("Failed to add.");
						}
						
					} else if (option == 3) {
						String edit = Helper.readString("Enter CCA to edit > ");
						
						String description = Helper.readString("Enter Description > ");
						int classSize = Helper.readInt("Enter class size > ");
						String day = Helper.readString("Enter day > ");
						String time = Helper.readString("Enter time > ");
						String venue = Helper.readString("Enter venue > ");
						String ctName = Helper.readString("Enter Category name > ");
						boolean available = Helper.readBoolean("Enter Availability > ");
						String instructoric = Helper.readString("Enter instructor's name > ");
						
						boolean isEdited = C206_CaseStudy.editCCA(ccaList, categoryList, edit,
								description, classSize, day, time, venue, ctName, available,
								instructoric);
						
						if (isEdited == true) {
							System.out.println("CCA successfully edited!");
						} else {
							System.out.println("Failed to edit.");
						}
						
					} else if (option == 4) {
						String title = Helper.readString("Enter CCA to delete > ");
						String cInstructor = Helper.readString("Enter CCA instructor's name > ");
						
						boolean isDeleted = C206_CaseStudy.deleteCCA(ccaList, title, cInstructor);
						
						if (isDeleted == true) {
							System.out.println("CCA successfully Deleted!");
						} else {
							System.out.println("Failed to Delete. Check name and CCA entered.");
						}
						
					} else if (option == 5) {
						String CategoryInString = C206_CaseStudy.getCategory(categoryList);
						System.out.println(CategoryInString);
						
					} else if (option == 6) {
						String ctName2 = Helper.readString("Enter CCA Category to add > ");
						
						boolean isAdded = C206_CaseStudy.addCategory(categoryList, ctName2);
						
						if (isAdded == true) {
							System.out.println("Category Successfully added!");
						} else {
							System.out.println("Failed to Add.");
						}
						
					} else if (option == 7) {
						String ctName2 = Helper.readString("Enter CCA Category to delete> ");
						
						boolean isDeleted = C206_CaseStudy.deleteCategory(categoryList, ctName2);
						
						if (isDeleted == true) {
							System.out.println("Category Successfully deleted!");
						} else {
							System.out.println("Failed to delete.");
						}
						
					} else if (option == 0) {
						isLogin = false;
						System.out.println("See you!");
					} else {
						System.out.println("Invalid option!");
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
	
	public static String getStudentCCA(ArrayList<StudentHasCCA> studentccaList, String studentName) {
		String output = "";
		output += String.format("%-10s %-10s %-10s %-10s\n", "STUDENT", "CCA 1", "CCA 2", "CCA 3");
		for (int i = 0; i < studentccaList.size(); i++) {
			if (studentccaList.get(i).getsName().equalsIgnoreCase(studentName)) {
				output += String.format("%-10s %-10s %-10s %-10s\n",
					studentccaList.get(i).getsName(), studentccaList.get(i).getCCA1(),
					studentccaList.get(i).getCCA2(), studentccaList.get(i).getCCA3());
			}
		}
		return output;
	}
	
	public static boolean addStudentCCA (ArrayList<StudentHasCCA> studentccaList, ArrayList<CCA> ccaList,
			String name, String cca) {
		boolean added = false;
		if (name != "") {
			for (int i = 0; i < studentccaList.size(); i++) {
				if (studentccaList.get(i).getsName().equalsIgnoreCase(name)) {
					if (studentccaList.get(i).getCCA1() == null) {
						for (int k = 0; k < ccaList.size(); k++) {
							if(cca.equalsIgnoreCase(ccaList.get(k).getcTitle())) {
								studentccaList.get(i).setCCA1(cca);
								added = true;
								break;
							} else {
								System.out.println("CCA does not exist!");
							}
						}
					} else if (studentccaList.get(i).getCCA2() == null) {
						for (int k = 0; k < ccaList.size(); k++) {
							if (cca.equalsIgnoreCase(ccaList.get(k).getcTitle())) {
								studentccaList.get(i).setCCA2(cca);
								added = true;
								break;
							} else {
								System.out.println("CCA does not exist!");
							}
						}
					} else if (studentccaList.get(i).getCCA3() == null) {
						for (int k = 0; k < ccaList.size(); k++) {
							if(cca.equalsIgnoreCase(ccaList.get(k).getcTitle())) {
								studentccaList.get(i).setCCA3(cca);
								added = true;
								break;
							} else {
								System.out.println("CCA does not exist!");
							}
						}
					} else {
						System.out.println("Student has registered max amount of CCAs!");
						added = false;
					}
					break;
				} else {
					for (int k = 0; k < ccaList.size(); k++) {
						if(cca.equalsIgnoreCase(ccaList.get(k).getcTitle())) {
							studentccaList.add(new StudentHasCCA(name, cca, null, null));
							added = true;
							break;
						} else {
							System.out.println("CCA does not exist!");
						}
					}
				}
			}
		} else {
			System.out.println("Please enter a name.");
			added = false;
		}
		return added;
	}
	
	public static boolean dropStudentCCA(ArrayList<StudentHasCCA> studentccaList, String name, String cca) {
		boolean dropped = false;
		for (int i = 0; i < studentccaList.size(); i++) {
			if (name.equalsIgnoreCase(studentccaList.get(i).getsName()) 
					&& cca.equalsIgnoreCase(studentccaList.get(i).getCCA1())) {
				studentccaList.get(i).setCCA1(null);
				dropped = true;
				System.out.println("CCA " + cca + " dropped for " + name + "!");
				break;
			} else if (name.equalsIgnoreCase(studentccaList.get(i).getsName()) 
					&& cca.equalsIgnoreCase(studentccaList.get(i).getCCA2())) {
				studentccaList.get(i).setCCA2(null);
				dropped = true;
				System.out.println("CCA " + cca + " dropped for " + name + "!");
				break;
			} else if (name.equalsIgnoreCase(studentccaList.get(i).getsName()) 
					&& cca.equalsIgnoreCase(studentccaList.get(i).getCCA3())) {
				studentccaList.get(i).setCCA3(null);
				dropped = true;
				System.out.println("CCA " + cca + " dropped for " + name + "!");
				break;
			} else {
				System.out.println("Student/CCA does not exist!");
			}
		}
		return dropped;
	}
	
	public static String getCCA(ArrayList<CCA> ccaList) {
		String output = "";
		output += String.format("%-10s %-10d %-10s %-10s %-10s %-10s %-10b %-10s %-10s\n",
				"NAME", "CLASS SIZE", "DAY", "TIME", "VENUE", "CATEGORY", "AVAILABILITY",
				"INSTRUCTOR", "DESCRIPTION");
		for (int i = 0; i < ccaList.size(); i++) {
			if (ccaList.get(i) != null) {
				output += String.format("%-10s %-10d %-10s %-10s %-10s %-10s %-10b %-10s %-10s\n",
						ccaList.get(i).getcTitle(), ccaList.get(i).getClassSize(), 
						ccaList.get(i).getDay(), ccaList.get(i).getTime(), ccaList.get(i).getVenue(),
						ccaList.get(i).getctName(), ccaList.get(i).getAvailable(),
						ccaList.get(i).getcInstructor(), ccaList.get(i).getDescription());
			}
		}
		return output;
	}
	
	public static boolean addCCA(ArrayList<CCA> ccaList, ArrayList<Category> categoryList,
			String title, String description, int classSize, String day, String time,
			String venue, String ctName, boolean available, String instructoric) {
		boolean added = false;
		if (classSize <= 50) {
			if (day != "Saturday" && day != "Sunday") {
				for (int i = 0; i < categoryList.size(); i++) {
					if (ctName.equalsIgnoreCase(categoryList.get(i).getctName())) {
						ccaList.add(new CCA(title, description, classSize, day, time, 
								venue, ctName, available, instructoric));
						added = true;
						break;
					} else {
						System.out.println("Invalid.");
					}
				}
			} else {
				System.out.println("Invalid.");
			}
		} else {
			System.out.println("Invalid.");
		}
		return added;
	}
	
	public static boolean editCCA(ArrayList<CCA> ccaList, ArrayList<Category> categoryList,
			String edit, String description, int classSize, String day, String time,
			String venue, String ctName, boolean available, String instructoric) {
		boolean edited = false;
		if (classSize <= 50) {
			if (day != "Saturday" && day != "Sunday") {
				for (int i = 0; i < ccaList.size(); i++) {
					if (edit.equalsIgnoreCase(ccaList.get(i).getcTitle())) {
						ccaList.get(i).setcTitle(edit);
						ccaList.get(i).setDescription(description);
						ccaList.get(i).setClassSize(classSize);
						ccaList.get(i).setDay(day);
						ccaList.get(i).setTime(time);
						ccaList.get(i).setVenue(venue);
						ccaList.get(i).setctName(ctName);
						ccaList.get(i).setAvailable(available);
						ccaList.get(i).setcInstructor(instructoric);
						edited = true;
					}
				}
			} else {
				System.out.println("Invalid.");
			}
		} else {
			System.out.println("Invalid.");
		}
		return edited;
	}
	
	public static boolean deleteCCA(ArrayList<CCA> ccaList, String title, String cInstructor) {
		boolean deleted = false;
		for (int i = 0; i < ccaList.size(); i++) {
			if (title.equalsIgnoreCase(ccaList.get(i).getcTitle()) && cInstructor.equalsIgnoreCase(ccaList.get(i).getcInstructor())) {
				String output = String.format("%-10s %-10d %-10s %-10s %-10s %-10s %-10b %-10s %-10s\n",
					ccaList.get(i).getcTitle(), ccaList.get(i).getClassSize(), 
					ccaList.get(i).getDay(), ccaList.get(i).getTime(), ccaList.get(i).getVenue(),
					ccaList.get(i).getctName(), ccaList.get(i).getAvailable(),
					ccaList.get(i).getcInstructor(), ccaList.get(i).getDescription());
				System.out.println(output);
				
				char confirm = Helper.readChar("Are you sure you want to delete the CCA above? (y/n) > ");
				if (confirm == 'y' || confirm == 'Y') {
					ccaList.remove(i);
					deleted = true;
					break;
				}
			} else {
				System.out.println("CCA/Instructor is not found.");
				deleted = false;
				break;
			}
		}
		return deleted;
	}
	
	public static String getCategory(ArrayList<Category> categoryList) {
		String output = "";
		output += String.format("%-10s %-10s\n", "ID", "NAME");
		for (int i = 0; i < categoryList.size(); i++) {
			if (categoryList.get(i) != null) {
				output += String.format("%-10s %-10s\n", categoryList.get(i).getctID(),
						categoryList.get(i).getctName());
			}
		}
		return output;
	}
	
	public static boolean addCategory(ArrayList<Category> categoryList, String ctName2) {
		boolean added = false;
		for (int i = 0; i < categoryList.size(); i++) {
			if(categoryList.get(i) != null && ctName2 != categoryList.get(i).getctName()) {
				categoryList.add(new Category((i + 1), ctName2));
				added = true;
				break;
			}
		}
		return added;
	}
	
	public static boolean deleteCategory(ArrayList<Category> categoryList, String ctName2) {
		boolean deleted = false;
		for (int i = 0; i < categoryList.size(); i++) {
			if(categoryList.get(i) != null && categoryList.get(i).getctName().equalsIgnoreCase(ctName2)) {
				String output = String.format("%-10s %-10s\n", categoryList.get(i).getctID(),
						categoryList.get(i).getctName());
				System.out.println(output);
				
				char confirm = Helper.readChar("Are you sure you want to delete the CCA category above? (y/n) > ");
				if (confirm == 'y' || confirm == 'Y') {
					categoryList.remove(i);
					deleted = true;
					break;
				}
			} else {
				System.out.println("Category not found.");
			}
		}
		return deleted;
	}
}
