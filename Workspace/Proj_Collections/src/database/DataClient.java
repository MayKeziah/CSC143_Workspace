/**
 * 
 */
package database;

import college.Major;
import college.Rank;
import college.Student;

/**
 * @author E
 *
 */
public class DataClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Student s1 = new Student(new Student.Builder().setName("Student1").setAge(24).setMajor(Major.COMPUTERSCIENCE).setRank(Rank.FRESHMAN).setGPA(3.8));
		System.out.println(s1.toString());
		System.out.println(s1.toFile());
	}

}
