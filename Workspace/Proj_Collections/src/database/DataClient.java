/**
 * 
 */
package database;

import java.io.File;
import java.io.IOException;

import college.Major;
import college.Rank;
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
		/**
		 * test student
		 */
		Student s1 = new Student.Builder().setName("Student1 testLast").setAge(24).setMajor(Major.COMPUTERSCIENCE).setRank(Rank.FRESHMAN).setGPA(3.8).build();

		/**
		 * The file to read "College.txt"
		 */		
		File file = new File(
				"C:" 	  	+ File.separator + 
				"Users" 	+ File.separator + 
				"E" 		+ File.separator + 
				"Desktop" 	+ File.separator + 
				"College.txt");
		
		DataStorage input = new DataStorage(file);
		ArrayList<Student> database = input.read();
		
		/**********************************************************************************************/

		/**
		 * The file for students on probation
		 */
		File file2 = new File(
				"C:" 	  	+ File.separator + 
				"Users" 	+ File.separator + 
				"E" 		+ File.separator + 
				"Desktop" 	+ File.separator + 
				"onProbation.txt");
		
		/**
		 * write information about students on probation to onProbation.txt 
		 */
		ArrayList<Student> probation = new ArrayList<Student>();
		for (int i = 0; i < database.size(); i++) {
			if(database.get(i).isOnProbation()) {
				probation.add(database.get(i));
			}
		}
		
		DataStorage onProbation = new DataStorage(file2);
		onProbation.write(probation);

		/**
		 * The file for students on deans list
		 */
		File file3 = new File(
				"C:" 	  	+ File.separator + 
				"Users" 	+ File.separator + 
				"E" 		+ File.separator + 
				"Desktop" 	+ File.separator + 
				"deansList.txt");
		
		/**
		 * write information about students on deans list to deansList.txt
		 */
		ArrayList<Student> deans = new ArrayList<Student>();
		for (int i = 0; i < database.size(); i++) {
			if(database.get(i).isOnDeansList()) {
				deans.add(database.get(i));
			}
		}
		
		DataStorage deansList = new DataStorage(file3);
		deansList.write(deans);
		
		/**
		 * The file for students on under 25
		 */
		File file4 = new File(
				"C:" 	  	+ File.separator + 
				"Users" 	+ File.separator + 
				"E" 		+ File.separator + 
				"Desktop" 	+ File.separator + 
				"under25.txt");
		
		/**
		 * write information about students on under 25 to under25.txt
		 */
		ArrayList<Student> under25 = new ArrayList<Student>(30);
		for (int i = 0; i < database.size(); i++) {
			if(database.get(i).getAge() < 25) {
				under25.add(database.get(i));
			}
		}
		
		DataStorage u25 = new DataStorage(file4);
		u25.write(under25);
		
		/**********************************************************************************************/
		
		/**
		 * The file for students on over 30
		 */
		File file5 = new File(
				"C:" 	  	+ File.separator + 
				"Users" 	+ File.separator + 
				"E" 		+ File.separator + 
				"Desktop" 	+ File.separator + 
				"over30.txt");
		
		/**
		 * write information about students on over 30 to over30.txt
		 */
		ArrayList<Student> over30 = new ArrayList<Student>(30);
		for (int i = 0; i < database.size(); i++) {
			if(database.get(i).getAge() > 30) {
				over30.add(database.get(i));
			}
		}
		
		DataStorage o30 = new DataStorage(file5);
		o30.write(over30);
		
		/**********************************************************************************************/

		/**
		 * The file for specifically searched for students using indexOf, a linear search
		 */
		File file6 = new File(
				"C:" 	  	+ File.separator + 
				"Users" 	+ File.separator + 
				"E" 		+ File.separator + 
				"Desktop" 	+ File.separator + 
				"searchFile.txt");
		
		/**
		 * write information about 3 students, one at the beginning, one in the middle, and one at the end to searchFile.txt
		 */
		ArrayList<Student> studentFound = new ArrayList<Student>(3);
		int index = Query.indexOf(database, "Virginia Alcott");
		if (index != -1) {
			studentFound.add(database.get(index));
		}
		
		index 	  = Query.indexOf(database, "Wilbur Grant");
		if (index != -1) {
			studentFound.add(database.get(index));
		}
		
		index 	  = Query.indexOf(database, "Michael Nyguen");
		if (index != -1) {
			studentFound.add(database.get(index));
		}		
		
		DataStorage searchFile = new DataStorage(file6);
		searchFile.write(studentFound);
		
		/**********************************************************************************************/

		/**
		 * The file for information about students sorted by first name
		 */
		File file7 = new File(
				"C:" 	  	+ File.separator + 
				"Users" 	+ File.separator + 
				"E" 		+ File.separator + 
				"Desktop" 	+ File.separator + 
				"bubbleFirstName.txt");
		
		/**
		 * write information about students sorted by first name to byFirstName.txt
		 */
		Query.bubbleSort(database, Student::compareByFirstName);
		DataStorage byFirstName = new DataStorage(file7);
		byFirstName.write(database); //jennergert
		
		/**********************************************************************************************/

		/**
		 * The file for information about students sorted by age
		 */
		File file8 = new File(
				"C:" 	  	+ File.separator + 
				"Users" 	+ File.separator + 
				"E" 		+ File.separator + 
				"Desktop" 	+ File.separator + 
				"bubbleAge.txt");
		
		/**
		 * write information about students sorted by age to byAge.txt
		 */
		Query.bubbleSort(database, Student::compareByAge);
		DataStorage byAge = new DataStorage(file8);
		byAge.write(database); //jennergert
		
		/**********************************************************************************************/

		/**
		 * The file for information about students sorted by GPA
		 */
		File file9 = new File(
				"C:" 	  	+ File.separator + 
				"Users" 	+ File.separator + 
				"E" 		+ File.separator + 
				"Desktop" 	+ File.separator + 
				"bubbleGPA.txt");
		
		/**
		 * write information about students sorted by GPA to byGPA.txt
		 */
		Query.bubbleSort(database, Student::compareByGPA);
		DataStorage byGPA = new DataStorage(file9);
		byGPA.write(database); //jennergert
		
		/**********************************************************************************************/
		
		/**
		 * The file for information about students sorted by last name
		 */
		File file10 = new File(
				"C:" 	  	+ File.separator + 
				"Users" 	+ File.separator + 
				"E" 		+ File.separator + 
				"Desktop" 	+ File.separator + 
				"quickSortLastName.txt");

		/**
		 * write information about students sorted by last name to byLastName.txt
		 */
		Query.quickSort(database, 0, database.size() - 1);
		DataStorage byLastName = new DataStorage(file10);
		byLastName.write(database); //jennergert

	}

}
