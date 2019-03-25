/**
 * 
 */
package database;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

import college.Major;
import college.Rank;
import college.Student;
import college.Student.Builder;
import lists.ArrayList;

/**
 * @author E
 *
 */
public class DataStorage {
	private File file;
	
	/**
	 * @param filePath the file path of the file to use
	 * @throws IOException 
	 */
	public DataStorage(String filePath) throws IOException {
		this(new File(filePath));
	}
	
	/**
	 * @param file the file to use
	 * @throws IOException 
	 */
	public DataStorage(File file) throws IOException {
		setFile(file);
	}
	
	/**
	 * Takes a comma separated line and parses it for information about a Student. 
	 * @param line the line to parse
	 * @return the student represented by the line given
	 * @throws IllegalArgumentException for invalid Rank, Major, or GPA range.
	 * @throws NumberFormatException for age's that are not integers and GPA's that are not real numbers.
	 */
	public static Student parse(String line) throws IllegalArgumentException, NumberFormatException {
		Builder builder = new Builder(); //Builds a student object to return
		String[] info = line.split(",");
		
		/**
		 * Set the student's name
		 */
		String name = info[0];
		builder.setName(name);
		
		/**
		 * if valid, set the student's age
		 */
		try {
			int age = Integer.parseInt(info[1]);
			builder.setAge(age);
		}catch(NumberFormatException e) {
			throw new NumberFormatException("Invalid age input for: " + line);
		}
		
		/**
		 * if valid, set the student's Rank
		 */
		try {
			Rank rank = Rank.valueOf(info[2]);
			builder.setRank(rank);
		}catch(IllegalArgumentException e) {
			throw new IllegalArgumentException("Invalid Rank input for: " + line);
		}
		
		/**
		 * if valid, set the student's Major
		 */
		try {
			Major major = Major.valueOf(info[3]);
			builder.setMajor(major);
		}catch(IllegalArgumentException e) {
			throw new IllegalArgumentException("Invalid Major input for: " + line);
		}
		
		/**
		 * if valid, set the student's GPA
		 */
		try {
			Double GPA = Double.parseDouble(info[4]);
			if (GPA > 4.0 || GPA < 0.0) {
				throw new IllegalArgumentException("Invalid GPA input. Must be less than 4.0 and positive: " + line);
			}
			builder.setGPA(GPA);
		}catch(NumberFormatException e) {
			throw new NumberFormatException("Invalid GPA input for: " + line);
		}
		
		/**
		 * return the student generated from the string of information.
		 */
		return builder.build();
	}
	
	/**
	 * Reads this file and returns a database containing information about the students listed in the file.
	 * This method does not add duplicates
	 * Format must be as follows: (case is irrelevant)
	 * <br> "FULL NAME,AGE,RANK,MAJOR,GPA"
	 * 
	 * 
	 * 
	 * @return the Student database generated from this file
	 * @throws fileNotFoundException
	 */
	public ArrayList<Student> read() throws FileNotFoundException{
		Scanner input 				= new Scanner(file); // The file reader
		ArrayList<Student> database = new ArrayList<Student>(); // The database to generate and return.
		Student next; // The next student to add
		
		/**
		 * Create a student from each line and add them to the database. Does not allow duplicates.
		 * */
		while(input.hasNextLine()) {
			next = parse(input.nextLine());
			if(!database.contains(next)) {
				database.add(next); 
			}
		}
		input.close();
		
		return database;
	}
	
	/**
	 * if the given file is valid, it stores it in this object.
	 * 
	 * @param file the file to set
	 * @throws IOException 
	 */
	public void setFile(File file) throws IOException {
		if(file.exists()) {
			this.file = file;
		}else {
			throw new IOException("Invalid File path: " + file.getPath() + ".");
		}
	}
	
	/**
	 * Writes information about each student in the given database to the saved file. 
	 * The information will be comma-separated such that it could be read by this class's 
	 * read method.
	 * 
	 * @param file the file to set
	 * @throws IOException 
	 */
	public void write(ArrayList<Student> data) throws IOException{
		PrintStream writer = new PrintStream(file);
		for (int i = 0; i < data.size(); i++) {
			writer.println(data.get(i).toString());
			writer.println();
		}
		
		writer.close();
	}
	
	/**
	 * Writes information about each student in the given database to the saved file. 
	 * The information will be neatly formatted such that it could be read a user.
	 * 
	 * @param file the file to set
	 * @throws IOException 
	 */
	public void writeCS(ArrayList<Student> data) throws IOException{
		PrintStream writer = new PrintStream(file);
		for (int i = 0; i < data.size(); i++) {
			writer.println(data.get(i).toFile());
		}
		
		writer.close();
	}
}
