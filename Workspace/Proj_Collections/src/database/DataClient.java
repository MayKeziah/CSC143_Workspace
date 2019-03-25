/**
 * 
 */
package database;

import java.io.File;
import java.io.IOException;


import college.Student;
import lists.ArrayList;
import utility.Query;

/**
 * @author E
 *
 */
public class DataClient {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
//		Student s1 = new Student(new Student.Builder().setName("Student1").setAge(24).setMajor(Major.COMPUTERSCIENCE).setRank(Rank.FRESHMAN).setGPA(3.8));
//		System.out.println(s1.toString());
//		System.out.println(s1.toFile());
		
		System.out.println();
		
		File file = new File(
				"C:" 	  	+ File.separator + 
				"Users" 	+ File.separator + 
				"E" 		+ File.separator + 
				"Desktop" 	+ File.separator + 
				"College.txt");
		DataStorage input = new DataStorage(file);
		ArrayList<Student> database = input.read();
		System.out.println(database.toFile());
//		Query.quickSort(database, 0, database.size() - 1);
		Query.bubbleSort(database, Student::compareByGPA);
		System.out.println("----------------------------------------");
		System.out.println(database.toFile());

	}

}
