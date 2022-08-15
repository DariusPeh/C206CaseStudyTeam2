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
				"basketball court", "Physical Sports", true, "Mr amran");
		cca2 = new CCA("Choir", "Group of singers", 30, "Friday", "2:30PM", "Music room",
				"Visual and Performing Arts", true, "Mr ally");
		c1 = new Category("Sports");
		c2 = new Category("Uniformed group");
		p1 = new parents("Nicole", 1, "2A", "Miss Lim", "Alice", "Alice@gmail.com", 88172121);
		p2 = new parents("Michael", 4, "2B", "Mr gan", "Lee", "Lee@yahoo.com", 92218181);
		s1 = new students("Rachel", 11111, 1, "4A", "Miss Lim");
		s2 = new students("Ronald", 22222, 3, "5C", "Mr chew");

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
		assertSame("Test that student is added same as 2nd item of the list?", s2, studentsList.get(1));
		}
	
	
	// Test for view all student
	@Test
		public void testRetrieveAllStudent() {
		assertNotNull("Test if there is a valid student array to add", studentsList);
		String viewAllStudent = C206_CaseStudy.viewAllStudent(studentsList);
		String output = "";
		assertSame("ViewAllStudentlist", output, viewAllStudent);
		
		C206_CaseStudy.addStudent(studentsList, s1);
		assertEquals("Test if arrayList size is equal to 1?", 1, studentsList.size());
		
		viewAllStudent = C206_CaseStudy.viewAllStudent(studentsList);
		
		output = String.format("%-15s %-15s %-15s %-15s\n", "Timothy Tan", "11111", "4D", "Theresa Jiang");
		
		output += String.format("%-15s %-15s %-15s %-15s\n", "Jason Lim", "22222", "3A", "Jennifer Tan");

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
	
	// Test for add category
	@Test
	public void testAddCategory() {
		
		assertNotNull("Test if it is a valid category to add in the arrayList", categoryList);
		
		C206_CaseStudy.addCategory(categoryList, c1);
		assertEquals("Test if arrayList equals to 1?", 1, categoryList.size());
		assertSame("Test that category is added same as 1st item of the list?", c1, categoryList.get(0));
		
		C206_CaseStudy.addCategory(categoryList, c2);
		assertEquals("Test if arrayList equals to 2?", 2, categoryList.size());
		assertSame("Test that category is added same as 2nd item of the list?", c2, categoryList.get(1));
		}
	// Test for view all category
	@Test
		public void testRetrieveAllCategory() {
		assertNotNull("Test if there is a valid category array to add", categoryList);
		String viewAllCategory = C206_CaseStudy.viewAllCategory(categoryList);
		String output = "";
		assertSame("ViewAllCategorylist", output, viewAllCategory);
		
		C206_CaseStudy.addCategory(categoryList, c1);
		assertEquals("Test if arrayList size is equal to 1?", 1, categoryList.size());
		
		viewAllCategory = C206_CaseStudy.viewAllCategory(categoryList);
		
		output = String.format("%-15s\n", "ctName");
	}
	// Test for delete category
		@Test
	    public void testDoDeleteCategory() {
			
			assertNotNull("Test if it is a valid category to delete in the arrayList", categoryList);
			
			C206_CaseStudy.deleteCategory(categoryList, c1);
			assertEquals("Test if arrayList equals to 0?", 0, categoryList.size());
			assertSame("Test that category deleted same as 1st item of the list?", c1, categoryList.get(0));
			
			C206_CaseStudy.deleteCategory(categoryList, c2);
			assertEquals("Test if arrayList equals to 1?", 1, categoryList.size());
			assertSame("Test that category deleted same as 2nd item of the list?", c2, categoryList.get(1));
			}
		// Test for add all parent
		@Test
		public void testAddParent() {
			assertNotNull("Test if it is a valid parent to add in the arrayList", parentsList);
			
			C206_CaseStudy.addParent(parentsList, p1);
			assertEquals("Test if arrayList equals to 1?", 1, parentsList.size());
			assertSame("Test that parent is added same as 1st item of the list?", p1, parentsList.get(0));
			
			C206_CaseStudy.addParent(parentsList, p2);
			assertEquals("Test if arrayList equals to 2?", 2, parentsList.size());
			assertSame("Test that parent is added same as 1st item of the list?", p2, parentsList.get(1));
			}
		// Test for add CCA
		@Test
		public void testAddCCA() {
			
			assertNotNull("Test if it is a valid category to add in the arrayList", ccaList);
			
			C206_CaseStudy.addCCA(ccaList, cca1);
			assertEquals("Test if arrayList equals to 1?", 1, ccaList.size());
			assertSame("Test that CCA is added same as 1st item of the list?", cca1, ccaList.get(0));
			
			C206_CaseStudy.addCCA(ccaList, cca2);
			assertEquals("Test if arrayList equals to 2?", 2, ccaList.size());
			assertSame("Test that CCA is added same as 2nd item of the list?", cca2, ccaList.get(1));
			}
		// Test for view all CCA
		@Test
			public void testRetrieveAllCCA() {
			assertNotNull("Test if there is a valid CCA array to add", ccaList);
			String viewAllCCA = C206_CaseStudy.viewAllCCA(ccaList);
			String output = "";
			assertSame("ViewAllCCAlist", output, viewAllCCA);
			
			C206_CaseStudy.addCCA(ccaList, cca1);
			assertEquals("Test if arrayList size is equal to 1?", 1, ccaList.size());
			
			viewAllCCA = C206_CaseStudy.viewAllCCA(ccaList);
			
			output = String.format("%-15s\n", "cName");
		}
		// Test for delete CCA
			@Test
		    public void testDoDeleteCCA() {
				
				assertNotNull("Test if it is a valid CCA to delete in the arrayList", ccaList);
				
				C206_CaseStudy.deleteCCA(ccaList, cca1);
				assertEquals("Test if arrayList equals to 0?", 0, categoryList.size());
				assertSame("Test that cca deleted same as 1st item of the list?", cca1, ccaList.get(0));
				
				C206_CaseStudy.deleteCCA(ccaList, cca2);
				assertEquals("Test if arrayList equals to 1?", 1, categoryList.size());
				assertSame("Test that cca deleted same as 2nd item of the list?", cca2, ccaList.get(1));
				}
		
    	// Test for retrieve parent
			@Test
			public void testRetrieveParent() {
				
				assertNotNull("Test if there is a valid parent array to add", parentsList);
				String viewAllStudent = C206_CaseStudy.viewAllStudent(parentsList);
				String output = "";
				Object viewAllParent;
				assertSame("ViewAllParentsList", output, viewAllParent);
				
				C206_CaseStudy.addParent(parentsList, s1);
				assertEquals("Test if arrayList size is equal to 1?", 1, parentsList.size());
				
				viewAllStudent = C206_CaseStudy.viewAllParent(parentsList);
				
				output = String.format("%-15s %-15s %-15s %-15s\n", "Nicole", 1, "4A", "Miss Lim", "Alice", "Alice@gmail.com", 88172121);
				
				output += String.format("%-15s %-15s %-15s %-15s\n", "Michael", 4, "5B", "Mr gan", "Lee", "Lee@yahoo.com", 92218181);
	
			}
			
	  // Test for add student CCA 
			
		
			
			public void testAddStudentToCCA() {
				
				assertNotNull("Test to add student to CCA in the arrayList", studentsList);
				
				C206_CaseStudy.addStudent(studentsList, s1);
				assertEquals("Test if arrayList equals to 1?", 1, studentsList.size());
				assertSame("Test that student is added same as 1st item of the list?", s1, studentsList.get(0));
				
				C206_CaseStudy.addStudent(studentsList, s2);
				assertEquals("Test if arrayList equals to 2?", 2, studentsList.size());
				assertSame("Test that student is added same as 2nd item of the list?", s2, studentsList.get(1));
				}
			
	  
			
		// Test for view all students registered for a CCA
			@Test
				public void testViewAllStudents() {
				assertNotNull("Test if there is a valid student array to add", studentsList);
				String viewAllStudent = C206_CaseStudy.viewAllStudent(studentsList);
				String output = "";
				assertSame("ViewAllStudentlist", output, viewAllStudent);
				
				C206_CaseStudy.addStudent(studentsList, s1);
				assertEquals("Test if arrayList size is equal to 1?", 1, studentsList.size());
				
				viewAllStudent = C206_CaseStudy.viewAllStudent(studentsList);
				
				output = String.format("%-15s %-15s %-15s %-15s\n", "Timothy Tan", "11111", "4D", "Theresa Jiang");
				
				output += String.format("%-15s %-15s %-15s %-15s\n", "Jason Lim", "22222", "3A", "Jennifer Tan");

			}
			
		
			@After
		public void tearDown() throws Exception {
			cca1 = null;
			cca2 = null;
			c1 = null;
			c2 = null;
			p1 = null;
			p2 = null;
			s1 = null;
			s2 = null;
			ccaList = null;
			categoryList = null;
			parentsList = null;
			studentsList = null;

		}
	
}
