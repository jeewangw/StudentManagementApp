import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.student.manage.Student;
import com.student.manage.StudentDao;

public class Start {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Welcome to Studnet Management App");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			System.out.println("PRESS 1 TO ADD STUDENTS");
			System.out.println("PRESS 2 TO DELETE STUDENTS");
			System.out.println("PRESS 3 TO DISPLAY STUDENTS");
			System.out.println("PRESS 4 TO UPDATE STUDENTS");
			System.out.println("PRESS 5 TO EXIT");
			
			int c = Integer.parseInt(br.readLine());
			
			if (c == 1) {
				
				//add students
				System.out.println("Enter Student Name");
				String name = br.readLine();
				
				System.out.println("Enter Student Phone");
				String phone = br.readLine();
				
				System.out.println("Enter Student City");
				String city = br.readLine();
				
				//Create Student Object to Store Student
				Student st = new Student(name, phone, city);
				boolean answer = StudentDao.insertStudentToDB(st);
				if (answer) {
					System.out.println("Successfully added!");
				}
				System.out.println(st);
				
			} else if (c == 2) {
				
				//delete students
				System.out.println("Enter Student ID to delete");
				int userID = Integer.parseInt(br.readLine());
				boolean f = StudentDao.deleteStudent(userID);
				
				if (f) {
					System.out.println("Successfully deleted");
				}
				
			} else if (c == 3) {
				
				//display students
				StudentDao.showAllStudent();
				
			}else if (c == 4){
				
				//update students

				System.out.println("Enter Student ID to update");
				int userID = Integer.parseInt(br.readLine());
				
				System.out.println("Enter  Updated Student Name");
				String name = br.readLine();
				
				System.out.println("Enter Updated Student Phone");
				String phone = br.readLine();
				
				System.out.println("Enter Updated Student City");
				String city = br.readLine();
				
				//Create Student Object to Store Student
				Student st = new Student(userID, name, phone, city);
				
				boolean f = StudentDao.updateStudent(st);
				
				if (f) {
					System.out.println("Successfully Updated!");
				}
				
			} else if (c == 5 ) {
				break;
				
			} else {
				
			}
			
		}
		System.out.println("Exiting.....");

	}

}
