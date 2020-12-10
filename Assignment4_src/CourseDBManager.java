import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class CourseDBManager implements CourseDBManagerInterface {

    CourseDBStructure structure = new CourseDBStructure(20);

	@Override
	public void add(String id, int crn, int credits, String roomNum, String instructor) {
		CourseDBElement element = new CourseDBElement(id, crn, credits, roomNum, instructor);
        structure.add(element);
	}

	@Override
	public CourseDBElement get(int crn) {
		try {
			return structure.get(crn);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("resource")
	@Override
	public void readFile(File input) throws FileNotFoundException {
		 Scanner file;
	        try {
	            file = new Scanner(input);
	        } catch (FileNotFoundException e){
	            throw new FileNotFoundException("File not found");
	        }
	        
	        structure = new CourseDBStructure(100);

	        do {
	        	Scanner scanner = new Scanner(file.nextLine());
	            String courseId = scanner.next();
	            int CRN = scanner.nextInt();
	            int numberOfCredits = scanner.nextInt();
	            String roomNumber = scanner.next();
	            String instructorName = "";
	            while (scanner.hasNext()){
	                instructorName += scanner.next()+ " ";
	            }
	            CourseDBElement element = new CourseDBElement(courseId, CRN, numberOfCredits, roomNumber, instructorName);
	            structure.add(element);
	        }while(file.hasNextLine());
	        file.close();
	}

	@Override
	public ArrayList<String> showAll() {
		ArrayList<String> arraylist = new ArrayList<String>();
		for (LinkedList<CourseDBElement> list : structure.hashTable) {
			if(list != null) {
				for (int i = 0; i < list.size(); i++) {
					String course = list.get(i).toString();
					arraylist.add(course);
				}
			}
		}
		return arraylist;
	}
	
}