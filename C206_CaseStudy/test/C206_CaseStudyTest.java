import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	private CCA cca1;
	private CCA cca2;
	private Category c1;
	private Category c2;
	private parents p1;
	private parents p2;
	private students s1;
	private students s2;
	
	private ArrayList<CCA> ccaList;
	private ArrayList<Category> categoryList;
	private ArrayList<parents> parentsList;
	private ArrayList<students> studentsList;
	
	public C206_CaseStudyTest() {
		super();
	}
	@Before
	public void setUp() throws Exception {
		// prepare test data
		cca1 = new CCA("Basketball", "Ball bouncing team sport", 40, "Wednesday", "2:00PM",
				"basketball court", "Physical Sports", true, "amran@WSSS.edu.sg");
		cca2 = new CCA("Choir", "Group of singers", 30, "Friday", "2:30PM", "Music room",
				"Visual and Performing Arts", true, "ally@WSSS.edu.sg");
		c1 = new Category("Sports");
		c2 = new Category("Uniformed group");
		p1 = new parents("Nicole", 1, "4A", "Miss Lim", "Alice", "Alice@gmail.com", 88172121);
		p2 = new parents("Michael", 4, "5B", "Mr gan", "Lee", "Lee@yahoo.com", 92218181);
		s1 = new students("Rachel", 1, "4A", "Miss Lim");
		s2 = new students("Ronald", 3, "5C", "Mr chew");

		ccaList= new ArrayList<CCA>();
		categoryList= new ArrayList<Category>();
		parentsList= new ArrayList<parents>();
		studentsList= new ArrayList<students>();
		
		
	
	}
	// Test for add all student
	@Test
	public void testAddStudent() {
		
		assertNotNull("Test if it is a valid student to add in the arrayList", studentsList);
		
		C206_CaseStudy.addStudent(studentsList, s1);
		assertEquals("Test if arrayList equals to 1?", 1, studentsList.size());
		assertSame("Test that student is added same as 1st item of the list?", s1, studentsList.get(0));
		
		C206_CaseStudy.addStudent(studentsList, s2);
		assertEquals("Test if arrayList equals to 2?", 2, studentsList.size());
		assertSame("Test that student is added same as 1st item of the list?", s2, studentsList.get(1));
		}
	
	
	// Test for view all student
	@Test
		public void testRetrieveAllStudent() {
		assertNotNull("Test if there is a valid student array to add", studentsList);
		String viewAllStudent = C206_CaseStudy.retrieveAllStudent(studentsList);
		String output = "";
		assertSame("ViewAllStudentlist", output, viewAllStudent);
		
		C206_CaseStudy.addStudents(studentsList,s1);
		assertEquals("Test if arrayList size is equal to 1?", 1, studentsList.size());
		
		viewAllStudent = C206_CaseStudy.retrieveAllStudent(studentsList);
		
		output = String.format("%-15s %-15s %-15s %-15s\n", "sName", "sId", "sGrade", "sClass", "sTeacher");
	}
	
	// Test for delete student
	@Test
    public void testDoReturnStudent() {
     
      assertNotNull("Test if there is valid Student arraylist to add to", studentsList);
      C206_CaseStudy.addStudent(studentsList, s1);
      
      Boolean isReturned = C206_CaseStudy.deleteStudent(studentsList, "s1");
      assertFalse("Test if available Student s1 is returned -false?", isReturned);
   
      isReturned = C206_CaseStudy.deleteStudent(studentsList, "S1");
      assertFalse("Test if non-existing Student s1 is returned - false?", isReturned);

    }
}
